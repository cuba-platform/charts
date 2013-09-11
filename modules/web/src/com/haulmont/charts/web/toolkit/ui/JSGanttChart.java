/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.web.toolkit.ui;

import com.haulmont.charts.web.toolkit.ui.charts.GanttChartComponent;
import com.haulmont.charts.web.toolkit.ui.client.jsgantt.JSGanttChartServerRPC;
import com.haulmont.charts.web.toolkit.ui.client.jsgantt.JSGanttChartState;
import com.vaadin.annotations.JavaScript;
import com.vaadin.data.Container;
import com.vaadin.data.Item;

import java.util.*;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
@JavaScript({"resources/js/jquery.mb.browser.min.js",
        "resources/js/jquery.bgiframe.js",
        "resources/js/jquery.dimensions.js",
        "resources/js/jquery.delegate.js",
        "resources/js/jquery.tooltip.js",
        "resources/js/jsgantt.js"})

public class JSGanttChart extends GanttChartComponent {

    public static final String VENDOR = "jsgantt";

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

    private JSGanttChartServerRPC rpc = new JSGanttChartServerRPC() {
        public void onClick(int itemId) {
            if (itemClickListener != null) {
                itemClickListener.handleClick(itemId);
            }
        }
    };

    public JSGanttChart() {
        addListener(new ItemSetChangeListener() {
            @Override
            public void containerItemSetChange(Container.ItemSetChangeEvent event) {
                updateTasks();
            }
        });
        addListener(new PropertySetChangeListener() {
            @Override
            public void containerPropertySetChange(Container.PropertySetChangeEvent event) {
                updateTasks();
            }
        });
        registerRpc(rpc);
        setWidth(100, Unit.PERCENTAGE);
    }

    protected void updateTasks() {
        Container containerDataSource = getContainerDataSource();
        List<Map<String, String>> tasks = new ArrayList<>();
        if (propertiesProvider != null) {
            propertiesProvider.assignTaskIds();
            for (Object key : containerDataSource.getItemIds()) {
                Item item = containerDataSource.getItem(key);
                Map<String, String> taskParams = propertiesProvider.getTaskProperties(item);
                tasks.add(taskParams);
            }
        }
        getState().tasks = tasks;
    }


    @Override
    protected JSGanttChartState getState() {
        return (JSGanttChartState) super.getState();
    }

    public Map<String, String> getLocaleDict() {
        return getState().localeDict;
    }

    public void setLocaleDict(Map<String, String> localeDict) {
        getState().localeDict = localeDict;
    }

    @Override
    public String getVendor() {
        return VENDOR;
    }

    public void setShowStartDate(boolean showStartDate) {
        getState().showStartDate = showStartDate;
    }

    public boolean getShowStartDate() {
        return getState().showStartDate;
    }

    public void setShowEndDate(boolean showEndDate) {
        getState().showEndDate = showEndDate;
    }

    public boolean getShowEndDate() {
        return getState().showEndDate;
    }

    @Override
    public void setShowDuration(boolean showDuration) {
        getState().showDuration = showDuration;
    }

    @Override
    public boolean getShowDuration() {
        return getState().showDuration;
    }

    @Override
    public void setShowResource(boolean showResource) {
        getState().showResource = showResource;
    }

    @Override
    public boolean getShowResource() {
        return getState().showResource;
    }

    @Override
    public void setShowInitiator(boolean showInitiator) {
        getState().showInitiator = showInitiator;
    }

    @Override
    public boolean getShowInitiator() {
        return getState().showInitiator;
    }


    @Override
    public void setShowComplete(boolean showComplete) {
        getState().showComplete = showComplete;
    }

    @Override
    public boolean getShowComplete() {
        return getState().showComplete;
    }

    public void setDateFormat(String dateTimeFormat) {
        getState().dateTimeFormat = dateTimeFormat;
    }

    public String getDateFormat() {
        return getState().dateTimeFormat;
    }

    public List<String> getMessageKeys() {
        return MESSAGE_KEYS;
    }
}