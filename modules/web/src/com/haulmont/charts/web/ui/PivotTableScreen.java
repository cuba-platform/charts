/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.ui;

import com.haulmont.charts.gui.components.pivot.PivotTable;
import com.haulmont.charts.gui.components.pivot.PivotTableExtension;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.web.gui.components.pivottable.WebPivotTableExtension;
import com.haulmont.cuba.gui.WindowParam;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class PivotTableScreen extends AbstractWindow {

    public static final String DATA_ITEMS = "dataItems";
    public static final String PROPERTIES = "properties";
    public static final String NATIVE_JSON = "nativeJson";

    protected PivotTableExtension pivotTableExtension;

    @Inject
    protected PivotTable pivotTable;

    @WindowParam(name = DATA_ITEMS)
    protected List<DataItem> dataItems;

    @WindowParam(name = PROPERTIES, required = true)
    protected Map<String, String> properties;

    @WindowParam(name = NATIVE_JSON)
    protected String nativeJson;

    @Override
    public void init(Map<String, Object> params) {
        if (dataItems != null) {
            for (DataItem dataItem : dataItems) {
                pivotTable.addData(dataItem);
            }
        }

        for (Map.Entry<String, String> entry : properties.entrySet()) {
            pivotTable.addProperty(entry.getKey(), entry.getValue());
        }

        if (nativeJson != null) {
            pivotTable.setNativeJson(nativeJson);
        }

        pivotTableExtension = new WebPivotTableExtension(pivotTable);
    }

    public void exportExcel() {
        pivotTableExtension.exportTableToXls();
    }
}