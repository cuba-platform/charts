/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.haulmont.charts.gui.model.JsFunction;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * See documentation for properties of AmGraph JS Object. <br/>
 * <p>
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmGraph">http://docs.amcharts.com/3/javascriptcharts/AmGraph</a>
 *
 */
@SuppressWarnings("unchecked")
public class AbstractGraph<T extends AbstractGraph> extends AbstractChartObject {

    private static final long serialVersionUID = 3973480345155361978L;

    private String accessibleLabel;

    private String alphaField;

    private Boolean animationPlayed;

    private Balloon balloon;

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

    private Integer bulletHitAreaSize;

    private Integer bulletOffset;

    private Integer bulletSize;

    private String bulletSizeField;

    private String classNameField;

    private String closeField;

    private Boolean clustered;

    private Color color;

    private String colorField;

    private String columnIndexField;

    private Double columnWidth;

    private Boolean connect;

    private Integer cornerRadiusTop;

    private Double cursorBulletAlpha;

    private String customBullet;

    private String customBulletField;

    private String customMarker;

    private Integer dashLength;

    private String dashLengthField;

    private DateFormat dateFormat;

    private String descriptionField;

    private String errorField;

    private Double fillAlphas;

    private Color fillColors;

    private String fillColorsField;

    private String fillToAxis;

    private String fillToGraph;

    private Integer fixedColumnWidth;

    private Integer fontSize;

    private String gapField;

    private Double gapPeriod;

    private GradientOrientation gradientOrientation;

    private Boolean hidden;

    private Integer hideBulletsCount;

    private String highField;

    private String id;

    private Boolean includeInMinMax;

    private String labelAnchor;

    private String labelColorField;

    private JsFunction labelFunction;

    private Integer labelOffset;

    private ValueLabelPosition labelPosition;

    private Integer labelRotation;

    private String labelText;

    private Double legendAlpha;

    private Color legendColor;

    private JsFunction legendColorFunction;

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

    private Integer minDistance;

    private Double negativeBase;

    private Double negativeFillAlphas;

    private Color negativeFillColors;

    private Double negativeLineAlpha;

    private Color negativeLineColor;

    private Boolean newStack;

    private Boolean noStepRisers;

    private String openField;

    private Pattern pattern;

    private String patternField;

    private Integer periodSpan;

    private PointPosition pointPosition;

    private Integer precision;

    private Boolean proCandlesticks;

    private Boolean showAllValueLabels;

    private Boolean showBalloon;

    private ShowPositionOnCandle showBalloonAt;

    private ShowPositionOnCandle showBulletsAt;

    private Boolean showHandOnHover;

    private Boolean showOnAxis;

    private Boolean stackable;

    private StepDirection stepDirection;

    private Boolean switchable;

    private Integer tabIndex;

    private String title;

    private Integer topRadius;

    private GraphType type;

    private String urlField;

    private String urlTarget;

    private Boolean useLineColorForBulletBorder;

    private Boolean useNegativeColorIfDown;

    private String valueAxis;

    private String valueField;

    private Boolean visibleInLegend;

    private String xAxis;

    private String xField;

    private String yAxis;

    private String yField;

    public Boolean getAnimationPlayed() {
        return animationPlayed;
    }

    public T setAnimationPlayed(Boolean animationPlayed) {
        this.animationPlayed = animationPlayed;
        return (T) this;
    }

    public String getTitle() {
        return title;
    }

    public T setTitle(String title) {
        this.title = title;
        return (T) this;
    }

    public GraphType getType() {
        return type;
    }

    public T setType(GraphType type) {
        this.type = type;
        return (T) this;
    }

    public String getValueField() {
        return valueField;
    }

    public T setValueField(String valueField) {
        this.valueField = valueField;
        return (T) this;
    }

    public String getXField() {
        return xField;
    }

    public T setXField(String xField) {
        this.xField = xField;
        return (T) this;
    }

    public String getYField() {
        return yField;
    }

    public T setYField(String yField) {
        this.yField = yField;
        return (T) this;
    }

    public String getAlphaField() {
        return alphaField;
    }

    public T setAlphaField(String alphaField) {
        this.alphaField = alphaField;
        return (T) this;
    }

    public Color getBalloonColor() {
        return balloonColor;
    }

    public T setBalloonColor(Color balloonColor) {
        this.balloonColor = balloonColor;
        return (T) this;
    }

    public String getBalloonText() {
        return balloonText;
    }

    public T setBalloonText(String balloonText) {
        this.balloonText = balloonText;
        return (T) this;
    }

    public Boolean getBehindColumns() {
        return behindColumns;
    }

    public T setBehindColumns(Boolean behindColumns) {
        this.behindColumns = behindColumns;
        return (T) this;
    }

    public BulletType getBullet() {
        return bullet;
    }

    public T setBullet(BulletType bullet) {
        this.bullet = bullet;
        return (T) this;
    }

    public Double getBulletAlpha() {
        return bulletAlpha;
    }

    public T setBulletAlpha(Double bulletAlpha) {
        this.bulletAlpha = bulletAlpha;
        return (T) this;
    }

    public Double getBulletBorderAlpha() {
        return bulletBorderAlpha;
    }

    public T setBulletBorderAlpha(Double bulletBorderAlpha) {
        this.bulletBorderAlpha = bulletBorderAlpha;
        return (T) this;
    }

    public Color getBulletBorderColor() {
        return bulletBorderColor;
    }

    public T setBulletBorderColor(Color bulletBorderColor) {
        this.bulletBorderColor = bulletBorderColor;
        return (T) this;
    }

    public Integer getBulletBorderThickness() {
        return bulletBorderThickness;
    }

    public T setBulletBorderThickness(Integer bulletBorderThickness) {
        this.bulletBorderThickness = bulletBorderThickness;
        return (T) this;
    }

    public Color getBulletColor() {
        return bulletColor;
    }

    public T setBulletColor(Color bulletColor) {
        this.bulletColor = bulletColor;
        return (T) this;
    }

    public String getBulletField() {
        return bulletField;
    }

    public T setBulletField(String bulletField) {
        this.bulletField = bulletField;
        return (T) this;
    }

    public Integer getBulletOffset() {
        return bulletOffset;
    }

    public T setBulletOffset(Integer bulletOffset) {
        this.bulletOffset = bulletOffset;
        return (T) this;
    }

    public Integer getBulletSize() {
        return bulletSize;
    }

    public T setBulletSize(Integer bulletSize) {
        this.bulletSize = bulletSize;
        return (T) this;
    }

    public String getBulletSizeField() {
        return bulletSizeField;
    }

    public T setBulletSizeField(String bulletSizeField) {
        this.bulletSizeField = bulletSizeField;
        return (T) this;
    }

    public String getCloseField() {
        return closeField;
    }

    public T setCloseField(String closeField) {
        this.closeField = closeField;
        return (T) this;
    }

    public Boolean getClustered() {
        return clustered;
    }

    public T setClustered(Boolean clustered) {
        this.clustered = clustered;
        return (T) this;
    }

    public Color getColor() {
        return color;
    }

    public T setColor(Color color) {
        this.color = color;
        return (T) this;
    }

    public String getColorField() {
        return colorField;
    }

    public T setColorField(String colorField) {
        this.colorField = colorField;
        return (T) this;
    }

    public Double getColumnWidth() {
        return columnWidth;
    }

    public T setColumnWidth(Double columnWidth) {
        this.columnWidth = columnWidth;
        return (T) this;
    }

    public Boolean getConnect() {
        return connect;
    }

    public T setConnect(Boolean connect) {
        this.connect = connect;
        return (T) this;
    }

    public Integer getCornerRadiusTop() {
        return cornerRadiusTop;
    }

    public T setCornerRadiusTop(Integer cornerRadiusTop) {
        this.cornerRadiusTop = cornerRadiusTop;
        return (T) this;
    }

    public Double getCursorBulletAlpha() {
        return cursorBulletAlpha;
    }

    public T setCursorBulletAlpha(Double cursorBulletAlpha) {
        this.cursorBulletAlpha = cursorBulletAlpha;
        return (T) this;
    }

    public String getCustomBullet() {
        return customBullet;
    }

    public T setCustomBullet(String customBullet) {
        this.customBullet = customBullet;
        return (T) this;
    }

    public String getCustomBulletField() {
        return customBulletField;
    }

    public T setCustomBulletField(String customBulletField) {
        this.customBulletField = customBulletField;
        return (T) this;
    }

    public String getCustomMarker() {
        return customMarker;
    }

    public T setCustomMarker(String customMarker) {
        this.customMarker = customMarker;
        return (T) this;
    }

    public Integer getDashLength() {
        return dashLength;
    }

    public T setDashLength(Integer dashLength) {
        this.dashLength = dashLength;
        return (T) this;
    }

    public String getDashLengthField() {
        return dashLengthField;
    }

    public T setDashLengthField(String dashLengthField) {
        this.dashLengthField = dashLengthField;
        return (T) this;
    }

    public String getDescriptionField() {
        return descriptionField;
    }

    public T setDescriptionField(String descriptionField) {
        this.descriptionField = descriptionField;
        return (T) this;
    }

    public String getErrorField() {
        return errorField;
    }

    public T setErrorField(String errorField) {
        this.errorField = errorField;
        return (T) this;
    }

    public Double getFillAlphas() {
        return fillAlphas;
    }

    public T setFillAlphas(Double fillAlphas) {
        this.fillAlphas = fillAlphas;
        return (T) this;
    }

    public Color getFillColors() {
        return fillColors;
    }

    public T setFillColors(Color fillColors) {
        this.fillColors = fillColors;
        return (T) this;
    }

    public String getFillColorsField() {
        return fillColorsField;
    }

    public T setFillColorsField(String fillColorsField) {
        this.fillColorsField = fillColorsField;
        return (T) this;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public T setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
        return (T) this;
    }

    public GradientOrientation getGradientOrientation() {
        return gradientOrientation;
    }

    public T setGradientOrientation(GradientOrientation gradientOrientation) {
        this.gradientOrientation = gradientOrientation;
        return (T) this;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public T setHidden(Boolean hidden) {
        this.hidden = hidden;
        return (T) this;
    }

    public Integer getHideBulletsCount() {
        return hideBulletsCount;
    }

    public T setHideBulletsCount(Integer hideBulletsCount) {
        this.hideBulletsCount = hideBulletsCount;
        return (T) this;
    }

    public String getHighField() {
        return highField;
    }

    public T setHighField(String highField) {
        this.highField = highField;
        return (T) this;
    }

    public String getId() {
        return id;
    }

    public T setId(String id) {
        this.id = id;
        return (T) this;
    }

    public Boolean getIncludeInMinMax() {
        return includeInMinMax;
    }

    public T setIncludeInMinMax(Boolean includeInMinMax) {
        this.includeInMinMax = includeInMinMax;
        return (T) this;
    }

    public String getLabelColorField() {
        return labelColorField;
    }

    public T setLabelColorField(String labelColorField) {
        this.labelColorField = labelColorField;
        return (T) this;
    }

    public ValueLabelPosition getLabelPosition() {
        return labelPosition;
    }

    public T setLabelPosition(ValueLabelPosition labelPosition) {
        this.labelPosition = labelPosition;
        return (T) this;
    }

    public String getLabelText() {
        return labelText;
    }

    public T setLabelText(String labelText) {
        this.labelText = labelText;
        return (T) this;
    }

    public Double getLegendAlpha() {
        return legendAlpha;
    }

    public T setLegendAlpha(Double legendAlpha) {
        this.legendAlpha = legendAlpha;
        return (T) this;
    }

    public Color getLegendColor() {
        return legendColor;
    }

    public T setLegendColor(Color legendColor) {
        this.legendColor = legendColor;
        return (T) this;
    }

    public String getLegendPeriodValueText() {
        return legendPeriodValueText;
    }

    public T setLegendPeriodValueText(String legendPeriodValueText) {
        this.legendPeriodValueText = legendPeriodValueText;
        return (T) this;
    }

    public String getLegendValueText() {
        return legendValueText;
    }

    public T setLegendValueText(String legendValueText) {
        this.legendValueText = legendValueText;
        return (T) this;
    }

    public Double getLineAlpha() {
        return lineAlpha;
    }

    public T setLineAlpha(Double lineAlpha) {
        this.lineAlpha = lineAlpha;
        return (T) this;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public T setLineColor(Color lineColor) {
        this.lineColor = lineColor;
        return (T) this;
    }

    public String getLineColorField() {
        return lineColorField;
    }

    public T setLineColorField(String lineColorField) {
        this.lineColorField = lineColorField;
        return (T) this;
    }

    public Integer getLineThickness() {
        return lineThickness;
    }

    public T setLineThickness(Integer lineThickness) {
        this.lineThickness = lineThickness;
        return (T) this;
    }

    public String getLowField() {
        return lowField;
    }

    public T setLowField(String lowField) {
        this.lowField = lowField;
        return (T) this;
    }

    public MarkerType getMarkerType() {
        return markerType;
    }

    public T setMarkerType(MarkerType markerType) {
        this.markerType = markerType;
        return (T) this;
    }

    public Integer getMaxBulletSize() {
        return maxBulletSize;
    }

    public T setMaxBulletSize(Integer maxBulletSize) {
        this.maxBulletSize = maxBulletSize;
        return (T) this;
    }

    public Integer getMinBulletSize() {
        return minBulletSize;
    }

    public T setMinBulletSize(Integer minBulletSize) {
        this.minBulletSize = minBulletSize;
        return (T) this;
    }

    public Double getNegativeBase() {
        return negativeBase;
    }

    public T setNegativeBase(Double negativeBase) {
        this.negativeBase = negativeBase;
        return (T) this;
    }

    public Double getNegativeFillAlphas() {
        return negativeFillAlphas;
    }

    public T setNegativeFillAlphas(Double negativeFillAlphas) {
        this.negativeFillAlphas = negativeFillAlphas;
        return (T) this;
    }

    public Color getNegativeFillColors() {
        return negativeFillColors;
    }

    public T setNegativeFillColors(Color negativeFillColors) {
        this.negativeFillColors = negativeFillColors;
        return (T) this;
    }

    public Double getNegativeLineAlpha() {
        return negativeLineAlpha;
    }

    public T setNegativeLineAlpha(Double negativeLineAlpha) {
        this.negativeLineAlpha = negativeLineAlpha;
        return (T) this;
    }

    public Color getNegativeLineColor() {
        return negativeLineColor;
    }

    public T setNegativeLineColor(Color negativeLineColor) {
        this.negativeLineColor = negativeLineColor;
        return (T) this;
    }

    public Boolean getNoStepRisers() {
        return noStepRisers;
    }

    public T setNoStepRisers(Boolean noStepRisers) {
        this.noStepRisers = noStepRisers;
        return (T) this;
    }

    public String getOpenField() {
        return openField;
    }

    public T setOpenField(String openField) {
        this.openField = openField;
        return (T) this;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public T setPattern(Pattern pattern) {
        this.pattern = pattern;
        return (T) this;
    }

    public String getPatternField() {
        return patternField;
    }

    public T setPatternField(String patternField) {
        this.patternField = patternField;
        return (T) this;
    }

    public Integer getPeriodSpan() {
        return periodSpan;
    }

    public T setPeriodSpan(Integer periodSpan) {
        this.periodSpan = periodSpan;
        return (T) this;
    }

    public PointPosition getPointPosition() {
        return pointPosition;
    }

    public T setPointPosition(PointPosition pointPosition) {
        this.pointPosition = pointPosition;
        return (T) this;
    }

    public Boolean getShowAllValueLabels() {
        return showAllValueLabels;
    }

    public T setShowAllValueLabels(Boolean showAllValueLabels) {
        this.showAllValueLabels = showAllValueLabels;
        return (T) this;
    }

    public Boolean getShowBalloon() {
        return showBalloon;
    }

    public T setShowBalloon(Boolean showBalloon) {
        this.showBalloon = showBalloon;
        return (T) this;
    }

    public ShowPositionOnCandle getShowBalloonAt() {
        return showBalloonAt;
    }

    public T setShowBalloonAt(ShowPositionOnCandle showBalloonAt) {
        this.showBalloonAt = showBalloonAt;
        return (T) this;
    }

    public Boolean getShowHandOnHover() {
        return showHandOnHover;
    }

    public T setShowHandOnHover(Boolean showHandOnHover) {
        this.showHandOnHover = showHandOnHover;
        return (T) this;
    }

    public Boolean getStackable() {
        return stackable;
    }

    public T setStackable(Boolean stackable) {
        this.stackable = stackable;
        return (T) this;
    }

    public StepDirection getStepDirection() {
        return stepDirection;
    }

    public T setStepDirection(StepDirection stepDirection) {
        this.stepDirection = stepDirection;
        return (T) this;
    }

    public String getUrlField() {
        return urlField;
    }

    public T setUrlField(String urlField) {
        this.urlField = urlField;
        return (T) this;
    }

    public String getUrlTarget() {
        return urlTarget;
    }

    public T setUrlTarget(String urlTarget) {
        this.urlTarget = urlTarget;
        return (T) this;
    }

    public Boolean getUseNegativeColorIfDown() {
        return useNegativeColorIfDown;
    }

    public T setUseNegativeColorIfDown(Boolean useNegativeColorIfDown) {
        this.useNegativeColorIfDown = useNegativeColorIfDown;
        return (T) this;
    }

    public Boolean getVisibleInLegend() {
        return visibleInLegend;
    }

    public T setVisibleInLegend(Boolean visibleInLegend) {
        this.visibleInLegend = visibleInLegend;
        return (T) this;
    }

    public String getBulletAxis() {
        return bulletAxis;
    }

    public T setBulletAxis(String bulletAxis) {
        this.bulletAxis = bulletAxis;
        return (T) this;
    }

    public String getValueAxis() {
        return valueAxis;
    }

    public T setValueAxis(String valueAxis) {
        this.valueAxis = valueAxis;
        return (T) this;
    }

    public String getXAxis() {
        return xAxis;
    }

    public T setXAxis(String xAxis) {
        this.xAxis = xAxis;
        return (T) this;
    }

    public String getYAxis() {
        return yAxis;
    }

    public T setYAxis(String yAxis) {
        this.yAxis = yAxis;
        return (T) this;
    }

    public JsFunction getBalloonFunction() {
        return balloonFunction;
    }

    public T setBalloonFunction(JsFunction balloonFunction) {
        this.balloonFunction = balloonFunction;
        return (T) this;
    }

    public String getFillToGraph() {
        return fillToGraph;
    }

    public T setFillToGraph(String fillToGraph) {
        this.fillToGraph = fillToGraph;
        return (T) this;
    }

    public String getFillToAxis() {
        return fillToAxis;
    }

    public T setFillToAxis(String fillToAxis) {
        this.fillToAxis = fillToAxis;
        return (T) this;
    }

    public Integer getFixedColumnWidth() {
        return fixedColumnWidth;
    }

    public T setFixedColumnWidth(Integer fixedColumnWidth) {
        this.fixedColumnWidth = fixedColumnWidth;
        return (T) this;
    }

    public String getGapField() {
        return gapField;
    }

    public T setGapField(String gapField) {
        this.gapField = gapField;
        return (T) this;
    }

    public Double getGapPeriod() {
        return gapPeriod;
    }

    public T setGapPeriod(Double gapPeriod) {
        this.gapPeriod = gapPeriod;
        return (T) this;
    }

    public String getLabelAnchor() {
        return labelAnchor;
    }

    public T setLabelAnchor(String labelAnchor) {
        this.labelAnchor = labelAnchor;
        return (T) this;
    }

    public JsFunction getLabelFunction() {
        return labelFunction;
    }

    public T setLabelFunction(JsFunction labelFunction) {
        this.labelFunction = labelFunction;
        return (T) this;
    }

    public Integer getLabelOffset() {
        return labelOffset;
    }

    public T setLabelOffset(Integer labelOffset) {
        this.labelOffset = labelOffset;
        return (T) this;
    }

    public Integer getMinDistance() {
        return minDistance;
    }

    public T setMinDistance(Integer minDistance) {
        this.minDistance = minDistance;
        return (T) this;
    }

    public Boolean getNewStack() {
        return newStack;
    }

    public T setNewStack(Boolean newStack) {
        this.newStack = newStack;
        return (T) this;
    }

    public ShowPositionOnCandle getShowBulletsAt() {
        return showBulletsAt;
    }

    public T setShowBulletsAt(ShowPositionOnCandle showBulletsAt) {
        this.showBulletsAt = showBulletsAt;
        return (T) this;
    }

    public Boolean getShowOnAxis() {
        return showOnAxis;
    }

    public T setShowOnAxis(Boolean showOnAxis) {
        this.showOnAxis = showOnAxis;
        return (T) this;
    }

    public Boolean getSwitchable() {
        return switchable;
    }

    public T setSwitchable(Boolean switchable) {
        this.switchable = switchable;
        return (T) this;
    }

    public Integer getTopRadius() {
        return topRadius;
    }

    public T setTopRadius(Integer topRadius) {
        this.topRadius = topRadius;
        return (T) this;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public T setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
        return (T) this;
    }

    public Integer getLabelRotation() {
        return labelRotation;
    }

    public T setLabelRotation(Integer labelRotation) {
        this.labelRotation = labelRotation;
        return (T) this;
    }

    public Integer getPrecision() {
        return precision;
    }

    public T setPrecision(Integer precision) {
        this.precision = precision;
        return (T) this;
    }

    public Boolean getProCandlesticks() {
        return proCandlesticks;
    }

    public T setProCandlesticks(Boolean proCandlesticks) {
        this.proCandlesticks = proCandlesticks;
        return (T) this;
    }

    public Boolean getUseLineColorForBulletBorder() {
        return useLineColorForBulletBorder;
    }

    public T setUseLineColorForBulletBorder(Boolean useLineColorForBulletBorder) {
        this.useLineColorForBulletBorder = useLineColorForBulletBorder;
        return (T) this;
    }

    public String getAccessibleLabel() {
        return accessibleLabel;
    }

    public T setAccessibleLabel(String accessibleLabel) {
        this.accessibleLabel = accessibleLabel;
        return (T) this;
    }

    public Balloon getBalloon() {
        return balloon;
    }

    public T setBalloon(Balloon balloon) {
        this.balloon = balloon;
        return (T) this;
    }

    public Integer getBulletHitAreaSize() {
        return bulletHitAreaSize;
    }

    public T setBulletHitAreaSize(Integer bulletHitAreaSize) {
        this.bulletHitAreaSize = bulletHitAreaSize;
        return (T) this;
    }

    public String getClassNameField() {
        return classNameField;
    }

    public T setClassNameField(String classNameField) {
        this.classNameField = classNameField;
        return (T) this;
    }

    public List<String> getWiredFields() {
        List<String> wiredFields = new ArrayList<>();

        if (StringUtils.isNotEmpty(getValueField())) {
            wiredFields.add(getValueField());
        }

        if (StringUtils.isNotEmpty(getAlphaField())) {
            wiredFields.add(getAlphaField());
        }

        if (StringUtils.isNotEmpty(getBulletField())) {
            wiredFields.add(getBulletField());
        }

        if (StringUtils.isNotEmpty(getBulletSizeField())) {
            wiredFields.add(getBulletSizeField());
        }

        if (StringUtils.isNotEmpty(getCloseField())) {
            wiredFields.add(getCloseField());
        }

        if (StringUtils.isNotEmpty(getColorField())) {
            wiredFields.add(getColorField());
        }

        if (StringUtils.isNotEmpty(getCustomBulletField())) {
            wiredFields.add(getCustomBulletField());
        }

        if (StringUtils.isNotEmpty(getDashLengthField())) {
            wiredFields.add(getDashLengthField());
        }

        if (StringUtils.isNotEmpty(getDescriptionField())) {
            wiredFields.add(getDescriptionField());
        }

        if (StringUtils.isNotEmpty(getErrorField())) {
            wiredFields.add(getErrorField());
        }

        if (StringUtils.isNotEmpty(getFillColorsField())) {
            wiredFields.add(getFillColorsField());
        }

        if (StringUtils.isNotEmpty(getGapField())) {
            wiredFields.add(getGapField());
        }

        if (StringUtils.isNotEmpty(getHighField())) {
            wiredFields.add(getHighField());
        }

        if (StringUtils.isNotEmpty(getLabelColorField())) {
            wiredFields.add(getLabelColorField());
        }

        if (StringUtils.isNotEmpty(getLineColorField())) {
            wiredFields.add(getLineColorField());
        }

        if (StringUtils.isNotEmpty(getLowField())) {
            wiredFields.add(getLowField());
        }

        if (StringUtils.isNotEmpty(getOpenField())) {
            wiredFields.add(getOpenField());
        }

        if (StringUtils.isNotEmpty(getPatternField())) {
            wiredFields.add(getPatternField());
        }

        if (StringUtils.isNotEmpty(getUrlField())) {
            wiredFields.add(getUrlField());
        }

        if (StringUtils.isNotEmpty(getXField())) {
            wiredFields.add(getXField());
        }

        if (StringUtils.isNotEmpty(getYField())) {
            wiredFields.add(getYField());
        }

        if (StringUtils.isNotEmpty(getClassNameField())) {
            wiredFields.add(getClassNameField());
        }

        return wiredFields;
    }

    public JsFunction getLegendColorFunction() {
        return legendColorFunction;
    }

    public T setLegendColorFunction(JsFunction legendColorFunction) {
        this.legendColorFunction = legendColorFunction;
        return (T) this;
    }

    public Integer getTabIndex() {
        return tabIndex;
    }

    public T setTabIndex(Integer tabIndex) {
        this.tabIndex = tabIndex;
        return (T) this;
    }

    public String getColumnIndexField() {
        return columnIndexField;
    }

    public T setColumnIndexField(String columnIndexField) {
        this.columnIndexField = columnIndexField;
        return (T) this;
    }
}