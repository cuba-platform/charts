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

package com.haulmont.charts.web.widgets.client.addons.googlemap.base;

import java.io.Serializable;

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