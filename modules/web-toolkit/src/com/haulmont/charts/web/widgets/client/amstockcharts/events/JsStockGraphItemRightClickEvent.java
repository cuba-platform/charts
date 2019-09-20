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

package com.haulmont.charts.web.widgets.client.amstockcharts.events;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.NativeEvent;

public class JsStockGraphItemRightClickEvent extends JavaScriptObject {

    protected JsStockGraphItemRightClickEvent() {
    }

    public final native String getPanelId() /*-{
        if (this.chart) {
            return this.chart.id;
        }
        return null;
    }-*/;

    public final native String getGraphId() /*-{
        if (this.graph) {
            return this.graph.id;
        }
        return null;
    }-*/;

    public final native NativeEvent getMouseEvent() /*-{
        return this.event;
    }-*/;

    public final native int getIndex() /*-{
        return this.index;
    }-*/;

    public final native String getItemKey() /*-{
        if (this.item && this.item.dataContext) {
            if (!this.item.dataContext.$k) {
                return null;
            }

            return "" + this.item.dataContext.$k;
        }
        return null;
    }-*/;

    public final native String getDataSetId() /*-{
        if (this.item && this.item.dataContext) {
            if (!this.item.dataContext.$d) {
                return null;
            }

            return "" + this.item.dataContext.$d;
        }
        return null;
    }-*/;
}
