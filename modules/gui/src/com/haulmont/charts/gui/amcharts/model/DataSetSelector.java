/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * See documentation for properties of DataSetSelector JS object. <br/>
 *
 * <a href="http://docs.amcharts.com/3/javascriptstockchart/DataSetSelector">http://docs.amcharts.com/3/javascriptstockchart/DataSetSelector</a>
 *
 * @author gorelov
 * @version $Id$
 */
public class DataSetSelector extends AbstractChartObject {

    private static final long serialVersionUID = 3890644574314511185L;

    private String comboBoxSelectText;

    private String compareText;

    private Integer listHeight;

    private Position position;

    private String selectText;

    private Integer width;

    public String getComboBoxSelectText() {
        return comboBoxSelectText;
    }

    public DataSetSelector setComboBoxSelectText(String comboBoxSelectText) {
        this.comboBoxSelectText = comboBoxSelectText;
        return this;
    }

    public String getCompareText() {
        return compareText;
    }

    public DataSetSelector setCompareText(String compareText) {
        this.compareText = compareText;
        return this;
    }

    public Integer getListHeight() {
        return listHeight;
    }

    public DataSetSelector setListHeight(Integer listHeight) {
        this.listHeight = listHeight;
        return this;
    }

    public Position getPosition() {
        return position;
    }

    public DataSetSelector setPosition(Position position) {
        this.position = position;
        return this;
    }

    public String getSelectText() {
        return selectText;
    }

    public DataSetSelector setSelectText(String selectText) {
        this.selectText = selectText;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public DataSetSelector setWidth(Integer width) {
        this.width = width;
        return this;
    }
}
