/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.client.addons.googlemap.maptypes;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @author korotkov
 * @version $Id$
 */
public interface GoogleTileUrlCallback extends IsSerializable {
    String getTileUrl(double x, double y, int zoomLevel);
}