/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amstockcharts.events;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author gorelov
 * @version $Id$
 */
public abstract class AbstractJsDataSetSelectorEvent extends JavaScriptObject {

    protected AbstractJsDataSetSelectorEvent() {
    }

    public final native String getDataSetId() /*-{
        return this.dataSet.id;
    }-*/;
}
