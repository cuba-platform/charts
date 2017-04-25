/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.map.google;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.Label;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapLabel;

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