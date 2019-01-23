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

package com.haulmont.charts.gui.map.model.maptype;

public interface ImageMapType {
    double getOpacity();
    void setOpacity(double opacity);

    double getTileWidth();
    double getTileHeight() ;
    void setTileSize(double tileWidth, double tileHeight);

    int getMinZoom();
    void setMinZoom(int minZoom);

    int getMaxZoom();
    void setMaxZoom(int maxZoom);

    String getTileUrlCallbackFunction();
    void setTileUrlCallbackFunction(String tileUrlCallbackFunction);

    String getMapTypeId();
    void setMapTypeId(String mapTypeId);

    String getName();
    void setName(String name);

    String getAltText();
    void setAltText(String altText);
}