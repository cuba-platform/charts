/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.*;

import java.util.List;

public interface SlicedChartModel<T extends SlicedChartModel> extends ChartModel<T>, HasMargins<T>, HasStartEffect<T>,
                                                                      HasColors<T> {
    Double getAlpha();
    T setAlpha(Double alpha);

    String getAlphaField();
    T setAlphaField(String alphaField);

    Color getBaseColor();
    T setBaseColor(Color baseColor);

    String getColorField();
    T setColorField(String colorField);

    String getDescriptionField();
    T setDescriptionField(String descriptionField);

    List<Double> getGradientRatio();
    T setGradientRatio(List<Double> gradientRatio);
    T addGradientRatio(Double... ratios);

    Double getGroupedAlpha();
    T setGroupedAlpha(Double groupedAlpha);

    Color getGroupedColor();
    T setGroupedColor(Color groupedColor);

    String getGroupedDescription();
    T setGroupedDescription(String groupedDescription);

    Boolean getGroupedPulled();
    T setGroupedPulled(Boolean groupedPulled);

    String getGroupedTitle();
    T setGroupedTitle(String groupedTitle);

    Double getGroupPercent();
    T setGroupPercent(Double groupPercent);

    Double getHideLabelsPercent();
    T setHideLabelsPercent(Double hideLabelsPercent);

    Double getHoverAlpha();
    T setHoverAlpha(Double hoverAlpha);

    Boolean getLabelsEnabled();
    T setLabelsEnabled(Boolean labelsEnabled);

    Double getLabelTickAlpha();
    T setLabelTickAlpha(Double labelTickAlpha);

    Color getLabelTickColor();
    T setLabelTickColor(Color labelTickColor);

    Double getOutlineAlpha();
    T setOutlineAlpha(Double outlineAlpha);

    Color getOutlineColor();
    T setOutlineColor(Color outlineColor);

    Integer getOutlineThickness();
    T setOutlineThickness(Integer outlineThickness);

    String getPatternField();
    T setPatternField(String patternField);

    String getPulledField();
    T setPulledField(String pulledField);

    Integer getPullOutDuration();
    T setPullOutDuration(Integer pullOutDuration);

    AnimationEffect getPullOutEffect();
    T setPullOutEffect(AnimationEffect pullOutEffect);

    Boolean getPullOutOnlyOne();
    T setPullOutOnlyOne(Boolean pullOutOnlyOne);

    Boolean getSequencedAnimation();
    T setSequencedAnimation(Boolean sequencedAnimation);

    Double getStartAlpha();
    T setStartAlpha(Double startAlpha);

    String getTitleField();
    T setTitleField(String titleField);

    String getUrlField();
    T setUrlField(String urlField);

    String getUrlTarget();
    T setUrlTarget(String urlTarget);

    String getValueField();
    T setValueField(String valueField);

    String getVisibleInLegendField();
    T setVisibleInLegendField(String visibleInLegendField);

    com.haulmont.charts.gui.model.JsFunction getLabelFunction();
    T setLabelFunction(com.haulmont.charts.gui.model.JsFunction labelFunction);

    Integer getMaxLabelWidth();
    T setMaxLabelWidth(Integer maxLabelWidth);

    String getClassNameField();
    T setClassNameField(String classNameField);

    Boolean getShowZeroSlices();
    T setShowZeroSlices(Boolean showZeroSlices);

    String getAccessibleLabel();
    T setAccessibleLabel(String accessibleLabel);

    Color getLabelColorField();
    T setLabelColorField(Color labelColorField);

    Integer getTabIndex();
    T setTabIndex(Integer tabIndex);
}