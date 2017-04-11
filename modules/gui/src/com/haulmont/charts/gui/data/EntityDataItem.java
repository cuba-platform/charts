/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.data;

import com.haulmont.chile.core.model.Instance;
import com.haulmont.cuba.core.entity.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Chart data item, which contains an instance of an {@link com.haulmont.cuba.core.entity.Entity}.
 */
public class EntityDataItem implements DataItem, DataItem.HasId {

    private static final long serialVersionUID = -2703129637028051748L;

    protected final Entity item;

    public EntityDataItem(Entity item) {
        this.item = item;
    }

    /**
     * Returns the value of entity property with the specified property name.
     *
     * @param property name of entity property
     * @return the value of entity property with the specified property name.
     * <ul>
     * <li>If property value is an instance of {@link Collection},
     * then method returns {@link List} of {@link EntityDataItem}.</li>
     * <li>Otherwise method returns value by {@link Instance#getValue(java.lang.String)}</li>
     * </ul>
     */
    @Override
    public Object getValue(String property) {
        Object value = item.getValue(property);
        if (value instanceof Collection) {
            List<DataItem> items = new ArrayList<>();

            for (Object item : (Collection) value) {
                items.add(new EntityDataItem((Entity) item));
            }
            return items;
        }
        return value;
    }

    /**
     * @return contained entity
     */
    public Entity getItem() {
        return item;
    }

    @Override
    public Object getId() {
        return item.getId();
    }
}