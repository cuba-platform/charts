/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model.drawing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author korotkov
 * @version $Id$
 */
public class ControlOptions {

    private static final long serialVersionUID = 10977779698792392L;

    protected Position position = Position.TOP_CENTER;
    protected List<OverlayType> drawingModes = new ArrayList<>();

    public ControlOptions() {
    }

    public ControlOptions(Position position, List<OverlayType> drawingModes) {
        this.position = position;
        this.drawingModes = drawingModes != null ? drawingModes : new ArrayList<OverlayType>();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<OverlayType> getDrawingModes() {
        return drawingModes;
    }

    public void setDrawingModes(List<OverlayType> drawingModes) {
        this.drawingModes = drawingModes;
    }
}
