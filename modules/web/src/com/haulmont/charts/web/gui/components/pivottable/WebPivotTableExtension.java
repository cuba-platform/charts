/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.pivottable;

import com.haulmont.charts.gui.components.pivot.PivotTable;
import com.haulmont.charts.gui.components.pivot.PivotTableExtension;
import com.haulmont.charts.gui.pivottable.extentsion.model.PivotData;
import com.haulmont.charts.web.toolkit.ui.pivottable.CubaPivotTableExtension;
import com.haulmont.cuba.gui.export.ExportDisplay;

public class WebPivotTableExtension implements PivotTableExtension {

    protected CubaPivotTableExtension pivotTableExtension;

    protected String fileName;

    protected PivotExcelExporter excelExporter ;

    public WebPivotTableExtension(PivotTable pivotTable) {
        pivotTableExtension = new CubaPivotTableExtension(pivotTable);
        excelExporter = new PivotExcelExporter(pivotTable);
    }

    @Override
    public void exportTableToXls() {
        excelExporter.exportPivotTable(pivotTableExtension.getPivotData(), fileName);
    }

    @Override
    public void exportTableToXls(ExportDisplay display) {
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
}