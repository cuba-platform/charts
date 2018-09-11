/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.components.charts.SerialChart;
import org.dom4j.Element;

public class SerialChartLoader extends AbstractSerialChartLoader<SerialChart> {

    @Override
    public void createComponent() {
        resultComponent = factory.create(SerialChart.NAME);
        loadId(resultComponent, element);
    }

    @Override
    public void loadComponent() {
        super.loadComponent();

        loadBezierX(resultComponent, element);
        loadBezierY(resultComponent, element);
    }

    private void loadBezierX(SerialChart serialChart, Element element) {
        String bezierX = element.attributeValue("bezierX");
        if (bezierX != null && !bezierX.isEmpty()) {
            serialChart.setBezierX(Integer.valueOf(bezierX));
        }
    }

    private void loadBezierY(SerialChart serialChart, Element element) {
        String bezierY = element.attributeValue("bezierY");
        if (bezierY != null && !bezierY.isEmpty()) {
            serialChart.setBezierY(Integer.valueOf(bezierY));
        }
    }
}