/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.pivottable;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.haulmont.charts.web.toolkit.ui.client.pivottable.events.RefreshHandler;

@SuppressWarnings("WeakerAccess")
public class CubaPivotTableJsOverlay {
    protected JavaScriptObject pivotTable;

    public CubaPivotTableJsOverlay(JavaScriptObject pivotTable) {
        this.pivotTable = pivotTable;
    }

    public static CubaPivotTableJsOverlay makePivot(Element placeHolder, JavaScriptObject configObject,
                                                    RefreshHandler refreshHandler) {
        return new CubaPivotTableJsOverlay(makeJsPivotTable(placeHolder, configObject, refreshHandler));
    }

    protected static native JavaScriptObject makeJsPivotTable(Element placeHolder, JavaScriptObject configObject,
                                                              RefreshHandler handler) /*-{
        if (handler) {
            configObject.options["onRefresh"] = $entry(function () {
                handler.@com.haulmont.charts.web.toolkit.ui.client.pivottable.events.RefreshHandler::onRefresh()();
            });
        }

        var localeCode = configObject.options.localeCode;
        if (configObject.options.editable) {
            return $wnd.jQuery(placeHolder).pivotUI(configObject.data, configObject.options, false, localeCode);
        } else {
            return $wnd.jQuery(placeHolder).pivot(configObject.data, configObject.options);
        }
    }-*/;
}
