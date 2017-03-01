/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.charts.amcharts;

import com.haulmont.charts.gui.amcharts.model.AnimationEffect;
import com.haulmont.charts.gui.amcharts.model.Color;
import com.haulmont.charts.gui.components.charts.SlicedChart;
import com.haulmont.charts.gui.model.JsFunction;

import java.util.List;

@SuppressWarnings("unchecked")
public abstract class WebSlicedChart<T extends SlicedChart,
        M extends com.haulmont.charts.gui.amcharts.model.charts.SlicedChart> extends WebChart<T, M> implements SlicedChart<T> {

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.SliceClickListener sliceClickHandler;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.SliceRightClickListener sliceRightClickHandler;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.SlicePullInListener slicePullInHandler;

    protected com.haulmont.charts.web.toolkit.ui.amcharts.events.SlicePullOutListener slicePullOutHandler;

    @Override
    public Double getAlpha() {
        return getModel().getAlpha();
    }

    @Override
    public T setAlpha(Double alpha) {
        getModel().setAlpha(alpha);
        return (T) this;
    }

    @Override
    public String getAlphaField() {
        return getModel().getAlphaField();
    }

    @Override
    public T setAlphaField(String alphaField) {
        getModel().setAlphaField(alphaField);
        return (T) this;
    }

    @Override
    public Color getBaseColor() {
        return getModel().getBaseColor();
    }

    @Override
    public T setBaseColor(Color baseColor) {
        getModel().setBaseColor(baseColor);
        return (T) this;
    }

    @Override
    public String getColorField() {
        return getModel().getColorField();
    }

    @Override
    public T setColorField(String colorField) {
        getModel().setColorField(colorField);
        return (T) this;
    }

    @Override
    public List<Color> getColors() {
        return getModel().getColors();
    }

    @Override
    public T setColors(List list) {
        getModel().setColors(list);
        return (T) this;
    }

    @Override
    public T addColors(Color... colors) {
        getModel().addColors(colors);
        return (T) this;
    }

    @Override
    public String getDescriptionField() {
        return getModel().getDescriptionField();
    }

    @Override
    public T setDescriptionField(String descriptionField) {
        getModel().setDescriptionField(descriptionField);
        return (T) this;
    }

    @Override
    public List<Double> getGradientRatio() {
        return getModel().getGradientRatio();
    }

    @Override
    public T setGradientRatio(List gradientRatio) {
        getModel().setGradientRatio(gradientRatio);
        return (T) this;
    }

    @Override
    public T addGradientRatio(Double... ratios) {
        getModel().addGradientRatio(ratios);
        return (T) this;
    }

    @Override
    public Double getGroupedAlpha() {
        return getModel().getGroupedAlpha();
    }

    @Override
    public T setGroupedAlpha(Double groupedAlpha) {
        getModel().setGroupedAlpha(groupedAlpha);
        return (T) this;
    }

    @Override
    public Color getGroupedColor() {
        return getModel().getGroupedColor();
    }

    @Override
    public T setGroupedColor(Color groupedColor) {
        getModel().setGroupedColor(groupedColor);
        return (T) this;
    }

    @Override
    public String getGroupedDescription() {
        return getModel().getGroupedDescription();
    }

    @Override
    public T setGroupedDescription(String groupedDescription) {
        getModel().setGroupedDescription(groupedDescription);
        return (T) this;
    }

    @Override
    public Boolean getGroupedPulled() {
        return getModel().getGroupedPulled();
    }

    @Override
    public T setGroupedPulled(Boolean groupedPulled) {
        getModel().setGroupedPulled(groupedPulled);
        return (T) this;
    }

    @Override
    public String getGroupedTitle() {
        return getModel().getGroupedTitle();
    }

    @Override
    public T setGroupedTitle(String groupedTitle) {
        getModel().setGroupedTitle(groupedTitle);
        return (T) this;
    }

    @Override
    public Double getGroupPercent() {
        return getModel().getGroupPercent();
    }

    @Override
    public T setGroupPercent(Double groupPercent) {
        getModel().setGroupPercent(groupPercent);
        return (T) this;
    }

    @Override
    public Double getHideLabelsPercent() {
        return getModel().getHideLabelsPercent();
    }

    @Override
    public T setHideLabelsPercent(Double hideLabelsPercent) {
        getModel().setHideLabelsPercent(hideLabelsPercent);
        return (T) this;
    }

    @Override
    public Double getHoverAlpha() {
        return getModel().getHoverAlpha();
    }

    @Override
    public T setHoverAlpha(Double hoverAlpha) {
        getModel().setHoverAlpha(hoverAlpha);
        return (T) this;
    }

    @Override
    public Boolean getLabelsEnabled() {
        return getModel().getLabelsEnabled();
    }

    @Override
    public T setLabelsEnabled(Boolean labelsEnabled) {
        getModel().setLabelsEnabled(labelsEnabled);
        return (T) this;
    }

    @Override
    public Double getLabelTickAlpha() {
        return getModel().getLabelTickAlpha();
    }

    @Override
    public T setLabelTickAlpha(Double labelTickAlpha) {
        getModel().setLabelTickAlpha(labelTickAlpha);
        return (T) this;
    }

    @Override
    public Color getLabelTickColor() {
        return getModel().getLabelTickColor();
    }

    @Override
    public T setLabelTickColor(Color labelTickColor) {
        getModel().setLabelTickColor(labelTickColor);
        return (T) this;
    }

    @Override
    public Integer getMarginBottom() {
        return getModel().getMarginBottom();
    }

    @Override
    public T setMarginBottom(Integer marginBottom) {
        getModel().setMarginBottom(marginBottom);
        return (T) this;
    }

    @Override
    public Integer getMarginLeft() {
        return getModel().getMarginLeft();
    }

    @Override
    public T setMarginLeft(Integer marginLeft) {
        getModel().setMarginLeft(marginLeft);
        return (T) this;
    }

    @Override
    public Integer getMarginRight() {
        return getModel().getMarginRight();
    }

    @Override
    public T setMarginRight(Integer marginRight) {
        getModel().setMarginRight(marginRight);
        return (T) this;
    }

    @Override
    public Integer getMarginTop() {
        return getModel().getMarginTop();
    }

    @Override
    public T setMarginTop(Integer marginTop) {
        getModel().setMarginTop(marginTop);
        return (T) this;
    }

    @Override
    public Double getOutlineAlpha() {
        return getModel().getOutlineAlpha();
    }

    @Override
    public T setOutlineAlpha(Double outlineAlpha) {
        getModel().setOutlineAlpha(outlineAlpha);
        return (T) this;
    }

    @Override
    public Color getOutlineColor() {
        return getModel().getOutlineColor();
    }

    @Override
    public T setOutlineColor(Color outlineColor) {
        getModel().setOutlineColor(outlineColor);
        return (T) this;
    }

    @Override
    public Integer getOutlineThickness() {
        return getModel().getOutlineThickness();
    }

    @Override
    public T setOutlineThickness(Integer outlineThickness) {
        getModel().setOutlineThickness(outlineThickness);
        return (T) this;
    }

    @Override
    public String getPatternField() {
        return getModel().getPatternField();
    }

    @Override
    public T setPatternField(String patternField) {
        getModel().setPatternField(patternField);
        return (T) this;
    }

    @Override
    public String getPulledField() {
        return getModel().getPulledField();
    }

    @Override
    public T setPulledField(String pulledField) {
        getModel().setPulledField(pulledField);
        return (T) this;
    }

    @Override
    public Integer getPullOutDuration() {
        return getModel().getPullOutDuration();
    }

    @Override
    public T setPullOutDuration(Integer pullOutDuration) {
        getModel().setPullOutDuration(pullOutDuration);
        return (T) this;
    }

    @Override
    public AnimationEffect getPullOutEffect() {
        return getModel().getPullOutEffect();
    }

    @Override
    public T setPullOutEffect(AnimationEffect pullOutEffect) {
        getModel().setPullOutEffect(pullOutEffect);
        return (T) this;
    }

    @Override
    public Boolean getPullOutOnlyOne() {
        return getModel().getPullOutOnlyOne();
    }

    @Override
    public T setPullOutOnlyOne(Boolean pullOutOnlyOne) {
        getModel().setPullOutOnlyOne(pullOutOnlyOne);
        return (T) this;
    }

    @Override
    public Boolean getSequencedAnimation() {
        return getModel().getSequencedAnimation();
    }

    @Override
    public T setSequencedAnimation(Boolean sequencedAnimation) {
        getModel().setSequencedAnimation(sequencedAnimation);
        return (T) this;
    }

    @Override
    public Double getStartAlpha() {
        return getModel().getStartAlpha();
    }

    @Override
    public T setStartAlpha(Double startAlpha) {
        getModel().setStartAlpha(startAlpha);
        return (T) this;
    }

    @Override
    public Integer getStartDuration() {
        return getModel().getStartDuration();
    }

    @Override
    public T setStartDuration(Integer startDuration) {
        getModel().setStartDuration(startDuration);
        return (T) this;
    }

    @Override
    public AnimationEffect getStartEffect() {
        return getModel().getStartEffect();
    }

    @Override
    public T setStartEffect(AnimationEffect startEffect) {
        getModel().setStartEffect(startEffect);
        return (T) this;
    }

    @Override
    public String getTitleField() {
        return getModel().getTitleField();
    }

    @Override
    public T setTitleField(String titleField) {
        getModel().setTitleField(titleField);
        return (T) this;
    }

    @Override
    public String getUrlField() {
        return getModel().getUrlField();
    }

    @Override
    public T setUrlField(String urlField) {
        getModel().setUrlField(urlField);
        return (T) this;
    }

    @Override
    public String getUrlTarget() {
        return getModel().getUrlTarget();
    }

    @Override
    public T setUrlTarget(String urlTarget) {
        getModel().setUrlTarget(urlTarget);
        return (T) this;
    }

    @Override
    public String getValueField() {
        return getModel().getValueField();
    }

    @Override
    public T setValueField(String valueField) {
        getModel().setValueField(valueField);
        return (T) this;
    }

    @Override
    public String getVisibleInLegendField() {
        return getModel().getVisibleInLegendField();
    }

    @Override
    public T setVisibleInLegendField(String visibleInLegendField) {
        getModel().setVisibleInLegendField(visibleInLegendField);
        return (T) this;
    }

    @Override
    public JsFunction getLabelFunction() {
        return getModel().getLabelFunction();
    }

    @Override
    public T setLabelFunction(JsFunction labelFunction) {
        getModel().setLabelFunction(labelFunction);
        return (T) this;
    }

    @Override
    public Integer getMaxLabelWidth() {
        return getModel().getMaxLabelWidth();
    }

    @Override
    public T setMaxLabelWidth(Integer maxLabelWidth) {
        getModel().setMaxLabelWidth(maxLabelWidth);
        return (T) this;
    }

    @Override
    public String getClassNameField() {
        return getModel().getClassNameField();
    }

    @Override
    public T setClassNameField(String classNameField) {
        getModel().setClassNameField(classNameField);
        return (T) this;
    }

    @Override
    public Boolean getShowZeroSlices() {
        return getModel().getShowZeroSlices();
    }

    @Override
    public T setShowZeroSlices(Boolean showZeroSlices) {
        getModel().setShowZeroSlices(showZeroSlices);
        return (T) this;
    }

    @Override
    public String getAccessibleLabel() {
        return getModel().getAccessibleLabel();
    }

    @Override
    public T setAccessibleLabel(String accessibleLabel) {
        getModel().setAccessibleLabel(accessibleLabel);
        return (T) this;
    }

    @Override
    public Color getLabelColorField() {
        return getModel().getLabelColorField();
    }

    @Override
    public T setLabelColorField(Color labelColorField) {
        getModel().setLabelColorField(labelColorField);
        return (T) this;
    }

    @Override
    public Integer getTabIndex() {
        return getModel().getTabIndex();
    }

    @Override
    public T setTabIndex(Integer tabIndex) {
        getModel().setTabIndex(tabIndex);
        return (T) this;
    }

    @Override
    public void addSliceClickListener(SliceClickListener listener) {
        getEventRouter().addListener(SliceClickListener.class, listener);
        if (sliceClickHandler == null) {
            sliceClickHandler = e -> {
                SliceClickEvent event = new SliceClickEvent(getEventItem(e.getSliceId()), e.getX(), e.getY(),
                        e.getAbsoluteX(), e.getAbsoluteY());
                getEventRouter().fireEvent(SliceClickListener.class, SliceClickListener::onClick, event);
            };
            component.addSliceClickListener(sliceClickHandler);
        }
    }

    @Override
    public void removeSliceClickListener(SliceClickListener listener) {
        getEventRouter().removeListener(SliceClickListener.class, listener);
        if (sliceClickHandler != null && !getEventRouter().hasListeners(SliceClickListener.class)) {
            component.removeSliceClickListener(sliceClickHandler);
            sliceClickHandler = null;
        }
    }

    @Override
    public void addSliceRightClickListener(SliceRightClickListener listener) {
        getEventRouter().addListener(SliceRightClickListener.class, listener);
        if (sliceRightClickHandler == null) {
            sliceRightClickHandler = e -> {
                SliceRightClickEvent event = new SliceRightClickEvent(getEventItem(e.getSliceId()), e.getX(), e.getY(),
                        e.getAbsoluteX(), e.getAbsoluteY());
                getEventRouter().fireEvent(SliceRightClickListener.class, SliceRightClickListener::onRightClick, event);
            };
            component.addSliceRightClickListener(sliceRightClickHandler);
        }
    }

    @Override
    public void removeSliceRightClickListener(SliceRightClickListener listener) {
        getEventRouter().removeListener(SliceRightClickListener.class, listener);
        if (sliceRightClickHandler != null && !getEventRouter().hasListeners(SliceRightClickListener.class)) {
            component.removeSliceRightClickListener(sliceRightClickHandler);
            sliceRightClickHandler = null;
        }
    }

    @Override
    public void addSlicePullInListener(SlicePullInListener listener) {
        getEventRouter().addListener(SlicePullInListener.class, listener);
        if (slicePullInHandler == null) {
            slicePullInHandler = e -> {
                SlicePullInEvent event = new SlicePullInEvent(getEventItem(e.getSliceId()));
                getEventRouter().fireEvent(SlicePullInListener.class, SlicePullInListener::onPullIn, event);
            };
            component.addSlicePullInListener(slicePullInHandler);
        }
    }

    @Override
    public void removeSlicePullInListener(SlicePullInListener listener) {
        getEventRouter().removeListener(SlicePullInListener.class, listener);
        if (slicePullInHandler != null && !getEventRouter().hasListeners(SlicePullInListener.class)) {
            component.removeSlicePullInListener(slicePullInHandler);
            slicePullInHandler = null;
        }
    }

    @Override
    public void addSlicePullOutListener(SlicePullOutListener listener) {
        getEventRouter().addListener(SlicePullOutListener.class, listener);
        if (slicePullOutHandler == null) {
            slicePullOutHandler = e -> {
                SlicePullOutEvent event = new SlicePullOutEvent(getEventItem(e.getSliceId()));
                getEventRouter().fireEvent(SlicePullOutListener.class, SlicePullOutListener::onPullOut, event);
            };
            component.addSlicePullOutListener(slicePullOutHandler);
        }
    }

    @Override
    public void removeSlicePullOutListener(SlicePullOutListener listener) {
        getEventRouter().removeListener(SlicePullOutListener.class, listener);
        if (slicePullOutHandler != null && !getEventRouter().hasListeners(SlicePullOutListener.class)) {
            component.removeSlicePullOutListener(slicePullOutHandler);
            slicePullOutHandler = null;
        }
    }
}