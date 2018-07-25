/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.map.google.directions;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.charts.gui.map.model.GeoPoint;
import com.haulmont.charts.gui.map.model.directions.DirectionsLeg;
import com.haulmont.charts.gui.map.model.directions.DirectionsStep;
import com.haulmont.charts.gui.map.model.directions.Distance;
import com.haulmont.charts.gui.map.model.directions.Duration;
import com.haulmont.charts.web.gui.components.map.google.DelegateHelper;
import com.haulmont.charts.web.gui.components.map.google.GeoPointDelegate;

import java.util.List;

public class DirectionsLegDelegate implements DirectionsLeg {

    private com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.services.DirectionsLeg directionsLeg;

    public static DirectionsLegDelegate fromDirectionsLeg(com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.services.DirectionsLeg leg) {
        return leg != null ? new DirectionsLegDelegate(leg) : null;
    }

    public DirectionsLegDelegate(com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.services.DirectionsLeg directionsLeg) {
        Preconditions.checkNotNullArgument(directionsLeg);
        this.directionsLeg = directionsLeg;
    }

    public com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.services.DirectionsLeg getDirectionsLeg() {
        return directionsLeg;
    }

    public void setDirectionsLeg(com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.services.DirectionsLeg directionsLeg) {
        this.directionsLeg = directionsLeg;
    }

    @Override
    public Distance getDistance() {
        return DistanceDelegate.fromDistance(directionsLeg.getDistance());
    }

    @Override
    public void setDistance(Distance distance) {
        directionsLeg.setDistance(distance != null ? ((DistanceDelegate)distance).getDistance() : null);
    }

    @Override
    public Duration getDuration() {
        return DurationDelegate.fromDuration(directionsLeg.getDuration());
    }

    @Override
    public void setDuration(Duration duration) {
        directionsLeg.setDuration(duration != null ? ((DurationDelegate) duration).getDuration() : null);
    }

    @Override
    public String getStartAddress() {
        return directionsLeg.getStartAddress();
    }

    @Override
    public void setStartAddress(String startAddress) {
        directionsLeg.setStartAddress(startAddress);
    }

    @Override
    public String getEndAddress() {
        return directionsLeg.getEndAddress();
    }

    @Override
    public void setEndAddress(String endAddress) {
        directionsLeg.setEndAddress(endAddress);
    }

    @Override
    public GeoPoint getStartLocation() {
        return GeoPointDelegate.fromLatLon(directionsLeg.getStartLocation());
    }

    @Override
    public void setStartLocation(GeoPoint startLocation) {
        directionsLeg.setStartLocation(startLocation != null ? ((GeoPointDelegate)startLocation).getLatLon() : null);
    }

    @Override
    public List<DirectionsStep> getSteps() {
        return DelegateHelper.toCubaDirectionsSteps(directionsLeg.getSteps());
    }

    @Override
    public void setSteps(List<DirectionsStep> steps) {
        directionsLeg.setSteps(DelegateHelper.toGoogleDirectionsSteps(steps));
    }

    @Override
    public List<GeoPoint> getViaWaypoints() {
        return DelegateHelper.toGeoPoints(directionsLeg.getViaWaypoints());
    }

    @Override
    public void setViaWaypoints(List<GeoPoint> viaWaypoints) {
        directionsLeg.setViaWaypoints(DelegateHelper.toLatLon(viaWaypoints));
    }

    @Override
    public GeoPoint getEndLocation() {
        return GeoPointDelegate.fromLatLon(directionsLeg.getEndLocation());
    }

    @Override
    public void setEndLocation(GeoPoint endLocation) {
        directionsLeg.setEndLocation(endLocation != null ? ((GeoPointDelegate)endLocation).getLatLon() : null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectionsLegDelegate that = (DirectionsLegDelegate) o;

        if (directionsLeg != null ? !directionsLeg.equals(that.directionsLeg) : that.directionsLeg != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return directionsLeg != null ? directionsLeg.hashCode() : 0;
    }
}