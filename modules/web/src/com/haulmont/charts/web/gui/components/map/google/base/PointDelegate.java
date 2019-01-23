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
import com.haulmont.charts.gui.map.model.base.Point;

public class PointDelegate implements Point {
    private com.haulmont.charts.web.widgets.client.addons.googlemap.base.Point point;

    public static PointDelegate fromPoint(com.haulmont.charts.web.widgets.client.addons.googlemap.base.Point point) {
        return point != null ? new PointDelegate(point) : null;
    }

    public PointDelegate(com.haulmont.charts.web.widgets.client.addons.googlemap.base.Point point) {
        Preconditions.checkNotNullArgument(point);
        this.point = point;
    }

    public com.haulmont.charts.web.widgets.client.addons.googlemap.base.Point getPoint() {
        return point;
    }

    public void setPoint(com.haulmont.charts.web.widgets.client.addons.googlemap.base.Point point) {
        this.point = point;
    }

    @Override
    public double getX() {
        return point.getX();
    }

    @Override
    public void setX(double x) {
        point.setX(x);
    }

    @Override
    public double getY() {
        return point.getY();
    }

    @Override
    public void setY(double y) {
        point.setY(y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PointDelegate that = (PointDelegate) o;

        if (point != null ? !point.equals(that.point) : that.point != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return point != null ? point.hashCode() : 0;
    }
}