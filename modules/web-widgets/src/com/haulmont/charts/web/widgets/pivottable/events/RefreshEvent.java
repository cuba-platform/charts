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

package com.haulmont.charts.web.widgets.pivottable.events;

import com.haulmont.charts.gui.pivottable.model.Aggregation;
import com.haulmont.charts.gui.pivottable.model.ColumnOrder;
import com.haulmont.charts.gui.pivottable.model.Renderer;
import com.haulmont.charts.gui.pivottable.model.RowOrder;
import com.haulmont.charts.web.widgets.pivottable.CubaPivotTable;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class RefreshEvent extends com.vaadin.ui.Component.Event {

    private static final long serialVersionUID = -5007279701639243292L;

    protected List<String> rows;
    protected List<String> cols;
    protected Renderer renderer;
    protected Aggregation aggregation;
    protected List<String> aggregationProperties;
    protected Map<String, List<String>> inclusions;
    protected Map<String, List<String>> exclusions;
    protected ColumnOrder columnOrder;
    protected RowOrder rowOrder;

    public RefreshEvent(CubaPivotTable source,
                        List<String> rows, List<String> cols, Renderer renderer,
                        Aggregation aggregation, List<String> aggregationProperties,
                        Map<String, List<String>> inclusions, Map<String, List<String>> exclusions,
                        ColumnOrder columnOrder, RowOrder rowOrder) {
        super(source);
        this.rows = rows;
        this.cols = cols;
        this.renderer = renderer;
        this.aggregation = aggregation;
        this.aggregationProperties = aggregationProperties;
        this.inclusions = inclusions;
        this.exclusions = exclusions;
        this.columnOrder = columnOrder;
        this.rowOrder = rowOrder;
    }

    public List<String> getRows() {
        return rows;
    }

    public List<String> getCols() {
        return cols;
    }

    @Nullable
    public Renderer getRenderer() {
        return renderer;
    }

    @Nullable
    public Aggregation getAggregation() {
        return aggregation;
    }

    public List<String> getAggregationProperties() {
        return aggregationProperties;
    }

    public Map<String, List<String>> getInclusions() {
        return inclusions;
    }

    public Map<String, List<String>> getExclusions() {
        return exclusions;
    }

    public ColumnOrder getColumnOrder() {
        return columnOrder;
    }

    public RowOrder getRowOrder() {
        return rowOrder;
    }
}
