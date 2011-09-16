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

@SuppressWarnings({"unused"})
public class JFreeChartRenderer extends SimplePanel implements Paintable {

    public static final String CLASSNAME = "chart";

    private Image image = new Image();

    private int reloadState;

    public JFreeChartRenderer() {
        buildHtmlSnippet();
    }

    protected void buildHtmlSnippet() {
        setStyleName(CLASSNAME);
        setWidget(image);
    }

    public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
        String chartId = uidl.getId();

        if (client.updateComponent(this, uidl, false)) {
            return;
        }

        reloadState = 5;

        final String uri = client.getAppUri() + (client.getAppUri().endsWith("/") ? "" : "/")
                + "chart/?id=" + chartId
                + "&t=" + System.currentTimeMillis();

        image.setUrl(uri);

        final Timer t = new Timer() {
            @Override
            public void run() {
                if (image.getOffsetHeight() == 0 && image.getOffsetWidth() == 0 && reloadState > 0) {
                    image.setUrl(uri);
                    --reloadState;
                } else {
                    this.cancel();
                }
            }
        };
        t.scheduleRepeating(300);
    }
}