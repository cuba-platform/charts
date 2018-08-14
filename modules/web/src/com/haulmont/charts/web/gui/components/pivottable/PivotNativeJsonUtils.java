/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.pivottable;

import com.google.common.base.Strings;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.haulmont.charts.gui.components.pivot.PivotTable;

import javax.annotation.Nullable;

/**
 * Helps to retrieve properties from {@link PivotTable} native json.
 */
public final class PivotNativeJsonUtils {

    /**
     * Get editable property from native json.
     *
     * @param json native json configuration of pivot table
     * @return null if there is no such property, otherwise true or false
     */
    @Nullable
    public static Boolean isEditable(String json) {
        if (Strings.isNullOrEmpty(json)) {
            return null;
        }

        JsonObject nativeJson;

        JsonParser parser = new JsonParser();
        try {
            nativeJson = parser.parse(json).getAsJsonObject();
        } catch (JsonSyntaxException e) {
            throw new IllegalStateException("Unable to parse JSON chart configuration");
        }

        if (nativeJson.get("editable") == null) {
            return null;
        } else {
            return nativeJson.get("editable").getAsBoolean();
        }
    }

    /**
     * Get renderer id from native json.
     *
     * @param json native json configuration of pivot table
     * @return null if there is no such property, otherwise renderer id
     */
    @Nullable
    public static String getRenderer(String json) {
        if (Strings.isNullOrEmpty(json)) {
            return null;
        }

        JsonObject nativeJson;

        JsonParser parser = new JsonParser();
        try {
            nativeJson = parser.parse(json).getAsJsonObject();
        } catch (JsonSyntaxException e) {
            throw new IllegalStateException("Unable to parse JSON chart configuration");
        }

        if (nativeJson.get("renderer") == null) {
            return null;
        } else {
            return nativeJson.get("renderer").getAsString();
        }
    }
}
