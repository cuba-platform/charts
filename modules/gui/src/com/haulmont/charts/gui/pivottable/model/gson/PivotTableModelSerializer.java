/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model.gson;

import com.google.gson.*;
import com.haulmont.charts.gui.pivottable.model.PivotTableModel;

import java.lang.reflect.Type;
import java.util.Map;

public class PivotTableModelSerializer implements JsonSerializer<PivotTableModel> {

    @Override
    public JsonElement serialize(PivotTableModel src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject pivotJson = context.serialize(src).getAsJsonObject();

        if (context instanceof PivotJsonSerializationContext) {
            PivotJsonSerializationContext pivotContext = (PivotJsonSerializationContext) context;

            localizeArray(pivotJson, "rows", pivotContext);
            localizeArray(pivotJson, "cols", pivotContext);
            localizeArray(pivotJson, "aggregationProperties", pivotContext);
            localizeArray(pivotJson, "hiddenProperties", pivotContext);
            localizeArray(pivotJson, "hiddenFromAggregations", pivotContext);
            localizeArray(pivotJson, "hiddenFromDragDrop", pivotContext);

            JsonObject aggregation = pivotJson.getAsJsonObject("aggregation");
            if (aggregation != null) {
                localizeArray(aggregation, "properties", pivotContext);
            }

            localizeMapKeys(pivotJson, "inclusions", pivotContext);
            localizeMapKeys(pivotJson, "exclusions", pivotContext);
        }

        return pivotJson;
    }

    protected void localizeArray(JsonObject jsonObject, String property, PivotJsonSerializationContext context) {
        JsonArray array = jsonObject.getAsJsonArray(property);
        if (array != null) {
            JsonArray localizedArray = new JsonArray();
            for (JsonElement row : array) {
                localizedArray.add(context.getLocalizedPropertyName(row.getAsString()));
            }
            jsonObject.add(property, localizedArray);
        }
    }

    private void localizeMapKeys(JsonObject jsonObject, String propery, PivotJsonSerializationContext context) {
        JsonObject map = jsonObject.getAsJsonObject(propery);
        if (map != null) {
            JsonObject localizedMap = new JsonObject();
            for (Map.Entry<String, JsonElement> entry : map.entrySet()) {
                localizedMap.add(context.getLocalizedPropertyName(entry.getKey()), entry.getValue());
            }
            jsonObject.add(propery, localizedMap);
        }
    }
}
