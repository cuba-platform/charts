/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.gui.components.charts;

import com.haulmont.charts.core.entity.GanttChartItem;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.data.CollectionDatasource;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
public interface GanttChart extends Chart, Component.Wrapper, Component.BelongToFrame,
        Component.HasXmlDescriptor, Component.HasCaption {

    String NAME = "ganttChart";

    CollectionDatasource getCollectionDatasource();

    void setCollectionDatasource(CollectionDatasource datasource);

    void setShowStartDate(boolean showStartDate);
    boolean getShowStartDate();

    void setShowEndDate(boolean showEndDate);
    boolean getShowEndDate();


    void setShowDuration(boolean showDuration);
    boolean getShowDuration();

    void setShowResource(boolean showResource);
    boolean getShowResource();

    void setShowInitiator(boolean showInitiator);
    boolean getShowInitiator();

    void setShowComplete(boolean showComplete);
    boolean getShowComplete();

    void setDateFormat(String dateTimeFormat);
    String getDateFormat();


    void setTaskClickListener(TaskClickListener taskClickListener);
    TaskClickListener getTaskClickListener();

    String getMessagePack();
    void setMessagePack(String messagePack);

    interface TaskClickListener {
        void performClick(GanttChartItem taskItem);
    }
}