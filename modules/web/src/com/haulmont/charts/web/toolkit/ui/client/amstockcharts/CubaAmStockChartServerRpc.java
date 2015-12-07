/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amstockcharts;

import com.vaadin.shared.communication.ServerRpc;

import java.util.Date;

/**
 * @author gorelov
 * @version $Id$
 */
public interface CubaAmStockChartServerRpc extends ServerRpc {

    void onChartClick(int x, int y, int absoluteX, int absoluteY);

    void onChartRightClick(int x, int y, int absoluteX, int absoluteY);

    void onStockEventClick(String graphId, Date date, String stockEventId);

    void onStockEventRollOut(String graphId, Date date, String stockEventId);

    void onStockEventRollOver(String graphId, Date date, String stockEventId);

    void onZoom(Date startDate, Date endDate, String period);

    void onPeriodSelectorChange(Date startDate, Date endDate, String predefinedPeriod,
                                Integer count, int x, int y, int absoluteX, int absoluteY);

    void onDataSetSelectorCompare(String dataSetId);

    void onDataSetSelectorSelect(String dataSetId);

    void onDataSetSelectorUnCompare(String dataSetId);

    void onStockGraphClick(String panelId, String graphId, int x, int y, int absoluteX, int absoluteY);

    void onStockGraphRollOut(String panelId, String graphId, int x, int y, int absoluteX, int absoluteY);

    void onStockGraphRollOver(String panelId, String graphId, int x, int y, int absoluteX, int absoluteY);

    void onStockGraphItemClick(String panelId, String graphId, int itemIndex, String itemId,
                          int x, int y, int absoluteX, int absoluteY);

    void onStockGraphItemRightClick(String panelId, String graphId, int itemIndex, String itemId,
                          int x, int y, int absoluteX, int absoluteY);

    void onStockGraphItemRollOut(String panelId, String graphId, int itemIndex, String itemId,
                            int x, int y, int absoluteX, int absoluteY);

    void onStockGraphItemRollOver(String panelId, String graphId, int itemIndex, String itemId,
                             int x, int y, int absoluteX, int absoluteY);
}
