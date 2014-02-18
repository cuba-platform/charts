/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.amcharts.model.AnimationEffect;
import com.haulmont.charts.gui.amcharts.model.Color;
import com.haulmont.charts.gui.amcharts.model.charts.SlicedChart;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

/**
 * @author artamonov
 * @version $Id$
 */
public abstract class SlicedChartLoader<T extends SlicedChart> extends AbtractChartLoader<T> {

    protected SlicedChartLoader(Context context) {
        super(context);
    }

    @Override
    protected void loadConfiguration(Element element, T chart) {
        super.loadConfiguration(element, chart);

        loadColors(element, chart);
        loadGradientRatios(element, chart);

        String alpha = element.attributeValue("alpha");
        if (StringUtils.isNotEmpty(alpha)) {
            chart.setAlpha(Double.valueOf(alpha));
        }

        String alphaField = element.attributeValue("alphaField");
        if (StringUtils.isNotEmpty(alphaField)) {
            chart.setAlphaField(alphaField);
        }

        String baseColor = element.attributeValue("baseColor");
        if (StringUtils.isNotEmpty(baseColor)) {
            chart.setBaseColor(Color.valueOf(baseColor));
        }

        String brightnessStep = element.attributeValue("brightnessStep");
        if (StringUtils.isNotEmpty(brightnessStep)) {
            chart.setBrightnessStep(Byte.valueOf(brightnessStep));
        }

        String colorField = element.attributeValue("colorField");
        if (StringUtils.isNotEmpty(colorField)) {
            chart.setColorField(colorField);
        }

        String descriptionField = element.attributeValue("descriptionField");
        if (StringUtils.isNotEmpty(descriptionField)) {
            chart.setDescriptionField(descriptionField);
        }

        String groupedAlpha = element.attributeValue("groupedAlpha");
        if (StringUtils.isNotEmpty(groupedAlpha)) {
            chart.setGroupedAlpha(Double.valueOf(groupedAlpha));
        }

        String groupedColor = element.attributeValue("groupedColor");
        if (StringUtils.isNotEmpty(groupedColor)) {
            chart.setGroupedColor(Color.valueOf(groupedColor));
        }

        String groupedDescription = element.attributeValue("groupedDescription");
        if (StringUtils.isNotEmpty(groupedDescription)) {
            chart.setGroupedDescription(loadResourceString(groupedDescription));
        }

        String groupedPulled = element.attributeValue("groupedPulled");
        if (StringUtils.isNotEmpty(groupedPulled)) {
            chart.setGroupedPulled(Boolean.valueOf(groupedPulled));
        }

        String groupedTitle = element.attributeValue("groupedTitle");
        if (StringUtils.isNotEmpty(groupedTitle)) {
            chart.setGroupedTitle(loadResourceString(groupedTitle));
        }

        String groupPercent = element.attributeValue("groupPercent");
        if (StringUtils.isNotEmpty(groupPercent)) {
            chart.setGroupPercent(Double.valueOf(groupPercent));
        }

        String hideLabelsPercent = element.attributeValue("hideLabelsPercent");
        if (StringUtils.isNotEmpty(hideLabelsPercent)) {
            chart.setHideLabelsPercent(Double.valueOf(hideLabelsPercent));
        }

        String hoverAlpha = element.attributeValue("hoverAlpha");
        if (StringUtils.isNotEmpty(hoverAlpha)) {
            chart.setHoverAlpha(Double.valueOf(hoverAlpha));
        }

        String labelsEnabled = element.attributeValue("labelsEnabled");
        if (StringUtils.isNotEmpty(labelsEnabled)) {
            chart.setLabelsEnabled(Boolean.valueOf(labelsEnabled));
        }

        String labelTickAlpha = element.attributeValue("labelTickAlpha");
        if (StringUtils.isNotEmpty(labelTickAlpha)) {
            chart.setLabelTickAlpha(Double.valueOf(labelTickAlpha));
        }

        String labelTickColor = element.attributeValue("labelTickColor");
        if (StringUtils.isNotEmpty(labelTickColor)) {
            chart.setLabelTickColor(Color.valueOf(labelTickColor));
        }

        loadMargins(element, chart);

        String outlineAlpha = element.attributeValue("outlineAlpha");
        if (StringUtils.isNotEmpty(outlineAlpha)) {
            chart.setOutlineAlpha(Double.valueOf(outlineAlpha));
        }

        String outlineColor = element.attributeValue("outlineColor");
        if (StringUtils.isNotEmpty(outlineColor)) {
            chart.setOutlineColor(Color.valueOf(outlineColor));
        }

        String outlineThickness = element.attributeValue("outlineThickness");
        if (StringUtils.isNotEmpty(outlineThickness)) {
            chart.setOutlineThickness(Integer.valueOf(outlineThickness));
        }

        String patternField = element.attributeValue("patternField");
        if (StringUtils.isNotEmpty(patternField)) {
            chart.setPatternField(patternField);
        }

        String pulledField = element.attributeValue("pulledField");
        if (StringUtils.isNotEmpty(pulledField)) {
            chart.setPulledField(pulledField);
        }

        String pullOutDuration = element.attributeValue("pullOutDuration");
        if (StringUtils.isNotEmpty(pullOutDuration)) {
            chart.setPullOutDuration(Integer.valueOf(pullOutDuration));
        }

        String pullOutEffect = element.attributeValue("pullOutEffect");
        if (StringUtils.isNotEmpty(pullOutEffect)) {
            chart.setPullOutEffect(AnimationEffect.valueOf(pullOutEffect));
        }

        String pullOutOnlyOne = element.attributeValue("pullOutOnlyOne");
        if (StringUtils.isNotEmpty(pullOutOnlyOne)) {
            chart.setPullOutOnlyOne(Boolean.valueOf(pullOutOnlyOne));
        }

        String sequencedAnimation = element.attributeValue("sequencedAnimation");
        if (StringUtils.isNotEmpty(sequencedAnimation)) {
            chart.setSequencedAnimation(Boolean.valueOf(sequencedAnimation));
        }

        String startAlpha = element.attributeValue("startAlpha");
        if (StringUtils.isNotEmpty(startAlpha)) {
            chart.setStartAlpha(Double.valueOf(startAlpha));
        }

        loadStartEffect(element, chart);

        String titleField = element.attributeValue("titleField");
        if (StringUtils.isNotEmpty(titleField)) {
            chart.setTitleField(titleField);
        }

        String urlField = element.attributeValue("urlField");
        if (StringUtils.isNotEmpty(urlField)) {
            chart.setUrlField(urlField);
        }

        String urlTarget = element.attributeValue("urlTarget");
        if (StringUtils.isNotEmpty(urlTarget)) {
            chart.setUrlTarget(urlTarget);
        }

        String valueField = element.attributeValue("valueField");
        if (StringUtils.isNotEmpty(valueField)) {
            chart.setValueField(valueField);
        }

        String visibleInLegendField = element.attributeValue("visibleInLegendField");
        if (StringUtils.isNotEmpty(visibleInLegendField)) {
            chart.setVisibleInLegendField(visibleInLegendField);
        }
    }

    protected void loadGradientRatios(Element element, T chart) {
        Element gradientRatiosElement = element.element("gradientRatios");
        if (gradientRatiosElement != null) {
            for (Object ratioItem : gradientRatiosElement.elements("ratio")) {
                Element ratioElement = (Element) ratioItem;

                String value = ratioElement.attributeValue("value");
                if (StringUtils.isNotEmpty(value)) {
                    chart.addGradientRatio(Double.valueOf(value));
                }
            }
        }
    }
}