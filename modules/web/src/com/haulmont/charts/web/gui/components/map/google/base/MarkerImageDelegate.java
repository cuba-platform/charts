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

package com.haulmont.charts.web.gui.components.map.google.base;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.charts.gui.map.model.base.MarkerImage;
import com.haulmont.charts.gui.map.model.base.Point;
import com.haulmont.charts.gui.map.model.base.Size;

public class MarkerImageDelegate implements MarkerImage {
    private com.haulmont.charts.web.widgets.client.addons.googlemap.base.MarkerImage markerImage;

    public static MarkerImageDelegate fromMarkerImage(com.haulmont.charts.web.widgets.client.addons.googlemap.base.MarkerImage image) {
        return image != null ? new MarkerImageDelegate(image) : null;
    }

    public MarkerImageDelegate(com.haulmont.charts.web.widgets.client.addons.googlemap.base.MarkerImage markerImage) {
        Preconditions.checkNotNullArgument(markerImage);
        this.markerImage = markerImage;
    }

    public com.haulmont.charts.web.widgets.client.addons.googlemap.base.MarkerImage getMarkerImage() {
        return markerImage;
    }

    public void setMarkerImage(com.haulmont.charts.web.widgets.client.addons.googlemap.base.MarkerImage markerImage) {
        this.markerImage = markerImage;
    }

    @Override
    public String getUrl() {
        return markerImage.getUrl();
    }

    @Override
    public void setUrl(String url) {
        markerImage.setUrl(url);
    }

    @Override
    public Size getSize() {
        return SizeDelegate.fromSize(markerImage.getSize());
    }

    @Override
    public void setSize(Size size) {
        markerImage.setSize(size != null ? ((SizeDelegate)size).getSize() : null);
    }

    @Override
    public Point getOrigin() {
        return PointDelegate.fromPoint(markerImage.getOrigin());
    }

    @Override
    public void setOrigin(Point origin) {
        markerImage.setOrigin(origin != null ? ((PointDelegate) origin).getPoint() : null);
    }

    @Override
    public Point getAnchor() {
        return PointDelegate.fromPoint(markerImage.getAnchor());
    }

    @Override
    public void setAnchor(Point anchor) {
        markerImage.setAnchor(anchor != null ? ((PointDelegate)anchor).getPoint() : null);
    }

    @Override
    public Size getScaledSize() {
        return SizeDelegate.fromSize(markerImage.getSize());
    }

    @Override
    public void setScaledSize(Size scaledSize) {
        markerImage.setScaledSize(scaledSize != null ? ((SizeDelegate)scaledSize).getSize() : null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarkerImageDelegate that = (MarkerImageDelegate) o;

        if (markerImage != null ? !markerImage.equals(that.markerImage) : that.markerImage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return markerImage != null ? markerImage.hashCode() : 0;
    }
}