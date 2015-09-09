/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author artamonov
 * @version $Id$
 */
public class Pattern extends AbstractChartObject {

    private static final long serialVersionUID = 952770895827665737L;

    private String url;

    private Integer width;

    private Integer height;

    public Integer getHeight() {
        return height;
    }

    public Pattern setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Pattern setUrl(String url) {
        this.url = url;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public Pattern setWidth(Integer width) {
        this.width = width;
        return this;
    }
}