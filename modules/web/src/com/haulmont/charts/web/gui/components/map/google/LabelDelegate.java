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

package com.haulmont.charts.web.gui.components.map.google;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.Label;
import com.haulmont.charts.web.widgets.client.addons.googlemap.overlays.GoogleMapLabel;

public class LabelDelegate implements Label {

    private GoogleMapLabel label;

    public LabelDelegate() {
        this.label = new GoogleMapLabel();
    }

    public LabelDelegate(GoogleMapLabel label) {
        Preconditions.checkNotNullArgument(label);
        this.label = label;
    }

    public GoogleMapLabel getLabel() {
        return label;
    }

    public void setLabel(GoogleMapLabel label) {
        this.label = label;
    }

    @Override
    public void setValue(String value) {
        label.setValue(value);
    }

    @Override
    public String getValue() {
        return label.getValue();
    }

    @Override
    public void setPosition(GeoPoint position) {
        label.setPosition(position != null ? ((GeoPointDelegate) position).getLatLon() : null);
    }

    @Override
    public GeoPoint getPosition() {
        return GeoPointDelegate.fromLatLon(label.getPosition());
    }

    @Override
    public void setContentType(ContentType contentType) {
        label.setContentType(GoogleMapLabel.ContentType.valueOf(contentType.name()));
    }

    @Override
    public ContentType getContentType() {
        return ContentType.valueOf(label.getContentType().name());
    }

    @Override
    public void setAdjustment(Adjustment adjustment) {
        label.setAdjustment(GoogleMapLabel.Adjustment.valueOf(adjustment.name()));
    }

    @Override
    public Adjustment getAdjustment() {
        return Adjustment.valueOf(label.getAdjustment().name());
    }

    @Override
    public void setStyleName(String styleName) {
        label.setStyleName(styleName);
    }

    @Override
    public String getStyleName() {
        return label.getStyleName();
    }
}