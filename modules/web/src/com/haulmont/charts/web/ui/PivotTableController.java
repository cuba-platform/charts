/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */
package com.haulmont.charts.web.ui;

import com.google.common.base.Strings;
import com.google.gson.*;
import com.haulmont.charts.gui.components.pivot.PivotTable;
import com.haulmont.charts.gui.model.JsFunction;
import com.haulmont.charts.gui.pivottable.model.*;
import com.haulmont.cuba.core.entity.KeyValueEntity;
import com.haulmont.cuba.gui.WindowParam;
import com.haulmont.cuba.gui.components.AbstractFrame;

import javax.inject.Inject;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PivotTableController extends AbstractFrame {

    @Inject
    protected PivotTableDatasource pivotTableDs;

    @Inject
    protected PivotTable pivotTable;

    protected PivotTableDescription pivotTableDescription;

    @WindowParam(required = true)
    protected String pivotTableJson;

    @WindowParam(name = "values", required = true)
    protected List<KeyValueEntity> values;

    @Override
    public void init(Map<String, Object> params) {
        pivotTableDescription = fromJsonString(pivotTableJson);

        pivotTable.setEditable(pivotTableDescription.editable);
        if (!Strings.isNullOrEmpty(pivotTableDescription.filterFunction)) {
            pivotTable.setFilterFunction(new JsFunction(pivotTableDescription.filterFunction));
        }
        if (!Strings.isNullOrEmpty(pivotTableDescription.sortersFunction)) {
            pivotTable.setSortersFunction(new JsFunction(pivotTableDescription.sortersFunction));
        }
        pivotTable.setRenderer(pivotTableDescription.defaultRenderer);
        pivotTable.setRendererOptions(createRendererOptions());
        pivotTable.setAggregation(createDefaultAggregation());
        pivotTable.setProperties(createProperties());
        pivotTable.setDerivedProperties(createDerivedProperties());
        pivotTable.setRows(pivotTableDescription.rowsProperties);
        pivotTable.setColumns(pivotTableDescription.columnsProperties);

        if (pivotTableDescription.editable) {
            pivotTable.setRenderers(createRenderers());
            pivotTable.setAggregations(createAggregations());
            pivotTable.setAggregationProperties(pivotTableDescription.aggregationProperties);
            pivotTable.setHiddenProperties(pivotTableDescription.hiddenProperties);
        }
        pivotTableDs.refresh(Collections.singletonMap(PivotTableDatasource.VALUES_PARAM, values));
    }

    protected PivotTableDescription fromJsonString(String json) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Renderer.class, new RendererAdapter())
                .registerTypeAdapter(AggregationMode.class, new AggregationModeAdapter())
                .create();
        return gson.fromJson(json, PivotTableDescription.class);
    }

    protected RendererOptions createRendererOptions() {
        RendererOptions renderOptions = new RendererOptions();
        if (!Strings.isNullOrEmpty(pivotTableDescription.colorScaleGeneratorFunction)) {
            HeatmapRendererOptions heatmapRendererOptions = new HeatmapRendererOptions();
            heatmapRendererOptions.setColorScaleGeneratorFunction(
                    new JsFunction(pivotTableDescription.colorScaleGeneratorFunction));
            renderOptions.setHeatmap(heatmapRendererOptions);
        }
        if (pivotTableDescription.c3Width != null && pivotTableDescription.c3Height != null) {
            C3RendererOptions c3RendererOptions = new C3RendererOptions();
            Size size = new Size();
            size.setWidth(pivotTableDescription.c3Width);
            size.setHeight(pivotTableDescription.c3Height);
            c3RendererOptions.setSize(size);
            renderOptions.setC3(c3RendererOptions);
        }
        return renderOptions;
    }

    protected Aggregation createDefaultAggregation() {
        if (pivotTableDescription.defaultAggregation != null) {
            Aggregation aggregation = createAggregation(pivotTableDescription.defaultAggregation);
            aggregation.setProperties(pivotTableDescription.aggregationProperties);
            return aggregation;
        }
        return null;
    }

    public Aggregations createAggregations() {
        Aggregations aggregations = new Aggregations();
        if (pivotTableDescription.aggregations != null) {
            List<Aggregation> aggregationList = pivotTableDescription.aggregations.stream()
                    .map(this::createAggregation)
                    .collect(Collectors.toList());
            aggregations.setAggregations(aggregationList);
            if (pivotTableDescription.defaultAggregation != null) {
                aggregations.setDefaultAggregation(pivotTableDescription.defaultAggregation.mode);
            }
        }
        return aggregations;
    }

    public Aggregation createAggregation(PivotTableDescription.AggregationDescription aggregationDescription) {
        Aggregation aggregation = new Aggregation();
        aggregation.setMode(aggregationDescription.mode);
        aggregation.setCaption(aggregationDescription.caption);
        if (aggregationDescription.function != null) {
            aggregation.setCustom(true);
            aggregation.setFunction(new JsFunction(aggregationDescription.function));
        }
        return aggregation;
    }

    public Renderers createRenderers() {
        Renderers result = new Renderers();
        result.setDefaultRenderer(pivotTableDescription.defaultRenderer);
        result.setRenderers(pivotTableDescription.renderers);
        return result;
    }

    public Map<String, String> createProperties() {
        if (pivotTableDescription.properties != null) {
            return pivotTableDescription.properties.stream()
                    .filter(e -> Strings.isNullOrEmpty(e.function))
                    .collect(Collectors.toMap(
                            PivotTableDescription.PropertyDescription::getName,
                            PivotTableDescription.PropertyDescription::getCaption, (e1, e2) -> e1));
        }
        return Collections.emptyMap();
    }

    public DerivedProperties createDerivedProperties() {
        DerivedProperties derivedProperties = new DerivedProperties();
        if (pivotTableDescription.properties != null) {
            derivedProperties.setProperties(pivotTableDescription.properties.stream()
                    .filter(e -> !Strings.isNullOrEmpty(e.function))
                    .collect(Collectors.toMap(
                            PivotTableDescription.PropertyDescription::getName,
                            e -> new JsFunction(e.function), (e1, e2) -> e1)));
        }
        return derivedProperties;
    }

    @SuppressWarnings("WeakerAccess")
    public static class PivotTableDescription implements Serializable {

        public Renderer defaultRenderer;

        public List<Renderer> renderers;

        public AggregationDescription defaultAggregation;

        public List<AggregationDescription> aggregations;

        public Set<PropertyDescription> properties;

        public boolean editable;

        public String filterFunction;

        public String sortersFunction;

        public String colorScaleGeneratorFunction;

        public Double c3Width;

        public Double c3Height;

        public List<String> hiddenProperties = Collections.emptyList();

        public List<String> rowsProperties = Collections.emptyList();

        public List<String> columnsProperties = Collections.emptyList();

        public List<String> aggregationProperties = Collections.emptyList();

        public static class AggregationDescription implements Serializable {
            public AggregationMode mode;
            public String caption;
            public String function;
        }

        public static class PropertyDescription implements Serializable {
            public String name;
            public String caption;
            public String function;

            public String getName() {
                return name;
            }

            public String getCaption() {
                return caption;
            }
        }
    }

    protected static class RendererAdapter implements JsonDeserializer<Renderer> {
        @Override
        public Renderer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return Renderer.fromId(json.getAsString());
        }
    }

    protected static class AggregationModeAdapter implements JsonDeserializer<AggregationMode> {
        @Override
        public AggregationMode deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return AggregationMode.fromId(json.getAsString());
        }
    }
}