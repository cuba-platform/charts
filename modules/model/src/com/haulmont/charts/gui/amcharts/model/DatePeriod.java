/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.haulmont.charts.gui.model.JsonEnum;

import javax.annotation.Nullable;

public enum DatePeriod implements JsonEnum {
    MILLISECONDS("fff"),
    SECONDS("ss"),
    MINUTES("mm"),
    HOURS("hh"),
    DAYS("DD"),
    MONTHS("MM"),
    WEEKS("WW"),
    YEARS("YYYY");

    private String id;

    DatePeriod(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static DatePeriod fromId(String id) {
        for (DatePeriod period : values()) {
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