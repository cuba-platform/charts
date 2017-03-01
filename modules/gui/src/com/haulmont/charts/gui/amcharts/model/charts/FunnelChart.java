/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.ChartType;
import com.haulmont.charts.gui.amcharts.model.FunnelValueRepresentation;
import com.haulmont.charts.gui.amcharts.model.LabelPosition;

/**
 * See documentation for properties of AmFunnelChart JS object. <br>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmFunnelChart">http://docs.amcharts.com/3/javascriptcharts/AmFunnelChart</a>
 */
public class FunnelChart extends SlicedChart<FunnelChart> implements FunnelChartModel<FunnelChart> {

    private static final long serialVersionUID = -8733320599720737456L;

    private Integer angle;

    private String balloonText;

    private String baseWidth;

    private Integer depth3D;

    private LabelPosition labelPosition;

    private String labelText;

    private String neckHeight;

    private String neckWidth;

    private String pullDistance;

    private Boolean rotate;

    private Integer startX;

    private Integer startY;

    private FunnelValueRepresentation valueRepresents;

    public FunnelChart() {
        super(ChartType.FUNNEL);
    }

    @Override
    public String getBalloonText() {
        return balloonText;
    }

    @Override
    public FunnelChart setBalloonText(String balloonText) {
        this.balloonText = balloonText;
        return this;
    }

    @Override
    public String getBaseWidth() {
        return baseWidth;
    }

    @Override
    public FunnelChart setBaseWidth(String baseWidth) {
        this.baseWidth = baseWidth;
        return this;
    }

    @Override
    public LabelPosition getLabelPosition() {
        return labelPosition;
    }

    @Override
    public FunnelChart setLabelPosition(LabelPosition labelPosition) {
        this.labelPosition = labelPosition;
        return this;
    }

    @Override
    public String getLabelText() {
        return labelText;
    }

    @Override
    public FunnelChart setLabelText(String labelText) {
        this.labelText = labelText;
        return this;
    }

    @Override
    public String getNeckHeight() {
        return neckHeight;
    }

    @Override
    public FunnelChart setNeckHeight(String neckHeight) {
        this.neckHeight = neckHeight;
        return this;
    }

    @Override
    public String getNeckWidth() {
        return neckWidth;
    }

    @Override
    public FunnelChart setNeckWidth(String neckWidth) {
        this.neckWidth = neckWidth;
        return this;
    }

    @Override
    public String getPullDistance() {
        return pullDistance;
    }

    @Override
    public FunnelChart setPullDistance(String pullDistance) {
        this.pullDistance = pullDistance;
        return this;
    }

    @Override
    public Integer getStartX() {
        return startX;
    }

    @Override
    public FunnelChart setStartX(Integer startX) {
        this.startX = startX;
        return this;
    }

    @Override
    public Integer getStartY() {
        return startY;
    }

    @Override
    public FunnelChart setStartY(Integer startY) {
        this.startY = startY;
        return this;
    }

    @Override
    public FunnelValueRepresentation getValueRepresents() {
        return valueRepresents;
    }

    @Override
    public FunnelChart setValueRepresents(FunnelValueRepresentation valueRepresents) {
        this.valueRepresents = valueRepresents;
        return this;
    }

    @Override
    public Boolean getRotate() {
        return rotate;
    }

    @Override
    public FunnelChart setRotate(Boolean rotate) {
        this.rotate = rotate;
        return this;
    }

    @Override
    public Integer getAngle() {
        return angle;
    }

    @Override
    public FunnelChart setAngle(Integer angle) {
        this.angle = angle;
        return this;
    }

    @Override
    public Integer getDepth3D() {
        return depth3D;
    }

    @Override
    public FunnelChart setDepth3D(Integer depth3D) {
        this.depth3D = depth3D;
        return this;
    }
}