/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */
package com.haulmont.charts.toolkit.gwt.client.charts.jfree;

import com.google.gwt.user.client.ui.SimplePanel;

/**
 *
 */
public class VChartRenderer extends SimplePanel {
    // vaadin7
/*
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
    }*/
}