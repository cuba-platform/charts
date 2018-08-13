/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.client.addons.googlemap.services;

/**
 * @author Igor Korotkov (igor@ikorotkov.com)
 */
public enum TravelMode {
    /**
     * Specifies a bicycling directions request.
     */
    BICYCLING,

    /**
     * Specifies a driving directions request.
     */
    DRIVING,

    /**
     * Specifies a walking directions request.
     */
    WALKING;

    public String value() {
        return name();
    }

    public static TravelMode fromValue(String type) {
        return valueOf(type.toUpperCase());
    }

    public String toString() {
        return name();
    }

}