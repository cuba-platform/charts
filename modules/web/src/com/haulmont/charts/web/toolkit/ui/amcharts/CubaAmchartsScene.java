/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.amcharts;

import com.haulmont.charts.web.toolkit.ui.client.amcharts.CubaAmchartsSceneState;
import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractComponent;
import org.apache.commons.lang.StringUtils;

/**
 * @author artamonov
 * @version $Id$
 */
@JavaScript({"resources/amcharts/amcharts-all.min.js",
             "resources/amcharts/themes.min.js",
             "resources/amcharts/exporting.min.js"})
public class CubaAmchartsScene extends AbstractComponent {

    @Override
    protected CubaAmchartsSceneState getState() {
        return (CubaAmchartsSceneState) super.getState();
    }

    @Override
    protected CubaAmchartsSceneState getState(boolean markAsDirty) {
        return (CubaAmchartsSceneState) super.getState(markAsDirty);
    }

    public void setJson(String json) {
        if (!StringUtils.equals(getJson(), json)) {
            getState().json = json;
        }
    }

    public String getJson() {
        return getState(false).json;
    }
}