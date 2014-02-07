/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author artamonov
 * @version $Id$
 */
public class ExportMenu extends AbstractConfigurationObject {

    private static final long serialVersionUID = -7641875968839847097L;

    private Align textAlign;

    private JsFunction onclick;

    private String icon;

    private String iconTitle;

    private List<ExportMenuItem> items;

    private ExportFormat format;

    public String getIcon() {
        return icon;
    }

    public ExportMenu setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getIconTitle() {
        return iconTitle;
    }

    public ExportMenu setIconTitle(String iconTitle) {
        this.iconTitle = iconTitle;
        return this;
    }

    public List<ExportMenuItem> getItems() {
        return items;
    }

    public ExportMenu setItems(List<ExportMenuItem> items) {
        this.items = items;
        return this;
    }

    public ExportMenu addItems(ExportMenuItem... items) {
        if (items != null) {
            if (this.items == null) {
                this.items = new ArrayList<>();
            }
            this.items.addAll(Arrays.asList(items));
        }
        return this;
    }

    public JsFunction getOnclick() {
        return onclick;
    }

    public ExportMenu setOnclick(JsFunction onclick) {
        this.onclick = onclick;
        return this;
    }

    public Align getTextAlign() {
        return textAlign;
    }

    public ExportMenu setTextAlign(Align textAlign) {
        this.textAlign = textAlign;
        return this;
    }

    public ExportFormat getFormat() {
        return format;
    }

    public ExportMenu setFormat(ExportFormat format) {
        this.format = format;
        return this;
    }
}