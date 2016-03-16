/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amstockcharts;

import com.vaadin.shared.AbstractComponentState;

/**
 */
public class CubaAmStockChartSceneState extends AbstractComponentState {

    public static final String CHART_CLICK_EVENT = "scc";
    public static final String CHART_RIGHT_CLICK_EVENT = "scrc";
    public static final String STOCK_EVENT_CLICK_EVENT = "sec";
    public static final String STOCK_EVENT_ROLL_OUT_EVENT = "serout";
    public static final String STOCK_EVENT_ROLL_OVER_EVENT = "sero";
    public static final String STOCK_ZOOM_EVENT = "sz";
    public static final String PERIOD_SELECTOR_CHANGE_EVENT = "psc";
    public static final String DATA_SET_SELECTOR_COMPARE_EVENT = "dssc";
    public static final String DATA_SET_SELECTOR_SELECT_EVENT = "dsss";
    public static final String DATA_SET_SELECTOR_UNCOMPARE_EVENT = "dssu";
    public static final String STOCK_GRAPH_CLICK_EVENT = "sgc";
    public static final String STOCK_GRAPH_ROLL_OUT_EVENT = "sgrout";
    public static final String STOCK_GRAPH_ROLL_OVER_EVENT = "sgro";
    public static final String STOCK_GRAPH_ITEM_CLICK_EVENT = "sgic";
    public static final String STOCK_GRAPH_ITEM_RIGHT_CLICK_EVENT = "sgirc";
    public static final String STOCK_GRAPH_ITEM_ROLL_OUT_EVENT = "sgirout";
    public static final String STOCK_GRAPH_ITEM_ROLL_OVER_EVENT = "sgiro";

    public String json;
    public String configuration;

    // Force state change on client
    public int version = 0;
}
