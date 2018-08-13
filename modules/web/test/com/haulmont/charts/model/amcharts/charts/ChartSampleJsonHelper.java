/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.model.amcharts.charts;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class ChartSampleJsonHelper {

    public static final java.lang.String DATE_FORMAT = "yyyy-MM-dd";

    private ChartSampleJsonHelper() {
    }

    public static String readFile(String fileName) throws IOException, URISyntaxException {
        URL resource = ChartSampleJsonHelper.class.getResource("/com/haulmont/charts/model/amcharts/charts/" + fileName);
        byte[] encoded = Files.readAllBytes(Paths.get(resource.toURI()));
        return new String(encoded, StandardCharsets.UTF_8);
    }

    public static String prettyJson(String json) {
        JsonParser parser = new JsonParser();
        JsonElement parsedJson = parser.parse(json);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(parsedJson);
    }
}