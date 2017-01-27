/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Responsive rule for chart. See documentation for responsive plugin.<br>
 *
 * <a href="https://github.com/amcharts/responsive">https://github.com/amcharts/responsive</a>
 */
public class Rule extends AbstractChartObject {

    private static final long serialVersionUID = -7360797549434731632L;

    private Integer minWidth;
    private Integer maxWidth;
    private Integer minHeight;
    private Integer maxHeight;

    private JsonElement overridesJson;
    private String rawOverridesJson;

    public Integer getMinWidth() {
        return minWidth;
    }

    public Rule setMinWidth(Integer minWidth) {
        this.minWidth = minWidth;
        return this;
    }

    public Integer getMaxWidth() {
        return maxWidth;
    }

    public Rule setMaxWidth(Integer maxWidth) {
        this.maxWidth = maxWidth;
        return this;
    }

    public Integer getMinHeight() {
        return minHeight;
    }

    public Rule setMinHeight(Integer minHeight) {
        this.minHeight = minHeight;
        return this;
    }

    public Integer getMaxHeight() {
        return maxHeight;
    }

    public Rule setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
        return this;
    }

    public JsonElement getOverridesJson() {
        return overridesJson;
    }

    public String getRawOverridesJson() {
        return rawOverridesJson;
    }

    public Rule setRawOverridesJson(String rawOverridesJson) {
        this.rawOverridesJson = rawOverridesJson;

        JsonParser parser = new JsonParser();
        this.overridesJson = parser.parse(rawOverridesJson);

        return this;
    }
}