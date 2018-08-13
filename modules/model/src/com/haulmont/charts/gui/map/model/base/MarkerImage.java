/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.map.model.base;

/**
 * Class representing a Marker icon or shadow image.
 */
public interface MarkerImage {
    /**
     * @return the URL of the image or sprite sheet.
     */
    String getUrl();

    /**
     * Sets the URL of the image or sprite sheet.
     * @param url url
     */
    void setUrl(String url);

    /**
     * @return the display size of the sprite or image. When using sprites, you must specify the sprite size. If the size is
     * not provided, it will be set when the image loads.
     */
    Size getSize();

    /**
     * Sets the display size of the sprite or image. When using sprites, you must specify the sprite size. If the size is
     * not provided, it will be set when the image loads.
     * @param size size
     */
    void setSize(Size size);

    /**
     * @return the position of the image within a sprite, if any. By default, the origin is located at the top left corner of
     * the image (0, 0).
     */
    Point getOrigin();

    /**
     * Sets the position of the image within a sprite, if any. By default, the origin is located at the top left corner of
     * the image (0, 0).
     * @param origin origin
     */
    void setOrigin(Point origin);

    /**
     * @return the position at which to anchor an image in correspondence to the location of the marker on the map.
     */
    Point getAnchor();

    /**
     * Sets the position at which to anchor an image in correspondence to the location of the marker on the map. By
     * default, the anchor is located along the center point of the bottom of the image.
     *
     * @param anchor anchor
     */
    void setAnchor(Point anchor);

    /**
     * @return the size of the entire image after scaling, if any. Use this property to stretch/shrink an image or a sprite.
     */
    Size getScaledSize();

    /**
     * Sets the size of the entire image after scaling, if any. Use this property to stretch/shrink an image or a sprite.
     * @param scaledSize size
     */
    void setScaledSize(Size scaledSize);
}
