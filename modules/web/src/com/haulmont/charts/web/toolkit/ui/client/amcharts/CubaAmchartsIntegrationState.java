/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.amcharts;

import com.vaadin.shared.communication.SharedState;

import java.util.Map;

/**
 * @author artamonov
 * @version $Id$
 */
public class CubaAmchartsIntegrationState extends SharedState {

    public String json;

    // key: language; value: messagesMap as json
    public Map<String, String> chartMessages;

    // key: language; value: messagesMap as json
    public Map<String, String> exportMessages;

    public int version = 0;
}