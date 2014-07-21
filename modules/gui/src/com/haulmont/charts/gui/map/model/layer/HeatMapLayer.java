/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.map.model.layer;

import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.WeightedLocation;

import java.util.List;

/**
 * @author korotkov
 * @version $Id$
 */
public interface HeatMapLayer {

    public List<GeoPoint> getData();
    public void setData(List<GeoPoint> data);

    public List<WeightedLocation> getWeightedData();
    public void setWeightedData(List<WeightedLocation> weightedData);

    public List<String> getGradient();
    public void setGradient(List<String> gradient);

    public Double getOpacity();
    public void setOpacity(Double opacity);

    public Double getRadius();
    public void setRadius(Double radius);

    public Double getMaxIntensity();
    public void setMaxIntensity(Double maxIntensity);

    public Boolean getDissipating();
    public void setDissipating(Boolean dissipating);
}
