/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts;

import com.vaadin.shared.communication.ClientRpc;

import java.util.Date;

/**
 */
public interface CubaAmchartsSceneClientRpc extends ClientRpc {

    void updatePoints(String json);

    void zoomOut();

    void zoomToIndexes(int start, int end);

    void zoomToDates(Date start, Date end);
}
