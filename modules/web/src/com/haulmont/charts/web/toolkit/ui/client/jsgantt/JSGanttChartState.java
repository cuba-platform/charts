/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.jsgantt;

import com.vaadin.shared.AbstractComponentState;

import java.util.List;
import java.util.Map;

/**
 * @author tsarevskiy
 * @version $Id$
 */
public class JSGanttChartState extends AbstractComponentState {

    public boolean showStartDate = true;
    public boolean showEndDate = true;
    public boolean showDuration = false;
    public boolean showComplete = false;
    public boolean showResource = false;
    public boolean showInitiator = false;
    public String dateTimeFormat = "dd/MM/yyyy";
    public Map<String, String> localeDict = null;
    public List<Map<String, String>> tasks;

}
