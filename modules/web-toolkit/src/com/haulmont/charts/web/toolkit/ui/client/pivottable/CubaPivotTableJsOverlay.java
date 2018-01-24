/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.pivottable;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.haulmont.charts.web.toolkit.ui.client.pivottable.events.JsRefreshEvent;

import java.util.function.Consumer;

public class CubaPivotTableJsOverlay {
    protected JavaScriptObject pivotTable;

    public CubaPivotTableJsOverlay(JavaScriptObject pivotTable) {
        this.pivotTable = pivotTable;
    }

    public static CubaPivotTableJsOverlay makePivot(Element placeHolder, JavaScriptObject configObject,
                                                    Consumer<JsRefreshEvent> refreshHandler, boolean enabled) {
        return new CubaPivotTableJsOverlay(makeJsPivotTable(placeHolder, configObject, refreshHandler, enabled));
    }

    protected static native JavaScriptObject makeJsPivotTable(Element placeHolder, JavaScriptObject configObject,
                                                              Consumer<JsRefreshEvent> handler, boolean enabled) /*-{
        if (handler) {
            configObject.options["onRefresh"] = $entry(function (config) {
                handler.@java.util.function.Consumer::accept(*)(config);
            });
        }

        if (configObject.options.editable) {
            var pivot = $wnd.jQuery(placeHolder).pivotUI(configObject.data,
                configObject.options, false, configObject.options.localeCode);

            if (!enabled) {
                pivot.find("select").attr('disabled', 'disabled');
            }

            return pivot;
        } else {
            return $wnd.jQuery(placeHolder).pivot(configObject.data, configObject.options);
        }
    }-*/;
}
