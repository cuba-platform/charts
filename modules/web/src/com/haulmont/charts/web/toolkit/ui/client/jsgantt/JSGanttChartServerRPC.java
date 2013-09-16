/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.jsgantt;

import com.vaadin.shared.communication.ServerRpc;

/**
 * @author tsarevskiy
 * @version $Id$
 */
public interface JSGanttChartServerRPC extends ServerRpc {
    public void onClick(int itemId);
}
