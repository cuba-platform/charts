/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Constructor for an object which will aggregate results per cell
 * (see <a href="https://github.com/nicolaskruchten/pivottable/wiki/Aggregators">documentation</a>).
 */
public class Aggregation extends AbstractPivotObject {
    private static final long serialVersionUID = 8131812058171838527L;

    /**
     * One of predefined aggregations.
     * <p>
     * Applies only when {@code custom=false}.
     */
    private AggregationMode mode;

    /**
     * When {@link Aggregation} is set as {@link PivotTableModel#aggregation},
     * then {@code caption} will be converted to {@code aggregatorName} - the name of
     * the aggregator, used for display purposes in some renderers.
     * <p>
     * When {@link Aggregation} is added as one of {@link Aggregations#aggregations},
     * then {@code caption} will be converted to a key in dictionary of generators
     * for aggregation functions in dropdown menu.
     */
    private String caption;

    /**
     * Determines that a function defined in {@link #function} field must be used as the aggregation.
     */
    private Boolean custom;

    /**
     * A function which will aggregate results per cell
     * (see <a href="https://github.com/nicolaskruchten/pivottable/wiki/Aggregators">documentation</a>).
     * <p>
     * Applies only when {@code custom=true}.
     */
    private PivotJsFunction function;

    /**
     * A collection of property names to pass as parameters to selected aggregation.
     * <p>
     * Applies only when {@code custom=false}.
     */
    private List<String> properties;

    public AggregationMode getMode() {
        return mode;
    }

    public Aggregation setMode(AggregationMode mode) {
        this.mode = mode;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public Aggregation setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public Boolean getCustom() {
        return custom;
    }

    public Aggregation setCustom(Boolean custom) {
        this.custom = custom;
        return this;
    }

    public PivotJsFunction getFunction() {
        return function;
    }

    public Aggregation setFunction(PivotJsFunction function) {
        this.function = function;
        return this;
    }

    public List<String> getProperties() {
        return properties;
    }

    public Aggregation setProperties(List<String> properties) {
        this.properties = properties;
        return this;
    }

    public Aggregation addProperties(String... properties) {
        if (properties != null) {
            if (this.properties == null) {
                this.properties = new ArrayList<>();
            }
            this.properties.addAll(Arrays.asList(properties));
        }
        return this;
    }
}
