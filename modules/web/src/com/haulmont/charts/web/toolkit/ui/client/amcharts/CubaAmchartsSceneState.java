/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts;

import com.vaadin.shared.AbstractComponentState;

public class CubaAmchartsSceneState extends AbstractComponentState {

    public static final String CHART_CLICK_EVENT = "cc";
    public static final String CHART_RIGHT_CLICK_EVENT = "crc";
    public static final String GRAPH_CLICK_EVENT = "gc";
    public static final String GRAPH_ITEM_CLICK_EVENT = "gic";
    public static final String GRAPH_ITEM_RIGHT_CLICK_EVENT = "girc";
    public static final String ZOOM_EVENT = "z";
    public static final String SLICE_CLICK_EVENT = "sc";
    public static final String SLICE_RIGHT_CLICK_EVENT = "src";
    public static final String SLICE_PULL_IN_EVENT = "spi";
    public static final String SLICE_PULL_OUT_EVENT = "spo";
    public static final String LEGEND_LABEL_CLICK_EVENT = "llc";
    public static final String LEGEND_MARKER_CLICK_EVENT = "lmc";
    public static final String LEGEND_ITEM_SHOW_EVENT = "lsi";
    public static final String LEGEND_ITEM_HIDE_EVENT = "lhi";
    public static final String CURSOR_ZOOM_EVENT = "cz";
    public static final String CURSOR_PERIOD_SELECT_EVENT = "cps";
    public static final String VALUE_AXIS_ZOOM_EVENT = "vaz";

    public String json;
    public String configuration;

    // Force state change on client
    public int version = 0;
}