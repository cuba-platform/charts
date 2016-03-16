/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 */
public class ExportMenuItem extends AbstractChartObject {

    private static final long serialVersionUID = 7821740492043242236L;

    private ExportFormat format;

    private String label;

    private String title;

    public ExportFormat getFormat() {
        return format;
    }

    public ExportMenuItem setFormat(ExportFormat format) {
        this.format = format;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public ExportMenuItem setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ExportMenuItem setTitle(String title) {
        this.title = title;
        return this;
    }
}