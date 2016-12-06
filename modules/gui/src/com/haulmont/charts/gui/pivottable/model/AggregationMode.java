/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model;

/**
 * An enum with predefined aggregations.
 */
public enum AggregationMode implements PivotEnum {
    COUNT("count"),
    COUNT_UNIQUE_VALUES("countUniqueValues"),
    LIST_UNIQUE_VALUES("listUniqueValues"),
    SUM("sum"),
    INTEGER_SUM("integerSum"),
    AVERAGE("average"),
    MINIMUM("minimum"),
    MAXIMUM("maximum"),
    SUM_OVER_SUM("sumOverSum"),
    UPPER_BOUND_80("upperBound80"),
    LOWER_BOUND_80("lowerBound80"),
    SUM_AS_FRACTION_OF_TOTAL("sumAsFractionOfTotal"),
    SUM_AS_FRACTION_OF_ROWS("sumAsFractionOfRows"),
    SUM_AS_FRACTION_OF_COLUMNS("sumAsFractionOfColumns"),
    COUNT_AS_FRACTION_OF_TOTAL("countAsFractionOfTotal"),
    COUNT_AS_FRACTION_OF_ROWS("countAsFractionOfRows"),
    COUNT_AS_FRACTION_OF_COLUMNS("countAsFractionOfColumns");

    private String id;

    AggregationMode(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }
}
