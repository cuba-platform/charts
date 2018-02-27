/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * See documentation for properties of StockLegend JS object. <br>
 *
 * <a href="http://docs.amcharts.com/3/javascriptstockchart/StockLegend">http://docs.amcharts.com/3/javascriptstockchart/StockLegend</a>
 */
public class StockLegend extends AbstractLegend<StockLegend> {

    private static final long serialVersionUID = -5155850515331784520L;

    private String periodValueTextComparing;

    private String periodValueTextRegular;

    private String valueTextComparing;

    private String valueTextRegular;

    /**
     * @return period value text comparing
     */
    public String getPeriodValueTextComparing() {
        return periodValueTextComparing;
    }

    /**
     * Sets the text which will be displayed in the value portion of the legend when user is not hovering above any
     * data point and the data sets are compared. The tags should be made out of two parts - the name of a field
     * (value / open / close / high / low) and the value of the period you want to be show - open / close / high /
     * low / sum / average / count. For example: [[value.sum]] means that sum of all data points of value field in
     * the selected period will be displayed. In case you want to display percent values, you should add "percent"
     * string in front of a tag, for example: [[percents.value.close]] means that last percent value of a period will
     * be displayed.
     *
     * @param periodValueTextComparing period value text comparing
     */
    public StockLegend setPeriodValueTextComparing(String periodValueTextComparing) {
        this.periodValueTextComparing = periodValueTextComparing;
        return this;
    }

    /**
     * @return period value text regular
     */
    public String getPeriodValueTextRegular() {
        return periodValueTextRegular;
    }

    /**
     * Sets the text which will be displayed in the value portion of the legend when user is not hovering above any
     * data point. The tags should be made out of two parts - the name of a field (value / open / close / high / low)
     * and the value of the period you want to be show - open / close / high / low / sum / average / count. For
     * example: [[value.sum]] means that sum of all data points of value field in the selected period will be displayed.
     *
     * @param periodValueTextRegular period value text regular
     */
    public StockLegend setPeriodValueTextRegular(String periodValueTextRegular) {
        this.periodValueTextRegular = periodValueTextRegular;
        return this;
    }

    /**
     * @return value text comparing
     */
    public String getValueTextComparing() {
        return valueTextComparing;
    }

    /**
     * Sets the text which will be displayed in the value portion of the legend when graph is comparable and at least
     * one data set is selected for comparing. You can use tags like [[value]], [[open]], [[high]], [[low]], [[close]],
     * [[percents.value/open/close/low/high]], [[description]].
     *
     * @param valueTextComparing value text comparing
     */
    public StockLegend setValueTextComparing(String valueTextComparing) {
        this.valueTextComparing = valueTextComparing;
        return this;
    }

    /**
     * @return value text regular
     */
    public String getValueTextRegular() {
        return valueTextRegular;
    }

    /**
     * Sets the text which will be displayed in the value portion of the legend. You can use tags like [[value]],
     * [[open]], [[high]], [[low]], [[close]], [[percents]], [[description]].
     *
     * @param valueTextRegular value text regular
     */
    public StockLegend setValueTextRegular(String valueTextRegular) {
        this.valueTextRegular = valueTextRegular;
        return this;
    }
}
