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

package com.haulmont.charts.web.gui.components.map.google.directions;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.charts.gui.map.model.directions.DirectionsResult;
import com.haulmont.charts.gui.map.model.directions.DirectionsRoute;
import com.haulmont.charts.web.gui.components.map.google.DelegateHelper;

import java.util.List;

public class DirectionsResultDelegate implements DirectionsResult {
    private com.haulmont.charts.web.widgets.client.addons.googlemap.services.DirectionsResult result;

    public static DirectionsResultDelegate fromDirectionsResult(com.haulmont.charts.web.widgets.client.addons.googlemap.services.DirectionsResult result) {
        return result != null ? new DirectionsResultDelegate(result) : null;
    }

    public DirectionsResultDelegate(com.haulmont.charts.web.widgets.client.addons.googlemap.services.DirectionsResult result) {
        Preconditions.checkNotNullArgument(result);
        this.result = result;
    }

    public com.haulmont.charts.web.widgets.client.addons.googlemap.services.DirectionsResult getResult() {
        return result;
    }

    public void setResult(com.haulmont.charts.web.widgets.client.addons.googlemap.services.DirectionsResult result) {
        this.result = result;
    }

    @Override
    public List<DirectionsRoute> getRoutes() {
        return DelegateHelper.toCubaDirectionsRoutes(result.getRoutes());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectionsResultDelegate that = (DirectionsResultDelegate) o;

        if (result != null ? !result.equals(that.result) : that.result != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return result != null ? result.hashCode() : 0;
    }
}