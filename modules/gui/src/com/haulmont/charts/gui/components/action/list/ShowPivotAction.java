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

import com.google.common.base.Strings;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.BeanLocator;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.ComponentsHelper;
import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.components.actions.ListAction;
import com.haulmont.cuba.gui.components.data.meta.ContainerDataUnit;
import com.haulmont.cuba.gui.meta.StudioAction;
import com.haulmont.cuba.gui.meta.StudioPropertiesItem;
import com.haulmont.cuba.gui.model.CollectionContainer;

import javax.inject.Inject;

import java.util.*;

/**
 * Gets items from {@link ListComponent} and shows them in new screen with pivot table component.
 */
@StudioAction(category = "List Actions", description = "Gets items from Table/DataGrid and shows them in a new screen with PivotTable component")
@ActionType(ShowPivotAction.ID)
public class ShowPivotAction extends ListAction {

    public static final String ID = "pivot_showPivot";

    protected Messages messages;
    protected BeanLocator beanLocator;

    protected String includedProperties;
    protected String excludedProperties;

    /**
     * Provides two modes for exporting rows from component.
     */
    protected enum ShowPivotMode {
        ALL_ROWS, SELECTED_ROWS
    }

    public ShowPivotAction() {
        super(ID);
    }

    public ShowPivotAction(String id) {
        super(id);
    }

    @Inject
    protected void setMessages(Messages messages) {
        this.messages = messages;
        this.caption = messages.getMainMessage("actions.showPivotAction.caption");
    }

    @Inject
    protected void setBeanLocator(BeanLocator beanLocator) {
        this.beanLocator = beanLocator;
    }

    /**
     * Set excluded properties separated by a comma. Excluded properties will not be shown in the PivotTable.
     *
     * @param properties excluded properties
     */
    @StudioPropertiesItem(
            name = "excludedProperties",
            description = "Set excluded properties separated by a comma. Excluded properties will not be shown in the PivotTable")
    public void setExcludedProperties(String properties) {
        excludedProperties = properties;
    }

    public String getExcludedProperties() {
        return excludedProperties;
    }

    /**
     * @return list with parsed excluded properties
     */
    public List<String> getExcludedPropertiesList() {
        if (Strings.isNullOrEmpty(excludedProperties)) {
            return Collections.emptyList();
        }
        return parseProperties(excludedProperties);
    }

    /**
     * Sets included properties separated by a comma. Only included properties will be shown in the PivotTable.
     *
     * @param properties included properties
     */
    @StudioPropertiesItem(
            name = "includedProperties", description = "Sets included properties separated by a comma. Only included properties will be shown in the PivotTable")
    public void setIncludedProperties(String properties) {
        includedProperties = properties;
    }

    public String getIncludedProperties() {
        return includedProperties;
    }

    /**
     * @return list with parsed included properties
     */
    public List<String> getIncludedPropertiesList() {
        if (Strings.isNullOrEmpty(includedProperties)) {
            return Collections.emptyList();
        }
        return parseProperties(includedProperties);
    }

    @Override
    public void actionPerform(Component component) {
        if (!hasSubscriptions(ActionPerformedEvent.class)) {
            if (target == null) {
                throw new IllegalStateException("ShowPivotAction target is not set");
            }

            if (needShowAll()) {
                showPivotTable(ShowPivotMode.ALL_ROWS);
            } else {
                Action[] actions = new Action[]{
                        new BaseAction("actions.showPivotAction.SELECTED_ROWS")
                                .withCaption(messages.getMainMessage("actions.showPivotAction.SELECTED_ROWS"))
                                .withPrimary(true)
                                .withHandler(event -> showPivotTable(ShowPivotMode.SELECTED_ROWS)),
                        new BaseAction("actions.showPivotAction.ALL_ROWS")
                                .withCaption(messages.getMainMessage("actions.showPivotAction.ALL_ROWS"))
                                .withHandler(event -> showPivotTable(ShowPivotMode.ALL_ROWS)),
                        new DialogAction(DialogAction.Type.CANCEL)
                };

                Dialogs dialogs = ComponentsHelper.getScreenContext(target).getDialogs();
                dialogs.createOptionDialog()
                        .withCaption(messages.getMainMessage("actions.showPivotAction.dialogTitle"))
                        .withMessage(messages.getMainMessage("actions.showPivotAction.dialogMessage"))
                        .withType(Dialogs.MessageType.CONFIRMATION)
                        .withActions(actions)
                        .show();
            }
        } else {
            super.actionPerform(component);
        }
    }

    protected boolean needShowAll() {
        if (target.getSelected().isEmpty()
                || !(target.getItems() instanceof ContainerDataUnit)) {
            return true;
        }

        CollectionContainer container = ((ContainerDataUnit) target.getItems()).getContainer();
        return container != null && container.getItems().size() <= 1;
    }

    protected List<String> parseProperties(String properties) {
        if (Strings.isNullOrEmpty(properties)) {
            return Collections.emptyList();
        }

        properties = properties.replace(" ", "");
        if (properties.isEmpty()) {
            return Collections.emptyList();
        }

        String[] propertiesArray = properties.split(",");
        return Arrays.asList(propertiesArray);
    }

    @SuppressWarnings("unchecked")
    protected void showPivotTable(ShowPivotMode mode) {
        Frame frame = target.getFrame();
        if (frame == null) {
            throw new IllegalStateException(
                    String.format("ShowPivotAction cannot be used by component '%s' which is not added to frame",
                            target.getId()));
        }

        Collection<Entity> items;
        if (ShowPivotMode.ALL_ROWS.equals(mode)) {
            if (target.getItems() instanceof ContainerDataUnit) {
                CollectionContainer container = ((ContainerDataUnit) target.getItems()).getContainer();
                items = container.getItems();
            } else {
                items = Collections.emptyList();
            }
        } else {
            items = target.getSelected();
        }

        PivotScreenBuilder showPivotManager = beanLocator.getPrototype(PivotScreenBuilder.NAME, target);
        showPivotManager.withItems(items)
                .withIncludedProperties(parseProperties(includedProperties))
                .withExcludedProperties(parseProperties(excludedProperties))
                .build()
                .show();
    }
}