/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.pivottable;

import com.google.common.collect.Sets;
import com.haulmont.charts.gui.components.pivot.PivotTable;
import com.haulmont.charts.gui.components.pivot.PivotTableExtension;
import com.haulmont.charts.gui.pivottable.extentsion.model.PivotData;
import com.haulmont.charts.gui.pivottable.model.Renderer;
import com.haulmont.charts.web.widgets.pivottable.CubaPivotTable;
import com.haulmont.charts.web.widgets.pivottable.CubaPivotTableExtension;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.export.ExportDisplay;

import java.util.Set;

import static com.haulmont.charts.gui.pivottable.model.Renderer.*;

public class WebPivotTableExtension implements PivotTableExtension {

    public static final Set<Renderer> supportedRenderers = Sets.newHashSet(
            TABLE, TABLE_BAR_CHART, HEATMAP, ROW_HEATMAP, COL_HEATMAP);

    protected CubaPivotTableExtension pivotTableExtension;

    protected String fileName;

    protected PivotExcelExporter excelExporter;

    protected Messages messages;

    protected PivotTable pivotTable;

    public WebPivotTableExtension(PivotTable pivotTable) {
        this.pivotTable = pivotTable;

        CubaPivotTable cubaPivotTable = pivotTable.unwrap(CubaPivotTable.class);
        pivotTableExtension = new CubaPivotTableExtension(cubaPivotTable);
        excelExporter = new PivotExcelExporter(pivotTable);

        messages = AppBeans.get(Messages.NAME);
    }

    @Override
    public void exportTableToXls() {
        checkSupportedRenderer();

        excelExporter.exportPivotTable(pivotTableExtension.getPivotData(), fileName);
    }

    @Override
    public void exportTableToXls(ExportDisplay display) {
        checkSupportedRenderer();

        excelExporter.exportPivotTable(pivotTableExtension.getPivotData(), fileName, display);
    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public String getPivotDataJSON() {
        return pivotTableExtension.getPivotDataJSON();
    }

    @Override
    public PivotData getPivotData() {
        return pivotTableExtension.getPivotData();
    }

    protected void checkSupportedRenderer() {
        Renderer currentRenderer = pivotTableExtension.getCurrentRenderer() == null ?
                pivotTable.getRenderers().getDefaultRenderer() : pivotTableExtension.getCurrentRenderer();

        if (!supportedRenderers.contains(currentRenderer)) {
            throw new IllegalStateException(messages.getMainMessage("pivottable.extension.notSupportedRenderer"));
        }
    }
}