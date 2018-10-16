/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.charts.amcharts;

import com.google.common.base.Strings;
import com.haulmont.bali.events.Subscription;
import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.components.charts.CoordinateChart;

import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("unchecked")
public abstract class WebCoordinateChart<T extends CoordinateChart,
        M extends com.haulmont.charts.gui.amcharts.model.charts.CoordinateChart> extends WebChart<T, M> implements CoordinateChart<T> {

    protected com.haulmont.charts.web.widgets.amcharts.events.AxisZoomListener axisZoomHandler;

    protected com.haulmont.charts.web.widgets.amcharts.events.GraphClickListener graphClickHandler;

    protected com.haulmont.charts.web.widgets.amcharts.events.GraphItemClickListener graphItemClickHandler;

    protected com.haulmont.charts.web.widgets.amcharts.events.GraphItemRightClickListener graphItemRightClickHandler;

    @Override
    public List<Color> getColors() {
        return getModel().getColors();
    }

    @Override
    public T setColors(List list) {
        getModel().setColors(list);
        return (T) this;
    }

    @Override
    public T addColors(Color... colors) {
        getModel().addColors(colors);
        return (T) this;
    }

    @Override
    public List<Graph> getGraphs() {
        return getModel().getGraphs();
    }

    @Override
    public T setGraphs(List list) {
        getModel().setGraphs(list);
        return (T) this;
    }

    @Override
    public T addGraphs(Graph... graphs) {
        getModel().addGraphs(graphs);
        return (T) this;
    }

    @Override
    public AnimationEffect getStartEffect() {
        return getModel().getStartEffect();
    }

    @Override
    public T setStartEffect(AnimationEffect startEffect) {
        getModel().setStartEffect(startEffect);
        return (T) this;
    }

    @Override
    public Double getStartDuration() {
        return getModel().getStartDuration();
    }

    @Override
    public T setStartDuration(Double startDuration) {
        getModel().setStartDuration(startDuration);
        return (T) this;
    }

    @Override
    public List<ValueAxis> getValueAxes() {
        return getModel().getValueAxes();
    }

    @Override
    public T setValueAxes(List valueAxes) {
        getModel().setValueAxes(valueAxes);
        return (T) this;
    }

    @Override
    public T addValueAxes(ValueAxis... valueAxes) {
        getModel().addValueAxes(valueAxes);
        return (T) this;
    }

    @Override
    public List<Guide> getGuides() {
        return getModel().getGuides();
    }

    @Override
    public T setGuides(List list) {
        getModel().setGuides(list);
        return (T) this;
    }

    @Override
    public T addGuides(Guide... guides) {
        getModel().addGuides(guides);
        return (T) this;
    }

    @Override
    public Boolean getGridAboveGraphs() {
        return getModel().getGridAboveGraphs();
    }

    @Override
    public T setGridAboveGraphs(Boolean gridAboveGraphs) {
        getModel().setGridAboveGraphs(gridAboveGraphs);
        return (T) this;
    }

    @Override
    public Boolean getSequencedAnimation() {
        return getModel().getSequencedAnimation();
    }

    @Override
    public T setSequencedAnimation(Boolean sequencedAnimation) {
        getModel().setSequencedAnimation(sequencedAnimation);
        return (T) this;
    }

    @Override
    public Double getStartAlpha() {
        return getModel().getStartAlpha();
    }

    @Override
    public T setStartAlpha(Double startAlpha) {
        getModel().setStartAlpha(startAlpha);
        return (T) this;
    }

    @Override
    public String getUrlTarget() {
        return getModel().getUrlTarget();
    }

    @Override
    public T setUrlTarget(String urlTarget) {
        getModel().setUrlTarget(urlTarget);
        return (T) this;
    }

    @Override
    public void zoomOutValueAxes() {
        component.zoomOutValueAxes();
    }

    @Override
    public void zoomOutValueAxis(String id) {
        component.zoomOutValueAxis(id);
    }

    @Override
    public void zoomOutValueAxis(int index) {
        component.zoomOutValueAxis(index);
    }

    @Override
    public void zoomValueAxisToValues(String id, Object startValue, Object endValue) {
        component.zoomValueAxisToValues(id, startValue, endValue);
    }

    @Override
    public void zoomValueAxisToValues(int index, Object startValue, Object endValue) {
        component.zoomValueAxisToValues(index, startValue, endValue);
    }

    @Override
    public Subscription addAxisZoomListener(Consumer<AxisZoomEvent> listener) {
        if (axisZoomHandler == null) {
            axisZoomHandler = this::onAxisZoomListener;
            component.addAxisZoomListener(axisZoomHandler);
        }
        return getEventHub().subscribe(AxisZoomEvent.class, listener);
    }

    protected void onAxisZoomListener(com.haulmont.charts.web.widgets.amcharts.events.AxisZoomEvent e) {
        publish(AxisZoomEvent.class, new AxisZoomEvent(e.getAxisId(), e.getStartValue(), e.getEndValue()));
    }

    @Override
    public void removeAxisZoomListener(Consumer<AxisZoomEvent> listener) {
        unsubscribe(AxisZoomEvent.class, listener);
        if (axisZoomHandler != null && !hasSubscriptions(AxisZoomEvent.class)) {
            component.removeAxisZoomListener(axisZoomHandler);
            axisZoomHandler = null;
        }
    }

    @Override
    public Subscription addGraphClickListener(Consumer<GraphClickEvent> listener) {
        if (graphClickHandler == null) {
            graphClickHandler = this::onGraphClick;
            component.addGraphClickListener(graphClickHandler);
        }

        return getEventHub().subscribe(GraphClickEvent.class, listener);
    }

    protected void onGraphClick(com.haulmont.charts.web.widgets.amcharts.events.GraphClickEvent e) {
        publish(GraphClickEvent.class,
                new GraphClickEvent(this, e.getGraphId(), e.getX(), e.getY(),
                        e.getAbsoluteX(), e.getAbsoluteY()));
    }

    @Override
    public void removeGraphClickListener(Consumer<GraphClickEvent> listener) {
        unsubscribe(GraphClickEvent.class, listener);
        if (graphClickHandler != null && !hasSubscriptions(GraphClickEvent.class)) {
            component.removeGraphClickListener(graphClickHandler);
            graphClickHandler = null;
        }
    }

    @Override
    public Subscription addGraphItemClickListener(Consumer<GraphItemClickEvent> listener) {
        if (graphItemClickHandler == null) {
            graphItemClickHandler = this::onGraphItemClick;
            component.addGraphItemClickListener(graphItemClickHandler);
        }

        return getEventHub().subscribe(GraphItemClickEvent.class, listener);
    }

    protected void onGraphItemClick(com.haulmont.charts.web.widgets.amcharts.events.GraphItemClickEvent e) {
        publish(GraphItemClickEvent.class,
                new GraphItemClickEvent(this, getGraphById(e.getGraphId()), e.getGraphId(), e.getDataItem(),
                        e.getItemIndex(), e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY()));
    }

    @Override
    public void removeGraphItemClickListener(Consumer<GraphItemClickEvent> listener) {
        unsubscribe(GraphItemClickEvent.class, listener);
        if (graphItemClickHandler != null && !hasSubscriptions(GraphItemClickEvent.class)) {
            component.removeGraphItemClickListener(graphItemClickHandler);
            graphItemClickHandler = null;
        }
    }

    @Override
    public Subscription addGraphItemRightClickListener(Consumer<GraphItemRightClickEvent> listener) {
        if (graphItemRightClickHandler == null) {
            graphItemRightClickHandler = this::onGraphItemRightClick;
            component.addGraphItemRightClickListener(graphItemRightClickHandler);
        }

        return getEventHub().subscribe(GraphItemRightClickEvent.class, listener);
    }

    protected void onGraphItemRightClick(com.haulmont.charts.web.widgets.amcharts.events.GraphItemRightClickEvent e) {
        publish(GraphItemRightClickEvent.class,
                new GraphItemRightClickEvent(this, getGraphById(e.getGraphId()), e.getGraphId(), e.getDataItem(),
                        e.getItemIndex(), e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY()));
    }

    @Override
    public void removeGraphItemRightClickListener(Consumer<GraphItemRightClickEvent> listener) {
        unsubscribe(GraphItemRightClickEvent.class, listener);
        if (graphItemRightClickHandler != null && !hasSubscriptions(GraphItemRightClickEvent.class)) {
            component.removeGraphItemRightClickListener(graphItemRightClickHandler);
            graphItemRightClickHandler = null;
        }
    }

    protected Graph getGraphById(String id) {
        if (Strings.isNullOrEmpty(id)
                || (getGraphs() == null || getGraphs().isEmpty())) {
            return null;
        }

        for (Graph graph : getGraphs()) {
            if (id.equals(graph.getId())) {
                return graph;
            }
        }
        return null;
    }
}