/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.web.gui;

import com.haulmont.cuba.gui.ComponentPalette;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.ComponentLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * Charts palette
 *
 * @author artamonov
 * @version $id$
 */
public class ChartComponentPalette implements ComponentPalette {
    @Override
    public Map<String, Class<? extends ComponentLoader>> getLoaders() {

        Map<String, Class<? extends ComponentLoader>> loaders = new HashMap<>();

        return loaders;
    }

    @Override
    public Map<String, Class<? extends Component>> getComponents() {
        Map<String, Class<? extends Component>> components = new HashMap<>();

        return components;
    }
}