/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model.gson;

import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.data.EntityDataItem;
import com.haulmont.chile.core.datatypes.Datatypes;
import com.haulmont.chile.core.datatypes.impl.EnumClass;
import com.haulmont.chile.core.model.Instance;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.chile.core.model.MetaPropertyPath;
import com.haulmont.chile.core.model.utils.InstanceUtils;
import com.haulmont.cuba.core.app.dynamicattributes.DynamicAttributesUtils;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.GuiDevelopmentException;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class PivotDataItemsSerializer {

    protected Messages messages = AppBeans.get(Messages.class);
    protected Metadata metadata = AppBeans.get(Metadata.class);
    protected UserSessionSource userSessionSource = AppBeans.get(UserSessionSource.class);

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
            if (item instanceof EntityDataItem) {
                EntityDataItem entityItem = (EntityDataItem) item;
                MetaClass metaClass = metadata.getClassNN(entityItem.getItem().getClass());
                MetaPropertyPath mpp = resolveMetaPropertyPath(metaClass, property);
                if (mpp != null) {
                    formattedValue = mpp.getRange().asDatatype().format(value, getUserLocale());
                } else {
                    formattedValue = getDateTimeFormattedValue(value, getUserLocale());
                }
            } else {
                formattedValue = getDateTimeFormattedValue(value, getUserLocale());
            }

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

    protected MetaPropertyPath resolveMetaPropertyPath(MetaClass metaClass, String property) {
        MetaPropertyPath mpp = metaClass.getPropertyPath(property);

        if (mpp == null && DynamicAttributesUtils.isDynamicAttribute(property)) {
            mpp = DynamicAttributesUtils.getMetaPropertyPath(metaClass, property);
        }

        return mpp;
    }

    protected String getDateTimeFormattedValue(Object value, Locale locale) {
        return Datatypes.getNN(Date.class).format(value, locale);
    }

    protected Locale getUserLocale() {
        return userSessionSource.checkCurrentUserSession() ?
                userSessionSource.getUserSession().getLocale() :
                messages.getTools().getDefaultLocale();
    }
}