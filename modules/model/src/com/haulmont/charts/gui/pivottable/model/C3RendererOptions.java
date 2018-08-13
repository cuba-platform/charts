/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model;

public class C3RendererOptions extends AbstractPivotObject {

    private static final long serialVersionUID = -5273273454206199279L;

    /**
     * Defines size of chart renderer
     */
    private Size size;

    public Size getSize() {
        return size;
    }

    public C3RendererOptions setSize(Size size) {
        this.size = size;
        return this;
    }
}
