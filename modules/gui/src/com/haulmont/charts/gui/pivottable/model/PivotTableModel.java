/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model;

import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;
import com.haulmont.charts.gui.pivottable.model.data.ListPivotDataProvider;
import com.haulmont.charts.gui.pivottable.model.data.PivotDataItem;
import com.haulmont.charts.gui.pivottable.model.data.PivotDataProvider;
import com.haulmont.charts.gui.pivottable.model.gson.PivotDataProviderSerializer;
import com.haulmont.charts.gui.pivottable.model.gson.PivotJsonSerializationContext;
import com.haulmont.charts.gui.pivottable.model.gson.PivotTableModelSerializer;
import org.apache.commons.collections.MapUtils;

import java.util.*;

/**
 * Description of PivotTable configuration. <br/>
 * <a href="https://github.com/nicolaskruchten/pivottable/">https://github.com/nicolaskruchten/pivottable/</a>
 * <p>
 * See documentation for properties of Pivot() and PivotUI() functions.<br/>
 * <a href="https://github.com/nicolaskruchten/pivottable/wiki/Parameters">https://github.com/nicolaskruchten/pivottable/wiki/Parameters</a>
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class PivotTableModel extends AbstractPivotObject {
    private static final long serialVersionUID = -1569394634634321813L;

    /**
     * If {@code editable=false} then {@code pivot()} function
     * will be called to generate PivotTable, {@code pivotUI()} otherwise.
     */
    private Boolean editable = false;                           // Haulmont API

    /**
     * Properties to serialize
     */
    @Expose(serialize = false, deserialize = false)
    private Map<String, String> properties;                     // Haulmont API

    /**
     * Collection of attribute names to use as rows.
     */
    private List<String> rows;                                  // pivot() and pivotUI()

    /**
     * Collection of attribute names to use as columns.
     */
    private List<String> cols;                                  // pivot() and pivotUI()

    /**
     * Origin property name: {@code aggregator}.
     * <p>
     * Constructor for an object which will aggregate results per cell
     * (see <a href="https://github.com/nicolaskruchten/pivottable/wiki/Aggregators">documentation</a>).
     * <p>
     * Applies only when {@code editable=false}.
     */
    private Aggregation aggregation;                            // pivot()

    /**
     * Generates output from pivot data structure
     * (see <a href="https://github.com/nicolaskruchten/pivottable/wiki/Renderers">documentation</a>).
     * <p>
     * Applies only when {@code editable=false}.
     */
    private Renderer renderer;                                  // pivot()

    /**
     * Origin property name: {@code vals}.
     * <p>
     * Attribute names to prepopulate in vals area (gets passed to aggregator generating function).
     * <p>
     * Applies only when {@code editable=true}.
     */
    private List<String> aggregationProperties;                 // pivotUI()

    /**
     * Origin property name: {@code aggregators}.
     * <p>
     * Dictionary of generators for aggregation functions in dropdown
     * (see <a href="https://github.com/nicolaskruchten/pivottable/wiki/Aggregators">documentation</a>).
     * <p>
     * Applies only when {@code editable=true}.
     */
    private Aggregations aggregations;                          // pivotUI()

    /**
     * Dictionary of rendering functions
     * (see <a href="https://github.com/nicolaskruchten/pivottable/wiki/Renderers">documentation</a>).
     * <p>
     * Applies only when {@code editable=true}.
     */
    private Renderers renderers;                                // pivotUI()

    /**
     * Contains attribute names to omit from the UI.
     * <p>
     * Applies only when {@code editable=true}.
     */
    private List<String> hiddenProperties;                      // pivotUI()

    /**
     * Maximum number of values to list in the double-click menu.
     * <p>
     * Applies only when {@code editable=true}.
     */
    private Integer menuLimit;                                  // pivotUI()

    /**
     * Origin property name: {@code autoSortUnusedAttrs}.
     * <p>
     * Controls whether or not unused attributes are kept sorted in the UI.
     * <p>
     * Applies only when {@code editable=true}.
     */
    private Boolean autoSortUnusedProperties;                   // pivotUI()

    /**
     * Origin property name: {@code unusedAttrsVertical}.
     * <p>
     * Controls whether or not unused attributes are shown vertically
     * instead of the default which is horizontally. {@code true} means
     * always vertical, {@code false} means always horizontal. If set to
     * a number (as is the default) then if the attributes' names' combined
     * length in characters exceeds the number then the attributes will be shown vertically.
     * <p>
     * Applies only when {@code editable=true}.
     */
    private UnusedPropertiesVertical unusedPropertiesVertical;  // pivotUI()

    /**
     * Origin property name: {@code filter}.
     * <p>
     * Called on each record, returns {@code false} if the record
     * is to be excluded from the input before rendering or {@code true} otherwise.
     */
    private PivotJsFunction filterFunction;                     // pivot() and pivotUI()

    /**
     * Origin property name: {@code sorters}.
     * <p>
     * Called with an attribute name and can return a function which can be used
     * as an argument to {@code Array.sort} for output purposes. If no function
     * is returned, the default sorting mechanism is a built-in "natural sort"
     * implementation. Useful for sorting attributes like month names.
     */
    private PivotJsFunction sortersFunction;                    // pivot() and pivotUI()

    /**
     * Object passed through to renderer as options.
     */
    private RendererOptions rendererOptions;                    // pivot() and pivotUI()

    /**
     * Object whose keys are attribute names and values are arrays of attribute values
     * which denote records to include in rendering; used to prepopulate the filter menus
     * that appear on double-click (overrides {@link #exclusions}).
     * <p>
     * Applies only when {@code editable=true}.
     *
     * @see #exclusions
     */
    private Map<String, List<String>> inclusions;               // pivotUI()

    /**
     * Object whose keys are attribute names and values are arrays of attribute values
     * which denote records to exclude from rendering; used to prepopulate the filter menus
     * that appear on double-click.
     * <p>
     * Applies only when {@code editable=true}.
     *
     * @see #inclusions
     */
    private Map<String, List<String>> exclusions;               // pivotUI()

    /**
     * Origin property name: {@code derivedAttributes}.
     * <p>
     * Object to define derived properties
     * (see <a href="https://github.com/nicolaskruchten/pivottable/wiki/Derived-Attributes">documentation</a>).
     */
    private DerivedProperties derivedProperties;                // pivot() and pivotUI()

    /**
     * Determines localization
     */
    private String localeCode;                                  // Haulmont API

    /**
     * Data provider for PivotTable. Contains items which will be shown on PivotTable.
     */
    @Expose(serialize = false, deserialize = false)
    private PivotDataProvider dataProvider;                     // Haulmont API - object to be serialized as input data

    public PivotTableModel() {
    }

    public Boolean getEditable() {
        return editable;
    }

    public PivotTableModel setEditable(Boolean editable) {
        this.editable = editable;
        return this;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public PivotTableModel setProperties(Map<String, String> properties) {
        this.properties = properties;
        return this;
    }

    public PivotTableModel addProperties(Map<String, String> properties) {
        if (properties != null) {
            if (this.properties == null) {
                this.properties = new HashMap<>();
            }
            this.properties.putAll(properties);
        }
        return this;
    }

    public PivotTableModel addProperty(String property, String value) {
        if (this.properties == null) {
            this.properties = new HashMap<>();
        }
        this.properties.put(property, value);

        return this;
    }

    public List<String> getRows() {
        return rows;
    }

    public PivotTableModel setRows(List<String> rows) {
        this.rows = rows;
        return this;
    }

    public PivotTableModel addRows(String... rows) {
        if (rows != null) {
            if (this.rows == null) {
                this.rows = new ArrayList<>();
            }
            this.rows.addAll(Arrays.asList(rows));
        }
        return this;
    }

    public List<String> getCols() {
        return cols;
    }

    public PivotTableModel setCols(List<String> cols) {
        this.cols = cols;
        return this;
    }

    public PivotTableModel addCols(String... cols) {
        if (cols != null) {
            if (this.cols == null) {
                this.cols = new ArrayList<>();
            }
            this.cols.addAll(Arrays.asList(cols));
        }
        return this;
    }

    public Aggregation getAggregation() {
        return aggregation;
    }

    public PivotTableModel setAggregation(Aggregation aggregation) {
        this.aggregation = aggregation;
        return this;
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public PivotTableModel setRenderer(Renderer renderer) {
        this.renderer = renderer;
        return this;
    }

    public List<String> getAggregationProperties() {
        return aggregationProperties;
    }

    public PivotTableModel setAggregationProperties(List<String> aggregationProperties) {
        this.aggregationProperties = aggregationProperties;
        return this;
    }

    public PivotTableModel addAggregationProperties(String... aggregationProperties) {
        if (aggregationProperties != null) {
            if (this.aggregationProperties == null) {
                this.aggregationProperties = new ArrayList<>();
            }
            this.aggregationProperties.addAll(Arrays.asList(aggregationProperties));
        }
        return this;
    }

    public Aggregations getAggregations() {
        return aggregations;
    }

    public PivotTableModel setAggregations(Aggregations aggregations) {
        this.aggregations = aggregations;
        return this;
    }

    public Renderers getRenderers() {
        return renderers;
    }

    public PivotTableModel setRenderers(Renderers renderers) {
        this.renderers = renderers;
        return this;
    }

    public List<String> getHiddenProperties() {
        return hiddenProperties;
    }

    public PivotTableModel setHiddenProperties(List<String> hiddenProperties) {
        this.hiddenProperties = hiddenProperties;
        return this;
    }

    public PivotTableModel addHiddenProperties(String... hiddenProperties) {
        if (hiddenProperties != null) {
            if (this.hiddenProperties == null) {
                this.hiddenProperties = new ArrayList<>();
            }
            this.hiddenProperties.addAll(Arrays.asList(hiddenProperties));
        }
        return this;
    }

    public Integer getMenuLimit() {
        return menuLimit;
    }

    public PivotTableModel setMenuLimit(Integer menuLimit) {
        this.menuLimit = menuLimit;
        return this;
    }

    public Boolean getAutoSortUnusedProperties() {
        return autoSortUnusedProperties;
    }

    public PivotTableModel setAutoSortUnusedProperties(Boolean autoSortUnusedProperties) {
        this.autoSortUnusedProperties = autoSortUnusedProperties;
        return this;
    }

    public UnusedPropertiesVertical getUnusedPropertiesVertical() {
        return unusedPropertiesVertical;
    }

    public PivotTableModel setUnusedPropertiesVertical(UnusedPropertiesVertical unusedPropertiesVertical) {
        this.unusedPropertiesVertical = unusedPropertiesVertical;
        return this;
    }

    public PivotDataProvider getDataProvider() {
        return dataProvider;
    }

    public PivotTableModel setDataProvider(PivotDataProvider dataProvider) {
        this.dataProvider = dataProvider;
        return this;
    }

    public PivotTableModel addData(PivotDataItem... dataItems) {
        if (dataItems != null) {
            if (this.dataProvider == null) {
                this.dataProvider = new ListPivotDataProvider();
            }
            this.dataProvider.addItems(Arrays.asList(dataItems));
        }
        return this;
    }

    public PivotJsFunction getFilterFunction() {
        return filterFunction;
    }

    public PivotTableModel setFilterFunction(PivotJsFunction filter) {
        this.filterFunction = filter;
        return this;
    }

    public PivotJsFunction getSortersFunction() {
        return sortersFunction;
    }

    public PivotTableModel setSortersFunction(PivotJsFunction sorters) {
        this.sortersFunction = sorters;
        return this;
    }

    public RendererOptions getRendererOptions() {
        return rendererOptions;
    }

    public PivotTableModel setRendererOptions(RendererOptions rendererOptions) {
        this.rendererOptions = rendererOptions;
        return this;
    }

    public Map<String, List<String>> getInclusions() {
        return inclusions;
    }

    public PivotTableModel setInclusions(Map<String, List<String>> inclusions) {
        this.inclusions = inclusions;
        return this;
    }

    public PivotTableModel setInclusions(String property, List<String> inclusions) {
        if (this.inclusions == null) {
            this.inclusions = new HashMap<>();
        }
        this.inclusions.put(property, inclusions);
        return this;
    }

    public PivotTableModel addInclusions(String property, String... inclusions) {
        if (inclusions != null) {
            if (this.inclusions == null) {
                this.inclusions = new HashMap<>();
            }
            if (this.inclusions.containsKey(property)) {
                this.inclusions.get(property).addAll(Arrays.asList(inclusions));
            } else {
                this.inclusions.put(property, new ArrayList<>(Arrays.asList(inclusions)));
            }
        }
        return this;
    }

    public Map<String, List<String>> getExclusions() {
        return exclusions;
    }

    public PivotTableModel setExclusions(Map<String, List<String>> exclusions) {
        this.exclusions = exclusions;
        return this;
    }

    public PivotTableModel setExclusions(String property, List<String> exclusions) {
        if (this.exclusions == null) {
            this.exclusions = new HashMap<>();
        }
        this.exclusions.put(property, exclusions);
        return this;
    }

    public PivotTableModel addExclusions(String property, String... exclusions) {
        if (exclusions != null) {
            if (this.exclusions == null) {
                this.exclusions = new HashMap<>();
            }
            if (this.exclusions.containsKey(property)) {
                this.exclusions.get(property).addAll(Arrays.asList(exclusions));
            } else {
                this.exclusions.put(property, new ArrayList<>(Arrays.asList(exclusions)));
            }
        }
        return this;
    }

    public DerivedProperties getDerivedProperties() {
        return derivedProperties;
    }

    public PivotTableModel setDerivedProperties(DerivedProperties derivedProperties) {
        this.derivedProperties = derivedProperties;
        return this;
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public PivotTableModel setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
        return this;
    }

    public String dataToString() {
        if (dataProvider != null) {
            PivotDataProviderSerializer serializer = new PivotDataProviderSerializer();
            PivotJsonSerializationContext context = new PivotJsonSerializationContext(this);
            JsonElement dataProviderElement = serializer.serialize(dataProvider, dataProvider.getClass(), context);
            return gson.toJson(dataProviderElement);
        }
        return null;
    }

    @Override
    public String toString() {
        PivotTableModelSerializer serializer = new PivotTableModelSerializer();
        PivotJsonSerializationContext context = new PivotJsonSerializationContext(this);
        JsonElement pivotElement = serializer.serialize(this, this.getClass(), context);
        return gson.toJson(pivotElement);
    }

    public List<String> getWiredFields() {
        List<String> fields = new ArrayList<>();
        if (MapUtils.isNotEmpty(getProperties())) {
            fields.addAll(properties.keySet());
        }
        return fields;
    }
}