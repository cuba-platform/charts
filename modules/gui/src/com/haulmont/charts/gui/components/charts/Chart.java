/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */
package com.haulmont.charts.gui.components.charts;

import com.haulmont.charts.gui.amcharts.model.charts.AbstractChart;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.data.CollectionDatasource;

/**
 * @author artamonov
 * @version $Id$
 */
public interface Chart extends Component, Component.BelongToFrame, Component.HasXmlDescriptor {

    String NAME = "chart";

    AbstractChart getConfiguration();
    void setConfiguration(AbstractChart chart);

    void setDatasource(CollectionDatasource datasource);
    CollectionDatasource getDatasource();

    void repaint();
}