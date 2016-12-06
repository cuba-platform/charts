/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model;

public class Size extends AbstractPivotObject {

    private static final long serialVersionUID = -7892174283356404245L;

    private Double width;

    private Double height;

    public Double getWidth() {
        return width;
    }

    public Size setWidth(Double width) {
        this.width = width;
        return this;
    }

    public Double getHeight() {
        return height;
    }

    public Size setHeight(Double height) {
        this.height = height;
        return this;
    }
}
