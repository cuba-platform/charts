/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.pivottable.events;

import com.google.gwt.core.client.JavaScriptObject;

public class JsRefreshEvent extends JavaScriptObject {

    protected JsRefreshEvent() {
    }

    public final native String[] getRows() /*-{
        return this.rows;
    }-*/;

    public final native String[] getCols() /*-{
        return this.cols;
    }-*/;

    public final native String getRenderer() /*-{
        var keyByValue = function getKeyByValue(object, value) {
            return Object.keys(object).find(function (key) {
                return object[key] === value
            });
        };

        var localeMapping = $wnd.$.pivotUtilities.locales[this.localeCode].renderersLocaleMapping;
        return keyByValue(localeMapping, this.rendererName);
    }-*/;

    public final native String getAggregation() /*-{
        return this.aggregatorsIds[this.aggregatorName];
    }-*/;

    public final native String[] getAggregationProperties() /*-{
        return this.vals;
    }-*/;
}
