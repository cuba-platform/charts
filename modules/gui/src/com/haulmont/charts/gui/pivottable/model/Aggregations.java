/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Configuration of aggregations. Use when {@link PivotTableModel#editable} is set to {@code true}.
 */
public class Aggregations extends AbstractPivotObject {
    private static final long serialVersionUID = 5569146922427717821L;

    /**
     * A list which will be converted to a dictionary of generators
     * for aggregation functions in dropdown menu.
     */
    private List<Aggregation> aggregations;

    /**
     * One of predefined aggregations, which name will be
     * converted to {@code aggregatorName} - an aggregator to
     * prepopulate in dropdown i.e. key to {@code aggregators} object.
     */
    private AggregationMode defaultAggregation;

    public List<Aggregation> getAggregations() {
        return aggregations;
    }

    public Aggregations setAggregations(List<Aggregation> aggregations) {
        this.aggregations = aggregations;
        return this;
    }

    public Aggregations addAggregations(Aggregation... aggregations) {
        if (aggregations != null) {
            if (this.aggregations == null) {
                this.aggregations = new ArrayList<>();
            }
            this.aggregations.addAll(Arrays.asList(aggregations));
        }
        return this;
    }

    public AggregationMode getDefaultAggregation() {
        return defaultAggregation;
    }

    public Aggregations setDefaultAggregation(AggregationMode defaultAggregation) {
        this.defaultAggregation = defaultAggregation;
        return this;
    }
}
