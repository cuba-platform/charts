/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.web.toolkit.ui.charts;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.*;

/**
 * <p>$Id$</p>
 *
 * @author zagumennikov
 */
public abstract class CategoryChartComponent extends ChartComponent implements WCategoryChart {

    private static final long serialVersionUID = -2096187829656779886L;

    protected Container items;
    protected Object rowCaptionPropertyId;

    protected boolean hasLegend = false;

    protected Map<Object, String> categories = new HashMap<Object, String>();

    protected Set<ItemSetChangeListener> itemSetChangeListeners = new LinkedHashSet<ItemSetChangeListener>();
    protected Set<PropertySetChangeListener> propertySetChangeListeners = new LinkedHashSet<PropertySetChangeListener>();

    protected CategoryChartComponent() {
        setContainerDataSource(new IndexedContainer());
    }

    @Override
    public Collection<?> getRowIds() {
        return getItemIds();
    }

    @Override
    public void addRow(Object id, String caption) {
        addItem(id);

        if (rowCaptionPropertyId != null) {
            Property p = getContainerProperty(id, rowCaptionPropertyId);
            if (p != null) {
                p.setValue(caption);
            }
        }
    }

    @Override
    public boolean getHasLegend() {
        return hasLegend;
    }

    @Override
    public void setHasLegend(boolean hasLegend) {
        this.hasLegend = hasLegend;
        requestRepaint();
    }

    @Override
    public void paintContent(PaintTarget target) throws PaintException {
        super.paintContent(target);

        if (hasLegend) {
            target.addAttribute("legend", true);
        }
    }

    @Override
    public String getRowCaption(Object id) {
        String caption = null;

        if (rowCaptionPropertyId != null) {
            Property p = getContainerProperty(id, rowCaptionPropertyId);
            if (p != null) {
                caption = p.toString();
            }
        } else {
            Item i = getItem(id);
            if (i != null) {
                caption = i.toString();
            }
        }

        return caption == null ? "" : caption;
    }

    @Override
    public Object getRowCaptionPropertyId() {
        return rowCaptionPropertyId;
    }

    @Override
    public void setRowCaptionPropertyId(Object propertyId) {
        rowCaptionPropertyId = propertyId;
        requestRepaint();
    }

    @Override
    public Collection<?> getPropertyIds() {
        return getContainerPropertyIds();
    }

    @Override
    public void addProperty(Object id) {
        addContainerProperty(id, Object.class, null);
    }

    @Override
    public Collection<?> getCategoryPropertyIds() {
        return categories.keySet();
    }

    @Override
    public void addCategory(Object propertyId, String caption) {
        categories.put(propertyId, caption);
        requestRepaint();
    }

    @Override
    public String getCategoryCaption(Object propertyId) {
        String caption = categories.get(propertyId);
        if (caption == null) {
            caption = propertyId.toString();
        }
        return caption == null ? "" : caption;
    }

    @Override
    public Object getValue(Object rowId, Object propertyId) {
        Property p = getContainerProperty(rowId, propertyId);
        if (p == null) {
            return null;
        }

        return p.getValue();
    }

    @Override
    public void setValue(Object rowId, Object propertyId, Object value) {
        Property p = getContainerProperty(rowId, propertyId);
        if (p != null) {
            p.setValue(value);
        }
    }

    @Override
    public Item getItem(Object itemId) {
        return items.getItem(itemId);
    }

    @Override
    public Collection<?> getContainerPropertyIds() {
        return items.getContainerPropertyIds();
    }

    @Override
    public Collection<?> getItemIds() {
        return items.getItemIds();
    }

    @Override
    public Property getContainerProperty(Object itemId, Object propertyId) {
        return items.getContainerProperty(itemId, propertyId);
    }

    @Override
    public Class<?> getType(Object propertyId) {
        return items.getType(propertyId);
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean containsId(Object itemId) {
        return items.containsId(itemId);
    }

    @Override
    public Item addItem(Object itemId) throws UnsupportedOperationException {
        final Item retval = items.addItem(itemId);
        if (retval != null && !(items instanceof ItemSetChangeNotifier)) {
            fireItemSetChange();
        }
        return retval;
    }

    @Override
    public Object addItem() throws UnsupportedOperationException {
        final Object retval = items.addItem();
        if (retval != null && !(items instanceof ItemSetChangeNotifier)) {
            fireItemSetChange();
        }
        return retval;
    }

    @Override
    public boolean removeItem(Object itemId) throws UnsupportedOperationException {
        final boolean retval = items.removeItem(itemId);
        if (retval && !(items instanceof ItemSetChangeNotifier)) {
            fireItemSetChange();
        }
        return retval;
    }

    @Override
    public boolean addContainerProperty(Object propertyId, Class<?> type, @Nullable Object defaultValue)
            throws UnsupportedOperationException {

        final boolean retval = items.addContainerProperty(propertyId, type, defaultValue);
        if (retval && !(items instanceof PropertySetChangeNotifier)) {
            firePropertySetChange();
        }
        return retval;
    }

    @Override
    public boolean removeContainerProperty(Object propertyId) throws UnsupportedOperationException {
        final boolean retval = items.removeContainerProperty(propertyId);
        if (retval && !(items instanceof PropertySetChangeNotifier)) {
            firePropertySetChange();
        }
        return retval;
    }

    @Override
    public boolean removeAllItems() throws UnsupportedOperationException {
        final boolean retval = items.removeAllItems();
        if (retval && !(items instanceof ItemSetChangeNotifier)) {
            fireItemSetChange();
        }
        return retval;
    }

    @Override
    public void containerItemSetChange(Container.ItemSetChangeEvent event) {
        fireItemSetChange();
    }

    @Override
    public void addListener(ItemSetChangeListener listener) {
        if (itemSetChangeListeners == null) {
            itemSetChangeListeners = new LinkedHashSet<ItemSetChangeListener>();
        }
        itemSetChangeListeners.add(listener);
    }

    @Override
    public void removeListener(ItemSetChangeListener listener) {
        itemSetChangeListeners.remove(listener);
    }

    @Override
    public void containerPropertySetChange(Container.PropertySetChangeEvent event) {
        firePropertySetChange();
    }

    @Override
    public void addListener(PropertySetChangeListener listener) {
        propertySetChangeListeners.add(listener);
    }

    @Override
    public void removeListener(PropertySetChangeListener listener) {
        if (propertySetChangeListeners != null) {
            propertySetChangeListeners.remove(listener);
        }
    }

    @Override
    public void setContainerDataSource(Container datasource) {
        if (items != datasource) {
            if (items != null) {
                if (items instanceof ItemSetChangeNotifier) {
                    ((ItemSetChangeNotifier) items).removeListener(this);
                }
                if (items instanceof PropertySetChangeNotifier) {
                    ((PropertySetChangeNotifier) items).removeListener(this);
                }
            }

            items = datasource;

            if (items instanceof ItemSetChangeNotifier) {
                ((ItemSetChangeNotifier) items).addListener(this);
            }
            if (items instanceof PropertySetChangeNotifier) {
                ((PropertySetChangeNotifier) items).addListener(this);
            }

            requestRepaint();
        }
    }

    @Override
    public Container getContainerDataSource() {
        return items;
    }

    private void fireItemSetChange() {
        for (final ItemSetChangeListener listener : itemSetChangeListeners) {
            listener.containerItemSetChange(new ItemSetChangeEvent());
        }
        requestRepaint();
    }

    private void firePropertySetChange() {
        for (final PropertySetChangeListener listener : propertySetChangeListeners) {
            listener.containerPropertySetChange(new PropertySetChangeEvent());
        }
        requestRepaint();
    }

    private class ItemSetChangeEvent implements Serializable, Container.ItemSetChangeEvent {
        private static final long serialVersionUID = -3105286428491462551L;

        @Override
        public Container getContainer() {
            return CategoryChartComponent.this;
        }
    }

    private class PropertySetChangeEvent implements Serializable, Container.PropertySetChangeEvent {
        private static final long serialVersionUID = -1597899704080413194L;

        @Override
        public Container getContainer() {
            return CategoryChartComponent.this;
        }
    }
}