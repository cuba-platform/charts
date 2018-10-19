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
import com.haulmont.cuba.gui.export.ExportDisplay;

import java.util.Set;

import static com.haulmont.charts.gui.pivottable.model.Renderer.*;

public class WebPivotTableExtension implements PivotTableExtension {

    public static final Set<Renderer> supportedRenderers = Sets.newHashSet(
            TABLE, TABLE_BAR_CHART, HEATMAP, ROW_HEATMAP, COL_HEATMAP);

    protected CubaPivotTableExtension pivotTableExtension;

    protected String fileName;

    protected PivotExcelExporter excelExporter;

    protected PivotTable pivotTable;

    public WebPivotTableExtension(PivotTable pivotTable) {
        this.pivotTable = pivotTable;
        excelExporter = AppBeans.getPrototype(PivotExcelExporter.NAME, pivotTable);

        CubaPivotTable cubaPivotTable = pivotTable.unwrap(CubaPivotTable.class);
        pivotTableExtension = new CubaPivotTableExtension(cubaPivotTable);
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
        String json = pivotTable.getNativeJson();
        Boolean editable = PivotNativeJsonUtils.isEditable(json);

        if (!Boolean.FALSE.equals(editable)) {
            Renderer currentRenderer = pivotTableExtension.getCurrentRenderer();

            if (currentRenderer != null) {
                checkRenderer(currentRenderer);
            } else if (pivotTable.getRenderers() != null) {
                Renderer defaultRenderer = pivotTable.getRenderers().getDefaultRenderer();
                if (defaultRenderer != null) {
                    checkRenderer(defaultRenderer);
                }
            }
        }

        if ((editable == null && !pivotTable.isEditable()) || Boolean.FALSE.equals(editable)) {
            String rendererId = PivotNativeJsonUtils.getRenderer(json);

            if (rendererId != null) {
                if (Renderer.fromId(rendererId) != null) { // check render in native json
                    checkRenderer(Renderer.fromId(rendererId));
                }
            } else if (pivotTable.getRenderer() != null) { // check in server configuration
                checkRenderer(pivotTable.getRenderer());
            }
        }
    }

    protected void checkRenderer(Renderer renderer) {
        if (!supportedRenderers.contains(renderer)) {
            throw new IllegalStateException(String.format("'%s' renderer is not supported for data export", renderer.name()));
        }
    }
}