/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author artamonov
 * @version $Id$
 */
public class Export extends AbstractChartObject {

    private static final long serialVersionUID = -8908356283007782587L;

    private Boolean enabled = true;

    private ExportLibs libs;

    private List<ExportMenuItem> menu;

    public Boolean getEnabled() {
        return enabled;
    }

    public Export setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public ExportLibs getLibs() {
        return libs;
    }

    public Export setLibs(ExportLibs libs) {
        this.libs = libs;
        return this;
    }

    public List<ExportMenuItem> getMenu() {
        return menu;
    }

    public Export setMenu(List<ExportMenuItem> menu) {
        this.menu = menu;
        return this;
    }

    public Export addMenuItem(ExportMenuItem menuItem) {
        if (menu == null) {
            menu = new ArrayList<>();
        }
        menu.add(menuItem);

        return this;
    }
}