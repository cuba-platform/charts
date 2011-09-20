/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.web.toolkit.ui.charts;

import com.vaadin.data.Container;

import java.util.Collection;

/**
 * <p>$Id$</p>
 *
 * @author zagumennikov
 */
public interface VCategoryChart extends VChart, Container.Viewer,
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