/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model.gson;

import com.google.gson.*;
import com.haulmont.charts.gui.data.DataProvider;

import java.lang.reflect.Type;
import java.util.List;

public class PivotDataProviderSerializer extends PivotDataItemsSerializer
        implements JsonSerializer<DataProvider> {

    @Override
    public JsonElement serialize(DataProvider src, Type typeOfSrc, JsonSerializationContext context) {
        JsonArray dataProviderElement = new JsonArray();
        List<JsonObject> jsonObjects = serialize(src.getItems(), context);
        for (JsonObject jsonObject : jsonObjects) {
            dataProviderElement.add(jsonObject);
        }

        // Prevent errors on client for empty data provider
        if (dataProviderElement.size() == 0) {
            dataProviderElement.add(new JsonObject());
        }

        return dataProviderElement;
    }
}