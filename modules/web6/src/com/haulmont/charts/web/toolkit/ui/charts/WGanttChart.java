/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.web.toolkit.ui.charts;

import com.vaadin.data.Container;

import java.util.Map;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
public interface WGanttChart extends WChart, Container.Viewer,
        Container, Container.ItemSetChangeNotifier, Container.ItemSetChangeListener,
        Container.PropertySetChangeNotifier, Container.PropertySetChangeListener {

    TaskPropertiesProvider getPropertiesProvider();

    void setPropertiesProvider(TaskPropertiesProvider propertiesProvider);

    void setShowDuration(boolean showDuration);

    boolean getShowDuration();

    void setShowResource(boolean showResource);

    boolean getShowResource();

    void setShowInitiator(boolean showInitiator);

    boolean getShowInitiator();

    void setShowComplete(boolean showComplete);

    boolean getShowComplete();

    void setTaskItemClickListener(TaskItemClickListener clickListener);

    TaskItemClickListener getTaskItemClickListener();

    Map<String, String> getLocaleDict();

    void setLocaleDict(Map<String, String> localeDict);

    interface TaskItemClickListener {
        void handleClick(Integer itemId);
    }
}