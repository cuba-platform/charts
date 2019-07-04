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

package com.haulmont.charts.gui.components.action.list;

import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.haulmont.bali.util.ParamsMap;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.data.EntityDataItem;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.chile.core.model.MetaModel;
import com.haulmont.chile.core.model.MetaProperty;
import com.haulmont.chile.core.model.MetaPropertyPath;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.Frame;
import com.haulmont.cuba.gui.components.ListComponent;
import com.haulmont.cuba.gui.components.data.meta.ContainerDataUnit;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.entity.EntityAttrAccess;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

import static com.haulmont.cuba.gui.screen.UiControllerUtils.getScreenContext;

/**
 * Prepares data and builds a screen with pivot table component.
 *
 * @see ShowPivotAction
 */
@Component(PivotScreenBuilder.NAME)
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PivotScreenBuilder {
    public static final String NAME = "charts_pivotScreenBuilder";

    public static final String SCREEN_ID = "chart$pivotTableScreen";

    protected Metadata metadata;
    protected ViewRepository viewRepository;
    protected Messages messages;
    protected Security security;

    protected List<String> includedProperties;
    protected List<String> excludedProperties;
    protected List<String> additionalProperties;

    protected List<DataItem> dataItems;
    protected String nativeJson;

    protected ListComponent target;

    public PivotScreenBuilder(ListComponent target) {
        this.target = target;
    }

    @Inject
    protected void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @Inject
    protected void setViewRepository(ViewRepository viewRepository) {
        this.viewRepository = viewRepository;
    }

    @Inject
    protected void setMessages(Messages messages) {
        this.messages = messages;
    }

    @Inject
    protected void setSecurity(Security security) {
        this.security = security;
    }

    /**
     * @return list of included properties
     */
    public List<String> getIncludedProperties() {
        if (includedProperties == null) {
            return Collections.emptyList();
        }
        return includedProperties;
    }

    /**
     * Set included properties list using fluent API method. If included properties aren't set, all properties in the
     * view will be shown, otherwise only included properties will be shown in the pivot table unless
     * {@link com.haulmont.charts.gui.components.action.ShowPivotAction#withExcludedProperties(List)} is not set.
     *
     * @param includedProperties list of included properties
     * @return current instance of action
     */
    public PivotScreenBuilder withIncludedProperties(List<String> includedProperties) {
        this.includedProperties = includedProperties;

        return this;
    }

    /**
     * @return list of excluded properties
     */
    public List<String> getExcludedProperties() {
        if (excludedProperties == null) {
            return Collections.emptyList();
        }
        return excludedProperties;
    }

    /**
     * Set excluded properties list using fluent API method.
     * <br>
     * Note, if it is used without {@link com.haulmont.charts.gui.components.action.ShowPivotAction#withIncludedProperties(List)}, excluded properties will be
     * applied for all properties in the view.
     *
     * @param excludedProperties list of excluded properties
     * @return current instance
     */
    public PivotScreenBuilder withExcludedProperties(List<String> excludedProperties) {
        this.excludedProperties = excludedProperties;

        return this;
    }

    /**
     * Set properties which should be additionally included. Additional property doesn't applied if excluded
     * properties list contains it.
     *
     * @param additionalProperties list of additional properties
     * @return current instance of action
     */
    public PivotScreenBuilder withAdditionalProperties(List<String> additionalProperties) {
        this.additionalProperties = additionalProperties;

        return this;
    }

    /**
     * @return list of additionally included properties
     */
    public List<String> getAdditionalProperties() {
        if (additionalProperties == null) {
            return Collections.emptyList();
        }
        return additionalProperties;
    }

    /**
     * @return configuration json of pivot table
     */
    public String getNativeJson() {
        return nativeJson;
    }

    /**
     * Set native json using fluent API method. Using native json you can configure pivot table with initial values.
     * For instance, for non-editable pivot table:
     * <pre> {@code
     * {
     * 	"cols": ["localized property", "localized property"],
     * 	"rows": ["localized property"],
     * 	"editable": false,
     * 	"renderer": "heatmap",
     * 	"aggregation": {
     * 		"id": "d8fc3fdf-730d-c94f-a0c8-72a9ce3dcb3a",
     * 		"mode": "sumOverSum",
     * 		"properties": ["localized property", "localized property"]
     *    }
     * }
     * }
     * </pre>
     * for editable pivot table:
     * <pre> {@code
     * {
     * 	"cols": ["localized property"],
     * 	"rows": ["localized property"],
     * 	"editable": true,
     * 	"renderers": {
     * 		"selectedRenderer": "barChart"
     *    },
     * 	"autoSortUnusedProperties": true,
     * 	"aggregationProperties": ["localized property", "localized property"],
     * 	"aggregations": {
     * 		"selectedAggregation": "count",
     * 		"aggregations": [{
     * 			"id": "647780f0-c6d0-6ade-a63a-542b5c8cdbd5",
     * 			"mode": "count",
     * 			"caption": "Count"
     *        }, {
     * 			"id": "c2663238-2654-67f0-2dec-add6962d867c",
     * 			"mode": "sumOverSum"
     *        }]
     *    }
     * }
     * }
     * </pre>
     *
     * @param nativeJson configuration json of pivot table
     * @return current instance of action
     */
    public PivotScreenBuilder withNativeJson(String nativeJson) {
        if (nativeJson != null) {
            try {
                JsonParser parser = new JsonParser();
                parser.parse(nativeJson);
            } catch (JsonSyntaxException e) {
                throw new IllegalStateException("Unable to parse JSON chart configuration");
            }
        }

        this.nativeJson = nativeJson;

        return this;
    }

    /**
     * Sets items that should be shown in PivotTable.
     *
     * @param items collection of entities
     * @return current instance
     */
    public PivotScreenBuilder withItems(Collection<? extends Entity> items) {
        dataItems = new ArrayList<>(items.size());
        for (Entity entity : items) {
            dataItems.add(new EntityDataItem(entity));
        }
        return this;
    }

    /**
     * @return created screen
     */
    public Screen build() {
        Frame frame = target.getFrame();
        if (frame == null) {
            throw new IllegalStateException(
                    String.format("ShowPivotManager cannot be used by component '%s' which is not added to frame",
                            target.getId()));
        }

        FrameOwner origin = frame.getFrameOwner();
        Screens screens = getScreenContext(origin).getScreens();

        if (dataItems == null) {
            dataItems = Collections.emptyList();
        }

        Map<String, String> properties = getPropertiesWithLocale();

        MapScreenOptions options = new MapScreenOptions(
                ParamsMap.of("dataItems", dataItems,
                             "properties", properties,
                             "nativeJson", nativeJson));
        return screens.create(SCREEN_ID, OpenMode.NEW_TAB, options);
    }

    protected Map<String, String> getPropertiesWithLocale() {
        Map<String, String> resultMap = new HashMap<>();

        ContainerDataUnit containerDataUnit = (ContainerDataUnit) target.getItems();
        View view = containerDataUnit.getContainer().getView();
        MetaClass metaClass = containerDataUnit.getEntityMetaClass();

        List<String> appliedProperties = includedProperties == null ?
                new ArrayList<>() : new ArrayList<>(includedProperties);

        if (appliedProperties.isEmpty()) {
            appliedProperties.addAll(getPropertiesFromView(metaClass, view));
            appliedProperties.addAll(getEmbeddedIdProperties(metaClass));
        }

        appliedProperties.addAll(additionalProperties == null ?
                Collections.emptyList() : additionalProperties);

        // exclude properties
        if (!CollectionUtils.isEmpty(excludedProperties)) {
            appliedProperties.removeAll(excludedProperties);
        }

        appliedProperties = removeNonExistingProperties(appliedProperties, metaClass, view);

        for (String property : appliedProperties) {
            MetaPropertyPath mpp = metaClass.getPropertyPath(property);
            if (mpp == null) {
                continue;
            }

            MetaProperty metaProperty = mpp.getMetaProperty();
            MetaModel metaModel = metaProperty.getModel();
            MetaClass propertyMetaClass;

            propertyMetaClass = metaModel == null ?
                    metaClass : metaModel.getClass(metaProperty.getDeclaringClass());

            if (!isManagedProperty(metaProperty, propertyMetaClass)) {
                continue;
            }

            resultMap.put(property, messages.getTools().getPropertyCaption(metaProperty));
        }

        return resultMap;
    }

    protected boolean isManagedProperty(MetaProperty metaProperty, MetaClass metaClass) {
        if (metadata.getTools().isSystemLevel(metaProperty)
                || metaProperty.getRange().getCardinality().isMany()
                || !isPermitted(metaClass, metaProperty)) {
            return false;
        }

        if (metaProperty.getRange().isDatatype() && (isByteArray(metaProperty) || isUuid(metaProperty))) {
            return false;
        }

        // id is system property, so it should be checked before isSystem() checking
        if (isIdProperty(metaProperty.getName(), metaClass)) {
            return true;
        }

        if (metadata.getTools().isSystem(metaProperty)) {
            return false;
        }

        return true;
    }

    protected boolean isPermitted(MetaClass metaClass, MetaProperty metaProperty) {
        return security.isEntityAttrPermitted(metaClass, metaProperty.getName(), EntityAttrAccess.VIEW);
    }

    protected boolean isByteArray(MetaProperty metaProperty) {
        return metaProperty.getRange().asDatatype().getJavaClass().equals(byte[].class);
    }

    protected boolean isUuid(MetaProperty metaProperty) {
        return metaProperty.getRange().asDatatype().getJavaClass().equals(UUID.class);
    }

    protected List<String> getPropertiesFromView(MetaClass metaClass, View view) {
        if (metadata.getTools().isNotPersistent(metaClass)) {
            return metaClass.getProperties().stream()
                    .map(MetaProperty::getName)
                    .collect(Collectors.toList());
        }

        view = view == null ? getBaseView(metaClass) : view;
        if (view.getProperties().isEmpty()) {
            return Collections.emptyList();
        }

        return view.getProperties().stream()
                .map(ViewProperty::getName)
                .collect(Collectors.toList());
    }

    protected View getBaseView(MetaClass metaClass) {
        return viewRepository.getView(metaClass, View.BASE);
    }

    protected List<String> getEmbeddedIdProperties(MetaClass metaClass) {
        List<String> result = new ArrayList<>();

        if (hasEmbeddedId(metaClass)) {
            MetaClass embeddedMetaClass = getEmbeddedIdMetaClass(metaClass);
            if (embeddedMetaClass == null) {
                return null;
            }

            String primaryKey = metadata.getTools().getPrimaryKeyName(metaClass);
            for (MetaProperty metaProperty : embeddedMetaClass.getOwnProperties()) {
                result.add(primaryKey + "." + metaProperty.getName());
            }
        }
        return result;
    }

    protected boolean hasEmbeddedId(MetaClass metaClass) {
        return metadata.getTools().hasCompositePrimaryKey(metaClass);
    }

    protected MetaClass getEmbeddedIdMetaClass(MetaClass metaClass) {
        String primaryKey = metadata.getTools().getPrimaryKeyName(metaClass);
        if (primaryKey == null) {
            return null;
        }

        MetaProperty metaProperty = metaClass.getPropertyNN(primaryKey);

        MetaModel metaModel = metaProperty.getModel();
        // in this case we should use `metaProperty.getJavaType()` because
        // we need to get class type of EmbeddedId property and then get MetaClass of it
        return metaModel == null ?
                null : metaModel.getClass(metaProperty.getJavaType());
    }

    protected List<String> removeNonExistingProperties(List<String> properties, MetaClass metaClass, View view) {
        if (metadata.getTools().isNotPersistent(metaClass)) {
            return properties.stream()
                    .filter(s -> metaClass.getPropertyPath(s) != null)
                    .collect(Collectors.toList());
        }

        List<String> result = new ArrayList<>();
        view = view == null ? getBaseView(metaClass) : view;

        for (String property : properties) {
            MetaPropertyPath mpp = metaClass.getPropertyPath(property);
            // is nested property and view contains it
            if (mpp != null && metadata.getTools().viewContainsProperty(view, mpp)) {
                result.add(property);
                // simple property
            } else if (view.containsProperty(property)) {
                result.add(property);
                // id property
            } else if (isIdProperty(property, metaClass)) {
                result.add(property);
                // EmbeddedId's property
            } else if (hasEmbeddedId(metaClass)
                    && isEmbeddedIdProperty(property, metaClass)) {
                result.add(property);
                // if metaClass contains property path, we need to check nested entities in view
            } else if (mpp != null) {
                for (MetaProperty metaProperty : mpp.getMetaProperties()) {
                    MetaClass propertyMetaClass = getPropertyMetaClass(metaProperty);
                    if (propertyMetaClass == null) {
                        propertyMetaClass = metaClass;
                    }
                    // EmbeddedId's property
                    if (isEmbeddedIdProperty(property, propertyMetaClass)) {
                        result.add(property);
                        // Id property
                    } else if (isIdProperty(metaProperty.getName(), propertyMetaClass)) {
                        result.add(property);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Checks if current MetaClass contains given id property.
     *
     * @param property  property to check
     * @param metaClass metaClass
     * @return true if MetaClass contains given id property
     */
    protected boolean isIdProperty(String property, MetaClass metaClass) {
        String primaryId = metadata.getTools().getPrimaryKeyName(metaClass);
        return property.equals(primaryId);
    }

    protected boolean isEmbeddedIdProperty(String property, MetaClass metaClass) {
        MetaClass embeddedMetaClass = getEmbeddedIdMetaClass(metaClass);
        if (embeddedMetaClass == null) {
            return false;
        }

        String[] propertyPathParts = property.split("\\.");
        String propertyName = propertyPathParts[propertyPathParts.length - 1];

        MetaProperty metaProperty = embeddedMetaClass.getProperty(propertyName);

        return embeddedMetaClass.getOwnProperties().contains(metaProperty);
    }

    protected MetaClass getPropertyMetaClass(MetaProperty metaProperty) {
        MetaModel metaModel = metaProperty.getModel();

        return metaModel == null ?
                null : metaModel.getClass(metaProperty.getDeclaringClass());
    }
}
