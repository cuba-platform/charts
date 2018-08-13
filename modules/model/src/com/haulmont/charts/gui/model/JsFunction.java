/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.model;

import java.io.Serializable;

/**
 * JavaScript function definition. <br>
 * Code example:
 * <pre>
 *  &#64;Inject
 *  private SerialChart serialChart;
 *  ...
 *  Graph graph = serialChart.getGraphs().get(0);
 *  graph.setBalloonFunction(new JsFunction(
 *      "function(event){"
 *          + "var result = 'Income in ' + event.category + ': '"
 *          + "+ event.serialDataItem.dataContext.expenses;"
 *          + "return result;}"));
 * </pre>
 */
public class JsFunction implements Serializable {

    private static final long serialVersionUID = 7614774685832973416L;

    private String code;

    public JsFunction(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}