/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.web.toolkit.ui.charts.jfree;

import com.haulmont.charts.toolkit.gwt.client.charts.jfree.VChartRenderer;
import com.haulmont.charts.web.controllers.ChartRenderingController;
import com.haulmont.charts.web.toolkit.ui.charts.CategoryChartComponent;
import com.haulmont.cuba.web.controllers.ControllerUtils;
import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;
import com.vaadin.ui.ClientWidget;

/**
 * <p>$Id$</p>
 *
 * @author zagumennikov
 */
@ClientWidget(VChartRenderer.class)
public abstract class JFreeCategoryChart extends CategoryChartComponent implements JFreeChart {
    private static final long serialVersionUID = -7073713483941791212L;

    @Override
    public String getVendor() {
        return VENDOR;
    }

    @Override
    public void paintContent(PaintTarget target) throws PaintException {
        super.paintContent(target);

        String controllerUrl = ControllerUtils.getControllerURL(ChartRenderingController.RENDERING_URL);
        target.addAttribute("renderUrl", controllerUrl);
    }
}