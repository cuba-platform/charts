/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.gui.components.map.google;

import com.haulmont.charts.core.global.MapConfig;
import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.charts.gui.map.model.*;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Configuration;
import com.haulmont.cuba.web.gui.components.WebAbstractComponent;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author korotkov
 * @version $Id$
 */
public class WebGoogleMapViewer extends WebAbstractComponent<GoogleMap> implements MapViewer {

    public static final String VENDOR = "google";

    protected MapConfig mapConfig = AppBeans.get(Configuration.class).getConfig(MapConfig.class);

    protected List<MapMoveListener> mapMoveListeners;
    protected com.vaadin.tapio.googlemaps.client.events.MapMoveListener mapMoveHandler;

    protected List<MarkerDragListener> markerDragListeners;
    protected com.vaadin.tapio.googlemaps.client.events.MarkerDragListener markerDragHandler;

    protected List<MarkerClickListener> markerClickListeners;
    protected com.vaadin.tapio.googlemaps.client.events.MarkerClickListener markerClickHandler;

    protected List<InfoWindowClosedListener> infoWindowClosedListeners;
    protected com.vaadin.tapio.googlemaps.client.events.InfoWindowClosedListener infoWindowClosedHandler;

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
    public void setZoom(double zoom) {
        component.setZoom(zoom);
    }

    @Override
    public double getZoom() {
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
    public double getMinZoom() {
        return component.getMinZoom();
    }

    @Override
    public void setMinZoom(double minZoom) {
        component.setMinZoom(minZoom);
    }

    @Override
    public double getMaxZoom() {
        return component.getMaxZoom();
    }

    @Override
    public void setMaxZoom(double maxZoom) {
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
                public void mapMoved(double zoom, LatLon center, LatLon boundsNE, LatLon boundsSW) {
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
    public void addMarkerDragListener(MarkerDragListener listener) {
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
    public void removeMarkerDragListener(MarkerDragListener listener) {
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
    public void addMarkerClickListener(MarkerClickListener listener) {
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
    public void removeMarkerClickListener(MarkerClickListener listener) {
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
    public void closeInfoWindow(InfoWindow infoWindow) {
        component.closeInfoWindow(((InfoWindowDelegate)infoWindow).getInfoWindow());
    }

    @Override
    public void openInfoWindow(InfoWindow infoWindow) {
        component.openInfoWindow(((InfoWindowDelegate)infoWindow).getInfoWindow());
    }
}
