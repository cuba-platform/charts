/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

/**
 * @author artamonov
 * @version $Id$
 */
public class NumberFormatter extends AbstractConfigurationObject {

    private static final long serialVersionUID = -6672745908840387292L;

    private Integer precision;

    private String decimalSeparator;

    private String thousandsSeparator;

    public String getDecimalSeparator() {
        return decimalSeparator;
    }

    public NumberFormatter setDecimalSeparator(String decimalSeparator) {
        this.decimalSeparator = decimalSeparator;
        return this;
    }

    public Integer getPrecision() {
        return precision;
    }

    public NumberFormatter setPrecision(Integer precision) {
        this.precision = precision;
        return this;
    }

    public String getThousandsSeparator() {
        return thousandsSeparator;
    }

    public NumberFormatter setThousandsSeparator(String thousandsSeparator) {
        this.thousandsSeparator = thousandsSeparator;
        return this;
    }
}