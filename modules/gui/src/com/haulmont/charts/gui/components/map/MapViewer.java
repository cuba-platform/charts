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

package com.haulmont.charts.gui.components.map;

import com.haulmont.bali.events.Subscription;
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
import com.haulmont.cuba.gui.components.Component;

import java.util.Collection;
import java.util.EventObject;
import java.util.List;
import java.util.function.Consumer;

/**
 * Google map component.
 */
public interface MapViewer extends Component, Component.BelongToFrame, Component.HasIcon, Component.HasCaption {

    String NAME = "mapViewer";

    /** Tag name for XML loader */
    @Deprecated
    String TAG_NAME = "mapViewer";

    /**
     * Map types
     */
    enum Type {
        /**
         * Normal street map
         */
        ROADMAP("roadmap"),

        /**
         * Satellite images
         */
        SATELLITE("satellite"),

        /**
         * Satellite images with transparent layer of major streets
         */
        HYBRID("hybrid"),

        /**
         * Map with physical features such as terrain and vegetation
         */
        TERRAIN("terrain");

        private String mapTypeId;

        Type(String mapTypeId) {
            this.mapTypeId = mapTypeId;
        }

        public String getMapTypeId() {
            return mapTypeId;
        }

        public Type fromId(String id) {
            for (Type type : Type.values()) {
                if (type.getMapTypeId().equals(id)) {
                    return type;
                }
            }
            return null;
        }
    }

    /**
     * Adds a listener to a marker. Called when user clicks on the marker.
     *
     * @param listener a listener to add
     */
    Subscription addMarkerClickListener(Consumer<MarkerClickEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeMarkerClickListener(Consumer<MarkerClickEvent> listener);

    /**
     * Adds a listener to a marker. Called when user double clicks on the marker.
     *
     * @param listener a listener to add
     */
    Subscription addMarkerDoubleClickListener(Consumer<MarkerDoubleClickEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeMarkerDoubleClickListener(Consumer<MarkerDoubleClickEvent> listener);

    /**
     * Adds a listener to a marker. Called when user drags marker on the map.
     *
     * @param listener a listener to add
     */
    Subscription addMarkerDragListener(Consumer<MarkerDragEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeMarkerDragListener(Consumer<MarkerDragEvent> listener);

    /**
     * Adds a listener to a marker. Called when user clicks on the marker.
     *
     * @param listener a listener to add
     */
    Subscription addMarkerRightClickListener(Consumer<MarkerRightClickEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeMarkerRightClickListener(Consumer<MarkerRightClickEvent> listener);

    /**
     * Adds a listener to map. The listener fired when map's center or bounds have been moved. If map's center or
     * bounds are being changed continuously (when the user is dragging the map for example), then listener will be
     * fired up only once, on moving finished.
     *
     * @param listener a listener to add
     */
    Subscription addMapMoveListener(Consumer<MapMoveEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeMapMoveListener(Consumer<MapMoveEvent> listener);

    /**
     * Adds a listener to map. Called when user clicks on map.
     *
     * @param listener a listener to add
     */
    Subscription addMapClickListener(Consumer<MapClickEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeMapClickListener(Consumer<MapClickEvent> listener);

    /**
     * Adds a listener to map. Called when user clicks o the map.
     *
     * @param listener a listener to add
     */
    Subscription addMapRightClickListener(Consumer<MapRightClickEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeMapRightClickListener(Consumer<MapRightClickEvent> listener);

    /**
     * Adds a listener to info window. The listener to be fired up on info window closing.
     *
     * @param listener a listener to add
     */
    Subscription addInfoWindowClosedListener(Consumer<InfoWindowCloseEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeInfoWindowClosedListener(Consumer<InfoWindowCloseEvent> listener);

    /**
     * Adds a listener to a polygon. Called when user finished drawing polygon, i.e. made the first and the last
     * vertices of the polygon connected.
     *
     * @param listener a listener to add
     */
    Subscription addPolygonCompleteListener(Consumer<PolygonCompleteEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removePolygonCompleteListener(Consumer<PolygonCompleteEvent> listener);

    /**
     * Adds a listener to a polygon. Called when user adds/removes/moves polygon vertex.
     *
     * @param listener a listener to add
     */
    Subscription addPolygonEditListener(Consumer<PolygonEditEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removePolygonEditListener(Consumer<PolygonEditEvent> listener);

    /**
     * Adds a listener to a polygon. Called when user clicks on the polygon.
     *
     * @param listener a listener to add
     */
    Subscription addPolygonClickListener(Consumer<PolygonClickEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removePolygonClickListener(Consumer<PolygonClickEvent> listener);

    /**
     * Adds a listener to a polygon. Called when user clicks on the polygon.
     *
     * @param listener a listener to add
     */
    Subscription addPolygonRightClickListener(Consumer<PolygonRightClickEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removePolygonRightClickListener(Consumer<PolygonRightClickEvent> listener);

    /**
     * Adds a listener to map. Called when map initialization is finished: tiles are loaded up, coordinates of
     * center and borders are known etc.
     *
     * @param listener a listener to add
     */
    Subscription addMapInitListener(Consumer<MapInitEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeMapInitListener(Consumer<MapInitEvent> listener);

    /**
     * Adds a listener to circle. Called when user clicks on the circle.
     *
     * @param listener a listener to add
     */
    Subscription addCircleClickListener(Consumer<CircleClickEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeCircleClickListener(Consumer<CircleClickEvent> listener);

    /**
     * Adds a listener to circle. Called when user double clicks on the circle.
     *
     * @param listener a listener to add
     */
    Subscription addCircleDoubleClickListener(Consumer<CircleDoubleClickEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeCircleDoubleClickListener(Consumer<CircleDoubleClickEvent> listener);

    /**
     * Adds a listener to circle. Called when user change
     *
     * @param listener a listener to add
     */
    Subscription addCircleRadiusChangeListener(Consumer<CircleRadiusChangeEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeCircleRadiusChangeListener(Consumer<CircleRadiusChangeEvent> listener);

    /**
     * Adds a listener to circle. Called when user changes center of the circle.
     */
    Subscription addCircleCenterChangeListener(Consumer<CircleCenterChangeEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeCircleCenterChangeListener(Consumer<CircleCenterChangeEvent> listener);

    /**
     * Adds a listener to circle. Called when user finished drawing circle.
     *
     * @param listener a listener to add
     */
    Subscription addCircleCompleteListener(Consumer<CircleCompleteEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeCircleCompleteListener(Consumer<CircleCompleteEvent> listener);

    /**
     * Adds a listener to circle. Called when user clicks on the circle.
     *
     * @param listener a listener to add
     */
    Subscription addCircleRightClickListener(Consumer<CircleRightClickEvent> listener);

    /**
     * @deprecated Use {@link Subscription} instead
     */
    @Deprecated
    void removeCircleRightClickListener(Consumer<CircleRightClickEvent> listener);

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
     * Create Image Map Type
     * @param mapTypeId id, used when you add this map in map type controls
     * @return image map type
     */
    ImageMapType createImageMapType(String mapTypeId);

    /**
     * Create Image Map Type
     *
     * Example of tile callback function for retreiving OpenStreet maps tiles:
     * <pre>
     *{@code
     *  f = function f(x, y, zoom) {
     *          return 'http://tile.openstreetmap.org/' + zoom + '/' + x + '/' + y + '.png';
     *        }
     * }
     * </pre>
     * @param mapTypeId id, used when you add this map in map type controls
     * @param tileUrlCallbackJsFunction javascript function providing url of the tile by its coordinates and zoom
     * @return image map type
     */
    ImageMapType createImageMapType(String mapTypeId, String tileUrlCallbackJsFunction);

    /**
     * Create Image Map Type
     *
     * Example of tile callback function for retreiving OpenStreet maps tiles:
     * <pre>
     *{@code
     *  f = function f(x, y, zoom) {
     *          return 'http://tile.openstreetmap.org/' + zoom + '/' + x + '/' + y + '.png';
     *        }
     * }
     * </pre>
     * @param mapTypeId id, used when you add this map in map type controls
     * @param name name, for map type control
     * @param tileUrlCallbackJsFunction javascript function providing url of the tile by its coordinates and zoom
     * @return image map type
     */
    ImageMapType createImageMapType(String mapTypeId, String name, String tileUrlCallbackJsFunction);

    /**
     * Adds Map type
     * @param imageMapType
     */
    void addImageMapType(ImageMapType imageMapType);

    /**
     * Removes Map Type
     * @param imageMapType
     */
    void removeImageMapType(ImageMapType imageMapType);

    /**
     * Adds image map type as overlay on top of the active map
     * @param imageMapType
     */
    void addOverlayImageMapType(ImageMapType imageMapType);

    /**
     * Removes overlay map
     * @param imageMapType
     */
    void removeOverlayImageMapType(ImageMapType imageMapType);

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
     * Clears any size settings.
     *
     * @deprecated Use {@link #setSizeAuto()}
     */
    @Deprecated
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
     * use {@link com.haulmont.charts.gui.components.map.MapViewer#addMapInitListener(Consumer)}
     */
    GeoPoint getBoundNorthEast();

    /**
     * @return coordinate of a south-west map corner. Note that border coordinates are not known
     * before map fully initialized. If you need to know border during screen initialization,
     * use {@link com.haulmont.charts.gui.components.map.MapViewer#addMapInitListener(Consumer)}
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
     * Changes map viewpoint to contain area defined by a given bounds. If the boundsNE has longitude
     * less than boundsSW longitude, so viewpoint will be changed to the bounds from boundsSW
     * of the first part of MapViewer to the boundsNE of next part of MapViewer.
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
     * Sets map type by its ID. Useful for setting custom map type
     * @param typeId map type id
     */
    void setMapType(String typeId);

    /**
     * Sets map types available in map type control. For passing standard map id use {@link Type#getMapTypeId()}
     * @param mapTypeIds map type ids
     */
    void setMapTypes(List<String> mapTypeIds);

    /**
     * @return map type
     */
    String getMapType();

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

    /**
     * Creates empty Label. Add Label on map using {@link MapViewer#addLabel(Label)}.
     *
     * @return Label instance
     */
    Label createLabel();

    /**
     * Creates Label with given params. Add Label on map using {@link MapViewer#addLabel(Label)}.
     *
     * @param value    value
     * @param position position
     *
     * @return Label instance
     */
    Label createLabel(String value, GeoPoint position);

    /**
     * Creates Label with given params. Add Label on map using {@link MapViewer#addLabel(Label)}.
     *
     * @param value       value
     * @param position    position
     * @param contentType contentType
     *
     * @return Label instance
     */
    Label createLabel(String value, GeoPoint position, Label.ContentType contentType);

    /**
     * Adds label on the map.
     *
     * @param label label
     */
    void addLabel(Label label);

    /**
     * Removes label from the map.
     *
     * @param label label
     */
    void removeLabel(Label label);

    /**
     * Removes given vertex from given polygon.
     *
     * @param polygon polygon
     * @param vertex  vertex
     */
    void removePolygonVertex(Polygon polygon, GeoPoint vertex);

    /**
     * Sets message which will be used in popup to remove polygon vertex.
     *
     * @param message localized message
     */
    void setRemoveMessage(String message);

    /**
     * @return remove message
     */
    String getRemoveMessage();

    /**
     * Sets whether vertex removing is available or not.
     *
     * @param enabled enabled
     */
    void setVertexRemovingEnabled(boolean enabled);

    /**
     * @return whether vertex removing is available or not
     */
    boolean isVertexRemovingEnabled();

    abstract class AbstractMapEvent extends EventObject {

        public AbstractMapEvent(MapViewer source) {
            super(source);
        }

        @Override
        public MapViewer getSource() {
            return (MapViewer) super.getSource();
        }
    }

    /**
     * Describes marker click event.
     */
    class MarkerClickEvent extends AbstractMapEvent {
        private Marker marker;

        public MarkerClickEvent(MapViewer mapViewer, Marker marker) {
            super(mapViewer);
            this.marker = marker;
        }

        public Marker getMarker() {
            return marker;
        }
    }

    /**
     * Describes marker double click event.
     */
    class MarkerDoubleClickEvent extends AbstractMapEvent {
        private Marker marker;

        public MarkerDoubleClickEvent(MapViewer mapViewer, Marker marker) {
            super(mapViewer);
            this.marker = marker;
        }

        public Marker getMarker() {
            return marker;
        }
    }

    /**
     * Describes marker drag event.
     */
    class MarkerDragEvent extends AbstractMapEvent {
        private Marker marker;
        private GeoPoint oldPosition;

        public MarkerDragEvent(MapViewer mapViewer, Marker marker, GeoPoint oldPosition) {
            super(mapViewer);
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

    /**
     * Describes marker right click event.
     */
    class MarkerRightClickEvent extends AbstractMapEvent {
        protected Marker marker;

        public MarkerRightClickEvent(MapViewer mapViewer, Marker marker) {
            super(mapViewer);
            this.marker = marker;
        }

        public Marker getMarker() {
            return marker;
        }
    }

    /**
     * Describes map move event.
     */
    class MapMoveEvent extends AbstractMapEvent {
        private double zoom;
        private GeoPoint center;
        private GeoPoint boundsNE;
        private GeoPoint boundsSW;

        public MapMoveEvent(MapViewer mapViewer, double zoom, GeoPoint center, GeoPoint boundsNE, GeoPoint boundsSW) {
            super(mapViewer);
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

    /**
     * Describes map click event.
     */
    class MapClickEvent extends AbstractMapEvent {
        private GeoPoint position;

        public MapClickEvent(MapViewer mapViewer, GeoPoint position) {
            super(mapViewer);
            this.position = position;
        }

        public GeoPoint getPosition() {
            return position;
        }
    }

    /**
     * Describes map right click event.
     */
    class MapRightClickEvent extends AbstractMapEvent {
        protected GeoPoint position;

        public MapRightClickEvent(MapViewer mapViewer, GeoPoint position) {
            super(mapViewer);
            this.position = position;
        }

        public GeoPoint getPosition() {
            return position;
        }
    }

    /**
     * Describes info window close event.
     */
    class InfoWindowCloseEvent extends AbstractMapEvent {
        private InfoWindow infoWindow;

        public InfoWindowCloseEvent(MapViewer mapViewer, InfoWindow infoWindow) {
            super(mapViewer);
            this.infoWindow = infoWindow;
        }

        public InfoWindow getInfoWindow() {
            return infoWindow;
        }
    }

    /**
     * Describes polygon complete event.
     */
    class PolygonCompleteEvent extends AbstractMapEvent {
        private Polygon polygon;

        public PolygonCompleteEvent(MapViewer mapViewer, Polygon polygon) {
            super(mapViewer);
            this.polygon = polygon;
        }

        public Polygon getPolygon() {
            return polygon;
        }
    }

    /**
     * Describes polygon edit event.
     */
    class PolygonEditEvent extends AbstractMapEvent {
        private Polygon polygon;
        private ActionType actionType;
        private int index;
        private GeoPoint geoPoint;

        /**
         * Polygon edit action type
         *
         * <br> {@link #INSERT} - vertex have been inserted into polygon
         * <br> {@link #REMOVE} - vertex have been removed from polygon
         * <br> {@link #SET} - vertex coordinates have been changed
         */
        public enum ActionType {
            INSERT,
            REMOVE,
            SET
        }

        public PolygonEditEvent(MapViewer mapViewer, Polygon polygon, ActionType actionType, int index,
                                GeoPoint geoPoint) {
            super(mapViewer);
            this.polygon = polygon;
            this.actionType = actionType;
            this.index = index;
            this.geoPoint = geoPoint;
        }

        public Polygon getPolygon() {
            return polygon;
        }

        public ActionType getActionType() {
            return actionType;
        }

        public int getIndex() {
            return index;
        }

        public GeoPoint getGeoPoint() {
            return geoPoint;
        }
    }

    /**
     * Describes polygon click event.
     */
    class PolygonClickEvent extends AbstractMapEvent {
        protected Polygon polygon;

        public PolygonClickEvent(MapViewer mapViewer, Polygon polygon) {
            super(mapViewer);
            this.polygon = polygon;
        }

        public Polygon getPolygon() {
            return polygon;
        }
    }

    /**
     * Describes polygon right click event.
     */
    class PolygonRightClickEvent extends AbstractMapEvent {
        protected Polygon polygon;

        public PolygonRightClickEvent(MapViewer mapViewer, Polygon polygon) {
            super(mapViewer);
            this.polygon = polygon;
        }

        public Polygon getPolygon() {
            return polygon;
        }
    }

    /**
     * Describes map init event.
     */
    class MapInitEvent extends AbstractMapEvent {
        protected GeoPoint center;
        protected int zoom;
        protected GeoPoint boundNE;
        protected GeoPoint boundSW;

        public MapInitEvent(MapViewer mapViewer, GeoPoint center, int zoom, GeoPoint boundNE, GeoPoint boundSW) {
            super(mapViewer);
            this.center = center;
            this.zoom = zoom;
            this.boundNE = boundNE;
            this.boundSW = boundSW;
        }

        public GeoPoint getCenter() {
            return center;
        }

        public int getZoom() {
            return zoom;
        }

        public GeoPoint getBoundNE() {
            return boundNE;
        }

        public GeoPoint getBoundSW() {
            return boundSW;
        }
    }

    /**
     * Describes circle click event.
     */
    class CircleClickEvent extends AbstractMapEvent {
        private Circle circle;

        public CircleClickEvent(MapViewer mapViewer, Circle circle) {
            super(mapViewer);
            this.circle = circle;
        }

        public Circle getCircle() {
            return circle;
        }
    }

    /**
     * Describes circle double click event.
     */
    class CircleDoubleClickEvent extends AbstractMapEvent {
        private Circle circle;

        public CircleDoubleClickEvent(MapViewer mapViewer, Circle circle) {
            super(mapViewer);
            this.circle = circle;
        }

        public Circle getCircle() {
            return circle;
        }
    }

    /**
     * Describes circle radius change event.
     */
    class CircleRadiusChangeEvent extends AbstractMapEvent {

        private Circle circle;
        private double oldRadius;

        public CircleRadiusChangeEvent(MapViewer mapViewer, Circle circle, double oldRadius) {
            super(mapViewer);
            this.circle = circle;
            this.oldRadius = oldRadius;
        }

        public Circle getCircle() {
            return circle;
        }

        public double getOldRadius() {
            return oldRadius;
        }
    }

    /**
     * Describes circle center change event.
     */
    class CircleCenterChangeEvent extends AbstractMapEvent {
        private Circle circle;
        private GeoPoint oldCenter;

        public CircleCenterChangeEvent(MapViewer mapViewer, Circle circle, GeoPoint oldCenter) {
            super(mapViewer);
            this.circle = circle;
            this.oldCenter = oldCenter;
        }

        public Circle getCircle() {
            return circle;
        }

        public GeoPoint getOldCenter() {
            return oldCenter;
        }
    }

    /**
     * Describes circle complete event.
     */
    class CircleCompleteEvent extends AbstractMapEvent {
        private Circle circle;

        public CircleCompleteEvent(MapViewer mapViewer, Circle circle) {
            super(mapViewer);
            this.circle = circle;
        }

        public Circle getCircle() {
            return circle;
        }
    }

    /**
     * Describes circle right click event.
     */
    class CircleRightClickEvent extends AbstractMapEvent {
        protected Circle circle;

        public CircleRightClickEvent(MapViewer mapViewer, Circle circle) {
            super(mapViewer);
            this.circle = circle;
        }

        public Circle getCircle() {
            return circle;
        }
    }
}