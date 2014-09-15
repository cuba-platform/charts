/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui.components.map.google;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.*;
import com.haulmont.charts.gui.map.model.WeightedLocation;
import com.haulmont.charts.gui.map.model.drawing.*;
import com.haulmont.charts.gui.map.model.drawing.DrawingOptions;
import com.haulmont.charts.gui.map.model.drawing.OverlayType;
import com.haulmont.charts.gui.map.model.drawing.PolygonOptions;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.*;
import com.vaadin.tapio.googlemaps.client.drawing.*;

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
            case ROADMAP: return Roadmap;
            case SATELLITE: return GoogleMap.MapType.Satellite;
            case HYBRID: return GoogleMap.MapType.Hybrid;
            case TERRAIN: return GoogleMap.MapType.Terrain;
            default: throw new IllegalArgumentException("Unsupported map type: " + type);
        }
    }

    public static MapViewer.Type toCubaMapType(GoogleMap.MapType type) {
        switch (type) {
            case Roadmap: return MapViewer.Type.ROADMAP;
            case Satellite: return MapViewer.Type.SATELLITE;
            case Hybrid: return MapViewer.Type.HYBRID;
            case Terrain: return MapViewer.Type.TERRAIN;
            default: throw new IllegalArgumentException("Unsupported map type: " + type);
        }
    }

    public static com.vaadin.tapio.googlemaps.client.drawing.DrawingOptions
        toGoogleDrawingOptions(DrawingOptions options) {
        if (options == null) {
            return null;
        }

        com.vaadin.tapio.googlemaps.client.drawing.DrawingOptions gOptions
                = new com.vaadin.tapio.googlemaps.client.drawing.DrawingOptions();

        gOptions.setPolygonOptions(toGooglePolygonOptions(options.getPolygonOptions()));
        gOptions.setDrawingControlOptions(toGoogleDrawingControlOptions(options.getDrawingControlOptions()));
        gOptions.setInitialDrawingMode(toGoogleOverlayType(options.getInitialDrawingMode()));
        gOptions.setEnableDrawingControl(options.isEnableDrawingControl());

        return gOptions;
    }

    private static com.vaadin.tapio.googlemaps.client.drawing.OverlayType
        toGoogleOverlayType(OverlayType overlayType) {
        if (overlayType == null) {
            return null;
        }

        switch (overlayType) {
            case POLYGON: return com.vaadin.tapio.googlemaps.client.drawing.OverlayType.POLYGON;
//            case CIRCLE: return com.vaadin.tapio.googlemaps.client.drawing.OverlayType.CIRCLE;
//            case POLYLINE: return com.vaadin.tapio.googlemaps.client.drawing.OverlayType.POLYLINE;
//            case MARKER: return com.vaadin.tapio.googlemaps.client.drawing.OverlayType.MARKER;
//            case RECTANGLE: return com.vaadin.tapio.googlemaps.client.drawing.OverlayType.RECTANGLE;
        }

        throw new IllegalArgumentException("Unknown overlay type: " + overlayType);
    }

    private static List<com.vaadin.tapio.googlemaps.client.drawing.OverlayType>
                toGoogleOverlayType(List<OverlayType> overlayTypes) {
        if (overlayTypes == null) {
            return null;
        }

        List<com.vaadin.tapio.googlemaps.client.drawing.OverlayType>
                gOverlayTypes = new ArrayList<>(overlayTypes.size()*2);

        for (OverlayType overlayType : overlayTypes) {
            gOverlayTypes.add(toGoogleOverlayType(overlayType));
        }

        return gOverlayTypes;
    }

    private static DrawingControlOptions
            toGoogleDrawingControlOptions(ControlOptions options) {
        DrawingControlOptions gOptions = new DrawingControlOptions();
        gOptions.setPosition(toGoogleControlPosition(options.getPosition()));
        gOptions.setDrawingModes(toGoogleOverlayType(options.getDrawingModes()));
        return gOptions;
    }

    private static ControlPosition toGoogleControlPosition(Position position) {
        if (position == null) {
            return null;
        }

        switch (position) {
            case BOTTOM_CENTER: return ControlPosition.BOTTOM_CENTER;
            case BOTTOM_LEFT: return ControlPosition.BOTTOM_LEFT;
            case BOTTOM_RIGHT: return ControlPosition.BOTTOM_RIGHT;

            case TOP_CENTER: return ControlPosition.TOP_CENTER;
            case TOP_LEFT: return ControlPosition.TOP_LEFT;
            case TOP_RIGHT: return ControlPosition.TOP_RIGHT;

            case LEFT_CENTER: return ControlPosition.LEFT_CENTER;
            case LEFT_TOP: return ControlPosition.LEFT_TOP;
            case LEFT_BOTTOM: return ControlPosition.LEFT_BOTTOM;

            case RIGHT_CENTER: return ControlPosition.RIGHT_CENTER;
            case RIGHT_TOP: return ControlPosition.RIGHT_TOP;
            case RIGHT_BOTTOM: return ControlPosition.RIGHT_BOTTOM;
        }

        throw new IllegalArgumentException("Unknown postition: " + position);
    }

    private static com.vaadin.tapio.googlemaps.client.drawing.PolygonOptions
        toGooglePolygonOptions(PolygonOptions options) {
        if (options == null) {
            return null;
        }

        com.vaadin.tapio.googlemaps.client.drawing.PolygonOptions gOptions
                = new com.vaadin.tapio.googlemaps.client.drawing.PolygonOptions();

        gOptions.setEditable(options.isEditable());
        gOptions.setStrokeOpacity(options.getStrokeOpacity());
        gOptions.setStrokeColor(options.getStrokeColor());
        gOptions.setStrokeWeight(options.getStrokeWeight());
        gOptions.setFillOpacity(options.getFillOpacity());
        gOptions.setFillColor(options.getFillColor());
//        gOptions.setClickable(options.isClickable());
        gOptions.setGeodesic(options.isGeodesic());
        gOptions.setVisible(options.isVisible());
        gOptions.setZIndex(options.getZIndex());

        return gOptions;
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

    public static List<com.vaadin.tapio.googlemaps.client.WeightedLocation> toGoogleWeightedLocations(
            List<WeightedLocation> weightedLocations) {
        if (weightedLocations == null) {
            return null;
        }

        List<com.vaadin.tapio.googlemaps.client.WeightedLocation> gWeightedLocations
                = new ArrayList<>(weightedLocations.size()*2);
        for (WeightedLocation w : weightedLocations) {
            LatLon location = new LatLon(w.getLocation().getLatitude(), w.getLocation().getLongitude());
            Double weight = w.getWeight();
            gWeightedLocations.add(new com.vaadin.tapio.googlemaps.client.WeightedLocation(location, weight));
        }

        return gWeightedLocations;
    }

    public static List<WeightedLocation> toWeightedLocations(
            List<com.vaadin.tapio.googlemaps.client.WeightedLocation> gWeightedLocations) {
        if (gWeightedLocations == null) {
            return null;
        }

        List<WeightedLocation> weightedLocations = new ArrayList<>(gWeightedLocations.size()*2);
        for (com.vaadin.tapio.googlemaps.client.WeightedLocation w : gWeightedLocations) {
            weightedLocations.add(new WeightedLocationDelegate(w));
        }

        return weightedLocations;
    }
}
