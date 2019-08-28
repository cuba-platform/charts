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

import com.haulmont.charts.web.widgets.client.addons.googlemap.base.LatLon;
import com.haulmont.charts.web.widgets.client.addons.googlemap.drawing.DrawingOptions;
import com.haulmont.charts.web.widgets.client.addons.googlemap.layers.GoogleMapHeatMapLayer;
import com.haulmont.charts.web.widgets.client.addons.googlemap.layers.GoogleMapKmlLayer;
import com.haulmont.charts.web.widgets.client.addons.googlemap.maptypes.GoogleImageMapType;
import com.haulmont.charts.web.widgets.client.addons.googlemap.overlays.*;
import com.haulmont.charts.web.widgets.client.addons.googlemap.services.DirectionsRequest;
import com.vaadin.shared.ui.AbstractComponentContainerState;

import java.util.*;

/**
 * The shared state of the Google Maps. Contains also the default values.
 */
public class GoogleMapState extends AbstractComponentContainerState {
    private static final long serialVersionUID = 646346522643L;

    public String apiKey = null;
    public String clientId = null;

    // defaults to the language setting of the browser
    public String language = null;
    public String mapTypeId = "Roadmap";
    public List<String> mapTypeIds = Arrays.asList("Roadmap", "Terrain", "Satellite");
    public LatLon center = new LatLon(51.477811, -0.001475);
    public LatLon boundNE = null;
    public LatLon boundSW = null;
    public int zoom = 8;
    public int maxZoom = 21;
    public int minZoom = 0;

    public String removeMessage = "Remove";
    public boolean vertexRemovingEnabled = false;

    public boolean draggable = true;
    public boolean keyboardShortcutsEnabled = true;
    public boolean scrollWheelEnabled = true;

    public boolean supportDrawing = false;

    public DrawingOptions drawingOptions = null;

    public Set<GoogleMapControl> controls = new HashSet<GoogleMapControl>(
            Arrays.asList(GoogleMapControl.MapType, GoogleMapControl.Pan,
                    GoogleMapControl.Rotate, GoogleMapControl.Scale,
                    GoogleMapControl.StreetView, GoogleMapControl.Zoom,
                    GoogleMapControl.Fullscreen));

    public boolean limitCenterBounds = false;
    public LatLon centerSWLimit = new LatLon(0.0, 0.0);
    public LatLon centerNELimit = new LatLon(0.0, 0.0);

    public boolean limitVisibleAreaBounds = false;
    public LatLon visibleAreaSWLimit = new LatLon(0.0, 0.0);
    public LatLon visibleAreaNELimit = new LatLon(0.0, 0.0);

    public LatLon fitToBoundsNE = null;
    public LatLon fitToBoundsSW = null;

    public Set<GoogleMapPolyline> polylines = new HashSet<GoogleMapPolyline>();
    public Set<GoogleMapKmlLayer> kmlLayers = new HashSet<GoogleMapKmlLayer>();
    public Set<GoogleMapHeatMapLayer> heatMapLayers = new HashSet<GoogleMapHeatMapLayer>();
    public Set<GoogleImageMapType> imageMapTypes = new LinkedHashSet<GoogleImageMapType>();
    public Set<GoogleImageMapType> overlayImageMapTypes = new LinkedHashSet<GoogleImageMapType>();

    public Map<Long, DirectionsRequest> directionsRequests = new HashMap<Long, DirectionsRequest>();

    public Map<Long, GoogleMapMarker> markers = new HashMap<Long, GoogleMapMarker>();

    public Map<Long, GoogleMapInfoWindow> infoWindows = new HashMap<Long, GoogleMapInfoWindow>();
    public boolean trafficLayerVisible = false;

    public Map<Long, GoogleMapPolygon> polygons = new HashMap<Long, GoogleMapPolygon>();

    public Map<Long, GoogleMapCircle> circles = new HashMap<Long, GoogleMapCircle>();

    public Map<Long, GoogleMapLabel> labels = new HashMap<Long, GoogleMapLabel>();

    public String apiUrl = null;
    public String mapsApiVersion = "3.38";

    public Map<Long, String> infoWindowContentIdentifiers = new HashMap<>();
}