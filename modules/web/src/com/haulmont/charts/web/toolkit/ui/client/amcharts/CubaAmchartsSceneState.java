/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts;

import com.vaadin.shared.AbstractComponentState;

/**
 * @author artamonov
 * @version $Id$
 */
public class CubaAmchartsSceneState extends AbstractComponentState {

    public String json;
    public String configuration;

    // Force state change on client
    public int version = 0;
}