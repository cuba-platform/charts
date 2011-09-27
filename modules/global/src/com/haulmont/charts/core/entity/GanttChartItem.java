/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.core.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.AbstractNotPersistentEntity;

import java.util.List;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
@MetaClass(name = "charts$GanttTaskItem")
public abstract class GanttChartItem extends AbstractNotPersistentEntity {

    private Long itemId;

    private String name;

    private String caption;

    private String color;

    private String resourceName;

    private String link;

    private GanttChartItem parent;

    private List<GanttChartItem> dependencies;

    private Boolean isMilestone;

    private Boolean isOpen;

    @MetaProperty
    public Long getItemId() {
        return itemId;
    }

    @MetaProperty
    public void setItemId(Long itemId) {
        this.itemId = itemId;
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
    public String getCaption() {
        return caption;
    }

    @MetaProperty
    public void setCaption(String caption) {
        this.caption = caption;
    }

    @MetaProperty
    public String getColor() {
        return color;
    }

    @MetaProperty
    public void setColor(String color) {
        this.color = color;
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
    public GanttChartItem getParent() {
        return parent;
    }

    @MetaProperty
    public void setParent(GanttChartItem parent) {
        this.parent = parent;
    }

    @MetaProperty
    public List<GanttChartItem> getDependencies() {
        return dependencies;
    }

    @MetaProperty
    public void setDependencies(List<GanttChartItem> dependencies) {
        this.dependencies = dependencies;
    }

    @MetaProperty
    public String getLink() {
        return link;
    }

    @MetaProperty
    public void setLink(String link) {
        this.link = link;
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
        return isOpen;
    }

    @MetaProperty
    public void setOpen(Boolean open) {
        isOpen = open;
    }
}