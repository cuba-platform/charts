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

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.BeanLocator;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.ComponentsHelper;
import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.components.actions.ListAction;
import com.haulmont.cuba.gui.components.data.meta.ContainerDataUnit;
import com.haulmont.cuba.gui.model.CollectionContainer;

import javax.inject.Inject;

import java.util.Collection;
import java.util.Collections;

/**
 * Gets items from {@link ListComponent} and shows them in new screen with pivot table component.
 */
@ActionType(ShowPivotAction.ID)
public class ShowPivotAction extends ListAction {

    public static final String ID = "pivot_showPivot";

    protected Messages messages;
    protected BeanLocator beanLocator;

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
                .build()
                .show();
    }
}