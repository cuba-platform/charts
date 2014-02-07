/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import java.io.Serializable;

/**
 * @author artamonov
 * @version $Id$
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