/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model.drawing;

/**
 * @author korotkov
 * @version $Id$
 */
public class DrawingOptions {

    private static final long serialVersionUID = -19754086700404391L;

    protected PolygonOptions polygonOptions;
    protected OverlayType initialDrawingMode;
    protected boolean enableDrawingControl;
    protected ControlOptions controlOptions;

    public DrawingOptions() {
    }

    public PolygonOptions getPolygonOptions() {
        return polygonOptions;
    }

    public void setPolygonOptions(PolygonOptions polygonOptions) {
        this.polygonOptions = polygonOptions;
    }

    public OverlayType getInitialDrawingMode() {
        return initialDrawingMode;
    }

    public void setInitialDrawingMode(OverlayType initialDrawingMode) {
        this.initialDrawingMode = initialDrawingMode;
    }

    public boolean isEnableDrawingControl() {
        return enableDrawingControl;
    }

    public void setEnableDrawingControl(boolean enableDrawingControl) {
        this.enableDrawingControl = enableDrawingControl;
    }

    public ControlOptions getDrawingControlOptions() {
        return controlOptions;
    }

    public void setDrawingControlOptions(ControlOptions drawingControlOptions) {
        this.controlOptions = drawingControlOptions;
    }
}
