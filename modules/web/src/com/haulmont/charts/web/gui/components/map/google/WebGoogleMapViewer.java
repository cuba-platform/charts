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

import java.util.*;

/**
 * @author korotkov
 * @version $Id$
 */
public class WebGoogleMapViewer extends WebAbstractComponent<GoogleMap> implements MapViewer {

    public static final String VENDOR = "google";

    protected MapConfig mapConfig = AppBeans.get(Configuration.class).getConfig(MapConfig.class);
    protected Map<MapMoveListener, com.vaadin.tapio.googlemaps.client.events.MapMoveListener> mapMoveListeners;
    protected Map<MarkerDragListener, com.vaadin.tapio.googlemaps.client.events.MarkerDragListener> markerDragListeners;
    protected Map<MarkerClickListener,
            com.vaadin.tapio.googlemaps.client.events.MarkerClickListener> markerClickListeners;
    protected Map<InfoWindowClosedListener,
            com.vaadin.tapio.googlemaps.client.events.InfoWindowClosedListener> infoWindowClosedListeners;

    public WebGoogleMapViewer() {
        super();

        String apiOrClientId;
        if (mapConfig.isUseBusinessApiKey()) {
            apiOrClientId = mapConfig.getBusinessApiKey();
        } else {
            apiOrClientId = mapConfig.getClientId();
        }
        component = new GoogleMap(new LatLon(mapConfig.getDefLatitude(), mapConfig.getDefLongitude()), apiOrClientId);

        mapMoveListeners = new HashMap<>();
        markerDragListeners = new HashMap<>();
        markerClickListeners = new HashMap<>();
        infoWindowClosedListeners = new HashMap<>();
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
    public void removeMapMoveListener(MapMoveListener listener) {
        component.removeMapMoveListener(mapMoveListeners.get(listener));
        mapMoveListeners.remove(listener);
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
    public void addMapMoveListener(final MapMoveListener listener) {
        MapMoveListenerDelegate googleListener = new MapMoveListenerDelegate(listener);
        mapMoveListeners.put(listener, googleListener);
        component.addMapMoveListener(googleListener);
    }

    @Override
    public void removeMarkerDragListener(MarkerDragListener listener) {
        component.removeMarkerDragListener(markerDragListeners.get(listener));
        markerDragListeners.remove(listener);
    }

    @Override
    public void addMarkerDragListener(MarkerDragListener listener) {
        MarkerDragListenerDelegate googleListener = new MarkerDragListenerDelegate(listener);
        markerDragListeners.put(listener, googleListener);
        component.addMarkerDragListener(googleListener);
    }

    @Override
    public void removeMarkerClickListener(MarkerClickListener listener) {
        component.removeMarkerClickListener(markerClickListeners.get(listener));
        markerClickListeners.remove(listener);
    }

    @Override
    public void addMarkerClickListener(MarkerClickListener listener) {
        MarkerClickListenerDelegate googleListener = new MarkerClickListenerDelegate(listener);
        markerClickListeners.put(listener, googleListener);
        component.addMarkerClickListener(googleListener);
    }

    @Override
    public void addInfoWindowClosedListener(InfoWindowClosedListener listener) {
        InfoWindowClosedListenerDelegate googleListener = new InfoWindowClosedListenerDelegate(listener);
        infoWindowClosedListeners.put(listener, googleListener);
        component.addInfoWindowClosedListener(googleListener);
    }

    @Override
    public void removeInfoWindowClosedListener(InfoWindowClosedListener listener) {
        component.removeInfoWindowClosedListener(infoWindowClosedListeners.get(listener));
        infoWindowClosedListeners.remove(listener);
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



    protected class MapMoveListenerDelegate implements com.vaadin.tapio.googlemaps.client.events.MapMoveListener {

        protected MapMoveListener cubaListener;

        public MapMoveListenerDelegate(MapMoveListener cubaListener) {
            this.cubaListener = cubaListener;
        }

        @Override
        public void mapMoved(double v, LatLon latLon, LatLon latLon2, LatLon latLon3) {
            cubaListener.mapMoved(v, new GeoPointDelegate(latLon), new GeoPointDelegate(latLon2),
                    new GeoPointDelegate(latLon3));
        }
    }

    protected class MarkerDragListenerDelegate implements com.vaadin.tapio.googlemaps.client.events.MarkerDragListener {

        protected MarkerDragListener cubaListener;

        public MarkerDragListenerDelegate(MarkerDragListener cubaListener) {
            this.cubaListener = cubaListener;
        }

        @Override
        public void markerDragged(GoogleMapMarker googleMarker, LatLon oldPosition) {
            cubaListener.markerDragged(new MarkerDelegate(googleMarker), new GeoPointDelegate(oldPosition));
        }
    }

    protected class MarkerClickListenerDelegate implements com.vaadin.tapio.googlemaps.client.events.MarkerClickListener {

        protected MarkerClickListener cubaListener;

        public MarkerClickListenerDelegate(MarkerClickListener cubaListener) {
            this.cubaListener = cubaListener;
        }

        @Override
        public void markerClicked(GoogleMapMarker googleMapMarker) {
            cubaListener.markerClicked(new MarkerDelegate(googleMapMarker));
        }
    }

    protected class InfoWindowClosedListenerDelegate implements com.vaadin.tapio.googlemaps.client.events.InfoWindowClosedListener {
        protected InfoWindowClosedListener cubaListener;

        public InfoWindowClosedListenerDelegate(InfoWindowClosedListener cubaListener) {
            this.cubaListener = cubaListener;
        }

        @Override
        public void infoWindowClosed(GoogleMapInfoWindow googleMapInfoWindow) {
            cubaListener.infoWindowClosed(new InfoWindowDelegate(googleMapInfoWindow));
        }
    }
}
