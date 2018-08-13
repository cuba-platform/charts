/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Responsive setting for chart. See documentation for responsive plugin.<br>
 *
 * <a href="https://github.com/amcharts/responsive">https://github.com/amcharts/responsive</a>
 */
public class Responsive extends AbstractChartObject {

    private static final long serialVersionUID = -7360797549413731632L;

    private Boolean enabled;
    private List<Rule> rules;

    public Boolean isEnabled() {
        return enabled;
    }

    public Responsive setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public Responsive setRules(List<Rule> rules) {
        this.rules = rules;
        return this;
    }

    public Responsive addRule(Rule... rules) {
        if (rules != null) {
            if (this.rules == null) {
                this.rules = new ArrayList<>();
            }
            this.rules.addAll(Arrays.asList(rules));
        }
        return this;
    }
}