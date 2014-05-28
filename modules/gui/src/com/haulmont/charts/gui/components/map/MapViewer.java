/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.components.map;

import com.haulmont.charts.gui.map.model.*;
import com.haulmont.cuba.gui.components.Component;

import java.util.Collection;
import java.util.List;
import java.util.Objects;


public interface MapViewer extends Component, Component.BelongToFrame, Component.HasXmlDescriptor {

    enum Type {
        Roadmap("roadmap"),
        Satellite("satellite"),
        Hybrid("hybrid"),
        Terrain("terrain");

        private String id;

        private Type(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public static Type fromId(String id) {
            for (Type type : Type.values()) {
                if (Objects.equals(id, type.id)) {
                    return type;
                }
            }
            return null;
        }
    }

    static class MarkerClickEvent {
        private Marker marker;

        public MarkerClickEvent(Marker marker) {
            this.marker = marker;
        }

        public Marker getMarker() {
            return marker;
        }
    }


    interface MarkerClickListener {
        void onClick(MarkerClickEvent event);
    }

    void addMarkerClickListener(MarkerClickListener listener);
    void removeMarkerClickListener(MarkerClickListener listener);


    static class MarkerDragEvent {
        private Marker marker;
        private GeoPoint oldPosition;

        public MarkerDragEvent(Marker marker, GeoPoint oldPosition) {
            this.marker = marker;
            this.oldPosition = oldPosition;
        }

        public Marker getMarker() {
            return marker;
        }

        public GeoPoint getOldPosition() {
            return oldPosition;
        }
    }

    interface MarkerDragListener {
        void onDrag(MarkerDragEvent event);
    }

    void addMarkerDragListener(MarkerDragListener listener);
    void removeMarkerDragListener(MarkerDragListener listener);


    static class MapMoveEvent {
        private double zoom;
        private GeoPoint center;
        private GeoPoint boundsNE;
        private GeoPoint boundsSW;

        public MapMoveEvent(double zoom, GeoPoint center, GeoPoint boundsNE, GeoPoint boundsSW) {
            this.zoom = zoom;
            this.center = center;
            this.boundsNE = boundsNE;
            this.boundsSW = boundsSW;
        }

        public double getZoom() {
            return zoom;
        }

        public GeoPoint getCenter() {
            return center;
        }

        public GeoPoint getBoundsNE() {
            return boundsNE;
        }

        public GeoPoint getBoundsSW() {
            return boundsSW;
        }
    }

    interface MapMoveListener {
        void onMove(MapMoveEvent event);
    }

    void addMapMoveListener(MapMoveListener listener);
    void removeMapMoveListener(MapMoveListener listener);

    static class InfoWindowCloseEvent {
        private InfoWindow infoWindow;

        public InfoWindowCloseEvent(InfoWindow infoWindow) {
            this.infoWindow = infoWindow;
        }

        public InfoWindow getInfoWindow() {
            return infoWindow;
        }
    }

    interface InfoWindowClosedListener {
        void onClose(InfoWindowCloseEvent event);
    }

    GeoPoint createGeoPoint();
    GeoPoint createGeoPoint(double latitude, double longitude);

    Marker createMarker();
    Marker createMarker(String caption, GeoPoint position, boolean draggable);
    Marker createMarker(String caption, GeoPoint position, boolean draggable, String iconUrl);

    Polygon createPolygon();
    Polygon createPolygon(List<GeoPoint> coordinates);
    Polygon createPolygon(List<GeoPoint> coordinates, String fillColor, double fillOpacity, String strokeColor,
                          double strokeOpacity,int strokeWeight);

    Polyline createPolyline();
    Polyline createPolyline(List<GeoPoint> coordinates);
    Polyline createPolyline(List<GeoPoint> coordinates, String strokeColor, double strokeOpacity, int strokeWeight);

    InfoWindow createInfoWindow();
    InfoWindow createInfoWindow(String content);
    InfoWindow createInfoWindow(String content, Marker anchorMarker);

    void addInfoWindowClosedListener(InfoWindowClosedListener listener);
    void removeInfoWindowClosedListener(InfoWindowClosedListener listener);

    void setZoom(double zoom);
    double getZoom();

    Marker addMarker(String caption, GeoPoint position, boolean draggable, String iconUrl);
    void addMarker(Marker marker);
    void removeMarker(Marker marker);
    void clearMarkers();
    boolean hasMarker(Marker marker);
    Collection<Marker> getMarkers();

    void setSizeFull();
    void setSizeUndefined();

    GeoPoint getCenter();
    void setCenter(GeoPoint center);

    void addPolyline(Polyline polyline);
    void removePolyline(Polyline polyline);

    void setVisibleAreaBoundLimitsEnabled(boolean enabled);
    void fitToBounds(GeoPoint boundsNE, GeoPoint boundsSW);
    boolean isVisibleAreaBoundLimitsEnabled();
    void setVisibleAreaBoundLimits(GeoPoint limitNE, GeoPoint limitSW);

    void setMaxZoom(double maxZoom);
    double getMaxZoom();

    void setMinZoom(double minZoom);
    double getMinZoom();

    boolean isDraggable();
    void setDraggable(boolean draggable);

    boolean areKeyboardShortcutsEnabled();

    void setKeyboardShortcutsEnabled(boolean enabled);

    boolean isScrollWheelEnabled();
    void setScrollWheelEnabled(boolean enabled);

    boolean isCenterBoundLimitsEnabled();
    void setCenterBoundLimitsEnabled(boolean enable);
    void setCenterBoundLimits(GeoPoint limitNE, GeoPoint limitSW);

    void addPolygonOverlay(Polygon polygon);
    void removePolygonOverlay(Polygon polygon);

    void setMapType(Type type);
    Type getMapType();

    void openInfoWindow(InfoWindow infoWindow);
    void closeInfoWindow(InfoWindow infoWindow);

    boolean isInfoWindowOpen(InfoWindow infoWindow);

//TODO korotkov: controls
//    Set<MapControl> getControls();
//    void setControls(Set<MapControl> controls);
//    void addControl(MapControl control);
//    void removeControl(MapControl control);
}
