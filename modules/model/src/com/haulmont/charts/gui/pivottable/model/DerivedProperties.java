/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model;

import com.haulmont.charts.gui.model.JsFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines derived properties
 * (see <a href="https://github.com/nicolaskruchten/pivottable/wiki/Derived-Attributes">documentation</a>).
 */
public class DerivedProperties extends AbstractPivotObject {
    private static final long serialVersionUID = -2113616038227536186L;

    private Map<String, JsFunction> properties;

    /**
     * @return a map of derived properties
     */
    public Map<String, JsFunction> getProperties() {
        return properties;
    }

    /**
     * Sets a map of derived properties.
     *
     * @param derivedProperties a map of derived properties
     * @return a reference to this object
     */
    public DerivedProperties setProperties(Map<String, JsFunction> derivedProperties) {
        this.properties = derivedProperties;
        return this;
    }

    /**
     * Adds a map of derived properties.
     *
     * @param derivedProperties a map of derived properties
     * @return a reference to this object
     */
    public DerivedProperties addAttributes(Map<String, JsFunction> derivedProperties) {
        if (this.properties == null) {
            this.properties = new HashMap<>();
        }
        this.properties.putAll(derivedProperties);
        return this;
    }

    /**
     * Adds a function that calculated a derived property to the given localized attribute name.
     *
     * @param caption  a localized attribute name
     * @param function a function that calculated a derived property
     * @return a reference to this object
     */
    public DerivedProperties addAttribute(String caption, JsFunction function) {
        if (this.properties == null) {
            this.properties = new HashMap<>();
        }
        this.properties.put(caption, function);
        return this;
    }
}
