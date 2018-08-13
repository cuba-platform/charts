/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.widgets.client.pivottable;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.json.client.JSONParser;
import com.haulmont.charts.web.widgets.pivottable.CubaPivotTable;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.layout.ElementResizeListener;
import com.vaadin.shared.ui.Connect;

import java.util.Map;
import java.util.Set;

@Connect(CubaPivotTable.class)
public class CubaPivotTableSceneConnector extends AbstractComponentConnector {

    private static final long serialVersionUID = -6263118673027033933L;

    protected CubaPivotTableServerRpc rpc = RpcProxy.create(CubaPivotTableServerRpc.class, this);

    protected ElementResizeListener tableResizeListener = e -> getLayoutManager().setNeedsMeasure(this);

    public CubaPivotTableSceneConnector() {
    }

    protected JavaScriptObject getJsonAsObject(String json) {
        return JSONParser.parseLenient(json).isObject().getJavaScriptObject();
    }

    @Override
    public CubaPivotTableSceneState getState() {
        return (CubaPivotTableSceneState) super.getState();
    }

    @Override
    public CubaPivotTableSceneWidget getWidget() {
        return (CubaPivotTableSceneWidget) super.getWidget();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        if (stateChangeEvent.hasPropertyChanged("localeMap") && getState().localeMap != null) {
            Map<String, String> pivotMessages = getState().localeMap;
            for (final Map.Entry<String, String> entry : pivotMessages.entrySet()) {
                JavaScriptObject pivotLocalization = getJsonAsObject(entry.getValue());
                addPivotTableMessages(entry.getKey(), pivotLocalization);
            }
        }

        if (stateChangeEvent.hasPropertyChanged("enabled")) {
            getWidget().setEnabled(getState().enabled);
        }

        final PivotTableConfig config = PivotTableConfig.fromServerConfig(getState().data,
                getState().options, getState().json, getState().emptyDataMessage);
        PivotTableEvents events = createEvents();

        Scheduler.get().scheduleDeferred(() -> {
            Element tableElement = getWidget().getElement().getFirstChildElement();
            if (tableElement != null) {
                getLayoutManager().removeElementResizeListener(tableElement, tableResizeListener);
            }

            getWidget().init(config, events);

            getLayoutManager().setNeedsMeasure(this);

            tableElement = getWidget().getElement().getFirstChildElement();
            getLayoutManager().addElementResizeListener(tableElement, tableResizeListener);
        });
    }

    @Override
    public void onUnregister() {
        super.onUnregister();

        getLayoutManager().removeElementResizeListener(getWidget().getElement().getFirstChildElement(),
                tableResizeListener);
    }

    private native void addPivotTableMessages(String localeCode, JavaScriptObject pivotLocalization) /*-{
        var formatFloat, formatInt, formatPercent, numberFormat, aggregatorTemplates;
        numberFormat = $wnd.$.pivotUtilities.numberFormat;
        aggregatorTemplates = $wnd.$.pivotUtilities.aggregatorTemplates;
        formatFloat = numberFormat({
            digitsAfterDecimal: pivotLocalization.floatFormat.digitsAfterDecimal,
            scaler: pivotLocalization.floatFormat.scaler,
            thousandsSep: pivotLocalization.floatFormat.thousandsSep,
            decimalSep: pivotLocalization.floatFormat.decimalSep,
            prefix: pivotLocalization.floatFormat.prefix,
            suffix: pivotLocalization.floatFormat.suffix,
            showZero: pivotLocalization.floatFormat.showZero
        });
        formatInt = numberFormat({
            digitsAfterDecimal: pivotLocalization.integerFormat.digitsAfterDecimal,
            scaler: pivotLocalization.integerFormat.scaler,
            thousandsSep: pivotLocalization.integerFormat.thousandsSep,
            decimalSep: pivotLocalization.integerFormat.decimalSep,
            prefix: pivotLocalization.integerFormat.prefix,
            suffix: pivotLocalization.integerFormat.suffix,
            showZero: pivotLocalization.integerFormat.showZero
        });
        formatPercent = numberFormat({
            digitsAfterDecimal: pivotLocalization.percentFormat.digitsAfterDecimal,
            scaler: pivotLocalization.percentFormat.scaler,
            thousandsSep: pivotLocalization.percentFormat.thousandsSep,
            decimalSep: pivotLocalization.percentFormat.decimalSep,
            prefix: pivotLocalization.percentFormat.prefix,
            suffix: pivotLocalization.percentFormat.suffix,
            showZero: pivotLocalization.percentFormat.showZero
        });

        var allAggregators = {};
        allAggregators[pivotLocalization.aggregation.count] = aggregatorTemplates.count(formatInt);
        allAggregators[pivotLocalization.aggregation.countUniqueValues] = aggregatorTemplates.countUnique(formatInt);
        allAggregators[pivotLocalization.aggregation.listUniqueValues] = aggregatorTemplates.listUnique(", ");
        allAggregators[pivotLocalization.aggregation.sum] = aggregatorTemplates.sum(formatFloat);
        allAggregators[pivotLocalization.aggregation.integerSum] = aggregatorTemplates.sum(formatInt);
        allAggregators[pivotLocalization.aggregation.average] = aggregatorTemplates.average(formatFloat);
        allAggregators[pivotLocalization.aggregation.minimum] = aggregatorTemplates.min(formatFloat);
        allAggregators[pivotLocalization.aggregation.maximum] = aggregatorTemplates.max(formatFloat);
        allAggregators[pivotLocalization.aggregation.sumOverSum] = aggregatorTemplates.sumOverSum(formatFloat);
        allAggregators[pivotLocalization.aggregation.upperBound80] = aggregatorTemplates.sumOverSumBound80(true, formatFloat);
        allAggregators[pivotLocalization.aggregation.lowerBound80] = aggregatorTemplates.sumOverSumBound80(false, formatFloat);
        allAggregators[pivotLocalization.aggregation.sumAsFractionOfTotal] =
            aggregatorTemplates.fractionOf(aggregatorTemplates.sum(), "total", formatPercent);
        allAggregators[pivotLocalization.aggregation.sumAsFractionOfRows] =
            aggregatorTemplates.fractionOf(aggregatorTemplates.sum(), "row", formatPercent);
        allAggregators[pivotLocalization.aggregation.sumAsFractionOfColumns] =
            aggregatorTemplates.fractionOf(aggregatorTemplates.sum(), "col", formatPercent);
        allAggregators[pivotLocalization.aggregation.countAsFractionOfTotal] =
            aggregatorTemplates.fractionOf(aggregatorTemplates.count(), "total", formatPercent);
        allAggregators[pivotLocalization.aggregation.countAsFractionOfRows] =
            aggregatorTemplates.fractionOf(aggregatorTemplates.count(), "row", formatPercent);
        allAggregators[pivotLocalization.aggregation.countAsFractionOfColumns] =
            aggregatorTemplates.fractionOf(aggregatorTemplates.count(), "col", formatPercent);

        var allRenderers = {};
        allRenderers[pivotLocalization.renderer.table] = $wnd.$.pivotUtilities.renderers["Table"];
        allRenderers[pivotLocalization.renderer.tableBarchart] = $wnd.$.pivotUtilities.renderers["Table Barchart"];
        allRenderers[pivotLocalization.renderer.heatmap] = $wnd.$.pivotUtilities.renderers["Heatmap"];
        allRenderers[pivotLocalization.renderer.rowHeatmap] = $wnd.$.pivotUtilities.renderers["Row Heatmap"];
        allRenderers[pivotLocalization.renderer.colHeatmap] = $wnd.$.pivotUtilities.renderers["Col Heatmap"];
        allRenderers[pivotLocalization.renderer.lineChart] = $wnd.$.pivotUtilities.c3_renderers["Line Chart"];
        allRenderers[pivotLocalization.renderer.barChart] = $wnd.$.pivotUtilities.c3_renderers["Bar Chart"];
        allRenderers[pivotLocalization.renderer.stackedBarChart] =
            $wnd.$.pivotUtilities.c3_renderers["Stacked Bar Chart"];
        allRenderers[pivotLocalization.renderer.horizontalBarChart] =
            $wnd.$.pivotUtilities.c3_renderers["Horizontal Bar Chart"];
        allRenderers[pivotLocalization.renderer.horizontalStackedBarChart] =
            $wnd.$.pivotUtilities.c3_renderers["Horizontal Stacked Bar Chart"];
        allRenderers[pivotLocalization.renderer.areaChart] = $wnd.$.pivotUtilities.c3_renderers["Area Chart"];
        allRenderers[pivotLocalization.renderer.scatterChart] = $wnd.$.pivotUtilities.c3_renderers["Scatter Chart"];
        allRenderers[pivotLocalization.renderer.treemap] = $wnd.$.pivotUtilities.d3_renderers["Treemap"];
        allRenderers[pivotLocalization.renderer.TSVExport] = $wnd.$.pivotUtilities.export_renderers["TSV Export"];

        $wnd.$.pivotUtilities.locales[localeCode] = {
            localeStrings: {
                renderError: pivotLocalization.renderError,
                computeError: pivotLocalization.computeError,
                uiRenderError: pivotLocalization.uiRenderError,
                selectAll: pivotLocalization.selectAll,
                selectNone: pivotLocalization.selectNone,
                apply: pivotLocalization.apply,
                cancel: pivotLocalization.cancel,
                tooMany: pivotLocalization.tooMany,
                filterResults: pivotLocalization.filterResults,
                totals: pivotLocalization.totals,
                vs: pivotLocalization.vs,
                by: pivotLocalization.by
            },
            aggregators: allAggregators,
            renderers: allRenderers,
            aggregatorsLocaleMapping: pivotLocalization.aggregation,
            renderersLocaleMapping: pivotLocalization.renderer
        };
    }-*/;

    protected PivotTableEvents createEvents() {
        PivotTableEvents pivotTableEvents = new PivotTableEvents();
        Set<String> events = getState().registeredEventListeners;
        if (events != null) {
            if (events.contains(CubaPivotTableSceneState.REFRESH_EVENT)) {
                pivotTableEvents.setRefreshHandler(event ->
                        rpc.onRefresh(event.getRows(), event.getCols(), event.getRenderer(),
                                event.getAggregation(), event.getAggregationProperties(),
                                event.getInclusions(), event.getExclusions(),
                                event.getColumnOrder(), event.getRowOrder()));
            }

            if (events.contains(CubaPivotTableSceneState.CELL_CLICK_EVENT)) {
                pivotTableEvents.setCellClickHandler(event ->
                        rpc.onCellClick(event.getValue(), event.getFilters()));
            }
        }

        return pivotTableEvents;
    }
}
