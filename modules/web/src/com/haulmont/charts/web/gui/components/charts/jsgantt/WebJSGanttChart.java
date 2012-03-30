/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.web.gui.components.charts.jsgantt;

import com.haulmont.charts.core.entity.GanttChartItem;
import com.haulmont.charts.web.gui.components.charts.WebAbstractGanttChart;
import com.haulmont.charts.web.toolkit.ui.charts.TaskPropertiesProvider;
import com.haulmont.charts.web.toolkit.ui.charts.WGanttChart;
import com.haulmont.charts.web.toolkit.ui.charts.jsgantt.JSGanttChart;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.chile.core.model.MetaProperty;
import com.haulmont.cuba.core.global.MessageProvider;
import com.haulmont.cuba.core.global.MetadataProvider;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import org.apache.commons.lang.ObjectUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
public class WebJSGanttChart extends WebAbstractGanttChart<JSGanttChart> {

    private String messagePack = WebJSGanttChart.class.getPackage().getName();

    public WebJSGanttChart() {
        component = new JSGanttChart();
        component.setPropertiesProvider(new GanttTaskPropertiesProvider());
        component.setLocaleDict(compileMessages(messagePack));
        component.setTaskItemClickListener(new WGanttChart.TaskItemClickListener() {
            @Override
            public void handleClick(Integer itemId) {
                CollectionDatasource datasource = getCollectionDatasource();
                if (datasource != null) {
                    Iterator iterator = datasource.getItemIds().iterator();
                    GanttChartItem chartItem = null;
                    while (iterator.hasNext() && (chartItem == null)) {
                        Object key = iterator.next();
                        GanttChartItem item = (GanttChartItem) datasource.getItem(key);
                        if (ObjectUtils.equals(item.getItemId(), itemId))
                            chartItem = item;
                    }

                    if (chartItem != null) {
                        if (taskClickListener != null)
                            taskClickListener.performClick(chartItem);
                    }
                }
            }
        });
    }

    @Override
    public void setShowStartDate(boolean showStartDate) {
        component.setShowStartDate(showStartDate);
    }

    @Override
    public boolean getShowStartDate() {
        return component.getShowStartDate();
    }

    @Override
    public void setShowEndDate(boolean showEndDate) {
        component.setShowEndDate(showEndDate);
    }

    @Override
    public boolean getShowEndDate() {
        return component.getShowEndDate();
    }

    @Override
    public void setShowDuration(boolean showDuration) {
        component.setShowDuration(showDuration);
    }

    @Override
    public boolean getShowDuration() {
        return component.getShowDuration();
    }

    @Override
    public void setShowResource(boolean showResource) {
        component.setShowResource(showResource);
    }

    @Override
    public boolean getShowResource() {
        return component.getShowResource();
    }

    @Override
    public void setShowComplete(boolean showComplete) {
        component.setShowComplete(showComplete);
    }

    @Override
    public boolean getShowComplete() {
        return component.getShowComplete();
    }

    @Override
    public void setDateFormat(String dateTimeFormat) {
        component.setDateFormat(dateTimeFormat);
    }

    @Override
    public String getDateFormat() {
        return component.getDateFormat();
    }

    @Override
    public String getMessagePack() {
        return messagePack;
    }

    @Override
    public void setMessagePack(String messagePack) {
        this.messagePack = messagePack;
        this.component.setLocaleDict(compileMessages(messagePack));
    }

    private Map<String, String> compileMessages(String messagePack) {
        Map<String, String> messages = new HashMap<String, String>();
        for (String key : component.getMessageKeys()) {
            messages.put(key, MessageProvider.getMessage(messagePack, key));
        }
        return messages;
    }

    /**
     * Properties mapping
     */
    private class GanttTaskPropertiesProvider implements TaskPropertiesProvider {

        private Map<String, MetaProperty> metaPropertyMap = new HashMap<String, MetaProperty>();

        private GanttTaskPropertiesProvider() {
            MetaClass metaClass = MetadataProvider.getSession().getClass(GanttChartItem.class);

            metaPropertyMap.put("itemId", metaClass.getProperty("itemId"));
            metaPropertyMap.put("parentId", metaClass.getProperty("parentId"));
            metaPropertyMap.put("title", metaClass.getProperty("name"));
            metaPropertyMap.put("styleClass", metaClass.getProperty("styleClass"));
            metaPropertyMap.put("completePercent", metaClass.getProperty("completePercent"));
            metaPropertyMap.put("resourceName", metaClass.getProperty("resourceName"));
            metaPropertyMap.put("captionType", metaClass.getProperty("captionType"));
            metaPropertyMap.put("tooltip", metaClass.getProperty("tooltip"));
            metaPropertyMap.put("dependsOn", metaClass.getProperty("dependsOn"));

            metaPropertyMap.put("isGroup", metaClass.getProperty("group"));
            metaPropertyMap.put("isOpen", metaClass.getProperty("open"));
            metaPropertyMap.put("isMileStone", metaClass.getProperty("milestone"));

            metaPropertyMap.put("startDate", metaClass.getProperty("startDate"));
            metaPropertyMap.put("endDate", metaClass.getProperty("endDate"));
        }

        @Override
        public void assignTaskIds() {
            CollectionDatasource datasource = getCollectionDatasource();
            if (datasource != null) {
                // 0 - global parent id
                // 1 - first child id on task pane
                int itemIdCounter = 1;
                for (Object key : datasource.getItemIds()) {
                    GanttChartItem chartItem = (GanttChartItem) datasource.getItem(key);
                    try {
                        Field itemIdField = GanttChartItem.class.getDeclaredField("itemId");
                        itemIdField.setAccessible(true);
                        itemIdField.set(chartItem, itemIdCounter);

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    itemIdCounter++;
                }
            }
        }

        @Override
        public Map<String, Object> getTaskProperties(Item taskItem) {
            Map<String, Object> propertyMap = new HashMap<String, Object>();
            for (Map.Entry<String, MetaProperty> metaPropertyEntry : metaPropertyMap.entrySet()) {
                MetaProperty metaProperty = metaPropertyEntry.getValue();
                Property itemProperty = taskItem.getItemProperty(metaProperty);
                propertyMap.put(metaPropertyEntry.getKey(), itemProperty.getValue());
            }

            return propertyMap;
        }
    }
}