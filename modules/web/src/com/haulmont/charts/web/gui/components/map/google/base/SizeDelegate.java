/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.map.google.base;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.charts.gui.map.model.base.Size;

public class SizeDelegate implements Size {
    private com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.base.Size size;

    public static SizeDelegate fromSize(com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.base.Size size) {
        return size != null ? new SizeDelegate(size) : null;
    }

    public SizeDelegate(com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.base.Size size) {
        Preconditions.checkNotNullArgument(size);
        this.size = size;
    }

    public com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.base.Size getSize() {
        return size;
    }

    public void setSize(com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.base.Size size) {
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