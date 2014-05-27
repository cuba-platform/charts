/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui.components.map.google;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.GeoPoint;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.*;

import java.util.ArrayList;
import java.util.List;

import static com.vaadin.tapio.googlemaps.GoogleMap.MapType.Roadmap;

/**
 * @author korotkov
 * @version $Id$
 */
public class DelegateHelper {

    public static GoogleMap.MapType toGoogleMapType(MapViewer.Type type) {
        switch (type) {
            case Roadmap: return Roadmap;
            case Satellite: return GoogleMap.MapType.Satellite;
            case Hybrid: return GoogleMap.MapType.Hybrid;
            case Terrain: return GoogleMap.MapType.Terrain;
            default: throw new IllegalArgumentException("Unsupported map type: " + type);
        }
    }

    public static MapViewer.Type toCubaMapType(GoogleMap.MapType type) {
        switch (type) {
            case Roadmap: return MapViewer.Type.Roadmap;
            case Satellite: return MapViewer.Type.Satellite;
            case Hybrid: return MapViewer.Type.Hybrid;
            case Terrain: return MapViewer.Type.Terrain;
            default: throw new IllegalArgumentException("Unsupported map type: " + type);
        }
    }

    public static List<LatLon> toLatLon(List<GeoPoint> coordinates) {
        if (coordinates == null) {
            return null;
        } else if (coordinates.isEmpty()) {
            return new ArrayList<>();
        } else {
            List<LatLon> result = new ArrayList<>(coordinates.size()*2);
            for (GeoPoint coordinate : coordinates) {
                result.add(((GeoPointDelegate)coordinate).getLatLon());
            }
            return result;
        }
    }

    public static List<GeoPoint> toGeoPoint(List<LatLon> coordinates) {
        if (coordinates == null) {
            return null;
        } else if (coordinates.isEmpty()) {
            return new ArrayList<>();
        } else {
            List<GeoPoint> result = new ArrayList<>(coordinates.size()*2);
            for (LatLon coordinate : coordinates) {
                result.add(new GeoPointDelegate(coordinate));
            }
            return result;
        }
    }
}
