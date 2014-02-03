/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.jsgantt;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.haulmont.charts.web.toolkit.ui.gantt.JSGanttChart;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

/**
 * @author tsarevskiy
 * @version $Id$
 */
@Connect(JSGanttChart.class)
public class VGanttChartRendererConnector extends AbstractComponentConnector {

    protected JSGanttChartServerRPC rpc = RpcProxy.create(JSGanttChartServerRPC.class, this);

    public VGanttChartRendererConnector() {
        getWidget().setClickHandler(new VGanttChartRenderer.ClickHandler() {
            @Override
            public void onClick(int itemId) {
                rpc.onClick(itemId);
            }
        });
    }

    @Override
    public VGanttChartRenderer getWidget() {
        return (VGanttChartRenderer) super.getWidget();
    }

    @Override
    protected VGanttChartRenderer createWidget() {
        VGanttChartRenderer vGanttChartRenderer = GWT.create(VGanttChartRenderer.class);
        return vGanttChartRenderer;
    }

    @Override
    public JSGanttChartState getState() {
        return (JSGanttChartState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        final VGanttChartRenderer vGanttChartRenderer = getWidget();
        vGanttChartRenderer.setClient(getConnection());
        vGanttChartRenderer.setPaintableId(getConnectorId());

        if (stateChangeEvent.isInitialStateChange()) {
            GanttChartAPI.onReady(new Runnable() {
                @Override
                public void run() {
                    vGanttChartRenderer.init(getState());
                    Widget parentContainer = vGanttChartRenderer.getParentContainer();
                    vGanttChartRenderer.getChartAPI().setSize(parentContainer.getOffsetWidth(),
                            parentContainer.getOffsetHeight());
                }
            });
        } else {
            GanttChartAPI chartAPI = vGanttChartRenderer.getChartAPI();
            vGanttChartRenderer.setShowStartDate(getState().showStartDate);
            vGanttChartRenderer.setShowEndDate(getState().showEndDate);
            vGanttChartRenderer.setShowDuration(getState().showDuration);
            vGanttChartRenderer.setShowResource(getState().showResource);
            vGanttChartRenderer.setShowInitiator(getState().showInitiator);
            vGanttChartRenderer.setShowComplete(getState().showComplete);
            vGanttChartRenderer.setDateFormat(getState().dateTimeFormat);
            if (getState().localeDict != null && stateChangeEvent.hasPropertyChanged("localeDict")) {
                vGanttChartRenderer.setLocale(getState().localeDict);
            }
            if (stateChangeEvent.hasPropertyChanged("tasks")) {
                vGanttChartRenderer.setTasks(getState().tasks);
            }
            chartAPI.repaint();
        }
    }
}
