/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.haulmont.charts.gui.amcharts.model.charts.StockChartGroup;
import com.haulmont.charts.gui.amcharts.model.charts.StockPanel;
import com.haulmont.charts.gui.amcharts.model.gson.ChartDataItemsSerializer;
import com.haulmont.charts.gui.amcharts.model.gson.StockChartSerializer;
import com.haulmont.charts.gui.data.DataProvider;
import com.haulmont.charts.gui.data.ListDataProvider;
import com.haulmont.charts.gui.data.MapDataItem;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.haulmont.charts.gui.amcharts.model.ChartSampleJsonHelper.*;
import static org.junit.Assert.assertEquals;

public class StockChartSerializationTest {

    private SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);

    @Test
    public void testStockChartWithMultipleDataSets() throws ParseException, IOException, URISyntaxException {
        ListDataProvider chartData1 = new ListDataProvider();
        populateDataProvider(chartData1, 40L, 100L, 1000L, 500L, 2L);
        ListDataProvider chartData2 = new ListDataProvider();
        populateDataProvider(chartData2, 100L, 200L, 1000L, 600L, 2L);
        ListDataProvider chartData3 = new ListDataProvider();
        populateDataProvider(chartData3, 100L, 200L, 1000L, 600L, 2L);
        ListDataProvider chartData4 = new ListDataProvider();
        populateDataProvider(chartData4, 100L, 200L, 100L, 600L, 1L);

        StockChartGroup stockChart = new StockChartGroup()
                .addDataSets(
                        new DataSet().setId("dataSet1").setTitle("first data set").setDataProvider(chartData1)
                                .setCategoryField("date")
                                .addFieldMappings(
                                        new FieldMapping().setFromField("value").setToField("value"),
                                        new FieldMapping().setFromField("volume").setToField("volume")),
                        new DataSet().setId("dataSet2").setTitle("second data set").setDataProvider(chartData2)
                                .setCategoryField("date")
                                .addFieldMappings(
                                        new FieldMapping().setFromField("value").setToField("value"),
                                        new FieldMapping().setFromField("volume").setToField("volume")),
                        new DataSet().setId("dataSet3").setTitle("third data set").setDataProvider(chartData3)
                                .setCategoryField("date")
                                .addFieldMappings(
                                        new FieldMapping().setFromField("value").setToField("value"),
                                        new FieldMapping().setFromField("volume").setToField("volume")),
                        new DataSet().setId("dataSet4").setTitle("forth data set").setDataProvider(chartData4)
                                .setCategoryField("date")
                                .addFieldMappings(
                                        new FieldMapping().setFromField("value").setToField("value"),
                                        new FieldMapping().setFromField("volume").setToField("volume")))
                .addPanels(
                        new StockPanel().setId("panel1").setShowCategoryAxis(false).setTitle("Value").setPercentHeight(70)
                                .addStockGraphs(new StockGraph().setId("sg1").setValueField("value").setComparable(true)
                                        .setCompareField("value").setBalloonText("[[title]]:&lt;b&gt;[[value]]&lt;/b&gt;")
                                        .setCompareGraphBalloonText("[[title]]:&lt;b&gt;[[value]]&lt;/b&gt;"))
                                .setStockLegend(new StockLegend().setPeriodValueTextComparing("[[percents.value.close]]%")
                                        .setPeriodValueTextRegular("[[value.close]]")),
                        new StockPanel().setId("panel2").setTitle("Volume").setPercentHeight(30)
                                .addStockGraphs(new StockGraph().setValueField("volume").setType(GraphType.COLUMN)
                                        .setShowBalloon(false).setFillAlphas(1.0))
                                .setStockLegend(new StockLegend().setPeriodValueTextRegular("[[value.close]]")))
                .setChartScrollbarSettings(new ChartScrollbarSettings().setGraph("sg1"))
                .setChartCursorSettings(new ChartCursorSettings().setValueBalloonsEnabled(true).setValueLineAlpha(0.5)
                        .setCursorAlpha(0.1).setValueBalloonsEnabled(true).setValueLineEnabled(true).setFullWidth(true))
                .setPeriodSelector(new PeriodSelector().addPeriods(
                        new Period().setPeriod(PeriodType.MONTHS).setSelected(true).setCount(1).setLabel("1 month"),
                        new Period().setPeriod(PeriodType.YEARS).setCount(1).setLabel("1 year"),
                        new Period().setPeriod(PeriodType.YTD).setLabel("YTD"),
                        new Period().setPeriod(PeriodType.MAX).setLabel("MAX")))
                .setDataSetSelector(new DataSetSelector().setPosition(Position.LEFT))
                .setExport(new Export());

        StockChartSerializer serializer = getTestSerializer();

        String json = serializer.serialize(stockChart);
        String expected = readFile("StockChartWithMultipleDataSets.json");

        assertEquals(prettyJson(expected), prettyJson(json));
    }

    @Test
    public void testStockChartWithIntradayDatas() throws ParseException, IOException, URISyntaxException {
        ListDataProvider chartData = new ListDataProvider();
        populateStockDatasourceWithTime(chartData, 40L, 100L);

        StockChartGroup stockChart = new StockChartGroup()
                .setCategoryAxesSettings(new CategoryAxesSettings().setMinPeriod("mm"))
                .addDataSets(new DataSet().setId("dataSet").setDataProvider(chartData)
                        .setColor(Color.valueOf("#b0de09")).setCategoryField("date")
                        .addFieldMappings(
                                new FieldMapping().setFromField("value").setToField("value"),
                                new FieldMapping().setFromField("volume").setToField("volume")))
                .addPanels(
                        new StockPanel().setId("p1").setTitle("Value").setPercentHeight(70).setShowCategoryAxis(false)
                                .addStockGraphs(new StockGraph().setId("sg4").setValueField("value").setLineThickness(2)
                                        .setType(GraphType.SMOOTHED_LINE).setBullet(BulletType.ROUND))
                                .setStockLegend(new StockLegend().setValueTextRegular(" ")
                                        .setMarkerType(MarkerType.NONE)),
                        new StockPanel().setId("p2").setTitle("Volume").setPercentHeight(30)
                                .addStockGraphs(new StockGraph().setValueField("volume").setCornerRadiusTop(2)
                                        .setType(GraphType.COLUMN).setFillAlphas(1.0))
                                .setStockLegend(new StockLegend().setValueTextRegular(" ")
                                        .setMarkerType(MarkerType.NONE)))
                .setChartScrollbarSettings(new ChartScrollbarSettings().setGraph("sg4").setUsePeriod("10mm")
                        .setPosition(ChartScrollbarPosition.TOP))
                .setChartCursorSettings(new ChartCursorSettings().setValueLineBalloonEnabled(true))
                .setPeriodSelector(new PeriodSelector().setPosition(Position.TOP).setInputFieldWidth(150)
                        .addPeriods(
                                new Period().setPeriod(PeriodType.HOURS).setCount(1).setLabel("1 hour").setSelected(true),
                                new Period().setPeriod(PeriodType.HOURS).setCount(2).setLabel("2 hours"),
                                new Period().setPeriod(PeriodType.HOURS).setCount(5).setLabel("5 hours"),
                                new Period().setPeriod(PeriodType.HOURS).setCount(12).setLabel("12 hours"),
                                new Period().setPeriod(PeriodType.MAX).setLabel("MAX")))
                .setPanelsSettings(new PanelsSettings().setUsePrefixes(true))
                .setExport(new Export().setPosition(ExportPosition.BOTTOM_RIGHT));

        StockChartSerializer serializer = getTestSerializer();

        String json = serializer.serialize(stockChart);
        String expected = readFile("StockChartWithIntradayDatas.json");

        assertEquals(prettyJson(expected), prettyJson(json));
    }

    private void populateDataProvider(DataProvider dataProvider,
                                      long valueX1, long valueX2, long volumeX1, long volumeX2, long volumeX3)
            throws ParseException {
        int daysCount = 10;
        Date date = df.parse("2012-01-01");
        date = getZeroTime(date);
        for (int i = 0; i < daysCount; i++) {
            Long value = valueX1 + valueX2 + i;
            Long volume = volumeX1 + volumeX2 + volumeX3 + i;
            dataProvider.addItem(dateValueVolume(i, DateUtils.addDays(date, i), value, volume));
        }
    }

    private void populateStockDatasourceWithTime(DataProvider dataProvider, long valueX1, long valueX2) throws ParseException {
        int hoursCount = 10;
        Date date = df.parse("2012-01-01");
        date = getZeroTime(date);
        for (int i = 0; i < hoursCount; i++) {
            Long value = valueX1 + valueX2 + i;
            Long volume = 100000000L * i;
            dataProvider.addItem(dateValueVolume(i, DateUtils.addMinutes(date, i), value, volume));
        }
    }

    private MapDataItem dateValueVolume(Integer id, Date date, Long value, Long volume) {
        MapDataItem dateValueVolume = new MapDataItem();
        dateValueVolume.add("id", id);
        dateValueVolume.add("date", date);
        dateValueVolume.add("value", value);
        dateValueVolume.add("volume", volume);
        return dateValueVolume;
    }

    private Date getZeroTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private StockChartSerializer getTestSerializer() {
        return new TestStockChartSerializer();
    }

    private static class TestStockChartSerializer extends StockChartSerializer {
        public TestStockChartSerializer() {
            super(dataItem -> String.valueOf(dataItem.getValue("id")));
        }

        @Override
        protected ChartDataItemsSerializer getDataItemsSerializer() {
            return new ChartDataItemsSerializer();
        }
    }
}