/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model;

import java.io.Serializable;

/**
 * JavaScript function definition. <br/>
 * Code example: <code>new JsFunction("function (event) { alert(event); }");</code>
 *
 */
public class PivotJsFunction implements Serializable {

    private static final long serialVersionUID = -6420221017693315595L;

    private String code;

    public PivotJsFunction(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}