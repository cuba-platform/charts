/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * See documentation for properties of StockGraph JS object. <br/>
 *
 * <a href="http://docs.amcharts.com/3/javascriptstockchart/StockGraph">http://docs.amcharts.com/3/javascriptstockchart/StockGraph</a>
 *
 */
public class StockGraph extends AbstractGraph<StockGraph> {

    private static final long serialVersionUID = -1746419165781920815L;

    private Boolean comparable;

    private String compareField;

    private Boolean compareFromStart;

    private Graph compareGraph;

    private Color compareGraphBalloonColor;

    private JsFunction compareGraphBalloonFunction;

    private String compareGraphBalloonText;

    private String compareGraphBullet;

    private Double compareGraphBulletBorderAlpha;

    private Color compareGraphBulletBorderColor;

    private Integer compareGraphBulletBorderThickness;

    private Color compareGraphBulletColor;

    private Integer compareGraphBulletSize;

    private Integer compareGraphCornerRadiusTop;

    private Integer compareGraphDashLength;

    private Double compareGraphFillAlphas;

    private Color compareGraphFillColors;

    private Double compareGraphLineAlpha;

    private Color compareGraphLineColor;

    private Integer compareGraphLineThickness;

    private GraphType compareGraphType;

    private Boolean compareGraphVisibleInLegend;

    private StockGraphValue periodValue;

    private StockGraphValue recalculateValue;

    private Boolean showEventsOnComparedGraphs;

    private Boolean useDataSetColors;

    public Boolean getComparable() {
        return comparable;
    }

    public StockGraph setComparable(Boolean comparable) {
        this.comparable = comparable;
        return this;
    }

    public String getCompareField() {
        return compareField;
    }

    public StockGraph setCompareField(String compareField) {
        this.compareField = compareField;
        return this;
    }

    public Boolean getCompareFromStart() {
        return compareFromStart;
    }

    public StockGraph setCompareFromStart(Boolean compareFromStart) {
        this.compareFromStart = compareFromStart;
        return this;
    }

    public Graph getCompareGraph() {
        return compareGraph;
    }

    public StockGraph setCompareGraph(Graph compareGraph) {
        this.compareGraph = compareGraph;
        return this;
    }

    public Color getCompareGraphBalloonColor() {
        return compareGraphBalloonColor;
    }

    public StockGraph setCompareGraphBalloonColor(Color compareGraphBalloonColor) {
        this.compareGraphBalloonColor = compareGraphBalloonColor;
        return this;
    }

    public JsFunction getCompareGraphBalloonFunction() {
        return compareGraphBalloonFunction;
    }

    public StockGraph setCompareGraphBalloonFunction(JsFunction compareGraphBalloonFunction) {
        this.compareGraphBalloonFunction = compareGraphBalloonFunction;
        return this;
    }

    public String getCompareGraphBalloonText() {
        return compareGraphBalloonText;
    }

    public StockGraph setCompareGraphBalloonText(String compareGraphBalloonText) {
        this.compareGraphBalloonText = compareGraphBalloonText;
        return this;
    }

    public String getCompareGraphBullet() {
        return compareGraphBullet;
    }

    public StockGraph setCompareGraphBullet(String compareGraphBullet) {
        this.compareGraphBullet = compareGraphBullet;
        return this;
    }

    public Double getCompareGraphBulletBorderAlpha() {
        return compareGraphBulletBorderAlpha;
    }

    public StockGraph setCompareGraphBulletBorderAlpha(Double compareGraphBulletBorderAlpha) {
        this.compareGraphBulletBorderAlpha = compareGraphBulletBorderAlpha;
        return this;
    }

    public Color getCompareGraphBulletBorderColor() {
        return compareGraphBulletBorderColor;
    }

    public StockGraph setCompareGraphBulletBorderColor(Color compareGraphBulletBorderColor) {
        this.compareGraphBulletBorderColor = compareGraphBulletBorderColor;
        return this;
    }

    public Integer getCompareGraphBulletBorderThickness() {
        return compareGraphBulletBorderThickness;
    }

    public StockGraph setCompareGraphBulletBorderThickness(Integer compareGraphBulletBorderThickness) {
        this.compareGraphBulletBorderThickness = compareGraphBulletBorderThickness;
        return this;
    }

    public Color getCompareGraphBulletColor() {
        return compareGraphBulletColor;
    }

    public StockGraph setCompareGraphBulletColor(Color compareGraphBulletColor) {
        this.compareGraphBulletColor = compareGraphBulletColor;
        return this;
    }

    public Integer getCompareGraphBulletSize() {
        return compareGraphBulletSize;
    }

    public StockGraph setCompareGraphBulletSize(Integer compareGraphBulletSize) {
        this.compareGraphBulletSize = compareGraphBulletSize;
        return this;
    }

    public Integer getCompareGraphCornerRadiusTop() {
        return compareGraphCornerRadiusTop;
    }

    public StockGraph setCompareGraphCornerRadiusTop(Integer compareGraphCornerRadiusTop) {
        this.compareGraphCornerRadiusTop = compareGraphCornerRadiusTop;
        return this;
    }

    public Integer getCompareGraphDashLength() {
        return compareGraphDashLength;
    }

    public StockGraph setCompareGraphDashLength(Integer compareGraphDashLength) {
        this.compareGraphDashLength = compareGraphDashLength;
        return this;
    }

    public Double getCompareGraphFillAlphas() {
        return compareGraphFillAlphas;
    }

    public StockGraph setCompareGraphFillAlphas(Double compareGraphFillAlphas) {
        this.compareGraphFillAlphas = compareGraphFillAlphas;
        return this;
    }

    public Color getCompareGraphFillColors() {
        return compareGraphFillColors;
    }

    public StockGraph setCompareGraphFillColors(Color compareGraphFillColors) {
        this.compareGraphFillColors = compareGraphFillColors;
        return this;
    }

    public Double getCompareGraphLineAlpha() {
        return compareGraphLineAlpha;
    }

    public StockGraph setCompareGraphLineAlpha(Double compareGraphLineAlpha) {
        this.compareGraphLineAlpha = compareGraphLineAlpha;
        return this;
    }

    public Color getCompareGraphLineColor() {
        return compareGraphLineColor;
    }

    public StockGraph setCompareGraphLineColor(Color compareGraphLineColor) {
        this.compareGraphLineColor = compareGraphLineColor;
        return this;
    }

    public Integer getCompareGraphLineThickness() {
        return compareGraphLineThickness;
    }

    public StockGraph setCompareGraphLineThickness(Integer compareGraphLineThickness) {
        this.compareGraphLineThickness = compareGraphLineThickness;
        return this;
    }

    public GraphType getCompareGraphType() {
        return compareGraphType;
    }

    public StockGraph setCompareGraphType(GraphType compareGraphType) {
        this.compareGraphType = compareGraphType;
        return this;
    }

    public Boolean getCompareGraphVisibleInLegend() {
        return compareGraphVisibleInLegend;
    }

    public StockGraph setCompareGraphVisibleInLegend(Boolean compareGraphVisibleInLegend) {
        this.compareGraphVisibleInLegend = compareGraphVisibleInLegend;
        return this;
    }

    public StockGraphValue getPeriodValue() {
        return periodValue;
    }

    public StockGraph setPeriodValue(StockGraphValue periodValue) {
        this.periodValue = periodValue;
        return this;
    }

    public StockGraphValue getRecalculateValue() {
        return recalculateValue;
    }

    public StockGraph setRecalculateValue(StockGraphValue recalculateValue) {
        this.recalculateValue = recalculateValue;
        return this;
    }

    public Boolean getShowEventsOnComparedGraphs() {
        return showEventsOnComparedGraphs;
    }

    public StockGraph setShowEventsOnComparedGraphs(Boolean showEventsOnComparedGraphs) {
        this.showEventsOnComparedGraphs = showEventsOnComparedGraphs;
        return this;
    }

    public Boolean getUseDataSetColors() {
        return useDataSetColors;
    }

    public StockGraph setUseDataSetColors(Boolean useDataSetColors) {
        this.useDataSetColors = useDataSetColors;
        return this;
    }

    @Override
    public List<String> getWiredFields() {
        List<String> wiredFields = new ArrayList<>(super.getWiredFields());

        if (StringUtils.isNotEmpty(getCompareField())) {
            wiredFields.add(getCompareField());
        }

        return wiredFields;
    }
}
