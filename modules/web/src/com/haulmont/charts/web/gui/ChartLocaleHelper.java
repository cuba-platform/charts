/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui;

import com.haulmont.charts.gui.amcharts.model.DayOfWeek;
import com.haulmont.charts.gui.amcharts.model.Month;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Messages;

import java.util.*;

public final class ChartLocaleHelper {

    private ChartLocaleHelper() {
    }

    public static Map<String, Object> getChartLocaleMap(Locale locale) {

        Map<String, Object> chartLocaleMap = new LinkedHashMap<>();
        Messages messages = AppBeans.get(Messages.class);

        // day of week
        List<String> dayNames = new LinkedList<>();
        List<String> shortDayNames = new LinkedList<>();
        for (DayOfWeek day : DayOfWeek.values()) {
            dayNames.add(messages.getMainMessage("amcharts.dayNames." + day.name(), locale));
            shortDayNames.add(messages.getMainMessage("amcharts.shortDayNames." + day.name(), locale));
        }
        chartLocaleMap.put("dayNames", dayNames);
        chartLocaleMap.put("shortDayNames", shortDayNames);

        // months
        List<String> monthNames = new LinkedList<>();
        List<String> shortMonthNames = new LinkedList<>();
        for (Month m : Month.values()) {
            monthNames.add(messages.getMainMessage("amcharts.monthNames." + m.name(), locale));
            shortMonthNames.add(messages.getMainMessage("amcharts.shortMonthNames." + m.name(), locale));
        }
        chartLocaleMap.put("monthNames", monthNames);
        chartLocaleMap.put("shortMonthNames", shortMonthNames);

        // formatting time
        chartLocaleMap.put("am", messages.getMainMessage("amcharts.am", locale));
        chartLocaleMap.put("pm", messages.getMainMessage("amcharts.pm", locale));

        return chartLocaleMap;
    }

    public static Map<String, String> getExportLocaleMap(Locale locale) {

        Map<String, String> exportLocaleMap = new LinkedHashMap<>();
        Messages messages = AppBeans.get(Messages.class);

        exportLocaleMap.put("fallback.save.text", messages.getMainMessage("fallback.save.text", locale));
        exportLocaleMap.put("fallback.save.image", messages.getMainMessage("fallback.save.image", locale));

        exportLocaleMap.put("capturing.delayed.menu.label", messages.getMainMessage("capturing.delayed.menu.label", locale));
        exportLocaleMap.put("capturing.delayed.menu.title", messages.getMainMessage("capturing.delayed.menu.title", locale));

        exportLocaleMap.put("menu.label.print", messages.getMainMessage("menu.label.print", locale));
        exportLocaleMap.put("menu.label.undo", messages.getMainMessage("menu.label.undo", locale));
        exportLocaleMap.put("menu.label.redo", messages.getMainMessage("menu.label.redo", locale));
        exportLocaleMap.put("menu.label.cancel", messages.getMainMessage("menu.label.cancel", locale));

        exportLocaleMap.put("menu.label.save.image", messages.getMainMessage("menu.label.save.image", locale));
        exportLocaleMap.put("menu.label.save.data", messages.getMainMessage("menu.label.save.data", locale));

        exportLocaleMap.put("menu.label.draw", messages.getMainMessage("menu.label.draw", locale));
        exportLocaleMap.put("menu.label.draw.change", messages.getMainMessage("menu.label.draw.change", locale));
        exportLocaleMap.put("menu.label.draw.add", messages.getMainMessage("menu.label.draw.add", locale));
        exportLocaleMap.put("menu.label.draw.shapes", messages.getMainMessage("menu.label.draw.shapes", locale));
        exportLocaleMap.put("menu.label.draw.colors", messages.getMainMessage("menu.label.draw.colors", locale));
        exportLocaleMap.put("menu.label.draw.widths", messages.getMainMessage("menu.label.draw.widths", locale));
        exportLocaleMap.put("menu.label.draw.opacities", messages.getMainMessage("menu.label.draw.opacities", locale));
        exportLocaleMap.put("menu.label.draw.text", messages.getMainMessage("menu.label.draw.text", locale));

        exportLocaleMap.put("menu.label.draw.modes", messages.getMainMessage("menu.label.draw.modes", locale));
        exportLocaleMap.put("menu.label.draw.modes.pencil", messages.getMainMessage("menu.label.draw.modes.pencil", locale));
        exportLocaleMap.put("menu.label.draw.modes.line", messages.getMainMessage("menu.label.draw.modes.line", locale));
        exportLocaleMap.put("menu.label.draw.modes.arrow", messages.getMainMessage("menu.label.draw.modes.arrow", locale));

        return exportLocaleMap;
    }
}
