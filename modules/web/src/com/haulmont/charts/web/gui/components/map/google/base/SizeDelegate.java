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
import com.haulmont.charts.gui.map.model.base.Size;

public class SizeDelegate implements Size {
    private com.haulmont.charts.web.widgets.client.addons.googlemap.base.Size size;

    public static SizeDelegate fromSize(com.haulmont.charts.web.widgets.client.addons.googlemap.base.Size size) {
        return size != null ? new SizeDelegate(size) : null;
    }

    public SizeDelegate(com.haulmont.charts.web.widgets.client.addons.googlemap.base.Size size) {
        Preconditions.checkNotNullArgument(size);
        this.size = size;
    }

    public com.haulmont.charts.web.widgets.client.addons.googlemap.base.Size getSize() {
        return size;
    }

    public void setSize(com.haulmont.charts.web.widgets.client.addons.googlemap.base.Size size) {
        this.size = size;
    }

    @Override
    public double getWidth() {
        return size.getWidth();
    }

    @Override
    public void setWidth(double width) {
        size.setWidth(width);
    }

    @Override
    public double getHeight() {
        return size.getHeight();
    }

    @Override
    public void setHeight(double height) {
        size.setHeight(height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SizeDelegate that = (SizeDelegate) o;

        if (size != null ? !size.equals(that.size) : that.size != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return size != null ? size.hashCode() : 0;
    }
}