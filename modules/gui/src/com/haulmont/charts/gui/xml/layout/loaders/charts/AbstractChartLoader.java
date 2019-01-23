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

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.haulmont.bali.util.Dom4j;
import com.haulmont.charts.gui.amcharts.model.Responsive;
import com.haulmont.charts.gui.amcharts.model.Rule;
import com.haulmont.charts.gui.components.charts.Chart;
import com.haulmont.charts.gui.data.ContainerDataProvider;
import com.haulmont.cuba.gui.GuiDevelopmentException;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.model.ScreenData;
import com.haulmont.cuba.gui.screen.FrameOwner;
import com.haulmont.cuba.gui.screen.UiControllerUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Element;

public abstract class AbstractChartLoader<T extends Chart> extends ChartModelLoader<T> {

    @Override
    public void loadComponent() {
        assignFrame(resultComponent);

        loadWidth(resultComponent, element);
        loadHeight(resultComponent, element);

        loadVisible(resultComponent, element);
        loadEnable(resultComponent, element);
        loadStyleName(resultComponent, element);
        loadAlign(resultComponent, element);

        loadIcon(resultComponent, element);
        loadCaption(resultComponent, element);
        loadDescription(resultComponent, element);

        loadCss(resultComponent, element);

        loadDataContainer(resultComponent, element);
    }

    protected void loadDatasource(Chart chart, Element element) {
        String datasource = element.attributeValue("datasource");
        if (StringUtils.isNotEmpty(datasource)) {
            Datasource ds = context.getDsContext().get(datasource);
            if (ds == null) {
                throw new GuiDevelopmentException("Can't find datasource by name: " + datasource, context.getCurrentFrameId());
            }

            if (!(ds instanceof CollectionDatasource)) {
                throw new GuiDevelopmentException("Not a CollectionDatasource: " + datasource, context.getCurrentFrameId());
            }

            chart.setDatasource((CollectionDatasource) ds);
        }
    }

    protected void loadDataContainer(Chart chart, Element element) {
        String dataContainerId = element.attributeValue("dataContainer");

        if (StringUtils.isNotEmpty(dataContainerId)) {
            FrameOwner frameOwner = context.getFrame().getFrameOwner();
            ScreenData screenData = UiControllerUtils.getScreenData(frameOwner);

            CollectionContainer dataContainer;

            InstanceContainer container = screenData.getContainer(dataContainerId);
            if (container instanceof CollectionContainer) {
                dataContainer = (CollectionContainer) container;
            } else {
                throw new GuiDevelopmentException("Not a CollectionContainer: " + dataContainerId, context.getCurrentFrameId());
            }

            chart.setDataProvider(new ContainerDataProvider(dataContainer));
        } else {
            loadDatasource(resultComponent, element);
        }
    }

    protected void checkMultipleDatasources(Element element) {
        String datasource = element.attributeValue("datasource");
        String dataContainer = element.attributeValue("dataContainer");
        Element dataSetElement = element.element("data");

        boolean isDatasourceProperty = StringUtils.isNotEmpty(datasource);
        boolean isDataContainerProperty = StringUtils.isNotEmpty(dataContainer);

        if ((isDatasourceProperty && isDataContainerProperty)
                || (dataSetElement != null && (isDatasourceProperty || isDataContainerProperty))) {
            throw new GuiDevelopmentException(
                    String.format("You cannot use chart '%s' with simultaneously defined: data element, datasource and "
                            + "dataContainer properties", resultComponent.getId()), context.getCurrentFrameId()
            );
        }
    }

    protected void loadConfiguration(T chart, Element element) {
        loadBaseProperties(chart, element);

        Element responsiveElement = element.element("responsive");
        if (responsiveElement != null) {
            Responsive responsive = new Responsive();
            loadResponsive(responsive, responsiveElement);
            chart.setResponsive(responsive);
        }

        Element nativeJson = element.element("nativeJson");
        if (nativeJson != null) {
            String nativeJsonString = nativeJson.getTextTrim();
            try {
                JsonParser parser = new JsonParser();
                parser.parse(nativeJsonString);
            } catch (JsonSyntaxException e) {
                throw new GuiDevelopmentException("Unable to parse JSON from XML chart configuration", context.getFullFrameId());
            }

            resultComponent.setNativeJson(nativeJsonString);
        }
    }

    protected void loadResponsive(Responsive responsive, Element responsiveElement) {
        loadRules(responsive, responsiveElement);

        String responsiveValue = responsiveElement.attributeValue("enabled");
        if (StringUtils.isNotEmpty(responsiveValue)) {
            responsive.setEnabled(Boolean.parseBoolean(responsiveValue));
        }
    }

    protected void loadRules(Responsive responsive, Element responsiveElement) {
        Element rulesElement = responsiveElement.element("rules");
        if (rulesElement != null) {
            for (Element ruleElement : Dom4j.elements(rulesElement, "rule")) {
                Rule rule = new Rule();

                String maxHeight = ruleElement.attributeValue("maxHeight");
                if (StringUtils.isNotEmpty(maxHeight)) {
                    rule.setMaxHeight(Integer.parseInt(maxHeight));
                }

                String minHeight = ruleElement.attributeValue("minHeight");
                if (StringUtils.isNotEmpty(minHeight)) {
                    rule.setMinHeight(Integer.parseInt(minHeight));
                }

                String maxWidth = ruleElement.attributeValue("maxWidth");
                if (StringUtils.isNotEmpty(maxWidth)) {
                    rule.setMaxWidth(Integer.parseInt(maxWidth));
                }

                String minWidth = ruleElement.attributeValue("minWidth");
                if (StringUtils.isNotEmpty(minWidth)) {
                    rule.setMinWidth(Integer.parseInt(minWidth));
                }

                rule.setRawOverridesJson(ruleElement.getTextTrim());
                responsive.addRule(rule);
            }
        }
    }
}