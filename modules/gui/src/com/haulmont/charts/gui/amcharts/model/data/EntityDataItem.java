/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.data;

import com.haulmont.chile.core.datatypes.impl.EnumClass;
import com.haulmont.chile.core.model.Instance;
import com.haulmont.chile.core.model.utils.InstanceUtils;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Messages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
* @author gorelov
* @version $Id$
*/
public class EntityDataItem implements DataItem {

    private static final long serialVersionUID = -2703129637028051748L;

    protected Messages messages = AppBeans.get(Messages.NAME);
    protected final Entity item;

    public EntityDataItem(Entity item) {
        this.item = item;
    }

    @Override
    public Object getValue(String property) {
        Object value = item.getValue(property);
        if (value instanceof Entity) {
            return InstanceUtils.getInstanceName((Instance) value);
        }
        if (value instanceof EnumClass) {
            return messages.getMessage((Enum) value);
        }
        if (value instanceof Collection) {
            List<DataItem> items = new ArrayList<>();

            for (Object item : (Collection) value) {
                items.add(new EntityDataItem((Entity) item));
            }
            return items;
        }
        return value;
    }
}
