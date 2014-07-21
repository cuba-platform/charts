/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui.components.map.google.layer;

import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.WeightedLocation;
import com.haulmont.charts.gui.map.model.layer.HeatMapLayer;
import com.haulmont.charts.web.gui.components.map.google.DelegateHelper;
import com.vaadin.tapio.googlemaps.client.layers.GoogleMapHeatMapLayer;

import java.util.List;

/**
 * @author korotkov
 * @version $Id$
 */
public class HeatMapLayerDelegate implements HeatMapLayer {

    protected GoogleMapHeatMapLayer layer;

    public GoogleMapHeatMapLayer getLayer() {
        return layer;
    }

    public HeatMapLayerDelegate(GoogleMapHeatMapLayer layer) {
        this.layer = layer;
    }

    @Override
    public void setDissipating(Boolean dissipating) {
        layer.setDissipating(dissipating);
    }

    @Override
    public Boolean getDissipating() {
        return layer.getDissipating();
    }

    @Override
    public void setMaxIntensity(Double maxIntensity) {
        layer.setMaxIntensity(maxIntensity);
    }

    @Override
    public Double getMaxIntensity() {
        return layer.getMaxIntensity();
    }

    @Override
    public void setRadius(Double radius) {
        layer.setRadius(radius);
    }

    @Override
    public Double getRadius() {
        return layer.getRadius();
    }

    @Override
    public void setOpacity(Double opacity) {
        layer.setOpacity(opacity);
    }

    @Override
    public Double getOpacity() {
        return layer.getOpacity();
    }

    @Override
    public void setGradient(List<String> gradient) {
        layer.setGradient(getGradient());
    }

    @Override
    public List<String> getGradient() {
        return layer.getGradient();
    }

    @Override
    public void setWeightedData(List<WeightedLocation> weightedData) {
        layer.setWeightedData(DelegateHelper.toGoogleWeightedLocations(weightedData));
    }

    @Override
    public List<WeightedLocation> getWeightedData() {
        return DelegateHelper.toWeightedLocations(layer.getWeightedData());
    }

    @Override
    public void setData(List<GeoPoint> data) {
        layer.setData(DelegateHelper.toLatLon(data));
    }

    @Override
    public List<GeoPoint> getData() {
        return DelegateHelper.toGeoPoint(layer.getData());
    }
}
