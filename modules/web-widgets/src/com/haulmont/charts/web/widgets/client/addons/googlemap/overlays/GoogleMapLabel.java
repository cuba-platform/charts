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

package com.haulmont.charts.web.widgets.client.addons.googlemap.overlays;

import com.haulmont.charts.web.widgets.client.addons.googlemap.base.LatLon;

import java.io.Serializable;

public class GoogleMapLabel implements Serializable {

    private static final long serialVersionUID = 4709925011179392361L;

    private static final String primaryStylename = "gm-label";

    private static long idCounter = 0;
    private long id;

    private String value;
    private LatLon position;
    private ContentType contentType = ContentType.PLAIN_TEXT;
    private Adjustment adjustment = Adjustment.BOTTOM_RIGHT;

    private String styleName;

    public GoogleMapLabel() {
        id = idCounter;
        idCounter++;
    }

    public GoogleMapLabel(String value, LatLon position) {
        this(value, position, ContentType.PLAIN_TEXT);
    }

    public GoogleMapLabel(String value, LatLon position, ContentType contentType) {
        this();
        this.value = value;
        this.position = position;
        this.contentType = contentType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LatLon getPosition() {
        return position;
    }

    public void setPosition(LatLon position) {
        this.position = position;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public Adjustment getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(Adjustment adjustment) {
        this.adjustment = adjustment;
    }

    public static String getPrimaryStylename() {
        return primaryStylename;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    @Override
    public int hashCode() {
        return 31 + (int) (id ^ (id >>> 32));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (getClass() != obj.getClass()) {
            return false;
        }

        GoogleMapLabel other = (GoogleMapLabel) obj;
        return id == other.id;
    }

    public enum ContentType {
        PLAIN_TEXT,
        HTML
    }

    public enum Adjustment {
        TOP_LEFT,
        TOP_CENTER,
        TOP_RIGHT,
        MIDDLE_LEFT,
        MIDDLE_CENTER,
        MIDDLE_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_CENTER,
        BOTTOM_RIGHT
    }
}