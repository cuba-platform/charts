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

package com.haulmont.charts.web.widgets.client.addons.googlemap.drawing;

import java.io.Serializable;

public class DrawingOptions implements Serializable {

    private static final long serialVersionUID = -806817086700404391L;

    protected PolygonOptions polygonOptions;
    protected CircleOptions circleOptions;
    protected OverlayType initialDrawingMode;
    protected boolean enableDrawingControl;
    protected DrawingControlOptions drawingControlOptions;

    public DrawingOptions() {
    }

    public PolygonOptions getPolygonOptions() {
        return polygonOptions;
    }

    public void setPolygonOptions(PolygonOptions polygonOptions) {
        this.polygonOptions = polygonOptions;
    }

    public CircleOptions getCircleOptions() {
        return circleOptions;
    }

    public void setCircleOptions(CircleOptions circleOptions) {
        this.circleOptions = circleOptions;
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

    public DrawingControlOptions getDrawingControlOptions() {
        return drawingControlOptions;
    }

    public void setDrawingControlOptions(DrawingControlOptions drawingControlOptions) {
        this.drawingControlOptions = drawingControlOptions;
    }
}