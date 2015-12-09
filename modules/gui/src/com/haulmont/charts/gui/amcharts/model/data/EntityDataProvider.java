/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.data;

import com.haulmont.charts.gui.amcharts.model.charts.AbstractChart;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author gorelov
 * @version $Id$
 */
public class EntityDataProvider implements DataProvider {

    private static final long serialVersionUID = -631516572260683521L;

    protected AbstractChart chart;

    protected final CollectionDatasource datasource;
    protected final List<ConfigurationChangeListener> changeListeners = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public EntityDataProvider(CollectionDatasource datasource) {
        this.datasource = datasource;

        this.datasource.addCollectionChangeListener(e -> {
            switch (e.getOperation()) {
                case ADD:
                    fireDataAdded(e.getItems());
                    break;
                case REMOVE:
                    fireDataRemoved(e.getItems());
                    break;
                case UPDATE:
                    fireDataUpdated(e.getItems());
                    break;
                case REFRESH:
                case CLEAR:
                    fireDataRefreshed();
                    break;
            }
        });
    }

    protected void fireDataAdded(List items) {
        for (Object entityItem : items) {
            Entity entity = (Entity) entityItem;

            DataAddedEvent dataAddedEvent = new DataAddedEvent(new EntityDataItem(this, entity));
            List<ConfigurationChangeListener> changeListeners = new ArrayList<>(this.changeListeners);
            for (ConfigurationChangeListener listener : changeListeners) {
                listener.dataAdded(dataAddedEvent);
            }
        }
    }

    protected void fireDataRemoved(List items) {
        for (Object entityItem : items) {
            Entity entity = (Entity) entityItem;

            DataRemovedEvent dataRemovedEvent = new DataRemovedEvent(new EntityDataItem(this, entity));
            List<ConfigurationChangeListener> changeListeners = new ArrayList<>(this.changeListeners);
            for (ConfigurationChangeListener listener : changeListeners) {
                listener.dataRemoved(dataRemovedEvent);
            }
        }
    }

    protected void fireDataUpdated(List items) {
        for (Object entityItem : items) {
            Entity entity = (Entity) entityItem;

            DataUpdatedEvent dataUpdatedEvent = new DataUpdatedEvent(new EntityDataItem(this, entity));
            List<ConfigurationChangeListener> changeListeners = new ArrayList<>(this.changeListeners);
            for (ConfigurationChangeListener listener : changeListeners) {
                listener.dataUpdated(dataUpdatedEvent);
            }
        }
    }

    protected void fireDataRefreshed() {
        List<ConfigurationChangeListener> changeListeners = new ArrayList<>(this.changeListeners);
        for (ConfigurationChangeListener listener : changeListeners) {
            listener.dataRefreshed();
        }
    }

    @Override
    public List<DataItem> getItems() {
        List<DataItem> items = new ArrayList<>();

        for (Object entityItem : datasource.getItems()) {
            Entity entity = (Entity) entityItem;

            items.add(new EntityDataItem(this, entity));
        }
        return items;
    }

    @Override
    public void addItem(DataItem item) {
    }

    @Override
    public void addItems(Collection<DataItem> items) {
    }

    @Override
    public void updateItem(DataItem item) {
    }

    @Override
    public void removeItem(DataItem item) {
    }

    public CollectionDatasource getDatasource() {
        return datasource;
    }

    @Override
    public void addChangeListener(ConfigurationChangeListener listener) {
        if (!changeListeners.contains(listener)) {
            changeListeners.add(listener);
        }
    }

    @Override
    public void removeChangeListener(ConfigurationChangeListener listener) {
        changeListeners.remove(listener);
    }
}
