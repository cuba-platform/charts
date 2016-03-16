/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.map.google;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.WeightedLocation;
import com.haulmont.charts.gui.map.model.drawing.*;
import com.haulmont.charts.web.gui.components.map.google.directions.DirectionsLegDelegate;
import com.haulmont.charts.web.gui.components.map.google.directions.DirectionsRouteDelegate;
import com.haulmont.charts.web.gui.components.map.google.directions.DirectionsStepDelegate;
import com.haulmont.charts.web.gui.components.map.google.directions.DirectionsWaypointDelegate;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.base.LatLon;
import com.vaadin.tapio.googlemaps.client.drawing.ControlPosition;
import com.vaadin.tapio.googlemaps.client.drawing.DrawingControlOptions;
import com.vaadin.tapio.googlemaps.client.services.DirectionsLeg;
import com.vaadin.tapio.googlemaps.client.services.DirectionsRoute;
import com.vaadin.tapio.googlemaps.client.services.DirectionsStep;
import com.vaadin.tapio.googlemaps.client.services.DirectionsWaypoint;

import java.util.ArrayList;
import java.util.List;

import static com.vaadin.tapio.googlemaps.GoogleMap.MapType.Roadmap;

/**
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
        gOptions.setCircleOptions(toGoogleCircleOptions(options.getCircleOptions()));
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
            case CIRCLE: return com.vaadin.tapio.googlemaps.client.drawing.OverlayType.CIRCLE;
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

    private static com.vaadin.tapio.googlemaps.client.drawing.CircleOptions toGoogleCircleOptions(CircleOptions options) {
        if (options == null) {
            return null;
        }

        com.vaadin.tapio.googlemaps.client.drawing.CircleOptions gOptions
                = new com.vaadin.tapio.googlemaps.client.drawing.CircleOptions();
        gOptions.setRadius(options.getRadius());
        gOptions.setCenter(options.getCenter() != null ? ((GeoPointDelegate)options.getCenter()).getLatLon() : null);
        gOptions.setEditable(options.isEditable());
        gOptions.setStrokeOpacity(options.getStrokeOpacity());
        gOptions.setStrokeColor(options.getStrokeColor());
        gOptions.setStrokeWeight(options.getStrokeWeight());
        gOptions.setFillOpacity(options.getFillOpacity());
        gOptions.setFillColor(options.getFillColor());
        gOptions.setClickable(options.isClickable());
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

    public static List<GeoPoint> toGeoPoints(List<LatLon> coordinates) {
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

    public static List<com.vaadin.tapio.googlemaps.client.base.WeightedLocation> toGoogleWeightedLocations(
            List<WeightedLocation> weightedLocations) {
        if (weightedLocations == null) {
            return null;
        }

        List<com.vaadin.tapio.googlemaps.client.base.WeightedLocation> gWeightedLocations
                = new ArrayList<>(weightedLocations.size()*2);
        for (WeightedLocation w : weightedLocations) {
            LatLon location = new LatLon(w.getLocation().getLatitude(), w.getLocation().getLongitude());
            Double weight = w.getWeight();
            gWeightedLocations.add(new com.vaadin.tapio.googlemaps.client.base.WeightedLocation(location, weight));
        }

        return gWeightedLocations;
    }

    public static List<WeightedLocation> toWeightedLocations(
            List<com.vaadin.tapio.googlemaps.client.base.WeightedLocation> gWeightedLocations) {
        if (gWeightedLocations == null) {
            return null;
        }

        List<WeightedLocation> weightedLocations = new ArrayList<>(gWeightedLocations.size()*2);
        for (com.vaadin.tapio.googlemaps.client.base.WeightedLocation w : gWeightedLocations) {
            weightedLocations.add(new WeightedLocationDelegate(w));
        }

        return weightedLocations;
    }

    public static List<com.haulmont.charts.gui.map.model.directions.DirectionsLeg> toCubaDirectionsLegs(List<DirectionsLeg> gLegs) {
        if (gLegs == null) {
            return null;
        } else {
            List<com.haulmont.charts.gui.map.model.directions.DirectionsLeg> legs = new ArrayList<>(gLegs.size()*2);
            for (DirectionsLeg gLeg : gLegs) {
                legs.add(new DirectionsLegDelegate(gLeg));
            }
            return legs;
        }
    }

    public static List<DirectionsLeg> toGoogleDirectionsLegs(List<com.haulmont.charts.gui.map.model.directions.DirectionsLeg> legs) {
        if (legs == null) {
            return null;
        } else {
            List<DirectionsLeg> gLegs = new ArrayList<>(legs.size()*2);
            for (com.haulmont.charts.gui.map.model.directions.DirectionsLeg leg : legs) {
                gLegs.add(((DirectionsLegDelegate)leg).getDirectionsLeg());
            }
            return gLegs;
        }
    }

    public static List<com.haulmont.charts.gui.map.model.directions.DirectionsStep> toCubaDirectionsSteps(List<DirectionsStep> gSteps) {
        if (gSteps == null) {
            return null;
        } else {
            List<com.haulmont.charts.gui.map.model.directions.DirectionsStep> steps = new ArrayList<>(gSteps.size()*2);
            for (DirectionsStep gStep : gSteps) {
                steps.add(new DirectionsStepDelegate(gStep));
            }
            return steps;
        }
    }

    public static List<DirectionsStep> toGoogleDirectionsSteps(List<com.haulmont.charts.gui.map.model.directions.DirectionsStep> steps) {
        if (steps == null) {
            return null;
        } else {
            List<DirectionsStep> gSteps = new ArrayList<>(steps.size()*2);
            for (com.haulmont.charts.gui.map.model.directions.DirectionsStep step : steps) {
                gSteps.add(((DirectionsStepDelegate) step).getDirectionsStep());
            }
            return gSteps;
        }
    }

    public static List<com.haulmont.charts.gui.map.model.directions.DirectionsRoute> toCubaDirectionsRoutes(List<DirectionsRoute> gRoutes) {
        if (gRoutes == null) {
            return null;
        } else {
            List<com.haulmont.charts.gui.map.model.directions.DirectionsRoute> routes = new ArrayList<>(gRoutes.size()*2);
            for (DirectionsRoute gRoute : gRoutes) {
                routes.add(new DirectionsRouteDelegate(gRoute));
            }
            return routes;
        }
    }

    public static List<com.haulmont.charts.gui.map.model.directions.DirectionsWaypoint> toCubaDirectionsWaypoints(List<DirectionsWaypoint> gWaypoints) {
        if (gWaypoints == null) {
            return null;
        } else {
            List<com.haulmont.charts.gui.map.model.directions.DirectionsWaypoint> waypoints = new ArrayList<>(gWaypoints.size()*2);
            for (DirectionsWaypoint gWaypoint : gWaypoints) {
                waypoints.add(new DirectionsWaypointDelegate(gWaypoint));
            }
            return waypoints;
        }
    }

    public static List<DirectionsWaypoint> toGoogleDirectionsWaypoints(List<com.haulmont.charts.gui.map.model.directions.DirectionsWaypoint> waypoints) {
        if (waypoints == null) {
            return null;
        } else {
            List<DirectionsWaypoint> gWaypoints = new ArrayList<>(waypoints.size()*2);
            for (com.haulmont.charts.gui.map.model.directions.DirectionsWaypoint waypoint : waypoints) {
                gWaypoints.add(((DirectionsWaypointDelegate) waypoint).getDirectionsWaypoint());
            }
            return gWaypoints;
        }
    }
}