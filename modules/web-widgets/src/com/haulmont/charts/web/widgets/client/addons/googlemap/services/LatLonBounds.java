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

package com.haulmont.charts.web.widgets.client.addons.googlemap.services;

import com.haulmont.charts.web.widgets.client.addons.googlemap.base.LatLon;

import java.io.Serializable;

public class LatLonBounds implements Serializable {
    private static final long serialVersionUID = -3471173653375916175L;

    private LatLon sw;
    private LatLon ne;

    public LatLonBounds() {
    }

    public LatLonBounds(LatLon sw, LatLon ne) {
        this.sw = sw;
        this.ne = ne;
    }

    public LatLon getSw() {
        return sw;
    }

    public void setSw(LatLon sw) {
        this.sw = sw;
    }

    public LatLon getNe() {
        return ne;
    }

    public void setNe(LatLon ne) {
        this.ne = ne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LatLonBounds that = (LatLonBounds) o;

        if (ne != null ? !ne.equals(that.ne) : that.ne != null) return false;
        if (sw != null ? !sw.equals(that.sw) : that.sw != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sw != null ? sw.hashCode() : 0;
        result = 31 * result + (ne != null ? ne.hashCode() : 0);
        return result;
    }
}