package com.haulmont.charts.web.widgets.client.amcharts.events;

import com.google.gwt.core.client.JavaScriptObject;

public class JsCategoryItemClickEvent extends JavaScriptObject {

    protected JsCategoryItemClickEvent() {
    }

    public final native String getValue() /*-{
        if (this.value) {
            return this.value;
        }
        return null;
    }-*/;

    public final native int getX() /*-{
        return this.event.x;
    }-*/;

    public final native int getY() /*-{
        return this.event.y;
    }-*/;

    public final native int getOffsetX() /*-{
        return this.event.offsetX;
    }-*/;

    public final native int getOffsetY() /*-{
        return this.event.offsetY;
    }-*/;

    public final native int getXAxis() /*-{
        return this.axis.x;
    }-*/;

    public final native int getYAxis() /*-{
        return this.axis.y;
    }-*/;
}
