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

import com.haulmont.charts.gui.map.model.Bounds;
import com.haulmont.charts.gui.map.model.GeoPoint;

import java.util.List;

public interface DirectionsRoute {
    Bounds getBounds();
    void setBounds(Bounds bounds);

    String getCopyrights();
    void setCopyrights(String copyrights);

    List<DirectionsLeg> getLegs();
    void setLegs(List<DirectionsLeg> legs);

    List<GeoPoint> getOverviewPath();
    void setOverviewPath(List<GeoPoint> overviewPath);

    String[] getWarnings();
    void setWarnings(String[] warnings);

    int[] getWaypointOrder();
    void setWaypointOrder(int[] waypointOrder);
}