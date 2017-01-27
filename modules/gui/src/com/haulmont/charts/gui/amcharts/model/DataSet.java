/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import com.google.gson.annotations.Expose;
import com.haulmont.charts.gui.data.DataProvider;
import com.haulmont.cuba.core.global.UuidProvider;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * See documentation for properties of DataSet JS object. <br>
 *
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

    public String getCategoryField() {
        return categoryField;
    }

    public DataSet setCategoryField(String categoryField) {
        this.categoryField = categoryField;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public DataSet setColor(Color color) {
        this.color = color;
        return this;
    }

    public Boolean getCompared() {
        return compared;
    }

    public DataSet setCompared(Boolean compared) {
        this.compared = compared;
        return this;
    }

    public DataProvider getDataProvider() {
        return dataProvider;
    }

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

    public List<FieldMapping> getFieldMappings() {
        return fieldMappings;
    }

    public DataSet setFieldMappings(List<FieldMapping> fieldMappings) {
        this.fieldMappings = fieldMappings;
        return this;
    }

    public DataSet addFieldMappings(FieldMapping... fieldMappings) {
        if (fieldMappings != null) {
            if (this.fieldMappings == null) {
                this.fieldMappings = new ArrayList<>();
            }
            this.fieldMappings.addAll(Arrays.asList(fieldMappings));
        }
        return this;
    }

    public Boolean getShowInCompare() {
        return showInCompare;
    }

    public DataSet setShowInCompare(Boolean showInCompare) {
        this.showInCompare = showInCompare;
        return this;
    }

    public Boolean getShowInSelect() {
        return showInSelect;
    }

    public DataSet setShowInSelect(Boolean showInSelect) {
        this.showInSelect = showInSelect;
        return this;
    }

    public List<StockEvent> getStockEvents() {
        return stockEvents;
    }

    public DataSet setStockEvents(List<StockEvent> stockEvents) {
        this.stockEvents = stockEvents;
        return this;
    }

    public DataSet addStockEvents(StockEvent... stockEvents) {
        if (stockEvents != null) {
            if (this.stockEvents == null) {
                this.stockEvents = new ArrayList<>();
            }
            this.stockEvents.addAll(Arrays.asList(stockEvents));
        }
        return this;
    }

    public String getTitle() {
        return title;
    }

    public DataSet setTitle(String title) {
        this.title = title;
        return this;
    }

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
