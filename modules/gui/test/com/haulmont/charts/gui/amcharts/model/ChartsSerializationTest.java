/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.haulmont.bali.util.ParamsMap;
import com.haulmont.charts.gui.amcharts.model.charts.*;
import com.haulmont.charts.gui.amcharts.model.data.DataItem;
import com.haulmont.charts.gui.amcharts.model.data.ListDataProvider;
import com.haulmont.charts.gui.amcharts.model.data.MapDataItem;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ChartsSerializationTest {

    private SimpleDateFormat df = new SimpleDateFormat(ChartSampleJsonHelper.DATE_FORMAT);

    @Test
    public void testSerialChart() throws IOException, URISyntaxException, ParseException {
        ListDataProvider dataProvider = new ListDataProvider();
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "1", "date", "2012-07-27", "value", 13)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "2", "date", "2012-07-28", "value", 11)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "3", "date", "2012-07-29", "value", 15)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "4", "date", "2012-07-30", "value", 16)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "5", "date", "2012-07-31", "value", 18)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "6", "date", "2012-08-01", "value", 13)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "7", "date", "2012-08-02", "value", 22)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "8", "date", "2012-08-03", "value", 23)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "9", "date", "2012-08-04", "value", 20)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "10", "date", "2012-08-05", "value", 17)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "11", "date", "2012-08-06", "value", 16)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "12", "date", "2012-08-07", "value", 18)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "13", "date", "2012-08-08", "value", 21)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "14", "date", "2012-08-09", "value", 26)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "15", "date", "2012-08-10", "value", 24)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "16", "date", "2012-08-11", "value", 29)));

        AbstractChart chart = new SerialChart().setCategoryField("date").setDataProvider(dataProvider)
                .addValueAxes(new ValueAxis().setAxisAlpha(0.0).setPosition(Position.LEFT))
                .addGraphs(new Graph().setId("g1").setBullet(BulletType.ROUND).setBulletBorderAlpha(1.0)
                        .setBulletColor(Color.WHITE).setBulletSize(5).setHideBulletsCount(50).setLineThickness(2)
                        .setTitle("Red line").setValueField("value"))
                .setCategoryAxis(new CategoryAxis().setDashLength(1).setMinorGridEnabled(true).setPosition(Position.TOP))
                .setChartScrollbar(new Scrollbar().setGraph("g1").setScrollbarHeight(30))
                .setChartCursor(new Cursor().setCursorPosition(CursorPosition.MOUSE).setPan(true))
                .setExport(new Export());

        String json = chart.toString();
        String expected = ChartSampleJsonHelper.readFile("SerialChart.json");
        Assert.assertEquals(null, expected, json);
    }

    @Test
    public void testXYChart() throws IOException, URISyntaxException {
        ListDataProvider dataProvider = new ListDataProvider();
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "1", "ax", 1.0, "ay", 0.5, "bx", 1.0, "by", 2.2)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "2", "ax", 2.0, "ay", 1.3, "bx", 2.0, "by", 4.9)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "3", "ax", 3.0, "ay", 2.3, "bx", 3.0, "by", 5.1)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "4", "ax", 4.0, "ay", 2.8, "bx", 4.0, "by", 5.3)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "5", "ax", 5.0, "ay", 3.5, "bx", 5.0, "by", 6.1)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "6", "ax", 6.0, "ay", 5.1, "bx", 6.0, "by", 8.3)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "7", "ax", 7.0, "ay", 6.7, "bx", 7.0, "by", 10.5)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "8", "ax", 8.0, "ay", 8.0, "bx", 8.0, "by", 12.3)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "9", "ax", 9.0, "ay", 8.9, "bx", 9.0, "by", 14.5)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "10", "ax", 10.0, "ay", 9.7, "bx", 10.0, "by", 15.0)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "11", "ax", 11.0, "ay", 10.4, "bx", 11.0, "by", 18.8)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "12", "ax", 12.0, "ay", 11.7, "bx", 12.0, "by", 19.0)));

        AbstractChart chart = new XYChart().setDataProvider(dataProvider).setStartDuration(1).setMarginLeft(64)
                .setMarginBottom(60)
                .setChartCursor(new Cursor())
                .setChartScrollbar(new Scrollbar())
                .addGraphs(
                        new Graph().setBullet(BulletType.TRIANGLE_UP).setLineAlpha(0.0).setXField("ax").setYField("ay")
                                .setLineColor(Color.valueOf("#FF6600")).setFillAlphas(0.0),
                        new Graph().setBullet(BulletType.TRIANGLE_DOWN).setLineAlpha(0.0).setXField("bx").setYField("by")
                                .setLineColor(Color.valueOf("#FCD202")).setFillAlphas(0.0))
                .addTrendLines(
                        new TrendLine().setFinalValue(12.0).setFinalXValue(12.0).setInitialValue(2.0)
                                .setInitialXValue(1.0).setLineColor(Color.valueOf("#FF6600")),
                        new TrendLine().setFinalValue(19.0).setFinalXValue(12.0).setInitialValue(1.0)
                                .setInitialXValue(1.0).setLineColor(Color.valueOf("#FCD202")))
                .addValueAxes(
                        new ValueAxis().setAxisAlpha(0.0).setDashLength(1).setTitle("X Axis").setPosition(Position.BOTTOM),
                        new ValueAxis().setAxisAlpha(0.0).setDashLength(1).setTitle("Y Axis").setPosition(Position.LEFT));

        String json = chart.toString();
        String expected = ChartSampleJsonHelper.readFile("XYChart.json");
        Assert.assertEquals(null, expected, json);
    }

    @Test
    public void testPieChart() throws IOException, URISyntaxException {
        ListDataProvider dataProvider = new ListDataProvider();
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "1", "country", "Czech Republic", "litres", 256.9)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "2", "country", "Ireland", "litres", 131.1)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "3", "country", "Germany", "litres", 115.8)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "4", "country", "Australia", "litres", 109.9)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "5", "country", "Austria", "litres", 108.3)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "6", "country", "UK", "litres", 65.0)));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("id", "7", "country", "Belgium", "litres", 40.0)));

        AbstractChart chart = new PieChart().setDataProvider(dataProvider).setDepth3D(15).setAngle(30)
                .setValueField("litres").setTitleField("country").setBalloonText("[[title]] - [[percents]]%")
                .setLegend(new Legend().setMarkerType(MarkerType.CIRCLE).setPosition(LegendPosition.RIGHT)
                        .setMarginRight(80).setAutoMargins(false))
                .setExport(new Export());


        String json = chart.toString();
        String expected = ChartSampleJsonHelper.readFile("PieChart.json");
        Assert.assertEquals(null, expected, json);
    }

    @Test
    public void testGanttChart() throws ParseException, IOException, URISyntaxException {
        ListDataProvider dataProvider = new ListDataProvider();
        dataProvider.addItem(taskSpan("1", "John",
                segment("s1", 7, 2, "#7B742C", "Task #1"),
                segment("s2", null, 2, "#7E585F", "Task #2"),
                segment("s3", null, 2, "#CF794A", "Task #3")));
        dataProvider.addItem(taskSpan("2", "Smith",
                segment("s4", 10, 2, "#7E585F", "Task #2"),
                segment("s5", null, 1, "#CF794A", "Task #3"),
                segment("s6", null, 4, "#7B742C", "Task #1")));
        dataProvider.addItem(taskSpan("3", "Ben",
                segment("s7", 12, 2, "#7E585F", "Task #2"),
                segment("s8", 16, 2, "#FFE4C4", "Task #4")));
        dataProvider.addItem(taskSpan("4", "Mike",
                segment("s9", 9, 6, "#7B742C", "Task #1"),
                segment("s10", null, 4, "#7E585F", "Task #2")));
        dataProvider.addItem(taskSpan("5", "Lenny",
                segment("s11", 8, 1, "#CF794A", "Task #3"),
                segment("s12", null, 4, "#7B742C", "Task #1")));
        dataProvider.addItem(taskSpan("6", "Scott",
                segment("s13", 15, 3, "#7E585F", "Task #2")));
        dataProvider.addItem(taskSpan("7", "Julia",
                segment("s14", 9, 2, "#7B742C", "Task #1"),
                segment("s15", null, 1, "#7E585F", "Task #2"),
                segment("s16", null, 8, "#CF794A", "Task #3")));
        dataProvider.addItem(taskSpan("8", "Bob",
                segment("s17", 9, 8, "#7E585F", "Task #2"),
                segment("s18", null, 7, "#CF794A", "Task #3")));
        dataProvider.addItem(taskSpan("9", "Kendra",
                segment("s19", 11, 8, "#7E585F", "Task #2"),
                segment("s20", 16, 2, "#FFE4C4", "Task #4")));
        dataProvider.addItem(taskSpan("9", "Tom",
                segment("s21", 9, 4, "#7B742C", "Task #1"),
                segment("s22", null, 3, "#7E585F", "Task #2"),
                segment("s23", null, 5, "#CF794A", "Task #3")));
        dataProvider.addItem(taskSpan("10", "Kyle",
                segment("s24", 6, 3, "#7E585F", "Task #2")));
        dataProvider.addItem(taskSpan("11", "Anita",
                segment("s25", 12, 2, "#7E585F", "Task #2"),
                segment("s26", 16, 2, "#FFE4C4", "Task #4")));
        dataProvider.addItem(taskSpan("12", "Jack",
                segment("s27", 8, 10, "#7B742C", "Task #1"),
                segment("s28", null, 2, "#7E585F", "Task #2")));
        dataProvider.addItem(taskSpan("13", "Kim",
                segment("s29", 12, 2, "#7E585F", "Task #2"),
                segment("s30", null, 3, "#CF794A", "Task #3")));
        dataProvider.addItem(taskSpan("14", "Aaron",
                segment("s31", 18, 2, "#7E585F", "Task #2"),
                segment("s32", null, 2, "#FFE4C4", "Task #4")));
        dataProvider.addItem(taskSpan("15", "Alan",
                segment("s33", 17, 2, "#7B742C", "Task #1"),
                segment("s34", null, 2, "#7E585F", "Task #2"),
                segment("s35", null, 2, "#CF794A", "Task #3")));
        dataProvider.addItem(taskSpan("16", "Ruth",
                segment("s36", 13, 2, "#7E585F", "Task #2"),
                segment("s37", null, 1, "#CF794A", "Task #3"),
                segment("s38", null, 4, "#7B742C", "Task #1")));
        dataProvider.addItem(taskSpan("17", "Simon",
                segment("s39", 10, 3, "#7E585F", "Task #2"),
                segment("s40", 17, 4, "#FFE4C4", "Task #4")));

        AbstractChart chart = new GanttChart().setDataProvider(dataProvider).setTheme(ChartTheme.LIGHT)
                .setMarginRight(70).setPeriod("hh").setBalloonDateFormat("JJ:NN").setColumnWidth(0.5)
                .setBrightnessStep(10).setRotate(true).setCategoryField("category").setSegmentsField("segments")
                .setStartDate(df.parse("2015-01-01")).setColorField("color").setStartField("start").setEndField("end")
                .setDurationField("duration").addAdditionalSegmentFields("task")
                .setGraph(new Graph().setFillAlphas(1.0).setBalloonText("[[task]]: [[open]] [[value]]"))
                .setValueAxis(new ValueAxis().setType(ValueAxisType.DATE).setMinimum(7.0).setMaximum(31.0))
                .setChartScrollbar(new Scrollbar())
                .setChartCursor(new Cursor().setValueBalloonsEnabled(false).setCursorAlpha(0.1)
                        .setValueLineBalloonEnabled(true).setValueLineEnabled(true).setFullWidth(true))
                .setExport(new Export());

        String json = chart.toString();
        String expected = ChartSampleJsonHelper.readFile("GanttChart.json");
        Assert.assertEquals(null, expected, json);
    }

    private MapDataItem taskSpan(String id, String category, DataItem... segments) {
        return new MapDataItem(ParamsMap.of("id", id, "category", category, "segments", Arrays.asList(segments)));
    }

    private MapDataItem segment(String id, Integer start, Integer duration, String color, String task) {
        Map<String, Object> segment = new HashMap<>(4);
        if (StringUtils.isNotEmpty(id)) {
            segment.put("id", id);
        }
        if (start != null) {
            segment.put("start", start);
        }
        if (duration != null) {
            segment.put("duration", duration);
        }
        if (color != null) {
            segment.put("color", color);
        }
        if (StringUtils.isNotEmpty(task)) {
            segment.put("task", task);
        }
        return new MapDataItem(segment);
    }
}
