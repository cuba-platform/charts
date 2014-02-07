/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author artamonov
 * @version $Id$
 */
public class ExportMenuItem extends AbstractConfigurationObject {

    private static final long serialVersionUID = -7641875968839847097L;

    private String title;

    private ExportFormat format;

    public ExportMenuItem() {
    }

    public ExportMenuItem(ExportFormat format, String title) {
        this.format = format;
        this.title = title;
    }

    public ExportFormat getFormat() {
        return format;
    }

    public ExportMenuItem setFormat(ExportFormat format) {
        this.format = format;
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