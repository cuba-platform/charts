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

package com.haulmont.charts.web.widgets.client.amcharts.events;

import com.google.gwt.core.client.JavaScriptObject;

public class JsAxisZoomedEvent extends JavaScriptObject {

    protected JsAxisZoomedEvent() {
    }

    public final native String getAxisId() /*-{
        return this.axisId;
    }-*/;

    public final native double getStartValue() /*-{
        return this.startValue;
    }-*/;

    public final native double getEndValue() /*-{
        return this.endValue;
    }-*/;
}