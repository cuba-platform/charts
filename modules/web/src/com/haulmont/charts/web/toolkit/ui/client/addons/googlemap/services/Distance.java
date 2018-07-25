/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.services;

import java.io.Serializable;

/**
 * @author Igor Korotkov (igor@ikorotkov.com)
 */
public class Distance implements Serializable {
    private static final long serialVersionUID = 8516378440142447051L;

    private String text;
    private int value;

    public Distance() {
    }

    public Distance(String text, int value) {
        this.text = text;
        this.value = value;
    }

    /**
     * A string representation of the distance value, using the UnitSystem specified in the request.
     */
    public String getText() {
        return text;
    }

    /**
     * A string representation of the distance value, using the UnitSystem specified in the request.
     *
     * @param text text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * The distance in meters.
     */
    public int getValue() {
        return value;
    }

    /**
     * The distance in meters.
     *
     * @param value value
     */
    public void setValue(int value) {
        this.value = value;
    }
}