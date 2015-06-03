/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.*;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * See documentation for properties of AmSlicedChart JS object. <br/>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmSlicedChart">http://docs.amcharts.com/3/javascriptcharts/AmSlicedChart</a>
 *
 * @author artamonov
 * @version $Id$
 */
@SuppressWarnings("unchecked")
public abstract class SlicedChart<T extends SlicedChart> extends AbstractChart<T>
        implements HasMargins<T>, HasStartEffect<T>, HasColors<T> {

    private Double alpha;

    private String alphaField;

    private Color baseColor;

    private Byte brightnessStep;

    private String colorField;

    private List<Color> colors;

    private String descriptionField;

    private List<Double> gradientRatio;

    private Double groupedAlpha;

    private Color groupedColor;

    private String groupedDescription;

    private Boolean groupedPulled;

    private String groupedTitle;

    private Double groupPercent;

    private Double hideLabelsPercent;

    private Double hoverAlpha;

    private JsFunction labelFunction;

    private Boolean labelsEnabled;

    private Double labelTickAlpha;

    private Color labelTickColor;

    private Integer marginBottom;

    private Integer marginLeft;

    private Integer marginRight;

    private Integer marginTop;

    private Integer maxLabelWidth;

    private Double outlineAlpha;

    private Color outlineColor;

    private Integer outlineThickness;

    private String patternField;

    private String pulledField;

    private Integer pullOutDuration;

    private AnimationEffect pullOutEffect;

    private Boolean pullOutOnlyOne;

    private Boolean sequencedAnimation;

    private Double startAlpha;

    private Integer startDuration;

    private AnimationEffect startEffect;

    private String titleField;

    private String urlField;

    private String urlTarget;

    private String valueField;

    private String visibleInLegendField;

    public SlicedChart(ChartType type) {
        super(type);
    }

    public Double getAlpha() {
        return alpha;
    }

    public T setAlpha(Double alpha) {
        this.alpha = alpha;
        return (T) this;
    }

    public String getAlphaField() {
        return alphaField;
    }

    public T setAlphaField(String alphaField) {
        this.alphaField = alphaField;
        return (T) this;
    }

    public Color getBaseColor() {
        return baseColor;
    }

    public T setBaseColor(Color baseColor) {
        this.baseColor = baseColor;
        return (T) this;
    }

    public Byte getBrightnessStep() {
        return brightnessStep;
    }

    public T setBrightnessStep(Byte brightnessStep) {
        this.brightnessStep = brightnessStep;
        return (T) this;
    }

    public String getColorField() {
        return colorField;
    }

    public T setColorField(String colorField) {
        this.colorField = colorField;
        return (T) this;
    }

    @Override
    public List<Color> getColors() {
        return colors;
    }

    @Override
    public T setColors(List<Color> colors) {
        this.colors = colors;
        return (T) this;
    }

    public T addColors(Color... colors) {
        if (colors != null) {
            if (this.colors == null) {
                this.colors = new ArrayList<>();
            }
            this.colors.addAll(Arrays.asList(colors));
        }
        return (T) this;
    }

    public String getDescriptionField() {
        return descriptionField;
    }

    public T setDescriptionField(String descriptionField) {
        this.descriptionField = descriptionField;
        return (T) this;
    }

    public List<Double> getGradientRatio() {
        return gradientRatio;
    }

    public T setGradientRatio(List<Double> gradientRatio) {
        this.gradientRatio = gradientRatio;
        return (T) this;
    }

    public T addGradientRatio(Double... ratios) {
        if (gradientRatio != null) {
            if (this.gradientRatio == null) {
                this.gradientRatio = new ArrayList<>();
            }
            this.gradientRatio.addAll(Arrays.asList(ratios));
        }
        return (T) this;
    }

    public Double getGroupedAlpha() {
        return groupedAlpha;
    }

    public T setGroupedAlpha(Double groupedAlpha) {
        this.groupedAlpha = groupedAlpha;
        return (T) this;
    }

    public Color getGroupedColor() {
        return groupedColor;
    }

    public T setGroupedColor(Color groupedColor) {
        this.groupedColor = groupedColor;
        return (T) this;
    }

    public String getGroupedDescription() {
        return groupedDescription;
    }

    public T setGroupedDescription(String groupedDescription) {
        this.groupedDescription = groupedDescription;
        return (T) this;
    }

    public Boolean getGroupedPulled() {
        return groupedPulled;
    }

    public T setGroupedPulled(Boolean groupedPulled) {
        this.groupedPulled = groupedPulled;
        return (T) this;
    }

    public String getGroupedTitle() {
        return groupedTitle;
    }

    public T setGroupedTitle(String groupedTitle) {
        this.groupedTitle = groupedTitle;
        return (T) this;
    }

    public Double getGroupPercent() {
        return groupPercent;
    }

    public T setGroupPercent(Double groupPercent) {
        this.groupPercent = groupPercent;
        return (T) this;
    }

    public Double getHideLabelsPercent() {
        return hideLabelsPercent;
    }

    public T setHideLabelsPercent(Double hideLabelsPercent) {
        this.hideLabelsPercent = hideLabelsPercent;
        return (T) this;
    }

    public Double getHoverAlpha() {
        return hoverAlpha;
    }

    public T setHoverAlpha(Double hoverAlpha) {
        this.hoverAlpha = hoverAlpha;
        return (T) this;
    }

    public Boolean getLabelsEnabled() {
        return labelsEnabled;
    }

    public T setLabelsEnabled(Boolean labelsEnabled) {
        this.labelsEnabled = labelsEnabled;
        return (T) this;
    }

    public Double getLabelTickAlpha() {
        return labelTickAlpha;
    }

    public T setLabelTickAlpha(Double labelTickAlpha) {
        this.labelTickAlpha = labelTickAlpha;
        return (T) this;
    }

    public Color getLabelTickColor() {
        return labelTickColor;
    }

    public T setLabelTickColor(Color labelTickColor) {
        this.labelTickColor = labelTickColor;
        return (T) this;
    }

    @Override
    public Integer getMarginBottom() {
        return marginBottom;
    }

    @Override
    public T setMarginBottom(Integer marginBottom) {
        this.marginBottom = marginBottom;
        return (T) this;
    }

    @Override
    public Integer getMarginLeft() {
        return marginLeft;
    }

    @Override
    public T setMarginLeft(Integer marginLeft) {
        this.marginLeft = marginLeft;
        return (T) this;
    }

    @Override
    public Integer getMarginRight() {
        return marginRight;
    }

    @Override
    public T setMarginRight(Integer marginRight) {
        this.marginRight = marginRight;
        return (T) this;
    }

    @Override
    public Integer getMarginTop() {
        return marginTop;
    }

    @Override
    public T setMarginTop(Integer marginTop) {
        this.marginTop = marginTop;
        return (T) this;
    }

    public Double getOutlineAlpha() {
        return outlineAlpha;
    }

    public T setOutlineAlpha(Double outlineAlpha) {
        this.outlineAlpha = outlineAlpha;
        return (T) this;
    }

    public Color getOutlineColor() {
        return outlineColor;
    }

    public T setOutlineColor(Color outlineColor) {
        this.outlineColor = outlineColor;
        return (T) this;
    }

    public Integer getOutlineThickness() {
        return outlineThickness;
    }

    public T setOutlineThickness(Integer outlineThickness) {
        this.outlineThickness = outlineThickness;
        return (T) this;
    }

    public String getPatternField() {
        return patternField;
    }

    public T setPatternField(String patternField) {
        this.patternField = patternField;
        return (T) this;
    }

    public String getPulledField() {
        return pulledField;
    }

    public T setPulledField(String pulledField) {
        this.pulledField = pulledField;
        return (T) this;
    }

    public Integer getPullOutDuration() {
        return pullOutDuration;
    }

    public T setPullOutDuration(Integer pullOutDuration) {
        this.pullOutDuration = pullOutDuration;
        return (T) this;
    }

    public AnimationEffect getPullOutEffect() {
        return pullOutEffect;
    }

    public T setPullOutEffect(AnimationEffect pullOutEffect) {
        this.pullOutEffect = pullOutEffect;
        return (T) this;
    }

    public Boolean getPullOutOnlyOne() {
        return pullOutOnlyOne;
    }

    public T setPullOutOnlyOne(Boolean pullOutOnlyOne) {
        this.pullOutOnlyOne = pullOutOnlyOne;
        return (T) this;
    }

    public Boolean getSequencedAnimation() {
        return sequencedAnimation;
    }

    public T setSequencedAnimation(Boolean sequencedAnimation) {
        this.sequencedAnimation = sequencedAnimation;
        return (T) this;
    }

    public Double getStartAlpha() {
        return startAlpha;
    }

    public T setStartAlpha(Double startAlpha) {
        this.startAlpha = startAlpha;
        return (T) this;
    }

    @Override
    public Integer getStartDuration() {
        return startDuration;
    }

    @Override
    public T setStartDuration(Integer startDuration) {
        this.startDuration = startDuration;
        return (T) this;
    }

    @Override
    public AnimationEffect getStartEffect() {
        return startEffect;
    }

    @Override
    public T setStartEffect(AnimationEffect startEffect) {
        this.startEffect = startEffect;
        return (T) this;
    }

    public String getTitleField() {
        return titleField;
    }

    public T setTitleField(String titleField) {
        this.titleField = titleField;
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

    public String getValueField() {
        return valueField;
    }

    public T setValueField(String valueField) {
        this.valueField = valueField;
        return (T) this;
    }

    public String getVisibleInLegendField() {
        return visibleInLegendField;
    }

    public T setVisibleInLegendField(String visibleInLegendField) {
        this.visibleInLegendField = visibleInLegendField;
        return (T) this;
    }

    public JsFunction getLabelFunction() {
        return labelFunction;
    }

    public T setLabelFunction(JsFunction labelFunction) {
        this.labelFunction = labelFunction;
        return (T) this;
    }

    public Integer getMaxLabelWidth() {
        return maxLabelWidth;
    }

    public T setMaxLabelWidth(Integer maxLabelWidth) {
        this.maxLabelWidth = maxLabelWidth;
        return (T) this;
    }

    @Override
    public List<String> getWiredFields() {
        List<String> wiredFields = new ArrayList<>(super.getWiredFields());

        if (StringUtils.isNotEmpty(alphaField)) {
            wiredFields.add(alphaField);
        }

        if (StringUtils.isNotEmpty(colorField)) {
            wiredFields.add(colorField);
        }

        if (StringUtils.isNotEmpty(descriptionField)) {
            wiredFields.add(descriptionField);
        }

        if (StringUtils.isNotEmpty(patternField)) {
            wiredFields.add(patternField);
        }

        if (StringUtils.isNotEmpty(pulledField)) {
            wiredFields.add(pulledField);
        }

        if (StringUtils.isNotEmpty(titleField)) {
            wiredFields.add(titleField);
        }

        if (StringUtils.isNotEmpty(urlField)) {
            wiredFields.add(urlField);
        }

        if (StringUtils.isNotEmpty(valueField)) {
            wiredFields.add(valueField);
        }

        if (StringUtils.isNotEmpty(visibleInLegendField)) {
            wiredFields.add(visibleInLegendField);
        }

        return wiredFields;
    }
}