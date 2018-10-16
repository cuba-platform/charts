/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
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