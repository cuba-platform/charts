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

import com.haulmont.charts.gui.model.JsonEnum;

public enum BigNumberPower implements JsonEnum {
    KILO("1e+3"),
    MEGA("1e+6"),
    GIGA("1e+9"),
    TERA("1e+12"),
    PETA("1e+15"),
    EXA("1e+18"),
    ZETTA("1e+21"),
    YOTTA("1e+24");

    private String id;

    BigNumberPower(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }
}