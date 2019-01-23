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
import java.util.ArrayList;
import java.util.List;

public class DrawingControlOptions implements Serializable {

    private static final long serialVersionUID = 9101754209698792392L;

    protected ControlPosition position;
    protected List<OverlayType> drawingModes;

    public DrawingControlOptions() {
    }

    public DrawingControlOptions(ControlPosition position, List<OverlayType> drawingModes) {
        this.position = position;
        this.drawingModes = drawingModes != null ? drawingModes : new ArrayList<OverlayType>();
    }

    public ControlPosition getPosition() {
        return position;
    }

    public void setPosition(ControlPosition position) {
        this.position = position;
    }

    public List<OverlayType> getDrawingModes() {
        return drawingModes;
    }

    public void setDrawingModes(List<OverlayType> drawingModes) {
        this.drawingModes = drawingModes;
    }
}