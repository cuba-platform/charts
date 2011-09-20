/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.haulmont.charts.web.toolkit.ui.charts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

public interface VChartDataProvider<T extends VChart> extends Serializable {

    void handleDataRequest(
            HttpServletRequest request,
            HttpServletResponse response,
            T chart
    ) throws ChartException;
}
