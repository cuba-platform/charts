/*
 * Copyright (c) 2008-2020 Haulmont.
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

package com.haulmont.charts.web.widgets.client.addons.googlemap;

import com.google.gwt.maps.client.LoadApi;
import com.google.gwt.user.client.Window;
import com.vaadin.client.ResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class CubaMapJsLoader {

    private static final Logger log = LoggerFactory.getLogger(CubaMapJsLoader.class);

    /**
     * Loads map API.
     *
     * @param apiUrl     custom api url if null "maps.googleapis.com" will be used
     * @param apiVersion api version
     * @param callback   is invoked when API will be loaded
     * @param params     additional params to request, this map will be converted to string as "key + '=' + value"
     */
    public static void load(String apiUrl, String apiVersion, Runnable callback, Map<String, String> params) {
        String url = createUrl(apiUrl, apiVersion, params);

        ResourceLoader.get().loadScript(url, new ResourceLoader.ResourceLoadListener() {

            @Override
            public void onLoad(ResourceLoader.ResourceLoadEvent event) {
                callback.run();
            }

            @Override
            public void onError(ResourceLoader.ResourceLoadEvent event) {
                log.error("Cannot load Google Map API script: " + event.getResourceUrl());
            }
        });
    }

    /**
     * @param libraries load libraries
     * @return string with libraries separated by comma, e.g. {@code "drawing,visualization"}
     */
    public static String getLibrariesList(List<LoadApi.LoadLibrary> libraries) {
        StringBuilder result = new StringBuilder();

        for (LoadApi.LoadLibrary library : libraries) {
            result.append(library.value()).append(",");
        }

        result.deleteCharAt(result.length() - 1);

        return result.toString();
    }

    protected static String createUrl(String apiUrl, String apiVersion, Map<String, String> params) {
        StringBuilder url = new StringBuilder(getProtocol() + "//");

        url.append(apiUrl != null ? apiUrl : "maps.googleapis.com");

        url.append("/maps/api/js?");
        url.append("v=").append(apiVersion).append("&");

        for (String key : params.keySet()) {
            url.append(key).append("=").append(params.get(key)).append("&");
        }

        url.deleteCharAt(url.length() - 1);

        return url.toString();
    }

    protected static String getProtocol() {
        if (Window.Location.getProtocol().equals("https:")) {
            return "https:";
        }
        return "http:";
    }
}
