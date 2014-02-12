/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui.components.charts.amcharts;

import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.amcharts.model.charts.AbstractChart;
import com.haulmont.charts.gui.amcharts.model.charts.RectangularChart;
import com.haulmont.charts.gui.amcharts.model.charts.SerialChart;
import com.haulmont.charts.gui.components.charts.Chart;
import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsIntegration;
import com.haulmont.charts.web.toolkit.ui.amcharts.CubaAmchartsScene;
import com.haulmont.chile.core.datatypes.Datatypes;
import com.haulmont.chile.core.datatypes.FormatStrings;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.web.gui.components.WebAbstractComponent;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.ObjectUtils;

import java.text.DecimalFormatSymbols;
import java.util.LinkedList;
import java.util.List;

/**
 * @author artamonov
 * @version $Id$
 */
public class WebChart extends WebAbstractComponent<CubaAmchartsScene> implements Chart {

    public static final String AMCHARTS_MESSAGE_PACK = "com.haulmont.charts.gui.amcharts";

    public static final String DEFAULT_JS_DATE_FORMAT = "YYYY-MM-DD JJ:NN:SS:QQQ";

    protected boolean byDate = false;

    protected Messages messages = AppBeans.get(Messages.class);

    protected UserSessionSource userSessionSource = AppBeans.get(UserSessionSource.class);

    public WebChart() {
        initLocale();

        component = new CubaAmchartsSceneExt();
    }

    protected void initLocale() {
        CubaAmchartsIntegration amchartsIntegration = CubaAmchartsIntegration.get();
        if (amchartsIntegration.getSettings() == null
                || !ObjectUtils.equals(userSessionSource.getLocale(), amchartsIntegration.getLocale())) {

            Settings settings = new Settings();

            // day of week
            List<String> dayNames = new LinkedList<>();
            List<String> shortDayNames = new LinkedList<>();
            for (DayOfWeek day : DayOfWeek.values()) {
                dayNames.add(messages.getMessage(AMCHARTS_MESSAGE_PACK, "amcharts.dayNames." + day.name()));
                shortDayNames.add(messages.getMessage(AMCHARTS_MESSAGE_PACK, "amcharts.shortDayNames." + day.name()));
            }
            settings.setDayNames(dayNames);
            settings.setShortDayNames(shortDayNames);

            // months
            List<String> monthNames = new LinkedList<>();
            List<String> shortMonthNames = new LinkedList<>();
            for (Month m : Month.values()) {
                monthNames.add(messages.getMessage(AMCHARTS_MESSAGE_PACK, "amcharts.monthNames." + m.name()));
                shortMonthNames.add(messages.getMessage(AMCHARTS_MESSAGE_PACK, "amcharts.shortMonthNames." + m.name()));
            }
            settings.setMonthNames(monthNames);
            settings.setShortMonthNames(shortMonthNames);

            amchartsIntegration.setSettings(settings);
            amchartsIntegration.setLocale(userSessionSource.getLocale());
        }
    }

    public boolean isByDate() {
        return byDate;
    }

    public void setByDate(boolean byDate) {
        this.byDate = byDate;
    }

    @Override
    public AbstractChart getConfiguration() {
        return component.getChart();
    }

    @Override
    public void setConfiguration(AbstractChart chart) {
        component.drawChart(chart);
    }

    protected class CubaAmchartsSceneExt extends CubaAmchartsScene {

        @Override
        protected void setupDefaults(AbstractChart chart) {
            super.setupDefaults(chart);

            setupChartLocale(chart);

            if (chart instanceof RectangularChart) {
                setupRectangularChartDefaults((RectangularChart) chart);
            }
            if (chart instanceof SerialChart) {
                setupSerialChartDefaults((SerialChart) chart);
            }
        }

        protected void setupChartLocale(AbstractChart chart) {
            // number formatting
            FormatStrings formatStrings = Datatypes.getFormatStrings(userSessionSource.getLocale());
            if (formatStrings != null) {
                DecimalFormatSymbols formatSymbols = formatStrings.getFormatSymbols();

                if (chart.getNumberFormatter() == null) {
                    chart.setNumberFormatter(new NumberFormatter()
                            .setPrecision(-1)
                            .setDecimalSeparator(Character.toString(formatSymbols.getDecimalSeparator()))
                            .setThousandsSeparator(Character.toString(formatSymbols.getGroupingSeparator())));
                }
                if (chart.getPercentFormatter() == null) {
                    chart.setPercentFormatter(new NumberFormatter()
                            .setPrecision(2)
                            .setDecimalSeparator(Character.toString(formatSymbols.getDecimalSeparator()))
                            .setThousandsSeparator(Character.toString(formatSymbols.getGroupingSeparator())));
                }
            }

            // number prefixes
            if (BooleanUtils.isTrue(chart.getUsePrefixes())) {
                if (chart.getPrefixesOfBigNumbers() == null) {
                    List<BigNumberPrefix> prefixes = new LinkedList<>();
                    for (BigNumberPower power : BigNumberPower.values()) {
                        prefixes.add(new BigNumberPrefix(power,
                                messages.getMessage(AMCHARTS_MESSAGE_PACK, "amcharts.bigNumberPower." + power.name())));
                    }
                    chart.setPrefixesOfBigNumbers(prefixes);
                }
                if (chart.getPrefixesOfSmallNumbers() == null) {
                    List<SmallNumberPrefix> prefixes = new LinkedList<>();
                    for (SmallNumberPower power : SmallNumberPower.values()) {
                        prefixes.add(new SmallNumberPrefix(power,
                                messages.getMessage(AMCHARTS_MESSAGE_PACK, "amcharts.smallNumberPower." + power.name())));
                    }
                    chart.setPrefixesOfSmallNumbers(prefixes);
                }
            }
        }

        protected void setupRectangularChartDefaults(RectangularChart chart) {
            if (chart.getZoomOutText() == null) {
                chart.setZoomOutText(messages.getMessage(AMCHARTS_MESSAGE_PACK, "amcharts.zoomOutText"));
            }
        }

        protected void setupSerialChartDefaults(SerialChart chart) {
            if (byDate) {
                CategoryAxis categoryAxis = chart.getCategoryAxis();
                if (categoryAxis == null) {
                    categoryAxis = new CategoryAxis();
                    chart.setCategoryAxis(categoryAxis);
                }

                String firstDayOfWeek = messages.getMessage(AMCHARTS_MESSAGE_PACK, "amcharts.firstDayOfWeek");
                if (categoryAxis.getFirstDayOfWeek() == null) {
                    categoryAxis.setFirstDayOfWeek(DayOfWeek.valueOf(firstDayOfWeek));
                }

                if (chart.getCategoryAxis().getParseDates() == null) {
                    chart.getCategoryAxis().setParseDates(true);
                }

                if (chart.getDataDateFormat() == null) {
                    chart.setDataDateFormat(DEFAULT_JS_DATE_FORMAT);
                }
            }
        }
    }
}