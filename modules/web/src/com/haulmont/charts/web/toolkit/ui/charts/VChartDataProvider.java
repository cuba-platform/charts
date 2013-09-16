/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */
package com.haulmont.charts.web.toolkit.ui.charts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

public interface VChartDataProvider<T extends WChart> extends Serializable {

    void handleDataRequest(
            HttpServletRequest request,
            HttpServletResponse response,
            T chart
    ) throws ChartException;
}
