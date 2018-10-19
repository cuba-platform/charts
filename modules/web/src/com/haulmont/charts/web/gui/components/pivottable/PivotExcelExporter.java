/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.pivottable;

import com.google.common.base.Strings;
import com.haulmont.bali.util.Preconditions;
import com.haulmont.charts.gui.components.pivot.PivotTable;
import com.haulmont.charts.gui.data.HasMetaClass;
import com.haulmont.charts.gui.pivottable.extentsion.model.PivotData;
import com.haulmont.charts.gui.pivottable.extentsion.model.PivotDataCell;
import com.haulmont.charts.gui.pivottable.extentsion.model.PivotDataSeparatedCell;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.export.ByteArrayDataProvider;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Exports {@link PivotData} to XLS.
 */
@Component(PivotExcelExporter.NAME)
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PivotExcelExporter {

    public static final String NAME = "charts_pivotExcelExporter";

    public static final int MAX_ROW_INDEX = 65535;

    public static final String DEFAULT_FILE_NAME = "pivotData";

    protected HSSFWorkbook wb;
    protected HSSFSheet sheet;
    protected HSSFCellStyle boldStyle;

    protected String fileName;
    protected MetaClass entityMetaClass;

    protected Messages messages;
    protected Notifications notifications;
    protected ExportDisplay display;

    public PivotExcelExporter(PivotTable pivotTable) {
        entityMetaClass = pivotTable.getDataProvider() instanceof HasMetaClass ?
                ((HasMetaClass) pivotTable.getDataProvider()).getMetaClass() : null;
    }

    @Inject
    public void setMessages(Messages messages){
        this.messages = messages;
    }

    @Inject
    public void setNotifications(Notifications notifications) {
        this.notifications = notifications;
    }

    @Inject
    public void setExportDisplay(ExportDisplay display) {
        this.display = display;
    }

    /**
     * Export to Xls.
     *
     * @param pivotData pivot with aggregated data
     * @param fileName  file name
     */
    public void exportPivotTable(PivotData pivotData, String fileName) {
        Preconditions.checkNotNullArgument(pivotData);

        if (isPivotDataEmpty(pivotData)) {
            showNoDataWarning();
            return;
        }

        if (!Strings.isNullOrEmpty(fileName)) {
            this.fileName = fileName;
        } else if (entityMetaClass != null) {
            this.fileName = messages.getTools().getEntityCaption(entityMetaClass);
        } else {
            this.fileName = DEFAULT_FILE_NAME;
        }

        createWorkbookWithSheet();
        createCellStyle();

        createRows(pivotData);

        if (isXlsMaxRowNumberExceeded(pivotData)) {
            showWarnNotification();
        }

        export(display);
    }

    /**
     * Export to Xls.
     *
     * @param pivotData pivot with aggregated data
     * @param fileName  file name
     * @param display   ExportDisplay implementation
     */
    public void exportPivotTable(PivotData pivotData, String fileName, ExportDisplay display) {
        Preconditions.checkNotNullArgument(pivotData);

        if (isPivotDataEmpty(pivotData)) {
            showNoDataWarning();
            return;
        }

        if (display == null) {
            throw new IllegalArgumentException("ExportDisplay is null");
        }

        if (!Strings.isNullOrEmpty(fileName)) {
            this.fileName = fileName;
        } else if (entityMetaClass != null) {
            this.fileName = messages.getTools().getEntityCaption(entityMetaClass);
        } else {
            this.fileName = DEFAULT_FILE_NAME;
        }

        createWorkbookWithSheet();
        createCellStyle();

        createRows(pivotData);

        if (isXlsMaxRowNumberExceeded(pivotData)) {
            showWarnNotification();
        }

        export(display);
    }

    protected void createRows(PivotData pivotData) {
        PivotDataExcelHelper excelUtils = new PivotDataExcelHelper(pivotData);
        List<List<PivotDataSeparatedCell>> dataRows = excelUtils.getRows();

        for (int i = 0; i < dataRows.size(); i++) {
            if (i > MAX_ROW_INDEX) {
                break;
            }

            HSSFRow hssfRow = sheet.createRow(i);

            List<PivotDataSeparatedCell> row = dataRows.get(i);

            for (PivotDataSeparatedCell cell : row) {
                HSSFCell hssfCell = hssfRow.createCell(cell.getIndexCol());

                if (cell.getType().equals(PivotDataCell.Type.STRING)) {
                    hssfCell.setCellType(CellType.STRING);
                    hssfCell.setCellValue(cell.getValue());
                } else {
                    hssfCell.setCellType(CellType.NUMERIC);
                    hssfCell.setCellValue(Double.parseDouble(cell.getValue()));
                }

                if (cell.isBold()) {
                    hssfCell.setCellStyle(boldStyle);
                }
            }
        }

        for (String id : excelUtils.getCellIdsToMerged()) {
            int firstRow = excelUtils.getFirstRowById(id);
            int lastRow = excelUtils.getLastRowById(id);

            if (firstRow >= MAX_ROW_INDEX) {
                break;
            }

            if (lastRow > MAX_ROW_INDEX) {
                lastRow = MAX_ROW_INDEX;
            }

            CellRangeAddress rangeAddress = new CellRangeAddress(
                    firstRow,
                    lastRow,
                    excelUtils.getFirstColById(id),
                    excelUtils.getLastColById(id)
            );

            sheet.addMergedRegion(rangeAddress);
        }
    }

    protected void createWorkbookWithSheet() {
        wb = new HSSFWorkbook();
        sheet = wb.createSheet("Export");

    }

    protected void createCellStyle() {
        HSSFFont boldFont = wb.createFont();
        boldFont.setBold(true);

        boldStyle = wb.createCellStyle();
        boldStyle.setFont(boldFont);
    }

    protected void showWarnNotification() {
        notifications.create()
                .setCaption(messages.getMainMessage("actions.warningExport.title"))
                .setDescription(messages.getMainMessage("actions.warningExport.message"))
                .setType(Notifications.NotificationType.WARNING)
                .setPosition(Notifications.Position.MIDDLE_CENTER)
                .show();
    }

    protected void export(ExportDisplay display) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            wb.write(out);
        } catch (IOException e) {
            throw new RuntimeException("Unable to write document", e);
        }
        if (fileName == null) {
            fileName = DEFAULT_FILE_NAME;
        }

        display.show(new ByteArrayDataProvider(out.toByteArray()), fileName + ".xls", ExportFormat.XLS);
    }

    protected void showNoDataWarning() {
        notifications.create()
                .setCaption(messages.getMainMessage("warningNotification.caption"))
                .setType(Notifications.NotificationType.WARNING)
                .setPosition(Notifications.Position.MIDDLE_CENTER)
                .show();
    }

    protected boolean isPivotDataEmpty(PivotData pivotData) {
        return pivotData.getDataNumCols() == 0
                || pivotData.getDataNumRows() == 0;
    }


    /**
     * @param pivotData pivot with aggregated data
     * @return true if exported table contains more than 65536 records
     */
    public boolean isXlsMaxRowNumberExceeded(PivotData pivotData) {
        return MAX_ROW_INDEX < pivotData.getAllRows().size();
    }
}