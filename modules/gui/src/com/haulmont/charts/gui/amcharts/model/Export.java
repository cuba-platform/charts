/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author artamonov
 * @version $Id$
 */
public class Export extends AbstractConfigurationObject {

    private static final long serialVersionUID = -8908356283007782587L;

    private String bottom;

    private Double buttonAlpha;

    private String buttonIcon;

    private Color buttonRollOverColor;

    private String buttonTitle;

    private Boolean exportJPG;

    private Boolean exportPDF;

    private Boolean exportPNG;

    private Boolean exportSVG;

    private Color imageBackgroundColor;

    private String imageFileName;

    private String left;

    private String right;

    private Color textRollOverColor;

    private String top;

    private ExportConfig userCFG;

    public String getBottom() {
        return bottom;
    }

    public Export setBottom(String bottom) {
        this.bottom = bottom;
        return this;
    }

    public Double getButtonAlpha() {
        return buttonAlpha;
    }

    public Export setButtonAlpha(Double buttonAlpha) {
        this.buttonAlpha = buttonAlpha;
        return this;
    }

    public String getButtonIcon() {
        return buttonIcon;
    }

    public Export setButtonIcon(String buttonIcon) {
        this.buttonIcon = buttonIcon;
        return this;
    }

    public Color getButtonRollOverColor() {
        return buttonRollOverColor;
    }

    public Export setButtonRollOverColor(Color buttonRollOverColor) {
        this.buttonRollOverColor = buttonRollOverColor;
        return this;
    }

    public String getButtonTitle() {
        return buttonTitle;
    }

    public Export setButtonTitle(String buttonTitle) {
        this.buttonTitle = buttonTitle;
        return this;
    }

    public Boolean getExportJPG() {
        return exportJPG;
    }

    public Export setExportJPG(Boolean exportJPG) {
        this.exportJPG = exportJPG;
        return this;
    }

    public Boolean getExportPDF() {
        return exportPDF;
    }

    public Export setExportPDF(Boolean exportPDF) {
        this.exportPDF = exportPDF;
        return this;
    }

    public Boolean getExportPNG() {
        return exportPNG;
    }

    public Export setExportPNG(Boolean exportPNG) {
        this.exportPNG = exportPNG;
        return this;
    }

    public Boolean getExportSVG() {
        return exportSVG;
    }

    public Export setExportSVG(Boolean exportSVG) {
        this.exportSVG = exportSVG;
        return this;
    }

    public Color getImageBackgroundColor() {
        return imageBackgroundColor;
    }

    public Export setImageBackgroundColor(Color imageBackgroundColor) {
        this.imageBackgroundColor = imageBackgroundColor;
        return this;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public Export setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
        return this;
    }

    public String getLeft() {
        return left;
    }

    public Export setLeft(String left) {
        this.left = left;
        return this;
    }

    public String getRight() {
        return right;
    }

    public Export setRight(String right) {
        this.right = right;
        return this;
    }

    public Color getTextRollOverColor() {
        return textRollOverColor;
    }

    public Export setTextRollOverColor(Color textRollOverColor) {
        this.textRollOverColor = textRollOverColor;
        return this;
    }

    public String getTop() {
        return top;
    }

    public Export setTop(String top) {
        this.top = top;
        return this;
    }

    public ExportConfig getUserCFG() {
        return userCFG;
    }

    public Export setUserCFG(ExportConfig userCFG) {
        this.userCFG = userCFG;
        return this;
    }
}