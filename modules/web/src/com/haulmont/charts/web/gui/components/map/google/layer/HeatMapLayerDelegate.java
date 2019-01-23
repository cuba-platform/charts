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

package com.haulmont.charts.web.gui.components.map.google.layer;

import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.WeightedLocation;
import com.haulmont.charts.gui.map.model.layer.HeatMapLayer;
import com.haulmont.charts.web.gui.components.map.google.DelegateHelper;
import com.haulmont.charts.web.widgets.client.addons.googlemap.layers.GoogleMapHeatMapLayer;

import java.util.ArrayList;
import java.util.List;

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
        layer.setGradient(gradient != null ? new ArrayList<>(gradient) : null);
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
        return DelegateHelper.toGeoPoints(layer.getData());
    }
}