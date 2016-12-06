/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.pivottable;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Widget;

@SuppressWarnings("WeakerAccess")
public class CubaPivotTableSceneWidget extends Widget {

    protected CubaPivotTableJsOverlay jsOverlay;

    public CubaPivotTableSceneWidget() {
        setElement(Document.get().createDivElement());
        setStyleName("c-pivot-table");
    }

    public void init(PivotTableConfig config, PivotTableEvents events) {
        jsOverlay = CubaPivotTableJsOverlay.makePivot(getElement(), config, events.getRefreshHandler());
    }
}
