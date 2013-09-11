package com.haulmont.charts.web.toolkit.ui.client.jsgantt;

import com.vaadin.shared.communication.ServerRpc;

/**
 * @author tsarevskiy
 * @version $Id$
 */
public interface JSGanttChartServerRPC extends ServerRpc {
    public void onClick(int itemId);
}
