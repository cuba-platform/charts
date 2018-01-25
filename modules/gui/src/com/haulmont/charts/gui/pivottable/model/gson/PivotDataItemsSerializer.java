/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model.gson;

import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.data.EntityDataItem;
import com.haulmont.chile.core.datatypes.impl.EnumClass;
import com.haulmont.chile.core.model.Instance;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.chile.core.model.MetaProperty;
import com.haulmont.chile.core.model.utils.InstanceUtils;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.GuiDevelopmentException;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class PivotDataItemsSerializer {

    protected Messages messages = AppBeans.get(Messages.class);
    protected Metadata metadata = AppBeans.get(Metadata.class);

    public List<JsonObject> serialize(List<DataItem> items, JsonSerializationContext context) {
        List<JsonObject> serialized = new ArrayList<>();

        if (context instanceof PivotJsonSerializationContext) {
            PivotJsonSerializationContext pivotContext = (PivotJsonSerializationContext) context;
            for (DataItem item : items) {
                JsonObject itemElement = new JsonObject();
                for (String property : pivotContext.getProperties()) {
                    Object value = item.getValue(property);
                    addProperty(itemElement, property, value, pivotContext, item);
                }

                serialized.add(itemElement);
            }
        }

        return serialized;
    }

    protected void addProperty(JsonObject jsonObject, String property, Object value,
                               PivotJsonSerializationContext context, DataItem item) {
        Object formattedValue;
        if (value == null) {
            formattedValue = StringUtils.EMPTY;
        } else if (value instanceof Entity) {
            formattedValue = InstanceUtils.getInstanceName((Instance) value);
        } else if (value instanceof EnumClass) {
            formattedValue = messages.getMessage((Enum) value);
        } else if (value instanceof Date) {
            String formatStr;
            if (item instanceof EntityDataItem) {
                EntityDataItem entityItem = (EntityDataItem) item;
                MetaClass metaClass = metadata.getClassNN(entityItem.getItem().getClass());
                MetaProperty metaProperty = metaClass.getPropertyNN(property);

                Class type = metaProperty.getRange().asDatatype().getJavaClass();
                if (type.equals(java.sql.Date.class)) {
                    formatStr = messages.getMainMessage("dateFormat");
                } else if (type.equals(Time.class)) {
                    formatStr = messages.getMainMessage("timeFormat");
                } else {
                    formatStr = messages.getMainMessage("dateTimeFormat");
                }
            } else {
                formatStr = messages.getMainMessage("dateTimeFormat");
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat(formatStr);
            formattedValue = dateFormat.format((Date) value);
        } else if (value instanceof Boolean) {
            formattedValue = BooleanUtils.isTrue((Boolean) value)
                    ? messages.getMainMessage("boolean.yes")
                    : messages.getMainMessage("boolean.no");
        } else if (value instanceof Collection) {
            throw new GuiDevelopmentException(String.format("'%s' cannot be added as a property, because " +
                    "PivotTable doesn't support collections as properties", property), null);
        } else {
            formattedValue = value;
        }

        jsonObject.add(context.getLocalizedPropertyName(property), context.serialize(formattedValue));
    }
}