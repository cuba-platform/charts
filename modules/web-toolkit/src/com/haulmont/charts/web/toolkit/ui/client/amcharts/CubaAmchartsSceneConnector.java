/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts;

import com.google.gwt.core.client.Scheduler;
import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsScene;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.layout.ElementResizeEvent;
import com.vaadin.client.ui.layout.ElementResizeListener;
import com.vaadin.shared.ui.Connect;

/**
 * @author artamonov
 * @version $Id$
 */
@Connect(value = CubaAmchartsScene.class, loadStyle = Connect.LoadStyle.LAZY)
public class CubaAmchartsSceneConnector extends AbstractComponentConnector {

    protected ElementResizeListener resizeListener;

    @Override
    public CubaAmchartsSceneState getState() {
        return (CubaAmchartsSceneState) super.getState();
    }

    @Override
    public CubaAmchartsSceneWidget getWidget() {
        return (CubaAmchartsSceneWidget) super.getWidget();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                // Add resize listener lazily here. If done in init like in
                // examples it will be called
                // way too early, like before the wiget is not even rendered yet
                if (resizeListener == null) {
                    resizeListener = new ElementResizeListener() {

                        @Override
                        public void onElementResize(ElementResizeEvent e) {
                            getWidget().updateSize();
                        }
                    };

                    getLayoutManager().addElementResizeListener(getWidget().getElement(), resizeListener);
                }
            }
        });

        if (stateChangeEvent.hasPropertyChanged("json")) {
            getWidget().update(getState().json);
        }
    }
}