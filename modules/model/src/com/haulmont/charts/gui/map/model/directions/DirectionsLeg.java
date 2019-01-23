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

public interface DirectionsLeg {
    Distance getDistance();

    void setDistance(Distance distance);

    Duration getDuration();

    void setDuration(Duration duration);

    String getStartAddress();

    void setStartAddress(String startAddress);

    String getEndAddress();

    void setEndAddress(String endAddress);

    GeoPoint getStartLocation();

    void setStartLocation(GeoPoint startLocation);

    List<DirectionsStep> getSteps();

    void setSteps(List<DirectionsStep> steps);

    List<GeoPoint> getViaWaypoints();

    void setViaWaypoints(List<GeoPoint> viaWaypoints);

    GeoPoint getEndLocation();

    void setEndLocation(GeoPoint endLocation);
}
