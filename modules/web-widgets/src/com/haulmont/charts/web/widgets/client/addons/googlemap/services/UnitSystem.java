/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.client.addons.googlemap.services;

/**
 * @author Igor Korotkov (igor@ikorotkov.com)
 */
public enum UnitSystem {
    /**
     * Specifies that distances in the DirectionsResult should be expressed in imperial units.
     */
    IMPERIAL(1),

    /**
     * Specifies that distances in the DirectionsResult should be expressed in metric units.
     */
    METRIC(0);

    private int type;

    UnitSystem(int type) {
        this.type = type;
    }

    public int value() {
        return type;
    }

    public static UnitSystem fromValue(int type) {
        UnitSystem u = null;
        switch (type) {
            case 0:
                u = UnitSystem.METRIC;
                break;
            case 1:
                u = UnitSystem.IMPERIAL;
                break;
        }
        return u;
    }

    public String toString() {
        return name() + "(" + type + ")";
    }

}