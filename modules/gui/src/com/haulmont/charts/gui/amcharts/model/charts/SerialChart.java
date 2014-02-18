/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.CategoryAxis;
import com.haulmont.charts.gui.amcharts.model.ChartType;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * See documentation for properties of AmSerialChart JS object.
 *
 * @author artamonov
 * @version $Id$
 */
public class SerialChart extends RectangularChart<SerialChart> {

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

    private Boolean rotate;

    private Boolean zoomOutOnDataUpdate;

    public SerialChart() {
        super(ChartType.SERIAL);
    }

    public CategoryAxis getCategoryAxis() {
        return categoryAxis;
    }

    public SerialChart setCategoryAxis(CategoryAxis categoryAxis) {
        this.categoryAxis = categoryAxis;
        return this;
    }

    public String getCategoryField() {
        return categoryField;
    }

    public SerialChart setCategoryField(String categoryField) {
        this.categoryField = categoryField;
        return this;
    }

    public String getBalloonDateFormat() {
        return balloonDateFormat;
    }

    public SerialChart setBalloonDateFormat(String balloonDateFormat) {
        this.balloonDateFormat = balloonDateFormat;
        return this;
    }

    public Integer getColumnSpacing3D() {
        return columnSpacing3D;
    }

    public SerialChart setColumnSpacing3D(Integer columnSpacing3D) {
        this.columnSpacing3D = columnSpacing3D;
        return this;
    }

    public Integer getColumnSpacing() {
        return columnSpacing;
    }

    public SerialChart setColumnSpacing(Integer columnSpacing) {
        this.columnSpacing = columnSpacing;
        return this;
    }

    public Double getColumnWidth() {
        return columnWidth;
    }

    public SerialChart setColumnWidth(Double columnWidth) {
        this.columnWidth = columnWidth;
        return this;
    }

    public String getDataDateFormat() {
        return dataDateFormat;
    }

    public SerialChart setDataDateFormat(String dataDateFormat) {
        this.dataDateFormat = dataDateFormat;
        return this;
    }

    public Integer getMaxSelectedSeries() {
        return maxSelectedSeries;
    }

    public SerialChart setMaxSelectedSeries(Integer maxSelectedSeries) {
        this.maxSelectedSeries = maxSelectedSeries;
        return this;
    }

    public Long getMaxSelectedTime() {
        return maxSelectedTime;
    }

    public SerialChart setMaxSelectedTime(Long maxSelectedTime) {
        this.maxSelectedTime = maxSelectedTime;
        return this;
    }

    public Long getMinSelectedTime() {
        return minSelectedTime;
    }

    public SerialChart setMinSelectedTime(Long minSelectedTime) {
        this.minSelectedTime = minSelectedTime;
        return this;
    }

    public Boolean getMouseWheelScrollEnabled() {
        return mouseWheelScrollEnabled;
    }

    public SerialChart setMouseWheelScrollEnabled(Boolean mouseWheelScrollEnabled) {
        this.mouseWheelScrollEnabled = mouseWheelScrollEnabled;
        return this;
    }

    public Boolean getRotate() {
        return rotate;
    }

    public SerialChart setRotate(Boolean rotate) {
        this.rotate = rotate;
        return this;
    }

    public Boolean getZoomOutOnDataUpdate() {
        return zoomOutOnDataUpdate;
    }

    public SerialChart setZoomOutOnDataUpdate(Boolean zoomOutOnDataUpdate) {
        this.zoomOutOnDataUpdate = zoomOutOnDataUpdate;
        return this;
    }

    @Override
    public List<String> getWiredFields() {
        List<String> wiredFields = new ArrayList<>(super.getWiredFields());
        if (StringUtils.isNotEmpty(categoryField)) {
            wiredFields.add(categoryField);
        }
        if (categoryAxis != null && StringUtils.isNotEmpty(categoryAxis.getForceShowField())) {
            wiredFields.add(categoryAxis.getForceShowField());
        }

        return wiredFields;
    }
}