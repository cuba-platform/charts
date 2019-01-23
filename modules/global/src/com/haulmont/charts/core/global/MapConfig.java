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

package com.haulmont.charts.core.global;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;
import com.haulmont.cuba.core.config.defaults.DefaultDouble;
import com.haulmont.cuba.core.config.defaults.DefaultString;

@Source(type = SourceType.DATABASE)
public interface MapConfig extends Config {

    /**
     * @deprecated map provider functionality is deprecated. MapViewer component is tightly bound with Google Map implementation.
     */
    @Deprecated
    @Property("charts.map.provider")
    @DefaultString("google")
    String getMapsProvider();
    void setMapsProvider(String key);

    @Property("charts.map.apiKey")
    String getApiKey();
    void setApiKey(String key);

    @Property("charts.map.clientId")
    String getClientId();
    void setClientId(String id);

    @Property("charts.map.language")
    String getLanguage();
    void setLanguage(String id);

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

    /**
     * Version of Google Maps API that should be used.
     * <p>
     * You can set this property to the "3" to use last released version of Google Maps API or to the "3.exp",
     * if you want to use experimental version.
     * <p>
     * Visit the official Google Maps API <a href="https://developers.google.com/maps/documentation/javascript/versions">documentation</a>
     * for more information.
     */
    @DefaultString("3.28")
    @Property("charts.map.apiVersion")
    String getMapsApiVersion();
    void setMapsApiVersion(String apiVersion);
}