/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.haulmont.charts.gui.model.JsonEnum;

import javax.annotation.Nullable;

public enum PeriodType implements JsonEnum {
    SECONDS("ss"),
    MINUTES("mm"),
    HOURS("hh"),
    DAYS("DD"),
    MONTHS("MM"),
    YEARS("YYYY"),
    YTD("YTD"),
    MAX("MAX");

    private String id;

    PeriodType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static PeriodType fromId(String id) {
        for (PeriodType period : values()) {
            if (period.getId().equals(id)) {
                return period;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return id;
    }
}