/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
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
