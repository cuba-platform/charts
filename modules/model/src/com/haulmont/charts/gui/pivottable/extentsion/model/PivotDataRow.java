/*
 * Copyright (c) 2008-2019 Haulmont.
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

package com.haulmont.charts.gui.pivottable.extentsion.model;

import java.io.Serializable;
import java.util.List;

public class PivotDataRow implements Serializable {

    protected Integer tableRowNumber;

    protected List<PivotDataCell> cells;

    public Integer getTableRowNumber() {
        return tableRowNumber;
    }

    public void setTableRowNumber(Integer tableRowNumber) {
        this.tableRowNumber = tableRowNumber;
    }

    public List<PivotDataCell> getCells() {
        return cells;
    }

    public void setCells(List<PivotDataCell> cells) {
        this.cells = cells;
    }
}
