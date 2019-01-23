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

package com.haulmont.charts.web.widgets.client.addons.googlemap;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.base.LatLngBounds;
import com.google.gwt.maps.client.base.Point;
import com.google.gwt.maps.client.base.Size;
import com.google.gwt.maps.client.controls.ControlPosition;
import com.google.gwt.maps.client.maptypes.ImageMapType;
import com.google.gwt.maps.client.maptypes.ImageMapTypeOptions;
import com.google.gwt.maps.client.maptypes.TileUrlCallBack;
import com.google.gwt.maps.client.overlays.CircleOptions;
import com.google.gwt.maps.client.overlays.PolygonOptions;
import com.haulmont.charts.web.widgets.client.addons.googlemap.drawing.DrawingControlOptions;
import com.haulmont.charts.web.widgets.client.addons.googlemap.base.LatLon;
import com.haulmont.charts.web.widgets.client.addons.googlemap.drawing.DrawingOptions;
import com.haulmont.charts.web.widgets.client.addons.googlemap.drawing.OverlayType;
import com.haulmont.charts.web.widgets.client.addons.googlemap.maptypes.GoogleImageMapType;
import com.haulmont.charts.web.widgets.client.addons.googlemap.services.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Igor Korotkov (igor@ikorotkov.com)
 */
public class GoogleMapAdapterUtils {

    public static com.google.gwt.maps.client.drawinglib.DrawingManagerOptions toDrawingManagerOptions(DrawingOptions drawingOptions) {
        DrawingControlOptions
                vControlOptions = drawingOptions.getDrawingControlOptions();
        com.google.gwt.maps.client.drawinglib.DrawingControlOptions controlOptions =
                com.google.gwt.maps.client.drawinglib.DrawingControlOptions.newInstance();

        ControlPosition cp = toControlPosition(vControlOptions.getPosition());
        if (cp != null) {
            controlOptions.setPosition(cp);
        }

        if (!vControlOptions.getDrawingModes().isEmpty()) {
            List<OverlayType>
                    vDrawingModes = vControlOptions.getDrawingModes();

            int drawingModesNum = vDrawingModes.size();
            com.google.gwt.maps.client.drawinglib.OverlayType[] drawingModes = new com.google.gwt.maps.client.drawinglib.OverlayType[drawingModesNum];
            for (int i = 0; i < drawingModesNum; i++) {
                com.google.gwt.maps.client.drawinglib.OverlayType ot = toOverlayType(vDrawingModes.get(i));
                if (ot != null) {
                    drawingModes[i] = ot;
                }
            }
            controlOptions.setDrawingModes(drawingModes);
        }

        com.google.gwt.maps.client.drawinglib.DrawingManagerOptions options =
                com.google.gwt.maps.client.drawinglib.DrawingManagerOptions.newInstance();
        options.setDrawingControlOptions(controlOptions);
        options.setDrawingControl(drawingOptions.isEnableDrawingControl());

        com.google.gwt.maps.client.drawinglib.OverlayType ot = toOverlayType(drawingOptions.getInitialDrawingMode());
        if (ot != null) {
            options.setDrawingMode(ot);
        }

        return options;
    }

    public static PolygonOptions toPolygonOptions(com.haulmont.charts.web.widgets.client.addons.googlemap.drawing.PolygonOptions vOptions) {
        PolygonOptions options = PolygonOptions.newInstance();
        options.setEditable(vOptions.isEditable());
        options.setClickable(vOptions.isClickable());
        options.setFillColor(vOptions.getFillColor());
        options.setFillOpacity(vOptions.getFillOpacity());
        options.setGeodesic(vOptions.isGeodesic());
        options.setStrokeColor(vOptions.getStrokeColor());
        options.setStrokeOpacity(vOptions.getStrokeOpacity());
        options.setStrokeWeight(vOptions.getStrokeWeight());
        options.setVisible(vOptions.isVisible());
        options.setZindex(vOptions.getZIndex());
        return options;
    }

    public static CircleOptions toCircleOptions(com.haulmont.charts.web.widgets.client.addons.googlemap.drawing.CircleOptions vOptions) {
        CircleOptions options = CircleOptions.newInstance();
        if (vOptions.getRadius() != null) {
            options.setRadius(vOptions.getRadius());
        }
        if (vOptions.getCenter() != null) {
            options.setCenter(toLatLng(vOptions.getCenter()));
        }
        options.setClickable(vOptions.isClickable());
        options.setFillColor(vOptions.getFillColor());
        options.setFillOpacity(vOptions.getFillOpacity());
        options.setStrokeColor(vOptions.getStrokeColor());
        options.setStrokeOpacity(vOptions.getStrokeOpacity());
        options.setStrokeWeight(vOptions.getStrokeWeight());
        options.setZindex(vOptions.getZIndex());

        return options;
    }

    public static com.google.gwt.maps.client.drawinglib.OverlayType toOverlayType(
            OverlayType vOverlayType) {
        if (vOverlayType == null) {
            return null;
        }

        switch (vOverlayType) {
            case POLYGON: return com.google.gwt.maps.client.drawinglib.OverlayType.POLYGON;
            case CIRCLE: return com.google.gwt.maps.client.drawinglib.OverlayType.CIRCLE;
            case MARKER: return com.google.gwt.maps.client.drawinglib.OverlayType.POLYGON;
            case POLYLINE: return com.google.gwt.maps.client.drawinglib.OverlayType.POLYGON;
            case RECTANGLE: return com.google.gwt.maps.client.drawinglib.OverlayType.POLYGON;
            default: return null;
        }
    }

    public static ControlPosition toControlPosition(
            com.haulmont.charts.web.widgets.client.addons.googlemap.drawing.ControlPosition vPosition) {
        if (vPosition == null) {
            return null;
        }

        switch (vPosition) {
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
            default: return null;
        }
    }

    public static com.google.gwt.maps.client.services.DirectionsRequest toDirectionsRequest(DirectionsRequest googleMapRequest) {
        if (googleMapRequest == null) {
            return null;
        }

        com.google.gwt.maps.client.services.DirectionsRequest request =
                com.google.gwt.maps.client.services.DirectionsRequest.newInstance();
        request.setAvoidHighways(googleMapRequest.isAvoidHighways());
        request.setAvoidTolls(googleMapRequest.isAvoidTolls());
        request.setOptimizeWaypoints(googleMapRequest.isOptimizeWaypoints());
        request.setProvideRouteAlternatives(googleMapRequest.isProvideRouteAlternatives());
        request.setRegion(googleMapRequest.getRegion());
        if (googleMapRequest.getWaypoints() != null) {
            request.setWaypoints(toWaypointList(googleMapRequest.getWaypoints()));
        }
        if (googleMapRequest.getDestination() != null) {
            request.setDestination(toLatLng(googleMapRequest.getDestination()));
        }
        if (googleMapRequest.getOrigin() != null) {
            request.setOrigin(toLatLng(googleMapRequest.getOrigin()));
        }
        if (googleMapRequest.getTravelMode() != null) {
            request.setTravelMode(toTravelMode(googleMapRequest.getTravelMode()));
        }
        if (googleMapRequest.getUnitSystem() != null) {
            request.setUnitSystem(toUnitSystem(googleMapRequest.getUnitSystem()));
        }
        return request;
    }

    private static com.google.gwt.maps.client.services.UnitSystem toUnitSystem(UnitSystem googleMapUnitSystem) {
        return googleMapUnitSystem != null ?
                com.google.gwt.maps.client.services.UnitSystem.fromValue(googleMapUnitSystem.value()) : null;
    }

    private static com.google.gwt.maps.client.services.TravelMode toTravelMode(TravelMode googleMapTravelMode) {
        return googleMapTravelMode != null ?
                com.google.gwt.maps.client.services.TravelMode.fromValue(googleMapTravelMode.value()) : null;
    }

    private static JsArray<com.google.gwt.maps.client.services.DirectionsWaypoint> toWaypointList(List<DirectionsWaypoint> googleMapWaypoints) {
        if (googleMapWaypoints == null) {
            return null;
        }

        JsArray<com.google.gwt.maps.client.services.DirectionsWaypoint> waypoints = JsArray.createArray().cast();
        for (DirectionsWaypoint googleMapWaypoint : googleMapWaypoints) {
            waypoints.push(toDirectionsWaypoint(googleMapWaypoint));
        }
        return waypoints;
    }

    private static com.google.gwt.maps.client.services.DirectionsWaypoint toDirectionsWaypoint(DirectionsWaypoint googleMapWaypoint) {
        com.google.gwt.maps.client.services.DirectionsWaypoint waypoint =
                com.google.gwt.maps.client.services.DirectionsWaypoint.newInstance();
        waypoint.setLocation(toLatLng(googleMapWaypoint.getLocation()));
        return waypoint;
    }

    public static LatLng toLatLng(LatLon location) {
        return location != null ? LatLng.newInstance(location.getLat(), location.getLon()) : null;
    }

    public static DirectionsResult fromDirectionsResult(com.google.gwt.maps.client.services.DirectionsResult result) {
        if (result == null) {
            return null;
        }

        DirectionsResult googleMapsResult = new DirectionsResult();
        if (result.getRoutes() != null) {
            JsArray<com.google.gwt.maps.client.services.DirectionsRoute> routes = result.getRoutes();
            List<DirectionsRoute> googleMapsRoutes = new ArrayList<DirectionsRoute>(routes.length());
            for (int i = 0; i < routes.length(); i++) {
                googleMapsRoutes.add(GoogleMapAdapterUtils.fromDirectionsRoute(routes.get(i)));
            }
            googleMapsResult.setRoutes(googleMapsRoutes);
        }
        return googleMapsResult;
    }

    private static DirectionsRoute fromDirectionsRoute(com.google.gwt.maps.client.services.DirectionsRoute route) {
        if (route == null) {
            return null;
        }

        DirectionsRoute googleMapRoute = new DirectionsRoute();
        googleMapRoute.setBounds(fromBounds(route.getBounds()));
        googleMapRoute.setCopyrights(route.getCopyrights());
        googleMapRoute.setLegs(fromDirectionsLegs(route.getLegs()));
        googleMapRoute.setOverviewPath(fromLatLons(route.getOverview_Path()));
        googleMapRoute.setWarnings(fromArrayString(route.getWarnings()));
        googleMapRoute.setWaypointOrder(fromArrayInteger(route.getWayPoint_Order()));
        return googleMapRoute;
    }

    private static List<DirectionsLeg> fromDirectionsLegs(JsArray<com.google.gwt.maps.client.services.DirectionsLeg> legs) {
        if (legs == null) {
            return null;
        } else {
            List<DirectionsLeg> googleMapLegs = new ArrayList<DirectionsLeg>(legs.length());
            for (int i = 0; i < legs.length(); i++) {
                googleMapLegs.add(fromDirectionsLeg(legs.get(i)));
            }
            return googleMapLegs;
        }
    }

    private static DirectionsLeg fromDirectionsLeg(com.google.gwt.maps.client.services.DirectionsLeg leg) {
        if (leg == null) {
            return null;
        } else {
            DirectionsLeg googleMapLeg = new DirectionsLeg();
            googleMapLeg.setDistance(fromDistance(leg.getDistance()));
            googleMapLeg.setDuration(fromDuration(leg.getDuration()));
            googleMapLeg.setEndAddress(leg.getEnd_Address());
            googleMapLeg.setStartAddress(leg.getStart_Address());
            googleMapLeg.setStartLocation(fromLatLng(leg.getStart_Location()));
            googleMapLeg.setEndLocation(fromLatLng(leg.getEnd_Location()));
            googleMapLeg.setViaWaypoints(fromLatLons(leg.getVia_Waypoints()));
            googleMapLeg.setSteps(fromDirectionsSteps(leg.getSteps()));
            return googleMapLeg;
        }
    }

    private static List<DirectionsStep> fromDirectionsSteps(JsArray<com.google.gwt.maps.client.services.DirectionsStep> steps) {
        if (steps == null) {
            return null;
        } else {
            List<DirectionsStep> googleMapSteps = new ArrayList<DirectionsStep>(steps.length());
            for (int i = 0; i < steps.length(); i++) {
                googleMapSteps.add(fromDirectionsStep(steps.get(i)));
            }
            return googleMapSteps;
        }
    }

    private static DirectionsStep fromDirectionsStep(com.google.gwt.maps.client.services.DirectionsStep step) {
        if (step == null) {
            return null;
        } else {
            DirectionsStep googleMapStep = new DirectionsStep(fromLatLons(step.getPath()));
            googleMapStep.setEndLocation(fromLatLng(step.getEnd_Location()));
            googleMapStep.setStartLocation(fromLatLng(step.getStart_Location()));
            googleMapStep.setDistance(fromDistance(step.getDistance()));
            googleMapStep.setDuration(fromDuration(step.getDuration()));
            googleMapStep.setInstructions(step.getInstructions());
            googleMapStep.setTravelMode(fromTravelMode(step.getTravelMode()));
            return googleMapStep;
        }
    }

    private static TravelMode fromTravelMode(com.google.gwt.maps.client.services.TravelMode travelMode) {
        return travelMode != null ? TravelMode.fromValue(travelMode.value()) : null;
    }

    private static Distance fromDistance(com.google.gwt.maps.client.services.Distance distance) {
        return distance != null ? new Distance(distance.getText(), distance.getValue()) : null;
    }

    private static Duration fromDuration(com.google.gwt.maps.client.services.Duration duration) {
        return duration != null ? new Duration(duration.getText(), duration.getValue()) : null;
    }

    private static int[] fromArrayInteger(JsArrayInteger jsArray) {
        if (jsArray == null) {
            return null;
        } else {
            int[] array = new int[jsArray.length()];
            for (int i = 0; i < jsArray.length(); i++) {
                array[i] = jsArray.get(i);
            }
            return array;
        }
    }

    private static String[] fromArrayString(JsArrayString jsArray) {
        if (jsArray == null) {
            return null;
        } else {
            String[] array = new String[jsArray.length()];
            for (int i = 0; i < jsArray.length(); i++) {
                array[i] = jsArray.get(i);
            }
            return array;
        }
    }

    private static List<LatLon> fromLatLons(JsArray<LatLng> coordinates) {
        if (coordinates == null) {
            return null;
        }

        List<LatLon> googleMapCoordinates = new ArrayList<LatLon>(coordinates.length());
        for (int i = 0; i < coordinates.length(); i++) {
            googleMapCoordinates.add(fromLatLng(coordinates.get(i)));
        }
        return googleMapCoordinates;
    }

    private static LatLonBounds fromBounds(LatLngBounds bounds) {
        if (bounds == null) {
            return null;
        } else {
            LatLonBounds googleMapBounds = new LatLonBounds();
            googleMapBounds.setSw(fromLatLng(bounds.getSouthWest()));
            googleMapBounds.setNe(fromLatLng(bounds.getNorthEast()));
            return googleMapBounds;
        }
    }

    public static LatLon fromLatLng(LatLng latLng) {
        return latLng != null ? new LatLon(latLng.getLatitude(), latLng.getLongitude()) : null;
    }

    public static DirectionsStatus fromDirectionsStatus(com.google.gwt.maps.client.services.DirectionsStatus status) {
        return status != null ? DirectionsStatus.fromValue(status.value()) : null;
    }

    public static ImageMapType toImageMapType(final GoogleImageMapType googleImageMapType) {
        ImageMapTypeOptions options = ImageMapTypeOptions.newInstance();
        options.setMaxZoom(googleImageMapType.getMaxZoom());
        options.setMinZoom(googleImageMapType.getMinZoom());
        options.setName(googleImageMapType.getName());
        options.setAlt(googleImageMapType.getAltText());
        options.setOpacity(googleImageMapType.getOpacity());

        if (googleImageMapType.getTileSize() != null) {
            com.haulmont.charts.web.widgets.client.addons.googlemap.base.Size googleSize = googleImageMapType.getTileSize();
            Size size = Size.newInstance(googleSize.getWidth(), googleSize.getHeight(),
                    googleSize.getWidthUnit(), googleSize.getHeightUnit());
            options.setTileSize(size);
        }

        if (googleImageMapType.getTileUrlCallbackFunction() != null) {
            options.setTileUrl(new TileUrlCallBack() {
                JavaScriptObject tileUrlFunction = toJavaScriptObject(googleImageMapType.getTileUrlCallbackFunction());
                @Override
                public String getTileUrl(Point point, int zoomLevel) {
                    return nativeCall(tileUrlFunction, point.getX(), point.getY(), zoomLevel);
                }
            });
        }

        return ImageMapType.newInstance(options);
    }

    private native static JavaScriptObject toJavaScriptObject(String tileUrlCallbackFunction) /*-{
        return eval(tileUrlCallbackFunction);
    }-*/;

    private native static String nativeCall(JavaScriptObject tileUrlCallbackFunction, double x, double y, int zoom) /*-{
        return tileUrlCallbackFunction(x, y, zoom);
    }-*/;
}