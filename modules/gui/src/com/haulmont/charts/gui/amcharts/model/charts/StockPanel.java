/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.cuba.core.global.UuidProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * See documentation for properties of StockPanel JS object. <br/>
 *
 * <a href="http://docs.amcharts.com/3/javascriptstockchart/StockPanel">http://docs.amcharts.com/3/javascriptstockchart/StockPanel</a>
 *
 * @author gorelov
 * @version $Id$
 */
public class StockPanel extends AbstractSerialChart<StockPanel> {

    private static final long serialVersionUID = 3129940127141352054L;

    private String id;
    
    private Boolean allowTurningOff;

    private Boolean drawingIconsEnabled;

    private ValueAxis drawOnAxis;

    private Boolean eraseAll;

    private Integer iconSize;

    private Integer percentHeight;

    private Date recalculateFromDate;

    private String recalculateToPercents;

    private Boolean showCategoryAxis;

    private Boolean showComparedOnTop;

    private List<StockGraph> stockGraphs;

    private StockLegend stockLegend;

    private String title;

    private Double trendLineAlpha;

    private Color trendLineColor;

    private Integer trendLineDashLength;

    private Integer trendLineThickness;

    public StockPanel() {
        super(null);
        this.id = UuidProvider.createUuid().toString();
    }

    public String getId() {
        return id;
    }

    public StockPanel setId(String id) {
        this.id = id;
        return this;
    }

    public Boolean getAllowTurningOff() {
        return allowTurningOff;
    }

    public StockPanel setAllowTurningOff(Boolean allowTurningOff) {
        this.allowTurningOff = allowTurningOff;
        return this;
    }

    public Boolean getDrawingIconsEnabled() {
        return drawingIconsEnabled;
    }

    public StockPanel setDrawingIconsEnabled(Boolean drawingIconsEnabled) {
        this.drawingIconsEnabled = drawingIconsEnabled;
        return this;
    }

    public ValueAxis getDrawOnAxis() {
        return drawOnAxis;
    }

    public StockPanel setDrawOnAxis(ValueAxis drawOnAxis) {
        this.drawOnAxis = drawOnAxis;
        return this;
    }

    public Boolean getEraseAll() {
        return eraseAll;
    }

    public StockPanel setEraseAll(Boolean eraseAll) {
        this.eraseAll = eraseAll;
        return this;
    }

    public Integer getIconSize() {
        return iconSize;
    }

    public StockPanel setIconSize(Integer iconSize) {
        this.iconSize = iconSize;
        return this;
    }

    public Integer getPercentHeight() {
        return percentHeight;
    }

    public StockPanel setPercentHeight(Integer percentHeight) {
        this.percentHeight = percentHeight;
        return this;
    }

    public Date getRecalculateFromDate() {
        return recalculateFromDate;
    }

    public StockPanel setRecalculateFromDate(Date recalculateFromDate) {
        this.recalculateFromDate = recalculateFromDate;
        return this;
    }

    public String getRecalculateToPercents() {
        return recalculateToPercents;
    }

    public StockPanel setRecalculateToPercents(String recalculateToPercents) {
        this.recalculateToPercents = recalculateToPercents;
        return this;
    }

    public Boolean getShowCategoryAxis() {
        return showCategoryAxis;
    }

    public StockPanel setShowCategoryAxis(Boolean showCategoryAxis) {
        this.showCategoryAxis = showCategoryAxis;
        return this;
    }

    public Boolean getShowComparedOnTop() {
        return showComparedOnTop;
    }

    public StockPanel setShowComparedOnTop(Boolean showComparedOnTop) {
        this.showComparedOnTop = showComparedOnTop;
        return this;
    }

    public List<StockGraph> getStockGraphs() {
        return stockGraphs;
    }

    public StockPanel setStockGraphs(List<StockGraph> stockGraphs) {
        this.stockGraphs = stockGraphs;
        return this;
    }

    public StockPanel addStockGraphs(StockGraph... stockGraphs) {
        if (stockGraphs != null) {
            if (this.stockGraphs == null) {
                this.stockGraphs = new ArrayList<>();
            }
            this.stockGraphs.addAll(Arrays.asList(stockGraphs));
        }
        return this;
    }

    public StockLegend getStockLegend() {
        return stockLegend;
    }

    public StockPanel setStockLegend(StockLegend stockLegend) {
        this.stockLegend = stockLegend;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public StockPanel setTitle(String title) {
        this.title = title;
        return this;
    }

    public Double getTrendLineAlpha() {
        return trendLineAlpha;
    }

    public StockPanel setTrendLineAlpha(Double trendLineAlpha) {
        this.trendLineAlpha = trendLineAlpha;
        return this;
    }

    public Color getTrendLineColor() {
        return trendLineColor;
    }

    public StockPanel setTrendLineColor(Color trendLineColor) {
        this.trendLineColor = trendLineColor;
        return this;
    }

    public Integer getTrendLineDashLength() {
        return trendLineDashLength;
    }

    public StockPanel setTrendLineDashLength(Integer trendLineDashLength) {
        this.trendLineDashLength = trendLineDashLength;
        return this;
    }

    public Integer getTrendLineThickness() {
        return trendLineThickness;
    }

    public StockPanel setTrendLineThickness(Integer trendLineThickness) {
        this.trendLineThickness = trendLineThickness;
        return this;
    }

    @Override
    public List<String> getWiredFields() {
        List<String> wiredFields = new ArrayList<>(super.getWiredFields());

        if (stockGraphs != null) {
            for (StockGraph g : stockGraphs) {
                wiredFields.addAll(g.getWiredFields());
            }
        }

        return wiredFields;
    }
}
