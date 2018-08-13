/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.drawing;

/**
 * Meta-class for setting options for drawing mode
 *
 */
public class DrawingOptions {

    private static final long serialVersionUID = -19754086700404391L;

    protected PolygonOptions polygonOptions;
    protected CircleOptions circleOptions;
    protected OverlayType initialDrawingMode;
    protected boolean enableDrawingControl;
    protected ControlOptions controlOptions;

    public DrawingOptions() {
    }

    /**
     * Sets options for drawing polygons
     * @param polygonOptions options
     */
    public void setPolygonOptions(PolygonOptions polygonOptions) {
        this.polygonOptions = polygonOptions;
    }

    /**
     * @return polygon drawing options
     */
    public PolygonOptions getPolygonOptions() {
        return polygonOptions;
    }

    /**
     * @return circle drawing options
     */
    public CircleOptions getCircleOptions() {
        return circleOptions;
    }

    /**
     * Sets options for drawing circle
     * @param circleOptions options
     */
    public void setCircleOptions(CircleOptions circleOptions) {
        this.circleOptions = circleOptions;
    }

    /**
     * Sets drawing mode enabled by default. Set null for no drawing selected
     * @param initialDrawingMode initial drawing mode
     */
    public void setInitialDrawingMode(OverlayType initialDrawingMode) {
        this.initialDrawingMode = initialDrawingMode;
    }

    /**
     * @return drawing mode enabled by default
     */
    public OverlayType getInitialDrawingMode() {
        return initialDrawingMode;
    }

    /**
     * Sets visibility of drawing controls
     * @param enableDrawingControl true for enabling toolbox with drawing tools
     */
    public void setEnableDrawingControl(boolean enableDrawingControl) {
        this.enableDrawingControl = enableDrawingControl;
    }

    /**
     * @return true if drawing tools toolbox is enabled
     */
    public boolean isEnableDrawingControl() {
        return enableDrawingControl;
    }

    /**
     * Sets options for drawing controls
     * @param drawingControlOptions options
     */
    public void setDrawingControlOptions(ControlOptions drawingControlOptions) {
        this.controlOptions = drawingControlOptions;
    }

    /**
     * @return options for drawing controls
     */
    public ControlOptions getDrawingControlOptions() {
        return controlOptions;
    }
}
