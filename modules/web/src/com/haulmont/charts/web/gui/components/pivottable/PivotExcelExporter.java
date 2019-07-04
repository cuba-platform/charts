/*
 * Copyright (c) 2008-2019 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.charts.web.gui.components.pivottable;

import com.haulmont.charts.gui.components.pivot.PivotTable;
import com.haulmont.charts.gui.data.HasMetaClass;
import com.haulmont.charts.gui.pivottable.extentsion.model.PivotData;
import com.haulmont.charts.gui.pivottable.extentsion.model.PivotDataCell;
import com.haulmont.charts.gui.pivottable.extentsion.model.PivotDataSeparatedCell;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.ComponentsHelper;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.Notifications.NotificationType;
import com.haulmont.cuba.gui.export.ByteArrayDataProvider;
import com.haulmont.cuba.gui.export.ExcelAutoColumnSizer;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
import com.haulmont.cuba.gui.screen.ScreenContext;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.haulmont.bali.util.Preconditions.checkNotNullArgument;

/**
 * Exports {@link PivotData} to XLS file.
 */
@Component(PivotExcelExporter.NAME)
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PivotExcelExporter {

    public static final String NAME = "charts_pivotExcelExporter";

    public static final int MAX_ROW_INDEX = 65535;

    /**
     * CAUTION Magic number! This multiplier is used for calculating column width. Without this multiplier all columns
     * in the file will be collapsed.
     */
    protected static final int COLUMN_WIDTH_MULTIPLIER = 48;

    public static final String DEFAULT_FILE_NAME = "pivotData";

    protected HSSFWorkbook wb;
    protected HSSFSheet sheet;

    protected HSSFFont stdFont;

    protected HSSFCellStyle cellLabelBoldStyle;

    protected HSSFCellStyle cellDateTimeStyle;
    protected HSSFCellStyle boldCellDateTimeStyle;

    protected HSSFCellStyle cellDateStyle;
    protected HSSFCellStyle boldCellDateStyle;

    protected HSSFCellStyle cellTimeStyle;
    protected HSSFCellStyle boldCellTimeStyle;

    protected String fileName;
    protected MetaClass entityMetaClass;

    protected Messages messages;
    protected ExportDisplay display;
    protected UserSessionSource userSessionSource;

    protected String dateTimeParseFormat;
    protected String dateParseFormat;
    protected String timeParseFormat;

    protected Notifications notifications;

    public PivotExcelExporter(PivotTable pivotTable) {
        entityMetaClass = pivotTable.getDataProvider() instanceof HasMetaClass ?
                ((HasMetaClass) pivotTable.getDataProvider()).getMetaClass() : null;

        initNotifications(pivotTable);
    }

    @Inject
    protected void setUserSessionSource(UserSessionSource userSessionSource) {
        this.userSessionSource = userSessionSource;
    }

    @Inject
    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    @Inject
    public void setExportDisplay(ExportDisplay display) {
        this.display = display;
    }

    protected void initNotifications(PivotTable pivotTable) {
        ScreenContext screenContext = ComponentsHelper.getScreenContext(pivotTable);
        notifications = screenContext.getNotifications();
    }

    /**
     * Export to Xls.
     *
     * @param pivotData pivot with aggregated data
     * @param fileName  file name
     */
    public void exportPivotTable(PivotData pivotData, String fileName) {
        checkNotNullArgument(pivotData);

        if (isPivotDataEmpty(pivotData)) {
            showNoDataWarning();
            return;
        }

        if (!isNullOrEmpty(fileName)) {
            this.fileName = fileName;
        } else if (entityMetaClass != null) {
            this.fileName = messages.getTools().getEntityCaption(entityMetaClass);
        } else {
            this.fileName = DEFAULT_FILE_NAME;
        }

        createWorkbookWithSheet();
        createCellsStyle();

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
        checkNotNullArgument(pivotData);

        if (isPivotDataEmpty(pivotData)) {
            showNoDataWarning();
            return;
        }

        if (display == null) {
            throw new IllegalArgumentException("ExportDisplay is null");
        }

        if (!isNullOrEmpty(fileName)) {
            this.fileName = fileName;
        } else if (entityMetaClass != null) {
            this.fileName = messages.getTools().getEntityCaption(entityMetaClass);
        } else {
            this.fileName = DEFAULT_FILE_NAME;
        }

        createWorkbookWithSheet();
        createCellsStyle();

        createRows(pivotData);

        if (isXlsMaxRowNumberExceeded(pivotData)) {
            showWarnNotification();
        }

        export(display);
    }

    protected void createRows(PivotData pivotData) {
        PivotDataExcelHelper excelUtils = new PivotDataExcelHelper(pivotData);
        List<List<PivotDataSeparatedCell>> dataRows = excelUtils.getRows();

        SimpleDateFormat dateTimeFormatter = null;
        if (!isNullOrEmpty(dateTimeParseFormat)) {
            dateTimeFormatter = new SimpleDateFormat(dateTimeParseFormat);
        }
        SimpleDateFormat dateFormatter = null;
        if (!isNullOrEmpty(dateParseFormat)) {
            dateFormatter = new SimpleDateFormat(dateParseFormat);
        }
        SimpleDateFormat timeFormatter = null;
        if (!isNullOrEmpty(timeParseFormat)) {
            timeFormatter = new SimpleDateFormat(timeParseFormat);
        }

        int columns = excelUtils.getOriginColumnsNumber();
        ExcelAutoColumnSizer[] sizers = columns != -1 ? new ExcelAutoColumnSizer[columns] : null;

        for (int i = 0; i < dataRows.size(); i++) {
            if (i > MAX_ROW_INDEX) {
                break;
            }

            HSSFRow hssfRow = sheet.createRow(i);
            List<PivotDataSeparatedCell> row = dataRows.get(i);
            for (PivotDataSeparatedCell cell : row) {
                HSSFCell hssfCell = hssfRow.createCell(cell.getIndexCol());

                PivotDataCell.Type type = cell.getType();
                switch (type) {
                    case NUMERIC:
                        hssfCell.setCellType(CellType.NUMERIC);
                        hssfCell.setCellValue(Double.parseDouble(cell.getValue()));
                        if (cell.isBold()) {
                            hssfCell.setCellStyle(cellLabelBoldStyle);
                        }
                        break;
                    case DATE_TIME:
                        initDateTimeCell(hssfCell, cell, dateTimeFormatter, cellDateTimeStyle, boldCellDateTimeStyle);
                        break;
                    case DATE:
                        initDateTimeCell(hssfCell, cell, dateFormatter, cellDateStyle, boldCellDateStyle);
                        break;
                    case TIME:
                        initDateTimeCell(hssfCell, cell, timeFormatter, cellTimeStyle, boldCellTimeStyle);
                        break;
                    case STRING:
                        hssfCell.setCellType(CellType.STRING);
                        hssfCell.setCellValue(cell.getValue());
                        if (cell.isBold()) {
                            hssfCell.setCellStyle(cellLabelBoldStyle);
                        }
                        break;
                }

                if (sizers != null) {
                    updateColumnSize(sizers, cell);
                }
            }
        }

        if (sizers != null) {
            for (int i = 0; i < sizers.length; i++) {
                sheet.setColumnWidth(i, sizers[i].getWidth() * COLUMN_WIDTH_MULTIPLIER);
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

    protected void updateColumnSize(ExcelAutoColumnSizer[] sizers, PivotDataSeparatedCell cell) {
        if (sizers[cell.getIndexCol()] == null) {
            ExcelAutoColumnSizer sizer = new ExcelAutoColumnSizer();
            sizers[cell.getIndexCol()] = sizer;
            sizers[cell.getIndexCol()].notifyCellValue(cell.getValue(), stdFont);
        }

        if (sizers[cell.getIndexCol()].isNotificationRequired(cell.getIndexRow())) {
            sizers[cell.getIndexCol()].notifyCellValue(cell.getValue(), stdFont);
        }
    }

    protected void initDateTimeCell(HSSFCell hssfCell, PivotDataSeparatedCell cell, SimpleDateFormat formatter,
                                    HSSFCellStyle cellStyle, HSSFCellStyle boldCellStyle) {
        if (formatter != null) {
            try {
                hssfCell.setCellValue(formatter.parse(cell.getValue()));
                if (cell.isBold()) {
                    hssfCell.setCellStyle(boldCellStyle);
                } else {
                    hssfCell.setCellStyle(cellStyle);
                }
                return;
            } catch (ParseException e) {
                // ignore because we set it as string
            }
        }
        // set as string
        hssfCell.setCellType(CellType.STRING);
        hssfCell.setCellValue(cell.getValue());
        if (cell.isBold()) {
            hssfCell.setCellStyle(cellLabelBoldStyle);
        }
    }

    protected void createWorkbookWithSheet() {
        wb = new HSSFWorkbook();
        sheet = wb.createSheet("Export");
    }

    protected void createCellsStyle() {
        HSSFFont boldFont = wb.createFont();
        boldFont.setBold(true);

        stdFont = wb.createFont();

        cellLabelBoldStyle = wb.createCellStyle();
        cellLabelBoldStyle.setFont(boldFont);

        cellDateTimeStyle = wb.createCellStyle();
        cellDateTimeStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));

        boldCellDateTimeStyle = wb.createCellStyle();
        boldCellDateTimeStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
        boldCellDateTimeStyle.setFont(boldFont);

        cellDateStyle = wb.createCellStyle();
        cellDateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));

        boldCellDateStyle = wb.createCellStyle();
        boldCellDateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
        boldCellDateStyle.setFont(boldFont);

        cellTimeStyle = wb.createCellStyle();
        cellTimeStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("h:mm"));

        boldCellTimeStyle = wb.createCellStyle();
        boldCellTimeStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("h:mm"));
        boldCellTimeStyle.setFont(boldFont);
    }

    protected void showWarnNotification() {
        notifications.create(NotificationType.WARNING)
                .withCaption(messages.getMainMessage("actions.warningExport.title"))
                .withDescription(messages.getMainMessage("actions.warningExport.message"))
                .withPosition(Notifications.Position.MIDDLE_CENTER)
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
        notifications.create(NotificationType.WARNING)
                .withCaption(messages.getMainMessage("warningNotification.caption"))
                .withPosition(Notifications.Position.MIDDLE_CENTER)
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

    /**
     * @return dateTime format or null
     */
    @Nullable
    public String getDateTimeParseFormat() {
        return dateTimeParseFormat;
    }

    /**
     * Sets dateTime format that will be used to finding dateTime value and exporting it to excel with dateTime type.
     *
     * @param dateTimeParseFormat dateTime format (e.g. dd/MM/yyyy HH:mm)
     */
    public void setDateTimeParseFormat(String dateTimeParseFormat) {
        this.dateTimeParseFormat = dateTimeParseFormat;
    }

    /**
     * @return date format or null
     */
    @Nullable
    public String getDateParseFormat() {
        return dateParseFormat;
    }

    /**
     * Sets date format that will be used to finding dateTime value and exporting it to excel with date type. If there
     * is no format set, date properties will be recognized as text value.
     *
     * @param dateParseFormat date format (e.g. dd/MM/yyyy)
     */
    public void setDateParseFormat(String dateParseFormat) {
        this.dateParseFormat = dateParseFormat;
    }

    /**
     * @return time format or null
     */
    @Nullable
    public String getTimeParseFormat() {
        return timeParseFormat;
    }

    /**
     * Sets date format that will be used to finding dateTime value and exporting it to excel with date type. If there
     * is no format set, time properties will be recognized as text value.
     *
     * @param timeParseFormat time format (e.g. HH:mm)
     */
    public void setTimeParseFormat(String timeParseFormat) {
        this.timeParseFormat = timeParseFormat;
    }
}