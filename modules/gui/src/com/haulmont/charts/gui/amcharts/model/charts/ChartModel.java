/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.data.DataProvider;

import java.util.List;

public interface ChartModel<T extends ChartModel> {
    Boolean getAddClassNames();
    T setAddClassNames(Boolean addClassNames);

    List<Label> getAllLabels();
    T setAllLabels(List<Label> allLabels);
    T addLabels(Label... allLabels);

    Export getExport();
    T setExport(Export export);

    Color getBackgroundColor();
    T setBackgroundColor(Color backgroundColor);

    Balloon getBalloon();
    T setBalloon(Balloon balloon);

    Legend getLegend();
    T setLegend(Legend legend);

    String getDecimalSeparator();
    T setDecimalSeparator(String decimalSeparator);

    Integer getPercentPrecision();
    T setPercentPrecision(Integer percentPrecision);

    Integer getPrecision();
    T setPrecision(Integer precision);

    DataProvider getDataProvider();
    T setDataProvider(DataProvider dataProvider);

    T addData(DataItem... dataItems);

    String getPathToImages();
    T setPathToImages(String pathToImages);

    ChartTheme getTheme();
    T setTheme(ChartTheme theme);

    Double getBorderAlpha();
    T setBorderAlpha(Double borderAlpha);

    Color getBorderColor();
    T setBorderColor(Color borderColor);

    String getClassNamePrefix();
    T setClassNamePrefix(String classNamePrefix);

    CreditsPosition getCreditsPosition();
    T setCreditsPosition(CreditsPosition creditsPosition);

    Color getColor();
    T setColor(Color color);

    String getFontFamily();
    T setFontFamily(String fontFamily);

    Integer getFontSize();
    T setFontSize(Integer fontSize);

    Boolean getHandDrawn();
    T setHandDrawn(Boolean handDrawn);

    Integer getHandDrawScatter();
    T setHandDrawScatter(Integer handDrawScatter);

    Integer getHandDrawThickness();
    T setHandDrawThickness(Integer handDrawThickness);

    Integer getHideBalloonTime();
    T setHideBalloonTime(Integer hideBalloonTime);

    Boolean getPanEventsEnabled();
    T setPanEventsEnabled(Boolean panEventsEnabled);

    List<BigNumberPrefix> getPrefixesOfBigNumbers();
    T setPrefixesOfBigNumbers(List<BigNumberPrefix> prefixesOfBigNumbers);
    T addPrefixesOfBigNumbers(BigNumberPrefix... prefixesOfBigNumbers);

    List<SmallNumberPrefix> getPrefixesOfSmallNumbers();
    T setPrefixesOfSmallNumbers(List<SmallNumberPrefix> prefixesOfSmallNumbers);
    T addPrefixesOfSmallNumbers(SmallNumberPrefix... prefixesOfSmallNumbers);

    String getThousandsSeparator();
    T setThousandsSeparator(String thousandsSeparator);

    List<Title> getTitles();
    T setTitles(List<Title> titles);
    T addTitles(Title... titles);

    Boolean getUsePrefixes();
    T setUsePrefixes(Boolean usePrefixes);

    List<String> getAdditionalFields();
    T setAdditionalFields(List<String> additionalFields);
    T addAdditionalFields(String... fields);

    Boolean getAutoDisplay();
    T setAutoDisplay(Boolean autoDisplay);

    Boolean getAutoResize();
    T setAutoResize(Boolean autoResize);

    Double getBackgroundAlpha();
    T setBackgroundAlpha(Double backgroundAlpha);

    String getLanguage();
    T setLanguage(String language);

    String getPath();
    T setPath(String path);

    Boolean getSvgIcons();
    T setSvgIcons(Boolean svgIcons);

    Boolean getTapToActivate();
    T setTapToActivate(Boolean tapToActivate);

    String getDefs();
    T setDefs(String defs);

    Boolean getAccessible();
    T setAccessible(Boolean accessible);

    String getAccessibleTitle();
    T setAccessibleTitle(String accessibleTitle);

    Responsive getResponsive();
    T setResponsive(Responsive responsive);

    Integer getProcessCount();
    T setProcessCount(Integer processCount);

    Integer getProcessTimeout();
    T setProcessTimeout(Integer processTimeout);

    Integer getTouchClickDuration();
    T setTouchClickDuration(Integer touchClickDuration);

    Boolean getAutoTransform();
    T setAutoTransform(Boolean autoTransform);

    String getAccessibleDescription();
    T setAccessibleDescription(String accessibleDescription);
}