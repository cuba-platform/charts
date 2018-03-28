/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.pivottable.events;

import com.vaadin.ui.Component;

import javax.annotation.Nullable;
import java.util.Map;

public class CellClickEvent extends com.vaadin.ui.Component.Event {
    protected Double value;
    protected Map<String, String> filters;

    public CellClickEvent(Component source, Double value, Map<String, String> filters) {
        super(source);
        this.value = value;
        this.filters = filters;
    }

    @Nullable
    public Double getValue() {
        return value;
    }

    public Map<String, String> getFilters() {
        return filters;
    }
}
