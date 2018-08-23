/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model;

public class C3RendererOptions extends AbstractPivotObject {

    private static final long serialVersionUID = -5273273454206199279L;

    private Size size;

    /**
     * @return size of chart renderer
     */
    public Size getSize() {
        return size;
    }

    /**
     * Sets size of chart renderer.
     *
     * @param size size of chart renderer
     * @return a reference to this object
     */
    public C3RendererOptions setSize(Size size) {
        this.size = size;
        return this;
    }
}
