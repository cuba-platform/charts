/*
 * Copyright (c) 2008-2019 Haulmont.
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

package com.haulmont.charts.gui.amcharts.model;

public class LegendItem extends AbstractChartObject {

    private static final long serialVersionUID = 8563526782768492986L;

    private String title;

    private Color color;

    private MarkerType markerType;

    public Color getColor() {
        return color;
    }

    public LegendItem setColor(Color color) {
        this.color = color;
        return this;
    }

    public MarkerType getMarkerType() {
        return markerType;
    }

    public LegendItem setMarkerType(MarkerType markerType) {
        this.markerType = markerType;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public LegendItem setTitle(String title) {
        this.title = title;
        return this;
    }
}