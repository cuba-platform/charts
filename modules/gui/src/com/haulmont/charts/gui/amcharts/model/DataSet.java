/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.google.gson.annotations.Expose;
import com.haulmont.charts.gui.data.DataProvider;
import com.haulmont.cuba.core.global.UuidProvider;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Holds all information about data.
 * <br>
 * See documentation for properties of DataSet JS object.
 * <br>
 * <a href="http://docs.amcharts.com/3/javascriptstockchart/DataSet">http://docs.amcharts.com/3/javascriptstockchart/DataSet</a>
 */
public class DataSet extends AbstractChartObject {

    private static final long serialVersionUID = -5376050190482065219L;

    @Expose(serialize = false, deserialize = false)
    private List<DataProviderChangeListener> dataProviderChangeListeners;

    private String id;

    private String categoryField;

    private Color color;

    private Boolean compared;

    private DataProvider dataProvider;

    private List<FieldMapping> fieldMappings;

    private Boolean showInCompare;

    private Boolean showInSelect;

    private List<StockEvent> stockEvents;

    private String title;

    public DataSet() {
        this.id = UuidProvider.createUuid().toString();
    }

    public String getId() {
        return id;
    }

    public DataSet setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * @return category field name
     */
    public String getCategoryField() {
        return categoryField;
    }

    /**
     * Sets category field name in your data provider. It needs to contains a date/time value. If you are specifying
     * dates as strings in your data, i.e. "2015-01-05", it is strongly recommend setting dataDateFormat as well.
     *
     * @param categoryField category field name
     */
    public DataSet setCategoryField(String categoryField) {
        this.categoryField = categoryField;
        return this;
    }

    /**
     * @return color of the data set
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets color of the data set. One of colors from
     * {@link com.haulmont.charts.gui.amcharts.model.charts.StockChartGroup#colors colors} array will be used if not
     * set.
     *
     * @param color color
     */
    public DataSet setColor(Color color) {
        this.color = color;
        return this;
    }

    /**
     * @return true if data set is selected for comparing
     */
    public Boolean getCompared() {
        return compared;
    }

    /**
     * Set to true if this data set selected for comparing.
     *
     * @param compared compared option
     */
    public DataSet setCompared(Boolean compared) {
        this.compared = compared;
        return this;
    }

    /**
     * @return data provider
     */
    public DataProvider getDataProvider() {
        return dataProvider;
    }

    /**
     * Sets data provider to the data set. An array of data points to be used as data. Important, the data points
     * needs to come pre-ordered in ascending order. Data with incorrect order might result in visual and functional
     * glitches on the chart.
     *
     * @param dataProvider data provider
     */
    public DataSet setDataProvider(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
        fireDataProviderChanged();
        return this;
    }

    protected void fireDataProviderChanged() {
        if (CollectionUtils.isNotEmpty(dataProviderChangeListeners)) {
            DataProviderChangeEvent event = new DataProviderChangeEvent(this);
            for (DataProviderChangeListener listener : new ArrayList<>(dataProviderChangeListeners)) {
                listener.onChange(event);
            }
        }
    }

    /**
     * @return list of field mappings
     */
    public List<FieldMapping> getFieldMappings() {
        return fieldMappings;
    }

    /**
     * Sets list of field mappings. Field mapping is an object with fromField and toField properties. fromField is a
     * name of your value field in data provider. toField might be chosen freely, it will be used to set
     * value/open/close/high/low fields for the {@link StockGraph}.
     *
     * @param fieldMappings list of field mappings
     */
    public DataSet setFieldMappings(List<FieldMapping> fieldMappings) {
        this.fieldMappings = fieldMappings;
        return this;
    }

    /**
     * Adds field mappings.
     *
     * @param fieldMappings field mappings
     */
    public DataSet addFieldMappings(FieldMapping... fieldMappings) {
        if (fieldMappings != null) {
            if (this.fieldMappings == null) {
                this.fieldMappings = new ArrayList<>();
            }
            this.fieldMappings.addAll(Arrays.asList(fieldMappings));
        }
        return this;
    }

    /**
     * @return true if this data set is visible in "compare to" list
     */
    public Boolean getShowInCompare() {
        return showInCompare;
    }

    /**
     * Set showInCompare to false if this data set shouldn't be visible in "compare to" list.
     *
     * @param showInCompare showInCompare option
     */
    public DataSet setShowInCompare(Boolean showInCompare) {
        this.showInCompare = showInCompare;
        return this;
    }

    /**
     * @return true if this data set is visible in "select" dropdown
     */
    public Boolean getShowInSelect() {
        return showInSelect;
    }

    /**
     * Set showInSelect to false if this data set shouldn't be visible in "select" dropdown.
     *
     * @param showInSelect showInSelect option
     */
    public DataSet setShowInSelect(Boolean showInSelect) {
        this.showInSelect = showInSelect;
        return this;
    }

    /**
     * @return list of stock events
     */
    public List<StockEvent> getStockEvents() {
        return stockEvents;
    }

    /**
     * Sets list of stock events.
     *
     * @param stockEvents list of stock events
     */
    public DataSet setStockEvents(List<StockEvent> stockEvents) {
        this.stockEvents = stockEvents;
        return this;
    }

    /**
     * Adds stock events.
     *
     * @param stockEvents stock events
     */
    public DataSet addStockEvents(StockEvent... stockEvents) {
        if (stockEvents != null) {
            if (this.stockEvents == null) {
                this.stockEvents = new ArrayList<>();
            }
            this.stockEvents.addAll(Arrays.asList(stockEvents));
        }
        return this;
    }

    /**
     * @return data set title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets data set title.
     *
     * @param title title
     */
    public DataSet setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * @return fields that are bound to the data set
     */
    public List<String> getWiredFields() {
        List<String> wiredFields = new ArrayList<>();
        if (StringUtils.isNotEmpty(categoryField)) {
            wiredFields.add(categoryField);
        }
        if (fieldMappings != null) {
            for (FieldMapping mapping : fieldMappings) {
                if (StringUtils.isNotEmpty(mapping.getFromField())) {
                    wiredFields.add(mapping.getFromField());
                }

                if (StringUtils.isNotEmpty(mapping.getToField())) {
                    wiredFields.add(mapping.getToField());
                }
            }
        }

        return wiredFields;
    }

    public void addDataProviderChangeListener(DataProviderChangeListener listener) {
        if (dataProviderChangeListeners == null) {
            dataProviderChangeListeners = new ArrayList<>();
        }
        dataProviderChangeListeners.add(listener);
    }

    public void removeDataProviderChangeListener(DataProviderChangeListener listener) {
        if (dataProviderChangeListeners != null) {
            dataProviderChangeListeners.remove(listener);
        }
    }

    public interface DataProviderChangeListener {
        void onChange(DataProviderChangeEvent event);
    }

    public class DataProviderChangeEvent {
        private final DataSet dataSet;

        public DataProviderChangeEvent(DataSet dataSet) {
            this.dataSet = dataSet;
        }

        public DataSet getDataSet() {
            return dataSet;
        }
    }
}
