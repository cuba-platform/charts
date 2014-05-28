/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.core.global;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;
import com.haulmont.cuba.core.config.defaults.DefaultBoolean;
import com.haulmont.cuba.core.config.defaults.DefaultDouble;
import com.haulmont.cuba.core.config.defaults.DefaultInteger;
import com.haulmont.cuba.core.config.defaults.DefaultString;

/**
 * @author korotkov
 * @version $Id$
 */
@Source(type = SourceType.APP)
public interface MapConfig extends Config {

    @Property("cuba.charts.map.provider")
    @DefaultString("google")
    String getDefaultMapsProvider();
    void setMapsProvider(String key);

    @Property("cuba.charts.map.freeApiKey")
    String getFreeApiKey();
    void setFreeApiKey(String key);

    @Property("cuba.charts.map.businessApiKey")
    String getBusinessApiKey();
    void setBusinessApiKey(String key);

    @Property("cuba.charts.map.clientId")
    String getClientId();
    void setClientId(String id);

    @Property("cuba.charts.map.useBusinessApiKey")
    @DefaultBoolean(false)
    boolean isUseBusinessApiKey();
    void setUseBusinessApiKey(boolean value);

    @Property("cuba.charts.map.defaultZoom")
    Double getDefZoom();
    void setDefZoom(Double defZoom);

    @Property("cuba.charts.map.defaultLatitude")
    Double getDefLatitude();
    void setDefLatitude(Double defLatitude);

    @Property("cuba.charts.map.defaultLongitude")
    Double getDefLongitude();
    void setDefLongitude(Double defLongitude);
}
