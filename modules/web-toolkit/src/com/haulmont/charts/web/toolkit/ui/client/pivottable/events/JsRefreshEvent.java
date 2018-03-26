/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.pivottable.events;

import com.google.gwt.core.client.JavaScriptObject;

import java.util.List;
import java.util.Map;

public class JsRefreshEvent extends JavaScriptObject {

    protected JsRefreshEvent() {
    }

    public final native List<String> getRows() /*-{
        return this.rows;
    }-*/;

    public final native List<String> getCols() /*-{
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

    public final native List<String> getAggregationProperties() /*-{
        return this.vals;
    }-*/;

    public final native Map<String, List<String>> getInclusions() /*-{
        return this.inclusions;
    }-*/;

    public final native Map<String, List<String>> getExclusions() /*-{
        return this.exclusions;
    }-*/;

    public final native String getColumnOrder() /*-{
        return this.colOrder;
    }-*/;

    public final native String getRowOrder() /*-{
        return this.rowOrder;
    }-*/;
}
