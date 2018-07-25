/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.base;

import java.io.Serializable;

/**
 * @author Igor Korotkov (igor@ikorotkov.com)
 */
public class MarkerImage implements Serializable {
    private static final long serialVersionUID = -7586709196736683656L;

    private String url;
    private Size size;
    private Point origin;
    private Point anchor;
    private Size scaledSize;

    public MarkerImage() {
    }

    public MarkerImage(String url) {
        this.url = url;
    }

    public MarkerImage(String url, Size size) {
        this.url = url;
        this.size = size;
    }

    public MarkerImage(String url, Size size, Point origin) {
        this.url = url;
        this.size = size;
        this.origin = origin;
    }

    public MarkerImage(String url, Size size, Point origin, Point anchor) {
        this.url = url;
        this.size = size;
        this.origin = origin;
        this.anchor = anchor;
    }

    public MarkerImage(String url, Size size, Point origin, Point anchor, Size scaledSize) {
        this.url = url;
        this.size = size;
        this.origin = origin;
        this.anchor = anchor;
        this.scaledSize = scaledSize;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    public Point getAnchor() {
        return anchor;
    }

    public void setAnchor(Point anchor) {
        this.anchor = anchor;
    }

    public Size getScaledSize() {
        return scaledSize;
    }

    public void setScaledSize(Size scaledSize) {
        this.scaledSize = scaledSize;
    }
}