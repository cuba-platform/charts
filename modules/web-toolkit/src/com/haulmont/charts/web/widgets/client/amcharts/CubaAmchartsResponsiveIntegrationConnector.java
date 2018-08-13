/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.client.amcharts;

import com.haulmont.charts.web.widgets.amcharts.CubaAmchartsResponsiveIntegration;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.shared.ui.Connect;

@Connect(CubaAmchartsResponsiveIntegration.class)
public class CubaAmchartsResponsiveIntegrationConnector extends AbstractExtensionConnector {
    @Override
    protected void extend(ServerConnector target) {
        // do nothing
        // this extension simply adds JavaScript include
    }
}