/*
 * Copyright 2018 Tapio Aali
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.haulmont.charts.web.widgets.client.addons.googlemap;

import com.google.gwt.animation.client.AnimationScheduler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.maps.client.MapImpl;
import com.google.gwt.maps.client.MapOptions;
import com.google.gwt.maps.client.MapTypeId;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.base.LatLngBounds;
import com.google.gwt.maps.client.base.Point;
import com.google.gwt.maps.client.base.Size;
import com.google.gwt.maps.client.controls.MapTypeControlOptions;
import com.google.gwt.maps.client.drawinglib.DrawingManager;
import com.google.gwt.maps.client.drawinglib.DrawingManagerOptions;
import com.google.gwt.maps.client.events.center.CenterChangeMapEvent;
import com.google.gwt.maps.client.events.center.CenterChangeMapHandler;
import com.google.gwt.maps.client.events.click.ClickMapEvent;
import com.google.gwt.maps.client.events.click.ClickMapHandler;
import com.google.gwt.maps.client.events.closeclick.CloseClickMapEvent;
import com.google.gwt.maps.client.events.closeclick.CloseClickMapHandler;
import com.google.gwt.maps.client.events.dblclick.DblClickMapEvent;
import com.google.gwt.maps.client.events.dblclick.DblClickMapHandler;
import com.google.gwt.maps.client.events.domready.DomReadyMapEvent;
import com.google.gwt.maps.client.events.domready.DomReadyMapHandler;
import com.google.gwt.maps.client.events.dragend.DragEndMapEvent;
import com.google.gwt.maps.client.events.dragend.DragEndMapHandler;
import com.google.gwt.maps.client.events.idle.IdleMapEvent;
import com.google.gwt.maps.client.events.idle.IdleMapHandler;
import com.google.gwt.maps.client.events.insertat.InsertAtMapEvent;
import com.google.gwt.maps.client.events.insertat.InsertAtMapHandler;
import com.google.gwt.maps.client.events.maptypeid.MapTypeIdChangeMapEvent;
import com.google.gwt.maps.client.events.maptypeid.MapTypeIdChangeMapHandler;
import com.google.gwt.maps.client.events.mousedown.MouseDownMapEvent;
import com.google.gwt.maps.client.events.mousedown.MouseDownMapHandler;
import com.google.gwt.maps.client.events.mouseup.MouseUpMapEvent;
import com.google.gwt.maps.client.events.mouseup.MouseUpMapHandler;
import com.google.gwt.maps.client.events.overlaycomplete.circle.CircleCompleteMapEvent;
import com.google.gwt.maps.client.events.overlaycomplete.polygon.PolygonCompleteMapEvent;
import com.google.gwt.maps.client.events.radius.RadiusChangeMapEvent;
import com.google.gwt.maps.client.events.radius.RadiusChangeMapHandler;
import com.google.gwt.maps.client.events.removeat.RemoveAtMapEvent;
import com.google.gwt.maps.client.events.removeat.RemoveAtMapHandler;
import com.google.gwt.maps.client.events.rightclick.RightClickMapEvent;
import com.google.gwt.maps.client.events.rightclick.RightClickMapHandler;
import com.google.gwt.maps.client.events.setat.SetAtMapEvent;
import com.google.gwt.maps.client.events.setat.SetAtMapHandler;
import com.google.gwt.maps.client.events.tiles.TilesLoadedMapEvent;
import com.google.gwt.maps.client.events.tiles.TilesLoadedMapHandler;
import com.google.gwt.maps.client.layers.KmlLayer;
import com.google.gwt.maps.client.layers.KmlLayerOptions;
import com.google.gwt.maps.client.layers.TrafficLayer;
import com.google.gwt.maps.client.maptypes.ImageMapType;
import com.google.gwt.maps.client.mvc.MVCArray;
import com.google.gwt.maps.client.overlays.*;
import com.google.gwt.maps.client.services.DirectionsResult;
import com.google.gwt.maps.client.services.DirectionsService;
import com.google.gwt.maps.client.services.DirectionsStatus;
import com.google.gwt.maps.client.visualizationlib.HeatMapLayer;
import com.google.gwt.maps.client.visualizationlib.HeatMapLayerOptions;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RequiresResize;
import com.google.gwt.user.client.ui.Widget;
import com.haulmont.charts.web.widgets.client.addons.googlemap.base.LatLon;
import com.haulmont.charts.web.widgets.client.addons.googlemap.base.WeightedLocation;
import com.haulmont.charts.web.widgets.client.addons.googlemap.drawing.DrawingOptions;
import com.haulmont.charts.web.widgets.client.addons.googlemap.events.*;
import com.haulmont.charts.web.widgets.client.addons.googlemap.events.centerchange.CircleCenterChangeListener;
import com.haulmont.charts.web.widgets.client.addons.googlemap.events.click.CircleClickListener;
import com.haulmont.charts.web.widgets.client.addons.googlemap.events.click.MapClickListener;
import com.haulmont.charts.web.widgets.client.addons.googlemap.events.click.MarkerClickListener;
import com.haulmont.charts.web.widgets.client.addons.googlemap.events.click.PolygonClickListener;
import com.haulmont.charts.web.widgets.client.addons.googlemap.events.doubleclick.CircleDoubleClickListener;
import com.haulmont.charts.web.widgets.client.addons.googlemap.events.doubleclick.MarkerDoubleClickListener;
import com.haulmont.charts.web.widgets.client.addons.googlemap.events.overlaycomplete.CircleCompleteListener;
import com.haulmont.charts.web.widgets.client.addons.googlemap.events.overlaycomplete.PolygonCompleteListener;
import com.haulmont.charts.web.widgets.client.addons.googlemap.events.radiuschange.CircleRadiusChangeListener;
import com.haulmont.charts.web.widgets.client.addons.googlemap.events.rightclick.CircleRightClickListener;
import com.haulmont.charts.web.widgets.client.addons.googlemap.events.rightclick.MapRightClickListener;
import com.haulmont.charts.web.widgets.client.addons.googlemap.events.rightclick.MarkerRightClickListener;
import com.haulmont.charts.web.widgets.client.addons.googlemap.events.rightclick.PolygonRightClickListener;
import com.haulmont.charts.web.widgets.client.addons.googlemap.layers.GoogleMapHeatMapLayer;
import com.haulmont.charts.web.widgets.client.addons.googlemap.layers.GoogleMapKmlLayer;
import com.haulmont.charts.web.widgets.client.addons.googlemap.maptypes.GoogleImageMapType;
import com.haulmont.charts.web.widgets.client.addons.googlemap.overlays.*;
import com.haulmont.charts.web.widgets.client.addons.googlemap.services.DirectionsRequest;

import java.util.*;

import static com.haulmont.charts.web.widgets.client.addons.googlemap.events.PolygonEditListener.ActionType.*;

public class GoogleMapWidget extends FlowPanel implements RequiresResize {

    public static final String CLASSNAME = "googlemap";

    private MapWidget map;
    private MapImpl mapImpl;
    private MapOptions mapOptions;
    private Map<Marker, GoogleMapMarker> markerMap = new HashMap<Marker, GoogleMapMarker>();
    private Map<GoogleMapMarker, Marker> gmMarkerMap = new HashMap<GoogleMapMarker, Marker>();
    private Map<Polygon, GoogleMapPolygon> polygonMap = new HashMap<Polygon, GoogleMapPolygon>();
    private Map<Circle, GoogleMapCircle> circleMap = new HashMap<Circle, GoogleMapCircle>();
    private Map<Polyline, GoogleMapPolyline> polylineMap = new HashMap<Polyline, GoogleMapPolyline>();
    private Map<KmlLayer, GoogleMapKmlLayer> kmlLayerMap = new HashMap<KmlLayer, GoogleMapKmlLayer>();
    private Map<HeatMapLayer, GoogleMapHeatMapLayer> heatMapLayerMap = new HashMap<HeatMapLayer, GoogleMapHeatMapLayer>();
    private Map<GoogleMapLabel, JavaScriptObject> labelsMap = new HashMap<GoogleMapLabel, JavaScriptObject>();
    private Map<ImageMapType, GoogleImageMapType> imageMapTypes = new LinkedHashMap<ImageMapType, GoogleImageMapType>();
    private Map<ImageMapType, GoogleImageMapType> overlayImageMapTypes = new LinkedHashMap<ImageMapType, GoogleImageMapType>();

    private MarkerClickListener markerClickListener = null;
    private MarkerDoubleClickListener markerDoubleClickListener = null;
    private MarkerDragListener markerDragListener = null;
    private MarkerRightClickListener markerRightClickListener = null;

    private InfoWindowClosedListener infoWindowClosedListener = null;
    private DirectionsResultHandler directionsResultHandler = null;

    private PolygonCompleteListener polygonCompleteListener = null;
    private PolygonClickListener polygonClickListener = null;
    private PolygonEditListener polygonEditListener = null;
    private PolygonRightClickListener polygonRightClickListener = null;

    private CircleClickListener circleClickListener = null;
    private CircleDoubleClickListener circleDoubleClickListener = null;
    private CircleRightClickListener circleRightClickListener = null;
    private CircleCompleteListener circleCompleteListener = null;
    private CircleCenterChangeListener circleCenterChangeListener = null;
    private CircleRadiusChangeListener circleRadiusChangeListener = null;

    private DirectionsService directionsService;

    protected DrawingManager drawingManager;
    private MapMoveListener mapMoveListener = null;
    private LatLngBounds allowedBoundsCenter = null;
    private LatLngBounds allowedBoundsVisibleArea = null;

    private MapClickListener mapClickListener = null;
    private MapRightClickListener mapRightClickListener = null;
    protected MapTypeChangeListener mapTypeChangeListener = null;

    protected Map<CustomInfoWindow, GoogleMapInfoWindow> infoWindowMap = new HashMap<>();
    protected Map<GoogleMapInfoWindow, CustomInfoWindow> gmInfoWindowMap = new HashMap<>();
    protected Map<Long, CustomInfoWindow> infoWindowIDs = new HashMap<>();

    protected Map<Marker, Long> markerDragCounter = new HashMap<>();

    protected boolean forceBoundUpdate = false;
    protected TrafficLayer trafficLayer = null;
    private boolean initListenerNotified = false;
    private transient boolean markerDoubleClicked = false;
    private String removeMessage = "Remove";
    private boolean vertexRemovingEnabled = false;
    protected boolean markerDragged = false;
    protected boolean markerRightClicked = false;

    public GoogleMapWidget() {
        setStyleName(CLASSNAME);
    }

    public void initMap(LatLon center, int zoom, String mapTypeId, final MapInitListener initListener) {

        mapOptions = MapOptions.newInstance();
        mapOptions.setMapTypeId(MapTypeId.fromValue(mapTypeId.toLowerCase()));
        mapOptions.setCenter(
                LatLng.newInstance(center.getLat(), center.getLon()));
        mapOptions.setZoom(zoom);

        mapImpl = MapImpl.newInstance(getElement(), mapOptions);

        map = MapWidget.newInstance(mapImpl);

        mapImpl.addTilesLoadedHandler(new TilesLoadedMapHandler() {
            @Override
            public void onEvent(TilesLoadedMapEvent event) {
                if (!initListenerNotified) {
                    //call map init listener once
                    LatLon center = getCenter(mapImpl);
                    LatLon boundNE = getBoundNE(mapImpl);
                    LatLon boundSW = getBoundSW(mapImpl);
                    initListener.init(center, mapImpl.getZoom(), boundNE, boundSW);
                    initListenerNotified = true;
                }
            }
        });

        // always when center has changed, check that it does not go out from
        // the given bounds
        mapImpl.addCenterChangeHandler(new CenterChangeMapHandler() {
            @Override
            public void onEvent(CenterChangeMapEvent event) {
                forceBoundUpdate = checkVisibleAreaBoundLimits();
                forceBoundUpdate = checkCenterBoundLimits();
            }
        });

        // do all updates when the map has stopped moving
        mapImpl.addIdleHandler(new IdleMapHandler() {
            @Override
            public void onEvent(IdleMapEvent event) {
                //scheduling due to vaadin 7.2 bug: http://dev.vaadin.com/ticket/14164
                Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
                    @Override
                    public void execute() {
                        updateBounds(forceBoundUpdate);
                    }
                });
            }
        });

        mapImpl.addClickHandler(new ClickMapHandler() {
            @Override
            public void onEvent(final ClickMapEvent event) {
                Scheduler.get().scheduleDeferred(new Command() {
                    @Override
                    public void execute() {
                        if (mapClickListener != null) {
                            LatLng latLng = event.getMouseEvent().getLatLng();
                            LatLon position = new LatLon(latLng.getLatitude(), latLng.getLongitude());
                            mapClickListener.mapClicked(position);
                        }
                    }
                });
            }
        });

        mapImpl.addMapTypeIdChangeHandler(new MapTypeIdChangeMapHandler() {
            @Override
            public void onEvent(MapTypeIdChangeMapEvent event) {
                String mapTypeId = getMapTypeIdString();

                if (mapTypeChangeListener != null) {
                    mapTypeChangeListener.mapTypeChanged(mapTypeId.toLowerCase());
                }
            }
        });
        mapImpl.addRightClickHandler(new RightClickMapHandler() {
            @Override
            public void onEvent(final RightClickMapEvent rightClickMapEvent) {
                Scheduler.get().scheduleDeferred(new Command() {
                    @Override
                    public void execute() {
                        if (mapRightClickListener != null) {
                            LatLng latLng = rightClickMapEvent.getMouseEvent().getLatLng();
                            LatLon position = new LatLon(latLng.getLatitude(), latLng.getLongitude());
                            mapRightClickListener.mapRightClicked(position);
                        }
                    }
                });
            }
        });

        initLabelOverlay();
        initDeleteVertexOverlay();
    }

    private LatLon getCenter(MapImpl mapImpl) {
        return new LatLon(mapImpl.getCenter().getLatitude(), mapImpl.getCenter().getLongitude());
    }

    private LatLon getBoundSW(MapImpl mapImpl) {
        LatLng southWest = mapImpl.getBounds().getSouthWest();
        return new LatLon(southWest.getLatitude(), southWest.getLongitude());
    }

    private LatLon getBoundNE(MapImpl mapImpl) {
        LatLng northEast = mapImpl.getBounds().getNorthEast();
        return new LatLon(northEast.getLatitude(), northEast.getLongitude());
    }

    private boolean checkVisibleAreaBoundLimits() {
        if (allowedBoundsVisibleArea == null) {
            return false;
        }
        double newCenterLat = map.getCenter().getLatitude();
        double newCenterLng = map.getCenter().getLongitude();

        LatLng mapNE = map.getBounds().getNorthEast();
        LatLng mapSW = map.getBounds().getSouthWest();

        LatLng limitNE = allowedBoundsVisibleArea.getNorthEast();
        LatLng limitSW = allowedBoundsVisibleArea.getSouthWest();

        double mapWidth = mapNE.getLongitude() - mapSW.getLongitude();
        double mapHeight = mapNE.getLatitude() - mapSW.getLatitude();

        double maxWidth = limitNE.getLongitude() - limitSW.getLongitude();
        double maxHeight = limitNE.getLatitude() - limitSW.getLatitude();

        if (mapWidth > maxWidth) {
            newCenterLng = allowedBoundsVisibleArea.getCenter().getLongitude();
        } else if (mapNE.getLongitude() > limitNE.getLongitude()) {
            newCenterLng -= (mapNE.getLongitude() - limitNE.getLongitude());
        } else if (mapSW.getLongitude() < limitSW.getLongitude()) {
            newCenterLng += (limitSW.getLongitude() - mapSW.getLongitude());
        }

        if (mapHeight > maxHeight) {
            newCenterLat = allowedBoundsVisibleArea.getCenter().getLatitude();
        } else if (mapNE.getLatitude() > limitNE.getLatitude()) {
            newCenterLat -= (mapNE.getLatitude() - limitNE.getLatitude());
        } else if (mapSW.getLatitude() < limitSW.getLatitude()) {
            newCenterLat += (limitSW.getLatitude() - mapSW.getLatitude());
        }

        LatLng newCenter = LatLng.newInstance(newCenterLat, newCenterLng);
        if (!newCenter.equals(map.getCenter())) {
            moveCenterTo(newCenter);
            return true;
        }

        return false;
    }

    protected void moveCenterTo(LatLng position) {
        if (!map.getCenter().equals(position)) {
            map.setCenter(position);
        }
    }

    private void updateBounds(boolean forceUpdate) {
        int zoom = mapOptions.getZoom();
        LatLng center = mapOptions.getCenter();

        if (forceUpdate || zoom != map.getZoom() || center == null
                || center.getLatitude() != map.getCenter().getLatitude()
                || center.getLongitude() != map.getCenter().getLongitude()) {
            zoom = map.getZoom();
            center = map.getCenter();
            mapOptions.setZoom(zoom);
            mapOptions.setCenter(center);

            if (mapMoveListener != null) {
                mapMoveListener.mapMoved(map.getZoom(),
                        new LatLon(map.getCenter().getLatitude(),
                                map.getCenter().getLongitude()),
                        new LatLon(map.getBounds().getNorthEast().getLatitude(),
                                map.getBounds().getNorthEast().getLongitude()),
                        new LatLon(map.getBounds().getSouthWest().getLatitude(),
                                map.getBounds().getSouthWest().getLongitude()));
            }
        }
    }


    private boolean checkCenterBoundLimits() {
        LatLng center = map.getCenter();
        if (allowedBoundsCenter == null
                || allowedBoundsCenter.contains(center)) {
            return false;
        }
        double lat = center.getLatitude();
        double lng = center.getLongitude();

        LatLng northEast = allowedBoundsCenter.getNorthEast();
        LatLng southWest = allowedBoundsCenter.getSouthWest();
        if (lat > northEast.getLatitude()) {
            lat = northEast.getLatitude();
        }
        if (lng > northEast.getLongitude()) {
            lng = northEast.getLongitude();
        }
        if (lat < southWest.getLatitude()) {
            lat = southWest.getLatitude();
        }
        if (lng < southWest.getLongitude()) {
            lng = southWest.getLongitude();
        }

        LatLng newCenter = LatLng.newInstance(lat, lng);
        moveCenterTo(newCenter);
        return true;
    }

    public void setCenter(LatLng center) {
        if (map.getCenter().equals(center)) {
            return;
        }

        mapOptions.setZoom(map.getZoom());
        mapOptions.setCenter(center);
        map.panTo(center);
    }

    private List<GoogleMapMarker> getRemovedMarkers(
            Collection<GoogleMapMarker> newMarkers) {
        List<GoogleMapMarker> result = new ArrayList<GoogleMapMarker>();

        for (GoogleMapMarker oldMarker : gmMarkerMap.keySet()) {
            if (!newMarkers.contains(oldMarker)) {
                result.add(oldMarker);
            }
        }
        return result;
    }

    public void setZoom(int zoom) {
        if (mapOptions.getZoom() == zoom) {
            return;
        }

        mapOptions.setZoom(zoom);
        map.setZoom(zoom);
    }

    public LatLng getCenter() {
        return map.getCenter();
    }

    private void removeMarkers(List<GoogleMapMarker> markers) {
        for (GoogleMapMarker gmarker : markers) {

            Marker marker = gmMarkerMap.get(gmarker);
            marker.close();
            marker.setMap((MapWidget) null);

            markerMap.remove(marker);
            gmMarkerMap.remove(gmarker);
        }
    }

    public void setMarkers(Collection<GoogleMapMarker> markers) {
        if (markers.size() == markerMap.size()
                && markerMap.values().containsAll(markers)) {
            return;
        }

        List<GoogleMapMarker> removedMarkers = getRemovedMarkers(markers);
        removeMarkers(removedMarkers);

        for (GoogleMapMarker googleMapMarker : markers) {
            if (!gmMarkerMap.containsKey(googleMapMarker)) {

                final Marker marker = addMarker(googleMapMarker);
                markerMap.put(marker, googleMapMarker);
                gmMarkerMap.put(googleMapMarker, marker);

                // since some browsers can't handle clicks properly, needed to
                // define a click as a mousedown + mouseup that last less
                // than 150 ms
                marker.addMouseDownHandler(new MouseDownMapHandler() {
                    @Override
                    public void onEvent(MouseDownMapEvent event) {
                        markerDragCounter.put(marker, new Date().getTime());
                    }
                });

                marker.addMouseUpHandler(new MouseUpMapHandler() {
                    @Override
                    public void onEvent(MouseUpMapEvent event) {
                        if (markerClickListener != null) {
                            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
                                @Override
                                public void execute() {
                                    Timer timer = new Timer() {
                                        @Override
                                        public void run() {
                                            if (!markerDoubleClicked && !markerDragged && !markerRightClicked) {
                                                markerClickListener.markerClicked(markerMap.get(marker));
                                            }
                                        }
                                    };
                                    timer.schedule(500);
                                }
                            });
                        }
                    }
                });
                marker.addDblClickHandler(new DblClickMapHandler() {
                    @Override
                    public void onEvent(DblClickMapEvent event) {
                        markerDoubleClicked = true;
                        if (markerDoubleClickListener != null) {
                            markerDoubleClickListener.markerDoubleClicked(markerMap.get(marker));
                        }
                        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
                            @Override
                            public void execute() {
                                Timer timer = new Timer() {
                                    @Override
                                    public void run() {
                                        markerDoubleClicked = false;
                                    }
                                };
                                timer.schedule(500);
                            }
                        });
                    }
                });
                marker.addDragEndHandler(new DragEndMapHandler() {
                    @Override
                    public void onEvent(DragEndMapEvent event) {
                        markerDragged = true;

                        GoogleMapMarker gMarker = markerMap.get(marker);
                        LatLon oldPosition = gMarker.getPosition();
                        gMarker.setPosition(new LatLon(marker.getPosition().getLatitude(),
                                marker.getPosition().getLongitude()));

                        if (markerDragListener != null) {
                            markerDragListener.markerDragged(gMarker,
                                    oldPosition);
                        }

                        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
                            @Override
                            public void execute() {
                                Timer timer = new Timer() {
                                    @Override
                                    public void run() {
                                        markerDragged = false;
                                    }
                                };
                                timer.schedule(500);
                            }
                        });
                    }
                });
                marker.addRightClickHandler(new RightClickMapHandler() {
                    @Override
                    public void onEvent(RightClickMapEvent rightClickMapEvent) {
                        markerRightClicked = true;

                        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
                            @Override
                            public void execute() {
                                Timer timer = new Timer() {
                                    @Override
                                    public void run() {
                                        if (!markerDoubleClicked && markerRightClickListener != null) {
                                            markerRightClickListener.markerRightClicked(markerMap.get(marker));
                                        }

                                        markerRightClicked = false;
                                    }
                                };
                                timer.schedule(500);
                            }
                        });
                    }
                });
            } else {
                updateMarker(googleMapMarker);
            }
        }
    }

    private void updateMarker(GoogleMapMarker googleMapMarker) {
        Marker marker = gmMarkerMap.get(googleMapMarker);
        GoogleMapMarker oldGmMarker = markerMap.get(marker);

        if (!oldGmMarker.hasSameFieldValues(googleMapMarker)) {
            MarkerOptions options = createMarkerOptions(googleMapMarker);
            marker.setOptions(options);
        }

        gmMarkerMap.put(googleMapMarker, marker);
        markerMap.put(marker, googleMapMarker);
    }

    public void setMarkerClickListener(MarkerClickListener listener) {
        markerClickListener = listener;
    }

    public void setMarkerRightClickListener(MarkerRightClickListener markerRightClickListener) {
        this.markerRightClickListener = markerRightClickListener;
    }

    public void setMarkerDoubleClickListener(MarkerDoubleClickListener listener) {
        markerDoubleClickListener = listener;
    }

    public void setMapMoveListener(MapMoveListener listener) {
        mapMoveListener = listener;
    }

    public void setMapClickListener(MapClickListener listener) {
        mapClickListener = listener;
    }

    protected void setMapRightClickListener(MapRightClickListener mapRightClickListener) {
        this.mapRightClickListener = mapRightClickListener;
    }

    public void setMarkerDragListener(MarkerDragListener listener) {
        markerDragListener = listener;
    }

    public void setInfoWindowClosedListener(InfoWindowClosedListener listener) {
        infoWindowClosedListener = listener;
    }

    public void setPolygonCompleteListener(PolygonCompleteListener listener) {
        polygonCompleteListener = listener;
    }

    public void setPolygonEditListener(PolygonEditListener listener) {
        polygonEditListener = listener;
    }

    public void setMapTypeChangeListener(MapTypeChangeListener listener) {
        mapTypeChangeListener = listener;
    }

    public void setPolygonClickListener(PolygonClickListener listener) {
        polygonClickListener = listener;
    }

    protected void setPolygonRightClickListener(PolygonRightClickListener polygonRightClickListener) {
        this.polygonRightClickListener = polygonRightClickListener;
    }

    public void setDirectionsResultHandler(DirectionsResultHandler handler) {
        directionsResultHandler = handler;
    }

    public void setCircleCompleteListener(CircleCompleteListener circleCompleteListener) {
        this.circleCompleteListener = circleCompleteListener;
    }

    public void setCircleClickListener(CircleClickListener circleClickListener) {
        this.circleClickListener = circleClickListener;
    }

    protected void setCircleRightClickListener(CircleRightClickListener circleRightClickListener) {
        this.circleRightClickListener = circleRightClickListener;
    }

    public void setCircleCenterChangeListener(CircleCenterChangeListener circleCenterChangeListener) {
        this.circleCenterChangeListener = circleCenterChangeListener;
    }

    public void setCircleDoubleClickListener(CircleDoubleClickListener circleDoubleClickListener) {
        this.circleDoubleClickListener = circleDoubleClickListener;
    }

    public void setCircleRadiusChangeListener(CircleRadiusChangeListener circleRadiusChangeListener) {
        this.circleRadiusChangeListener = circleRadiusChangeListener;
    }

    private Marker addMarker(GoogleMapMarker googleMapMarker) {
        MarkerOptions options = createMarkerOptions(googleMapMarker);

        final Marker marker = Marker.newInstance(options);
        marker.setMap(map);

        return marker;
    }

    private MarkerOptions createMarkerOptions(GoogleMapMarker googleMapMarker) {
        LatLng center = LatLng.newInstance(googleMapMarker.getPosition().getLat(),
                googleMapMarker.getPosition().getLon());
        MarkerOptions options = MarkerOptions.newInstance();
        options.setPosition(center);
        options.setTitle(googleMapMarker.getCaption());
        options.setDraggable(googleMapMarker.isDraggable());
        options.setOptimized(googleMapMarker.isOptimized());

        if (googleMapMarker.getIconUrl() != null) {
            options.setIcon(googleMapMarker.getIconUrl());
        }

        if (googleMapMarker.getMarkerImage() != null) {
            options.setIcon(createMarkerImage(googleMapMarker.getMarkerImage()));
        }

        if (googleMapMarker.isAnimationEnabled()) {
            options.setAnimation(Animation.DROP);
        }
        return options;
    }

    private MarkerImage createMarkerImage(com.haulmont.charts.web.widgets.client.addons.googlemap.base.MarkerImage googleMapMarkerImage) {
        if (googleMapMarkerImage == null) {
            return null;
        }

        MarkerImage markerImage = MarkerImage.newInstance(googleMapMarkerImage.getUrl());
        markerImage.setSize(createSize(googleMapMarkerImage.getSize()));
        markerImage.setAnchor(createPoint(googleMapMarkerImage.getAnchor()));
        markerImage.setOrigin(createPoint(googleMapMarkerImage.getOrigin()));
        markerImage.setScaledSize(createSize(googleMapMarkerImage.getScaledSize()));

        return markerImage;
    }

    private Point createPoint(com.haulmont.charts.web.widgets.client.addons.googlemap.base.Point googleMapPoint) {
        if (googleMapPoint == null) {
            return null;
        }
        return Point.newInstance(googleMapPoint.getX(), googleMapPoint.getY());
    }

    private Size createSize(com.haulmont.charts.web.widgets.client.addons.googlemap.base.Size googleMapSize) {
        if (googleMapSize == null) {
            return null;
        }
        return Size.newInstance(googleMapSize.getWidth(), googleMapSize.getHeight(),
                googleMapSize.getWidthUnit(), googleMapSize.getHeightUnit());
    }

    public double getZoom() {
        return map.getZoom();
    }

    public double getLatitude() {
        return map.getCenter().getLatitude();
    }

    public double getLongitude() {
        return map.getCenter().getLongitude();
    }

    public void setCenterBoundLimits(LatLon limitNE, LatLon limitSW) {
        allowedBoundsCenter = LatLngBounds.newInstance(
                LatLng.newInstance(limitSW.getLat(), limitSW.getLon()),
                LatLng.newInstance(limitNE.getLat(), limitNE.getLon()));
    }

    public void clearCenterBoundLimits() {
        allowedBoundsCenter = null;
    }

    public void setVisibleAreaBoundLimits(LatLon limitNE, LatLon limitSW) {
        allowedBoundsVisibleArea = LatLngBounds.newInstance(
                LatLng.newInstance(limitSW.getLat(), limitSW.getLon()),
                LatLng.newInstance(limitNE.getLat(), limitNE.getLon()));
    }

    public void clearVisibleAreaBoundLimits() {
        allowedBoundsVisibleArea = null;
    }

    public void setPolygonOverlays(Map<Long, GoogleMapPolygon> polyOverlays) {
        for (Polygon polygon : polygonMap.keySet()) {
            polygon.setMap(null);
        }
        polygonMap.clear();

        for (GoogleMapPolygon overlay : polyOverlays.values()) {
            MVCArray<LatLng> points = MVCArray.newInstance();
            for (LatLon latLon : overlay.getCoordinates()) {
                LatLng latLng = LatLng.newInstance(latLon.getLat(), latLon.getLon());
                points.push(latLng);
            }

            PolygonOptions options = PolygonOptions.newInstance();
            options.setFillColor(overlay.getFillColor());
            options.setFillOpacity(overlay.getFillOpacity());
            options.setGeodesic(overlay.isGeodesic());
            options.setStrokeColor(overlay.getStrokeColor());
            options.setStrokeOpacity(overlay.getStrokeOpacity());
            options.setStrokeWeight(overlay.getStrokeWeight());
            options.setZindex(overlay.getzIndex());
            options.setMap(map);

            Polygon polygon = Polygon.newInstance(options);
            polygon.setPath(points);
            polygon.setMap(map);
            polygon.setEditable(overlay.isEditable());
            attachPolygonEditListeners(polygon, overlay);
            polygonMap.put(polygon, overlay);

            addPolygonVertexClickListener(polygon);
        }
    }

    private native void addPolygonVertexClickListener(Polygon polygon) /*-{
        var that = this;
        $wnd.google.maps.event.addListener(polygon, 'rightclick', function(e) {
            var removingEnabled = that.@com.haulmont.charts.web.widgets.client.addons.googlemap.GoogleMapWidget::isVertexRemovingEnabled()();
            if (!removingEnabled) {
                return;
            }

            if (e.vertex != undefined) {
                var map = that.@com.haulmont.charts.web.widgets.client.addons.googlemap.GoogleMapWidget::getMapImpl()();
                var deleteOverlay = new $wnd.DeleteVertexOverlay();
                deleteOverlay.open(map, polygon, e.vertex);
            }
        });
    }-*/;

    private native void initDeleteVertexOverlay() /*-{
        var that = this;
        $wnd.DeleteVertexOverlay = function() {
            this.div_ = document.createElement('div');
            this.div_.className = 'delete-vertex-overlay';

            var menu = this;
            $wnd.google.maps.event.addDomListener(this.div_, 'click', function() {
                menu.removeVertex();
            });
        }
        $wnd.DeleteVertexOverlay.prototype = new $wnd.google.maps.OverlayView();

        $wnd.DeleteVertexOverlay.prototype.onAdd = function() {
            var deleteOverlay = this;
            var map = this.getMap();
            this.getPanes().floatPane.appendChild(this.div_);

            this.divListener_ = $wnd.google.maps.event.addDomListener(map.getDiv(), 'mousedown', function(e) {
                if (e.target != deleteOverlay.div_) {
                    deleteOverlay.close();
                }
            }, true);
        };

        $wnd.DeleteVertexOverlay.prototype.onRemove = function() {
            $wnd.google.maps.event.removeListener(this.divListener_);
            this.div_.parentNode.removeChild(this.div_);

            this.set('position');
            this.set('polygon');
            this.set('vertex');
        };

        $wnd.DeleteVertexOverlay.prototype.close = function() {
            this.setMap(null);
        };

        $wnd.DeleteVertexOverlay.prototype.draw = function() {
            var position = this.get('position');
            var projection = this.getProjection();

            if (!position || !projection) {
                return;
            }

            var point = projection.fromLatLngToDivPixel(position);
            this.div_.style.top = point.y + 'px';
            this.div_.style.left = point.x + 'px';
        };

        $wnd.DeleteVertexOverlay.prototype.open = function(map, polygon, vertex) {
            this.set('position', polygon.getPath().getAt(vertex));
            this.set('polygon', polygon);
            this.set('vertex', vertex);

            var deleteMessage = that.@com.haulmont.charts.web.widgets.client.addons.googlemap.GoogleMapWidget::getRemoveMessage()();
            this.div_.innerHTML = deleteMessage;

            this.setMap(map);
            this.draw();
        };

        $wnd.DeleteVertexOverlay.prototype.removeVertex = function() {
            var polygon = this.get('polygon');
            var path = polygon.getPath();

            if (path.length <= 3) {
                this.close();
                return;
            }

            var vertex = this.get('vertex');

            if (!path || vertex == undefined) {
                this.close();
                return;
            }

            path.removeAt(vertex);

            this.close();
        };
    }-*/;

    public void setCircleOverlays(Map<Long, GoogleMapCircle> circleOverlays) {
        for (Circle circle : circleMap.keySet()) {
            circle.setMap(null);
        }
        circleMap.clear();

        for (GoogleMapCircle overlay : circleOverlays.values()) {
            CircleOptions options = CircleOptions.newInstance();

            options.setCenter(GoogleMapAdapterUtils.toLatLng(overlay.getCenter()));
            options.setRadius(overlay.getRadius());
            options.setFillColor(overlay.getFillColor());
            options.setFillOpacity(overlay.getFillOpacity());
            options.setStrokeColor(overlay.getStrokeColor());
            options.setStrokeOpacity(overlay.getStrokeOpacity());
            options.setStrokeWeight(overlay.getStrokeWeight());
            options.setZindex(overlay.getzIndex());
            options.setClickable(overlay.isClickable());

            Circle circle = Circle.newInstance(options);

            circle.setRadius(overlay.getRadius());
            circle.setMap(map);
            circle.setEditable(overlay.isEditable());

            attachCircleListeners(circle);
            circleMap.put(circle, overlay);
        }
    }

    private void attachCircleListeners(final Circle circle) {
        circle.addCenterChangeHandler(new CenterChangeMapHandler() {
            @Override
            public void onEvent(CenterChangeMapEvent event) {
                Scheduler.get().scheduleDeferred(new Command() {
                    @Override
                    public void execute() {
                        GoogleMapCircle vCircle = circleMap.get(circle);

                        LatLon vOldCenter = vCircle.getCenter();
                        LatLng gwtOldCenter = LatLng.newInstance(vOldCenter.getLat(), vOldCenter.getLon());

                        vCircle.setCenter(GoogleMapAdapterUtils.fromLatLng(circle.getCenter()));

                        if (circleCenterChangeListener != null && !Objects.equals(gwtOldCenter, circle.getCenter())) {
                            circleCenterChangeListener.centerChanged(vCircle, vOldCenter);
                        }
                    }
                });
            }
        });
        circle.addClickHandler(new ClickMapHandler() {
            @Override
            public void onEvent(ClickMapEvent event) {
                Scheduler.get().scheduleDeferred(new Command() {
                    @Override
                    public void execute() {
                        if (circleClickListener != null) {
                            final GoogleMapCircle vCircle = circleMap.get(circle);
                            circleClickListener.circleClicked(vCircle);
                        }
                    }
                });
            }
        });
        circle.addDblClickHandler(new DblClickMapHandler() {
            @Override
            public void onEvent(DblClickMapEvent event) {
                Scheduler.get().scheduleDeferred(new Command() {
                    @Override
                    public void execute() {
                        if (circleDoubleClickListener != null) {
                            final GoogleMapCircle vCircle = circleMap.get(circle);
                            circleDoubleClickListener.circleDoubleClicked(vCircle);
                        }
                    }
                });
            }
        });
        circle.addRadiusChangeHandler(new RadiusChangeMapHandler() {
            @Override
            public void onEvent(RadiusChangeMapEvent event) {
                Scheduler.get().scheduleDeferred(new Command() {
                    @Override
                    public void execute() {
                        final GoogleMapCircle vCircle = circleMap.get(circle);
                        final double oldRadius = vCircle.getRadius();
                        vCircle.setRadius(circle.getRadius());
                        if (circleRadiusChangeListener != null && vCircle.getRadius() != oldRadius) {
                            circleRadiusChangeListener.radiusChange(vCircle, oldRadius);
                        }
                    }
                });
            }
        });
        circle.addRightClickHandler(new RightClickMapHandler() {
            @Override
            public void onEvent(RightClickMapEvent rightClickMapEvent) {
                Scheduler.get().scheduleDeferred(new Command() {
                    @Override
                    public void execute() {
                        if (circleRightClickListener != null) {
                            circleRightClickListener.circleRightClicked(circleMap.get(circle));
                        }
                    }
                });
            }
        });
    }

    public void setPolylineOverlays(Set<GoogleMapPolyline> polylineOverlays) {
        if (polylineOverlays.size() == polylineMap.size()
                && polylineMap.values().containsAll(polylineOverlays)) {
            return;
        }

        for (Polyline polyline : polylineMap.keySet()) {
            polyline.setMap(null);
        }
        polylineMap.clear();

        for (GoogleMapPolyline overlay : polylineOverlays) {
            MVCArray<LatLng> points = MVCArray.newInstance();
            for (LatLon latLon : overlay.getCoordinates()) {
                LatLng latLng = LatLng.newInstance(latLon.getLat(), latLon.getLon());
                points.push(latLng);
            }

            PolylineOptions options = PolylineOptions.newInstance();
            options.setGeodesic(overlay.isGeodesic());
            options.setStrokeColor(overlay.getStrokeColor());
            options.setStrokeOpacity(overlay.getStrokeOpacity());
            options.setStrokeWeight(overlay.getStrokeWeight());
            options.setZindex(overlay.getzIndex());

            Polyline polyline = Polyline.newInstance(options);
            polyline.setPath(points);
            polyline.setMap(map);

            polylineMap.put(polyline, overlay);
        }
    }

    public void setKmlLayers(Collection<GoogleMapKmlLayer> layers) {

        // no update needed if old layers match
        if (kmlLayerMap.size() == layers.size()
                && kmlLayerMap.values().containsAll(layers)) {
            return;
        }

        for (KmlLayer kmlLayer : kmlLayerMap.keySet()) {
            kmlLayer.setMap(null);
        }
        kmlLayerMap.clear();

        for (GoogleMapKmlLayer gmLayer : layers) {
            KmlLayerOptions options = KmlLayerOptions.newInstance();
            options.setClickable(gmLayer.isClickable());
            options.setPreserveViewport(gmLayer.isViewportPreserved());
            options.setSuppressInfoWindows(gmLayer
                    .isInfoWindowRenderingDisabled());

            KmlLayer kmlLayer = KmlLayer.newInstance(gmLayer.getUrl(), options);
            kmlLayer.setMap(map);

            kmlLayerMap.put(kmlLayer, gmLayer);
        }
    }

    public void processDirectionRequests(Collection<DirectionsRequest> requests) {
        directionsService = DirectionsService.newInstance();
        for (final DirectionsRequest googleMapRequest : requests) {
            final long id = googleMapRequest.getId();
            final com.google.gwt.maps.client.services.DirectionsRequest request =
                    GoogleMapAdapterUtils.toDirectionsRequest(googleMapRequest);
            directionsService.route(request, new GoogleDirectionsResultHandler(id));
        }
    }

    public void setHeatMapLayers(Collection<GoogleMapHeatMapLayer> layers) {
        for (HeatMapLayer heatMapLayer : heatMapLayerMap.keySet()) {
            heatMapLayer.setMap(null);
        }
        heatMapLayerMap.clear();

        for (GoogleMapHeatMapLayer heatMapLayer : layers) {
            HeatMapLayerOptions options = HeatMapLayerOptions.newInstance();

            if (heatMapLayer.getDissipating() != null) {
                options.setDissipating(heatMapLayer.getDissipating());
            }
            if (heatMapLayer.getMaxIntensity() != null) {
                options.setMaxIntensity(heatMapLayer.getMaxIntensity());
            }
            if (heatMapLayer.getOpacity() != null) {
                options.setOpacity(heatMapLayer.getOpacity());
            }
            if (heatMapLayer.getRadius() != null) {
                options.setRadius(heatMapLayer.getRadius());
            }

            if (heatMapLayer.getGradient() != null && !heatMapLayer.getGradient().isEmpty()) {
                JsArrayString gradient = JsArrayString.createArray().cast();
                for (String color : heatMapLayer.getGradient()) {
                    gradient.push(color);
                }
                options.setGradient(gradient);
            }
            HeatMapLayer layer = HeatMapLayer.newInstance(options);

            if (heatMapLayer.getData() != null && !heatMapLayer.getData().isEmpty()) {
                MVCArray<LatLng> data = MVCArray.newInstance();
                for (LatLon latLon : heatMapLayer.getData()) {
                    data.push(LatLng.newInstance(latLon.getLat(), latLon.getLon()));
                }
                layer.setData(data);
            } else if (heatMapLayer.getWeightedData() != null
                    && !heatMapLayer.getWeightedData().isEmpty()) {
                MVCArray<com.google.gwt.maps.client.visualizationlib.WeightedLocation> weightedData
                        = MVCArray.newInstance();
                for (WeightedLocation location : heatMapLayer.getWeightedData()) {
                    LatLng latLng = LatLng.newInstance(location.getLocation().getLat(),
                            location.getLocation().getLon());
                    weightedData.push(com.google.gwt.maps.client.visualizationlib
                            .WeightedLocation.newInstance(latLng, location.getWeight()));
                }
                layer.setDataWeighted(weightedData);
            } else {
                layer.setData(MVCArray.<LatLng>newInstance());
            }

            layer.setMap(map);
            heatMapLayerMap.put(layer, heatMapLayer);
        }
    }

    public void setImageMapTypes(Set<GoogleImageMapType> mapTypes) {
        //no need to clear registry, will re-set map types instead
        imageMapTypes.clear();

        for (GoogleImageMapType mapType : mapTypes) {
            ImageMapType imageMapType = GoogleMapAdapterUtils.toImageMapType(mapType);
            map.getMapTypeRegistry().set(mapType.getMapTypeId().toUpperCase(), imageMapType);
            imageMapTypes.put(imageMapType, mapType);
        }
    }

    public void setOverlayImageMapTypes(Set<GoogleImageMapType> mapTypes) {
        map.getOverlayMapTypes().clear();
        overlayImageMapTypes.clear();

        for (GoogleImageMapType mapType : mapTypes) {
            ImageMapType imageMapType = GoogleMapAdapterUtils.toImageMapType(mapType);
            map.getOverlayMapTypes().insertAt(mapType.getOverlayMapTypePosition(), imageMapType);
            overlayImageMapTypes.put(imageMapType, mapType);
        }
    }

    public void setMapType(String mapTypeId) {
        MapTypeId id = MapTypeId.fromValue(mapTypeId.toLowerCase());
        if (id == mapOptions.getMapTypeId()) {
            return;
        }
        mapOptions.setMapTypeId(MapTypeId.fromValue(mapTypeId.toLowerCase()));

        // avoid infinite loops
        if (id != mapImpl.getMapTypeId()) {
            map.setOptions(mapOptions);
        }
    }

    public void setControls(Set<GoogleMapControl> controls) {

        // check if there's been a real change in selected controls
        Set<GoogleMapControl> currentControls = new HashSet<GoogleMapControl>();
        if (mapOptions.getMapTypeControl()) {
            currentControls.add(GoogleMapControl.MapType);
        }
        if (mapOptions.getOverviewMapControl()) {
            currentControls.add(GoogleMapControl.OverView);
        }
        if (mapOptions.getPanControl()) {
            currentControls.add(GoogleMapControl.Pan);
        }
        if (mapOptions.getRotateControl()) {
            currentControls.add(GoogleMapControl.Rotate);
        }
        if (mapOptions.getScaleControl()) {
            currentControls.add(GoogleMapControl.Scale);
        }
        if (mapOptions.getStreetViewControl()) {
            currentControls.add(GoogleMapControl.StreetView);
        }
        if (mapOptions.getZoomControl()) {
            currentControls.add(GoogleMapControl.Zoom);
        }

        if (controls.size() == currentControls.size()
                && currentControls.containsAll(controls)) {
            return;
        }

        mapOptions
                .setMapTypeControl(controls.contains(GoogleMapControl.MapType));
        mapOptions.setOverviewMapControl(
                controls.contains(GoogleMapControl.OverView));
        mapOptions.setPanControl(controls.contains(GoogleMapControl.Pan));
        mapOptions.setRotateControl(controls.contains(GoogleMapControl.Rotate));
        mapOptions.setScaleControl(controls.contains(GoogleMapControl.Scale));
        mapOptions.setStreetViewControl(controls
                .contains(GoogleMapControl.StreetView));
        mapOptions.setZoomControl(controls.contains(GoogleMapControl.Zoom));

        setFullscreenControl(mapOptions, controls.contains(GoogleMapControl.Fullscreen));

        map.setOptions(mapOptions);

    }

    protected final native void setFullscreenControl(MapOptions mapOptions, boolean value) /*-{
        mapOptions.fullscreenControl = value;
    }-*/;

    public void setDraggable(boolean draggable) {
        if (mapOptions.getDraggable() == draggable) {
            return;
        }

        mapOptions.setDraggable(draggable);
        map.setOptions(mapOptions);
    }

    public void setKeyboardShortcutsEnabled(boolean keyboardShortcutsEnabled) {
        if (mapOptions.getKeyboardShortcuts() == keyboardShortcutsEnabled) {
            return;
        }
        mapOptions.setKeyboardShortcuts(keyboardShortcutsEnabled);
        map.setOptions(mapOptions);
    }

    public void setScrollWheelEnabled(boolean scrollWheelEnabled) {
        if (mapOptions.getScrollWheel() == scrollWheelEnabled) {
            return;
        }
        mapOptions.setScrollWheel(scrollWheelEnabled);
        map.setOptions(mapOptions);
    }

    public void setMinZoom(int minZoom) {
        if (mapOptions.getMinZoom() == minZoom) {
            return;
        }
        mapOptions.setMinZoom(minZoom);
        map.setOptions(mapOptions);
    }

    public void setMaxZoom(int maxZoom) {
        if (mapOptions.getMaxZoom() == maxZoom) {
            return;
        }
        mapOptions.setMaxZoom(maxZoom);
        map.setOptions(mapOptions);
    }

    public MapWidget getMap() {
        return map;
    }

    public void triggerResize() {
        AnimationScheduler.get().requestAnimationFrame(new AnimationScheduler.AnimationCallback() {
            @Override
            public void execute(double timestamp) {
                Scheduler.get().scheduleFinally(new Scheduler.ScheduledCommand() {
                    @Override
                    public void execute() {
                        map.triggerResize();
                        map.setZoom(mapOptions.getZoom());
                        map.setCenter(mapOptions.getCenter());
                    }
                });
            }
        });
    }

    InfoWindowOptions createInfoWindowOptions(GoogleMapInfoWindow gmWindow) {
        InfoWindowOptions options = InfoWindowOptions.newInstance();
        options.setDisableAutoPan(gmWindow.isAutoPanDisabled());
        if (gmWindow.getMaxWidth() != null) {
            options.setMaxWidth(gmWindow.getMaxWidth());
        }
        if (gmWindow.getPixelOffsetHeight() != null
                && gmWindow.getPixelOffsetWidth() != null) {
            options.setPixelOffet(
                    Size.newInstance(gmWindow.getPixelOffsetWidth(),
                            gmWindow.getPixelOffsetHeight()));
        }
        if (gmWindow.getPosition() != null) {
            options.setPosition(
                    LatLng.newInstance(gmWindow.getPosition().getLat(),
                            gmWindow.getPosition().getLon()));
        }
        if (gmWindow.getzIndex() != null) {
            options.setZindex(gmWindow.getzIndex());
        }
        return options;
    }

    DivElement createContentFromGMWindow(GoogleMapInfoWindow gmWindow) {
        String contents = gmWindow.getContent();

        // wrap the contents inside a div if there's a defined width or height
        if (gmWindow.getHeight() != null || gmWindow.getWidth() != null) {
            StringBuilder contentWrapper = new StringBuilder("<div style=\"");
            if (gmWindow.getWidth() != null) {
                contentWrapper.append("width:")
                        .append(gmWindow.getWidth())
                        .append(";");
            }
            if (gmWindow.getHeight() != null) {
                contentWrapper.append("height:")
                        .append(gmWindow.getHeight())
                        .append(";");
            }
            contentWrapper.append("\" >")
                    .append(contents)
                    .append("</div>");
            contents = contentWrapper.toString();
        }

        DivElement div = Document.get().createDivElement();
        div.setInnerHTML(contents);
        return div;
    }

    public void setInfoWindows(Collection<GoogleMapInfoWindow> infoWindows) {

        for(GoogleMapInfoWindow gmWindow : infoWindows) {
            InfoWindowOptions options = createInfoWindowOptions(gmWindow);

            CustomInfoWindow window;

            if(!gmInfoWindowMap.containsKey(gmWindow)) {
                // Create new InfoWindow with contents
                final CustomInfoWindow w = window = new CustomInfoWindow();
                window.setContent(createContentFromGMWindow(gmWindow));
                window.addCloseClickListener(new CloseClickMapHandler() {
                    @Override
                    public void onEvent(CloseClickMapEvent event) {
                        if (infoWindowClosedListener != null) {
                            infoWindowClosedListener.infoWindowClosed(infoWindowMap.get(w));
                        }
                    }
                });
                adopt(window);

                // Register new info window
                infoWindowMap.put(window,gmWindow);
                gmInfoWindowMap.put(gmWindow,window);
                infoWindowIDs.put(gmWindow.getId(),window);
            } else {
                // Get reference to old window and close it
                window = gmInfoWindowMap.get(gmWindow);
                window.close();
            }

            // Open the window
            if (gmMarkerMap.containsKey(gmWindow.getAnchorMarker())) {
                window.open(options, map, gmMarkerMap.get(gmWindow.getAnchorMarker()));
            } else {
                window.open(options, map);
            }

            window.getWrapped().addDomReadyHandler(new DomReadyMapHandler() {
                @Override
                public void onEvent(DomReadyMapEvent event) {
                    setInfoWindowClass();
                }
            });

        }
    }

    private native void setInfoWindowClass() /*-{
        var infoWindows = $doc.getElementsByClassName("gm-style-iw");

        for (i = 0; i < infoWindows.length; i++) {
            var infoWindow = infoWindows[i];
            if (infoWindow.className.indexOf("gm-style-iw-cuba") >= 0) {
                continue;
            }
            infoWindow.className += " gm-style-iw-cuba";

            var rootInfoWindow = infoWindow.parentElement;
            var rootBubble = rootInfoWindow.firstChild;
            var closeBtn = rootInfoWindow.lastChild;
            rootInfoWindow.className = "gm-style-iw-cuba-root";
            rootBubble.className = "gm-style-iw-cuba-bubble";
            closeBtn.className = "gm-style-iw-cuba-close";

            var e = rootBubble.firstChild;
            e.className = "gm-style-iw-cuba-bubble-anchor-shadow";
            e.nextSibling.className = "gm-style-iw-cuba-bubble-shadow";
            e.nextSibling.nextSibling.className = "gm-style-iw-cuba-bubble-anchor";
            rootBubble.lastChild.className = "gm-style-iw-cuba-bubble";
        }
    }-*/;

    public void fitToBounds(LatLon boundsNE, LatLon boundsSW) {
        LatLng ne = LatLng.newInstance(boundsNE.getLat(), boundsNE.getLon());
        LatLng sw = LatLng.newInstance(boundsSW.getLat(), boundsSW.getLon());

        LatLngBounds bounds = LatLngBounds.newInstance(sw, ne);
        final LatLngBounds mapBounds = map.getBounds();
        if (mapBounds != null && mapBounds.equals(bounds)) {
            return;
        }
        map.fitBounds(bounds);
        updateBounds(false);
    }

    @Override
    public void onResize() {
        triggerResize();
    }

    public void setTrafficLayerVisible(boolean trafficLayerVisible) {
        if (trafficLayerVisible) {
            if (trafficLayer == null) {
                trafficLayer = TrafficLayer.newInstance();
            }
            trafficLayer.setMap(map);
        } else {
            if (trafficLayer != null) {
                trafficLayer.setMap(null);
            }
            trafficLayer = null;
        }
    }


    public void setInfoWindowContents(Map<Long, Widget> contents) {
        for(long id : contents.keySet()) {
            CustomInfoWindow win = infoWindowIDs.get(id);
            Widget w = contents.get(id);
            if(win != null && win.getContents() != w) {
                win.setContent(w);
            }
        }
    }
    public DrawingManager getDrawingManager() {
        return drawingManager;
    }

    public void setDrawingOptions(DrawingOptions vOptions) {
        if (vOptions == null) {
            if (drawingManager != null) {
                drawingManager.setMap(null);
                drawingManager = null;
            }
            return;
        }

        DrawingManagerOptions options = GoogleMapAdapterUtils.toDrawingManagerOptions(vOptions);

        final com.haulmont.charts.web.widgets.client.addons.googlemap.drawing.PolygonOptions vPolygonOptions = vOptions.getPolygonOptions();
        options.setPolygonOptions(GoogleMapAdapterUtils.toPolygonOptions(vPolygonOptions));

        final com.haulmont.charts.web.widgets.client.addons.googlemap.drawing.CircleOptions vCircleOptions = vOptions.getCircleOptions();
        options.setCircleOptions(GoogleMapAdapterUtils.toCircleOptions(vCircleOptions));

        drawingManager = DrawingManager.newInstance(options);
        drawingManager.setMap(map);

        drawingManager.addPolygonCompleteHandler(new PolygonCompleteMapHandler(vPolygonOptions));
        drawingManager.addCircleCompleteHandler(new CircleCompleteMapHandler(vCircleOptions));
    }

    private void attachPolygonEditListeners(final Polygon polygon, final GoogleMapPolygon vPolygon) {
        polygon.addClickHandler(new ClickMapHandler() {
            @Override
            public void onEvent(ClickMapEvent event) {
                Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
                    @Override
                    public void execute() {
                        polygonClickListener.polygonClicked(vPolygon);
                    }
                });
            }
        });
        polygon.addRightClickHandler(new RightClickMapHandler() {
            @Override
            public void onEvent(RightClickMapEvent rightClickMapEvent) {
                Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
                    @Override
                    public void execute() {
                        if (polygonRightClickListener != null) {
                            polygonRightClickListener.polygonRightClicked(vPolygon);
                        }
                    }
                });
            }
        });
        MVCArray path = polygon.getPath();
        if (path != null) {
            path.addInsertAtHandler(new InsertAtMapHandler() {
                @Override
                public void onEvent(final InsertAtMapEvent event) {
                    Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
                        @Override
                        public void execute() {
                            firePolygonEdited(polygon, vPolygon, event.getIndex(), INSERT);
                        }
                    });
                }
            });
            path.addSetAtHandler(new SetAtMapHandler() {
                @Override
                public void onEvent(final SetAtMapEvent event) {
                    Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
                        @Override
                        public void execute() {
                            firePolygonEdited(polygon, vPolygon, event.getIndex(), SET);
                        }
                    });
                }
            });
            path.addRemoveAtHandler(new RemoveAtMapHandler() {
                @Override
                public void onEvent(final RemoveAtMapEvent event) {
                    com.google.gwt.ajaxloader.client.Properties properties = event.getProperties();
                    Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
                        @Override
                        public void execute() {
                            firePolygonEdited(polygon, vPolygon, event.getIndex(), REMOVE);
                        }
                    });
                }
            });
        }
    }

    private void firePolygonEdited(Polygon polygon, GoogleMapPolygon
            vPolygon, int idx, PolygonEditListener.ActionType action) {
        LatLng latLng;

        if (REMOVE == action) {
            LatLon latLon = vPolygon.getCoordinates().get(idx);
            latLng = LatLng.newInstance(latLon.getLat(), latLon.getLon());
        } else {
            latLng = polygon.getPath().get(idx);
        }

        switch (action) {
            case INSERT:
                vPolygon.getCoordinates().add(idx, GoogleMapAdapterUtils.fromLatLng(latLng));
                break;
            case REMOVE:
                vPolygon.getCoordinates().remove(idx);
                break;
            case SET:
                LatLon existing = vPolygon.getCoordinates().get(idx);
                existing.setLat(latLng.getLatitude());
                existing.setLon(latLng.getLongitude());
                break;
        }
        polygonEditListener.polygonEdited(vPolygon, action, idx,
                new LatLon(latLng.getLatitude(), latLng.getLongitude()));
    }

    public void setMapTypes(List<String> mapTypeIds) {
        MapTypeControlOptions mapTypeControlOptions = mapOptions.getMapTypeControlOptions();
        if (mapTypeControlOptions == null) {
            mapTypeControlOptions = MapTypeControlOptions.newInstance();
        }
        mapTypeControlOptions.setMapTypeIds(mapTypeIds.toArray(new String[mapTypeIds.size()]));
        mapOptions.setMapTypeControlOptions(mapTypeControlOptions);
    }

    public void setLabels(Collection<GoogleMapLabel> labels) {
        removeAllLabels();

        for (GoogleMapLabel label : labels) {
            GoogleMapLabelOptions labelOptions = createLabelOptions(label);

            JavaScriptObject jsLabel = addLabel(labelOptions);

            labelsMap.put(label, jsLabel);
        }
    }

    protected GoogleMapLabelOptions createLabelOptions(GoogleMapLabel label) {
        GoogleMapLabelOptions options = GoogleMapLabelOptions.newInstance();

        options.setValue(label.getValue());

        LatLon position = label.getPosition();
        options.setPosition(LatLng.newInstance(position.getLat(), position.getLon()));
        options.setContentType(label.getContentType());

        options.setAdjustment(label.getAdjustment());
        options.setStyleName(label.getStyleName());

        return options;
    }

    protected void removeAllLabels() {
        for (JavaScriptObject jsLabel : labelsMap.values()) {
            removeLabel(jsLabel);
        }
        labelsMap.clear();
    }

    protected native void removeLabel(Object jsLabel) /*-{
        jsLabel.setMap(null);
    }-*/;

    protected native void initLabelOverlay() /*-{
        if ($wnd.LabelOverlay) {
            return;
        }

        $wnd.LabelOverlay = function(labelOptions, map) {
            this.value = labelOptions.value;
            this.contentType = labelOptions.contentType;

            this.position = labelOptions.position;
            this.adjustment = labelOptions.adjustment;
            this.styleName = labelOptions.styleName;

            this.div = null;
            this.innerDiv = null;

            this.setMap(map);
        };
        $wnd.LabelOverlay.prototype = new $wnd.google.maps.OverlayView();

        $wnd.LabelOverlay.prototype.onAdd = function() {
            var div = document.createElement('div');

            var primaryStylename = @com.haulmont.charts.web.widgets.client.addons.googlemap.overlays.GoogleMapLabel::getPrimaryStylename()();
            div.className = primaryStylename;
            div.style.position = 'absolute';
            this.div = div;

            var innerDiv = document.createElement('div');
            innerDiv.className = this.styleName;
            innerDiv.style.position = 'relative';
            this.innerDiv = innerDiv;

            div.appendChild(innerDiv);

            if (this.contentType == 'PLAIN_TEXT') {
                innerDiv.appendChild(document.createTextNode(this.value));
            } else {
                innerDiv.innerHTML = this.value;
            }

            var adjustmentClassName = this.adjustment.toLowerCase().replace('_', '-');
            innerDiv.className += ' ' + adjustmentClassName;

            var panes = this.getPanes();
            panes.overlayLayer.appendChild(div);
        };

        $wnd.LabelOverlay.prototype.onRemove = function() {
            this.div.parentNode.removeChild(this.div);
        };

        $wnd.LabelOverlay.prototype.draw = function() {
            var overlayProjection = this.getProjection();
            var pos = overlayProjection.fromLatLngToDivPixel(this.position);

            this.div.style.left = pos.x + 'px';
            this.div.style.top = pos.y + 'px';
        };
    }-*/;

    protected native JavaScriptObject addLabel(GoogleMapLabelOptions labelOptions)/*-{
        var map = this.@com.haulmont.charts.web.widgets.client.addons.googlemap.GoogleMapWidget::getMapImpl()();
        return new $wnd.LabelOverlay(labelOptions, map);
    }-*/;

    protected native String getMapTypeIdString()/*-{
        var map = this.@com.haulmont.charts.web.widgets.client.addons.googlemap.GoogleMapWidget::getMapImpl()();
        return map.mapTypeId;
    }-*/;

    protected MapImpl getMapImpl() {
        return mapImpl;
    }

    public void setRemoveMessage(String removeMessage) {
        this.removeMessage = removeMessage;
    }

    public String getRemoveMessage() {
        return removeMessage;
    }

    protected void removeVertex(GoogleMapPolygon polygon, LatLon vertex) {
        Polygon vPolygon = null;
        for (Map.Entry<Polygon, GoogleMapPolygon> entry : polygonMap.entrySet()) {
            if (entry.getValue().equals(polygon)) {
                vPolygon = entry.getKey();
                break;
            }
        }
        if (vPolygon == null)
            return;

        LatLng latLng = LatLng.newInstance(vertex.getLat(), vertex.getLon());
        Integer idx = null;
        MVCArray<LatLng> path = vPolygon.getPath();
        for (int i = 0; i < path.getLength(); i++) {
            if (latLng.equals(path.get(i))) {
                idx = i;
                break;
            }
        }
        if (idx != null) {
            path.removeAt(idx);
        }
    }

    protected void setVertexRemovingEnabled(boolean vertexRemovingEnabled) {
        this.vertexRemovingEnabled = vertexRemovingEnabled;
    }

    protected boolean isVertexRemovingEnabled() {
        return vertexRemovingEnabled;
    }

    private class PolygonCompleteMapHandler implements
            com.google.gwt.maps.client.events.overlaycomplete.polygon.PolygonCompleteMapHandler {

        private final com.haulmont.charts.web.widgets.client.addons.googlemap.drawing.PolygonOptions polygonOptions;

        public PolygonCompleteMapHandler(com.haulmont.charts.web.widgets.client.addons.googlemap.drawing.PolygonOptions polygonOptions) {
            this.polygonOptions = polygonOptions;
        }

        @Override
        public void onEvent(PolygonCompleteMapEvent event) {
            Polygon polygon = event.getPolygon();

            JsArray<LatLng> polygonCoordinates = polygon.getPath().getArray();
            List<LatLon> googlePolygonCoordinates =
                    new ArrayList<LatLon>(polygonCoordinates.length() * 2);

            for (int i = 0; i < polygonCoordinates.length(); i++) {
                LatLng latLng = polygonCoordinates.get(i);
                googlePolygonCoordinates.add(new LatLon(latLng.getLatitude(),
                        latLng.getLongitude()));
            }

            GoogleMapPolygon vPolygon = new GoogleMapPolygon();
            vPolygon.setCoordinates(googlePolygonCoordinates);

            if (polygonOptions != null) {
                vPolygon.setFillColor(polygonOptions.getFillColor());
                vPolygon.setFillOpacity(polygonOptions.getFillOpacity());
                vPolygon.setGeodesic(polygonOptions.isGeodesic());
                vPolygon.setStrokeColor(polygonOptions.getStrokeColor());
                vPolygon.setStrokeOpacity(polygonOptions.getStrokeOpacity());
                vPolygon.setStrokeWeight(polygonOptions.getStrokeWeight());
                vPolygon.setStrokeColor(polygonOptions.getStrokeColor());
                vPolygon.setzIndex(polygonOptions.getZIndex());
                vPolygon.setStrokeColor(polygonOptions.getStrokeColor());
            }
            vPolygon.setEditable(polygon.getEditable());
            polygonMap.put(polygon, vPolygon);
            attachPolygonEditListeners(polygon, vPolygon);
            polygonCompleteListener.polygonComplete(vPolygon);
        }
    }

    private class CircleCompleteMapHandler implements
            com.google.gwt.maps.client.events.overlaycomplete.circle.CircleCompleteMapHandler {

        private final com.haulmont.charts.web.widgets.client.addons.googlemap.drawing.CircleOptions circleOptions;

        public CircleCompleteMapHandler(com.haulmont.charts.web.widgets.client.addons.googlemap.drawing.CircleOptions circleOptions) {
            this.circleOptions = circleOptions;
        }

        @Override
        public void onEvent(CircleCompleteMapEvent event) {
            Circle circle = event.getCircle();

            GoogleMapCircle vCircle = new GoogleMapCircle();
            vCircle.setRadius(circle.getRadius());
            vCircle.setCenter(GoogleMapAdapterUtils.fromLatLng(circle.getCenter()));

            if (circleOptions != null) {
                vCircle.setFillColor(circleOptions.getFillColor());
                vCircle.setFillOpacity(circleOptions.getFillOpacity());
                vCircle.setStrokeColor(circleOptions.getStrokeColor());
                vCircle.setStrokeOpacity(circleOptions.getStrokeOpacity());
                vCircle.setStrokeWeight(circleOptions.getStrokeWeight());
                vCircle.setStrokeColor(circleOptions.getStrokeColor());
                vCircle.setzIndex(circleOptions.getZIndex());
                vCircle.setStrokeColor(circleOptions.getStrokeColor());
            }

            vCircle.setEditable(circle.getEditable());
            circleMap.put(circle, vCircle);
            attachCircleListeners(circle);
            circleCompleteListener.circleComplete(vCircle);
        }
    }

    native public void consoleLog(String message) /*-{
      console.log(message);
    }-*/;

    private class GoogleDirectionsResultHandler implements com.google.gwt.maps.client.services.DirectionsResultHandler {
        private final long id;
        private long requestId;

        public GoogleDirectionsResultHandler(long id) {
            this.id = id;
            requestId = id;
        }

        @Override
        public void onCallback(DirectionsResult result, DirectionsStatus status) {
            consoleLog("Callback for direction request with id " + requestId);
            directionsResultHandler.handle(id,
                    GoogleMapAdapterUtils.fromDirectionsResult(result),
                    GoogleMapAdapterUtils.fromDirectionsStatus(status));
        }
    }

    //Haulmont API
    protected Map<Marker, GoogleMapMarker> getMarkerMap() {
        return markerMap;
    }
}