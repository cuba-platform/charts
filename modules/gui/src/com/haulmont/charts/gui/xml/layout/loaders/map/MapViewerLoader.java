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

package com.haulmont.charts.gui.xml.layout.loaders.map;

import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.loaders.AbstractComponentLoader;
import org.dom4j.Element;

public class MapViewerLoader extends AbstractComponentLoader<MapViewer> {

    @Override
    public void createComponent() {
        resultComponent = factory.create(MapViewer.NAME);
        loadId(resultComponent, element);
    }

    @Override
    public void loadComponent() {
        assignFrame(resultComponent);
        loadWidth(resultComponent, element, Component.AUTO_SIZE);
        loadHeight(resultComponent, element, Component.AUTO_SIZE);

        loadVisible(resultComponent, element);
        loadEnable(resultComponent, element);
        loadStyleName(resultComponent, element);

        loadIcon(resultComponent, element);
        loadCaption(resultComponent, element);
        loadDescription(resultComponent, element);
        loadCss(resultComponent, element);

        loadMapType(resultComponent, element);
    }

    protected void loadMapType(MapViewer mapViewer, Element element) {
        String mapType = element.attributeValue("mapType");
        if (mapType != null) {
            mapViewer.setMapType(MapViewer.Type.valueOf(mapType.toUpperCase()));
        }
    }
}