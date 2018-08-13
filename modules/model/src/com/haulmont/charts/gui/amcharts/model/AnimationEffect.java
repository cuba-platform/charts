/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.haulmont.charts.gui.model.JsonEnum;

public enum AnimationEffect implements JsonEnum {
    EASE_OUT_SINE("easeOutSine"),
    EASE_IN_SINE("easeInSine"),
    ELASTIC("elastic"),
    BOUNCE("bounce");

    private String id;

    AnimationEffect(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }
}