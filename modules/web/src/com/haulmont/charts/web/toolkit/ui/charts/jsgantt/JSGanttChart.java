/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.web.toolkit.ui.charts.jsgantt;

import com.haulmont.charts.toolkit.gwt.client.charts.jsgantt.VGanttChartRenderer;
import com.haulmont.charts.web.toolkit.ui.charts.GanttChartComponent;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;
import com.vaadin.ui.ClientWidget;

import java.util.*;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
@ClientWidget(VGanttChartRenderer.class)
public class JSGanttChart extends GanttChartComponent {

    public static final String VENDOR = "jsgantt";

    protected boolean showDuration = false;
    private boolean showComplete = false;
    private boolean showResource = false;

    private boolean settingsChanged = false;
    private boolean itemsChanged = false;
    private boolean localeChanged = false;

    private Map<String, String> localeDict = null;

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

    public JSGanttChart() {
        addListener(new ItemSetChangeListener() {
            @Override
            public void containerItemSetChange(Container.ItemSetChangeEvent event) {
                itemsChanged = true;
            }
        });
        addListener(new PropertySetChangeListener() {
            @Override
            public void containerPropertySetChange(Container.PropertySetChangeEvent event) {
                itemsChanged = true;
            }
        });
    }

    @Override
    public void changeVariables(Object source, Map<String, Object> variables) {
        super.changeVariables(source, variables);
        if (variables.containsKey("clickOnItem") && (itemClickListener != null)) {
            Integer itemId = (Integer) variables.get("clickOnItem");
            itemClickListener.handleClick(itemId);
        }
    }

    @Override
    public void paintContent(PaintTarget target) throws PaintException {
        super.paintContent(target);

        if (localeChanged) {
            if (localeDict != null) {
                // Configure localization
                target.addAttribute(VGanttChartRenderer.LOCALE_SECTION, localeDict);
            }
            localeChanged = false;
        }

        if (settingsChanged) {
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("showDuration", showDuration);
            prefs.put("showComplete", showComplete);
            prefs.put("showResource", showResource);
            target.addAttribute(VGanttChartRenderer.CONFIG_SECTION, prefs);
            settingsChanged = false;
        }

        if (itemsChanged) {
            Container containerDataSource = getContainerDataSource();
            List<Integer> tasks_ids = new LinkedList<Integer>();

            if (propertiesProvider != null) {
                propertiesProvider.assignTaskIds();

                for (Object key : containerDataSource.getItemIds()) {
                    Item item = containerDataSource.getItem(key);
                    Map<String, Object> taskParams = propertiesProvider.getTaskProperties(item);
                    Integer itemId = (Integer) taskParams.get("itemId");

                    tasks_ids.add(itemId);
                    target.addAttribute("task_" + Integer.toString(itemId), taskParams);
                }
            }

            target.addAttribute(VGanttChartRenderer.TASKS_SECTION, tasks_ids.toArray());
            itemsChanged = false;
        }
    }

    public Map<String, String> getLocaleDict() {
        return localeDict;
    }

    public void setLocaleDict(Map<String, String> localeDict) {
        this.localeDict = localeDict;
        this.localeChanged = true;
        requestRepaint();
    }

    @Override
    public String getVendor() {
        return VENDOR;
    }

    @Override
    public void setShowDuration(boolean showDuration) {
        this.showDuration = showDuration;
        this.settingsChanged = true;
        requestRepaint();
    }

    @Override
    public boolean getShowDuration() {
        return showDuration;
    }

    @Override
    public void setShowResource(boolean showResource) {
        this.showResource = showResource;
        this.settingsChanged = true;
        requestRepaint();
    }

    @Override
    public boolean getShowResource() {
        return showResource;
    }

    @Override
    public void setShowComplete(boolean showComplete) {
        this.showComplete = showComplete;
        this.settingsChanged = true;
        requestRepaint();
    }

    @Override
    public boolean getShowComplete() {
        return showComplete;
    }

    public List<String> getMessageKeys() {
        return MESSAGE_KEYS;
    }
}