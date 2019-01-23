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

package com.haulmont.charts.gui.map.model;

public interface Label {

    /**
     * Sets value of the label.
     *
     * @param value label value
     */
    void setValue(String value);

    /**
     * @return value of the label
     */
    String getValue();

    /**
     * Sets position of the label.
     *
     * @param position position
     */
    void setPosition(GeoPoint position);

    /**
     * @return position of the label
     */
    GeoPoint getPosition();

    /**
     * Sets whether label value will be parsed as HTML or not.
     *
     * @param contentType content type
     */
    void setContentType(ContentType contentType);

    /**
     * @return content type
     */
    ContentType getContentType();

    /**
     * Sets label adjustment relative to the its GeoPoint position
     *
     * @param adjustment adjustment
     */
    void setAdjustment(Adjustment adjustment);

    /**
     * @return adjustment
     */
    Adjustment getAdjustment();

    /**
     * Sets additional stylename to the label.
     *
     * @param styleName stylename
     */
    void setStyleName(String styleName);

    /**
     * @return stylename
     */
    String getStyleName();

    enum Adjustment {
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

    enum ContentType {
        PLAIN_TEXT,
        HTML
    }
}