/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * See documentation for properties of StockLegend JS object. <br/>
 *
 * <a href="http://docs.amcharts.com/3/javascriptstockchart/StockLegend">http://docs.amcharts.com/3/javascriptstockchart/StockLegend</a>
 *
 * @author gorelov
 * @version $Id$
 */
public class StockLegend extends AbstractLegend<StockLegend> {

    private static final long serialVersionUID = -5155850515331784520L;

    private String periodValueTextComparing;

    private String periodValueTextRegular;

    private String valueTextComparing;

    private String valueTextRegular;

    public String getPeriodValueTextComparing() {
        return periodValueTextComparing;
    }

    public StockLegend setPeriodValueTextComparing(String periodValueTextComparing) {
        this.periodValueTextComparing = periodValueTextComparing;
        return this;
    }

    public String getPeriodValueTextRegular() {
        return periodValueTextRegular;
    }

    public StockLegend setPeriodValueTextRegular(String periodValueTextRegular) {
        this.periodValueTextRegular = periodValueTextRegular;
        return this;
    }

    public String getValueTextComparing() {
        return valueTextComparing;
    }

    public StockLegend setValueTextComparing(String valueTextComparing) {
        this.valueTextComparing = valueTextComparing;
        return this;
    }

    public String getValueTextRegular() {
        return valueTextRegular;
    }

    public StockLegend setValueTextRegular(String valueTextRegular) {
        this.valueTextRegular = valueTextRegular;
        return this;
    }
}
