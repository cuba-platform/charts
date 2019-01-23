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

import com.haulmont.bali.events.Subscription;
import com.haulmont.bali.util.Preconditions;
import com.haulmont.charts.core.global.MapConfig;
import com.haulmont.charts.gui.components.map.GoogleMapViewer;
import com.haulmont.charts.gui.components.map.MapViewer;
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
import com.haulmont.charts.gui.map.model.maptype.ImageMapType;
import com.haulmont.charts.web.gui.components.map.google.base.MarkerImageDelegate;
import com.haulmont.charts.web.gui.components.map.google.base.PointDelegate;
import com.haulmont.charts.web.gui.components.map.google.base.SizeDelegate;
import com.haulmont.charts.web.gui.components.map.google.directions.DirectionsRequestDelegate;
import com.haulmont.charts.web.gui.components.map.google.directions.DirectionsResultDelegate;
import com.haulmont.charts.web.gui.components.map.google.directions.DirectionsWaypointDelegate;
import com.haulmont.charts.web.gui.components.map.google.layer.HeatMapLayerDelegate;
import com.haulmont.charts.web.gui.components.map.google.maptype.ImageMapTypeDelegate;
import com.haulmont.charts.web.widgets.addons.googlemap.GoogleMap;
import com.haulmont.charts.web.widgets.client.addons.googlemap.base.LatLon;
import com.haulmont.charts.web.widgets.client.addons.googlemap.events.PolygonEditListener;
import com.haulmont.charts.web.widgets.client.addons.googlemap.layers.GoogleMapHeatMapLayer;
import com.haulmont.charts.web.widgets.client.addons.googlemap.overlays.*;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Configuration;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.web.gui.components.WebAbstractComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public class WebGoogleMapViewer extends WebAbstractComponent<GoogleMap> implements MapViewer, GoogleMapViewer {

    private final Logger log = LoggerFactory.getLogger(WebGoogleMapViewer.class);

    protected MapConfig mapConfig = AppBeans.get(Configuration.class).getConfig(MapConfig.class);

    protected com.haulmont.charts.web.widgets.client.addons.googlemap.events.MapMoveListener mapMoveHandler;
    protected com.haulmont.charts.web.widgets.client.addons.googlemap.events.click.MapClickListener mapClickHandler;
    protected com.haulmont.charts.web.widgets.client.addons.googlemap.events.rightclick.MapRightClickListener mapRightClickHandler;
    protected com.haulmont.charts.web.widgets.client.addons.googlemap.events.MapInitListener mapInitHandler;

    protected com.haulmont.charts.web.widgets.client.addons.googlemap.events.MarkerDragListener markerDragHandler;
    protected com.haulmont.charts.web.widgets.client.addons.googlemap.events.click.MarkerClickListener markerClickHandler;
    protected com.haulmont.charts.web.widgets.client.addons.googlemap.events.doubleclick.MarkerDoubleClickListener markerDoubleClickHandler;
    protected com.haulmont.charts.web.widgets.client.addons.googlemap.events.rightclick.MarkerRightClickListener markerRightClickHandler;

    protected com.haulmont.charts.web.widgets.client.addons.googlemap.events.InfoWindowClosedListener infoWindowClosedHandler;

    protected com.haulmont.charts.web.widgets.client.addons.googlemap.events.overlaycomplete.PolygonCompleteListener polygonCompleteHandler;
    protected com.haulmont.charts.web.widgets.client.addons.googlemap.events.PolygonEditListener polygonEditHandler;
    protected com.haulmont.charts.web.widgets.client.addons.googlemap.events.click.PolygonClickListener polygonClickHandler;
    protected com.haulmont.charts.web.widgets.client.addons.googlemap.events.rightclick.PolygonRightClickListener polygonRightClickHandler;

    protected com.haulmont.charts.web.widgets.client.addons.googlemap.events.click.CircleClickListener circleClickHandler;
    protected com.haulmont.charts.web.widgets.client.addons.googlemap.events.doubleclick.CircleDoubleClickListener circleDoubleClickHandler;
    protected com.haulmont.charts.web.widgets.client.addons.googlemap.events.radiuschange.CircleRadiusChangeListener circleRadiusChangeHandler;
    protected com.haulmont.charts.web.widgets.client.addons.googlemap.events.centerchange.CircleCenterChangeListener circleCenterChangeHandler;
    protected com.haulmont.charts.web.widgets.client.addons.googlemap.events.overlaycomplete.CircleCompleteListener circleCompleteHandler;
    protected com.haulmont.charts.web.widgets.client.addons.googlemap.events.rightclick.CircleRightClickListener circleRightClickHandler;

    public WebGoogleMapViewer() {
        String clientId = mapConfig.getClientId();
        String key = mapConfig.getApiKey();
        String lang = mapConfig.getLanguage();

        mapInitHandler = this::onMapInit;

        component = new GoogleMap(new LatLon(mapConfig.getDefLatitude(), mapConfig.getDefLongitude()),
                mapConfig.getDefZoom().intValue(), key, clientId, lang, mapInitHandler, mapConfig.getMapsApiVersion());

        String deleteMessage = AppBeans.get(Messages.class).getMainMessage("actions.Remove");
        component.setRemoveMessage(deleteMessage);
    }

    protected void onMapInit(LatLon center, int zoom, LatLon boundsNE, LatLon boundsSW) {
        GeoPointDelegate geoPointCenter = center != null ? new GeoPointDelegate(center) : null;
        GeoPointDelegate geoPointBoundNE = boundsNE != null ? new GeoPointDelegate(boundsNE) : null;
        GeoPointDelegate geoPointBoundSW = boundsSW != null ? new GeoPointDelegate(boundsSW) : null;

        MapInitEvent event = new MapInitEvent(this, geoPointCenter, zoom, geoPointBoundNE, geoPointBoundSW);
        publish(MapInitEvent.class, event);
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
        return new MarkerDelegate(component.addMarker(caption, ((GeoPointDelegate) position).getLatLon(), draggable, iconUrl));
    }

    @Override
    public void addMarker(Marker marker) {
        component.addMarker(((MarkerDelegate) marker).getMarker());
    }

    @Override
    public void removeMarker(Marker marker) {
        component.removeMarker(((MarkerDelegate) marker).getMarker());
    }

    @Override
    public void clearMarkers() {
        component.clearMarkers();
    }

    @Override
    public boolean hasMarker(Marker marker) {
        return component.hasMarker(((MarkerDelegate) marker).getMarker());
    }

    @Override
    public Collection<Marker> getMarkers() {
        Collection<GoogleMapMarker> googleMarkers = component.getMarkers();
        Collection<Marker> markers = new ArrayList<>(googleMarkers.size() * 2);
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
        component.setCenter(((GeoPointDelegate) center).getLatLon());
    }

    @Override
    public void removePolyline(Polyline polyline) {
        component.removePolyline(((PolylineDelegate) polyline).getPolyline());
    }

    @Override
    public void addPolyline(Polyline polyline) {
        component.addPolyline(((PolylineDelegate) polyline).getPolyline());
    }

    @Override
    public void setCenterBoundLimits(GeoPoint limitNE, GeoPoint limitSW) {
        component.setCenterBoundLimits(((GeoPointDelegate) limitNE).getLatLon(),
                ((GeoPointDelegate) limitSW).getLatLon());
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
        component.setVisibleAreaBoundLimits(((GeoPointDelegate) limitNE).getLatLon(),
                ((GeoPointDelegate) limitSW).getLatLon());
    }

    @Override
    public boolean isVisibleAreaBoundLimitsEnabled() {
        return component.isVisibleAreaBoundLimitsEnabled();
    }

    @Override
    public void fitToBounds(GeoPoint boundsNE, GeoPoint boundsSW) {
        component.fitToBounds(((GeoPointDelegate) boundsNE).getLatLon(), ((GeoPointDelegate) boundsSW).getLatLon());
    }

    @Override
    public void setVisibleAreaBoundLimitsEnabled(boolean enabled) {
        component.setVisibleAreaBoundLimitsEnabled(enabled);
    }

    @Override
    public void removePolygonOverlay(Polygon polygon) {
        component.removePolygonOverlay(((PolygonDelegate) polygon).getPolygon());
    }

    @Override
    public void addPolygonOverlay(Polygon polygon) {
        component.addPolygonOverlay(((PolygonDelegate) polygon).getPolygon());
    }

    @Override
    public void addCircleOverlay(Circle circle) {
        component.addCircleOverlay(((CircleDelegate) circle).getCircle());
    }

    @Override
    public void removeCircleOverlay(Circle circle) {
        component.removeCircleOverlay(((CircleDelegate) circle).getCircle());
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
        return new MarkerDelegate(new GoogleMapMarker(caption, ((GeoPointDelegate) position).getLatLon(), draggable));
    }

    @Override
    public Marker createMarker(String caption, GeoPoint position, boolean draggable, String iconUrl) {
        return new MarkerDelegate(new GoogleMapMarker(caption,
                position != null ? ((GeoPointDelegate) position).getLatLon() : null,
                draggable,
                iconUrl));
    }

    @Override
    public Marker createMarker(String caption, GeoPoint position, boolean draggable, MarkerImage icon) {
        return new MarkerDelegate(new GoogleMapMarker(
                caption,
                position != null ? ((GeoPointDelegate) position).getLatLon() : null,
                draggable,
                icon != null ? ((MarkerImageDelegate) icon).getMarkerImage() : null));
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
        return new CircleDelegate(new GoogleMapCircle(((GeoPointDelegate) center).getLatLon(), radius));
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
        return new InfoWindowDelegate(new GoogleMapInfoWindow(content, ((MarkerDelegate) anchorMarker).getMarker()));
    }

    @Override
    public void removeHeatMapLayer(HeatMapLayer layer) {
        component.removeHeatMapLayer(((HeatMapLayerDelegate) layer).getLayer());
    }

    @Override
    public void addHeatMapLayer(HeatMapLayer layer) {
        component.addHeatMapLayer(((HeatMapLayerDelegate) layer).getLayer());
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
        component.addImageMapType(((ImageMapTypeDelegate) imageMapType).getMapType());
    }

    @Override
    public void removeImageMapType(ImageMapType imageMapType) {
        Preconditions.checkNotNullArgument(imageMapType);
        component.removeImageMapType(((ImageMapTypeDelegate) imageMapType).getMapType());
    }

    @Override
    public void addOverlayImageMapType(ImageMapType imageMapType) {
        component.addOverlayImageMapType(((ImageMapTypeDelegate) imageMapType).getMapType());
    }

    @Override
    public void removeOverlayImageMapType(ImageMapType imageMapType) {
        Preconditions.checkNotNullArgument(imageMapType);
        component.removeOverlayImageMapType(((ImageMapTypeDelegate) imageMapType).getMapType());
    }

    @Override
    public Subscription addMapMoveListener(Consumer<MapMoveEvent> listener) {
        if (mapMoveHandler == null) {
            mapMoveHandler = this::onMapMove;
            component.addMapMoveListener(mapMoveHandler);
        }
        return getEventHub().subscribe(MapMoveEvent.class, listener);
    }

    protected void onMapMove(int zoomLevel, LatLon center, LatLon boundsNE, LatLon boundsSW) {
        GeoPointDelegate geoPointCenter = center != null ? new GeoPointDelegate(center) : null;
        GeoPointDelegate geoPointBoundNE = boundsNE != null ? new GeoPointDelegate(boundsNE) : null;
        GeoPointDelegate geoPointBoundSW = boundsSW != null ? new GeoPointDelegate(boundsSW) : null;
        MapMoveEvent event = new MapMoveEvent(this, zoomLevel, geoPointCenter, geoPointBoundNE, geoPointBoundSW);

        publish(MapMoveEvent.class, event);
    }

    @Override
    public void removeMapMoveListener(Consumer<MapMoveEvent> listener) {
        unsubscribe(MapMoveEvent.class, listener);
        if (mapMoveHandler != null && !hasSubscriptions(MapMoveEvent.class)) {
            component.removeMapMoveListener(mapMoveHandler);
            mapMoveHandler = null;
        }
    }

    @Override
    public Subscription addMapClickListener(Consumer<MapClickEvent> listener) {
        if (mapClickHandler == null) {
            mapClickHandler = this::onMapClick;
            component.addMapClickListener(mapClickHandler);
        }
        return getEventHub().subscribe(MapClickEvent.class, listener);
    }

    protected void onMapClick(LatLon position) {
        GeoPointDelegate geoPoint = position != null ? new GeoPointDelegate(position) : null;

        publish(MapClickEvent.class, new MapClickEvent(this, geoPoint));
    }

    @Override
    public void removeMapClickListener(Consumer<MapClickEvent> listener) {
        unsubscribe(MapClickEvent.class, listener);
        if (mapClickHandler != null && !hasSubscriptions(MapClickEvent.class)) {
            component.removeMapClickListener(mapClickHandler);
            mapClickHandler = null;
        }
    }

    @Override
    public void removePolygonClickListener(Consumer<PolygonClickEvent> listener) {
        unsubscribe(PolygonClickEvent.class, listener);
        if (polygonClickHandler != null && !hasSubscriptions(PolygonClickEvent.class)) {
            component.removePolygonClickListener(polygonClickHandler);
            polygonClickHandler = null;
        }
    }

    @Override
    public Subscription addPolygonClickListener(Consumer<PolygonClickEvent> listener) {
        if (polygonClickHandler == null) {
            polygonClickHandler = this::onPolygonClick;
            component.addPolygonClickListener(polygonClickHandler);
        }
        return getEventHub().subscribe(PolygonClickEvent.class, listener);
    }

    protected void onPolygonClick(GoogleMapPolygon polygon) {
        if (polygon == null) {
            log.warn("Polygon clicked listener have been fired but no polygon received");
            return;
        }
        publish(PolygonClickEvent.class, new PolygonClickEvent(this, new PolygonDelegate(polygon)));
    }

    @Override
    public Subscription addMarkerDragListener(Consumer<MarkerDragEvent> listener) {
        if (markerDragHandler == null) {
            markerDragHandler = this::onMarkerDrag;
            component.addMarkerDragListener(markerDragHandler);
        }
        return getEventHub().subscribe(MarkerDragEvent.class, listener);
    }

    protected void onMarkerDrag(GoogleMapMarker marker, LatLon oldPosition) {
        if (marker == null) {
            log.warn("Marker dragged listener have been fired but no marker received");
            return;
        }
        GeoPointDelegate geoPoint = oldPosition != null ? new GeoPointDelegate(oldPosition) : null;
        MarkerDragEvent event = new MarkerDragEvent(this, new MarkerDelegate(marker), geoPoint);

        publish(MarkerDragEvent.class, event);
    }

    @Override
    public void removeMarkerDragListener(Consumer<MarkerDragEvent> listener) {
        unsubscribe(MarkerDragEvent.class, listener);
        if (markerDragHandler != null && !hasSubscriptions(MarkerDragEvent.class)) {
            component.removeMarkerDragListener(markerDragHandler);
            markerDragHandler = null;
        }
    }

    @Override
    public Subscription addMarkerClickListener(Consumer<MarkerClickEvent> listener) {
        if (markerClickHandler == null) {
            markerClickHandler = this::onMarkerClick;
            component.addMarkerClickListener(markerClickHandler);
        }
        return getEventHub().subscribe(MarkerClickEvent.class, listener);
    }

    protected void onMarkerClick(GoogleMapMarker marker) {
        if (marker == null) {
            log.warn("Marker clicked listener have been fired but no marker received");
            return;
        }
        publish(MarkerClickEvent.class, new MarkerClickEvent(this, new MarkerDelegate(marker)));
    }

    @Override
    public void removeMarkerClickListener(Consumer<MarkerClickEvent> listener) {
        unsubscribe(MarkerClickEvent.class, listener);
        if (markerClickHandler != null && !hasSubscriptions(MarkerClickEvent.class)) {
            component.removeMarkerClickListener(markerClickHandler);
            markerClickHandler = null;
        }
    }

    @Override
    public Subscription addMarkerDoubleClickListener(Consumer<MarkerDoubleClickEvent> listener) {
        if (markerDoubleClickHandler == null) {
            markerDoubleClickHandler = this::onMarkerDoubleClick;
            component.addMarkerDoubleClickListener(markerDoubleClickHandler);
        }
        return getEventHub().subscribe(MarkerDoubleClickEvent.class, listener);
    }

    protected void onMarkerDoubleClick(GoogleMapMarker marker) {
        if (marker == null) {
            log.warn("Marker double clicked listener have been fired but no marker received");
            return;
        }
        MarkerDoubleClickEvent event = new MarkerDoubleClickEvent(this, new MarkerDelegate(marker));
        publish(MarkerDoubleClickEvent.class, event);
    }

    @Override
    public void removeMarkerDoubleClickListener(Consumer<MarkerDoubleClickEvent> listener) {
        unsubscribe(MarkerDoubleClickEvent.class, listener);
        if (markerDoubleClickHandler != null && !hasSubscriptions(MarkerDoubleClickEvent.class)) {
            component.removeMarkerDoubleClickListener(markerDoubleClickHandler);
            markerDoubleClickHandler = null;
        }
    }

    @Override
    public Subscription addInfoWindowClosedListener(Consumer<InfoWindowCloseEvent> listener) {
        if (infoWindowClosedHandler == null) {
            infoWindowClosedHandler = this::onInfoWindowClose;
            component.addInfoWindowClosedListener(infoWindowClosedHandler);
        }
        return getEventHub().subscribe(InfoWindowCloseEvent.class, listener);
    }

    protected void onInfoWindowClose(GoogleMapInfoWindow infoWindow) {
        if (infoWindow == null) {
            log.warn("InfoWindow close listener have been fired but no info window received");
            return;
        }
        InfoWindowCloseEvent event = new InfoWindowCloseEvent(this, new InfoWindowDelegate(infoWindow));
        publish(InfoWindowCloseEvent.class, event);
    }

    @Override
    public void removeInfoWindowClosedListener(Consumer<InfoWindowCloseEvent> listener) {
        unsubscribe(InfoWindowCloseEvent.class, listener);
        if (infoWindowClosedHandler != null && !hasSubscriptions(InfoWindowCloseEvent.class)) {
            component.removeInfoWindowClosedListener(infoWindowClosedHandler);
            infoWindowClosedHandler = null;
        }
    }

    @Override
    public Subscription addPolygonCompleteListener(Consumer<PolygonCompleteEvent> listener) {
        if (polygonCompleteHandler == null) {
            polygonCompleteHandler = this::onPolygonComplete;
            component.addPolygonCompleteListener(polygonCompleteHandler);
        }
        return getEventHub().subscribe(PolygonCompleteEvent.class, listener);
    }

    protected void onPolygonComplete(GoogleMapPolygon polygon) {
        if (polygon == null) {
            log.warn("Polygon complete listener have been fired but no polygon received");
            return;
        }
        PolygonCompleteEvent event = new PolygonCompleteEvent(this, new PolygonDelegate(polygon));
        publish(PolygonCompleteEvent.class, event);
    }

    @Override
    public void removePolygonCompleteListener(Consumer<PolygonCompleteEvent> listener) {
        unsubscribe(PolygonCompleteEvent.class, listener);
        if (polygonCompleteHandler != null && !hasSubscriptions(PolygonCompleteEvent.class)) {
            component.removePolygonCompleteListener(polygonCompleteHandler);
            polygonCompleteHandler = null;
        }
    }

    @Override
    public Subscription addPolygonEditListener(Consumer<PolygonEditEvent> listener) {
        if (polygonEditHandler == null) {
            polygonEditHandler = this::onPolygonEdit;
            component.addPolygonEditListener(polygonEditHandler);
        }
        return getEventHub().subscribe(PolygonEditEvent.class, listener);
    }

    protected void onPolygonEdit(GoogleMapPolygon polygon, PolygonEditListener.ActionType actionType, int idx, LatLon latLon) {
        if (polygon == null) {
            log.warn("Polygon edited listener have been fired but no polygon received");
            return;
        }
        GeoPointDelegate geoPoint = latLon != null ? new GeoPointDelegate(latLon) : null;
        PolygonEditEvent event = new PolygonEditEvent(this, new PolygonDelegate(polygon),
                toCubaActionType(actionType), idx, geoPoint);

        publish(PolygonEditEvent.class, event);
    }

    private PolygonEditEvent.ActionType toCubaActionType(
            com.haulmont.charts.web.widgets.client.addons.googlemap.events.PolygonEditListener.ActionType actionType) {
        if (actionType == null) {
            return null;
        }

        switch (actionType) {
            case INSERT:
                return PolygonEditEvent.ActionType.INSERT;
            case REMOVE:
                return PolygonEditEvent.ActionType.REMOVE;
            case SET:
                return PolygonEditEvent.ActionType.SET;
        }

        throw new IllegalArgumentException("Unknown edit action type: " + actionType);
    }

    @Override
    public void removePolygonEditListener(Consumer<PolygonEditEvent> listener) {
        unsubscribe(PolygonEditEvent.class, listener);
        if (polygonEditHandler != null && !hasSubscriptions(PolygonEditEvent.class)) {
            component.removePolygonEditListener(polygonEditHandler);
            polygonEditHandler = null;
        }
    }

    @Override
    public Subscription addCircleClickListener(Consumer<CircleClickEvent> listener) {
        if (circleClickHandler == null) {
            circleClickHandler = this::onCircleClick;
            component.addCircleClickListener(circleClickHandler);
        }
        return getEventHub().subscribe(CircleClickEvent.class, listener);
    }

    protected void onCircleClick(GoogleMapCircle circle) {
        if (circle == null) {
            log.warn("Circle clicked listener have been fired but no circle received");
            return;
        }
        CircleClickEvent event = new CircleClickEvent(this, new CircleDelegate(circle));
        publish(CircleClickEvent.class, event);
    }

    @Override
    public void removeCircleClickListener(Consumer<CircleClickEvent> listener) {
        unsubscribe(CircleClickEvent.class, listener);
        if (circleClickHandler != null && !hasSubscriptions(CircleClickEvent.class)) {
            component.removeCircleClickListener(circleClickHandler);
            circleClickHandler = null;
        }
    }

    @Override
    public Subscription addCircleDoubleClickListener(Consumer<CircleDoubleClickEvent> listener) {
        if (circleDoubleClickHandler == null) {
            circleDoubleClickHandler = this::onCircleDoubleClick;
            component.addCircleDoubleClickListener(circleDoubleClickHandler);
        }
        return getEventHub().subscribe(CircleDoubleClickEvent.class, listener);
    }

    protected void onCircleDoubleClick(GoogleMapCircle circle) {
        if (circle == null) {
            log.warn("Circle double clicked listener have been fired but no circle received");
            return;
        }
        CircleDoubleClickEvent event = new CircleDoubleClickEvent(this, new CircleDelegate(circle));
        publish(CircleDoubleClickEvent.class, event);
    }

    @Override
    public void removeCircleDoubleClickListener(Consumer<CircleDoubleClickEvent> listener) {
        unsubscribe(CircleDoubleClickEvent.class, listener);
        if (circleDoubleClickHandler != null && !hasSubscriptions(CircleDoubleClickEvent.class)) {
            component.removeCircleDoubleClickListener(circleDoubleClickHandler);
            circleDoubleClickHandler = null;
        }
    }

    @Override
    public Subscription addCircleRadiusChangeListener(Consumer<CircleRadiusChangeEvent> listener) {
        if (circleRadiusChangeHandler == null) {
            circleRadiusChangeHandler = this::onCircleRadiusChange;
            component.addCircleRadiusChangeListener(circleRadiusChangeHandler);
        }
        return getEventHub().subscribe(CircleRadiusChangeEvent.class, listener);
    }

    protected void onCircleRadiusChange(GoogleMapCircle circle, double oldRadius) {
        if (circle == null) {
            log.warn("Circle radius changed listener have been fired but no circle received");
            return;
        }
        CircleRadiusChangeEvent event =
                new CircleRadiusChangeEvent(this, new CircleDelegate(circle), oldRadius);
        publish(CircleRadiusChangeEvent.class, event);
    }

    @Override
    public void removeCircleRadiusChangeListener(Consumer<CircleRadiusChangeEvent> listener) {
        unsubscribe(CircleRadiusChangeEvent.class, listener);
        if (circleRadiusChangeHandler != null && !hasSubscriptions(CircleRadiusChangeEvent.class)) {
            component.removeCircleRadiusChangeListener(circleRadiusChangeHandler);
            circleRadiusChangeHandler = null;
        }
    }

    @Override
    public Subscription addCircleCenterChangeListener(Consumer<CircleCenterChangeEvent> listener) {
        if (circleCenterChangeHandler == null) {
            circleCenterChangeHandler = this::onCircleCenterChange;
            component.addCircleCenterChangeListener(circleCenterChangeHandler);
        }
        return getEventHub().subscribe(CircleCenterChangeEvent.class, listener);
    }

    protected void onCircleCenterChange(GoogleMapCircle circle, LatLon oldCenter) {
        if (circle == null) {
            log.warn("Circle center changed listener have been fired but no circle received");
            return;
        }
        if (oldCenter == null) {
            log.warn("Circle center changed listener have been fired but old center point is null");
            return;
        }
        CircleCenterChangeEvent event = new CircleCenterChangeEvent(this,
                new CircleDelegate(circle), new GeoPointDelegate(oldCenter));
        publish(CircleCenterChangeEvent.class, event);
    }

    @Override
    public void removeCircleCenterChangeListener(Consumer<CircleCenterChangeEvent> listener) {
        unsubscribe(CircleCenterChangeEvent.class, listener);
        if (circleCenterChangeHandler != null && !hasSubscriptions(CircleCenterChangeEvent.class)) {
            component.removeCircleCenterChangeListener(circleCenterChangeHandler);
            circleCenterChangeHandler = null;
        }
    }

    @Override
    public Subscription addCircleCompleteListener(Consumer<CircleCompleteEvent> listener) {
        if (circleCompleteHandler == null) {
            circleCompleteHandler = this::onCircleComplete;
            component.addCircleCompleteListener(circleCompleteHandler);
        }
        return getEventHub().subscribe(CircleCompleteEvent.class, listener);
    }

    protected void onCircleComplete(GoogleMapCircle circle) {
        if (circle == null) {
            log.warn("Circle complete listener have been fired but no circle received");
            return;
        }
        CircleCompleteEvent event = new CircleCompleteEvent(this, new CircleDelegate(circle));
        publish(CircleCompleteEvent.class, event);
    }

    @Override
    public void removeCircleCompleteListener(Consumer<CircleCompleteEvent> listener) {
        unsubscribe(CircleCompleteEvent.class, listener);
        if (circleCompleteHandler != null && !hasSubscriptions(CircleCompleteEvent.class)) {
            component.removeCircleCompleteListener(circleCompleteHandler);
            circleCompleteHandler = null;
        }
    }

    @Override
    public Subscription addMapInitListener(Consumer<MapInitEvent> listener) {
        return getEventHub().subscribe(MapInitEvent.class, listener);
    }

    @Override
    public void removeMapInitListener(Consumer<MapInitEvent> listener) {
        unsubscribe(MapInitEvent.class, listener);
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
        return component.isInfoWindowOpen(((InfoWindowDelegate) infoWindow).getInfoWindow());
    }

    @Override
    public void setDrawingOptions(DrawingOptions drawingOptions) {
        component.setDrawingOptions(DelegateHelper.toGoogleDrawingOptions(drawingOptions));
    }

    @Override
    public void closeInfoWindow(InfoWindow infoWindow) {
        component.closeInfoWindow(((InfoWindowDelegate) infoWindow).getInfoWindow());
    }

    @Override
    public void openInfoWindow(InfoWindow infoWindow) {
        component.openInfoWindow(((InfoWindowDelegate) infoWindow).getInfoWindow());
    }

    @Override
    public DirectionsRequest createDirectionsRequest() {
        return new DirectionsRequestDelegate(new com.haulmont.charts.web.widgets.client.addons.googlemap.services.DirectionsRequest());
    }

    @Override
    public DirectionsRequest createDirectionsRequest(GeoPoint origin, GeoPoint destination, TravelMode travelMode) {
        Preconditions.checkNotNullArgument(origin);
        Preconditions.checkNotNullArgument(destination);

        com.haulmont.charts.web.widgets.client.addons.googlemap.services.DirectionsRequest googleDirectionsRequest
                = new com.haulmont.charts.web.widgets.client.addons.googlemap.services.DirectionsRequest(
                ((GeoPointDelegate) origin).getLatLon(),
                ((GeoPointDelegate) destination).getLatLon(),
                travelMode != null ? com.haulmont.charts.web.widgets.client.addons.googlemap.services.TravelMode.fromValue(travelMode.value()) : null
        );

        return new DirectionsRequestDelegate(googleDirectionsRequest);
    }

    @Override
    public DirectionsWaypoint createDirectionsWaypoint() {
        return new DirectionsWaypointDelegate(new com.haulmont.charts.web.widgets.client.addons.googlemap.services.DirectionsWaypoint());
    }

    @Override
    public DirectionsWaypoint createDirectionsWaypoint(GeoPoint location, boolean stopOver) {
        Preconditions.checkNotNullArgument(location);
        return new DirectionsWaypointDelegate(new com.haulmont.charts.web.widgets.client.addons.googlemap.services.DirectionsWaypoint(((GeoPointDelegate) location).getLatLon(), stopOver));
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
        return new SizeDelegate(new com.haulmont.charts.web.widgets.client.addons.googlemap.base.Size(width, height));
    }

    @Override
    public Point createPoint(double x, double y) {
        return new PointDelegate(new com.haulmont.charts.web.widgets.client.addons.googlemap.base.Point(x, y));
    }

    @Override
    public MarkerImage createMarkerImage() {
        return new MarkerImageDelegate(new com.haulmont.charts.web.widgets.client.addons.googlemap.base.MarkerImage());
    }

    @Override
    public MarkerImage createMarkerImage(String url) {
        return new MarkerImageDelegate(new com.haulmont.charts.web.widgets.client.addons.googlemap.base.MarkerImage(url));
    }

    @Override
    public Subscription addMarkerRightClickListener(Consumer<MarkerRightClickEvent> listener) {
        if (markerRightClickHandler == null) {
            markerRightClickHandler = this::onMarkerRightClick;
            component.addMarkerRightClickListener(markerRightClickHandler);
        }
        return getEventHub().subscribe(MarkerRightClickEvent.class, listener);
    }

    protected void onMarkerRightClick(GoogleMapMarker marker) {
        if (marker == null) {
            log.warn("Marker right clicked listener have been fired but no marker received");
            return;
        }

        MarkerRightClickEvent event = new MarkerRightClickEvent(this, new MarkerDelegate(marker));
        publish(MarkerRightClickEvent.class, event);
    }

    @Override
    public void removeMarkerRightClickListener(Consumer<MarkerRightClickEvent> listener) {
        unsubscribe(MarkerRightClickEvent.class, listener);
        if (markerRightClickHandler != null && !hasSubscriptions(MarkerRightClickEvent.class)) {
            component.removeMarkerRightClickListener(markerRightClickHandler);
            markerRightClickHandler = null;
        }
    }

    @Override
    public Subscription addMapRightClickListener(Consumer<MapRightClickEvent> listener) {
        if (mapRightClickHandler == null) {
            mapRightClickHandler = this::onMapRightClick;
            component.addMapRightClickListener(mapRightClickHandler);
        }
        return getEventHub().subscribe(MapRightClickEvent.class, listener);
    }

    protected void onMapRightClick(LatLon position) {
        GeoPointDelegate geoPoint = position != null ? new GeoPointDelegate(position) : null;
        MapRightClickEvent event = new MapRightClickEvent(this, geoPoint);

        publish(MapRightClickEvent.class, event);
    }

    @Override
    public void removeMapRightClickListener(Consumer<MapRightClickEvent> listener) {
        unsubscribe(MapRightClickEvent.class, listener);
        if (markerRightClickHandler != null && !hasSubscriptions(MapRightClickEvent.class)) {
            component.removeMapRightClickListener(mapRightClickHandler);
            markerRightClickHandler = null;
        }
    }

    @Override
    public Subscription addPolygonRightClickListener(Consumer<PolygonRightClickEvent> listener) {
        if (polygonRightClickHandler == null) {
            polygonRightClickHandler = this::onPolygonRightClick;
            component.addPolygonRightClickListener(polygonRightClickHandler);
        }
        return getEventHub().subscribe(PolygonRightClickEvent.class, listener);
    }

    protected void onPolygonRightClick(GoogleMapPolygon polygon) {
        if (polygon == null) {
            log.warn("Polygon right clicked listener have been fired but no polygon received");
            return;
        }

        PolygonRightClickEvent event = new PolygonRightClickEvent(this, new PolygonDelegate(polygon));
        publish(PolygonRightClickEvent.class, event);
    }

    @Override
    public void removePolygonRightClickListener(Consumer<PolygonRightClickEvent> listener) {
        unsubscribe(PolygonRightClickEvent.class, listener);
        if (polygonRightClickHandler != null && !hasSubscriptions(PolygonRightClickEvent.class)) {
            component.removePolygonRightClickListener(polygonRightClickHandler);
            polygonRightClickHandler = null;
        }
    }

    @Override
    public Subscription addCircleRightClickListener(Consumer<CircleRightClickEvent> listener) {
        if (circleRightClickHandler == null) {
            circleRightClickHandler = this::onCircleRightClick;
            component.addCircleRightClickListener(circleRightClickHandler);
        }
        return getEventHub().subscribe(CircleRightClickEvent.class, listener);
    }

    protected void onCircleRightClick(GoogleMapCircle circle) {
        if (circle == null) {
            log.warn("Circle right clicked listener have been fired but no circle received");
            return;
        }

        CircleRightClickEvent event = new CircleRightClickEvent(this, new CircleDelegate(circle));
        publish(CircleRightClickEvent.class, event);
    }

    @Override
    public void removeCircleRightClickListener(Consumer<CircleRightClickEvent> listener) {
        unsubscribe(CircleRightClickEvent.class, listener);
        if (circleRightClickHandler != null && !hasSubscriptions(CircleRightClickEvent.class)) {
            component.removeCircleRightClickListener(circleRightClickHandler);
            circleRightClickHandler = null;
        }
    }

    @Override
    public void addLabel(Label label) {
        component.addLabel(((LabelDelegate) label).getLabel());
    }

    @Override
    public void removeLabel(Label label) {
        component.removeLabel(((LabelDelegate) label).getLabel());
    }

    @Override
    public Label createLabel() {
        return new LabelDelegate();
    }

    @Override
    public Label createLabel(String value, GeoPoint position) {
        return createLabel(value, position, Label.ContentType.PLAIN_TEXT);
    }

    @Override
    public Label createLabel(String value, GeoPoint position, Label.ContentType contentType) {
        LabelDelegate labelDelegate = new LabelDelegate();
        labelDelegate.setValue(value);
        labelDelegate.setPosition(position);
        labelDelegate.setContentType(contentType);
        return labelDelegate;
    }

    @Override
    public void removePolygonVertex(Polygon polygon, GeoPoint vertex) {
        Preconditions.checkNotNullArgument(polygon);
        Preconditions.checkNotNullArgument(vertex);

        LatLon latLon = new LatLon(vertex.getLatitude(), vertex.getLongitude());
        GoogleMapPolygon vPolygon = ((PolygonDelegate) polygon).getPolygon();

        component.removePolygonVertex(vPolygon, latLon);
    }

    @Override
    public void setRemoveMessage(String message) {
        component.setRemoveMessage(message);
    }

    @Override
    public String getRemoveMessage() {
        return component.getRemoveMessage();
    }

    @Override
    public void setVertexRemovingEnabled(boolean enabled) {
        component.setVertexRemovingEnabled(enabled);
    }

    @Override
    public boolean isVertexRemovingEnabled() {
        return component.isVertexRemovingEnabled();
    }
}