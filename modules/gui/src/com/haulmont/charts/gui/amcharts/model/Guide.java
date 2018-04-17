/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.haulmont.charts.gui.components.charts.SerialChart;
import com.haulmont.charts.gui.components.charts.XYChart;
import com.haulmont.charts.gui.components.charts.RadarChart;

import java.util.Date;

/**
 * Creates a horizontal/vertical guideline-/area for {@link SerialChart}, {@link XYChart} and {@link RadarChart}
 * charts, automatically adapts it's settings from the axes if none has been specified.
 * <p>
 * See documentation for properties of Guide JS Object. <br>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/Guide">http://docs.amcharts.com/3/javascriptcharts/Guide</a>
 */
public class Guide extends AbstractChartObject {

    private static final long serialVersionUID = -6465377479319328449L;

    private Boolean above;

    private Integer angle;

    private Color balloonColor;

    private String balloonText;

    private Boolean boldLabel;

    private String category;

    private Color color;

    private Integer dashLength;

    private Date date;

    private Boolean expand;

    private Double fillAlpha;

    private Color fillColor;

    private Integer fontSize;

    private String id;

    private Boolean inside;

    private String label;

    private Integer labelRotation;

    private Double lineAlpha;

    private Color lineColor;

    private Integer lineThickness;

    private Position position;

    private Integer tickLength;

    private Integer toAngle;

    private String toCategory;

    private Date toDate;

    private Object toValue;

    private Object value;

    private String valueAxis;

    /**
     * @return true if guide displayed above the graphs
     */
    public Boolean getAbove() {
        return above;
    }

    /**
     * Set above to true if the guide should be displayed above the graphs. If not set the default value is false.
     *
     * @param above above option
     */
    public Guide setAbove(Boolean above) {
        this.above = above;
        return this;
    }

    /**
     * @return angle at which guide starts
     */
    public Integer getAngle() {
        return angle;
    }

    /**
     * Sets angle at which guide should start. Affects only fills, not lines. Radar chart only.
     *
     * @param angle angle
     */
    public Guide setAngle(Integer angle) {
        this.angle = angle;
        return this;
    }

    /**
     * @return balloon fill color
     */
    public Color getBalloonColor() {
        return balloonColor;
    }

    /**
     * Sets balloon fill color.
     *
     * @param balloonColor fill color
     */
    public Guide setBalloonColor(Color balloonColor) {
        this.balloonColor = balloonColor;
        return this;
    }

    /**
     * @return balloon text which is displayed if the user rolls-over the guide
     */
    public String getBalloonText() {
        return balloonText;
    }

    /**
     * Sets the text which will be displayed if the user rolls-over the guide.
     *
     * @param balloonText balloon text
     */
    public Guide setBalloonText(String balloonText) {
        this.balloonText = balloonText;
        return this;
    }

    /**
     * @return category value
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets category of the guide (in case the guide is for category axis).
     *
     * @param category category value
     */
    public Guide setCategory(String category) {
        this.category = category;
        return this;
    }

    /**
     * @return dash length.
     */
    public Integer getDashLength() {
        return dashLength;
    }

    /**
     * Sets dash length.
     *
     * @param dashLength dash length
     */
    public Guide setDashLength(Integer dashLength) {
        this.dashLength = dashLength;
        return this;
    }

    /**
     * @return date of the guide
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date of the guide (in case the guide is for category axis and {@link CategoryAxis#parseDates} is set to
     * true).
     *
     * @param date date
     */
    public Guide setDate(Date date) {
        this.date = date;
        return this;
    }

    /**
     * @return fill opacity
     */
    public Double getFillAlpha() {
        return fillAlpha;
    }

    /**
     * Sets fill opacity. Value range is 0 - 1.
     *
     * @param fillAlpha fill opacity
     */
    public Guide setFillAlpha(Double fillAlpha) {
        this.fillAlpha = fillAlpha;
        return this;
    }

    /**
     * @return fill color
     */
    public Color getFillColor() {
        return fillColor;
    }

    /**
     * Sets fill color.
     *
     * @param fillColor fill color
     */
    public Guide setFillColor(Color fillColor) {
        this.fillColor = fillColor;
        return this;
    }

    /**
     * @return font size of guide label
     */
    public Integer getFontSize() {
        return fontSize;
    }

    /**
     * Sets font size of guide label.
     *
     * @param fontSize font size
     */
    public Guide setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    /**
     * @return true if if label is placed inside plot area
     */
    public Boolean getInside() {
        return inside;
    }

    /**
     * Set inside to true if label should be placed inside plot area.
     *
     * @param inside inside option
     */
    public Guide setInside(Boolean inside) {
        this.inside = inside;
        return this;
    }

    /**
     * @return label which is displayed near the guide
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the label which will be displayed near the guide.
     *
     * @param label label string
     */
    public Guide setLabel(String label) {
        this.label = label;
        return this;
    }

    /**
     * @return rotation angle of a guide label
     */
    public Integer getLabelRotation() {
        return labelRotation;
    }

    /**
     * Sets rotation angle of a guide label.
     *
     * @param labelRotation rotation angle
     */
    public Guide setLabelRotation(Integer labelRotation) {
        this.labelRotation = labelRotation;
        return this;
    }

    /**
     * @return line opacity
     */
    public Double getLineAlpha() {
        return lineAlpha;
    }

    /**
     * Sets line opacity.
     *
     * @param lineAlpha line opacity
     */
    public Guide setLineAlpha(Double lineAlpha) {
        this.lineAlpha = lineAlpha;
        return this;
    }

    /**
     * @return line color
     */
    public Color getLineColor() {
        return lineColor;
    }

    /**
     * Sets line color.
     *
     * @param lineColor line color
     */
    public Guide setLineColor(Color lineColor) {
        this.lineColor = lineColor;
        return this;
    }

    /**
     * @return line thickness
     */
    public Integer getLineThickness() {
        return lineThickness;
    }

    /**
     * Sets line thickness.
     *
     * @param lineThickness line thickness
     */
    public Guide setLineThickness(Integer lineThickness) {
        this.lineThickness = lineThickness;
        return this;
    }

    /**
     * @return position of guide label
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets position of guide label. Possible values are "left" or "right" for horizontal axis and "top" or "bottom"
     * for vertical axis.
     *
     * @param position position of guide label
     */
    public Guide setPosition(Position position) {
        this.position = position;
        return this;
    }

    /**
     * @return tick length
     */
    public Integer getTickLength() {
        return tickLength;
    }

    /**
     * Sets tick length.
     *
     * @param tickLength tick length
     */
    public Guide setTickLength(Integer tickLength) {
        this.tickLength = tickLength;
        return this;
    }

    /**
     * @return angle at which guide ends
     */
    public Integer getToAngle() {
        return toAngle;
    }

    /**
     * Sets the angle at which guide should end. Affects only fills, not lines. Radar chart only.
     *
     * @param toAngle angle
     */
    public Guide setToAngle(Integer toAngle) {
        this.toAngle = toAngle;
        return this;
    }

    /**
     * @return "to" category of the guide
     */
    public String getToCategory() {
        return toCategory;
    }

    /**
     * Sets "to" category of the guide (in case the guide is for category axis).
     *
     * @param toCategory to category
     */
    public Guide setToCategory(String toCategory) {
        this.toCategory = toCategory;
        return this;
    }

    /**
     * @return "to" date of the guide
     */
    public Date getToDate() {
        return toDate;
    }

    /**
     * Sets "to" date of the guide (in case the guide is for category axis and {@link CategoryAxis#parseDates} is set
     * to true) If you have both date and toDate, the space between these two dates can be filled with color.
     *
     * @param toDate date
     */
    public Guide setToDate(Date toDate) {
        this.toDate = toDate;
        return this;
    }

    /**
     * @return "to" value of the guide
     */
    public Object getToValue() {
        return toValue;
    }

    /**
     * Sets "to" value of the guide (in case the guide is for value axis).
     *
     * @param toValue to value
     */
    public Guide setToValue(Object toValue) {
        this.toValue = toValue;
        return this;
    }

    /**
     * @return value of the guide
     */
    public Object getValue() {
        return value;
    }

    /**
     * Sets value of the guide (in case the guide is for value axis).
     *
     * @param value value
     */
    public Guide setValue(Object value) {
        this.value = value;
        return this;
    }

    /**
     * @return true if label is bold
     */
    public Boolean getBoldLabel() {
        return boldLabel;
    }

    /**
     * Set boldLabel to true if label should be bold. If not set the default value is false.
     *
     * @param boldLabel boldLabel option
     */
    public Guide setBoldLabel(Boolean boldLabel) {
        this.boldLabel = boldLabel;
        return this;
    }

    /**
     * @return color of a guide label
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets color of a guide label.
     *
     * @param color color
     */
    public Guide setColor(Color color) {
        this.color = color;
        return this;
    }

    /**
     * @return true if the guide starts on the beginning of the category cell and ends at the end of
     * "toCategory" cell
     */
    public Boolean getExpand() {
        return expand;
    }

    /**
     * Set expand to true if the guide should start (or be placed, if it's not a fill) on the beginning of the
     * category cell and should end at the end of "toCategory" cell. Works if a guide is added to {@link CategoryAxis}
     * and this axis is non-date-based. If not set the default value is false.
     *
     * @param expand expand option
     */
    public Guide setExpand(Boolean expand) {
        this.expand = expand;
        return this;
    }

    /**
     * @return unique id of a guide
     */
    public String getId() {
        return id;
    }

    /**
     * Sets unique id of a guide.
     *
     * @param id id
     */
    public Guide setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * @return value axis id
     */
    public String getValueAxis() {
        return valueAxis;
    }

    /**
     * Sets value axis of a guide. As you can add guides directly to the chart, you might need to specify which value
     * axis should be used.
     *
     * @param valueAxis value axis id
     */
    public Guide setValueAxis(String valueAxis) {
        this.valueAxis = valueAxis;
        return this;
    }
}