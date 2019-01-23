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

package com.haulmont.charts.gui.pivottable.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Configuration of aggregations. Use when {@link PivotTableModel#editable} is set to {@code true}.
 */
public class Aggregations extends AbstractPivotObject {
    private static final long serialVersionUID = 5569146922427717821L;

    private List<Aggregation> aggregations;

    private AggregationMode selectedAggregation;

    /**
     * @return a list which will be converted to a dictionary
     * of generators for aggregation functions in dropdown menu
     */
    public List<Aggregation> getAggregations() {
        return aggregations;
    }

    /**
     * Sets a list which will be converted to a dictionary of
     * generators for aggregation functions in dropdown menu.
     *
     * @param aggregations a list which will be converted to a dictionary
     *                     of generators for aggregation functions in dropdown menu
     * @return a reference to this object
     */
    public Aggregations setAggregations(List<Aggregation> aggregations) {
        this.aggregations = aggregations;
        return this;
    }

    /**
     * Adds an array which will be converted to a dictionary of
     * generators for aggregation functions in dropdown menu.
     *
     * @param aggregations an array which will be converted to a dictionary
     *                     of generators for aggregation functions in dropdown menu
     * @return a reference to this object
     */
    public Aggregations addAggregations(Aggregation... aggregations) {
        if (aggregations != null) {
            if (this.aggregations == null) {
                this.aggregations = new ArrayList<>();
            }
            this.aggregations.addAll(Arrays.asList(aggregations));
        }
        return this;
    }

    /**
     * @return a selected aggregation
     */
    public AggregationMode getSelectedAggregation() {
        return selectedAggregation;
    }

    /**
     * Sets one of predefined aggregations, which name will be
     * converted to {@code aggregatorName} - an aggregator to
     * prepopulate in dropdown i.e. key to {@code aggregators} object.
     *
     * @param selectedAggregation an aggregation to set as a selected
     * @return a reference to this object
     */
    public Aggregations setSelectedAggregation(AggregationMode selectedAggregation) {
        this.selectedAggregation = selectedAggregation;
        return this;
    }

    /**
     * @return a selected aggregation
     * @deprecated use {@link #getSelectedAggregation()} instead
     */
    @Deprecated
    public AggregationMode getDefaultAggregation() {
        return getSelectedAggregation();
    }

    /**
     * Sets one of predefined aggregations, which name will be
     * converted to {@code aggregatorName} - an aggregator to
     * prepopulate in dropdown i.e. key to {@code aggregators} object.
     *
     * @param defaultAggregation an aggregation to set as a selected
     * @return a reference to this object
     * @deprecated user {@link #setSelectedAggregation(AggregationMode)} instead
     */
    @Deprecated
    public Aggregations setDefaultAggregation(AggregationMode defaultAggregation) {
        return setSelectedAggregation(defaultAggregation);
    }
}
