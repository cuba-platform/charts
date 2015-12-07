/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.data;

import com.haulmont.charts.gui.amcharts.model.charts.AbstractChart;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Data provider for chart.
 *
 * @author artamonov
 * @version $Id$
 */
public interface DataProvider extends Serializable {

    String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss:S";

    void bindToChart(AbstractChart chart);

    void bindWiredFields(List<String> wiredFields);

    List<DataItem> getItems();

    AbstractChart getChart();

    void addItem(DataItem item);

    void addItems(Collection<DataItem> items);

    boolean contains(DataItem item);

    void updateItem(DataItem item);

    void removeItem(DataItem item);

    String getDateFormat();

    void addChangeListener(ConfigurationChangeListener listener);

    void removeChangeListener(ConfigurationChangeListener listener);
}