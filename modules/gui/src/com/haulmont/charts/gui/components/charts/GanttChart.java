/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.gui.components.charts;

import com.haulmont.cuba.gui.components.Component;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
public interface GanttChart extends Chart, Component.Wrapper, Component.BelongToFrame,
        Component.HasXmlDescriptor, Component.Expandable, Component.HasCaption {

    String NAME = "ganttChart";

    void refresh();
}