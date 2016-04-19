/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts.events;

import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsScene;

public abstract class AbstractLegendItemEvent extends com.vaadin.ui.Component.Event {

    private static final long serialVersionUID = -2258433755537180205L;

    private final String itemId;

    public AbstractLegendItemEvent(CubaAmchartsScene scene, String itemId) {
        super(scene);
        this.itemId = itemId;
    }

    public String getItemId() {
        return itemId;
    }
}
