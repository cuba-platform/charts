/*
 * Copyright (c) 2008-2020 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.charts.web.widgets.amcharts.events;

import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.web.widgets.amcharts.CubaAmchartsScene;
import com.vaadin.ui.Component;

public class RollOverGraphItemEvent extends Component.Event {

    private final String graphId;
    private final int itemIndex;
    private final DataItem dataItem;

    public RollOverGraphItemEvent(CubaAmchartsScene scene, String graphId, int itemIndex, DataItem dataItem) {
        super(scene);
        this.graphId = graphId;
        this.itemIndex = itemIndex;
        this.dataItem = dataItem;
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
