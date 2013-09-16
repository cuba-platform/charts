/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.charts;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.IndexedContainer;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
public abstract class GanttChartComponent extends ChartComponent implements WGanttChart {

    protected GanttChartComponent() {
        chartWidth = -1;
        chartHeight = -1;

        setWidth("-1px");
        setHeight("-1px");

        setContainerDataSource(new IndexedContainer());
    }

    protected Container items;

    protected TaskPropertiesProvider propertiesProvider;

    protected TaskItemClickListener itemClickListener;

    protected Set<ItemSetChangeListener> itemSetChangeListeners = new LinkedHashSet<ItemSetChangeListener>();
    protected Set<PropertySetChangeListener> propertySetChangeListeners = new LinkedHashSet<PropertySetChangeListener>();

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
    public boolean addContainerProperty(Object propertyId, Class<?> type, Object defaultValue) throws UnsupportedOperationException {
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
    public void setContainerDataSource(Container datasource) {
        if (items != datasource) {
            if (items != null) {
                if (items instanceof ItemSetChangeNotifier) {
                    ((ItemSetChangeNotifier) items).removeItemSetChangeListener(this);
                }
                if (items instanceof PropertySetChangeNotifier) {
                    ((PropertySetChangeNotifier) items).removePropertySetChangeListener(this);
                }
            }

            items = datasource;

            if (items instanceof ItemSetChangeNotifier) {
                ((ItemSetChangeNotifier) items).addItemSetChangeListener(this);
            }
            if (items instanceof PropertySetChangeNotifier) {
                ((PropertySetChangeNotifier) items).addPropertySetChangeListener(this);
            }
        }
    }

    @Override
    public Container getContainerDataSource() {
        return items;
    }

    @Override
    public TaskPropertiesProvider getPropertiesProvider() {
        return propertiesProvider;
    }

    @Override
    public void setPropertiesProvider(TaskPropertiesProvider propertiesProvider) {
        this.propertiesProvider = propertiesProvider;
    }

    @Override
    public void containerItemSetChange(Container.ItemSetChangeEvent event) {
        fireItemSetChange();
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
    public void setTaskItemClickListener(TaskItemClickListener clickListener) {
        this.itemClickListener = clickListener;
    }

    @Override
    public TaskItemClickListener getTaskItemClickListener() {
        return itemClickListener;
    }

    @Override
    public void addItemSetChangeListener(ItemSetChangeListener listener) {
    }

    @Override
    public void removeItemSetChangeListener(ItemSetChangeListener listener) {
    }

    @Override
    public void addPropertySetChangeListener(PropertySetChangeListener listener) {
    }

    @Override
    public void removePropertySetChangeListener(PropertySetChangeListener listener) {
    }

    private void fireItemSetChange() {
        for (final ItemSetChangeListener listener : itemSetChangeListeners) {
            listener.containerItemSetChange(new ItemSetChangeEvent());
        }
    }

    private void firePropertySetChange() {
        for (final PropertySetChangeListener listener : propertySetChangeListeners) {
            listener.containerPropertySetChange(new PropertySetChangeEvent());
        }
    }

    private class ItemSetChangeEvent implements Serializable, Container.ItemSetChangeEvent {
        private static final long serialVersionUID = -3105286428491462551L;

        public Container getContainer() {
            return GanttChartComponent.this;
        }
    }

    private class PropertySetChangeEvent implements Serializable, Container.PropertySetChangeEvent {
        private static final long serialVersionUID = -1597899704080413194L;

        public Container getContainer() {
            return GanttChartComponent.this;
        }
    }
}