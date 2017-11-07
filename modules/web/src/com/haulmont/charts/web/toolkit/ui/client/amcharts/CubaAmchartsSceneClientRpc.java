/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts;

import com.vaadin.shared.communication.ClientRpc;
import elemental.json.JsonObject;

import java.util.Date;

public interface CubaAmchartsSceneClientRpc extends ClientRpc {

    void draw(String chartJson);

    void updatePoints(String json);

    void zoomOut();

    void zoomToIndexes(int start, int end);

    void zoomToDates(Date start, Date end);

    void zoomOutValueAxes();

    void zoomOutValueAxisById(String id);

    void zoomOutValueAxisByIndex(int index);

    void zoomValueAxisToValuesById(String id, String startValue, String endValue);

    void zoomValueAxisToValuesByIndex(int index, String startValue, String endValue);

    void zoomValueAxisToDatesById(String id, Date start, Date end);

    void zoomValueAxisToDatesByIndex(int index, Date start, Date end);
}