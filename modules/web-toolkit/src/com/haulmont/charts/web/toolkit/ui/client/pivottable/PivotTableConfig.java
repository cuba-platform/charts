/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.pivottable;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONParser;
import com.haulmont.charts.web.toolkit.ui.client.utils.JsUtils;

public class PivotTableConfig extends JavaScriptObject {

    protected PivotTableConfig() {
    }

    public static PivotTableConfig fromServerConfig(String data, String options, String json) {
        PivotTableConfig configObject = JavaScriptObject.createObject().cast();

        String dataJson = data != null ? data : "[]";
        JavaScriptObject dataObject = JSONParser.parseLenient(dataJson).isArray().getJavaScriptObject();
        setData(configObject, dataObject);

        String optionsJson = options != null ? options : "{}";
        JavaScriptObject optionsObject = JSONParser.parseLenient(optionsJson).isObject().getJavaScriptObject();
        parseRenderers(optionsObject);
        parseAggregators(optionsObject);
        replaceProperties(optionsObject);
        applyLocaleStrings(optionsObject);
        JsUtils.activateFunctions(optionsObject, true);
        setOptions(configObject, optionsObject);

        JsUtils.applyCustomJson(optionsObject, json);

        return configObject;
    }

    private static void replaceProperties(JavaScriptObject config) {
        replaceProperty(config, "hiddenProperties", "hiddenAttributes");
        replaceProperty(config, "autoSortUnusedProperties", "autoSortUnusedAttrs");
        replaceProperty(config, "unusedPropertiesVertical", "unusedAttrsVertical");
        replaceProperty(config, "aggregationProperties", "vals");
        replaceProperty(config, "derivedProperties", "derivedAttributes");
    }

    private static native void replaceProperty(JavaScriptObject config, String origin, String replacer) /*-{
        if (config[origin]) {
            config[replacer] = config[origin];
            delete config[origin];
        }
    }-*/;

    private static native void setData(JavaScriptObject config, JavaScriptObject data) /*-{
        config.data = data;
    }-*/;

    private static native void setOptions(JavaScriptObject config, JavaScriptObject options) /*-{
        config.options = options;
    }-*/;

    private static native void parseRenderers(JavaScriptObject config) /*-{
        var allRenderers = $wnd.$.pivotUtilities.locales[config.localeCode].renderers;
        var localeMapping = $wnd.$.pivotUtilities.locales[config.localeCode].renderersLocaleMapping;

        if (config.editable) {
            if (config.renderers) {
                if (config.renderers.defaultRenderer) {
                    config.rendererName = localeMapping[config.renderers.defaultRenderer];
                }

                if (config.renderers.renderers) {
                    var renderers = {};
                    for (var i = 0; i < config.renderers.renderers.length; i++) {
                        var rendererName = localeMapping[config.renderers.renderers[i]];
                        var rendererFunc = allRenderers[rendererName];
                        if (rendererFunc) {
                            renderers[rendererName] = rendererFunc;
                        }
                    }
                    config.renderers = renderers;
                } else {
                    config.renderers = allRenderers;
                }
            } else {
                config.renderers = allRenderers;
            }
        } else {
            if (config.renderer) {
                config.renderer = allRenderers[localeMapping[config.renderer]];
            }
        }
    }-*/;

    private static native void parseAggregators(JavaScriptObject config) /*-{
        var allAggregators = $wnd.$.pivotUtilities.locales[config.localeCode].aggregators;
        var localeMapping = $wnd.$.pivotUtilities.locales[config.localeCode].aggregatorsLocaleMapping;

        if (config.editable) {
            if (config.aggregations) {
                if (config.aggregations.defaultAggregation) {
                    config.aggregatorName = localeMapping[config.aggregations.defaultAggregation];
                }

                var aggregations = config.aggregations.aggregations;
                if (aggregations) {
                    var aggregators = {};
                    var aggregatorsIds = {};
                    for (var i = 0; i < aggregations.length; i++) {
                        var aggregatorCaption = aggregations[i].caption;
                        var aggregationKey = aggregatorCaption;

                        if (aggregations[i].custom) {
                            aggregators[aggregationKey] = $wnd.eval("(" + aggregations[i]["function"] + ")");
                        } else {
                            var aggregatorName = localeMapping[aggregations[i].mode];
                            var aggregatorFunc = allAggregators[aggregatorName];
                            if (aggregatorFunc) {
                                aggregationKey = aggregatorCaption ? aggregatorCaption : aggregatorName;
                                aggregators[aggregationKey] = aggregatorFunc;
                                if (aggregatorCaption && config.aggregatorName == aggregatorName) {
                                    config.aggregatorName = aggregatorCaption;
                                }
                            }
                        }
                        aggregatorsIds[aggregationKey] = aggregations[i].id;
                    }
                    config.aggregators = aggregators;
                    config.aggregatorsIds = aggregatorsIds;
                }

                delete config.aggregations;
            }
        } else {
            if (config.aggregation) {
                if (config.aggregation.custom) {
                    config.aggregator = $wnd.eval("(" + config.aggregation["function"] + ")");
                } else {
                    var aggregator = allAggregators[localeMapping[config.aggregation.mode]];
                    if (config.aggregation.properties) {
                        aggregator = aggregator(config.aggregation.properties);
                    }
                    config.aggregator = aggregator;
                }

                if (config.aggregation.caption) {
                    config.aggregatorName = config.aggregation.caption;
                } else {
                    config.aggregatorName = localeMapping[config.aggregation.mode];
                }

                delete config.aggregation;
            }
        }
    }-*/;

    private static native void applyLocaleStrings(JavaScriptObject config) /*-{
        config.localeStrings = $wnd.$.pivotUtilities.locales[config.localeCode].localeStrings;
        if (!config.rendererOptions) {
            config.rendererOptions = {};
        }
        config.rendererOptions.localeStrings = config.localeStrings;
    }-*/;
}
