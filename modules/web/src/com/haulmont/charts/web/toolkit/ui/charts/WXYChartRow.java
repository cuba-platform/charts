/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.charts;

import com.vaadin.data.Container;
import com.vaadin.ui.Component;

import java.util.Collection;

/**
 * <p>$Id$</p>
 *
 * @author zagumennikov
 */
public interface WXYChartRow extends Component, Container, Container.Viewer,
        Container.ItemSetChangeNotifier, Container.ItemSetChangeListener,
        Container.PropertySetChangeNotifier, Container.PropertySetChangeListener {

    Collection<?> getPointIds();
    void addPoint(Object id);

    Collection<?> getPropertyIds();
    void addProperty(Object id);

    Object getXPropertyId();
    void setXPropertyId(Object propertyId);

    Object getYPropertyId();
    void setYPropertyId(Object propertyId);

    Object getXValue(Object pointId);
    void setXValue(Object pointId, Object value);

    Object getYValue(Object pointId);
    void setYValue(Object pointId, Object value);
}
