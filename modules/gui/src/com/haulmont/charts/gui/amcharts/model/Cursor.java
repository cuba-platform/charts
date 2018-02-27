/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.haulmont.charts.gui.model.JsFunction;

/**
 * See documentation for properties of ChartCursor JS Object. <br>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/ChartCursor">http://docs.amcharts.com/3/javascriptcharts/ChartCursor</a>
 */
public class Cursor extends AbstractChartObject {

    private static final long serialVersionUID = 4196605135301917493L;

    private Integer adjustment;

    private Double animationDuration;

    private Boolean avoidBalloonOverlapping;

    private String balloonPointerOrientation;

    private Boolean bulletsEnabled;

    private Integer bulletSize;

    private Double categoryBalloonAlpha;

    private Color categoryBalloonColor;

    private String categoryBalloonDateFormat;

    private Boolean categoryBalloonEnabled;

    private JsFunction categoryBalloonFunction;

    private String categoryBalloonText;

    private Color color;

    private Double cursorAlpha;

    private Color cursorColor;

    private CursorPosition cursorPosition;

    private Boolean enabled;

    private Boolean fullWidth;

    private Double graphBulletAlpha;

    private Double graphBulletSize;

    private Boolean leaveAfterTouch;

    private Boolean leaveCursor;

    private String limitToGraph;

    private Boolean oneBalloonOnly;

    private Boolean pan;

    private Double selectionAlpha;

    private Boolean selectWithoutZooming;

    private Boolean showNextAvailable;

    private Boolean valueBalloonsEnabled;

    private Double valueLineAlpha;

    private String valueLineAxis;

    private Boolean valueLineBalloonEnabled;

    private Boolean valueLineEnabled;

    private Boolean valueZoomable;

    private Boolean zoomable;

    private Integer tabIndex;

    /**
     * @return adjustment
     */
    public Integer getAdjustment() {
        return adjustment;
    }

    /**
     * Sets adjustment. If you set adjustment to -1, the balloon will be shown near previous, if you set it to 1 - near
     * next data point.
     *
     * @param adjustment adjustment
     */
    public Cursor setAdjustment(Integer adjustment) {
        this.adjustment = adjustment;
        return this;
    }

    /**
     * @return true if avoidBalloonOverlapping is enabled
     */
    public Boolean getAvoidBalloonOverlapping() {
        return avoidBalloonOverlapping;
    }

    /**
     * Specifies if cursor should arrange balloons so they won't overlap. If chart is rotated, it might be good idea
     * to turn this off.
     *
     * @param avoidBalloonOverlapping avoidBalloonOverlapping option
     */
    public Cursor setAvoidBalloonOverlapping(Boolean avoidBalloonOverlapping) {
        this.avoidBalloonOverlapping = avoidBalloonOverlapping;
        return this;
    }

    /**
     * @return balloon pointer orientation
     */
    public String getBalloonPointerOrientation() {
        return balloonPointerOrientation;
    }

    /**
     * Sets the balloon pointer orientation. It defines if the balloon should be shown above the datapoint or sideways.
     *
     * @param balloonPointerOrientation balloon pointer orientation
     */
    public Cursor setBalloonPointerOrientation(String balloonPointerOrientation) {
        this.balloonPointerOrientation = balloonPointerOrientation;
        return this;
    }

    /**
     * @return duration of animation of a line, in seconds
     */
    public Double getAnimationDuration() {
        return animationDuration;
    }

    /**
     * Sets duration of animation of a line, in seconds.
     *
     * @param animationDuration duration of animation of a line, in seconds
     */
    public Cursor setAnimationDuration(Double animationDuration) {
        this.animationDuration = animationDuration;
        return this;
    }

    /**
     * @return true if bullet for each graph follows the cursor
     */
    public Boolean getBulletsEnabled() {
        return bulletsEnabled;
    }

    /**
     * Set bulletsEnabled to true if bullet for each graph should follow the cursor.
     *
     * @param bulletsEnabled bulletsEnabled option
     */
    public Cursor setBulletsEnabled(Boolean bulletsEnabled) {
        this.bulletsEnabled = bulletsEnabled;
        return this;
    }

    /**
     * @return bullet size
     */
    public Integer getBulletSize() {
        return bulletSize;
    }

    /**
     * Sets bullet size, that following the cursor.
     *
     * @param bulletSize bullet size
     */
    public Cursor setBulletSize(Integer bulletSize) {
        this.bulletSize = bulletSize;
        return this;
    }

    /**
     * @return opacity of the category balloon
     */
    public Double getCategoryBalloonAlpha() {
        return categoryBalloonAlpha;
    }

    /**
     * Sets opacity of the category balloon.
     *
     * @param categoryBalloonAlpha opacity of the category balloon
     */
    public Cursor setCategoryBalloonAlpha(Double categoryBalloonAlpha) {
        this.categoryBalloonAlpha = categoryBalloonAlpha;
        return this;
    }

    /**
     * @return category balloon color
     */
    public Color getCategoryBalloonColor() {
        return categoryBalloonColor;
    }

    /**
     * Sets color of the category balloon. Default color is cursorColor.
     *
     * @param categoryBalloonColor category balloon color
     */
    public Cursor setCategoryBalloonColor(Color categoryBalloonColor) {
        this.categoryBalloonColor = categoryBalloonColor;
        return this;
    }

    /**
     * @return category balloon date format
     */
    public String getCategoryBalloonDateFormat() {
        return categoryBalloonDateFormat;
    }

    /**
     * Sets category balloon date format (used only if category axis parses dates).
     *
     * @param categoryBalloonDateFormat category balloon date format string
     */
    public Cursor setCategoryBalloonDateFormat(String categoryBalloonDateFormat) {
        this.categoryBalloonDateFormat = categoryBalloonDateFormat;
        return this;
    }

    /**
     * @return true if balloon is enabled
     */
    public Boolean getCategoryBalloonEnabled() {
        return categoryBalloonEnabled;
    }

    /**
     * Set categoryBalloonEnabled to false if you want balloon shouldn't be enabled.
     *
     * @param categoryBalloonEnabled categoryBalloonEnabled option
     */
    public Cursor setCategoryBalloonEnabled(Boolean categoryBalloonEnabled) {
        this.categoryBalloonEnabled = categoryBalloonEnabled;
        return this;
    }

    /**
     * @return text color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets text color.
     *
     * @param color text color
     */
    public Cursor setColor(Color color) {
        this.color = color;
        return this;
    }

    /**
     * @return opacity of the cursor line
     */
    public Double getCursorAlpha() {
        return cursorAlpha;
    }

    /**
     * Sets opacity of the cursor line.
     *
     * @param cursorAlpha opacity
     */
    public Cursor setCursorAlpha(Double cursorAlpha) {
        this.cursorAlpha = cursorAlpha;
        return this;
    }

    /**
     * @return color of the cursor line
     */
    public Color getCursorColor() {
        return cursorColor;
    }

    /**
     * Sets color of the cursor line.
     *
     * @param cursorColor color
     */
    public Cursor setCursorColor(Color cursorColor) {
        this.cursorColor = cursorColor;
        return this;
    }

    /**
     * @return cursor position
     */
    public CursorPosition getCursorPosition() {
        return cursorPosition;
    }

    /**
     * Sets cursor position: on the beginning of the period (day, hour, etc) or in the middle (only when
     * {@link CategoryAxis#parseDates} is set to true). If you want the cursor to follow mouse and not to glue to the
     * nearest data point, set "mouse" here. Possible values are: start, middle, mouse.
     *
     * @param cursorPosition cursor position
     */
    public Cursor setCursorPosition(CursorPosition cursorPosition) {
        this.cursorPosition = cursorPosition;
        return this;
    }

    /**
     * @return true if cursor is enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * Set enabled to false if you want cursor shouldn't be enabled.
     *
     * @param enabled enabled option
     */
    public Cursor setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * @return size of a graph's bullet
     */
    public Double getGraphBulletSize() {
        return graphBulletSize;
    }

    /**
     * Sets size of a graph's bullet (if available) at the cursor position. If you don't want the bullet to change
     * its size, set this property to 1.
     *
     * @param graphBulletSize graph bullet size
     */
    public Cursor setGraphBulletSize(Double graphBulletSize) {
        this.graphBulletSize = graphBulletSize;
        return this;
    }

    /**
     * @return true if only one balloon at a time is displayed
     */
    public Boolean getOneBalloonOnly() {
        return oneBalloonOnly;
    }

    /**
     *
     * Set to oneBalloonOnly true if only one balloon at a time should be displayed. Note, this is quite CPU consuming.
     *
     * @param oneBalloonOnly oneBalloonOnly option
     */
    public Cursor setOneBalloonOnly(Boolean oneBalloonOnly) {
        this.oneBalloonOnly = oneBalloonOnly;
        return this;
    }

    /**
     * @return true if the user can pan the chart instead of zooming
     */
    public Boolean getPan() {
        return pan;
    }

    /**
     * Set pan to true and the user will be able to pan the chart instead of zooming.
     *
     * @param pan pan option
     */
    public Cursor setPan(Boolean pan) {
        this.pan = pan;
        return this;
    }

    /**
     * @return opacity of the selection
     */
    public Double getSelectionAlpha() {
        return selectionAlpha;
    }

    /**
     * Sets opacity of the selection.
     *
     * @param selectionAlpha opacity
     */
    public Cursor setSelectionAlpha(Double selectionAlpha) {
        this.selectionAlpha = selectionAlpha;
        return this;
    }

    /**
     * @return true if cursor only marks selected area but not zoom-in after user releases mouse button
     */
    public Boolean getSelectWithoutZooming() {
        return selectWithoutZooming;
    }

    /**
     * Set selectWithoutZooming to true if cursor should only mark selected area but not zoom-in after user releases
     * mouse button.
     *
     * @param selectWithoutZooming selectWithoutZooming option
     */
    public Cursor setSelectWithoutZooming(Boolean selectWithoutZooming) {
        this.selectWithoutZooming = selectWithoutZooming;
        return this;
    }

    /**
     * @return true if the graph displays balloon on next available data point if currently hovered item doesn't have
     * value for this graph.
     */
    public Boolean getShowNextAvailable() {
        return showNextAvailable;
    }

    /**
     * Set showNextAvailable to true if the graph should display balloon on next available data point if currently
     * hovered item doesn't have value for this graph.
     *
     * @param showNextAvailable showNextAvailable option
     */
    public Cursor setShowNextAvailable(Boolean showNextAvailable) {
        this.showNextAvailable = showNextAvailable;
        return this;
    }

    /**
     * @return true if valueBalloonsEnabled is enabled
     */
    public Boolean getValueBalloonsEnabled() {
        return valueBalloonsEnabled;
    }

    /**
     * Set valueBalloonsEnabled to false if you want value balloons will not be enabled. In case they are
     * not, the balloons might be displayed anyway, when the user rolls-over the column or
     * bullet.
     *
     * @param valueBalloonsEnabled valueBalloonsEnabled option
     */
    public Cursor setValueBalloonsEnabled(Boolean valueBalloonsEnabled) {
        this.valueBalloonsEnabled = valueBalloonsEnabled;
        return this;
    }

    /**
     * @return true if the user can zoom-in the chart
     */
    public Boolean getZoomable() {
        return zoomable;
    }

    /**
     * Set zoomable to true if the user should zoom-in the chart. If pan is set to true, zoomable is switched to false
     * automatically.
     *
     * @param zoomable zoomable option
     */
    public Cursor setZoomable(Boolean zoomable) {
        this.zoomable = zoomable;
        return this;
    }

    /**
     * @return JS function that format category balloon text
     */
    public JsFunction getCategoryBalloonFunction() {
        return categoryBalloonFunction;
    }

    /**
     * Sets JS function that format category balloon text. This function should return a string which will be
     * displayed in a balloon. When categoryBalloonFunction is called, category value (or date) is passed as
     * an argument.
     *
     * @param categoryBalloonFunction JS function
     */
    public Cursor setCategoryBalloonFunction(JsFunction categoryBalloonFunction) {
        this.categoryBalloonFunction = categoryBalloonFunction;
        return this;
    }

    /**
     * @return true if instead of a cursor line, used fill which width will always be equal to the
     * width of one data item
     */
    public Boolean getFullWidth() {
        return fullWidth;
    }

    /**
     * Set to true if you want instead of a cursor line user should see a fill which width will always be equal to the
     * width of one data item. It recommended setting cursorAlpha to 0.1 or some other small number if using this
     * feature.
     *
     * @param fullWidth fullWidth option
     */
    public Cursor setFullWidth(Boolean fullWidth) {
        this.fullWidth = fullWidth;
        return this;
    }

    /**
     * @return opacity of graph bullet
     */
    public Double getGraphBulletAlpha() {
        return graphBulletAlpha;
    }

    /**
     * Sets opacity of graph bullet. If you make graph's bullets invisible by setting their opacity to 0
     * ({@link AbstractGraph#bulletAlpha}) and will set graphBulletAlpha to 1, the bullets will only appear at the
     * cursor's position.
     *
     * @param graphBulletAlpha opacity of graph bullet
     */
    public Cursor setGraphBulletAlpha(Double graphBulletAlpha) {
        this.graphBulletAlpha = graphBulletAlpha;
        return this;
    }

    /**
     * @return opacity of value line
     */
    public Double getValueLineAlpha() {
        return valueLineAlpha;
    }

    /**
     * Sets opacity of value line. Will use cursorAlpha value if not set.
     *
     * @param valueLineAlpha opacity of value line.
     */
    public Cursor setValueLineAlpha(Double valueLineAlpha) {
        this.valueLineAlpha = valueLineAlpha;
        return this;
    }

    /**
     * @return value line axis id
     */
    public String getValueLineAxis() {
        return valueLineAxis;
    }

    /**
     * Sets axis which should display the balloon.
     *
     * @param valueLineAxis value line axis id
     */
    public Cursor setValueLineAxis(String valueLineAxis) {
        this.valueLineAxis = valueLineAxis;
        return this;
    }

    /**
     * @return true if value balloon next to value axes labels is displayed
     */
    public Boolean getValueLineBalloonEnabled() {
        return valueLineBalloonEnabled;
    }

    /**
     * Set valueLineBalloonEnabled to true if value balloon next to value axes labels should be displayed.
     *
     * @param valueLineBalloonEnabled valueLineBalloonEnabled option
     */
    public Cursor setValueLineBalloonEnabled(Boolean valueLineBalloonEnabled) {
        this.valueLineBalloonEnabled = valueLineBalloonEnabled;
        return this;
    }

    /**
     * @return true if cursor of serial chart displays horizontal (or vertical if chart is rotated) line
     */
    public Boolean getValueLineEnabled() {
        return valueLineEnabled;
    }

    /**
     * Set valueLineEnabled to true if cursor of serial chart should display horizontal (or vertical if chart is
     * rotated) line. This line might help users to compare distant values of a chart. You can also enable value
     * balloons on this line by setting valueLineBalloonEnabled to true.
     *
     * @param valueLineEnabled valueLineEnabled option
     */
    public Cursor setValueLineEnabled(Boolean valueLineEnabled) {
        this.valueLineEnabled = valueLineEnabled;
        return this;
    }

    /**
     * @return category balloon text
     */
    public String getCategoryBalloonText() {
        return categoryBalloonText;
    }

    /**
     * Sets category balloon text. You can have [[category]] - [[toCategory]] tags in there and show category ranges
     * this way.
     *
     * @param categoryBalloonText category balloon text
     */
    public Cursor setCategoryBalloonText(String categoryBalloonText) {
        this.categoryBalloonText = categoryBalloonText;
        return this;
    }

    /**
     * @return true if cursor and balloons remain after the user touches the chart
     */
    public Boolean getLeaveAfterTouch() {
        return leaveAfterTouch;
    }

    /**
     * Set leaveAfterTouch to false if cursor and balloons shouldn't remain after the user touches the chart.
     *
     * @param leaveAfterTouch leaveAfterTouch option
     */
    public Cursor setLeaveAfterTouch(Boolean leaveAfterTouch) {
        this.leaveAfterTouch = leaveAfterTouch;
        return this;
    }

    /**
     * @return true if the cursor remains in the last position
     */
    public Boolean getLeaveCursor() {
        return leaveCursor;
    }

    /**
     * Set leaveCursor to true if cursor should be left at it's last position. Useful for touch devices - user might
     * want to see the balloons after he moves finger away.
     *
     * @param leaveCursor leaveCursor option
     */
    public Cursor setLeaveCursor(Boolean leaveCursor) {
        this.leaveCursor = leaveCursor;
        return this;
    }

    /**
     * @return id of a graph
     */
    public String getLimitToGraph() {
        return limitToGraph;
    }

    /**
     * Sets an id of a graph. {@link CategoryAxis} cursor line will be limited to this graph instead of being drawn
     * through full height of plot area. Note, this works with serial chart only. Also, cursorPosition must be set to
     * middle.
     *
     * @param limitToGraph id of a graph
     */
    public Cursor setLimitToGraph(String limitToGraph) {
        this.limitToGraph = limitToGraph;
        return this;
    }

    /**
     * @return true if the user can zoom-in value axes of a serial chart
     */
    public Boolean getValueZoomable() {
        return valueZoomable;
    }

    /**
     * Set valueZoomable to true if the user should zoom-in value axes of a serial chart.
     *
     * @param valueZoomable valueZoomable option
     */
    public Cursor setValueZoomable(Boolean valueZoomable) {
        this.valueZoomable = valueZoomable;
        return this;
    }

    /**
     * @return tab index
     */
    public Integer getTabIndex() {
        return tabIndex;
    }

    /**
     * In case you set it to some number, the chart will set focus on chart cursor (works only with serial chart)
     * when user clicks tab key. When a focus is set user can move cursor using cursor keys. Note, not all browsers
     * and readers support this.
     *
     * @param tabIndex tab index
     */
    public void setTabIndex(Integer tabIndex) {
        this.tabIndex = tabIndex;
    }
}