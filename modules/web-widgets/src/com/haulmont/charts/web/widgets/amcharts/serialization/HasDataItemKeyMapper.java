/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.amcharts.serialization;

import com.haulmont.charts.gui.data.DataItem;

import java.util.function.Function;

public interface HasDataItemKeyMapper {
    Function<DataItem, String> getDataItemKeyMapper();

    void setDataItemKeyMapper(Function<DataItem, String> dataItemKeyMapper);
}
