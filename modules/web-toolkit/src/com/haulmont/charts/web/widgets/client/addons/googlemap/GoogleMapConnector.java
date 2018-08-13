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

import com.google.gwt.ajaxloader.client.AjaxLoader;
import com.google.gwt.core.client.GWT;
import com.google.gwt.maps.client.LoadApi;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.user.client.ui.Widget;

import com.haulmont.charts.web.widgets.client.addons.googlemap.events.*;
import com.haulmont.charts.web.widgets.client.addons.googlemap.rpcs.*;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentContainerConnector;
import com.vaadin.client.ui.layout.ElementResizeEvent;
import com.vaadin.client.ui.layout.ElementResizeListener;
import com.vaadin.shared.ui.Connect;
import com.haulmont.charts.web.widgets.addons.googlemap.GoogleMap;
import com.haulmont.charts.web.widgets.client.addons.googlemap.base.LatLon;
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
import com.haulmont.charts.web.widgets.client.addons.googlemap.overlays.GoogleMapCircle;
import com.haulmont.charts.web.widgets.client.addons.googlemap.overlays.GoogleMapInfoWindow;
import com.haulmont.charts.web.widgets.client.addons.googlemap.overlays.GoogleMapMarker;
import com.haulmont.charts.web.widgets.client.addons.googlemap.overlays.GoogleMapPolygon;
import com.haulmont.charts.web.widgets.client.addons.googlemap.rpcs.centerchange.CircleCenterChangeRpc;
import com.haulmont.charts.web.widgets.client.addons.googlemap.rpcs.click.CircleClickedRpc;
import com.haulmont.charts.web.widgets.client.addons.googlemap.rpcs.click.MapClickedRpc;
import com.haulmont.charts.web.widgets.client.addons.googlemap.rpcs.click.MarkerClickedRpc;
import com.haulmont.charts.web.widgets.client.addons.googlemap.rpcs.click.PolygonClickedRpc;
import com.haulmont.charts.web.widgets.client.addons.googlemap.rpcs.doubleclick.CircleDoubleClickRpc;
import com.haulmont.charts.web.widgets.client.addons.googlemap.rpcs.doubleclick.MarkerDoubleClickedRpc;
import com.haulmont.charts.web.widgets.client.addons.googlemap.rpcs.overlaycomplete.CircleCompleteRpc;
import com.haulmont.charts.web.widgets.client.addons.googlemap.rpcs.overlaycomplete.PolygonCompleteRpc;
import com.haulmont.charts.web.widgets.client.addons.googlemap.rpcs.radiuschange.CircleRadiusChangeRpc;
import com.haulmont.charts.web.widgets.client.addons.googlemap.rpcs.rightclick.CircleRightClickedRpc;
import com.haulmont.charts.web.widgets.client.addons.googlemap.rpcs.rightclick.MapRightClickedRpc;
import com.haulmont.charts.web.widgets.client.addons.googlemap.rpcs.rightclick.MarkerRightClickedRpc;
import com.haulmont.charts.web.widgets.client.addons.googlemap.rpcs.rightclick.PolygonRightClickedRpc;
import com.haulmont.charts.web.widgets.client.addons.googlemap.services.DirectionsResult;
import com.haulmont.charts.web.widgets.client.addons.googlemap.services.DirectionsStatus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Connect(GoogleMap.class)
public class GoogleMapConnector extends AbstractComponentContainerConnector implements
        MarkerClickListener, MarkerDoubleClickListener, MarkerDragListener, MarkerRightClickListener,
        MapMoveListener, MapClickListener, MapInitListener, MapRightClickListener,
        PolygonCompleteListener, PolygonEditListener, PolygonClickListener, PolygonRightClickListener,
        CircleClickListener, CircleDoubleClickListener, CircleCompleteListener, CircleRadiusChangeListener,
        CircleCenterChangeListener, CircleRightClickListener, DirectionsResultHandler, InfoWindowClosedListener,
        MapTypeChangeListener {

    private static final long serialVersionUID = -357262975672050103L;

    public static boolean loadingApi = false;
    protected static boolean apiLoaded = false;

    private final List<GoogleMapInitListener> initListeners = new ArrayList<GoogleMapInitListener>();

    private boolean deferred = false;

    private InfoWindowClosedRpc infoWindowClosedRpc = RpcProxy.create(InfoWindowClosedRpc.class, this);
    private HandleDirectionsResultRpc handleDirectionsResultRpc = RpcProxy.create(HandleDirectionsResultRpc.class, this);

    private MarkerClickedRpc markerClickedRpc = RpcProxy.create(MarkerClickedRpc.class, this);
    private MarkerDoubleClickedRpc markerDoubleClickedRpc = RpcProxy.create(MarkerDoubleClickedRpc.class, this);
    private MarkerRightClickedRpc markerRightClickedRpc = RpcProxy.create(MarkerRightClickedRpc.class, this);
    private MarkerDraggedRpc markerDraggedRpc = RpcProxy.create(MarkerDraggedRpc.class, this);

    private MapClickedRpc mapClickRpc = RpcProxy.create(MapClickedRpc.class, this);
    private MapRightClickedRpc mapRightClickedRpc = RpcProxy.create(MapRightClickedRpc.class, this);
    private MapMovedRpc mapMovedRpc = RpcProxy.create(MapMovedRpc.class, this);
    private MapInitRpc mapInitRpc = RpcProxy.create(MapInitRpc.class, this);

    private PolygonClickedRpc polygonClickedRpc = RpcProxy.create(PolygonClickedRpc.class, this);
    private PolygonRightClickedRpc polygonRightClickedRpc = RpcProxy.create(PolygonRightClickedRpc.class, this);
    private PolygonCompleteRpc polygonCompleteRpc = RpcProxy.create(PolygonCompleteRpc.class, this);
    private PolygonEditRpc polygonEditRpc = RpcProxy.create(PolygonEditRpc.class, this);

    private CircleClickedRpc circleClickedRpc = RpcProxy.create(CircleClickedRpc.class, this);
    private CircleDoubleClickRpc circleDoubleClickRpc = RpcProxy.create(CircleDoubleClickRpc.class, this);
    private CircleRightClickedRpc circleRightClickedRpc = RpcProxy.create(CircleRightClickedRpc.class, this);
    private CircleCenterChangeRpc circleCenterChangeRpc = RpcProxy.create(CircleCenterChangeRpc.class, this);
    private CircleRadiusChangeRpc circleRadiusChangeRpc = RpcProxy.create(CircleRadiusChangeRpc.class, this);
    private CircleCompleteRpc circleCompleteRpc = RpcProxy.create(CircleCompleteRpc.class, this);
    private final MapTypeChangedRpc mapTypeChangedRpc = RpcProxy.create(MapTypeChangedRpc.class, this);

    public GoogleMapConnector() {
        registerRpc(PolygonRemoveVertexRpc.class, new PolygonRemoveVertexRpc() {
            @Override
            public void removeVertex(GoogleMapPolygon polygon, LatLon vertex) {
                getWidget().removeVertex(polygon, vertex);
            }
        });
    }

    private void initMap() {
        final GoogleMapWidget googleMap = getWidget();

        googleMap.initMap(getState().center, getState().zoom, getState().mapTypeId, this);
        googleMap.setRemoveMessage(getState().removeMessage);
        googleMap.setVertexRemovingEnabled(getState().vertexRemovingEnabled);

        googleMap.setMarkerClickListener(this);
        googleMap.setMarkerDoubleClickListener(this);
        googleMap.setMarkerRightClickListener(this);
        googleMap.setMarkerDragListener(this);

        googleMap.setMapClickListener(this);
        googleMap.setMapRightClickListener(this);
        googleMap.setMapMoveListener(this);
        googleMap.setMapTypeChangeListener(this);

        googleMap.setInfoWindowClosedListener(this);
        googleMap.setDirectionsResultHandler(this);

        googleMap.setPolygonClickListener(this);
        googleMap.setPolygonRightClickListener(this);
        googleMap.setPolygonCompleteListener(this);
        googleMap.setPolygonEditListener(this);

        googleMap.setCircleClickListener(this);
        googleMap.setCircleDoubleClickListener(this);
        googleMap.setCircleRightClickListener(this);
        googleMap.setCircleCompleteListener(this);
        googleMap.setCircleCenterChangeListener(this);
        googleMap.setCircleRadiusChangeListener(this);
        getLayoutManager().addElementResizeListener(googleMap.getElement(),
                new ElementResizeListener() {
                    @Override
                    public void onElementResize(ElementResizeEvent e) {
                        googleMap.triggerResize();
                    }
                });
        MapWidget map = googleMap.getMap();
        if (deferred) {
            forceStateChange();
            deferred = false;
        }
        for (GoogleMapInitListener listener : initListeners) {
            listener.mapWidgetInitiated(map);
        }
    }

    protected void loadMapApi() {
        if (loadingApi) {
            return;
        }
        loadingApi = true;
        ArrayList<LoadApi.LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
        loadLibraries.add(LoadApi.LoadLibrary.DRAWING);
        loadLibraries.add(LoadApi.LoadLibrary.VISUALIZATION);

        Runnable onLoad = new Runnable() {
            @Override
            public void run() {
                apiLoaded = true;
                loadingApi = false;
                for (GoogleMapInitListener listener : initListeners) {
                    listener.mapsApiLoaded();
                }
                initMap();
            }
        };

        LoadApi.Language language = null;
        if (getState().language != null) {
            language = LoadApi.Language.fromValue(getState().language);
        }

        String params = null;
        if (getState().clientId != null) {
            params = "client=" + getState().clientId;
        } else if (getState().apiKey != null) {
            params = "key=" + getState().apiKey;
        }

        if (getState().apiUrl != null) {
            AjaxLoader.init(getState().apiKey, getState().apiUrl);
        }

        load(onLoad, loadLibraries, language, getState().mapsApiVersion, params);
    }

    private static void load(Runnable onLoad, ArrayList<LoadApi.LoadLibrary> loadLibraries, LoadApi.Language language,
                             String mapsApiVersion, String otherParams) {
        String op = "";
        if (otherParams != null) {
            op = op + "&" + otherParams;
        }

        if (loadLibraries != null) {
            op = op + "&" + getLibraries(loadLibraries);
        }

        if (language != null) {
            op = op + "&language=" + language.getValue();
        }

        AjaxLoader.AjaxLoaderOptions settings = AjaxLoader.AjaxLoaderOptions.newInstance();
        settings.setOtherParms(op);
        AjaxLoader.loadApi("maps", mapsApiVersion, onLoad, settings);
    }

    private static String getLibraries(ArrayList<LoadApi.LoadLibrary> loadLibraries) {
        if (loadLibraries == null) {
            return "";
        } else {
            StringBuilder s = new StringBuilder("libraries=");
            Iterator itr = loadLibraries.iterator();
            int i = 0;

            while (itr.hasNext()) {
                LoadApi.LoadLibrary ll = (LoadApi.LoadLibrary) itr.next();
                if (ll != null) {
                    if (i > 0) {
                        s.append(",");
                    }

                    s.append(ll.value());
                    ++i;
                }
            }

            return s.toString();
        }
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        if (!apiLoaded) {
            deferred = true;
            loadMapApi();
            return;
        } else if (getWidget().getMap() == null) {
            deferred = true;
            initMap();
            return;
        }

        updateVisibleAreaAndCenterBoundLimits();

        GoogleMapWidget googleMap = getWidget();

        if (stateChangeEvent.hasPropertyChanged("center")) {
            LatLng center = LatLng.newInstance(getState().center.getLat(),
                    getState().center.getLon());
            googleMap.setCenter(center);
        }

        if (stateChangeEvent.hasPropertyChanged("zoom")) {
            googleMap.setZoom(getState().zoom);
        }

        if (stateChangeEvent.hasPropertyChanged("trafficLayerVisible")) {
            googleMap.setTrafficLayerVisible(getState().trafficLayerVisible);
        }

        if (stateChangeEvent.hasPropertyChanged("markers")) {
            googleMap.setMarkers(getState().markers.values());
        }

        if (stateChangeEvent.hasPropertyChanged("labels")) {
            googleMap.setLabels(getState().labels.values());
        }

        if (stateChangeEvent.hasPropertyChanged("polygons")) {
            googleMap.setPolygonOverlays(getState().polygons);
        }

        if (stateChangeEvent.hasPropertyChanged("polylines")) {
            googleMap.setPolylineOverlays(getState().polylines);
        }

        if (stateChangeEvent.hasPropertyChanged("circles")) {
            googleMap.setCircleOverlays(getState().circles);
        }

        if (stateChangeEvent.hasPropertyChanged("kmlLayers")) {
            googleMap.setKmlLayers(getState().kmlLayers);
        }

        if (stateChangeEvent.hasPropertyChanged("heatMapLayers")) {
            googleMap.setHeatMapLayers(getState().heatMapLayers);
        }

        if (stateChangeEvent.hasPropertyChanged("imageMapTypes")) {
            googleMap.setImageMapTypes(getState().imageMapTypes);
        }

        if (stateChangeEvent.hasPropertyChanged("overlayImageMapTypes")) {
            googleMap.setOverlayImageMapTypes(getState().overlayImageMapTypes);
        }

        if (stateChangeEvent.hasPropertyChanged("infoWindows")) {
            googleMap.setInfoWindows(getState().infoWindows.values());
        }

        if (stateChangeEvent.hasPropertyChanged("mapTypeIds")) {
            googleMap.setMapTypes(getState().mapTypeIds);
        }

        if (stateChangeEvent.hasPropertyChanged("mapTypeId")) {
            googleMap.setMapType(getState().mapTypeId);
        }

        if (stateChangeEvent.hasPropertyChanged("controls")) {
            googleMap.setControls(getState().controls);
        }

        if (stateChangeEvent.hasPropertyChanged("draggable")) {
            googleMap.setDraggable(getState().draggable);
        }

        if (stateChangeEvent.hasPropertyChanged("keyboardShortcutsEnabled")) {
            googleMap.setKeyboardShortcutsEnabled(getState().keyboardShortcutsEnabled);
        }

        if (stateChangeEvent.hasPropertyChanged("minZoom")) {
            googleMap.setMinZoom(getState().minZoom);
        }

        if (stateChangeEvent.hasPropertyChanged("maxZoom")) {
            googleMap.setMaxZoom(getState().maxZoom);
        }

        if (stateChangeEvent.hasPropertyChanged("scrollWheelEnabled")) {
            googleMap.setScrollWheelEnabled(getState().scrollWheelEnabled);
        }

        if (stateChangeEvent.hasPropertyChanged("drawingOptions")) {
            googleMap.setDrawingOptions(getState().drawingOptions);
        }

        if (stateChangeEvent.hasPropertyChanged("directionsRequests")) {
            googleMap.processDirectionRequests(getState().directionsRequests.values());
        }

        if (stateChangeEvent.hasPropertyChanged("vertexRemovingEnabled")) {
            googleMap.setVertexRemovingEnabled(getState().vertexRemovingEnabled);
        }

        if (stateChangeEvent.hasPropertyChanged("removeMessage")) {
            googleMap.setRemoveMessage(getState().removeMessage);
        }

        if (stateChangeEvent.hasPropertyChanged("fitToBoundsNE")) {
            if (getState().fitToBoundsNE != null && getState().fitToBoundsSW != null) {
                googleMap.fitToBounds(getState().fitToBoundsNE, getState().fitToBoundsSW);
            }
        }

        if (stateChangeEvent.isInitialStateChange()) {
            googleMap.triggerResize();
        }
        onConnectorHierarchyChange(null);
    }

    protected void updateVisibleAreaAndCenterBoundLimits() {
        if (getState().limitCenterBounds) {
            getWidget().setCenterBoundLimits(getState().centerNELimit,
                    getState().centerSWLimit);
        } else {
            getWidget().clearCenterBoundLimits();
        }

        if (getState().limitVisibleAreaBounds) {
            getWidget().setVisibleAreaBoundLimits(getState().visibleAreaNELimit,
                    getState().visibleAreaSWLimit);
        } else {
            getWidget().clearVisibleAreaBoundLimits();
        }
    }

    @Override
    protected Widget createWidget() {
        return GWT.create(GoogleMapWidget.class);
    }

    @Override
    public void markerDoubleClicked(GoogleMapMarker clickedMarker) {
        if (isEnabled()) {
            markerDoubleClickedRpc.markerClicked(clickedMarker.getId());
        }
    }

    @Override
    public GoogleMapWidget getWidget() {
        return (GoogleMapWidget) super.getWidget();
    }

    @Override
    public void init(LatLon center, int zoom, LatLon boundsNE, LatLon boundsSW) {
        if (isEnabled()) {
            mapInitRpc.init(center, zoom, boundsNE, boundsSW);
        }
    }

    @Override
    public GoogleMapState getState() {
        return (GoogleMapState) super.getState();
    }

    @Override
    public void infoWindowClosed(GoogleMapInfoWindow window) {
        if (isEnabled()) {
            infoWindowClosedRpc.infoWindowClosed(window.getId());
        }
    }

    @Override
    public void markerDragged(GoogleMapMarker draggedMarker,
                              LatLon oldPosition) {
        if (isEnabled()) {
            markerDraggedRpc.markerDragged(draggedMarker.getId(),
                    draggedMarker.getPosition());
        }
    }

    @Override
    public void polygonComplete(GoogleMapPolygon polygon) {
        if (isEnabled()) {
            polygonCompleteRpc.polygonComplete(polygon);
        }
    }

    @Override
    public void mapClicked(LatLon position) {
        if (isEnabled()) {
            mapClickRpc.mapClicked(position);
        }
    }

    @Override
    public void mapMoved(int zoomLevel, LatLon center, LatLon boundsNE,
                         LatLon boundsSW) {
        if (isEnabled()) {
            mapMovedRpc.mapMoved(zoomLevel, center, boundsNE, boundsSW);
        }
    }

    @Override
    public void markerClicked(GoogleMapMarker clickedMarker) {
        if (isEnabled()) {
            markerClickedRpc.markerClicked(clickedMarker.getId());
        }
    }

    @Override
    public void mapTypeChanged(String mapTypeId) {
        if (!getState().mapTypeId.toLowerCase().equals(mapTypeId)) {
            mapTypeChangedRpc.mapTypeChanged(mapTypeId);
        }
    }

    public void addInitListener(GoogleMapInitListener listener) {
        if (apiLoaded) {
            listener.mapsApiLoaded();
        }
        if (getWidget().getMap() != null) {
            listener.mapWidgetInitiated(getWidget().getMap());
        }
        initListeners.add(listener);
    }

    @Override
    public void onConnectorHierarchyChange(
            ConnectorHierarchyChangeEvent connectorHierarchyChangeEvent) {
        Map<Long, Widget> infoWindowContents = new HashMap<>();
        List<ComponentConnector> children = getChildComponents();
        for (ComponentConnector connector : children) {
            for (String style : connector.getState().styles) {
                if (style.startsWith("content-for-infowindow-")) {
                    String identifier = style
                            .replace("content-for-infowindow-", "");
                    Long id = Long.parseLong(identifier);
                    infoWindowContents.put(id, connector.getWidget());
                    getWidget().setInfoWindowContents(infoWindowContents);
                }
            }
        }
    }

    @Override
    public void updateCaption(ComponentConnector connector) {

    }

    @Override
    public void polygonEdited(GoogleMapPolygon polygon, ActionType actionType, int idx, LatLon latLon) {
        if (isEnabled()) {
            polygonEditRpc.polygonEdited(polygon.getId(), actionType, idx, latLon);
        }
    }

    @Override
    public void polygonClicked(GoogleMapPolygon polygon) {
        if (isEnabled()) {
            polygonClickedRpc.polygonClicked(polygon.getId());
        }
    }

    @Override
    public void handle(long requestId, DirectionsResult result, DirectionsStatus status) {
        if (isEnabled()) {
            handleDirectionsResultRpc.handle(result, status, requestId);
        }
    }

    @Override
    public void radiusChange(GoogleMapCircle circle, double oldRadius) {
        if (isEnabled()) {
            circleRadiusChangeRpc.radiusChanged(circle.getId(), circle.getRadius());
        }
    }

    @Override
    public void circleDoubleClicked(GoogleMapCircle circle) {
        if (isEnabled()) {
            circleDoubleClickRpc.circleDoubleClicked(circle.getId());
        }
    }

    @Override
    public void circleComplete(GoogleMapCircle circle) {
        if (isEnabled()) {
            circleCompleteRpc.circleComplete(circle);
        }
    }

    @Override
    public void circleClicked(GoogleMapCircle clickedCircle) {
        if (isEnabled()) {
            circleClickedRpc.circleClicked(clickedCircle.getId());
        }
    }

    @Override
    public void centerChanged(GoogleMapCircle circle, LatLon oldCenter) {
        if (isEnabled()) {
            circleCenterChangeRpc.centerChanged(circle.getId(), circle.getCenter());
        }
    }

    @Override
    public void mapRightClicked(LatLon position) {
        if (isEnabled()) {
            mapRightClickedRpc.mapRightClicked(position);
        }
    }

    @Override
    public void circleRightClicked(GoogleMapCircle circle) {
        if (isEnabled()) {
            circleRightClickedRpc.circleRightClicked(circle.getId());
        }
    }

    @Override
    public void markerRightClicked(GoogleMapMarker marker) {
        if (isEnabled()) {
            markerRightClickedRpc.markerRightClicked(marker.getId());
        }
    }

    @Override
    public void polygonRightClicked(GoogleMapPolygon polygon) {
        if (isEnabled()) {
            polygonRightClickedRpc.polygonRightClicked(polygon.getId());
        }
    }
}