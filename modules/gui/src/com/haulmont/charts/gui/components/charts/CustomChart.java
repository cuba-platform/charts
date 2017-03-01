/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.components.charts;

import com.haulmont.charts.gui.amcharts.model.charts.AbstractChart;
import com.haulmont.cuba.gui.components.Component;

/**
 * Chart that can show any chart configuration inherited from {@link AbstractChart}.
 */
public interface CustomChart extends Component, Component.BelongToFrame, Component.HasXmlDescriptor, Component.HasIcon,
                                     Component.HasCaption {
    String NAME = "customChart";

    AbstractChart getConfiguration();
    void setConfiguration(AbstractChart configuration);

    /**
     * Resend all items and properties to client and repaint chart.
     * Use this method if you change some property of already displayed chart.
     */
    void repaint();

    /**
     * Set additional JSON configuration as a string.
     * This JSON can override configuration loaded from XML and from Component API.
     */
    void setNativeJson(String json);
    /**
     * @return additional JSON configuration as a string.
     */
    String getNativeJson();
}