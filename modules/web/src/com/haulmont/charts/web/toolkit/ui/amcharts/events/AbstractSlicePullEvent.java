/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts.events;

import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsScene;

public abstract class AbstractSlicePullEvent extends com.vaadin.ui.Component.Event {

    private static final long serialVersionUID = -3625204689056222328L;

    private final String sliceId;

    public AbstractSlicePullEvent(CubaAmchartsScene scene, String sliceId) {
        super(scene);
        this.sliceId = sliceId;
    }

    public String getSliceId() {
        return sliceId;
    }
}
