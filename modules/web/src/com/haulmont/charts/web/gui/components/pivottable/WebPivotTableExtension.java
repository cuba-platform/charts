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

import com.google.common.collect.Sets;
import com.haulmont.charts.gui.components.pivot.PivotTable;
import com.haulmont.charts.gui.components.pivot.PivotTableExtension;
import com.haulmont.charts.gui.pivottable.extentsion.model.PivotData;
import com.haulmont.charts.gui.pivottable.model.Renderer;
import com.haulmont.charts.web.widgets.pivottable.CubaPivotTable;
import com.haulmont.charts.web.widgets.pivottable.CubaPivotTableExtension;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.gui.export.ExportDisplay;

import java.util.Collections;
import java.util.Set;

import static com.haulmont.charts.gui.pivottable.model.Renderer.*;

public class WebPivotTableExtension implements PivotTableExtension {

    public static final Set<Renderer> supportedRenderers = Collections.unmodifiableSet(Sets.newHashSet(
            TABLE, TABLE_BAR_CHART, HEATMAP, ROW_HEATMAP, COL_HEATMAP));

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

        setupParseFormats();

        excelExporter.exportPivotTable(pivotTableExtension.getPivotData(), fileName);
    }

    @Override
    public void exportTableToXls(ExportDisplay display) {
        checkSupportedRenderer();

        setupParseFormats();

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

    @Override
    public String getDateTimeParseFormat() {
        return pivotTableExtension.getDateTimeParseFormat();
    }

    @Override
    public void setDateTimeParseFormat(String dateTimeParseFormat) {
        pivotTableExtension.setDateTimeParseFormat(dateTimeParseFormat);
    }

    @Override
    public String getDateParseFormat() {
        return pivotTableExtension.getDateParseFormat();
    }

    @Override
    public void setDateParseFormat(String dateParseFormat) {
        pivotTableExtension.setDateParseFormat(dateParseFormat);
    }

    @Override
    public String getTimeParseFormat() {
        return pivotTableExtension.getTimeParseFormat();
    }

    @Override
    public void setTimeParseFormat(String timeParseFormat) {
        pivotTableExtension.setTimeParseFormat(timeParseFormat);
    }

    protected void setupParseFormats() {
        if (excelExporter != null) {
            excelExporter.setDateTimeParseFormat(getDateTimeParseFormat());
            excelExporter.setDateParseFormat(getDateParseFormat());
            excelExporter.setTimeParseFormat(getTimeParseFormat());
        }
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