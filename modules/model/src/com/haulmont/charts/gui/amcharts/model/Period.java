/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

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

    /**
     * return count of periods
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Sets how many periods button will select.
     *
     * @param count count
     */
    public Period setCount(Integer count) {
        this.count = count;
        return this;
    }

    /**
     * @return text label that is displayed on the button
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets text label that will be displayed on the button.
     *
     * @param label label string
     */
    public Period setLabel(String label) {
        this.label = label;
        return this;
    }

    /**
     * @return true if this button is selected when the chart is initialized
     */
    public Boolean getSelected() {
        return selected;
    }

    /**
     * Set selected to true if this button should be selected when the chart is initialized.
     *
     * @param selected selected option
     */
    public Period setSelected(Boolean selected) {
        this.selected = selected;
        return this;
    }
}