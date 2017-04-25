/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
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