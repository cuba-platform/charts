/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.charts.amcharts;

import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.amcharts.model.charts.AbstractChart;
import com.haulmont.charts.gui.amcharts.model.charts.AbstractSerialChart;
import com.haulmont.charts.gui.amcharts.model.charts.RectangularChart;
import com.haulmont.charts.web.gui.serialization.CubaChartSerializer;
import com.haulmont.charts.web.widgets.amcharts.serialization.ChartJsonSerializationContext;
import com.haulmont.charts.gui.components.charts.CustomChart;
import com.haulmont.charts.web.gui.ChartLocaleHelper;
import com.haulmont.charts.web.widgets.amcharts.CubaAmchartsIntegration;
import com.haulmont.charts.web.widgets.amcharts.CubaAmchartsScene;
import com.haulmont.charts.web.widgets.amcharts.serialization.ChartSerializer;
import com.haulmont.chile.core.datatypes.Datatypes;
import com.haulmont.chile.core.datatypes.FormatStrings;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.web.gui.components.WebAbstractComponent;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormatSymbols;
import java.util.*;

import static com.haulmont.bali.util.Preconditions.checkNotNullArgument;

public class WebCustomChart extends WebAbstractComponent<CubaAmchartsScene> implements CustomChart {
    protected Messages messages = AppBeans.get(Messages.class);

    public WebCustomChart() {
        initLocale();

        component = createComponent();
    }

    protected CubaAmchartsScene createComponent() {
        return new CubaAmchartsScene(createChartSerializer());
    }

    protected ChartSerializer createChartSerializer() {
        return AppBeans.getPrototype(CubaChartSerializer.NAME);
    }

    @Override
    public AbstractChart getConfiguration() {
        return component.getChart();
    }

    @Override
    public void setConfiguration(AbstractChart configuration) {
        checkNotNullArgument(configuration);

        setupDefaults(configuration);
        component.drawChart(configuration);
    }

    @Override
    public void repaint() {
        component.drawChart();
    }

    @Override
    public String getNativeJson() {
        return component.getJson();
    }

    @Override
    public void setNativeJson(String json) {
        component.setJson(json);
    }

    protected void initLocale() {
        UserSessionSource userSessionSource = AppBeans.get(UserSessionSource.class);
        CubaAmchartsIntegration amchartsIntegration = CubaAmchartsIntegration.get();
        if (amchartsIntegration.getSettings() == null
                || !Objects.equals(userSessionSource.getLocale(), amchartsIntegration.getLocale())) {
            Settings settings = new Settings();
            Locale locale = userSessionSource.getLocale();

            // chart
            String localeString = messages.getTools().localeToString(locale);
            amchartsIntegration.setChartMessages(localeString, ChartLocaleHelper.getChartLocaleMap(locale));

            // export
            amchartsIntegration.setExportMessages(localeString, ChartLocaleHelper.getExportLocaleMap(locale));

            amchartsIntegration.setSettings(settings);
            amchartsIntegration.setLocale(userSessionSource.getLocale());
        }
    }

    protected void setupDefaults(AbstractChart chart) {
        setupChartLocale(chart);

        if (chart instanceof RectangularChart) {
            setupRectangularChartDefaults((RectangularChart) chart);
        }
        if (chart instanceof AbstractSerialChart) {
            setupSerialChartDefaults((AbstractSerialChart) chart);
        }
    }

    protected void setupChartLocale(AbstractChart chart) {
        UserSessionSource userSessionSource = AppBeans.get(UserSessionSource.class);
        // language
        if (StringUtils.isEmpty(chart.getLanguage())) {
            chart.setLanguage(messages.getTools().localeToString(userSessionSource.getLocale()));
        }

        // export
        if (chart.getExport() != null && chart.getExport().getDateFormat() == null) {
            chart.getExport().setDateFormat(messages.getMainMessage("amcharts.export.dateFormat"));
        }

        // number formatting
        FormatStrings formatStrings = Datatypes.getFormatStrings(userSessionSource.getLocale());
        if (formatStrings != null) {
            DecimalFormatSymbols formatSymbols = formatStrings.getFormatSymbols();

            if (chart.getPrecision() == null) {
                chart.setPrecision(-1);
            }

            if (chart.getPercentPrecision() == null) {
                chart.setPercentPrecision(2);
            }

            if (chart.getDecimalSeparator() == null) {
                chart.setDecimalSeparator(Character.toString(formatSymbols.getDecimalSeparator()));
            }

            if (chart.getThousandsSeparator() == null) {
                chart.setThousandsSeparator(Character.toString(formatSymbols.getGroupingSeparator()));
            }
        }

        // number prefixes
        if (BooleanUtils.isTrue(chart.getUsePrefixes())) {
            if (chart.getPrefixesOfBigNumbers() == null) {
                List<BigNumberPrefix> prefixes = new ArrayList<>();
                for (BigNumberPower power : BigNumberPower.values()) {
                    prefixes.add(new BigNumberPrefix(power,
                            messages.getMainMessage("amcharts.bigNumberPower." + power.name())));
                }
                chart.setPrefixesOfBigNumbers(prefixes);
            }
            if (chart.getPrefixesOfSmallNumbers() == null) {
                List<SmallNumberPrefix> prefixes = new ArrayList<>();
                for (SmallNumberPower power : SmallNumberPower.values()) {
                    prefixes.add(new SmallNumberPrefix(power,
                            messages.getMainMessage("amcharts.smallNumberPower." + power.name())));
                }
                chart.setPrefixesOfSmallNumbers(prefixes);
            }
        }
    }

    protected void setupRectangularChartDefaults(RectangularChart chart) {
        if (chart.getZoomOutText() == null) {
            chart.setZoomOutText(messages.getMainMessage("amcharts.zoomOutText"));
        }

        Cursor cursor = chart.getChartCursor();
        if (cursor != null) {
            if (StringUtils.isEmpty(cursor.getCategoryBalloonDateFormat())) {
                String format = messages.getMainMessage("amcharts.rectangularChart.categoryBalloonDateFormat");
                cursor.setCategoryBalloonDateFormat(format);
            }
        }
    }

    protected void setupSerialChartDefaults(AbstractSerialChart chart) {
        CategoryAxis categoryAxis = chart.getCategoryAxis();
        if (categoryAxis == null) {
            categoryAxis = new CategoryAxis();
            chart.setCategoryAxis(categoryAxis);
        }

        String firstDayOfWeek = messages.getMainMessage("amcharts.firstDayOfWeek");
        if (categoryAxis.getFirstDayOfWeek() == null) {
            categoryAxis.setFirstDayOfWeek(DayOfWeek.valueOf(firstDayOfWeek));
        }

        if (StringUtils.isEmpty(chart.getDataDateFormat())) {
            chart.setDataDateFormat(ChartJsonSerializationContext.DEFAULT_JS_DATE_FORMAT);
        }

        if (StringUtils.isEmpty(chart.getBalloonDateFormat())) {
            String format = messages.getMainMessage("amcharts.serialChart.balloonDateFormat");
            chart.setBalloonDateFormat(format);
        }
    }
}