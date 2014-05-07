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
public class ExportConfig extends AbstractConfigurationObject {

    private static final long serialVersionUID = 3973480345155361978L;

    private String menuTop;

    private String menuLeft;

    private String menuRight;

    private String menuBottom;

    private List<ExportMenu> menuItems;

    private ExportMenuItemStyle menuItemStyle;

    private ExportMenuItemOutput menuItemOutput;

    public String getMenuBottom() {
        return menuBottom;
    }

    public ExportConfig setMenuBottom(String menuBottom) {
        this.menuBottom = menuBottom;
        return this;
    }

    public List<ExportMenu> getMenuItems() {
        return menuItems;
    }

    public ExportConfig setMenuItems(List<ExportMenu> menuItems) {
        this.menuItems = menuItems;
        return this;
    }

    public ExportConfig addMenu(ExportMenu... menuItems) {
        if (menuItems != null) {
            if (this.menuItems == null) {
                this.menuItems = new ArrayList<>();
            }
            this.menuItems.addAll(Arrays.asList(menuItems));
        }
        return this;
    }

    public ExportMenuItemStyle getMenuItemStyle() {
        return menuItemStyle;
    }

    public ExportConfig setMenuItemStyle(ExportMenuItemStyle menuItemStyle) {
        this.menuItemStyle = menuItemStyle;
        return this;
    }

    public String getMenuLeft() {
        return menuLeft;
    }

    public ExportConfig setMenuLeft(String menuLeft) {
        this.menuLeft = menuLeft;
        return this;
    }

    public String getMenuRight() {
        return menuRight;
    }

    public ExportConfig setMenuRight(String menuRight) {
        this.menuRight = menuRight;
        return this;
    }

    public String getMenuTop() {
        return menuTop;
    }

    public ExportConfig setMenuTop(String menuTop) {
        this.menuTop = menuTop;
        return this;
    }

    public ExportMenuItemOutput getMenuItemOutput() {
        return menuItemOutput;
    }

    public ExportConfig setMenuItemOutput(ExportMenuItemOutput exportMenuItemOutput) {
        this.menuItemOutput = exportMenuItemOutput;
        return this;
    }
}