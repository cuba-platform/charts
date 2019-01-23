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

package com.haulmont.charts.web.widgets.client.addons.googlemap.overlays;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.maps.client.base.LatLng;
import com.haulmont.charts.web.widgets.client.addons.googlemap.overlays.GoogleMapLabel.Adjustment;
import com.haulmont.charts.web.widgets.client.addons.googlemap.overlays.GoogleMapLabel.ContentType;

public class GoogleMapLabelOptions extends JavaScriptObject {

    protected GoogleMapLabelOptions() {
    }

    public final static GoogleMapLabelOptions newInstance() {
        return JavaScriptObject.createObject().cast();
    }

    public final native void setValue(String value) /*-{
        this.value = value;
    }-*/;

    public final native String getValue() /*-{
        return this.value;
    }-*/;

    public final native void setPosition(LatLng position) /*-{
        this.position = position;
    }-*/;

    public final native LatLng getPosition() /*-{
        return this.position;
    }-*/;

    public final void setContentType(ContentType contentType) {
        setContentTypeJsni(contentType.name());
    }

    private final native void setContentTypeJsni(String contentType) /*-{
        this.contentType = contentType;
    }-*/;

    public final ContentType getContentType() {
        return ContentType.valueOf(getContentTypeJsni());
    }

    private final native String getContentTypeJsni() /*-{
        return this.contentType;
    }-*/;

    public final void setAdjustment(Adjustment adjustment) {
        setAdjustmentJsni(adjustment.name());
    }

    private final native void setAdjustmentJsni(String adjustment) /*-{
        this.adjustment = adjustment;
    }-*/;

    public final Adjustment getAdjustment() {
        return Adjustment.valueOf(getAdjustmentJsni());
    }

    private final native String getAdjustmentJsni() /*-{
        return this.adjustment;
    }-*/;

    public final native void setStyleName(String styleName) /*-{
        this.styleName = styleName;
    }-*/;

    public final native String getStyleName() /*-{
        return this.styleName;
    }-*/;
}