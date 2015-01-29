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
 * See documentation for properties of AmCoordinateChart JS object.
 *
 * @author artamonov
 * @version $Id$
 */
@SuppressWarnings("unchecked")
public abstract class CoordinateChart<T extends CoordinateChart> extends AbstractChart<T>
        implements HasStartEffect<T>, HasColors<T> {

    private List<Color> colors;

    private List<Graph> graphs;

    private Boolean gridAboveGraphs;

    private List<Guide> guides;

    private Boolean sequencedAnimation;

    private Double startAlpha;

    private AnimationEffect startEffect;

    private Integer startDuration;

    private List<ValueAxis> valueAxes;

    private String urlTarget;

    public CoordinateChart(ChartType type) {
        super(type);
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

    public List<Graph> getGraphs() {
        return graphs;
    }

    public T setGraphs(List<Graph> graphs) {
        this.graphs = graphs;
        return (T) this;
    }

    public T addGraphs(Graph... graphs) {
        if (graphs != null) {
            if (this.graphs == null) {
                this.graphs = new ArrayList<>();
            }
            this.graphs.addAll(Arrays.asList(graphs));
        }
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

    @Override
    public Integer getStartDuration() {
        return startDuration;
    }

    @Override
    public T setStartDuration(Integer startDuration) {
        this.startDuration = startDuration;
        return (T) this;
    }

    public List<ValueAxis> getValueAxes() {
        return valueAxes;
    }

    public T setValueAxes(List<ValueAxis> valueAxes) {
        this.valueAxes = valueAxes;
        return (T) this;
    }

    public T addValueAxes(ValueAxis... valueAxes) {
        if (valueAxes != null) {
            if (this.valueAxes == null) {
                this.valueAxes = new ArrayList<>();
            }
            this.valueAxes.addAll(Arrays.asList(valueAxes));
        }
        return (T) this;
    }

    public List<Guide> getGuides() {
        return guides;
    }

    public T setGuides(List<Guide> guides) {
        this.guides = guides;
        return (T) this;
    }

    public T addGuides(Guide... guides) {
        if (guides != null) {
            if (this.guides == null) {
                this.guides = new ArrayList<>();
            }
            this.guides.addAll(Arrays.asList(guides));
        }
        return (T) this;
    }

    public Boolean getGridAboveGraphs() {
        return gridAboveGraphs;
    }

    public T setGridAboveGraphs(Boolean gridAboveGraphs) {
        this.gridAboveGraphs = gridAboveGraphs;
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

    public String getUrlTarget() {
        return urlTarget;
    }

    public T setUrlTarget(String urlTarget) {
        this.urlTarget = urlTarget;
        return (T) this;
    }

    @Override
    public List<String> getWiredFields() {
        List<String> wiredFields = new ArrayList<>(super.getWiredFields());

        if (graphs != null) {
            for (Graph g : graphs) {
                if (StringUtils.isNotEmpty(g.getValueField())) {
                    wiredFields.add(g.getValueField());
                }

                if (StringUtils.isNotEmpty(g.getAlphaField())) {
                    wiredFields.add(g.getAlphaField());
                }

                if (StringUtils.isNotEmpty(g.getBulletField())) {
                    wiredFields.add(g.getBulletField());
                }

                if (StringUtils.isNotEmpty(g.getBulletSizeField())) {
                    wiredFields.add(g.getBulletSizeField());
                }

                if (StringUtils.isNotEmpty(g.getCloseField())) {
                    wiredFields.add(g.getCloseField());
                }

                if (StringUtils.isNotEmpty(g.getColorField())) {
                    wiredFields.add(g.getColorField());
                }

                if (StringUtils.isNotEmpty(g.getCustomBulletField())) {
                    wiredFields.add(g.getCustomBulletField());
                }

                if (StringUtils.isNotEmpty(g.getDashLengthField())) {
                    wiredFields.add(g.getDashLengthField());
                }

                if (StringUtils.isNotEmpty(g.getDescriptionField())) {
                    wiredFields.add(g.getDescriptionField());
                }

                if (StringUtils.isNotEmpty(g.getErrorField())) {
                    wiredFields.add(g.getErrorField());
                }

                if (StringUtils.isNotEmpty(g.getFillColorsField())) {
                    wiredFields.add(g.getFillColorsField());
                }

                if (StringUtils.isNotEmpty(g.getGapField())) {
                    wiredFields.add(g.getGapField());
                }

                if (StringUtils.isNotEmpty(g.getHighField())) {
                    wiredFields.add(g.getHighField());
                }

                if (StringUtils.isNotEmpty(g.getLabelColorField())) {
                    wiredFields.add(g.getLabelColorField());
                }

                if (StringUtils.isNotEmpty(g.getLineColorField())) {
                    wiredFields.add(g.getLineColorField());
                }

                if (StringUtils.isNotEmpty(g.getLowField())) {
                    wiredFields.add(g.getLowField());
                }

                if (StringUtils.isNotEmpty(g.getOpenField())) {
                    wiredFields.add(g.getOpenField());
                }

                if (StringUtils.isNotEmpty(g.getPatternField())) {
                    wiredFields.add(g.getPatternField());
                }

                if (StringUtils.isNotEmpty(g.getUrlField())) {
                    wiredFields.add(g.getUrlField());
                }

                if (StringUtils.isNotEmpty(g.getXField())) {
                    wiredFields.add(g.getXField());
                }

                if (StringUtils.isNotEmpty(g.getYField())) {
                    wiredFields.add(g.getYField());
                }
            }
        }

        return wiredFields;
    }
}