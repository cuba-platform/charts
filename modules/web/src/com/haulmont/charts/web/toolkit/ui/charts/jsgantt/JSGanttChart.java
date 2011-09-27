/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.web.toolkit.ui.charts.jsgantt;

import com.haulmont.charts.toolkit.gwt.client.charts.jsgantt.VGanttChartRenderer;
import com.haulmont.charts.web.toolkit.ui.charts.GanttChartComponent;
import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;
import com.vaadin.ui.ClientWidget;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
@ClientWidget(VGanttChartRenderer.class)
public class JSGanttChart extends GanttChartComponent {

    public static final String VENDOR = "jsgantt";

    private boolean refresh = false;

    @Override
    public void paintContent(PaintTarget target) throws PaintException {
        super.paintContent(target);
        if (refresh)
            target.addAttribute(VGanttChartRenderer.CONFIG_KEY, "");
    }

    public void refresh() {
        refresh = true;
        requestRepaint();
    }

    @Override
    public String getVendor() {
        return VENDOR;
    }
}