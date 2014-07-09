/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui.components.map.google;

import com.haulmont.charts.core.global.MapConfig;
import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.*;
import com.haulmont.charts.gui.map.model.drawing.DrawingOptions;
import com.haulmont.charts.gui.map.model.listeners.InfoWindowClosedListener;
import com.haulmont.charts.gui.map.model.listeners.MapClickListener;
import com.haulmont.charts.gui.map.model.listeners.MapMoveListener;
import com.haulmont.charts.gui.map.model.listeners.MarkerClickListener;
import com.haulmont.charts.gui.map.model.listeners.MarkerDragListener;
import com.haulmont.charts.gui.map.model.listeners.PolygonCompleteListener;
import com.haulmont.charts.gui.map.model.listeners.PolygonEditListener;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Configuration;
import com.haulmont.cuba.web.gui.components.WebAbstractComponent;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.*;
import com.vaadin.tapio.googlemaps.client.overlays.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.haulmont.charts.gui.map.model.listeners.InfoWindowClosedListener.InfoWindowCloseEvent;
import static com.haulmont.charts.gui.map.model.listeners.MapClickListener.MapClickEvent;
import static com.haulmont.charts.gui.map.model.listeners.MapMoveListener.MapMoveEvent;
import static com.haulmont.charts.gui.map.model.listeners.MarkerClickListener.MarkerClickEvent;
import static com.haulmont.charts.gui.map.model.listeners.MarkerDragListener.MarkerDragEvent;
import static com.haulmont.charts.gui.map.model.listeners.PolygonCompleteListener.PolygonCompleteEvent;

/**
 * @author korotkov
 * @version $Id$
 */
public class WebGoogleMapViewer extends WebAbstractComponent<GoogleMap> implements MapViewer {

    public static final String VENDOR = "google";

    protected MapConfig mapConfig = AppBeans.get(Configuration.class).getConfig(MapConfig.class);

    protected List<MapMoveListener> mapMoveListeners;
    protected com.vaadin.tapio.googlemaps.client.events.MapMoveListener mapMoveHandler;

    protected List<MapClickListener> mapClickListeners;
    protected com.vaadin.tapio.googlemaps.client.events.MapClickListener mapClickHandler;

    protected List<MarkerDragListener> markerDragListeners;
    protected com.vaadin.tapio.googlemaps.client.events.MarkerDragListener markerDragHandler;

    protected List<MarkerClickListener> markerClickListeners;
    protected com.vaadin.tapio.googlemaps.client.events.MarkerClickListener markerClickHandler;

    protected List<InfoWindowClosedListener> infoWindowClosedListeners;
    protected com.vaadin.tapio.googlemaps.client.events.InfoWindowClosedListener infoWindowClosedHandler;

    protected List<PolygonCompleteListener> polygonCompleteListeners;
    protected com.vaadin.tapio.googlemaps.client.events.PolygonCompleteListener polygonCompleteHandler;

    protected List<PolygonEditListener> polygonEditListeners;
    protected com.vaadin.tapio.googlemaps.client.events.PolygonEditListener polygonEditHandler;

    public WebGoogleMapViewer() {
        super();

        String apiOrClientId;
        if (mapConfig.isUseBusinessApiKey()) {
            apiOrClientId = mapConfig.getBusinessApiKey();
        } else {
            apiOrClientId = mapConfig.getClientId();
        }
        component = new GoogleMap(new LatLon(mapConfig.getDefLatitude(), mapConfig.getDefLongitude()), apiOrClientId);

    }

    @Override
    public GeoPoint getCenter() {
        return new GeoPointDelegate(component.getCenter());
    }

    @Override
    public void setZoom(int zoom) {
        component.setZoom(zoom);
    }

    @Override
    public int getZoom() {
        return component.getZoom();
    }

    @Override
    public Marker addMarker(String caption, GeoPoint position, boolean draggable, String iconUrl) {
        return new MarkerDelegate(component.addMarker(caption, ((GeoPointDelegate)position).getLatLon(), draggable, iconUrl));
    }

    @Override
    public void addMarker(Marker marker) {
        component.addMarker(((MarkerDelegate)marker).getMarker());
    }

    @Override
    public void removeMarker(Marker marker) {
        component.removeMarker(((MarkerDelegate)marker).getMarker());
    }

    @Override
    public void clearMarkers() {
        component.clearMarkers();
    }

    @Override
    public boolean hasMarker(Marker marker) {
        return component.hasMarker(((MarkerDelegate)marker).getMarker());
    }

    @Override
    public Collection<Marker> getMarkers() {
        Collection<GoogleMapMarker> googleMarkers = component.getMarkers();
        Collection<Marker> markers = new ArrayList<>(googleMarkers.size()*2);
        for (GoogleMapMarker googleMarker : googleMarkers) {
            markers.add(new MarkerDelegate(googleMarker));
        }
        return markers;
    }

    @Override
    public void setSizeFull() {
        component.setSizeFull();
    }

    @Override
    public void setSizeUndefined() {
        component.setSizeUndefined();
    }

    @Override
    public void setCenter(GeoPoint center) {
        component.setCenter(((GeoPointDelegate)center).getLatLon());
    }

    @Override
    public void removePolyline(Polyline polyline) {
        component.removePolyline(((PolylineDelegate)polyline).getPolyline());
    }

    @Override
    public void addPolyline(Polyline polyline) {
        component.addPolyline(((PolylineDelegate)polyline).getPolyline());
    }

    @Override
    public void setCenterBoundLimits(GeoPoint limitNE, GeoPoint limitSW) {
        component.setCenterBoundLimits(((GeoPointDelegate)limitNE).getLatLon(),
                ((GeoPointDelegate)limitSW).getLatLon());
    }

    @Override
    public void setCenterBoundLimitsEnabled(boolean enable) {
        component.setCenterBoundLimitsEnabled(enable);
    }

    @Override
    public boolean isCenterBoundLimitsEnabled() {
        return component.isCenterBoundLimitsEnabled();
    }

    @Override
    public void setScrollWheelEnabled(boolean enabled) {
        component.setScrollWheelEnabled(enabled);
    }

    @Override
    public boolean isScrollWheelEnabled() {
        return component.isScrollWheelEnabled();
    }

    @Override
    public void setKeyboardShortcutsEnabled(boolean enabled) {
        component.setKeyboardShortcutsEnabled(enabled);
    }

    @Override
    public boolean areKeyboardShortcutsEnabled() {
        return component.areKeyboardShortcutsEnabled();
    }

    @Override
    public void setDraggable(boolean draggable) {
        component.setDraggable(draggable);
    }

    @Override
    public boolean isDraggable() {
        return component.isDraggable();
    }

    @Override
    public int getMinZoom() {
        return component.getMinZoom();
    }

    @Override
    public void setMinZoom(int minZoom) {
        component.setMinZoom(minZoom);
    }

    @Override
    public int getMaxZoom() {
        return component.getMaxZoom();
    }

    @Override
    public void setMaxZoom(int maxZoom) {
        component.setMaxZoom(maxZoom);
    }

    @Override
    public void setVisibleAreaBoundLimits(GeoPoint limitNE, GeoPoint limitSW) {
        component.setVisibleAreaBoundLimits(((GeoPointDelegate)limitNE).getLatLon(),
                ((GeoPointDelegate)limitSW).getLatLon());
    }

    @Override
    public boolean isVisibleAreaBoundLimitsEnabled() {
        return component.isVisibleAreaBoundLimitsEnabled();
    }

    @Override
    public void fitToBounds(GeoPoint boundsNE, GeoPoint boundsSW) {
        component.fitToBounds(((GeoPointDelegate)boundsNE).getLatLon(), ((GeoPointDelegate)boundsSW).getLatLon());
    }

    @Override
    public void setVisibleAreaBoundLimitsEnabled(boolean enabled) {
        component.setVisibleAreaBoundLimitsEnabled(enabled);
    }

    @Override
    public void removePolygonOverlay(Polygon polygon) {
        component.removePolygonOverlay(((PolygonDelegate)polygon).getPolygon());
    }

    @Override
    public void addPolygonOverlay(Polygon polygon) {
        component.addPolygonOverlay(((PolygonDelegate)polygon).getPolygon());
    }

    @Override
    public GeoPoint createGeoPoint() {
        return new GeoPointDelegate();
    }

    @Override
    public GeoPoint createGeoPoint(double latitude, double longitude) {
        return new GeoPointDelegate(latitude, longitude);
    }

    @Override
    public Marker createMarker() {
        return new MarkerDelegate();
    }

    @Override
    public Marker createMarker(String caption, GeoPoint position, boolean draggable) {
        return new MarkerDelegate(new GoogleMapMarker(caption, ((GeoPointDelegate)position).getLatLon(), draggable));
    }

    @Override
    public Marker createMarker(String caption, GeoPoint position, boolean draggable, String iconUrl) {
        return new MarkerDelegate(new GoogleMapMarker(caption, ((GeoPointDelegate)position).getLatLon(), draggable,
                iconUrl));
    }

    @Override
    public Polygon createPolygon() {
        return new PolygonDelegate();
    }

    @Override
    public Polygon createPolygon(List<GeoPoint> coordinates) {
        return new PolygonDelegate(new GoogleMapPolygon(DelegateHelper.toLatLon(coordinates)));
    }

    @Override
    public Polygon createPolygon(List<GeoPoint> coordinates, String fillColor, double fillOpacity, String strokeColor,
                                 double strokeOpacity, int strokeWeight) {
        return new PolygonDelegate(new GoogleMapPolygon(DelegateHelper.toLatLon(coordinates), fillColor, fillOpacity,
                strokeColor, strokeOpacity, strokeWeight));
    }

    @Override
    public Polyline createPolyline() {
        return new PolylineDelegate();
    }

    @Override
    public Polyline createPolyline(List<GeoPoint> coordinates) {
        return new PolylineDelegate(new GoogleMapPolyline(DelegateHelper.toLatLon(coordinates)));
    }

    @Override
    public Polyline createPolyline(List<GeoPoint> coordinates, String strokeColor, double strokeOpacity, int strokeWeight) {
        return new PolylineDelegate(new GoogleMapPolyline(DelegateHelper.toLatLon(coordinates), strokeColor,
                strokeOpacity, strokeWeight));
    }

    @Override
    public InfoWindow createInfoWindow() {
        return new InfoWindowDelegate();
    }

    @Override
    public InfoWindow createInfoWindow(String content) {
        return new InfoWindowDelegate(new GoogleMapInfoWindow(content));
    }

    @Override
    public InfoWindow createInfoWindow(String content, Marker anchorMarker) {
        return new InfoWindowDelegate(new GoogleMapInfoWindow(content, ((MarkerDelegate)anchorMarker).getMarker()));
    }

    @Override
    public void addMapMoveListener(MapMoveListener listener) {
        if (mapMoveListeners == null) {
            mapMoveListeners = new ArrayList<>();
            mapMoveListeners.add(listener);

            mapMoveHandler = new com.vaadin.tapio.googlemaps.client.events.MapMoveListener() {
                @Override
                public void mapMoved(int zoom, LatLon center, LatLon boundsNE, LatLon boundsSW) {
                    MapMoveEvent event = new MapMoveEvent(zoom, new GeoPointDelegate(center),
                            new GeoPointDelegate(boundsNE), new GeoPointDelegate(boundsSW));
                    for (MapMoveListener l : new ArrayList<>(mapMoveListeners)) {
                        l.onMove(event);
                    }
                }
            };

            component.addMapMoveListener(mapMoveHandler);
        } else {
            mapMoveListeners.add(listener);
        }
    }

    @Override
    public void removeMapMoveListener(MapMoveListener listener) {
        if (mapMoveListeners != null) {
            mapMoveListeners.remove(listener);

            if (mapMoveListeners.isEmpty()) {
                component.removeMapMoveListener(mapMoveHandler);
                mapMoveHandler = null;
                mapMoveListeners = null;
            }
        }
    }

    @Override
    public void addMapClickListener(MapClickListener listener) {
        if (mapClickListeners == null) {
            mapClickListeners = new ArrayList<>();
            mapClickListeners.add(listener);

            mapClickHandler = new com.vaadin.tapio.googlemaps.client.events.MapClickListener() {
                @Override
                public void mapClicked(LatLon position) {
                    MapClickEvent event = new MapClickEvent(new GeoPointDelegate(position));
                    for (MapClickListener l : new ArrayList<>(mapClickListeners)) {
                        l.onClick(event);
                    }
                }
            };

            component.addMapClickListener(mapClickHandler);
        } else {
            mapClickListeners.add(listener);
        }
    }

    @Override
    public void removeMapClickListener(MapClickListener listener) {
        if (mapClickListeners != null) {
            mapClickListeners.remove(listener);

            if (mapClickListeners.isEmpty()) {
                component.removeMapClickListener(mapClickHandler);
                mapClickHandler = null;
                mapClickListeners = null;
            }
        }
    }

    @Override
    public void addMarkerDragListener(com.haulmont.charts.gui.map.model.listeners.MarkerDragListener listener) {
        if (markerDragListeners == null) {
            markerDragListeners = new ArrayList<>();
            markerDragListeners.add(listener);

            markerDragHandler = new com.vaadin.tapio.googlemaps.client.events.MarkerDragListener() {
                @Override
                public void markerDragged(GoogleMapMarker marker, LatLon oldPosition) {
                    MarkerDragEvent event = new MarkerDragEvent(new MarkerDelegate(marker),
                            new GeoPointDelegate(oldPosition));

                    for (MarkerDragListener l : new ArrayList<>(markerDragListeners)) {
                        l.onDrag(event);
                    }
                }
            };

            component.addMarkerDragListener(markerDragHandler);
        } else {
            markerDragListeners.add(listener);
        }
    }

    @Override
    public void removeMarkerDragListener(com.haulmont.charts.gui.map.model.listeners.MarkerDragListener listener) {
        if (markerDragListeners != null) {
            markerDragListeners.remove(listener);

            if (markerDragListeners.isEmpty()) {
                component.removeMarkerDragListener(markerDragHandler);
                markerDragHandler = null;
                markerDragListeners = null;
            }
        }
    }

    @Override
    public void addMarkerClickListener(com.haulmont.charts.gui.map.model.listeners.MarkerClickListener listener) {
        if (markerClickListeners == null) {
            markerClickListeners = new ArrayList<>();
            markerClickListeners.add(listener);

            markerClickHandler = new com.vaadin.tapio.googlemaps.client.events.MarkerClickListener() {

                @Override
                public void markerClicked(GoogleMapMarker marker) {
                    MarkerClickEvent event = new MarkerClickEvent(new MarkerDelegate(marker));
                    for (MarkerClickListener l : new ArrayList<>(markerClickListeners)) {
                        l.onClick(event);
                    }
                }
            };

            component.addMarkerClickListener(markerClickHandler);
        } else {
            markerClickListeners.add(listener);
        }
    }

    @Override
    public void removeMarkerClickListener(com.haulmont.charts.gui.map.model.listeners.MarkerClickListener listener) {
        if (markerClickListeners != null) {
            markerClickListeners.remove(listener);

            if (markerClickListeners.isEmpty()) {
                component.removeMarkerClickListener(markerClickHandler);
                markerClickHandler = null;
                markerClickListeners = null;
            }
        }
    }

    @Override
    public void addInfoWindowClosedListener(InfoWindowClosedListener listener) {
        if (infoWindowClosedListeners == null) {
            infoWindowClosedListeners = new ArrayList<>();
            infoWindowClosedListeners.add(listener);

            infoWindowClosedHandler = new com.vaadin.tapio.googlemaps.client.events.InfoWindowClosedListener() {

                @Override
                public void infoWindowClosed(GoogleMapInfoWindow infoWindow) {
                    InfoWindowCloseEvent event = new InfoWindowCloseEvent(new InfoWindowDelegate(infoWindow));
                    for (InfoWindowClosedListener l : new ArrayList<>(infoWindowClosedListeners)) {
                        l.onClose(event);
                    }
                }
            };

            component.addInfoWindowClosedListener(infoWindowClosedHandler);
        } else {
            infoWindowClosedListeners.add(listener);
        }
    }

    @Override
    public void removeInfoWindowClosedListener(InfoWindowClosedListener listener) {
        if (infoWindowClosedListeners != null) {
            infoWindowClosedListeners.remove(listener);

            if (infoWindowClosedListeners.isEmpty()) {
                component.removeInfoWindowClosedListener(infoWindowClosedHandler);
                infoWindowClosedHandler = null;
                infoWindowClosedListeners = null;
            }
        }
    }

    @Override
    public void addPolygonCompleteListener(PolygonCompleteListener listener) {
        if (polygonCompleteListeners == null) {
            polygonCompleteListeners = new ArrayList<>();
            polygonCompleteListeners.add(listener);

            polygonCompleteHandler = new com.vaadin.tapio.googlemaps.client.events.PolygonCompleteListener() {

                @Override
                public void polygonComplete(GoogleMapPolygon polygon) {
                    PolygonCompleteEvent event = new PolygonCompleteEvent(new PolygonDelegate(polygon));
                    for (PolygonCompleteListener l : new ArrayList<>(polygonCompleteListeners)) {
                        l.onComplete(event);
                    }
                }
            };

            component.addPolygonCompleteListener(polygonCompleteHandler);
        } else {
            polygonCompleteListeners.add(listener);
        }
    }

    @Override
    public void removePolygonCompleteListener(PolygonCompleteListener listener) {
        if (polygonCompleteListeners != null) {
            polygonCompleteListeners.remove(listener);

            if (polygonCompleteListeners.isEmpty()) {
                component.removePolygonCompleteListener(polygonCompleteHandler);
                polygonCompleteHandler = null;
                polygonCompleteListeners = null;
            }
        }
    }

    @Override
    public void addPolygonEditListener(PolygonEditListener listener) {
        if (polygonEditListeners == null) {
            polygonEditListeners = new ArrayList<>();
            polygonEditListeners.add(listener);

            polygonEditHandler = new com.vaadin.tapio.googlemaps.client.events.PolygonEditListener() {

                @Override
                public void polygonEdited(GoogleMapPolygon polygon, ActionType actionType, int idx, LatLon latLon) {
                    PolygonEditListener.PolygonEditEvent event =
                            new PolygonEditListener.PolygonEditEvent(new PolygonDelegate(polygon),
                                    toCubaActionType(actionType), idx, new GeoPointDelegate(latLon));
                    for (PolygonEditListener l : new ArrayList<>(polygonEditListeners)) {
                        l.onEdit(event);
                    }
                }
            };

            component.addPolygonEditListener(polygonEditHandler);
        } else {
            polygonEditListeners.add(listener);
        }
    }

    private PolygonEditListener.ActionType toCubaActionType(
            com.vaadin.tapio.googlemaps.client.events.PolygonEditListener.ActionType actionType) {
        if (actionType == null) {
            return null;
        }

        switch (actionType) {
            case INSERT: return PolygonEditListener.ActionType.INSERT;
            case REMOVE: return PolygonEditListener.ActionType.REMOVE;
            case SET: return PolygonEditListener.ActionType.SET;
        }

        throw new IllegalArgumentException("Unknown edit action type: " + actionType);
    }

    @Override
    public void removePolygonEditListener(PolygonEditListener listener) {
        if (polygonEditListeners != null) {
            polygonEditListeners.remove(listener);

            if (polygonEditListeners.isEmpty()) {
                component.removePolygonEditListener(polygonEditHandler);
                polygonEditHandler = null;
                polygonEditListeners = null;
            }
        }
    }

    @Override
    public void setMapType(Type type) {
        component.setMapType(DelegateHelper.toGoogleMapType(type));
    }

    @Override
    public Type getMapType() {
        return DelegateHelper.toCubaMapType(component.getMapType());
    }

    @Override
    public boolean isInfoWindowOpen(InfoWindow infoWindow) {
        return component.isInfoWindowOpen(((InfoWindowDelegate)infoWindow).getInfoWindow());
    }

    @Override
    public void setDrawingOptions(DrawingOptions drawingOptions) {
        component.setDrawingOptions(DelegateHelper.toGoogleDrawingOptions(drawingOptions));
    }

    @Override
    public void closeInfoWindow(InfoWindow infoWindow) {
        component.closeInfoWindow(((InfoWindowDelegate)infoWindow).getInfoWindow());
    }

    @Override
    public void openInfoWindow(InfoWindow infoWindow) {
        component.openInfoWindow(((InfoWindowDelegate)infoWindow).getInfoWindow());
    }
}