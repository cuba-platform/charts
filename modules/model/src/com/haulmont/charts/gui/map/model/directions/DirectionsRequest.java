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

package com.haulmont.charts.gui.map.model.directions;

import com.haulmont.charts.gui.map.model.GeoPoint;

import java.util.List;

public interface DirectionsRequest {
    List<DirectionsWaypoint> getWaypoints();
    void setWaypoints(List<DirectionsWaypoint> waypoints);

    boolean isAvoidHighways();
    void setAvoidHighways(boolean avoidHighways);

    boolean isAvoidTolls();
    void setAvoidTolls(boolean avoidTolls);

    boolean isOptimizeWaypoints();
    void setOptimizeWaypoints(boolean optimizeWaypoints);

    boolean isProvideRouteAlternatives();
    void setProvideRouteAlternatives(boolean provideRouteAlternatives);

    GeoPoint getOrigin();
    void setOrigin(GeoPoint origin);

    GeoPoint getDestination();
    void setDestination(GeoPoint destination);

    String getRegion();
    void setRegion(String region);

    TravelMode getTravelMode();
    void setTravelMode(TravelMode travelMode);

    UnitSystem getUnitSystem();
    void setUnitSystem(UnitSystem unitSystem);
}