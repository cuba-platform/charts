/*
 * Copyright (c) 2008 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.

 * Author: Nikolay Gorodnov
 * Created: 01.09.2010 16:08:48
 *
 * $Id$
 */
package com.haulmont.charts.toolkit.gwt.client.charts.jfree;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;
import com.vaadin.terminal.gwt.client.ApplicationConnection;
import com.vaadin.terminal.gwt.client.Paintable;
import com.vaadin.terminal.gwt.client.UIDL;

/**
 *
 */
public class VChartRenderer extends SimplePanel implements Paintable {

    public static final String CLASSNAME = "chart";

    private Image image = new Image();

    private int retryCounter;

    public VChartRenderer() {
        buildHtmlSnippet();
    }

    protected void buildHtmlSnippet() {
        setStyleName(CLASSNAME);
        setWidget(image);
    }

    public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
        String chartId = uidl.getId();
        String renderUrl = uidl.getStringAttribute("renderUrl");
        renderUrl += renderUrl.endsWith("/") ? "" : "/";

        if (client.updateComponent(this, uidl, false)) {
            return;
        }

        final String uri = renderUrl + "?id=" + chartId + "&t=" + System.currentTimeMillis();

        image.setUrl(uri);

        retryCounter = 5;

        final Timer t = new Timer() {
            @Override
            public void run() {
                if (image.getOffsetHeight() == 0 && image.getOffsetWidth() == 0 && retryCounter > 0) {
                    image.setUrl(uri);
                    --retryCounter;
                } else {
                    this.cancel();
                }
            }
        };
        t.scheduleRepeating(300);
    }
}