/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.CategoryAxis;
import com.haulmont.charts.gui.amcharts.model.ChartType;
import com.haulmont.charts.gui.amcharts.model.Scrollbar;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * See documentation for properties of AmSerialChart JS object. <br/>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmSerialChart">http://docs.amcharts.com/3/javascriptcharts/AmSerialChart</a>
 *
 */
@SuppressWarnings("unchecked")
public abstract class AbstractSerialChart<T extends AbstractSerialChart> extends RectangularChart<T> {

    private static final long serialVersionUID = 4097450050182930159L;

    private String balloonDateFormat;

    private CategoryAxis categoryAxis;

    private String categoryField;

    private Integer columnSpacing;

    private Integer columnSpacing3D;

    private Double columnWidth;

    private String dataDateFormat;

    private Integer maxSelectedSeries;

    private Long maxSelectedTime;

    private Long minSelectedTime;

    private Boolean mouseWheelScrollEnabled;

    private Boolean mouseWheelZoomEnabled;

    private Boolean rotate;

    private Boolean synchronizeGrid;

    private Scrollbar valueScrollbar;

    private Boolean zoomOutOnDataUpdate;

    protected AbstractSerialChart(ChartType type) {
        super(type);
    }

    public CategoryAxis getCategoryAxis() {
        return categoryAxis;
    }

    public T setCategoryAxis(CategoryAxis categoryAxis) {
        this.categoryAxis = categoryAxis;
        return (T) this;
    }

    public String getCategoryField() {
        return categoryField;
    }

    public T setCategoryField(String categoryField) {
        this.categoryField = categoryField;
        return (T) this;
    }

    public String getBalloonDateFormat() {
        return balloonDateFormat;
    }

    public T setBalloonDateFormat(String balloonDateFormat) {
        this.balloonDateFormat = balloonDateFormat;
        return (T) this;
    }

    public Integer getColumnSpacing3D() {
        return columnSpacing3D;
    }

    public T setColumnSpacing3D(Integer columnSpacing3D) {
        this.columnSpacing3D = columnSpacing3D;
        return (T) this;
    }

    public Integer getColumnSpacing() {
        return columnSpacing;
    }

    public T setColumnSpacing(Integer columnSpacing) {
        this.columnSpacing = columnSpacing;
        return (T) this;
    }

    public Double getColumnWidth() {
        return columnWidth;
    }

    public T setColumnWidth(Double columnWidth) {
        this.columnWidth = columnWidth;
        return (T) this;
    }

    public String getDataDateFormat() {
        return dataDateFormat;
    }

    public T setDataDateFormat(String dataDateFormat) {
        this.dataDateFormat = dataDateFormat;
        return (T) this;
    }

    public Integer getMaxSelectedSeries() {
        return maxSelectedSeries;
    }

    public T setMaxSelectedSeries(Integer maxSelectedSeries) {
        this.maxSelectedSeries = maxSelectedSeries;
        return (T) this;
    }

    public Long getMaxSelectedTime() {
        return maxSelectedTime;
    }

    public T setMaxSelectedTime(Long maxSelectedTime) {
        this.maxSelectedTime = maxSelectedTime;
        return (T) this;
    }

    public Long getMinSelectedTime() {
        return minSelectedTime;
    }

    public T setMinSelectedTime(Long minSelectedTime) {
        this.minSelectedTime = minSelectedTime;
        return (T) this;
    }

    public Boolean getMouseWheelScrollEnabled() {
        return mouseWheelScrollEnabled;
    }

    public T setMouseWheelScrollEnabled(Boolean mouseWheelScrollEnabled) {
        this.mouseWheelScrollEnabled = mouseWheelScrollEnabled;
        return (T) this;
    }

    public Boolean getRotate() {
        return rotate;
    }

    public T setRotate(Boolean rotate) {
        this.rotate = rotate;
        return (T) this;
    }

    public Boolean getZoomOutOnDataUpdate() {
        return zoomOutOnDataUpdate;
    }

    public T setZoomOutOnDataUpdate(Boolean zoomOutOnDataUpdate) {
        this.zoomOutOnDataUpdate = zoomOutOnDataUpdate;
        return (T) this;
    }

    public Boolean getMouseWheelZoomEnabled() {
        return mouseWheelZoomEnabled;
    }

    public T setMouseWheelZoomEnabled(Boolean mouseWheelZoomEnabled) {
        this.mouseWheelZoomEnabled = mouseWheelZoomEnabled;
        return (T) this;
    }

    public Scrollbar getValueScrollbar() {
        return valueScrollbar;
    }

    public T setValueScrollbar(Scrollbar valueScrollbar) {
        this.valueScrollbar = valueScrollbar;
        return (T) this;
    }

    @Override
    public List<String> getWiredFields() {
        List<String> wiredFields = new ArrayList<>(super.getWiredFields());
        if (StringUtils.isNotEmpty(categoryField)) {
            wiredFields.add(categoryField);
        }
        if (categoryAxis != null) {
            if (StringUtils.isNotEmpty(categoryAxis.getForceShowField())) {
                wiredFields.add(categoryAxis.getForceShowField());
            }

            if (StringUtils.isNotEmpty(categoryAxis.getLabelColorField())) {
                wiredFields.add(categoryAxis.getLabelColorField());
            }
        }

        return wiredFields;
    }

    public Boolean getSynchronizeGrid() {
        return synchronizeGrid;
    }

    public T setSynchronizeGrid(Boolean synchronizeGrid) {
        this.synchronizeGrid = synchronizeGrid;
        return (T) this;
    }
}