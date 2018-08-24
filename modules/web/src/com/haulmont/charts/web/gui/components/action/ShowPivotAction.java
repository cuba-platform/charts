/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.gui.components.action;

import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.haulmont.bali.util.ParamsMap;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.data.EntityDataItem;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.chile.core.model.MetaModel;
import com.haulmont.chile.core.model.MetaProperty;
import com.haulmont.chile.core.model.MetaPropertyPath;
import com.haulmont.chile.core.model.utils.InstanceUtils;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.security.entity.EntityAttrAccess;
import org.springframework.context.annotation.Scope;

import java.util.*;
import java.util.stream.Collectors;

import static com.haulmont.charts.web.gui.components.action.ShowPivotAction.ShowPivotMode.ALL_ROWS;
import static com.haulmont.charts.web.gui.components.action.ShowPivotAction.ShowPivotMode.SELECTED_ROWS;

/**
 * Gets all or selected rows from {@link ListComponent} and shows them in new screen with pivot table component.
 * <p>
 * Action's behaviour can be customized by providing arguments to constructor or setting properties.
 * <p>
 * In order to provide your own implementation globally, create a subclass and register it in {@code web-spring.xml},
 * for example:
 * <pre>
 * &lt;bean id="charts_ShowPivotAction" class="com.company.sample.gui.MyShowPivotAction" scope="prototype"/&gt;
 * </pre>
 * Also, use {@code create()} static methods instead of constructors when creating the action programmatically.
 */
@org.springframework.stereotype.Component(ShowPivotAction.NAME)
@Scope("prototype")
public class ShowPivotAction extends BaseAction implements Action.HasBeforeActionPerformedHandler {

    public static final String NAME = "charts_ShowPivotAction";
    public static final String ACTION_ID = "showPivotAction";
    public static final String SCREEN_ID = "chart$pivotTableScreen";

    protected List<String> includedProperties = new ArrayList<>();
    protected List<String> excludedProperties = new ArrayList<>();

    protected List<String> appliedProperties;

    protected String nativeJson;

    protected Metadata metadata = AppBeans.get(Metadata.NAME);

    protected Security security = AppBeans.get(Security.NAME);

    protected ViewRepository viewRepository = AppBeans.get(ViewRepository.NAME);

    protected BeforeActionPerformedHandler beforeActionPerformedHandler;

    protected enum ShowPivotMode {
        ALL_ROWS, SELECTED_ROWS
    }

    /**
     * Creates an action with default id.
     *
     * @param target component containing data to export
     */
    public static ShowPivotAction create(ListComponent target) {
        return AppBeans.getPrototype(NAME, target);
    }

    /**
     * Creates an action with specified id.
     *
     * @param target component containing data to export
     * @param id     action's id
     */
    public static ShowPivotAction create(ListComponent target, String id) {
        return AppBeans.getPrototype(NAME, target, id);
    }

    /**
     * The simplest constructor. The action uses default id and other parameters.
     *
     * @param target component containing data to export
     */
    public ShowPivotAction(ListComponent target) {
        this(target, ACTION_ID);
    }

    /**
     * Constructor allows to specify action's name.
     *
     * @param target component containing data to export
     * @param id     action's name
     */
    public ShowPivotAction(ListComponent target, String id) {
        super(id);

        this.target = target;
    }

    @Override
    public void actionPerform(Component component) {
        if (beforeActionPerformedHandler != null) {
            if (!beforeActionPerformedHandler.beforeActionPerformed())
                return;
        }

        if (target.getSelected().isEmpty()
                || target.getDatasource().size() <= 1) {
            showPivotTable(ALL_ROWS);
        } else {
            Action[] actions = new Action[]{
                    new BaseAction("actions.showPivotAction.SELECTED_ROWS")
                            .withCaption(messages.getMainMessage("actions.showPivotAction.SELECTED_ROWS"))
                            .withHandler(event -> showPivotTable(SELECTED_ROWS)),
                    new BaseAction("actions.showPivotAction.ALL_ROWS")
                            .withCaption(messages.getMainMessage("actions.showPivotAction.ALL_ROWS"))
                            .withHandler(event -> showPivotTable(ALL_ROWS)),
                    new DialogAction(DialogAction.Type.CANCEL)
            };

            target.getFrame().showOptionDialog(
                    messages.getMainMessage("actions.showPivotAction.dialogTitle"),
                    messages.getMainMessage("actions.showPivotAction.dialogMessage"),
                    Frame.MessageType.CONFIRMATION,
                    actions);
        }
    }

    protected void showPivotTable(ShowPivotMode mode) {
        ParamsMap paramsMap = ParamsMap.of();

        if (mode == ALL_ROWS) {
            paramsMap.pair("dataItems", convertEntitiesToDataItems(target.getDatasource().getItems()));
        } else {
            paramsMap.pair("dataItems", convertEntitiesToDataItems(target.getSelected()));
        }

        paramsMap.pair("properties", getPropertiesWithLocale());
        paramsMap.pair("nativeJson", nativeJson);

        target.getFrame().openWindow(SCREEN_ID, WindowManager.OpenType.NEW_TAB, paramsMap.create());
    }

    /**
     * @return list of included properties
     */
    public List<String> getIncludedProperties() {
        return includedProperties;
    }

    /**
     * Set included properties list using fluent API method. If included properties aren't set, all properties in the
     * view will be shown, otherwise only included properties will be shown in the pivot table unless
     * {@link ShowPivotAction#withExcludedProperties(List)} is not set.
     *
     * @param includedProperties list of included properties
     * @return current instance of action
     */
    public ShowPivotAction withIncludedProperties(List<String> includedProperties) {
        this.includedProperties = includedProperties;

        appliedProperties = new ArrayList<>(includedProperties);

        return this;
    }

    /**
     * @return list of excluded properties
     */
    public List<String> getExcludedProperties() {
        return excludedProperties;
    }

    /**
     * Set excluded properties list using fluent API method.
     * <br>
     * Note, if it is used without {@link ShowPivotAction#withIncludedProperties(List)}, excluded properties will be
     * applied for all properties in the view.
     *
     * @param excludedProperties list of excluded properties
     * @return current instance of action
     */
    public ShowPivotAction withExcludedProperties(List<String> excludedProperties) {
        this.excludedProperties = excludedProperties;

        return this;
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
     * 	}
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
     * 	},
     * 	"autoSortUnusedProperties": true,
     * 	"aggregationProperties": ["localized property", "localized property"],
     * 	"aggregations": {
     * 		"selectedAggregation": "count",
     * 		"aggregations": [{
     * 			"id": "647780f0-c6d0-6ade-a63a-542b5c8cdbd5",
     * 			"mode": "count",
     * 			"caption": "Count"
     * 		}, {
     * 			"id": "c2663238-2654-67f0-2dec-add6962d867c",
     * 			"mode": "sumOverSum"
     * 		}]
     * 	}
     * }
     * }
     * </pre>
     *
     * @param nativeJson configuration json of pivot table
     * @return current instance of action
     */
    public ShowPivotAction withNativeJson(String nativeJson) {
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

    @Override
    public BeforeActionPerformedHandler getBeforeActionPerformedHandler() {
        return beforeActionPerformedHandler;
    }

    @Override
    public void setBeforeActionPerformedHandler(BeforeActionPerformedHandler handler) {
        this.beforeActionPerformedHandler = handler;
    }

    protected List<DataItem> convertEntitiesToDataItems(Collection entities) {
        List<DataItem> dataItems = new ArrayList<>();

        for (Object entity : entities) {
            dataItems.add(new EntityDataItem((Entity) entity));
        }

        return dataItems;
    }

    protected void applyExcludedProperties(List<String> propertiesList, List<String> excludedProperties) {
        if (propertiesList == null || propertiesList.isEmpty()) {
            return;
        }

        for (String property : excludedProperties) {
            propertiesList.remove(property);
        }
    }

    protected List<String> getAllProperties(MetaClass metaClass) {
        View view = target.getDatasource().getView();
        if (view != null && !view.getProperties().isEmpty()) {
            return view.getProperties().stream()
                    .map(ViewProperty::getName)
                    .collect(Collectors.toList());
        }

        if (metadata.getTools().isNotPersistent(metaClass)) {
            return metaClass.getProperties().stream()
                    .map(MetaProperty::getName)
                    .collect(Collectors.toList());
        }

        view = getView(metaClass);
        return view.getProperties().stream()
                .map(ViewProperty::getName)
                .collect(Collectors.toList());
    }

    protected List<String> removeNonExistingProperties(List<String> propertiesList, MetaClass metaClass) {
        List<String> result = new ArrayList<>();

        View view = target.getDatasource().getView();
        if (view != null && !view.getProperties().isEmpty()) {
            for (String property : propertiesList) {
                if (isPropertyPath(property) && viewContainsPropertyPath(view, property)) {
                    result.add(property);
                } else if (view.containsProperty(property)) {
                    result.add(property);
                }
            }
            return result;
        }

        if (metadata.getTools().isNotPersistent(metaClass)) {
            for (String property : propertiesList) {
                if (metaClass.getPropertyPath(property) != null) {
                    result.add(property);
                }
            }

            return result;
        }

        view = getView(metaClass);
        for (String property : propertiesList) {
            if (isPropertyPath(property) && viewContainsPropertyPath(view, property)) {
                result.add(property);
            } else if (view.containsProperty(property)) {
                result.add(property);
            }
        }

        return result;
    }

    protected boolean isPropertyPath(String property) {
        String[] strings = InstanceUtils.parseValuePath(property);
        return strings.length > 1;
    }

    protected boolean viewContainsPropertyPath(View view, String property) {
        String[] properties = InstanceUtils.parseValuePath(property);
        View currentView = view;
        for (int i = 0; i < properties.length; i++) {
            if (currentView == null) {
                return false;
            }

            ViewProperty viewProperty = currentView.getProperty(properties[i]);
            if (viewProperty == null) {
                return false;
            }

            currentView = viewProperty.getView();
            if (currentView == null && (i + 1 == properties.length)) {
                return true;
            }
        }
        return false;
    }

    protected Map<String, String> getPropertiesWithLocale() {
        Map<String, String> resultMap = new HashMap<>();

        MetaClass metaClass = target.getDatasource().getMetaClass();

        if (appliedProperties == null || appliedProperties.isEmpty()) {
            appliedProperties = getAllProperties(metaClass);
        }

        if (!excludedProperties.isEmpty()) {
            applyExcludedProperties(appliedProperties, excludedProperties);
        }

        appliedProperties = removeNonExistingProperties(appliedProperties, metaClass);

        for (String property : appliedProperties) {
            MetaPropertyPath metaPropertyPath = metaClass.getPropertyPath(property);

            if (metaPropertyPath == null) {
                continue;
            }

            MetaProperty metaProperty = metaPropertyPath.getMetaProperty();
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
        if (metadata.getTools().isSystem(metaProperty)
                || metadata.getTools().isSystemLevel(metaProperty)
                || metaProperty.getRange().getCardinality().isMany()
                || !isPermitted(metaClass, metaProperty)) {
            return false;
        }

        if (metaProperty.getRange().isDatatype() && (isByteArray(metaProperty) || isUuid(metaProperty))) {
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

    protected View getView(MetaClass metaClass) {
        View localView = viewRepository.getView(metaClass, View.LOCAL);
        View minimalView = viewRepository.getView(metaClass, View.MINIMAL);
        View view = new View(localView.getEntityClass(), "entitiesView", false);
        copyViewProperties(localView, view, metaClass);
        copyViewProperties(minimalView, view, metaClass);
        return view;
    }

    protected void copyViewProperties(View src, View target, MetaClass metaClass) {
        for (ViewProperty viewProperty : src.getProperties()) {
            MetaProperty metaProperty = metaClass.getProperty(viewProperty.getName());
            if (metaProperty == null || !metadata.getTools().isSystemLevel(metaProperty)) {
                if (!target.containsProperty(viewProperty.getName())) {
                    target.addProperty(viewProperty.getName(), viewProperty.getView(), viewProperty.getFetchMode());
                }
            }
        }
    }
}