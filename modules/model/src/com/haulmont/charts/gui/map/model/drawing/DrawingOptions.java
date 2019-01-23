/*
 * Copyright (c) 2008-2019 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
