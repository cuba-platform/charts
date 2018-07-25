/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.layers;

import com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.base.LatLon;
import com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.base.WeightedLocation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Igor Korotkov (igor@ikorotkov.com)
 */
public class GoogleMapHeatMapLayer implements Serializable {
    private static final long serialVersionUID = 896513236735515400L;

    private static long idCounter = 0;

    private long id;

    private List<LatLon> data = new ArrayList<LatLon>();
    private List<WeightedLocation> weightedData = new ArrayList<WeightedLocation>();
    private List<String> gradient;
    private Double opacity = 0.6;
    private Double radius;
    private Double maxIntensity;
    private Boolean dissipating;

    public GoogleMapHeatMapLayer() {
        id = idCounter;
        idCounter++;
    }

    public GoogleMapHeatMapLayer(List<LatLon> data) {
        this();
        this.data = data;
    }

    public GoogleMapHeatMapLayer(List<LatLon> data, List<WeightedLocation> weightedData) {
        this();
        this.data = data;
        this.weightedData = weightedData;
    }

    public List<LatLon> getData() {
        return data;
    }

    public void setData(List<LatLon> data) {
        this.data = data;
    }

    public List<WeightedLocation> getWeightedData() {
        return weightedData;
    }

    public void setWeightedData(List<WeightedLocation> weightedData) {
        this.weightedData = weightedData;
    }

    public List<String> getGradient() {
        return gradient;
    }

    public void setGradient(List<String> gradient) {
        this.gradient = gradient;
    }

    public Double getOpacity() {
        return opacity;
    }

    public void setOpacity(Double opacity) {
        this.opacity = opacity;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Double getMaxIntensity() {
        return maxIntensity;
    }

    public void setMaxIntensity(Double maxIntensity) {
        this.maxIntensity = maxIntensity;
    }

    public Boolean getDissipating() {
        return dissipating;
    }

    public void setDissipating(Boolean dissipating) {
        this.dissipating = dissipating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoogleMapHeatMapLayer that = (GoogleMapHeatMapLayer) o;

        if (id != that.id) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (dissipating != null ? !dissipating.equals(that.dissipating) : that.dissipating != null) return false;
        if (gradient != null ? !gradient.equals(that.gradient) : that.gradient != null) return false;
        if (maxIntensity != null ? !maxIntensity.equals(that.maxIntensity) : that.maxIntensity != null) return false;
        if (opacity != null ? !opacity.equals(that.opacity) : that.opacity != null) return false;
        if (radius != null ? !radius.equals(that.radius) : that.radius != null) return false;
        if (weightedData != null ? !weightedData.equals(that.weightedData) : that.weightedData != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (weightedData != null ? weightedData.hashCode() : 0);
        result = 31 * result + (gradient != null ? gradient.hashCode() : 0);
        result = 31 * result + (opacity != null ? opacity.hashCode() : 0);
        result = 31 * result + (radius != null ? radius.hashCode() : 0);
        result = 31 * result + (maxIntensity != null ? maxIntensity.hashCode() : 0);
        result = 31 * result + (dissipating != null ? dissipating.hashCode() : 0);
        return result;
    }
}