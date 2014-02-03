/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.gantt;

import com.vaadin.data.Item;

import java.util.Map;

/**
 * @author artamonov
 * @version $Id$
 */
public interface TaskPropertiesProvider {

    /**
     * Generate new temporary task ids
     */
    void assignTaskIds();

    /**
     * Get properties for task
     * @param taskItem Task item
     * @return Properties map
     */
    Map<String, String> getTaskProperties(Item taskItem);
}