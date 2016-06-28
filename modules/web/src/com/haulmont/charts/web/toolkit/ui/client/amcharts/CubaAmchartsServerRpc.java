/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts;

import com.vaadin.shared.communication.ServerRpc;

import java.util.Date;

public interface CubaAmchartsServerRpc extends ServerRpc {

    void onChartClick(int x, int y, int absoluteX, int absoluteY, double xAxis, double yAxis);

    void onChartRightClick(int x, int y, int absoluteX, int absoluteY, double xAxis, double yAxis);

    void onGraphClick(String graphId, int x, int y, int absoluteX, int absoluteY);

    void onGraphItemClick(String graphId, int itemIndex, String itemId, int x, int y, int absoluteX, int absoluteY);

    void onGraphItemRightClick(String graphId, int itemIndex, String itemId, int x, int y, int absoluteX, int absoluteY);

    void onZoom(int startIndex, int endIndex, Date startDate, Date endDate, String startValue, String endValue);

    void onSliceClick(String sliceId, int x, int y, int absoluteX, int absoluteY);

    void onSlicePullIn(String sliceId);

    void onSlicePullOut(String sliceId);

    void onSliceRightClick(String sliceId, int x, int y, int absoluteX, int absoluteY);

    void onLegendLabelClick(String itemId);

    void onLegendMarkerClick(String itemId);

    void onLegendItemHide(String itemId);

    void onLegendItemShow(String itemId);

    void onCursorZoom(String start, String end);

    void onCursorPeriodSelect(String start, String end);

    void onValueAxisZoom(String axisId, double startValue, double endValue);
}