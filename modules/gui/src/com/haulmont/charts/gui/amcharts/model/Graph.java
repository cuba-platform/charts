/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author artamonov
 * @version $Id$
 */
public class Graph extends AbstractConfigurationObject {

    private static final long serialVersionUID = 3973480345155361978L;

    private String alphaField;

    private Color balloonColor;

    private JsFunction balloonFunction;

    private String balloonText;

    private Boolean behindColumns;

    private BulletType bullet;

    private Double bulletAlpha;

    private String bulletAxis;

    private Double bulletBorderAlpha;

    private Color bulletBorderColor;

    private Integer bulletBorderThickness;

    private Color bulletColor;

    private String bulletField;

    private Integer bulletOffset;

    private Integer bulletSize;

    private String bulletSizeField;

    private String closeField;

    private Boolean clustered;

    private Color color;

    private String colorField;

    private Integer columnWidth;

    private Boolean connect;

    private Integer cornerRadiusTop;

    private Double cursorBulletAlpha;

    private String customBullet;

    private String customBulletField;

    private String customMarker;

    private Integer dashLength;

    private String dashLengthField;

    private String descriptionField;

    private String errorField;

    private Double fillAlphas;

    private Color fillColors;

    private String fillColorsField;

    private String fillToGraph;

    private Integer fontSize;

    private GradientOrientation gradientOrientation;

    private Boolean hidden;

    private Integer hideBulletsCount;

    private String highField;

    private String id;

    private Boolean includeInMinMax;

    private String labelColorField;

    private ValueLabelPosition labelPosition;

    private String labelText;

    private Double legendAlpha;

    private Color legendColor;

    private String legendPeriodValueText;

    private String legendValueText;

    private Double lineAlpha;

    private Color lineColor;

    private String lineColorField;

    private Integer lineThickness;

    private String lowField;

    private MarkerType markerType;

    private Integer maxBulletSize;

    private Integer minBulletSize;

    private Double negativeBase;

    private Double negativeFillAlphas;

    private Color negativeFillColors;

    private Double negativeLineAlpha;

    private Color negativeLineColor;

    private Boolean noStepRisers;

    private NumberFormatter numberFormatter;

    private String openField;

    private Pattern pattern;

    private String patternField;

    private Integer periodSpan;

    private PointPosition pointPosition;

    private Boolean showAllValueLabels;

    private Boolean showBalloon;

    private BalloonShowPosition showBalloonAt;

    private Boolean showHandOnHover;

    private Boolean stackable;

    private StepDirection stepDirection;

    private String title;

    private GraphType type;

    private String urlField;

    private String urlTarget;

    private Boolean useLineColorForBulletBorder;

    private String valueAxis;

    private String valueField;

    private Boolean visibleInLegend;

    private String xAxis;

    private String xField;

    private String yAxis;

    private String yField;

    public String getTitle() {
        return title;
    }

    public Graph setTitle(String title) {
        this.title = title;
        return this;
    }

    public GraphType getType() {
        return type;
    }

    public Graph setType(GraphType type) {
        this.type = type;
        return this;
    }

    public String getValueField() {
        return valueField;
    }

    public Graph setValueField(String valueField) {
        this.valueField = valueField;
        return this;
    }

    public String getXField() {
        return xField;
    }

    public Graph setXField(String xField) {
        this.xField = xField;
        return this;
    }

    public String getYField() {
        return yField;
    }

    public Graph setYField(String yField) {
        this.yField = yField;
        return this;
    }

    public String getAlphaField() {
        return alphaField;
    }

    public Graph setAlphaField(String alphaField) {
        this.alphaField = alphaField;
        return this;
    }

    public Color getBalloonColor() {
        return balloonColor;
    }

    public Graph setBalloonColor(Color balloonColor) {
        this.balloonColor = balloonColor;
        return this;
    }

    public String getBalloonText() {
        return balloonText;
    }

    public Graph setBalloonText(String balloonText) {
        this.balloonText = balloonText;
        return this;
    }

    public Boolean getBehindColumns() {
        return behindColumns;
    }

    public Graph setBehindColumns(Boolean behindColumns) {
        this.behindColumns = behindColumns;
        return this;
    }

    public BulletType getBullet() {
        return bullet;
    }

    public Graph setBullet(BulletType bullet) {
        this.bullet = bullet;
        return this;
    }

    public Double getBulletAlpha() {
        return bulletAlpha;
    }

    public Graph setBulletAlpha(Double bulletAlpha) {
        this.bulletAlpha = bulletAlpha;
        return this;
    }

    public Double getBulletBorderAlpha() {
        return bulletBorderAlpha;
    }

    public Graph setBulletBorderAlpha(Double bulletBorderAlpha) {
        this.bulletBorderAlpha = bulletBorderAlpha;
        return this;
    }

    public Color getBulletBorderColor() {
        return bulletBorderColor;
    }

    public Graph setBulletBorderColor(Color bulletBorderColor) {
        this.bulletBorderColor = bulletBorderColor;
        return this;
    }

    public Integer getBulletBorderThickness() {
        return bulletBorderThickness;
    }

    public Graph setBulletBorderThickness(Integer bulletBorderThickness) {
        this.bulletBorderThickness = bulletBorderThickness;
        return this;
    }

    public Color getBulletColor() {
        return bulletColor;
    }

    public Graph setBulletColor(Color bulletColor) {
        this.bulletColor = bulletColor;
        return this;
    }

    public String getBulletField() {
        return bulletField;
    }

    public Graph setBulletField(String bulletField) {
        this.bulletField = bulletField;
        return this;
    }

    public Integer getBulletOffset() {
        return bulletOffset;
    }

    public Graph setBulletOffset(Integer bulletOffset) {
        this.bulletOffset = bulletOffset;
        return this;
    }

    public Integer getBulletSize() {
        return bulletSize;
    }

    public Graph setBulletSize(Integer bulletSize) {
        this.bulletSize = bulletSize;
        return this;
    }

    public String getBulletSizeField() {
        return bulletSizeField;
    }

    public Graph setBulletSizeField(String bulletSizeField) {
        this.bulletSizeField = bulletSizeField;
        return this;
    }

    public String getCloseField() {
        return closeField;
    }

    public Graph setCloseField(String closeField) {
        this.closeField = closeField;
        return this;
    }

    public Boolean getClustered() {
        return clustered;
    }

    public Graph setClustered(Boolean clustered) {
        this.clustered = clustered;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public Graph setColor(Color color) {
        this.color = color;
        return this;
    }

    public String getColorField() {
        return colorField;
    }

    public Graph setColorField(String colorField) {
        this.colorField = colorField;
        return this;
    }

    public Integer getColumnWidth() {
        return columnWidth;
    }

    public Graph setColumnWidth(Integer columnWidth) {
        this.columnWidth = columnWidth;
        return this;
    }

    public Boolean getConnect() {
        return connect;
    }

    public Graph setConnect(Boolean connect) {
        this.connect = connect;
        return this;
    }

    public Integer getCornerRadiusTop() {
        return cornerRadiusTop;
    }

    public Graph setCornerRadiusTop(Integer cornerRadiusTop) {
        this.cornerRadiusTop = cornerRadiusTop;
        return this;
    }

    public Double getCursorBulletAlpha() {
        return cursorBulletAlpha;
    }

    public Graph setCursorBulletAlpha(Double cursorBulletAlpha) {
        this.cursorBulletAlpha = cursorBulletAlpha;
        return this;
    }

    public String getCustomBullet() {
        return customBullet;
    }

    public Graph setCustomBullet(String customBullet) {
        this.customBullet = customBullet;
        return this;
    }

    public String getCustomBulletField() {
        return customBulletField;
    }

    public Graph setCustomBulletField(String customBulletField) {
        this.customBulletField = customBulletField;
        return this;
    }

    public String getCustomMarker() {
        return customMarker;
    }

    public Graph setCustomMarker(String customMarker) {
        this.customMarker = customMarker;
        return this;
    }

    public Integer getDashLength() {
        return dashLength;
    }

    public Graph setDashLength(Integer dashLength) {
        this.dashLength = dashLength;
        return this;
    }

    public String getDashLengthField() {
        return dashLengthField;
    }

    public Graph setDashLengthField(String dashLengthField) {
        this.dashLengthField = dashLengthField;
        return this;
    }

    public String getDescriptionField() {
        return descriptionField;
    }

    public Graph setDescriptionField(String descriptionField) {
        this.descriptionField = descriptionField;
        return this;
    }

    public String getErrorField() {
        return errorField;
    }

    public Graph setErrorField(String errorField) {
        this.errorField = errorField;
        return this;
    }

    public Double getFillAlphas() {
        return fillAlphas;
    }

    public Graph setFillAlphas(Double fillAlphas) {
        this.fillAlphas = fillAlphas;
        return this;
    }

    public Color getFillColors() {
        return fillColors;
    }

    public Graph setFillColors(Color fillColors) {
        this.fillColors = fillColors;
        return this;
    }

    public String getFillColorsField() {
        return fillColorsField;
    }

    public Graph setFillColorsField(String fillColorsField) {
        this.fillColorsField = fillColorsField;
        return this;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public Graph setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    public GradientOrientation getGradientOrientation() {
        return gradientOrientation;
    }

    public Graph setGradientOrientation(GradientOrientation gradientOrientation) {
        this.gradientOrientation = gradientOrientation;
        return this;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public Graph setHidden(Boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    public Integer getHideBulletsCount() {
        return hideBulletsCount;
    }

    public Graph setHideBulletsCount(Integer hideBulletsCount) {
        this.hideBulletsCount = hideBulletsCount;
        return this;
    }

    public String getHighField() {
        return highField;
    }

    public Graph setHighField(String highField) {
        this.highField = highField;
        return this;
    }

    public String getId() {
        return id;
    }

    public Graph setId(String id) {
        this.id = id;
        return this;
    }

    public Boolean getIncludeInMinMax() {
        return includeInMinMax;
    }

    public Graph setIncludeInMinMax(Boolean includeInMinMax) {
        this.includeInMinMax = includeInMinMax;
        return this;
    }

    public String getLabelColorField() {
        return labelColorField;
    }

    public Graph setLabelColorField(String labelColorField) {
        this.labelColorField = labelColorField;
        return this;
    }

    public ValueLabelPosition getLabelPosition() {
        return labelPosition;
    }

    public Graph setLabelPosition(ValueLabelPosition labelPosition) {
        this.labelPosition = labelPosition;
        return this;
    }

    public String getLabelText() {
        return labelText;
    }

    public Graph setLabelText(String labelText) {
        this.labelText = labelText;
        return this;
    }

    public Double getLegendAlpha() {
        return legendAlpha;
    }

    public Graph setLegendAlpha(Double legendAlpha) {
        this.legendAlpha = legendAlpha;
        return this;
    }

    public Color getLegendColor() {
        return legendColor;
    }

    public Graph setLegendColor(Color legendColor) {
        this.legendColor = legendColor;
        return this;
    }

    public String getLegendPeriodValueText() {
        return legendPeriodValueText;
    }

    public Graph setLegendPeriodValueText(String legendPeriodValueText) {
        this.legendPeriodValueText = legendPeriodValueText;
        return this;
    }

    public String getLegendValueText() {
        return legendValueText;
    }

    public Graph setLegendValueText(String legendValueText) {
        this.legendValueText = legendValueText;
        return this;
    }

    public Double getLineAlpha() {
        return lineAlpha;
    }

    public Graph setLineAlpha(Double lineAlpha) {
        this.lineAlpha = lineAlpha;
        return this;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public Graph setLineColor(Color lineColor) {
        this.lineColor = lineColor;
        return this;
    }

    public String getLineColorField() {
        return lineColorField;
    }

    public Graph setLineColorField(String lineColorField) {
        this.lineColorField = lineColorField;
        return this;
    }

    public Integer getLineThickness() {
        return lineThickness;
    }

    public Graph setLineThickness(Integer lineThickness) {
        this.lineThickness = lineThickness;
        return this;
    }

    public String getLowField() {
        return lowField;
    }

    public Graph setLowField(String lowField) {
        this.lowField = lowField;
        return this;
    }

    public MarkerType getMarkerType() {
        return markerType;
    }

    public Graph setMarkerType(MarkerType markerType) {
        this.markerType = markerType;
        return this;
    }

    public Integer getMaxBulletSize() {
        return maxBulletSize;
    }

    public Graph setMaxBulletSize(Integer maxBulletSize) {
        this.maxBulletSize = maxBulletSize;
        return this;
    }

    public Integer getMinBulletSize() {
        return minBulletSize;
    }

    public Graph setMinBulletSize(Integer minBulletSize) {
        this.minBulletSize = minBulletSize;
        return this;
    }

    public Double getNegativeBase() {
        return negativeBase;
    }

    public Graph setNegativeBase(Double negativeBase) {
        this.negativeBase = negativeBase;
        return this;
    }

    public Double getNegativeFillAlphas() {
        return negativeFillAlphas;
    }

    public Graph setNegativeFillAlphas(Double negativeFillAlphas) {
        this.negativeFillAlphas = negativeFillAlphas;
        return this;
    }

    public Color getNegativeFillColors() {
        return negativeFillColors;
    }

    public Graph setNegativeFillColors(Color negativeFillColors) {
        this.negativeFillColors = negativeFillColors;
        return this;
    }

    public Double getNegativeLineAlpha() {
        return negativeLineAlpha;
    }

    public Graph setNegativeLineAlpha(Double negativeLineAlpha) {
        this.negativeLineAlpha = negativeLineAlpha;
        return this;
    }

    public Color getNegativeLineColor() {
        return negativeLineColor;
    }

    public Graph setNegativeLineColor(Color negativeLineColor) {
        this.negativeLineColor = negativeLineColor;
        return this;
    }

    public Boolean getNoStepRisers() {
        return noStepRisers;
    }

    public Graph setNoStepRisers(Boolean noStepRisers) {
        this.noStepRisers = noStepRisers;
        return this;
    }

    public NumberFormatter getNumberFormatter() {
        return numberFormatter;
    }

    public Graph setNumberFormatter(NumberFormatter numberFormatter) {
        this.numberFormatter = numberFormatter;
        return this;
    }

    public String getOpenField() {
        return openField;
    }

    public Graph setOpenField(String openField) {
        this.openField = openField;
        return this;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public Graph setPattern(Pattern pattern) {
        this.pattern = pattern;
        return this;
    }

    public String getPatternField() {
        return patternField;
    }

    public Graph setPatternField(String patternField) {
        this.patternField = patternField;
        return this;
    }

    public Integer getPeriodSpan() {
        return periodSpan;
    }

    public Graph setPeriodSpan(Integer periodSpan) {
        this.periodSpan = periodSpan;
        return this;
    }

    public PointPosition getPointPosition() {
        return pointPosition;
    }

    public Graph setPointPosition(PointPosition pointPosition) {
        this.pointPosition = pointPosition;
        return this;
    }

    public Boolean getShowAllValueLabels() {
        return showAllValueLabels;
    }

    public Graph setShowAllValueLabels(Boolean showAllValueLabels) {
        this.showAllValueLabels = showAllValueLabels;
        return this;
    }

    public Boolean getShowBalloon() {
        return showBalloon;
    }

    public Graph setShowBalloon(Boolean showBalloon) {
        this.showBalloon = showBalloon;
        return this;
    }

    public BalloonShowPosition getShowBalloonAt() {
        return showBalloonAt;
    }

    public Graph setShowBalloonAt(BalloonShowPosition showBalloonAt) {
        this.showBalloonAt = showBalloonAt;
        return this;
    }

    public Boolean getShowHandOnHover() {
        return showHandOnHover;
    }

    public Graph setShowHandOnHover(Boolean showHandOnHover) {
        this.showHandOnHover = showHandOnHover;
        return this;
    }

    public Boolean getStackable() {
        return stackable;
    }

    public Graph setStackable(Boolean stackable) {
        this.stackable = stackable;
        return this;
    }

    public StepDirection getStepDirection() {
        return stepDirection;
    }

    public Graph setStepDirection(StepDirection stepDirection) {
        this.stepDirection = stepDirection;
        return this;
    }

    public String getUrlField() {
        return urlField;
    }

    public Graph setUrlField(String urlField) {
        this.urlField = urlField;
        return this;
    }

    public String getUrlTarget() {
        return urlTarget;
    }

    public Graph setUrlTarget(String urlTarget) {
        this.urlTarget = urlTarget;
        return this;
    }

    public Boolean getUseLineColorForBulletBorder() {
        return useLineColorForBulletBorder;
    }

    public Graph setUseLineColorForBulletBorder(Boolean useLineColorForBulletBorder) {
        this.useLineColorForBulletBorder = useLineColorForBulletBorder;
        return this;
    }

    public Boolean getVisibleInLegend() {
        return visibleInLegend;
    }

    public Graph setVisibleInLegend(Boolean visibleInLegend) {
        this.visibleInLegend = visibleInLegend;
        return this;
    }

    public String getBulletAxis() {
        return bulletAxis;
    }

    public Graph setBulletAxis(String bulletAxis) {
        this.bulletAxis = bulletAxis;
        return this;
    }

    public String getValueAxis() {
        return valueAxis;
    }

    public Graph setValueAxis(String valueAxis) {
        this.valueAxis = valueAxis;
        return this;
    }

    public String getXAxis() {
        return xAxis;
    }

    public Graph setXAxis(String xAxis) {
        this.xAxis = xAxis;
        return this;
    }

    public String getYAxis() {
        return yAxis;
    }

    public Graph setYAxis(String yAxis) {
        this.yAxis = yAxis;
        return this;
    }

    public JsFunction getBalloonFunction() {
        return balloonFunction;
    }

    public Graph setBalloonFunction(JsFunction balloonFunction) {
        this.balloonFunction = balloonFunction;
        return this;
    }

    public String getFillToGraph() {
        return fillToGraph;
    }

    public Graph setFillToGraph(String fillToGraph) {
        this.fillToGraph = fillToGraph;
        return this;
    }
}