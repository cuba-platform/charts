/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.extentsion.model;

public class PivotDataSeparatedCell {

    protected String id;

    protected String value;

    protected int indexRow;
    protected int indexCol;

    protected int colSpan;
    protected int rowSpan;

    protected PivotDataCell.Type type;

    protected Boolean isBold = false;

    public PivotDataSeparatedCell() {
    }

    public PivotDataSeparatedCell(String value, int rowSpan, int colSpan, PivotDataCell.Type type, Boolean isBold) {
        this.value = value;

        this.rowSpan = rowSpan;
        this.colSpan = colSpan;

        this.type = type;
        this.isBold = isBold;
    }

    public PivotDataSeparatedCell(PivotDataSeparatedCell cell) {
        this.id = cell.getId();

        this.value = cell.getValue();

        this.rowSpan = cell.getRowSpan();
        this.colSpan = cell.getColSpan();

        this.type = cell.getType();
        this.isBold = cell.isBold();

        this.indexCol = cell.getIndexCol();
        this.indexRow = cell.getIndexRow();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getIndexRow() {
        return indexRow;
    }

    public void setIndexRow(int indexRow) {
        this.indexRow = indexRow;
    }

    public int getIndexCol() {
        return indexCol;
    }

    public void setIndexCol(int indexCol) {
        this.indexCol = indexCol;
    }

    public int getColSpan() {
        return colSpan;
    }

    public void setColSpan(int colSpan) {
        this.colSpan = colSpan;
    }

    public int getRowSpan() {
        return rowSpan;
    }

    public void setRowSpan(int rowSpan) {
        this.rowSpan = rowSpan;
    }

    public PivotDataCell.Type getType() {
        return type;
    }

    public void setType(PivotDataCell.Type type) {
        this.type = type;
    }

    public boolean isBold() {
        return isBold;
    }

    public void setBold(boolean bold) {
        isBold = bold;
    }
}
