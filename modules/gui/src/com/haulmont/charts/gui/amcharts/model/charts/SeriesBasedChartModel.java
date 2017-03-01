/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.CategoryAxis;
import com.haulmont.charts.gui.amcharts.model.Scrollbar;

public interface SeriesBasedChartModel<T extends SeriesBasedChartModel> extends RectangularChartModel<T> {
    CategoryAxis getCategoryAxis();
    T setCategoryAxis(CategoryAxis categoryAxis);

    String getCategoryField();
    T setCategoryField(String categoryField);

    String getBalloonDateFormat();
    T setBalloonDateFormat(String balloonDateFormat);

    Integer getColumnSpacing3D();
    T setColumnSpacing3D(Integer columnSpacing3D);

    Integer getColumnSpacing();
    T setColumnSpacing(Integer columnSpacing);

    Double getColumnWidth();
    T setColumnWidth(Double columnWidth);

    String getDataDateFormat();
    T setDataDateFormat(String dataDateFormat);

    Integer getMaxSelectedSeries();
    T setMaxSelectedSeries(Integer maxSelectedSeries);

    Long getMaxSelectedTime();
    T setMaxSelectedTime(Long maxSelectedTime);

    Long getMinSelectedTime();
    T setMinSelectedTime(Long minSelectedTime);

    Boolean getMouseWheelScrollEnabled();
    T setMouseWheelScrollEnabled(Boolean mouseWheelScrollEnabled);

    Boolean getRotate();
    T setRotate(Boolean rotate);

    Boolean getZoomOutOnDataUpdate();
    T setZoomOutOnDataUpdate(Boolean zoomOutOnDataUpdate);

    Boolean getMouseWheelZoomEnabled();
    T setMouseWheelZoomEnabled(Boolean mouseWheelZoomEnabled);

    Scrollbar getValueScrollbar();
    T setValueScrollbar(Scrollbar valueScrollbar);

    Boolean getSynchronizeGrid();
    T setSynchronizeGrid(Boolean synchronizeGrid);
}