/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.web.toolkit.ui.charts.jsgantt;

import com.haulmont.charts.web.toolkit.ui.charts.GanttChartComponent;
import com.vaadin.data.Container;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
//@ClientWidget(VGanttChartRenderer.class)
public class JSGanttChart extends GanttChartComponent {

    public static final String VENDOR = "jsgantt";

    private boolean showStartDate = true;
    private boolean showEndDate = true;
    protected boolean showDuration = false;
    private boolean showComplete = false;
    private boolean showResource = false;
    private boolean showInitiator = false;

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
    private String dateTimeFormat = "";


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
        setWidth(100, UNITS_PERCENTAGE);
    }
/*  vaadin7
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

        // Configure localization
        if (localeDict != null)
            target.addAttribute(VGanttChartRenderer.LOCALE_SECTION, localeDict);

        if (localeChanged) {
            target.addAttribute("localeChanged", "true");
            localeChanged = false;
        }

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("showStartDate", showStartDate);
        prefs.put("showEndDate", showEndDate);
        prefs.put("showDuration", showDuration);
        prefs.put("showComplete", showComplete);
        prefs.put("showResource", showResource);
        prefs.put("showInitiator", showInitiator);
        prefs.put("dateFormat", StringUtils.defaultString(dateTimeFormat, "dd/MM/yyyy"));
        target.addAttribute(VGanttChartRenderer.CONFIG_SECTION, prefs);

        if (settingsChanged) {
            target.addAttribute("settingsChanged", "true");
            settingsChanged = false;
        }

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

        if (itemsChanged) {
            target.addAttribute("taskChanged", "true");
            itemsChanged = false;
        }
    }*/

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

    public void setShowStartDate(boolean showStartDate) {
        this.showStartDate = showStartDate;
        fireSettingsChange();
    }

    public boolean getShowStartDate() {
        return showStartDate;
    }

    public void setShowEndDate(boolean showEndDate) {
        this.showEndDate = showEndDate;
        fireSettingsChange();
    }

    public boolean getShowEndDate() {
        return showEndDate;
    }

    @Override
    public void setShowDuration(boolean showDuration) {
        this.showDuration = showDuration;
        fireSettingsChange();
    }

    @Override
    public boolean getShowDuration() {
        return showDuration;
    }

    @Override
    public void setShowResource(boolean showResource) {
        this.showResource = showResource;
        fireSettingsChange();
    }

    @Override
    public boolean getShowResource() {
        return showResource;
    }

    @Override
    public void setShowInitiator(boolean showInitiator) {
        this.showInitiator = showInitiator;
        fireSettingsChange();
    }

    @Override
    public boolean getShowInitiator() {
        return showInitiator;
    }


    @Override
    public void setShowComplete(boolean showComplete) {
        this.showComplete = showComplete;
        fireSettingsChange();
    }

    @Override
    public boolean getShowComplete() {
        return showComplete;
    }

    public void setDateFormat(String dateTimeFormat) {
        this.dateTimeFormat = dateTimeFormat;
        fireSettingsChange();
    }

    public String getDateFormat() {
        return dateTimeFormat;
    }

    public List<String> getMessageKeys() {
        return MESSAGE_KEYS;
    }

    protected void fireSettingsChange() {
        this.settingsChanged = true;
        requestRepaint();
    }
}