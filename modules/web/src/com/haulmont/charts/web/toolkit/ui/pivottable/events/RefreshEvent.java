/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.pivottable.events;

import com.haulmont.charts.gui.pivottable.model.Aggregation;
import com.haulmont.charts.gui.pivottable.model.ColumnOrder;
import com.haulmont.charts.gui.pivottable.model.Renderer;
import com.haulmont.charts.gui.pivottable.model.RowOrder;
import com.haulmont.charts.web.toolkit.ui.pivottable.CubaPivotTable;

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
