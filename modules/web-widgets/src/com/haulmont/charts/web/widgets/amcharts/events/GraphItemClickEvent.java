/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.amcharts.events;

import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.web.widgets.amcharts.CubaAmchartsScene;

public class GraphItemClickEvent extends AbstractClickEvent {

    private static final long serialVersionUID = 5059266635532077593L;

    private final String graphId;

    private final int itemIndex;
    private final DataItem dataItem;

    public GraphItemClickEvent(CubaAmchartsScene scene, String graphId, int itemIndex,
                               DataItem dataItem, int x, int y, int absoluteX, int absoluteY) {
        super(scene, x, y, absoluteX, absoluteY);
        this.itemIndex = itemIndex;
        this.dataItem = dataItem;
        this.graphId = graphId;
    }

    public String getGraphId() {
        return graphId;
    }

    public int getItemIndex() {
        return itemIndex;
    }

    public DataItem getDataItem() {
        return dataItem;
    }
}