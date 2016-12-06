/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.pivottable;

import com.vaadin.shared.AbstractComponentState;

import java.util.Map;

public class CubaPivotTableSceneState extends AbstractComponentState {

    {
        primaryStyleName = "c-pivot-table";
    }

    public static final String REFRESH_EVENT = "r";

    public String data;
    public String options;
    public String json;

    // key: language; value: messagesMap as json
    public Map<String, String> pivotTableMessages;

    // Force state change on client
    public int version = 0;
}
