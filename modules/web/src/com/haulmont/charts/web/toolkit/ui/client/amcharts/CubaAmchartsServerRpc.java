/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts;

import com.vaadin.shared.communication.ServerRpc;

import javax.annotation.Nullable;
import java.util.Date;

public interface CubaAmchartsServerRpc extends ServerRpc {

    void onChartClick(int x, int y, int absoluteX, int absoluteY, double xAxis, double yAxis);

    void onChartRightClick(int x, int y, int absoluteX, int absoluteY, double xAxis, double yAxis);

    void onGraphClick(String graphId, int x, int y, int absoluteX, int absoluteY);

    void onGraphItemClick(String graphId, int itemIndex, String itemKey, int x, int y, int absoluteX, int absoluteY);

    void onGraphItemRightClick(String graphId, int itemIndex, String itemKey, int x, int y, int absoluteX, int absoluteY);

    void onZoom(int startIndex, int endIndex, Date startDate, Date endDate, String startValue, String endValue);

    void onSliceClick(int itemIndex, String dataItemKey, int x, int y, int absoluteX, int absoluteY);

    void onSliceRightClick(int itemIndex, String dataItemKey, int x, int y, int absoluteX, int absoluteY);

    void onSlicePullIn(String dataItemKey);

    void onSlicePullOut(String dataItemKey);

    void onLegendLabelClick(int legendItemIndex, @Nullable String dataItemKey);

    void onLegendMarkerClick(int legendItemIndex, @Nullable String dataItemKey);

    void onLegendItemHide(int legendItemIndex, @Nullable String dataItemKey);

    void onLegendItemShow(int legendItemIndex, @Nullable String dataItemKey);

    void onCursorZoom(String start, String end);

    void onCursorPeriodSelect(String start, String end);

    void onValueAxisZoom(String axisId, double startValue, double endValue);
}