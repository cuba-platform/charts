/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author gorelov
 * @version $Id$
 */
public class Period extends AbstractChartObject {

    private static final long serialVersionUID = 1078558318840294205L;

    private PeriodType period;
    
    private Integer count;
    
    private String label;
    
    private Boolean selected;

    public PeriodType getPeriod() {
        return period;
    }

    public Period setPeriod(PeriodType period) {
        this.period = period;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public Period setCount(Integer count) {
        this.count = count;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public Period setLabel(String label) {
        this.label = label;
        return this;
    }

    public Boolean getSelected() {
        return selected;
    }

    public Period setSelected(Boolean selected) {
        this.selected = selected;
        return this;
    }
}
