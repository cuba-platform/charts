/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.web.toolkit.ui.charts.jfree;

import com.haulmont.charts.toolkit.gwt.client.charts.jfree.JFreeChartRenderer;
import com.haulmont.charts.web.toolkit.ui.charts.XYChartComponent;
import com.vaadin.ui.ClientWidget;

/**
 * <p>$Id$</p>
 *
 * @author zagumennikov
 */
@ClientWidget(JFreeChartRenderer.class)
public abstract class JFreeXYChart extends XYChartComponent implements JFreeChart {
    private static final long serialVersionUID = -8367704232221959253L;

    public String getVendor() {
        return VENDOR;
    }
}