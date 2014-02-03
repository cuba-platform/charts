/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.gantt;

import com.vaadin.data.Container;

import java.util.Map;

/**
 * @author artamonov
 * @version $Id$
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