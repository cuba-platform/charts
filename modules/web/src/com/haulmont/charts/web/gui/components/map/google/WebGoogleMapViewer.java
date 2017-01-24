/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.map.google;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.charts.core.global.MapConfig;
import com.haulmont.charts.gui.components.map.GoogleMapViewer;
import com.haulmont.charts.gui.map.model.*;
import com.haulmont.charts.gui.map.model.base.MarkerImage;
import com.haulmont.charts.gui.map.model.base.Point;
import com.haulmont.charts.gui.map.model.base.Size;
import com.haulmont.charts.gui.map.model.directions.DirectionsRequest;
import com.haulmont.charts.gui.map.model.directions.DirectionsRequestCallback;
import com.haulmont.charts.gui.map.model.directions.DirectionsWaypoint;
import com.haulmont.charts.gui.map.model.directions.TravelMode;
import com.haulmont.charts.gui.map.model.drawing.DrawingOptions;
import com.haulmont.charts.gui.map.model.layer.HeatMapLayer;
import com.haulmont.charts.gui.map.model.listeners.InfoWindowClosedListener;
import com.haulmont.charts.gui.map.model.listeners.MapInitListener;
import com.haulmont.charts.gui.map.model.listeners.MapMoveListener;
import com.haulmont.charts.gui.map.model.listeners.PolygonEditListener;
import com.haulmont.charts.gui.map.model.listeners.centerchange.CircleCenterChangeListener;
import com.haulmont.charts.gui.map.model.listeners.click.CircleClickListener;
import com.haulmont.charts.gui.map.model.listeners.click.MapClickListener;
import com.haulmont.charts.gui.map.model.listeners.click.MarkerClickListener;
import com.haulmont.charts.gui.map.model.listeners.click.PolygonClickListener;
import com.haulmont.charts.gui.map.model.listeners.doubleclick.CircleDoubleClickListener;
import com.haulmont.charts.gui.map.model.listeners.doubleclick.MarkerDoubleClickListener;
import com.haulmont.charts.gui.map.model.listeners.drag.MarkerDragListener;
import com.haulmont.charts.gui.map.model.listeners.overlaycomplete.CircleCompleteListener;
import com.haulmont.charts.gui.map.model.listeners.overlaycomplete.PolygonCompleteListener;
import com.haulmont.charts.gui.map.model.listeners.radiuschange.CircleRadiusChangeListener;
import com.haulmont.charts.gui.map.model.maptype.ImageMapType;
import com.haulmont.charts.web.gui.components.map.google.base.MarkerImageDelegate;
import com.haulmont.charts.web.gui.components.map.google.base.PointDelegate;
import com.haulmont.charts.web.gui.components.map.google.base.SizeDelegate;
import com.haulmont.charts.web.gui.components.map.google.directions.DirectionsRequestDelegate;
import com.haulmont.charts.web.gui.components.map.google.directions.DirectionsResultDelegate;
import com.haulmont.charts.web.gui.components.map.google.directions.DirectionsWaypointDelegate;
import com.haulmont.charts.web.gui.components.map.google.layer.HeatMapLayerDelegate;
import com.haulmont.charts.web.gui.components.map.google.maptype.ImageMapTypeDelegate;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Configuration;
import com.haulmont.cuba.web.gui.components.WebAbstractComponent;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.base.LatLon;
import com.vaadin.tapio.googlemaps.client.layers.GoogleMapHeatMapLayer;
import com.vaadin.tapio.googlemaps.client.overlays.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.haulmont.charts.gui.map.model.listeners.InfoWindowClosedListener.InfoWindowCloseEvent;
import static com.haulmont.charts.gui.map.model.listeners.MapMoveListener.MapMoveEvent;
import static com.haulmont.charts.gui.map.model.listeners.click.MapClickListener.MapClickEvent;
import static com.haulmont.charts.gui.map.model.listeners.click.MarkerClickListener.MarkerClickEvent;
import static com.haulmont.charts.gui.map.model.listeners.doubleclick.MarkerDoubleClickListener.MarkerDoubleClickEvent;
import static com.haulmont.charts.gui.map.model.listeners.drag.MarkerDragListener.MarkerDragEvent;
import static com.haulmont.charts.gui.map.model.listeners.overlaycomplete.PolygonCompleteListener.PolygonCompleteEvent;

public class WebGoogleMapViewer extends WebAbstractComponent<GoogleMap> implements GoogleMapViewer {

    public static final String VENDOR = "google";

    private final Logger log = LoggerFactory.getLogger(WebGoogleMapViewer.class);

    protected MapConfig mapConfig = AppBeans.get(Configuration.class).getConfig(MapConfig.class);

    protected List<MapMoveListener> mapMoveListeners;
    protected com.vaadin.tapio.googlemaps.client.events.MapMoveListener mapMoveHandler;

    protected List<MapClickListener> mapClickListeners;
    protected com.vaadin.tapio.googlemaps.client.events.click.MapClickListener mapClickHandler;

    protected List<MarkerDragListener> markerDragListeners;
    protected com.vaadin.tapio.googlemaps.client.events.MarkerDragListener markerDragHandler;

    protected List<MarkerClickListener> markerClickListeners;
    protected com.vaadin.tapio.googlemaps.client.events.click.MarkerClickListener markerClickHandler;

    protected List<MarkerDoubleClickListener> markerDoubleClickListeners;
    protected com.vaadin.tapio.googlemaps.client.events.doubleclick.MarkerDoubleClickListener markerDoubleClickHandler;

    protected List<InfoWindowClosedListener> infoWindowClosedListeners;
    protected com.vaadin.tapio.googlemaps.client.events.InfoWindowClosedListener infoWindowClosedHandler;

    protected List<PolygonCompleteListener> polygonCompleteListeners;
    protected com.vaadin.tapio.googlemaps.client.events.overlaycomplete.PolygonCompleteListener polygonCompleteHandler;

    protected List<PolygonEditListener> polygonEditListeners;
    protected com.vaadin.tapio.googlemaps.client.events.PolygonEditListener polygonEditHandler;

    protected List<PolygonClickListener> polygonClickListeners;
    protected com.vaadin.tapio.googlemaps.client.events.click.PolygonClickListener polygonClickHandler;

    protected List<MapInitListener> mapInitListeners;
    protected com.vaadin.tapio.googlemaps.client.events.MapInitListener mapInitHandler;

    protected List<CircleClickListener> circleClickListeners;
    protected com.vaadin.tapio.googlemaps.client.events.click.CircleClickListener circleClickHandler;

    protected List<CircleDoubleClickListener> circleDoubleClickListeners;
    protected com.vaadin.tapio.googlemaps.client.events.doubleclick.CircleDoubleClickListener circleDoubleClickHandler;

    protected List<CircleRadiusChangeListener> circleRadiusChangeListeners;
    protected com.vaadin.tapio.googlemaps.client.events.radiuschange.CircleRadiusChangeListener circleRadiusChangeHandler;

    protected List<CircleCenterChangeListener> circleCenterChangeListeners;
    protected com.vaadin.tapio.googlemaps.client.events.centerchange.CircleCenterChangeListener circleCenterChangeHandler;

    protected List<CircleCompleteListener> circleCompleteListeners;
    protected com.vaadin.tapio.googlemaps.client.events.overlaycomplete.CircleCompleteListener circleCompleteHandler;


    public WebGoogleMapViewer() {
        super();

        String clientId = mapConfig.getClientId();
        String key = mapConfig.getApiKey();
        String lang = mapConfig.getLanguage();

        mapInitHandler = (center, zoom, boundsNE, boundsSW) -> {
            if (mapInitListeners == null) {
                return;
            }
            GeoPointDelegate geoPointCenter = center != null ? new GeoPointDelegate(center) : null;
            GeoPointDelegate geoPointBoundNE = boundsNE != null ? new GeoPointDelegate(boundsNE) : null;
            GeoPointDelegate geoPointBoundSW = boundsSW != null ? new GeoPointDelegate(boundsSW) : null;
            for (MapInitListener l : new ArrayList<>(mapInitListeners)) {
                l.init(geoPointCenter, zoom, geoPointBoundNE, geoPointBoundSW);
            }
        };

        component = new GoogleMap(new LatLon(mapConfig.getDefLatitude(), mapConfig.getDefLongitude()),
                mapConfig.getDefZoom().intValue(), key, clientId, lang, mapInitHandler);
    }

    @Override
    public GeoPoint getCenter() {
        return new GeoPointDelegate(component.getCenter());
    }

    @Override
    public GeoPoint getBoundSouthWest() {
        return new GeoPointDelegate(component.getBoundSW());
    }

    @Override
    public GeoPoint getBoundNorthEast() {
        return new GeoPointDelegate(component.getBoundNE());
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
    public void addCircleOverlay(Circle circle) {
        component.addCircleOverlay(((CircleDelegate)circle).getCircle());
    }

    @Override
    public void removeCircleOverlay(Circle circle) {
        component.removeCircleOverlay(((CircleDelegate)circle).getCircle());
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
        return new MarkerDelegate(new GoogleMapMarker(caption,
                position != null ? ((GeoPointDelegate)position).getLatLon() : null,
                draggable,
                iconUrl));
    }

    @Override
    public Marker createMarker(String caption, GeoPoint position, boolean draggable, MarkerImage icon) {
        return new MarkerDelegate(new GoogleMapMarker(
                caption,
                position != null ? ((GeoPointDelegate)position).getLatLon() : null,
                draggable,
                icon != null ? ((MarkerImageDelegate)icon).getMarkerImage() : null));
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
    public Circle createCircle() {
        return new CircleDelegate(new GoogleMapCircle());
    }

    @Override
    public Circle createCircle(GeoPoint center, double radius) {
        return new CircleDelegate(new GoogleMapCircle(((GeoPointDelegate)center).getLatLon(), radius));
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
    public void removeHeatMapLayer(HeatMapLayer layer) {
        component.removeHeatMapLayer(((HeatMapLayerDelegate) layer).getLayer());
    }

    @Override
    public void addHeatMapLayer(HeatMapLayer layer) {
        component.addHeatMapLayer(((HeatMapLayerDelegate)layer).getLayer());
    }

    @Override
    public HeatMapLayer createHeatMapLayer() {
        return new HeatMapLayerDelegate(new GoogleMapHeatMapLayer());
    }

    @Override
    public ImageMapType createImageMapType(String mapTypeId) {
        return new ImageMapTypeDelegate(mapTypeId);
    }

    @Override
    public ImageMapType createImageMapType(String mapTypeId, String tileUrlCallbackJsFunction) {
        return new ImageMapTypeDelegate(mapTypeId, tileUrlCallbackJsFunction);
    }

    @Override
    public ImageMapType createImageMapType(String mapTypeId, String name, String tileUrlCallbackJsFunction) {
        return new ImageMapTypeDelegate(mapTypeId, name, tileUrlCallbackJsFunction);
    }

    @Override
    public void addImageMapType(ImageMapType imageMapType) {
        component.addImageMapType(((ImageMapTypeDelegate)imageMapType).getMapType());
    }

    @Override
    public void removeImageMapType(ImageMapType imageMapType) {
        Preconditions.checkNotNullArgument(imageMapType);
        component.removeImageMapType(((ImageMapTypeDelegate)imageMapType).getMapType());
    }

    @Override
    public void addOverlayImageMapType(ImageMapType imageMapType) {
        component.addOverlayImageMapType(((ImageMapTypeDelegate)imageMapType).getMapType());
    }

    @Override
    public void removeOverlayImageMapType(ImageMapType imageMapType) {
        Preconditions.checkNotNullArgument(imageMapType);
        component.removeOverlayImageMapType(((ImageMapTypeDelegate)imageMapType).getMapType());
    }

    @Override
    public void addMapMoveListener(MapMoveListener listener) {
        if (mapMoveListeners == null) {
            mapMoveListeners = new ArrayList<>();
            mapMoveListeners.add(listener);

            mapMoveHandler = (zoom, center, boundsNE, boundsSW) -> {
                GeoPointDelegate geoPointCenter = center != null ? new GeoPointDelegate(center) : null;
                GeoPointDelegate geoPointBoundNE = boundsNE != null ? new GeoPointDelegate(boundsNE) : null;
                GeoPointDelegate geoPointBoundSW = boundsSW != null ? new GeoPointDelegate(boundsSW) : null;
                MapMoveEvent event = new MapMoveEvent(zoom, geoPointCenter, geoPointBoundNE, geoPointBoundSW);
                for (MapMoveListener l : new ArrayList<>(mapMoveListeners)) {
                    l.onMove(event);
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

            mapClickHandler = position -> {
                GeoPointDelegate geoPoint = position != null ? new GeoPointDelegate(position) : null;
                MapClickEvent event = new MapClickEvent(geoPoint);
                for (MapClickListener l : new ArrayList<>(mapClickListeners)) {
                    l.onClick(event);
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
    public void removePolygonClickListener(PolygonClickListener listener) {
        if (polygonClickListeners != null) {
            polygonClickListeners.remove(listener);

            if (polygonClickListeners.isEmpty()) {
                component.removePolygonClickListener(polygonClickHandler);
                polygonClickHandler = null;
                polygonClickListeners = null;
            }
        }
    }

    @Override
    public void addPolygonClickListener(PolygonClickListener listener) {
        if (polygonClickListeners == null) {
            polygonClickListeners = new ArrayList<>();
            polygonClickListeners.add(listener);

            polygonClickHandler = polygon -> {
                if (polygon == null) {
                    log.warn("Polygon clicked listener have been fired but no polygon received");
                    return;
                }
                PolygonClickListener.PolygonClickEvent event =
                        new PolygonClickListener.PolygonClickEvent(new PolygonDelegate(polygon));
                for (PolygonClickListener l : new ArrayList<>(polygonClickListeners)) {
                    l.onClick(event);
                }
            };

            component.addPolygonClickListener(polygonClickHandler);
        } else {
            polygonClickListeners.add(listener);
        }
    }

    @Override
    public void addMarkerDragListener(MarkerDragListener listener) {
        if (markerDragListeners == null) {
            markerDragListeners = new ArrayList<>();
            markerDragListeners.add(listener);

            markerDragHandler = (marker, oldPosition) -> {
                if (marker == null) {
                    log.warn("Marker dragged listener have been fired but no marker received");
                    return;
                }
                GeoPointDelegate geoPoint = oldPosition != null ? new GeoPointDelegate(oldPosition) : null;
                MarkerDragEvent event = new MarkerDragEvent(new MarkerDelegate(marker), geoPoint);

                for (MarkerDragListener l : new ArrayList<>(markerDragListeners)) {
                    l.onDrag(event);
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

            markerClickHandler = marker -> {
                if (marker == null) {
                    log.warn("Marker clicked listener have been fired but no marker received");
                    return;
                }
                MarkerClickEvent event = new MarkerClickEvent(new MarkerDelegate(marker));
                for (MarkerClickListener l : new ArrayList<>(markerClickListeners)) {
                    l.onClick(event);
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
    public void addMarkerDoubleClickListener(MarkerDoubleClickListener listener) {
        if (markerDoubleClickListeners == null) {
            markerDoubleClickListeners = new ArrayList<>();
            markerDoubleClickListeners.add(listener);

            markerDoubleClickHandler = marker -> {
                if (marker == null) {
                    log.warn("Marker double clicked listener have been fired but no marker received");
                    return;
                }
                MarkerDoubleClickEvent event = new MarkerDoubleClickEvent(new MarkerDelegate(marker));
                for (MarkerDoubleClickListener l : new ArrayList<>(markerDoubleClickListeners)) {
                    l.onClick(event);
                }
            };

            component.addMarkerDoubleClickListener(markerDoubleClickHandler);
        } else {
            markerDoubleClickListeners.add(listener);
        }
    }

    @Override
    public void removeMarkerDoubleClickListener(MarkerDoubleClickListener listener) {
        if (markerDoubleClickListeners != null) {
            markerDoubleClickListeners.remove(listener);

            if (markerDoubleClickListeners.isEmpty()) {
                component.removeMarkerDoubleClickListener(markerDoubleClickHandler);
                markerDoubleClickHandler = null;
                markerDoubleClickListeners = null;
            }
        }
    }

    @Override
    public void addInfoWindowClosedListener(InfoWindowClosedListener listener) {
        if (infoWindowClosedListeners == null) {
            infoWindowClosedListeners = new ArrayList<>();
            infoWindowClosedListeners.add(listener);

            infoWindowClosedHandler = infoWindow -> {
                if (infoWindow == null) {
                    log.warn("InfoWindow close listener have been fired but no info window received");
                    return;
                }
                InfoWindowCloseEvent event = new InfoWindowCloseEvent(new InfoWindowDelegate(infoWindow));
                for (InfoWindowClosedListener l : new ArrayList<>(infoWindowClosedListeners)) {
                    l.onClose(event);
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

            polygonCompleteHandler = polygon -> {
                if (polygon == null) {
                    log.warn("Polygon complete listener have been fired but no polygon received");
                    return;
                }
                PolygonCompleteEvent event = new PolygonCompleteEvent(new PolygonDelegate(polygon));
                for (PolygonCompleteListener l : new ArrayList<>(polygonCompleteListeners)) {
                    l.onComplete(event);
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

            polygonEditHandler = (polygon, actionType, idx, latLon) -> {
                if (polygon == null) {
                    log.warn("Polygon edited listener have been fired but no polygon received");
                    return;
                }
                GeoPointDelegate geoPoint = latLon != null ? new GeoPointDelegate(latLon) : null;
                PolygonEditListener.PolygonEditEvent event =
                        new PolygonEditListener.PolygonEditEvent(new PolygonDelegate(polygon),
                                toCubaActionType(actionType), idx, geoPoint);
                for (PolygonEditListener l : new ArrayList<>(polygonEditListeners)) {
                    l.onEdit(event);
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
    public void addCircleClickListener(CircleClickListener listener) {
        if (circleClickListeners == null) {
            circleClickListeners = new ArrayList<>();
            circleClickListeners.add(listener);

            circleClickHandler = circle -> {
                if (circle == null) {
                    log.warn("Circle clicked listener have been fired but no circle received");
                    return;
                }
                CircleClickListener.CircleClickEvent event = new CircleClickListener.CircleClickEvent(new CircleDelegate(circle));
                for (CircleClickListener l : new ArrayList<>(circleClickListeners)) {
                    l.onClick(event);
                }
            };

            component.addCircleClickListener(circleClickHandler);
        } else {
            circleClickListeners.add(listener);
        }
    }

    @Override
    public void removeCircleClickListener(CircleClickListener listener) {
        if (circleClickListeners != null) {
            circleClickListeners.remove(listener);

            if (circleClickListeners.isEmpty()) {
                component.removeCircleClickListener(circleClickHandler);
                circleClickHandler = null;
                circleClickListeners = null;
            }
        }
    }

    @Override
    public void addCircleDoubleClickListener(CircleDoubleClickListener listener) {
        if (circleDoubleClickListeners == null) {
            circleDoubleClickListeners = new ArrayList<>();
            circleDoubleClickListeners.add(listener);

            circleDoubleClickHandler = circle -> {
                if (circle == null) {
                    log.warn("Circle double clicked listener have been fired but no circle received");
                    return;
                }
                CircleDoubleClickListener.CircleDoubleClickEvent event =
                        new CircleDoubleClickListener.CircleDoubleClickEvent(new CircleDelegate(circle));
                for (CircleDoubleClickListener l : new ArrayList<>(circleDoubleClickListeners)) {
                    l.onDoubleClick(event);
                }
            };

            component.addCircleDoubleClickListener(circleDoubleClickHandler);
        } else {
            circleDoubleClickListeners.add(listener);
        }
    }

    @Override
    public void removeCircleDoubleClickListener(CircleDoubleClickListener listener) {
        if (circleDoubleClickListeners != null) {
            circleDoubleClickListeners.remove(listener);

            if (circleDoubleClickListeners.isEmpty()) {
                component.removeCircleDoubleClickListener(circleDoubleClickHandler);
                circleDoubleClickHandler = null;
                circleDoubleClickListeners = null;
            }
        }
    }

    @Override
    public void addCircleRadiusChangeListener(CircleRadiusChangeListener listener) {
        if (circleRadiusChangeListeners == null) {
            circleRadiusChangeListeners = new ArrayList<>();
            circleRadiusChangeListeners.add(listener);

            circleRadiusChangeHandler = (circle, oldRadius) -> {
                if (circle == null) {
                    log.warn("Circle radius changed listener have been fired but no circle received");
                    return;
                }
                CircleRadiusChangeListener.CircleRadiusChangeEvent event =
                        new CircleRadiusChangeListener.CircleRadiusChangeEvent(new CircleDelegate(circle), oldRadius);
                for (CircleRadiusChangeListener l : new ArrayList<>(circleRadiusChangeListeners)) {
                    l.onRadiusChange(event);
                }
            };

            component.addCircleRadiusChangeListener(circleRadiusChangeHandler);
        } else {
            circleRadiusChangeListeners.add(listener);
        }
    }

    @Override
    public void removeCircleRadiusChangeListener(CircleRadiusChangeListener listener) {
        if (circleRadiusChangeListeners != null) {
            circleRadiusChangeListeners.remove(listener);

            if (circleRadiusChangeListeners.isEmpty()) {
                component.removeCircleRadiusChangeListener(circleRadiusChangeHandler);
                circleRadiusChangeHandler = null;
                circleRadiusChangeListeners = null;
            }
        }
    }

    @Override
    public void addCircleCenterChangeListener(CircleCenterChangeListener listener) {
        if (circleCenterChangeListeners == null) {
            circleCenterChangeListeners = new ArrayList<>();
            circleCenterChangeListeners.add(listener);

            circleCenterChangeHandler = (circle, oldCenter) -> {
                if (circle == null) {
                    log.warn("Circle center changed listener have been fired but no circle received");
                    return;
                }
                if (oldCenter == null) {
                    log.warn("Circle center changed listener have been fired but old center point is null");
                    return;
                }
                CircleCenterChangeListener.CircleCenterChangeEvent event =
                        new CircleCenterChangeListener.CircleCenterChangeEvent(new CircleDelegate(circle), new GeoPointDelegate(oldCenter));
                for (CircleCenterChangeListener l : new ArrayList<>(circleCenterChangeListeners)) {
                    l.onCenterChange(event);
                }
            };

            component.addCircleCenterChangeListener(circleCenterChangeHandler);
        } else {
            circleCenterChangeListeners.add(listener);
        }
    }

    @Override
    public void removeCircleCenterChangeListener(CircleCenterChangeListener listener) {
        if (circleCenterChangeListeners != null) {
            circleCenterChangeListeners.remove(listener);

            if (circleCenterChangeListeners.isEmpty()) {
                component.removeCircleCenterChangeListener(circleCenterChangeHandler);
                circleCenterChangeHandler = null;
                circleCenterChangeListeners = null;
            }
        }
    }

    @Override
    public void addCircleCompleteListener(CircleCompleteListener listener) {
        if (circleCompleteListeners == null) {
            circleCompleteListeners = new ArrayList<>();
            circleCompleteListeners.add(listener);

            circleCompleteHandler = circle -> {
                if (circle == null) {
                    log.warn("Circle complete listener have been fired but no circle received");
                    return;
                }
                CircleCompleteListener.CircleCompleteEvent event =
                        new CircleCompleteListener.CircleCompleteEvent(new CircleDelegate(circle));
                for (CircleCompleteListener l : new ArrayList<>(circleCompleteListeners)) {
                    l.onCircleComplete(event);
                }
            };

            component.addCircleCompleteListener(circleCompleteHandler);
        } else {
            circleCompleteListeners.add(listener);
        }
    }

    @Override
    public void removeCircleCompleteListener(CircleCompleteListener listener) {
        if (circleCompleteListeners != null) {
            circleCompleteListeners.remove(listener);

            if (circleCompleteListeners.isEmpty()) {
                component.removeCircleCompleteListener(circleCompleteHandler);
                circleCompleteHandler = null;
                circleCompleteListeners = null;
            }
        }
    }

    @Override
    public void addMapInitListener(MapInitListener listener) {
        if (mapInitListeners == null) {
            mapInitListeners = new ArrayList<>();
            mapInitListeners.add(listener);
        } else {
            mapInitListeners.add(listener);
        }
    }

    @Override
    public void removeMapInitListener(MapInitListener listener) {
        if (mapInitListeners != null) {
            mapInitListeners.remove(listener);

            if (mapInitListeners.isEmpty()) {
                mapInitListeners = null;
            }
        }
    }

    @Override
    public void setMapType(Type type) {
        component.setMapType(DelegateHelper.toGoogleMapType(type));
    }

    @Override
    public void setMapType(String typeId) {
        component.setMapType(typeId);
    }

    @Override
    public void setMapTypes(List<String> mapTypeIds) {
        component.setMapTypes(mapTypeIds);
    }

    @Override
    public String getMapType() {
        return component.getMapType();
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

    @Override
    public DirectionsRequest createDirectionsRequest() {
        return new DirectionsRequestDelegate(new com.vaadin.tapio.googlemaps.client.services.DirectionsRequest());
    }

    @Override
    public DirectionsRequest createDirectionsRequest(GeoPoint origin, GeoPoint destination, TravelMode travelMode) {
        Preconditions.checkNotNullArgument(origin);
        Preconditions.checkNotNullArgument(destination);

        com.vaadin.tapio.googlemaps.client.services.DirectionsRequest googleDirectionsRequest = new com.vaadin.tapio.googlemaps.client.services.DirectionsRequest(
                ((GeoPointDelegate) origin).getLatLon(),
                ((GeoPointDelegate) destination).getLatLon(),
                travelMode != null ? com.vaadin.tapio.googlemaps.client.services.TravelMode.fromValue(travelMode.value()) : null
        );

        return new DirectionsRequestDelegate(googleDirectionsRequest);
    }

    @Override
    public DirectionsWaypoint createDirectionsWaypoint() {
        return new DirectionsWaypointDelegate(new com.vaadin.tapio.googlemaps.client.services.DirectionsWaypoint());
    }

    @Override
    public DirectionsWaypoint createDirectionsWaypoint(GeoPoint location, boolean stopOver) {
        Preconditions.checkNotNullArgument(location);
        return new DirectionsWaypointDelegate(new com.vaadin.tapio.googlemaps.client.services.DirectionsWaypoint(((GeoPointDelegate)location).getLatLon(), stopOver));
    }

    @Override
    public void route(DirectionsRequest request, final DirectionsRequestCallback callback) {
        component.route(((DirectionsRequestDelegate) request).getRequest(), (result, status) -> {
            com.haulmont.charts.gui.map.model.directions.DirectionsResult cubaResult = result != null
                    ? new DirectionsResultDelegate(result) : null;
            callback.onCallback(cubaResult, com.haulmont.charts.gui.map.model.directions.DirectionsStatus.fromValue(status.value()));
        });
    }

    @Override
    public Size createSize(double width, double height) {
        return new SizeDelegate(new com.vaadin.tapio.googlemaps.client.base.Size(width, height));
    }

    @Override
    public Point createPoint(double x, double y) {
        return new PointDelegate(new com.vaadin.tapio.googlemaps.client.base.Point(x, y));
    }

    @Override
    public MarkerImage createMarkerImage() {
        return new MarkerImageDelegate(new com.vaadin.tapio.googlemaps.client.base.MarkerImage());
    }

    @Override
    public MarkerImage createMarkerImage(String url) {
        return new MarkerImageDelegate(new com.vaadin.tapio.googlemaps.client.base.MarkerImage(url));
    }
}