/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.charts.amcharts;

import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.components.charts.CoordinateChart;

import java.util.List;

@SuppressWarnings("unchecked")
public abstract class WebCoordinateChart<T extends CoordinateChart,
        M extends com.haulmont.charts.gui.amcharts.model.charts.CoordinateChart> extends WebChart<T, M> implements CoordinateChart<T> {

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.AxisZoomListener axisZoomHandler;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.GraphClickListener graphClickHandler;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.GraphItemClickListener graphItemClickHandler;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.GraphItemRightClickListener graphItemRightClickHandler;

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
    public Integer getStartDuration() {
        return getModel().getStartDuration();
    }

    @Override
    public T setStartDuration(Integer startDuration) {
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
    public void addAxisZoomListener(AxisZoomListener listener) {
        getEventRouter().addListener(AxisZoomListener.class, listener);
        if (axisZoomHandler == null) {
            axisZoomHandler = e -> {
                AxisZoomEvent event = new AxisZoomEvent(e.getAxisId(), e.getStartValue(), e.getEndValue());
                getEventRouter().fireEvent(AxisZoomListener.class, AxisZoomListener::onZoom, event);
            };
            component.addAxisZoomListener(axisZoomHandler);
        }
    }

    @Override
    public void removeAxisZoomListener(AxisZoomListener listener) {
        getEventRouter().removeListener(AxisZoomListener.class, listener);
        if (axisZoomHandler != null && !getEventRouter().hasListeners(AxisZoomListener.class)) {
            component.removeAxisZoomListener(axisZoomHandler);
            axisZoomHandler = null;
        }
    }

    @Override
    public void addGraphClickListener(GraphClickListener listener) {
        getEventRouter().addListener(GraphClickListener.class, listener);
        if (graphClickHandler == null) {
            graphClickHandler = e -> {
                GraphClickEvent event = new GraphClickEvent(e.getGraphId(), e.getX(), e.getY(),
                        e.getAbsoluteX(), e.getAbsoluteY());
                getEventRouter().fireEvent(GraphClickListener.class, GraphClickListener::onClick, event);
            };
            component.addGraphClickListener(graphClickHandler);
        }
    }

    @Override
    public void removeGraphClickListener(GraphClickListener listener) {
        getEventRouter().removeListener(GraphClickListener.class, listener);
        if (graphClickHandler != null && !getEventRouter().hasListeners(GraphClickListener.class)) {
            component.removeGraphClickListener(graphClickHandler);
            graphClickHandler = null;
        }
    }

    @Override
    public void addGraphItemClickListener(GraphItemClickListener listener) {
        getEventRouter().addListener(GraphItemClickListener.class, listener);
        if (graphItemClickHandler == null) {
            graphItemClickHandler = e -> {
                GraphItemClickEvent event = new GraphItemClickEvent(e.getGraphId(), e.getDataItem(),
                        e.getItemIndex(), e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());
                getEventRouter().fireEvent(GraphItemClickListener.class, GraphItemClickListener::onClick, event);
            };
            component.addGraphItemClickListener(graphItemClickHandler);
        }
    }

    @Override
    public void removeGraphItemClickListener(GraphItemClickListener listener) {
        getEventRouter().removeListener(GraphItemClickListener.class, listener);
        if (graphItemClickHandler != null && !getEventRouter().hasListeners(GraphItemClickListener.class)) {
            component.removeGraphItemClickListener(graphItemClickHandler);
            graphItemClickHandler = null;
        }
    }

    @Override
    public void addGraphItemRightClickListener(GraphItemRightClickListener listener) {
        getEventRouter().addListener(GraphItemRightClickListener.class, listener);
        if (graphItemRightClickHandler == null) {
            graphItemRightClickHandler = e -> {
                GraphItemRightClickEvent event = new GraphItemRightClickEvent(e.getGraphId(), e.getDataItem(),
                        e.getItemIndex(), e.getX(), e.getY(), e.getAbsoluteX(), e.getAbsoluteY());
                getEventRouter().fireEvent(GraphItemRightClickListener.class, GraphItemRightClickListener::onRightClick, event);
            };
            component.addGraphItemRightClickListener(graphItemRightClickHandler);
        }
    }

    @Override
    public void removeGraphItemRightClickListener(GraphItemRightClickListener listener) {
        getEventRouter().removeListener(GraphItemRightClickListener.class, listener);
        if (graphItemRightClickHandler != null && !getEventRouter().hasListeners(GraphItemRightClickListener.class)) {
            component.removeGraphItemRightClickListener(graphItemRightClickHandler);
            graphItemRightClickHandler = null;
        }
    }
}