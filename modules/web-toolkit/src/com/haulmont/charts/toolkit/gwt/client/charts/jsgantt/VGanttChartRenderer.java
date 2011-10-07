/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.toolkit.gwt.client.charts.jsgantt;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.SimplePanel;
import com.haulmont.charts.toolkit.gwt.client.charts.ChartsResourcesLoader;
import com.vaadin.terminal.gwt.client.ApplicationConnection;
import com.vaadin.terminal.gwt.client.Paintable;
import com.vaadin.terminal.gwt.client.UIDL;
import com.vaadin.terminal.gwt.client.ValueMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
public class VGanttChartRenderer extends SimplePanel implements Paintable {

    public static final String CLASSNAME = "v-ganttchart";

    public static final String TASKS_SECTION = "tasks";
    public static final String CONFIG_SECTION = "config";
    public static final String LOCALE_SECTION = "locale";

    private boolean initialized = false;

    private String paintableId;
    private GanttChartAPI chartAPI = null;
    private ApplicationConnection client;

    private Element chartPane = DOM.createDiv();

    private static final List<String> MESSAGE_KEYS = Collections.unmodifiableList(
            Arrays.asList(
                    "gantt.label.format",
                    "gantt.label.day",
                    "gantt.label.week",
                    "gantt.label.month",
                    "gantt.label.quarter",

                    "gantt.label.resource",
                    "gantt.label.duration",
                    "gantt.label.complete",
                    "gantt.label.startDate",
                    "gantt.label.endDate",
                    "gantt.label.qtr",

                    "gantt.month.January",
                    "gantt.month.February",
                    "gantt.month.March",
                    "gantt.month.April",
                    "gantt.month.May",
                    "gantt.month.June",
                    "gantt.month.July",
                    "gantt.month.August",
                    "gantt.month.September",
                    "gantt.month.October",
                    "gantt.month.November",
                    "gantt.month.December"));

    public VGanttChartRenderer() {
        setStyleName(CLASSNAME);
        DOM.appendChild(getElement(), chartPane);
        chartPane.getStyle().setProperty("height", "auto");
        chartPane.setId("chartPane");
        chartPane.getStyle().setPosition(Style.Position.RELATIVE);
    }

    @Override
    public void updateFromUIDL(final UIDL uidl, ApplicationConnection client) {
        this.client = client;

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
                    if (chartAPI == null)
                        chartAPI = new GanttChartAPI(chartPane.getId(), new ChartClickHandler());

                    renderContent(uidl);
                }
            });

            initialized = true;
        }

        if (chartAPI != null)
            renderContent(uidl);
    }

    private class ChartClickHandler implements GanttChartAPI.ClickHandler {

        @Override
        public void onClick(int itemId) {
            client.updateVariable(paintableId, "clickOnItem", itemId, true);
        }
    }

    private void renderContent(UIDL uidl) {
        boolean hasChanges = false;

        if (uidl.hasAttribute(LOCALE_SECTION)) {
            chartAPI.clearTaskPane();
            // load locale
            ValueMap messages = uidl.getMapAttribute(LOCALE_SECTION);
            GanttMessagePack localeLabels = GWT.create(GanttMessagePack.class);
            List<String> months = new LinkedList<String>();

            String labelPrefix = "gantt.label.";
            String monthPrefix = "gantt.month.";
            for (String key : MESSAGE_KEYS) {
                if (key.startsWith(labelPrefix)) {
                    String localeKey = key.substring(labelPrefix.length());
                    localeLabels.addMessage(localeKey, messages.getString(key));
                } else if (key.startsWith(monthPrefix)) {
                    months.add(messages.getString(key));
                }
            }
            chartAPI.setLocale(localeLabels);
            chartAPI.setMonthNames(months.toArray(new String[months.size()]));
            hasChanges = true;
        }

        if (uidl.hasAttribute(CONFIG_SECTION)) {
            chartAPI.clearTaskPane();
            // init configuration
            ValueMap prefs = uidl.getMapAttribute(CONFIG_SECTION);
            if (prefs.containsKey("showDuration"))
                chartAPI.setShowDuration(prefs.getBoolean("showDuration"));
            if (prefs.containsKey("showResource"))
                chartAPI.setShowResource(prefs.getBoolean("showResource"));
            if (prefs.containsKey("showComplete"))
                chartAPI.setShowCompete(prefs.getBoolean("showComplete"));
            // read config keys and set property values in chartApi

            hasChanges = true;
        }

        if (uidl.hasAttribute(TASKS_SECTION)) {
            chartAPI.clearTaskPane();
            // get tasks ids
            String[] tasks_ids = uidl.getStringArrayAttribute(TASKS_SECTION);
            // load value maps for ids
            if (tasks_ids != null) {
                for (String taskId : tasks_ids) {
                    ValueMap taskProps = uidl.getMapAttribute("task_" + taskId);
                    renderTaskFromUIDL(taskId, taskProps);
                }
            }
            hasChanges = true;
        }

        if (hasChanges) {
            setSize("-1px", "-1px");
            chartAPI.repaint();
        }
    }

    private int getInt(ValueMap props, String key, int defaultValue) {
        if (props.containsKey(key))
            return props.getInt(key);
        else
            return defaultValue;
    }

    private String getString(ValueMap props, String key, String defaultValue) {
        if (props.containsKey(key))
            return props.getString(key);
        else
            return defaultValue;
    }

    private boolean getBoolean(ValueMap props, String key, boolean defaultValue) {
        if (props.containsKey(key))
            return props.getBoolean(key);
        else
            return defaultValue;
    }

    private void renderTaskFromUIDL(String taskId, ValueMap taskProps) {
        int id = Integer.parseInt(taskId);

        int parentId = getInt(taskProps, "parentId", 0);
        String title = getString(taskProps, "title", "");
        String resource = getString(taskProps, "resource", "");
        int completePercent = getInt(taskProps, "completePercent", 0);

        String startTs = getString(taskProps, "startDate", "");
        String endTs = getString(taskProps, "endDate", "");

        String color = getString(taskProps, "color", "00ff00");
        String dependsOn = getString(taskProps, "dependsOn", "");
        String captionType = getString(taskProps, "captionType", "Resource");

        boolean isMileStone = getBoolean(taskProps, "isMileStone", false);
        boolean isOpen = getBoolean(taskProps, "isOpen", false);
        boolean isGroup = getBoolean(taskProps, "isGroup", false);

        chartAPI.addTask(id, parentId, title, resource,
                completePercent, startTs, endTs,
                color, dependsOn, captionType,
                isMileStone, isOpen, isGroup);
    }
}