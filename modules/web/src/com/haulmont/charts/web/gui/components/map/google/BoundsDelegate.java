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
import com.haulmont.charts.gui.map.model.Bounds;
import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.web.widgets.client.addons.googlemap.services.LatLonBounds;

public class BoundsDelegate implements Bounds {
    private LatLonBounds bounds;

    public static BoundsDelegate fromLatLonBounds(LatLonBounds bounds) {
        return bounds != null ? new BoundsDelegate(bounds) : null;
    }

    public BoundsDelegate(LatLonBounds bounds) {
        Preconditions.checkNotNullArgument(bounds);
        this.bounds = bounds;
    }

    public LatLonBounds getBounds() {
        return bounds;
    }

    public void setBounds(LatLonBounds bounds) {
        this.bounds = bounds;
    }

    @Override
    public GeoPoint getSw() {
        return GeoPointDelegate.fromLatLon(bounds.getSw());
    }

    @Override
    public void setSw(GeoPoint sw) {
        bounds.setSw(sw != null ? ((GeoPointDelegate) sw).getLatLon() : null);
    }

    @Override
    public GeoPoint getNe() {
        return GeoPointDelegate.fromLatLon(bounds.getNe());
    }

    @Override
    public void setNe(GeoPoint ne) {
        bounds.setNe(ne != null ? ((GeoPointDelegate) ne).getLatLon() : null);
    }
}