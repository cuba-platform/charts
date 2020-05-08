/*
 * Copyright (c) 2008-2019 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.charts.web.gui.serialization;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.data.EntityDataItem;
import com.haulmont.charts.web.widgets.pivottable.serialization.PivotJsonSerializationContext;
import com.haulmont.charts.web.widgets.pivottable.serialization.PivotTableSerializationContext;
import com.haulmont.chile.core.datatypes.Datatype;
import com.haulmont.chile.core.datatypes.Datatypes;
import com.haulmont.chile.core.datatypes.impl.EnumClass;
import com.haulmont.chile.core.model.Instance;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.chile.core.model.MetaPropertyPath;
import com.haulmont.cuba.core.app.dynamicattributes.DynamicAttributesUtils;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.GuiDevelopmentException;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.time.temporal.Temporal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

@Component(PivotTableDataItemsSerializer.NAME)
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PivotTableDataItemsSerializer {

    public static final String NAME = "charts_PivotTableDataItemsSerializer";

    protected Messages messages;
    protected Metadata metadata;
    protected UserSessionSource userSessionSource;

    @Inject
    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    @Inject
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @Inject
    public void setUserSessionSource(UserSessionSource userSessionSource) {
        this.userSessionSource = userSessionSource;
    }

    public JsonArray serialize(List<DataItem> items, JsonSerializationContext context) {
        return serialize(items, context, null);
    }

    public JsonArray serialize(List<DataItem> items, JsonSerializationContext context,
                               Consumer<PivotTableSerializationContext> postSerializationHandler) {
        JsonArray serialized = new JsonArray();

        if (context instanceof PivotJsonSerializationContext) {
            PivotJsonSerializationContext pivotContext = (PivotJsonSerializationContext) context;
            for (DataItem item : items) {
                JsonObject itemElement = new JsonObject();
                for (String property : pivotContext.getProperties()) {
                    Object value = item.getValue(property);
                    addProperty(itemElement, property, value, pivotContext, item);
                }

                if (postSerializationHandler != null) {
                    postSerializationHandler.accept(new PivotTableSerializationContext(item, itemElement, pivotContext));
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
            formattedValue = metadata.getTools().getInstanceName((Instance) value);
        } else if (value instanceof EnumClass) {
            formattedValue = messages.getMessage((Enum) value);
        } else if (value instanceof Date || value instanceof Temporal) {
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
                    "PivotTable doesn't support collections as properties", property), (String) null);
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
        Datatype<?> datatype = Datatypes.getNN(value.getClass());
        return datatype.format(value, locale);
    }

    protected Locale getUserLocale() {
        return userSessionSource.checkCurrentUserSession() ?
                userSessionSource.getUserSession().getLocale() :
                messages.getTools().getDefaultLocale();
    }
}
