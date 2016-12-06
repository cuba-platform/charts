/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui;

import com.haulmont.charts.gui.pivottable.model.AggregationMode;
import com.haulmont.charts.gui.pivottable.model.Renderer;
import com.haulmont.chile.core.datatypes.Datatypes;
import com.haulmont.chile.core.datatypes.FormatStrings;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Messages;

import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public final class PivotTableLocaleHelper {

    private PivotTableLocaleHelper() {
        throw new AssertionError();
    }

    public static Map<String, Object> getPivotTableLocaleMap(Locale locale) {
        Map<String, Object> localeMap = new LinkedHashMap<>();

        Messages messages = AppBeans.get(Messages.class);

        // Number formatting
        String[] formatTypes = {"floatFormat", "integerFormat", "percentFormat"};
        FormatStrings formatStrings = Datatypes.getFormatStrings(locale);

        for (String type : formatTypes) {
            Map<String, String> typeMessages = new HashMap<>();
            typeMessages.put("digitsAfterDecimal",
                    messages.getMainMessage("pivottable." + type + ".digitsAfterDecimal", locale));
            typeMessages.put("scaler", messages.getMainMessage("pivottable." + type + ".scaler", locale));
            typeMessages.put("prefix", messages.getMainMessage("pivottable." + type + ".prefix", locale));
            typeMessages.put("suffix", messages.getMainMessage("pivottable." + type + ".suffix", locale));
            typeMessages.put("showZero", messages.getMainMessage("pivottable." + type + ".showZero", locale));

            if (formatStrings != null) {
                DecimalFormatSymbols formatSymbols = formatStrings.getFormatSymbols();

                typeMessages.put("thousandsSep", Character.toString(formatSymbols.getGroupingSeparator()));
                typeMessages.put("decimalSep", Character.toString(formatSymbols.getDecimalSeparator()));
            } else {
                typeMessages.put("thousandsSep",
                        messages.getMainMessage("pivottable." + type + ".thousandsSep", locale));
                typeMessages.put("decimalSep",
                        messages.getMainMessage("pivottable." + type + ".decimalSep", locale));
            }

            localeMap.put(type, typeMessages);
        }

        if (formatStrings != null) {
            DecimalFormatSymbols formatSymbols = formatStrings.getFormatSymbols();
            localeMap.put("percentFormat.suffix", Character.toString(formatSymbols.getPercent()));
        }

        // Other
        localeMap.put("renderError", messages.getMainMessage("pivottable.renderError", locale));
        localeMap.put("computeError", messages.getMainMessage("pivottable.computeError", locale));
        localeMap.put("uiRenderError", messages.getMainMessage("pivottable.uiRenderError", locale));
        localeMap.put("selectAll", messages.getMainMessage("pivottable.selectAll", locale));
        localeMap.put("selectNone", messages.getMainMessage("pivottable.selectNone", locale));
        localeMap.put("tooMany", messages.getMainMessage("pivottable.tooMany", locale));
        localeMap.put("filterResults", messages.getMainMessage("pivottable.filterResults", locale));
        localeMap.put("totals", messages.getMainMessage("pivottable.totals", locale));
        localeMap.put("vs", messages.getMainMessage("pivottable.vs", locale));
        localeMap.put("by", messages.getMainMessage("pivottable.by", locale));

        localeMap.put("aggregation", getAggregationsLocaleMap(locale));
        localeMap.put("renderer", getRenderersLocaleMap(locale));

        return localeMap;
    }

    public static Map<String, String> getAggregationsLocaleMap(Locale locale) {
        Map<String, String> localeMap = new LinkedHashMap<>();

        Messages messages = AppBeans.get(Messages.class);

        for (AggregationMode mode : AggregationMode.values()) {
            localeMap.put(mode.getId(),
                    messages.getMainMessage("pivottable.aggregator." + mode.getId(), locale));
        }

        return localeMap;
    }

    public static Map<String, String> getRenderersLocaleMap(Locale locale) {
        Map<String, String> localeMap = new LinkedHashMap<>();

        Messages messages = AppBeans.get(Messages.class);

        for (Renderer renderer : Renderer.values()) {
            localeMap.put(renderer.getId(),
                    messages.getMainMessage("pivottable.renderer." + renderer.getId(), locale));
        }

        return localeMap;
    }
}
