/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONParser;
import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsIntegration;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.shared.ui.Connect;

import java.util.Map;

/**
 * @author artamonov
 * @version $Id$
 */
@Connect(CubaAmchartsIntegration.class)
public class CubaAmchartsIntegrationConnector extends AbstractExtensionConnector {

    @Override
    public CubaAmchartsIntegrationState getState() {
        return (CubaAmchartsIntegrationState) super.getState();
    }

    @Override
    protected void extend(ServerConnector target) {
        // do nothing
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        if (stateChangeEvent.hasPropertyChanged("version") && getState().json != null) {
            JavaScriptObject options = JSONParser.parseLenient(getState().json).isObject().getJavaScriptObject();
            applyOptions(options);
        }

        if (stateChangeEvent.hasPropertyChanged("chartMessages") && getState().chartMessages != null) {
            Map<String, String> chartMessages = getState().chartMessages;
            for (final Map.Entry<String, String> entry : chartMessages.entrySet()) {
                JavaScriptObject chartLocalization = JSONParser.parseLenient(entry.getValue()).isObject().getJavaScriptObject();
                applyChartMessages(entry.getKey(), chartLocalization);
            }
        }

        if (stateChangeEvent.hasPropertyChanged("exportMessages") && getState().exportMessages != null) {
            Map<String, String> exportMessages = getState().exportMessages;
            for (final Map.Entry<String, String> entry : exportMessages.entrySet()) {
                JavaScriptObject exportLocalization = JSONParser.parseLenient(entry.getValue()).isObject().getJavaScriptObject();
                applyExportMessages(entry.getKey(), exportLocalization);
            }
        }
    }

    private native void applyChartMessages(String localeCode, JavaScriptObject chartMessages) /*-{
        $wnd.AmCharts.translations[localeCode] = chartMessages;
    }-*/;

    private native void applyExportMessages(String localeCode, JavaScriptObject exportMessages) /*-{
        $wnd.AmCharts.translations['export'][localeCode] = exportMessages;
    }-*/;

    private native void applyOptions(JavaScriptObject options) /*-{
        var merge = function (dst, src) {
            for (var property in src) {
                if (src.hasOwnProperty(property)) {
                    if (src[property] && typeof src[property] === "object") {
                        if (!dst[property]) {
                            dst[property] = src[property];
                        } else {
                            arguments.callee(dst[property], src[property]);
                        }
                    } else {
                        dst[property] = src[property];
                    }
                }
            }
        };
        merge($wnd.AmCharts, options);
    }-*/;
}