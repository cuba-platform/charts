/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines derived properties
 * (see <a href="https://github.com/nicolaskruchten/pivottable/wiki/Derived-Attributes">documentation</a>).
 */
public class DerivedProperties extends AbstractPivotObject {
    private static final long serialVersionUID = -2113616038227536186L;

    private Map<String, PivotJsFunction> properties;

    public Map<String, PivotJsFunction> getProperties() {
        return properties;
    }

    public DerivedProperties setProperties(Map<String, PivotJsFunction> derivedProperties) {
        this.properties = derivedProperties;
        return this;
    }

    public DerivedProperties addAttributes(Map<String, PivotJsFunction> derivedProperties) {
        if (this.properties == null) {
            this.properties = new HashMap<>();
        }
        this.properties.putAll(derivedProperties);
        return this;
    }

    public DerivedProperties addAttribute(String caption, PivotJsFunction function) {
        if (this.properties == null) {
            this.properties = new HashMap<>();
        }
        this.properties.put(caption, function);
        return this;
    }
}
