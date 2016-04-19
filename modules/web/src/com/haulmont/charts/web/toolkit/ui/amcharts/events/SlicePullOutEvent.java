/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts.events;

import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsScene;

/**
 */
public class SlicePullOutEvent extends AbstractSlicePullEvent {

    private static final long serialVersionUID = -536343761071370040L;

    public SlicePullOutEvent(CubaAmchartsScene scene, String sliceId) {
        super(scene, sliceId);
    }
}