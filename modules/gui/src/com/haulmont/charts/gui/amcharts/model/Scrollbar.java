/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * See documentation for properties of ChartScrollbar JS Object.
 *
 * @author artamonov
 * @version $Id$
 */
public class Scrollbar extends AbstractConfigurationObject {

    private static final long serialVersionUID = 6850646494521513508L;

    private Boolean autoGridCount;

    private Double backgroundAlpha;

    private Color backgroundColor;

    private Color color;

    private Integer dragIconHeight;

    private Integer dragIconWidth;

    private String graph;

    private Double graphFillAlpha;

    private Color graphFillColor;

    private Double graphLineAlpha;

    private Color graphLineColor;

    private GraphType graphType;

    private Double gridAlpha;

    private Color gridColor;

    private Integer gridCount;

    private Boolean hideResizeGrips;

    private Double maximum;

    private Double minimum;

    private Boolean resizeEnabled;

    private Integer scrollbarHeight;

    private Double scrollDuration;

    private Double selectedBackgroundAlpha;

    private Color selectedBackgroundColor;

    private Double selectedGraphFillAlpha;

    private Color selectedGraphFillColor;

    private Double selectedGraphLineAlpha;

    private Color selectedGraphLineColor;

    private Boolean updateOnReleaseOnly;

    public Boolean getAutoGridCount() {
        return autoGridCount;
    }

    public Scrollbar setAutoGridCount(Boolean autoGridCount) {
        this.autoGridCount = autoGridCount;
        return this;
    }

    public Double getBackgroundAlpha() {
        return backgroundAlpha;
    }

    public Scrollbar setBackgroundAlpha(Double backgroundAlpha) {
        this.backgroundAlpha = backgroundAlpha;
        return this;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Scrollbar setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public Scrollbar setColor(Color color) {
        this.color = color;
        return this;
    }

    public Integer getDragIconHeight() {
        return dragIconHeight;
    }

    public Scrollbar setDragIconHeight(Integer dragIconHeight) {
        this.dragIconHeight = dragIconHeight;
        return this;
    }

    public Integer getDragIconWidth() {
        return dragIconWidth;
    }

    public Scrollbar setDragIconWidth(Integer dragIconWidth) {
        this.dragIconWidth = dragIconWidth;
        return this;
    }

    public Double getGraphFillAlpha() {
        return graphFillAlpha;
    }

    public Scrollbar setGraphFillAlpha(Double graphFillAlpha) {
        this.graphFillAlpha = graphFillAlpha;
        return this;
    }

    public Color getGraphFillColor() {
        return graphFillColor;
    }

    public Scrollbar setGraphFillColor(Color graphFillColor) {
        this.graphFillColor = graphFillColor;
        return this;
    }

    public Double getGraphLineAlpha() {
        return graphLineAlpha;
    }

    public Scrollbar setGraphLineAlpha(Double graphLineAlpha) {
        this.graphLineAlpha = graphLineAlpha;
        return this;
    }

    public Color getGraphLineColor() {
        return graphLineColor;
    }

    public Scrollbar setGraphLineColor(Color graphLineColor) {
        this.graphLineColor = graphLineColor;
        return this;
    }

    public GraphType getGraphType() {
        return graphType;
    }

    public Scrollbar setGraphType(GraphType graphType) {
        this.graphType = graphType;
        return this;
    }

    public Double getGridAlpha() {
        return gridAlpha;
    }

    public Scrollbar setGridAlpha(Double gridAlpha) {
        this.gridAlpha = gridAlpha;
        return this;
    }

    public Color getGridColor() {
        return gridColor;
    }

    public Scrollbar setGridColor(Color gridColor) {
        this.gridColor = gridColor;
        return this;
    }

    public Integer getGridCount() {
        return gridCount;
    }

    public Scrollbar setGridCount(Integer gridCount) {
        this.gridCount = gridCount;
        return this;
    }

    public Boolean getHideResizeGrips() {
        return hideResizeGrips;
    }

    public Scrollbar setHideResizeGrips(Boolean hideResizeGrips) {
        this.hideResizeGrips = hideResizeGrips;
        return this;
    }

    public Double getMaximum() {
        return maximum;
    }

    public Scrollbar setMaximum(Double maximum) {
        this.maximum = maximum;
        return this;
    }

    public Double getMinimum() {
        return minimum;
    }

    public Scrollbar setMinimum(Double minimum) {
        this.minimum = minimum;
        return this;
    }

    public Boolean getResizeEnabled() {
        return resizeEnabled;
    }

    public Scrollbar setResizeEnabled(Boolean resizeEnabled) {
        this.resizeEnabled = resizeEnabled;
        return this;
    }

    public Integer getScrollbarHeight() {
        return scrollbarHeight;
    }

    public Scrollbar setScrollbarHeight(Integer scrollbarHeight) {
        this.scrollbarHeight = scrollbarHeight;
        return this;
    }

    public Double getScrollDuration() {
        return scrollDuration;
    }

    public Scrollbar setScrollDuration(Double scrollDuration) {
        this.scrollDuration = scrollDuration;
        return this;
    }

    public Double getSelectedBackgroundAlpha() {
        return selectedBackgroundAlpha;
    }

    public Scrollbar setSelectedBackgroundAlpha(Double selectedBackgroundAlpha) {
        this.selectedBackgroundAlpha = selectedBackgroundAlpha;
        return this;
    }

    public Color getSelectedBackgroundColor() {
        return selectedBackgroundColor;
    }

    public Scrollbar setSelectedBackgroundColor(Color selectedBackgroundColor) {
        this.selectedBackgroundColor = selectedBackgroundColor;
        return this;
    }

    public Double getSelectedGraphFillAlpha() {
        return selectedGraphFillAlpha;
    }

    public Scrollbar setSelectedGraphFillAlpha(Double selectedGraphFillAlpha) {
        this.selectedGraphFillAlpha = selectedGraphFillAlpha;
        return this;
    }

    public Color getSelectedGraphFillColor() {
        return selectedGraphFillColor;
    }

    public Scrollbar setSelectedGraphFillColor(Color selectedGraphFillColor) {
        this.selectedGraphFillColor = selectedGraphFillColor;
        return this;
    }

    public Double getSelectedGraphLineAlpha() {
        return selectedGraphLineAlpha;
    }

    public Scrollbar setSelectedGraphLineAlpha(Double selectedGraphLineAlpha) {
        this.selectedGraphLineAlpha = selectedGraphLineAlpha;
        return this;
    }

    public Color getSelectedGraphLineColor() {
        return selectedGraphLineColor;
    }

    public Scrollbar setSelectedGraphLineColor(Color selectedGraphLineColor) {
        this.selectedGraphLineColor = selectedGraphLineColor;
        return this;
    }

    public Boolean getUpdateOnReleaseOnly() {
        return updateOnReleaseOnly;
    }

    public Scrollbar setUpdateOnReleaseOnly(Boolean updateOnReleaseOnly) {
        this.updateOnReleaseOnly = updateOnReleaseOnly;
        return this;
    }

    public String getGraph() {
        return graph;
    }

    public Scrollbar setGraph(String graph) {
        this.graph = graph;
        return this;
    }
}