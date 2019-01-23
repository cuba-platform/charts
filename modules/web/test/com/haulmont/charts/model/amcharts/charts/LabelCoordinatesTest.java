/*
 * Copyright (c) 2008-2019 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.charts.model.amcharts.charts;

import com.haulmont.charts.gui.amcharts.model.Label;
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
