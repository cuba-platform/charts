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

package com.haulmont.charts.gui.components.charts;

import com.haulmont.charts.gui.amcharts.model.charts.AbstractChart;
import com.haulmont.cuba.gui.components.Component;

/**
 * Chart that can show any chart configuration inherited from {@link AbstractChart}.
 */
public interface CustomChart extends Component, Component.BelongToFrame, Component.HasIcon, Component.HasCaption {
    String NAME = "customChart";

    AbstractChart getConfiguration();
    void setConfiguration(AbstractChart configuration);

    /**
     * Resend all items and properties to client and repaint chart.
     * Use this method if you change some property of already displayed chart.
     */
    void repaint();

    /**
     * Set additional JSON configuration as a string.
     * This JSON can override configuration loaded from XML and from Component API.
     */
    void setNativeJson(String json);
    /**
     * @return additional JSON configuration as a string.
     */
    String getNativeJson();
}