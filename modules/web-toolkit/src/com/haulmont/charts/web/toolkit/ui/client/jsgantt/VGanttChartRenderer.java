/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.jsgantt;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ApplicationConnection;

import java.util.*;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
public class VGanttChartRenderer extends SimplePanel {

    public static final String CLASSNAME = "v-ganttchart";

    private String paintableId;
    private GanttChartAPI chartAPI = null;
    private ApplicationConnection client;

    private Element chartPane = DOM.createDiv();

    private ClickHandler clickHandler;

    private static final List<String> MESSAGE_KEYS = Collections.unmodifiableList(
            Arrays.asList(
                    "gantt.label.format",
                    "gantt.label.day",
                    "gantt.label.week",
                    "gantt.label.month",
                    "gantt.label.quarter",

                    "gantt.label.name",
                    "gantt.label.initiator",
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

    public String getPaintableId() {
        return paintableId;
    }

    public void setPaintableId(String paintableId) {
        if (chartAPI == null) {
            chartPane.setId(paintableId + "_chartPane");
            chartAPI = new GanttChartAPI(chartPane.getId(), new ChartClickHandler());
        }
        this.paintableId = paintableId;

    }

    public interface ClickHandler {
        void onClick(int itemId);
    }

    public GanttChartAPI getChartAPI() {
        return chartAPI;
    }

    class ChartClickHandler implements GanttChartAPI.ClickHandler {
        @Override
        public void onClick(int itemId) {
            if (clickHandler != null) {
                clickHandler.onClick(itemId);
            }
        }
    }

    public ClickHandler getClickHandler() {
        return clickHandler;
    }

    public void setClickHandler(ClickHandler clickHandler) {
        this.clickHandler = clickHandler;
    }

    public void setChartAPI(GanttChartAPI chartAPI) {
        this.chartAPI = chartAPI;
    }

    public ApplicationConnection getClient() {
        return client;
    }

    public void setClient(ApplicationConnection client) {
        this.client = client;
    }

    public Element getChartPane() {
        return chartPane;
    }

    public void setChartPane(Element chartPane) {
        this.chartPane = chartPane;
    }

    public VGanttChartRenderer() {
        setStyleName(CLASSNAME);
        DOM.appendChild(getElement(), chartPane);
        chartPane.getStyle().setProperty("height", "auto");
        chartPane.setId("chartPane");

    }

    public Widget getParentContainer() {
        Widget parent = getParent();
        while (parent != null && !(parent instanceof HasWidgets)) {
            parent = parent.getParent();
        }
        if (parent != null) {
            return parent;
        }
        return null;
    }


    public void setWidth(String width) {
        super.setWidth(width);
        if (chartAPI != null) {
            Widget parentContainer = getParentContainer();
            chartAPI.setSize(parentContainer.getOffsetWidth(), parentContainer.getOffsetHeight());
        }
    }

    public void setHeight(String height) {
        super.setHeight(height);
        if (chartAPI != null) {
            Widget parentContainer = getParentContainer();
            chartAPI.setSize(parentContainer.getOffsetWidth(), parentContainer.getOffsetHeight());
        }
    }

    public void init(JSGanttChartState jsGanttChartState) {
        setLocale(jsGanttChartState.localeDict);
        chartAPI.clearTaskPane();
        setShowStartDate(jsGanttChartState.showStartDate);
        setShowEndDate(jsGanttChartState.showEndDate);
        setShowDuration(jsGanttChartState.showDuration);
        setShowResource(jsGanttChartState.showResource);
        setShowInitiator(jsGanttChartState.showInitiator);
        setShowComplete(jsGanttChartState.showComplete);
        setDateFormat(jsGanttChartState.dateTimeFormat);
        chartAPI.clearTaskPane();
        setTasks(jsGanttChartState.tasks);
        setSize("-1px", "-1px");
        chartAPI.repaint();
    }

    public void setShowStartDate(boolean showStartDate) {
        chartAPI.setShowStartDate(showStartDate);
    }

    public void setShowEndDate(boolean showEndDate) {
        chartAPI.setShowEndDate(showEndDate);
    }

    public void setShowDuration(boolean showDuration) {
        chartAPI.setShowDuration(showDuration);
    }

    public void setShowResource(boolean showResource) {
        chartAPI.setShowResource(showResource);
    }

    public void setShowInitiator(boolean showInitiator) {
        chartAPI.setShowInitiator(showInitiator);
    }

    public void setShowComplete(boolean showComplete) {
        chartAPI.setShowCompete(showComplete);
    }

    public void setDateFormat(String dateFormat) {
        chartAPI.setDateFormat(dateFormat);
    }

    public void setLocale(Map<String, String> messages) {
        chartAPI.clearTaskPane();
        // load locale
        GanttMessagePack localeLabels = GWT.create(GanttMessagePack.class);
        List<String> months = new LinkedList();

        String labelPrefix = "gantt.label.";
        String monthPrefix = "gantt.month.";
        for (String key : MESSAGE_KEYS) {
            if (key.startsWith(labelPrefix)) {
                String localeKey = key.substring(labelPrefix.length());
                localeLabels.addMessage(localeKey, messages.get(key));
            } else if (key.startsWith(monthPrefix)) {
                months.add(messages.get(key));
            }
        }
        chartAPI.setLocale(localeLabels);
        chartAPI.setMonthNames(months.toArray(new String[months.size()]));
    }

    public void setTasks(List<Map<String, String>> tasks) {
        for (Map<String, String> task : tasks) {
            renderTask(task);
        }
    }

    private int getInt(Map<String, String> props, String key, int defaultValue) {
        if (props.containsKey(key))
            return Integer.parseInt(props.get(key));
        else
            return defaultValue;
    }

    private String getString(Map<String, String> props, String key, String defaultValue) {
        if (props.containsKey(key))
            return props.get(key);
        else
            return defaultValue;
    }

    private boolean getBoolean(Map<String, String> props, String key, boolean defaultValue) {
        if (props.containsKey(key))
            return Boolean.parseBoolean(props.get(key));
        else
            return defaultValue;
    }

    private void renderTask(Map<String, String> taskProps) {
        int taskId = getInt(taskProps, "itemId", 0);
        int parentId = getInt(taskProps, "parentId", 0);
        String title = getString(taskProps, "title", "");
        String resource = getString(taskProps, "resourceName", "");
        String initiator = getString(taskProps, "initiatorName", "");
        int completePercent = getInt(taskProps, "completePercent", 0);

        String startTs = getString(taskProps, "startDate", "");
        String endTs = getString(taskProps, "endDate", "");

        String styleClass = getString(taskProps, "styleClass", "");
        String dependsOn = getString(taskProps, "dependsOn", "");
        String captionType = getString(taskProps, "captionType", "Resource");
        String tooltip = getString(taskProps, "tooltip", "");

        boolean isMileStone = getBoolean(taskProps, "isMileStone", false);
        boolean isOpen = getBoolean(taskProps, "isOpen", false);
        boolean isGroup = getBoolean(taskProps, "isGroup", false);

        chartAPI.addTask(taskId, parentId, title, resource, initiator,
                completePercent, startTs, endTs,
                styleClass, dependsOn, captionType, tooltip,
                isMileStone, isOpen, isGroup);
    }

}