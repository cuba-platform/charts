/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONParser;

/**
 * @author artamonov
 * @version $Id$
 */
public class AmchartsConfig extends JavaScriptObject {

    protected AmchartsConfig() {

    }

    public static AmchartsConfig fromServerConfig(String config) {
        return (AmchartsConfig) JSONParser.parseLenient(config).isObject().getJavaScriptObject();
    }
}