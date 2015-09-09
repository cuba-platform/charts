/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author gorelov
 * @version $Id$
 */
public class ExportLibs extends AbstractChartObject {

    private static final long serialVersionUID = -729310699528694421L;

    private String path;

    public String getPath() {
        return path;
    }

    public ExportLibs setPath(String path) {
        this.path = path;
        return this;
    }
}
