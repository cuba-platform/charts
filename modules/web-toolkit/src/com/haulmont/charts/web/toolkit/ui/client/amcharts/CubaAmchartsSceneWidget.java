/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts;

import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author artamonov
 * @version $Id$
 */
public class CubaAmchartsSceneWidget extends Widget {

    private CubaAmchartsJsOverlay jsOverlay;

    public CubaAmchartsSceneWidget() {
        setElement(Document.get().createDivElement());
    }

    public void update(String json) {
        jsOverlay = CubaAmchartsJsOverlay.makeChart(getElement(), JsonUtils.safeEval(json));
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                updateSize();
            }
        });
    }

    public void updateSize() {
        if (jsOverlay != null) {
            jsOverlay.updateSize();
        }
    }
}