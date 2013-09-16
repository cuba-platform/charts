/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.core.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.AbstractNotPersistentEntity;
import com.haulmont.cuba.core.entity.annotation.SystemLevel;
import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
@MetaClass(name = "charts$GanttChartItem")
@SystemLevel
public abstract class GanttChartItem extends AbstractNotPersistentEntity {

    protected Integer itemId;

    protected String name = "";

    protected String captionType = "";

    protected String tooltip = "";

    protected String color = "000000";

    protected String resourceName = "";

    private String initiatorName = "";

    protected GanttChartItem parent;

    protected List<GanttChartItem> dependencies;

    protected Boolean isMilestone = false;

    protected Boolean open = false;

    protected Object relatedEntity;

    protected DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private String styleClass = "";


    @MetaProperty
    public Integer getItemId() {
        return itemId;
    }

    @MetaProperty
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Object getRelatedEntity() {
        return relatedEntity;
    }

    public void setRelatedEntity(Object relatedEntity) {
        this.relatedEntity = relatedEntity;
    }

    @MetaProperty
    public String getName() {
        return name;
    }

    @MetaProperty
    public void setName(String name) {
        this.name = name;
    }

    @MetaProperty
    public String getTooltip() {
        return tooltip;
    }

    @MetaProperty
    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    @MetaProperty
    public String getCaptionType() {
        return captionType;
    }

    @MetaProperty
    public void setCaptionType(String captionType) {
        this.captionType = captionType;
    }

    @MetaProperty
    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    @MetaProperty
    public String getStyleClass() {
        return styleClass;
    }

    @MetaProperty
    public String getResourceName() {
        return resourceName;
    }

    @MetaProperty
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @MetaProperty
    public String getInitiatorName() {
        return initiatorName;
    }

    @MetaProperty
    public void setInitiatorName(String initiatorName) {
        this.initiatorName = initiatorName;
    }

    @MetaProperty
    public GanttChartItem getParent() {
        return parent;
    }

    @MetaProperty
    public Integer getParentId() {
        if (parent != null)
            return parent.getItemId();
        else
            return 0;
    }

    @MetaProperty
    public Boolean getGroup() {
        return this instanceof GanttChartGroup;
    }

    @MetaProperty
    public void setParent(GanttChartItem parent) {
        this.parent = parent;
    }

    public List<GanttChartItem> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<GanttChartItem> dependencies) {
        this.dependencies = dependencies;
    }

    @MetaProperty
    public String getDependsOn() {
        if (dependencies == null)
            return "";

        List<Integer> dependsList = new LinkedList<Integer>();
        for (Object dependencyItem : dependencies) {
            GanttChartItem dependencyChartItem = (GanttChartItem) dependencyItem;
            dependsList.add(dependencyChartItem.getItemId());
        }

        return StringUtils.join(dependsList, ',');
    }

    @MetaProperty
    public Integer getCompletePercent() {
        return 0;
    }

    @MetaProperty
    public void setCompletePercent(Integer percent) {
    }

    @MetaProperty
    public Boolean getMilestone() {
        return isMilestone;
    }

    @MetaProperty
    public void setMilestone(Boolean milestone) {
        isMilestone = milestone;
    }

    @MetaProperty
    public Boolean getOpen() {
        return open;
    }

    @MetaProperty
    public void setOpen(Boolean open) {
        this.open = open;
    }

    @MetaProperty
    public Date getStartTs() {
        return null;
    }

    @MetaProperty
    public Date getEndTs() {
        return null;
    }

    @MetaProperty
    public String getStartDate() {
        Date start = getStartTs();
        if (start != null)
            return dateFormat.format(start);
        else
            return "";
    }

    @MetaProperty
    public String getEndDate() {
        Date end = getEndTs();
        if (end != null)
            return dateFormat.format(end);
        else
            return "";
    }
}