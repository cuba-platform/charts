/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * JavaScript function definition. <br/>
 * Code example: <code>new JsFunction("function (event) { alert(event); }");</code>
 *
 * @deprecated use {@link com.haulmont.charts.gui.model.JsFunction} instead
 */
@Deprecated
public class JsFunction extends com.haulmont.charts.gui.model.JsFunction {
    private static final long serialVersionUID = 7614774685832973416L;

    public JsFunction(String code) {
        super(code);
    }
}