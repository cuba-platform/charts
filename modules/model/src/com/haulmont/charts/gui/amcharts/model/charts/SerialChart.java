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

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.ChartType;

/**
 * See documentation for properties of AmSerialChart JS object. <br>
 *
 * <a href="http://docs.amcharts.com/3/javascriptcharts/AmSerialChart">http://docs.amcharts.com/3/javascriptcharts/AmSerialChart</a>
 */
public class SerialChart extends AbstractSerialChart<SerialChart> {

    private static final long serialVersionUID = 4640758803235179022L;

    private Integer bezierX;

    private Integer bezierY;

    public SerialChart() {
        super(ChartType.SERIAL);
    }

    public Integer getBezierX() {
        return bezierX;
    }

    public SerialChart setBezierX(Integer bezierX) {
        this.bezierX = bezierX;
        return this;
    }

    public Integer getBezierY() {
        return bezierY;
    }

    public SerialChart setBezierY(Integer bezierY) {
        this.bezierY = bezierY;
        return this;
    }
}