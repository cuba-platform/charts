/*
 * Copyright (c) 2008-2020 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.charts.model.amcharts.charts;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.pivottable.model.Aggregation;
import com.haulmont.charts.gui.pivottable.model.AggregationMode;
import com.haulmont.charts.gui.pivottable.model.PivotTableModel;
import com.haulmont.charts.model.amcharts.charts.container.ChartsTestContainer;
import com.haulmont.charts.web.gui.serialization.PivotTableDataItemsSerializer;
import com.haulmont.charts.web.widgets.pivottable.serialization.PivotJsonSerializationContext;
import com.haulmont.cuba.web.testsupport.TestUiEnvironment;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.spockframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class PivotTableSerializerTest {

    private List<DataItem> dataItems;

    @ClassRule
    public static TestUiEnvironment environment =
            //Using this container to avoid fiddling with user session, authorization
            new TestUiEnvironment(ChartsTestContainer.Common.INSTANCE) {
                @Override
                protected void cleanupEnvironment() {
                    //we don't have windows, we don't have client cache
                }
            }
            .withLocale(Locale.ENGLISH)
            .withUserLogin("admin");

    @Before
    public void setupTest() {
        dataItems = new ArrayList<>();
        LocalDateTime localDateTime = LocalDateTime.of(2010, Month.APRIL, 10, 14, 11, 59);
        Date date = Date.from(localDateTime.toInstant(ZoneOffset.UTC));
        dataItems.add(new PivotDataItem(1L,
                "one",
                localDateTime,
                localDateTime.toLocalDate(), date));
    }

    @Test
    public void dateSerialziationTest() {

        PivotTableDataItemsSerializer serializer = new PivotTableDataItemsSerializer();
        serializer.setUserSessionSource(environment.getSessionSource());
        PivotTableModel model = getPivotTableModel();
        PivotJsonSerializationContext ctx = new PivotJsonSerializationContext(model, new Gson());
        JsonArray serialize = serializer.serialize(dataItems, ctx);

        JsonObject jsonObject = serialize.getAsJsonArray().get(0).getAsJsonObject();
        JsonElement id = jsonObject.get("id");
        JsonElement name = jsonObject.get("name");
        JsonElement localDate = jsonObject.get("localDate");
        JsonElement localDateTime = jsonObject.get("localDateTime");
        JsonElement date = jsonObject.get("date");

        //All values should be serialized
        Assert.that(id.isJsonPrimitive(), "Long values should be serialized");
        Assert.that(name.isJsonPrimitive(), "String values should be serialized");
        Assert.that(localDate.isJsonPrimitive(), "LocalDate values should be serialized");
        Assert.that(localDateTime.isJsonPrimitive(), "LocalDateTime values should be serialized");
        Assert.that(date.isJsonPrimitive(), "Date values should be serialized");
    }

    private PivotTableModel getPivotTableModel() {
        Map<String, String> props = new HashMap<>();
        props.put("id", "id");
        props.put("name", "name");
        props.put("localDate", "localDate");
        props.put("localDateTime", "localDateTime");
        props.put("date", "date");

        Aggregation aggregation = new Aggregation();
        aggregation.setMode(AggregationMode.COUNT);

        PivotTableModel model = new PivotTableModel();
        model.setProperties(props);
        model.addCols("localDate");
        model.addRows("name");
        model.addAggregationProperties("id");
        model.setAggregation(aggregation);
        return model;
    }

    static class PivotDataItem implements DataItem {
        private final Long id;
        private final String name;
        private final LocalDateTime localDateTime;
        private final LocalDate localDate;
        private final Date date;

        public PivotDataItem(Long id, String name, LocalDateTime localDateTime, LocalDate localDate, Date date) {
            this.id = id;
            this.name = name;
            this.localDateTime = localDateTime;
            this.localDate = localDate;
            this.date = date;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public LocalDateTime getLocalDateTime() {
            return localDateTime;
        }

        public Date getDate() {
            return date;
        }

        @Override
        public Object getValue(String property) {
            switch (property) {
                case "id":
                    return id;
                case "name":
                    return name;
                case "localDateTime":
                    return localDateTime;
                case "localDate":
                    return localDate;
                case "date":
                    return date;
                default:
                    return null;
            }
        }
    }

}
