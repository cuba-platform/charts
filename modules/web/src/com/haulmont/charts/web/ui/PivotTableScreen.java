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

package com.haulmont.charts.web.ui;

import com.haulmont.charts.gui.components.pivot.PivotTable;
import com.haulmont.charts.gui.components.pivot.PivotTableExtension;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.web.gui.components.pivottable.WebPivotTableExtension;
import com.haulmont.cuba.gui.WindowParam;
import com.haulmont.cuba.gui.components.AbstractWindow;

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

        pivotTable.addProperties(properties);

        if (nativeJson != null) {
            pivotTable.setNativeJson(nativeJson);
        }

        pivotTableExtension = new WebPivotTableExtension(pivotTable);
    }

    public void exportExcel() {
        pivotTableExtension.exportTableToXls();
    }
}