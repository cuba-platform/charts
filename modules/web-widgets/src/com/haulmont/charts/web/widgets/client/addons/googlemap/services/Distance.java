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

package com.haulmont.charts.web.widgets.client.addons.googlemap.services;

import java.io.Serializable;

public class Distance implements Serializable {
    private static final long serialVersionUID = 8516378440142447051L;

    private String text;
    private int value;

    public Distance() {
    }

    public Distance(String text, int value) {
        this.text = text;
        this.value = value;
    }

    /**
     * A string representation of the distance value, using the UnitSystem specified in the request.
     */
    public String getText() {
        return text;
    }

    /**
     * A string representation of the distance value, using the UnitSystem specified in the request.
     *
     * @param text text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * The distance in meters.
     */
    public int getValue() {
        return value;
    }

    /**
     * The distance in meters.
     *
     * @param value value
     */
    public void setValue(int value) {
        this.value = value;
    }
}