/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.web.toolkit.ui.charts;

import com.vaadin.data.Item;

import java.util.Map;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
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
    Map<String, Object> getTaskProperties(Item taskItem);
}