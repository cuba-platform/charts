/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import java.util.ArrayList;
import java.util.List;

public class Export extends AbstractChartObject {

    private static final long serialVersionUID = -8908356283007782587L;

    private static final String DEFAULT_FILE_NAME = "chart";

    private Color backgroundColor;

    private Boolean enabled = true;

    private String fileName = DEFAULT_FILE_NAME;

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

    /**
     * @return true if export functionality is enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * Set enabled to false if you want to disable export functionality.
     *
     * @param enabled enabled option
     */
    public Export setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * @return 3rd party required library settings
     */
    public ExportLibs getLibs() {
        return libs;
    }

    /**
     * Sets 3rd party required library settings.
     *
     * @param libs export libs
     */
    public Export setLibs(ExportLibs libs) {
        this.libs = libs;
        return this;
    }

    /**
     * @return a list of menu or submenu items
     */
    public List<ExportMenuItem> getMenu() {
        return menu;
    }

    /**
     * Sets a list of menu or submenu items.
     *
     * @param menu list of menu
     */
    public Export setMenu(List<ExportMenuItem> menu) {
        this.menu = menu;
        return this;
    }

    /**
     * Adds menu item.
     *
     * @param menuItem menu item
     */
    public Export addMenuItem(ExportMenuItem menuItem) {
        if (menu == null) {
            menu = new ArrayList<>();
        }
        menu.add(menuItem);
        return this;
    }

    /**
     * @return the color for the background of the exported image
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Sets the color for the background of the exported image.
     *
     * @param backgroundColor color
     */
    public Export setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * @return file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets a file name that used for generated export files (an extension will be appended to it based on the export
     * format).
     *
     * @param fileName file name
     */
    public Export setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    /**
     * @return a position of export icon
     */
    public ExportPosition getPosition() {
        return position;
    }

    /**
     * Sets a position of export icon. Possible values: "top-left", "top-right" (default), "bottom-left",
     * "bottom-right".
     *
     * @param position position
     */
    public Export setPosition(ExportPosition position) {
        this.position = position;
        return this;
    }

    /**
     * @return true if removeImages is enabled
     */
    public Boolean getRemoveImages() {
        return removeImages;
    }

    /**
     * If true, export checks for and removes "tainted" images that area loaded from different domains.
     *
     * @param removeImages removeImages option
     */
    public Export setRemoveImages(Boolean removeImages) {
        this.removeImages = removeImages;
        return this;
    }

    /**
     * @return true if exportTitles is enabled
     */
    public Boolean getExportTitles() {
        return exportTitles;
    }

    /**
     * Set exportTitles to true if the data field names should be replaced with it's dedicated title (data export only).
     *
     * @param exportTitles exportTitles option
     */
    public Export setExportTitles(Boolean exportTitles) {
        this.exportTitles = exportTitles;
        return this;
    }

    /**
     * @return true if only current data selection is exported
     */
    public Boolean getExportSelection() {
        return exportSelection;
    }

    /**
     * Set exportSelection to true if you want to export the current data selection only (data export only).
     *
     * @param exportSelection exportSelection option
     */
    public Export setExportSelection(Boolean exportSelection) {
        this.exportSelection = exportSelection;
        return this;
    }

    /**
     * @return data date format
     */
    public String getDataDateFormat() {
        return dataDateFormat;
    }

    /**
     * Sets data date format to convert date strings to date objects. Uses by default charts dataDateFormat (data
     * export only).
     *
     * @param dataDateFormat data date format
     */
    public Export setDataDateFormat(String dataDateFormat) {
        this.dataDateFormat = dataDateFormat;
        return this;
    }

    /**
     * @return date format
     */
    public String getDateFormat() {
        return dateFormat;
    }

    /**
     * Formats the category field in given date format (data export only).
     *
     * @param dateFormat date format
     */
    public Export setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }

    /**
     * @return true if keyListener is enabled
     */
    public Boolean getKeyListener() {
        return keyListener;
    }

    /**
     * If true it observes the pressed keys to undo/redo the annotations.
     *
     * @param keyListener keyListener option
     */
    public Export setKeyListener(Boolean keyListener) {
        this.keyListener = keyListener;
        return this;
    }

    /**
     * @return true if fileListener is enabled
     */
    public Boolean getFileListener() {
        return fileListener;
    }

    /**
     * If true it observes the drag and drop feature and loads the dropped image file into the annotation.
     *
     * @param fileListener fileListener option
     */
    public Export setFileListener(Boolean fileListener) {
        this.fileListener = fileListener;
        return this;
    }
}