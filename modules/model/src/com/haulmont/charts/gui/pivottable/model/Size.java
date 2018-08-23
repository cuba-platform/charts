/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model;

/**
 * An object that describes the size.
 */
public class Size extends AbstractPivotObject {

    private static final long serialVersionUID = -7892174283356404245L;

    private Double width;

    private Double height;

    /**
     * @return the width value
     */
    public Double getWidth() {
        return width;
    }

    /**
     * Sets the width value.
     *
     * @param width the width value
     * @return a reference to this object
     */
    public Size setWidth(Double width) {
        this.width = width;
        return this;
    }

    /**
     * @return the height value
     */
    public Double getHeight() {
        return height;
    }

    /**
     * Sets the height value.
     *
     * @param height the height value
     * @return a reference to this object
     */
    public Size setHeight(Double height) {
        this.height = height;
        return this;
    }
}
