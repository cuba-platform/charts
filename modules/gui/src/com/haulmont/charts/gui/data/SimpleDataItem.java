/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.data;

import com.haulmont.chile.core.datatypes.impl.EnumClass;
import com.haulmont.chile.core.model.Instance;
import com.haulmont.chile.core.model.utils.InstanceUtils;
import com.haulmont.chile.core.model.utils.MethodsCache;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Messages;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Data item, which contains an instance of any class.
 */
public class SimpleDataItem implements DataItem {

    private static final long serialVersionUID = -283289357315588981L;

    private static transient Map<Class, MethodsCache> methodCacheMap = new ConcurrentHashMap<>();

    protected Messages messages = AppBeans.get(Messages.NAME);
    protected Object item;

    public SimpleDataItem(Object item) {
        this.item = item;
    }

    /**
     * @return item
     */
    public Object getItem() {
        return item;
    }

    /**
     * Sets item.
     *
     * @param item item to be set
     */
    public void setItem(Object item) {
        this.item = item;
    }

    /**
     * Returns the value of a property with the specified property name.
     * <p>
     * <p> Each property in a class which will be used by {@code SimpleDataItem} must have a {@code public} getter method.
     * Reflection is used to get property values.
     *
     * @param property name of property
     * @return the value of a property with the specified property name.
     * If property value is an instance of {@link com.haulmont.cuba.core.entity.Entity},
     * then method returns entity instance name by
     * {@link InstanceUtils#getInstanceName(com.haulmont.chile.core.model.Instance)}.
     * If property value is an instance of {@link EnumClass},
     * then method returns localized value for enum constant.
     * If property value is an instance of {@link Collection},
     * then method returns {@link List} of {@link SimpleDataItem}.
     * Otherwise method returns getter value
     */
    @Override
    public Object getValue(String property) {
        Object value = getMethodsCache().invokeGetter(item, property);

        if (value instanceof Entity) {
            return InstanceUtils.getInstanceName((Instance) value);
        }
        if (value instanceof EnumClass) {
            return messages.getMessage((Enum) value);
        }
        if (value instanceof Collection) {
            List<DataItem> items = new ArrayList<>();

            for (Object item : (Collection) value) {
                items.add(new SimpleDataItem(item));
            }
            return items;
        }
        return value;
    }

    protected MethodsCache getMethodsCache() {
        Class cls = item.getClass();
        return methodCacheMap.computeIfAbsent(cls, k -> new MethodsCache(cls));
    }
}