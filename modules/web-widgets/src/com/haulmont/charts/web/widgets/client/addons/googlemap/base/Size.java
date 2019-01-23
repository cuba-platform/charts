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

package com.haulmont.charts.web.widgets.client.addons.googlemap.base;

import java.io.Serializable;

public class Size implements Serializable {
    private static final long serialVersionUID = 7769425097002447246L;

    private double width = 0.0;
    private double height = 0.0;
    private String widthUnit = null;
    private String heightUnit = null;

    public Size() {
    }

    public Size(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Size(double width, double height, String widthUnit, String heightUnit) {
        this.width = width;
        this.height = height;
        this.widthUnit = widthUnit;
        this.heightUnit = heightUnit;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getWidthUnit() {
        return widthUnit;
    }

    public void setWidthUnit(String widthUnit) {
        this.widthUnit = widthUnit;
    }

    public String getHeightUnit() {
        return heightUnit;
    }

    public void setHeightUnit(String heightUnit) {
        this.heightUnit = heightUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Size size = (Size) o;

        if (Double.compare(size.height, height) != 0) return false;
        if (Double.compare(size.width, width) != 0) return false;
        if (heightUnit != null ? !heightUnit.equals(size.heightUnit) : size.heightUnit != null) return false;
        if (widthUnit != null ? !widthUnit.equals(size.widthUnit) : size.widthUnit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(width);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (widthUnit != null ? widthUnit.hashCode() : 0);
        result = 31 * result + (heightUnit != null ? heightUnit.hashCode() : 0);
        return result;
    }
}