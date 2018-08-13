package com.haulmont.charts.web.widgets.amcharts.events;

import com.haulmont.charts.web.widgets.amcharts.CubaAmchartsScene;

public class CategoryItemClickEvent extends com.vaadin.ui.Component.Event {

    private String value;

    private int offsetX;
    private int offsetY;

    private int x;
    private int y;

    private int xAxis;
    private int yAxis;

    public CategoryItemClickEvent(CubaAmchartsScene source, String value, int x, int y,
                                  int offsetX, int offsetY, int xAxis, int yAxis) {
        super(source);
        this.value = value;
        this.x = x;
        this.y = y;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getXAxis() {
        return xAxis;
    }

    public void setXAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public int getYAxis() {
        return yAxis;
    }

    public void setYAxis(int yAxis) {
        this.yAxis = yAxis;
    }
}
