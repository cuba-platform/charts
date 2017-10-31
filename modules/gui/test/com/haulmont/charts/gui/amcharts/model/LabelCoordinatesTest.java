/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LabelCoordinatesTest {

    private Label label = new Label();

    @Test
    public void testSetNull() {
        label.setX(null);
        assertEquals(null, label.getX());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIncorrectNumber() {
        label.setX("10x13");
    }

    @Test
    public void testSetCorrectNumber() {
        String value = "200.5";
        label.setX(value);
        assertEquals(value, label.getX());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIncorrectNumberBeforePercentage() {
        label.setX("10px13%%");
    }

    @Test
    public void testSetCorrectNumberBeforePercentage() {
        String value = "6.0%";
        label.setX(value);
        assertEquals(value, label.getX());
    }
}
