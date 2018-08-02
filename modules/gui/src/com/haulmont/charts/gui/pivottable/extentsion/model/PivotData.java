/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.extentsion.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PivotData implements Serializable {

    protected Integer dataNumRows;
    protected Integer dataNumCols;

    protected List<PivotDataRow> headRows;
    protected List<PivotDataRow> bodyRows;

    public Integer getDataNumRows() {
        return dataNumRows;
    }

    public void setDataNumRows(Integer dataNumRows) {
        this.dataNumRows = dataNumRows;
    }

    public Integer getDataNumCols() {
        return dataNumCols;
    }

    public void setDataNumCols(Integer dataNumCols) {
        this.dataNumCols = dataNumCols;
    }

    public List<PivotDataRow> getHeadRows() {
        return headRows;
    }

    public void setHeadRows(List<PivotDataRow> headRows) {
        this.headRows = headRows;
    }

    public List<PivotDataRow> getBodyRows() {
        return bodyRows;
    }

    public void setBodyRows(List<PivotDataRow> bodyRows) {
        this.bodyRows = bodyRows;
    }

    public List<PivotDataRow> getAllRows() {
        List<PivotDataRow> pivotDataRows = new ArrayList<>();
        pivotDataRows.addAll(headRows);
        pivotDataRows.addAll(bodyRows);
        return pivotDataRows;
    }
}
