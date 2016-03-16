/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.core.global;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;
import com.haulmont.cuba.core.config.defaults.DefaultBoolean;
import com.haulmont.cuba.core.config.defaults.DefaultDouble;
import com.haulmont.cuba.core.config.defaults.DefaultString;

/**
 */
@Source(type = SourceType.DATABASE)
public interface MapConfig extends Config {

    @Property("charts.map.provider")
    @DefaultString("google")
    String getMapsProvider();
    void setMapsProvider(String key);

    @Property("charts.map.freeApiKey")
    String getFreeApiKey();
    void setFreeApiKey(String key);

    @Property("charts.map.businessApiKey")
    String getBusinessApiKey();
    void setBusinessApiKey(String key);

    @Property("charts.map.clientId")
    String getClientId();
    void setClientId(String id);

    @Property("charts.map.useBusinessApiKey")
    @DefaultBoolean(false)
    boolean isUseBusinessApiKey();
    void setUseBusinessApiKey(boolean value);

    @Property("charts.map.defaultZoom")
    @DefaultDouble(8.0)
    Double getDefZoom();
    void setDefZoom(Double defZoom);

    @DefaultDouble(53.485846)
    @Property("charts.map.defaultLatitude")
    Double getDefLatitude();
    void setDefLatitude(Double defLatitude);

    @DefaultDouble(-2.24248)
    @Property("charts.map.defaultLongitude")
    Double getDefLongitude();
    void setDefLongitude(Double defLongitude);
}