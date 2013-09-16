/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */
package com.haulmont.charts.web.toolkit.ui.charts;

public class ChartException extends Exception {
    public ChartException() {
    }

    public ChartException(String message) {
        super(message);
    }

    public ChartException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChartException(Throwable cause) {
        super(cause);
    }
}