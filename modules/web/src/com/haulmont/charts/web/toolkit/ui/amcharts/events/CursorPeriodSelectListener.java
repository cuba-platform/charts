/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts.events;

/**
 * Note: set selectWithoutZooming for Cursor to true.
 *
 * @author artamonov
 * @version $Id$
 */
public interface CursorPeriodSelectListener {
    void onSelect(CursorPeriodSelectEvent event);
}