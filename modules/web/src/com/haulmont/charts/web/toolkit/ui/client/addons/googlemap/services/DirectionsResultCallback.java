/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.addons.googlemap.services;

/**
 * @author Igor Korotkov (igor@ikorotkov.com)
 */
public interface DirectionsResultCallback {
    void onCallback(DirectionsResult result, DirectionsStatus status);
}