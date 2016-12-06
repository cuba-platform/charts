/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.pivottable.events;

import com.haulmont.charts.web.toolkit.ui.pivottable.CubaPivotTableScene;

public class RefreshEvent extends com.vaadin.ui.Component.Event {

    private static final long serialVersionUID = -5007279701639243292L;

    public RefreshEvent(CubaPivotTableScene source) {
        super(source);
    }
}
