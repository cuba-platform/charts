/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.toolkit.gwt.client.charts.jsgantt;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.SimplePanel;
import com.haulmont.charts.toolkit.gwt.client.charts.ChartsResourcesLoader;
import com.vaadin.terminal.gwt.client.ApplicationConnection;
import com.vaadin.terminal.gwt.client.Paintable;
import com.vaadin.terminal.gwt.client.UIDL;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
public class VGanttChartRenderer extends SimplePanel implements Paintable {

    public static final String CLASSNAME = "v-ganttchart";

    public static final String REFRESH_KEY = "refresh";
    public static final String CONFIG_KEY = "config";

    private boolean initialized = false;

    private String paintableId;
    private GanttChartAPI chartAPI = null;

    private Element chartPane = DOM.createDiv();

    public VGanttChartRenderer() {
        setStyleName(CLASSNAME);
        DOM.appendChild(getElement(), chartPane);
        chartPane.setId("chartPane");
        chartPane.getStyle().setPosition(Style.Position.RELATIVE);
    }

    @Override
    public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
        paintableId = uidl.getId();
        chartPane.setId(paintableId + "_chartPane");

        if (client.updateComponent(this, uidl, false)) {
            return;
        }

        if (!initialized) {
            ChartsResourcesLoader.injectCss(client.getAppUri(), "/css/jsgantt.css");
            ChartsResourcesLoader.injectJs(client.getAppUri(), "/js/jsgantt.js");

            GanttChartAPI.onReady(new Runnable() {
                @Override
                public void run() {
                    initChartPane();
                }
            });

            initialized = true;
        } else {
            if (chartAPI != null) {
                // Process chart objects and commands
                if (uidl.hasAttribute(CONFIG_KEY)) {
                    // init configuration
                    initChartPane();
                    // read config keys and set property values in chartApi
                }

                if (uidl.hasAttribute(REFRESH_KEY)) {
                    // refresh task list
                    initChartPane();
                    // load tasks

                }
            }
        }
    }

    private void initChartPane() {
/*        NodeList<Node> nodes = chartPane.getChildNodes();
        if (nodes != null) {
            for (int i = 0; i < nodes.getLength(); i++) {
                chartPane.removeChild(nodes.getItem(i));
            }
        }*/

        chartAPI = new GanttChartAPI(paintableId, chartPane.getId());
        chartAPI.createChartControl();
    }
}