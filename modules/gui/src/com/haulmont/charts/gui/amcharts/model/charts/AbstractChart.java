/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.amcharts.model.data.DataItem;
import com.haulmont.charts.gui.amcharts.model.data.DataProvider;
import com.haulmont.charts.gui.amcharts.model.data.ListDataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Base class for charts. <br/>
 * See documentation for properties of AmChart JS object.
 *
 * @author artamonov
 * @version $Id$
 */
@SuppressWarnings("unchecked")
public abstract class AbstractChart<T extends AbstractConfigurationObject> extends AbstractConfigurationObject {

    private final ChartType type;

    private List<Label> allLabels;

    private Color backgroundColor;

    private Balloon balloon;

    private Double borderAlpha;

    private Color borderColor;

    private Color color;

    private DataProvider dataProvider;

    private ExportConfig exportConfig;

    private String fontFamily;

    private Integer fontSize;

    private Boolean handDrawn;

    private Integer handDrawScatter;

    private Integer handDrawThickness;

    private String height;

    private Integer hideBalloonTime;

    private Legend legend;

    private NumberFormatter numberFormatter;

    private Boolean panEventsEnabled;

    private String pathToImages = "VAADIN/resources/amcharts/images/";

    private NumberFormatter percentFormatter;

    private List<BigNumberPrefix> prefixesOfBigNumbers;

    private List<SmallNumberPrefix> prefixesOfSmallNumbers;

    private List<Title> titles;

    private Boolean usePrefixes;

    private ChartTheme theme;

    protected AbstractChart(ChartType type) {
        this.type = type;
    }

    public List<Label> getAllLabels() {
        return allLabels;
    }

    public T setAllLabels(List<Label> allLabels) {
        this.allLabels = allLabels;
        return (T) this;
    }

    public T addLabels(Label... allLabels) {
        if (allLabels != null) {
            if (this.allLabels == null) {
                this.allLabels = new ArrayList<>();
            }
            this.allLabels.addAll(Arrays.asList(allLabels));
        }
        return (T) this;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public T setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return (T) this;
    }

    public Balloon getBalloon() {
        return balloon;
    }

    public T setBaloon(Balloon balloon) {
        this.balloon = balloon;
        return (T) this;
    }

    public ExportConfig getExportConfig() {
        return exportConfig;
    }

    public T setExportConfig(ExportConfig exportConfig) {
        this.exportConfig = exportConfig;
        return (T) this;
    }

    public Legend getLegend() {
        return legend;
    }

    public T setLegend(Legend legend) {
        this.legend = legend;
        return (T) this;
    }

    public DataProvider getDataProvider() {
        return dataProvider;
    }

    public T setDataProvider(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
        return (T) this;
    }

    public T addData(DataItem... dataItems) {
        if (dataItems != null) {
            if (this.dataProvider == null) {
                this.dataProvider = new ListDataProvider();
            }
            this.dataProvider.addItems(Arrays.asList(dataItems));
        }
        return (T) this;
    }

    public String getPathToImages() {
        return pathToImages;
    }

    public T setPathToImages(String pathToImages) {
        this.pathToImages = pathToImages;
        return (T) this;
    }

    public ChartTheme getTheme() {
        return theme;
    }

    public T setTheme(ChartTheme theme) {
        this.theme = theme;
        return (T) this;
    }

    public T setBalloon(Balloon balloon) {
        this.balloon = balloon;
        return (T) this;
    }

    public Double getBorderAlpha() {
        return borderAlpha;
    }

    public T setBorderAlpha(Double borderAlpha) {
        this.borderAlpha = borderAlpha;
        return (T) this;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public T setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        return (T) this;
    }

    public Color getColor() {
        return color;
    }

    public T setColor(Color color) {
        this.color = color;
        return (T) this;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public T setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
        return (T) this;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public T setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
        return (T) this;
    }

    public Boolean getHandDrawn() {
        return handDrawn;
    }

    public T setHandDrawn(Boolean handDrawn) {
        this.handDrawn = handDrawn;
        return (T) this;
    }

    public Integer getHandDrawScatter() {
        return handDrawScatter;
    }

    public T setHandDrawScatter(Integer handDrawScatter) {
        this.handDrawScatter = handDrawScatter;
        return (T) this;
    }

    public Integer getHandDrawThickness() {
        return handDrawThickness;
    }

    public T setHandDrawThickness(Integer handDrawThickness) {
        this.handDrawThickness = handDrawThickness;
        return (T) this;
    }

    public String getHeight() {
        return height;
    }

    public T setHeight(String height) {
        this.height = height;
        return (T) this;
    }

    public Integer getHideBalloonTime() {
        return hideBalloonTime;
    }

    public T setHideBalloonTime(Integer hideBalloonTime) {
        this.hideBalloonTime = hideBalloonTime;
        return (T) this;
    }

    public NumberFormatter getNumberFormatter() {
        return numberFormatter;
    }

    public T setNumberFormatter(NumberFormatter numberFormatter) {
        this.numberFormatter = numberFormatter;
        return (T) this;
    }

    public Boolean getPanEventsEnabled() {
        return panEventsEnabled;
    }

    public T setPanEventsEnabled(Boolean panEventsEnabled) {
        this.panEventsEnabled = panEventsEnabled;
        return (T) this;
    }

    public NumberFormatter getPercentFormatter() {
        return percentFormatter;
    }

    public T setPercentFormatter(NumberFormatter percentFormatter) {
        this.percentFormatter = percentFormatter;
        return (T) this;
    }

    public List<BigNumberPrefix> getPrefixesOfBigNumbers() {
        return prefixesOfBigNumbers;
    }

    public T setPrefixesOfBigNumbers(List<BigNumberPrefix> prefixesOfBigNumbers) {
        this.prefixesOfBigNumbers = prefixesOfBigNumbers;
        return (T) this;
    }

    public T addPrefixesOfBigNumbers(BigNumberPrefix... prefixesOfBigNumbers) {
        if (prefixesOfBigNumbers != null) {
            if (this.prefixesOfBigNumbers == null) {
                this.prefixesOfBigNumbers = new ArrayList<>();
            }
            this.prefixesOfBigNumbers.addAll(Arrays.asList(prefixesOfBigNumbers));
        }
        return (T) this;
    }

    public List<SmallNumberPrefix> getPrefixesOfSmallNumbers() {
        return prefixesOfSmallNumbers;
    }

    public T setPrefixesOfSmallNumbers(List<SmallNumberPrefix> prefixesOfSmallNumbers) {
        this.prefixesOfSmallNumbers = prefixesOfSmallNumbers;
        return (T) this;
    }

    public T addPrefixesOfSmallNumbers(SmallNumberPrefix... prefixesOfSmallNumbers) {
        if (prefixesOfSmallNumbers != null) {
            if (this.prefixesOfSmallNumbers == null) {
                this.prefixesOfSmallNumbers = new ArrayList<>();
            }
            this.prefixesOfSmallNumbers.addAll(Arrays.asList(prefixesOfSmallNumbers));
        }
        return (T) this;
    }

    public List<Title> getTitles() {
        return titles;
    }

    public T setTitles(List<Title> titles) {
        this.titles = titles;
        return (T) this;
    }

    public T addTitles(Title... titles) {
        if (titles != null) {
            if (this.titles == null) {
                this.titles = new ArrayList<>();
            }
            this.titles.addAll(Arrays.asList(titles));
        }
        return (T) this;
    }

    public Boolean getUsePrefixes() {
        return usePrefixes;
    }

    public T setUsePrefixes(Boolean usePrefixes) {
        this.usePrefixes = usePrefixes;
        return (T) this;
    }

    public ChartType getType() {
        return type;
    }
}