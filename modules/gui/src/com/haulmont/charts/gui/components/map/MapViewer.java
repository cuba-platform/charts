/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.components.map;

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
import com.haulmont.charts.gui.map.model.listeners.*;
import com.haulmont.charts.gui.map.model.listeners.centerchange.CircleCenterChangeListener;
import com.haulmont.charts.gui.map.model.listeners.click.CircleClickListener;
import com.haulmont.charts.gui.map.model.listeners.click.MapClickListener;
import com.haulmont.charts.gui.map.model.listeners.click.MarkerClickListener;
import com.haulmont.charts.gui.map.model.listeners.doubleclick.CircleDoubleClickListener;
import com.haulmont.charts.gui.map.model.listeners.doubleclick.MarkerDoubleClickListener;
import com.haulmont.charts.gui.map.model.listeners.drag.MarkerDragListener;
import com.haulmont.charts.gui.map.model.listeners.overlaycomplete.CircleCompleteListener;
import com.haulmont.charts.gui.map.model.listeners.overlaycomplete.PolygonCompleteListener;
import com.haulmont.charts.gui.map.model.listeners.radiuschange.CircleRadiusChangeListener;
import com.haulmont.cuba.gui.components.Component;

import java.util.Collection;
import java.util.List;

/**
 * @author korotkov
 * @version $Id$
 */
public interface MapViewer extends Component, Component.BelongToFrame, Component.HasXmlDescriptor {

    /** Tag name for XML loader, for component name see {@link com.haulmont.charts.gui.components.map.GoogleMapViewer#NAME} */
    String TAG_NAME = "mapViewer";

    /**
     * Map types
     */
    enum Type {
        /**
         * Normal street map
         */
        ROADMAP,

        /**
         * Satellite images
         */
        SATELLITE,

        /**
         * Satellite images with transparent layer of major streets
         */
        HYBRID,

        /**
         * Map with physical features such as terrain and vegetation
         */
        TERRAIN
    }

    void addMarkerClickListener(MarkerClickListener listener);
    void removeMarkerClickListener(MarkerClickListener listener);

    void addMarkerDoubleClickListener(MarkerDoubleClickListener listener);
    void removeMarkerDoubleClickListener(MarkerDoubleClickListener listener);

    void addMarkerDragListener(MarkerDragListener listener);
    void removeMarkerDragListener(MarkerDragListener listener);

    void addMapMoveListener(MapMoveListener listener);
    void removeMapMoveListener(MapMoveListener listener);

    void addMapClickListener(MapClickListener listener);
    void removeMapClickListener(MapClickListener listener);

    void addInfoWindowClosedListener(InfoWindowClosedListener listener);
    void removeInfoWindowClosedListener(InfoWindowClosedListener listener);

    void addPolygonCompleteListener(PolygonCompleteListener listener);
    void removePolygonCompleteListener(PolygonCompleteListener listener);

    void addPolygonEditListener(PolygonEditListener listener);
    void removePolygonEditListener(PolygonEditListener listener);

    void addMapInitListener(MapInitListener listener);
    void removeMapInitListener(MapInitListener listener);

    void addCircleClickListener(CircleClickListener listener);
    void removeCircleClickListener(CircleClickListener listener);

    void addCircleDoubleClickListener(CircleDoubleClickListener listener);
    void removeCircleDoubleClickListener(CircleDoubleClickListener listener);

    void addCircleRadiusChangeListener(CircleRadiusChangeListener listener);
    void removeCircleRadiusChangeListener(CircleRadiusChangeListener listener);

    void addCircleCenterChangeListener(CircleCenterChangeListener listener);
    void removeCircleCenterChangeListener(CircleCenterChangeListener listener);

    void addCircleCompleteListener(CircleCompleteListener listener);
    void removeCircleCompleteListener(CircleCompleteListener listener);

    /**
     * Creates geo point with no coordinates
     * @return geo point
     */
    GeoPoint createGeoPoint();

    /**
     * Creates geo point with given coordinates
     * @param latitude latitude
     * @param longitude latitude
     * @return geo point
     */
    GeoPoint createGeoPoint(double latitude, double longitude);

    /**
     * Creates marker with default icon. Add marker on map using {@link com.haulmont.charts.gui.components.map.MapViewer#addMarker(com.haulmont.charts.gui.map.model.Marker)}
     * @return marker
     */
    Marker createMarker();

    /**
     * Creates marker with given params. Add marker on map using {@link com.haulmont.charts.gui.components.map.MapViewer#addMarker(com.haulmont.charts.gui.map.model.Marker)}
     * @param caption caption
     * @param position position
     * @param draggable draggable
     * @return marker
     */
    Marker createMarker(String caption, GeoPoint position, boolean draggable);

    /**
     * Creates marker with given params. Add marker on map using {@link com.haulmont.charts.gui.components.map.MapViewer#addMarker(com.haulmont.charts.gui.map.model.Marker)}
     * @param caption caption
     * @param position position
     * @param draggable draggable
     * @param iconUrl icon url
     * @return marker
     */
    Marker createMarker(String caption, GeoPoint position, boolean draggable, String iconUrl);

    /**
     * Creates marker with given params. Add marker on map using {@link com.haulmont.charts.gui.components.map.MapViewer#addMarker(com.haulmont.charts.gui.map.model.Marker)}
     * @param caption caption
     * @param position position
     * @param draggable draggable
     * @param icon icon
     * @return marker
     */
    Marker createMarker(String caption, GeoPoint position, boolean draggable, MarkerImage icon);

    /**
     * Creates polygon. Add polygon on map using {@link com.haulmont.charts.gui.components.map.MapViewer#addPolygonOverlay(com.haulmont.charts.gui.map.model.Polygon)}
     * @return polygon
     */
    Polygon createPolygon();

    /**
     * Creates polygon with given coordinates for vertices. Add polygon on map using {@link com.haulmont.charts.gui.components.map.MapViewer#addPolygonOverlay(com.haulmont.charts.gui.map.model.Polygon)}
     * @return polygon
     */
    Polygon createPolygon(List<GeoPoint> coordinates);

    /**
     * Creates polygon with given params. Add polygon on map using {@link com.haulmont.charts.gui.components.map.MapViewer#addPolygonOverlay(com.haulmont.charts.gui.map.model.Polygon)}
     * @return polygon
     */
    Polygon createPolygon(List<GeoPoint> coordinates, String fillColor, double fillOpacity, String strokeColor,
                          double strokeOpacity,int strokeWeight);

    /**
     * Creates circle. Add circle on map using {@link com.haulmont.charts.gui.components.map.MapViewer#addCircleOverlay(com.haulmont.charts.gui.map.model.Circle)}
     * @return circle
     */
    Circle createCircle();

    /**
     * Creates circle with given center location and radius (in meters). Add circle on map using {@link com.haulmont.charts.gui.components.map.MapViewer#addCircleOverlay(com.haulmont.charts.gui.map.model.Circle)}
     * @return circle
     */
    Circle createCircle(GeoPoint center, double radius);

    /**
     * Creates polyline. Add polyline on map using {@link com.haulmont.charts.gui.components.map.MapViewer#addPolyline(com.haulmont.charts.gui.map.model.Polyline)}
     * @return polyline
     */
    Polyline createPolyline();

    /**
     * Creates polyline with given coordinates for vertices. Add polyline on map using {@link com.haulmont.charts.gui.components.map.MapViewer#addPolyline(com.haulmont.charts.gui.map.model.Polyline)}
     * @return polyline
     */
    Polyline createPolyline(List<GeoPoint> coordinates);

    /**
     * Creates polyline with given parameters. Add polyline on map using {@link com.haulmont.charts.gui.components.map.MapViewer#addPolyline(com.haulmont.charts.gui.map.model.Polyline)}
     * @return polyline
     */
    Polyline createPolyline(List<GeoPoint> coordinates, String strokeColor, double strokeOpacity, int strokeWeight);

    /**
     * Creates info window. Open info window on map using {@link com.haulmont.charts.gui.components.map.MapViewer#openInfoWindow(com.haulmont.charts.gui.map.model.InfoWindow)}
     * @return info window
     */
    InfoWindow createInfoWindow();

    /**
     * Creates info window with given content. Open info window on map using {@link com.haulmont.charts.gui.components.map.MapViewer#openInfoWindow(com.haulmont.charts.gui.map.model.InfoWindow)}
     * @return info window
     */
    InfoWindow createInfoWindow(String content);

    /**
     * Creates info window with given content and anchor marker. Open info window on map using {@link com.haulmont.charts.gui.components.map.MapViewer#openInfoWindow(com.haulmont.charts.gui.map.model.InfoWindow)}
     * @return info window
     */
    InfoWindow createInfoWindow(String content, Marker anchorMarker);

    /**
     * Creates heatmap layer. Add layer on map using Open info window on map using {@link MapViewer#addHeatMapLayer(com.haulmont.charts.gui.map.model.layer.HeatMapLayer)}
     * @return heatmap layer
     */
    HeatMapLayer createHeatMapLayer();

    /**
     * Creates directions request. Request directions api using {@link MapViewer#route(com.haulmont.charts.gui.map.model.directions.DirectionsRequest, com.haulmont.charts.gui.map.model.directions.DirectionsRequestCallback)}
     * @return request
     */
    DirectionsRequest createDirectionsRequest();

    /**
     * Creates directions request. Request directions api using {@link MapViewer#route(com.haulmont.charts.gui.map.model.directions.DirectionsRequest, com.haulmont.charts.gui.map.model.directions.DirectionsRequestCallback)}
     * @param origin location of origin
     * @param destination location of destination
     * @param travelMode type of routing requested
     * @return directions request
     */
    DirectionsRequest createDirectionsRequest(GeoPoint origin, GeoPoint destination, TravelMode travelMode);


    /**
     * Creates directions waypoint.
     * @return waypoint
     */
    DirectionsWaypoint createDirectionsWaypoint();

    /**
     * Creates directions waypoint.
     * @param location location
     * @param stopOver if true, indicates that this waypoint is a stop between the origin and destination.
     *                 This has the effect of splitting the route into two. This value is true by default.
     * @return waypoint
     */
    DirectionsWaypoint createDirectionsWaypoint(GeoPoint location, boolean stopOver);

    /**
     * Creates marker image object
     * @return marker image
     */
    MarkerImage createMarkerImage();

    /**
     * Creates marker image object
     * @param url icon or sprites file url
     * @return marker image
     */
    MarkerImage createMarkerImage(String url);

    /**
     * Creates size object
     * @param width width
     * @param height height
     * @return size
     */
    Size createSize(double width, double height);

    /**
     * Creates point object
     * @param x X coordinate
     * @param y Y coordinate
     * @return point
     */
    Point createPoint(double x, double y);

    /**
     * Adds heatmap layer on map.
     * @param layer layer
     */
    void addHeatMapLayer(HeatMapLayer layer);

    /**
     * Removes heatmap layer from map.
     * @param layer layer
     */
    void removeHeatMapLayer(HeatMapLayer layer);

    /**
     * Sets map zoom level. Supported values depend on used map service provider.
     * For Google Maps it is from 0 to 20 where 0 corresponds to a map of the Earth fully zoomed out.
     *
     * @param zoom zoom
     */
    void setZoom(int zoom);

    /**
     * @return zoom
     */
    int getZoom();

    /**
     * Creates and adds marker.
     * @param caption caption
     * @param position position
     * @param draggable draggable
     * @param iconUrl icon URL
     * @return created marker
     */
    Marker addMarker(String caption, GeoPoint position, boolean draggable, String iconUrl);

    /**
     * Adds marker on the map
     * @param marker marker
     */
    void addMarker(Marker marker);

    /**
     * Removes marker from map
     * @param marker marker
     */
    void removeMarker(Marker marker);

    /**
     * Removes all the markers from map
     */
    void clearMarkers();

    /**
     * @param marker marker
     * @return true if given marker is on the map
     */
    boolean hasMarker(Marker marker);

    /**
     * @return collection of the added on the map markers
     */
    Collection<Marker> getMarkers();

    /**
     * Sets the size to 100% x 100%
     */
    void setSizeFull();

    /**
     * Clears any size settings.
     */
    void setSizeUndefined();

    /**
     * @return center coordinate
     */
    GeoPoint getCenter();

    /**
     * Sets map center
     * @param center center
     */
    void setCenter(GeoPoint center);

    /**
     * @return coordinate of a north-east map corner. Note that border coordinates are not known
     * before map fully initialized. If you need to know border during screen initialization,
     * use {@link com.haulmont.charts.gui.components.map.MapViewer#addMapInitListener(com.haulmont.charts.gui.map.model.listeners.MapInitListener)}
     */
    GeoPoint getBoundNorthEast();

    /**
     * @return coordinate of a south-west map corner. Note that border coordinates are not known
     * before map fully initialized. If you need to know border during screen initialization,
     * use {@link com.haulmont.charts.gui.components.map.MapViewer#addMapInitListener(com.haulmont.charts.gui.map.model.listeners.MapInitListener)}
     */
    GeoPoint getBoundSouthWest();

    /**
     * Adds polyline on map
     * @param polyline polyline
     */
    void addPolyline(Polyline polyline);

    /**
     * Removes polyline from the map
     * @param polyline polyline
     */
    void removePolyline(Polyline polyline);

    /**
     * Adds circle on map
     * @param circle circle
     */
    void addCircleOverlay(Circle circle);

    /**
     * Removes circle from map
     * @param circle circle
     */
    void removeCircleOverlay(Circle circle);

    /**
     * Enables limiting of the visible area by a given bounds
     * @param enabled enabled
     */
    void setVisibleAreaBoundLimitsEnabled(boolean enabled);

    /**
     * Changes map viewpoint to contain area defined by a given bounds
     * @param boundsNE north-east coordinate
     * @param boundsSW south-west coordinate
     */
    void fitToBounds(GeoPoint boundsNE, GeoPoint boundsSW);

    /**
     * @return true if visible area limitation is enabled
     */
    boolean isVisibleAreaBoundLimitsEnabled();

    /**
     * Sets bounds for limiting map visible area
     * @param limitNE north-east coordinate
     * @param limitSW south-west coordinate
     */
    void setVisibleAreaBoundLimits(GeoPoint limitNE, GeoPoint limitSW);

    /**
     * Sets map maximum zoom
     * @param maxZoom zoom
     */
    void setMaxZoom(int maxZoom);

    /**
     * @return map maximum zoom
     */
    int getMaxZoom();

    /**
     * Sets map minimum zoom
     * @param minZoom zoom
     */
    void setMinZoom(int minZoom);

    /**
     * @return map minimum zoom
     */
    int getMinZoom();

    /**
     * @return true if map viewpoint can be changed by user dragging the map
     */
    boolean isDraggable();

    /**
     * Sets whether user should be able to change map viewpoint by dragging the map
     * @param draggable true for draggable
     */
    void setDraggable(boolean draggable);

    /**
     * @return true if keyboard shortcuts are enabled
     */
    boolean areKeyboardShortcutsEnabled();

    /**
     * Sets whether keyboard shortcuts should be enabled
     * @param enabled enabled
     */
    void setKeyboardShortcutsEnabled(boolean enabled);

    /**
     * @return true of zoom changing by mouse wheel scrolling is enabled
     */
    boolean isScrollWheelEnabled();

    /**
     * Sets whether map zoom should be editable by mouse wheel scrolling
     * @param enabled enabled
     */
    void setScrollWheelEnabled(boolean enabled);

    /**
     * @return true if map center possible locations are limited
     */
    boolean isCenterBoundLimitsEnabled();

    /**
     * Sets whether map center possible locations should be limited
     * @param enable enable
     */
    void setCenterBoundLimitsEnabled(boolean enable);

    /**
     * Sets map center possible locations bounds
     * @param limitNE north-east coordinate
     * @param limitSW south-west coordinate
     */
    void setCenterBoundLimits(GeoPoint limitNE, GeoPoint limitSW);

    /**
     * Adds polygon on map
     * @param polygon polygon
     */
    void addPolygonOverlay(Polygon polygon);

    /**
     * Removes polygon from map
     * @param polygon polygon
     */
    void removePolygonOverlay(Polygon polygon);

    /**
     * Sets map type
     * @param type type
     */
    void setMapType(Type type);

    /**
     * @return map type
     */
    Type getMapType();

    /**
     * Opens given info window
     * @param infoWindow info window
     */
    void openInfoWindow(InfoWindow infoWindow);

    /**
     * Closes given info window
     * @param infoWindow info window
     */
    void closeInfoWindow(InfoWindow infoWindow);

    /**
     * @param infoWindow info window
     * @return true if given info window is opened
     */
    boolean isInfoWindowOpen(InfoWindow infoWindow);

    /**
     * Sets options for drawing mode
     * @param drawingOptions drawing options
     */
    void setDrawingOptions(DrawingOptions drawingOptions);

    /**
     * Method for requesting mapping service to create a route
     * @param request request
     * @param callback callback object
     */
    void route(DirectionsRequest request, DirectionsRequestCallback callback);
}