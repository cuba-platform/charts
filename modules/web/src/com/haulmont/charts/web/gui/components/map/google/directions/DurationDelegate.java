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
import com.haulmont.charts.gui.map.model.directions.Duration;

public class DurationDelegate implements Duration {

    private com.haulmont.charts.web.widgets.client.addons.googlemap.services.Duration duration;

    public static DurationDelegate fromDuration(com.haulmont.charts.web.widgets.client.addons.googlemap.services.Duration duration) {
        return duration != null ? new DurationDelegate(duration) : null;
    }

    public DurationDelegate(com.haulmont.charts.web.widgets.client.addons.googlemap.services.Duration duration) {
        Preconditions.checkNotNullArgument(duration);
        this.duration = duration;
    }

    public com.haulmont.charts.web.widgets.client.addons.googlemap.services.Duration getDuration() {
        return duration;
    }

    public void setDuration(com.haulmont.charts.web.widgets.client.addons.googlemap.services.Duration duration) {
        this.duration = duration;
    }

    @Override
    public String getText() {
        return duration.getText();
    }

    @Override
    public void setText(String text) {
        duration.setText(text);
    }

    @Override
    public int getValue() {
        return duration.getValue();
    }

    @Override
    public void setValue(int value) {
        duration.setValue(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DurationDelegate that = (DurationDelegate) o;

        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return duration != null ? duration.hashCode() : 0;
    }
}