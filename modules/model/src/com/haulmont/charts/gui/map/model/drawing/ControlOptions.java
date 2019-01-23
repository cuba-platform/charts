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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ControlOptions implements Serializable {

    private static final long serialVersionUID = 10977779698792392L;

    protected Position position = Position.TOP_CENTER;
    protected List<OverlayType> drawingModes = new ArrayList<>();

    public ControlOptions() {
    }

    public ControlOptions(Position position, List<OverlayType> drawingModes) {
        this.position = position;
        this.drawingModes = drawingModes != null ? drawingModes : new ArrayList<>();
    }

    /**
     * Sets position for drawing tools toolbox.
     * Defaults to TOP_CENTER
     *
     * @param position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * @return position of drawing tools toolbox
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets drawing modes to display in drawing tools toolbox
     * @param drawingModes list of drawing modes
     */
    public void setDrawingModes(List<OverlayType> drawingModes) {
        this.drawingModes = drawingModes;
    }

    /**
     * @return list of drawing modes displayed in drawing tools toolbox
     */
    public List<OverlayType> getDrawingModes() {
        return drawingModes;
    }
}