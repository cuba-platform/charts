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

    String NAME = "mapviewer";

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

    interface MarkerClickListener {
        void markerClicked(Marker marker);
    }

    void addMarkerClickListener(MarkerClickListener listener);
    void removeMarkerClickListener(MarkerClickListener listener);

    interface MarkerDragListener {
        void markerDragged(Marker marker, GeoPoint oldPosition);
    }

    void addMarkerDragListener(MarkerDragListener listener);
    void removeMarkerDragListener(MarkerDragListener listener);


    interface MapMoveListener {
        void mapMoved(double zoomLevel, GeoPoint center, GeoPoint boundsNE, GeoPoint boundsSW);
    }

    void addMapMoveListener(MapMoveListener listener);
    void removeMapMoveListener(MapMoveListener listener);

    interface InfoWindowClosedListener {
        void infoWindowClosed(InfoWindow window);
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
