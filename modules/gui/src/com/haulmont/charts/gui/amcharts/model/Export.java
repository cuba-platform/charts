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

    private Color backgroundColor;

    private Boolean enabled = true;

    private String fileName;

    private ExportLibs libs;

    private List<ExportMenuItem> menu;

    private ExportPosition position;

    private Boolean removeImages;

    private Boolean exportTitles;

    private Boolean exportSelection;

    private String dataDateFormat;

    private String dateFormat;

    private Boolean keyListener;

    private Boolean fileListener;

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

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Export setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public Export setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public ExportPosition getPosition() {
        return position;
    }

    public Export setPosition(ExportPosition position) {
        this.position = position;
        return this;
    }

    public Boolean getRemoveImages() {
        return removeImages;
    }

    public Export setRemoveImages(Boolean removeImages) {
        this.removeImages = removeImages;
        return this;
    }

    public Boolean getExportTitles() {
        return exportTitles;
    }

    public Export setExportTitles(Boolean exportTitles) {
        this.exportTitles = exportTitles;
        return this;
    }

    public Boolean getExportSelection() {
        return exportSelection;
    }

    public Export setExportSelection(Boolean exportSelection) {
        this.exportSelection = exportSelection;
        return this;
    }

    public String getDataDateFormat() {
        return dataDateFormat;
    }

    public Export setDataDateFormat(String dataDateFormat) {
        this.dataDateFormat = dataDateFormat;
        return this;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public Export setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }

    public Boolean getKeyListener() {
        return keyListener;
    }

    public Export setKeyListener(Boolean keyListener) {
        this.keyListener = keyListener;
        return this;
    }

    public Boolean getFileListener() {
        return fileListener;
    }

    public Export setFileListener(Boolean fileListener) {
        this.fileListener = fileListener;
        return this;
    }
}