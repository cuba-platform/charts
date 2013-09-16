/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.charts;

import com.vaadin.data.Container;

import java.util.Collection;

/**
 * <p>$Id$</p>
 *
 * @author zagumennikov
 */
public interface WCategoryChart extends WChart, WChart.HasLegend, Container.Viewer,
        Container, Container.ItemSetChangeNotifier, Container.ItemSetChangeListener,
        Container.PropertySetChangeNotifier, Container.PropertySetChangeListener {

    Collection<?> getRowIds();
    void addRow(Object id, String caption);

    String getRowCaption(Object id);

    Object getRowCaptionPropertyId();
    void setRowCaptionPropertyId(Object propertyId);

    Collection<?> getPropertyIds();
    void addProperty(Object id);

    Collection<?> getCategoryPropertyIds();
    void addCategory(Object propertyId, String caption);

    String getCategoryCaption(Object propertyId);

    Object getValue(Object rowId, Object propertyId);
    void setValue(Object rowId, Object propertyId, Object value);
}