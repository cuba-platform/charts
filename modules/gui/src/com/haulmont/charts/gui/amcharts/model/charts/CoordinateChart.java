/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * See documentation for properties of AmCoordinateChart JS object.
 *
 * @author artamonov
 * @version $Id$
 */
@SuppressWarnings("unchecked")
public abstract class CoordinateChart<T extends CoordinateChart> extends AbstractChart<T>
        implements HasStartEffect<T>, HasColors<T> {

    private List<Color> colors;

    private List<Graph> graphs;

    private AnimationEffect startEffect;

    private Integer startDuration;

    private List<ValueAxis> valueAxes;

    public CoordinateChart(ChartType type) {
        super(type);
    }

    @Override
    public List<Color> getColors() {
        return colors;
    }

    @Override
    public T setColors(List<Color> colors) {
        this.colors = colors;
        return (T) this;
    }

    public T addColors(Color... colors) {
        if (colors != null) {
            if (this.colors == null) {
                this.colors = new ArrayList<>();
            }
            this.colors.addAll(Arrays.asList(colors));
        }
        return (T) this;
    }

    public List<Graph> getGraphs() {
        return graphs;
    }

    public T setGraphs(List<Graph> graphs) {
        this.graphs = graphs;
        return (T) this;
    }

    public T addGraphs(Graph... graphs) {
        if (graphs != null) {
            if (this.graphs == null) {
                this.graphs = new ArrayList<>();
            }
            this.graphs.addAll(Arrays.asList(graphs));
        }
        return (T) this;
    }

    @Override
    public AnimationEffect getStartEffect() {
        return startEffect;
    }

    @Override
    public T setStartEffect(AnimationEffect startEffect) {
        this.startEffect = startEffect;
        return (T) this;
    }

    @Override
    public Integer getStartDuration() {
        return startDuration;
    }

    @Override
    public T setStartDuration(Integer startDuration) {
        this.startDuration = startDuration;
        return (T) this;
    }

    public List<ValueAxis> getValueAxes() {
        return valueAxes;
    }

    public T setValueAxes(List<ValueAxis> valueAxes) {
        this.valueAxes = valueAxes;
        return (T) this;
    }

    public T addValueAxes(ValueAxis... valueAxes) {
        if (valueAxes != null) {
            if (this.valueAxes == null) {
                this.valueAxes = new ArrayList<>();
            }
            this.valueAxes.addAll(Arrays.asList(valueAxes));
        }
        return (T) this;
    }
}