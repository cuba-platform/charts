/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.map;

import com.haulmont.charts.core.global.MapConfig;
import com.haulmont.charts.gui.components.map.GoogleMapViewer;
import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Configuration;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.loaders.AbstractComponentLoader;
import org.dom4j.Element;

/**
 */
public class MapViewerLoader extends AbstractComponentLoader<MapViewer> {

    @Override
    public void createComponent() {
        String vendor = element.attributeValue("vendor");
        if (vendor == null) {
            Configuration configuration = AppBeans.get(Configuration.NAME);
            MapConfig mapConfig = configuration.getConfig(MapConfig.class);

            vendor = mapConfig.getMapsProvider();
        }

        String componentId;
        switch (vendor) {
            case "google":
                componentId = GoogleMapViewer.NAME;
                break;
            default:
                throw new IllegalArgumentException("Unknown maps vendor: " + vendor);
        }

        resultComponent = (MapViewer) factory.createComponent(componentId);
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

        loadMapType(resultComponent, element);
    }

    protected void loadMapType(MapViewer mapViewer, Element element) {
        String mapType = element.attributeValue("mapType");
        if (mapType != null) {
            mapViewer.setMapType(MapViewer.Type.valueOf(mapType.toUpperCase()));
        }
    }
}
