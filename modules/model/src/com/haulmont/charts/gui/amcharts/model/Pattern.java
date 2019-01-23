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

public class Pattern extends AbstractChartObject {

    private static final long serialVersionUID = 952770895827665737L;

    private String url;

    private Integer width;

    private Integer height;

    public Integer getHeight() {
        return height;
    }

    public Pattern setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Pattern setUrl(String url) {
        this.url = url;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public Pattern setWidth(Integer width) {
        this.width = width;
        return this;
    }
}