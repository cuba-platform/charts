/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amstockcharts;

import com.vaadin.shared.communication.ClientRpc;

/**
 * @author gorelov
 * @version $Id$
 */
public interface CubaAmStockChartSceneClientRpc extends ClientRpc {

    void updatePoints(String json);
}
