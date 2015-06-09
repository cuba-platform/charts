/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.map;

import com.haulmont.charts.core.global.MapConfig;
import com.haulmont.charts.gui.components.map.GoogleMapViewer;
import com.haulmont.charts.gui.components.map.MapViewer;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Configuration;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.cuba.gui.xml.layout.loaders.ComponentLoader;
import org.dom4j.Element;

/**
 * @author korotkov
 * @version $Id$
 */
public class MapViewerLoader extends ComponentLoader {

    protected MapConfig mapConfig = AppBeans.get(Configuration.class).getConfig(MapConfig.class);

    public MapViewerLoader(Context context) {
        super(context);
    }

    @Override
    public Component loadComponent(ComponentsFactory factory, Element element, Component parent) {
        String vendor = element.attributeValue("vendor");
        if (vendor == null) {
            vendor = mapConfig.getDefaultMapsProvider();
        }

        String componentId;
        switch (vendor) {
            case "google":
                componentId = GoogleMapViewer.NAME;
                break;
            default:
                throw new IllegalArgumentException("Unknown maps vendor: " + vendor);
        }

        MapViewer mapViewer = factory.createComponent(componentId);

        loadId(mapViewer, element);
        loadWidth(mapViewer, element, Component.AUTO_SIZE);
        loadHeight(mapViewer, element, Component.AUTO_SIZE);

        loadVisible(mapViewer, element);
        loadEnable(mapViewer, element);
        loadStyleName(mapViewer, element);

        loadMapType(mapViewer, element);

        assignFrame(mapViewer);
        return mapViewer;
    }

    private void loadMapType(MapViewer mapViewer, Element element) {
        String mapType = element.attributeValue("mapType");
        if (mapType != null) {
            mapViewer.setMapType(MapViewer.Type.valueOf(mapType.toUpperCase()));
        }
    }
}
