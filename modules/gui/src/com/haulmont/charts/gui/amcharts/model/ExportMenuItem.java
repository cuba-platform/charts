/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;


public class ExportMenuItem extends AbstractChartObject {

    private static final long serialVersionUID = 7821740492043242236L;

    private ExportFormat format;

    private String label;

    private String title;

    /**
     * A file name to use for generated export files.
     */
    private String fileName;

    /**
     * Default orientation is portrait.
     */
    private PageOrientation pageOrientation = PageOrientation.PORTRAIT;

    /**
     * A flag to show / hide the origin of the generated PDF ( pdf format only ). Default value is true
     */
    private Boolean pageOrigin = true;

    /**
     * The format of pdf list. Default value is A4;
     */
    private PageSize pageSize = PageSize.A4;

    /**
     * A quality of the resulting JPG image. Default value is 1. Available values 0 - 1.
     */
    private Double quality = 1.0;

    /**
     * Scale factor for the generated image.
     */
    private Double multiplier;

    /**
     * Delay by number of seconds.
     */
    private Double delay;

    /**
     * Enable or disable image optimization when printing. Default value is false;
     */
    private Boolean lossless = false;

    /**
     * A string to use as a column delimiter. Default value is ",".
     */
    private String delimiter = ",";

    /**
     * Set whether to enclose strings in doublequotes. Default value is true.
     */
    private Boolean quotes = true;

    /**
     * Set whether to escape strings. Default value is true.
     */
    private Boolean escape = true;

    /**
     * Add header row with column names. Work for CSV and XLSX format. Default value is true.
     */
    private Boolean withHeader = true;

    /**
     * The date format, work for XLSX format. Do not forget to set
     * parseDates to true in {@link CategoryAxis}.
     */
    private String dateFormat;

    /**
     * Convert all cell content to strings. Work for XLSX format.
     */
    private Boolean stringify;

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

    public String getFileName() {
        return fileName;
    }

    public ExportMenuItem setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public PageOrientation getPageOrientation() {
        return pageOrientation;
    }

    public ExportMenuItem setPageOrientation(PageOrientation pageOrientation) {
        this.pageOrientation = pageOrientation;
        return this;
    }

    public Boolean getPageOrigin() {
        return pageOrigin;
    }

    public ExportMenuItem setPageOrigin(Boolean pageOrigin) {
        this.pageOrigin = pageOrigin;
        return this;
    }

    public PageSize getPageSize() {
        return pageSize;
    }

    public ExportMenuItem setPageSize(PageSize pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Double getQuality() {
        return quality;
    }

    public ExportMenuItem setQuality(Double quality) {
        this.quality = quality;
        return this;
    }

    public Double getMultiplier() {
        return multiplier;
    }

    public ExportMenuItem setMultiplier(Double multiplier) {
        this.multiplier = multiplier;
        return this;
    }

    public Double getDelay() {
        return delay;
    }

    public ExportMenuItem setDelay(Double delay) {
        this.delay = delay;
        return this;
    }

    public Boolean getLossless() {
        return lossless;
    }

    public ExportMenuItem setLossless(Boolean lossless) {
        this.lossless = lossless;
        return this;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public ExportMenuItem setDelimiter(String delimiter) {
        this.delimiter = delimiter;
        return this;
    }

    public Boolean getQuotes() {
        return quotes;
    }

    public ExportMenuItem setQuotes(Boolean quotes) {
        this.quotes = quotes;
        return this;
    }

    public Boolean getEscape() {
        return escape;
    }

    public ExportMenuItem setEscape(Boolean escape) {
        this.escape = escape;
        return this;
    }

    public Boolean getWithHeader() {
        return withHeader;
    }

    public ExportMenuItem setWithHeader(Boolean withHeader) {
        this.withHeader = withHeader;
        return this;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public ExportMenuItem setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }

    public Boolean getStringify() {
        return stringify;
    }

    public ExportMenuItem setStringify(Boolean stringify) {
        this.stringify = stringify;
        return this;
    }
}