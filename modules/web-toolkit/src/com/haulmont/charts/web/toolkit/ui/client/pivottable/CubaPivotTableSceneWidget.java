/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.pivottable;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.Widget;

public class CubaPivotTableSceneWidget extends Widget implements HasEnabled {

    protected static final String EMPTY_DATA_STYLE = "empty";

    protected CubaPivotTableJsOverlay jsOverlay;
    protected boolean enabled = true;

    public CubaPivotTableSceneWidget() {
        setElement(Document.get().createDivElement());
        setStyleName("c-pivot-table");
    }

    public void init(PivotTableConfig config, PivotTableEvents events) {
        jsOverlay = CubaPivotTableJsOverlay.makePivot(getElement(), config, events.getRefreshHandler(), enabled);
        setShowEmptyDataMessage(!config.hasData());
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    protected void setShowEmptyDataMessage(boolean showEmptyDataMessage) {
        if (showEmptyDataMessage) {
            addStyleDependentName(EMPTY_DATA_STYLE);
        } else {
            removeStyleDependentName(EMPTY_DATA_STYLE);
        }
    }
}
