/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author artamonov
 * @version $Id$
 */
public class MapDataItem implements DataItem {

    private static final long serialVersionUID = -6115531750392377539L;

    private Map<String, Object> properties = new HashMap<>();

    @Override
    public Collection<String> getProperties() {
        return properties.keySet();
    }

    @Override
    public Object getValue(String property) {
        return properties.get(property);
    }

    public MapDataItem add(String key, Object value) {
        properties.put(key, value);
        return this;
    }

    public void remove(String key) {
        properties.remove(key);
    }
}