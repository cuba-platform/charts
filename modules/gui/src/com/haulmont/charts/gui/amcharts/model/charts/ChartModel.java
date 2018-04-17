/*
 * Copyright (c) 2008-2017 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.amcharts.model.charts;

import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.data.DataProvider;
import com.haulmont.charts.gui.data.ListDataProvider;

import java.util.List;

public interface ChartModel<T extends ChartModel> {
    /**
     * @return true if CSS class names should be added to chart elements
     */
    Boolean getAddClassNames();

    /**
     * Specifies, if CSS class names should be added to chart elements (line, fill, column, etc). If not set the
     * default value is false.
     * <br>
     * See documentation for available CSS class names.
     * <br>
     * <a href="http://www.amcharts.com/kbase/css-class-names/">http://www.amcharts.com/kbase/css-class-names/</a>
     *
     * @param addClassNames add CSS class names option
     */
    T setAddClassNames(Boolean addClassNames);

    /**
     * @return list of labels
     */
    List<Label> getAllLabels();

    /**
     * Sets the list of labels.
     *
     * @param allLabels list of labels
     */
    T setAllLabels(List<Label> allLabels);

    /**
     * Adds labels.
     *
     * @param allLabels the labels to to add
     */
    T addLabels(Label... allLabels);

    /**
     * @return export config
     */
    Export getExport();

    /**
     * Sets export config. Specifies how export to image/data export/print/annotate menu will look and behave.
     *
     * @param export the export
     */
    T setExport(Export export);

    /**
     * @return background color
     */
    Color getBackgroundColor();

    /**
     * Sets background color. You should set {@link AbstractChart#backgroundAlpha} to greater than 0 value in order
     * background to be visible. If not set the default value is #FFFFFF.
     *
     * @param backgroundColor the background color
     */
    T setBackgroundColor(Color backgroundColor);

    /**
     * @return balloon of the chart
     */
    Balloon getBalloon();

    /**
     * Sets the balloon (tooltip) of the chart.
     *
     * @param balloon the balloon
     */
    T setBalloon(Balloon balloon);

    /**
     * @return legend of a chart
     */
    Legend getLegend();

    /**
     * Sets legend of a chart.
     *
     * @param legend the legend
     */
    T setLegend(Legend legend);

    /**
     * @return decimal separator
     */
    String getDecimalSeparator();

    /**
     * Sets decimal separator. If not set the default value is ".".
     *
     * @param decimalSeparator the decimal separator string
     */
    T setDecimalSeparator(String decimalSeparator);

    /**
     * @return percent precision
     */
    Integer getPercentPrecision();

    /**
     * Sets precision of percent values. -1 means percent values won't be rounded at all and show as they are. If not
     * set the default value is 2.
     *
     * @param percentPrecision the percent precision
     */
    T setPercentPrecision(Integer percentPrecision);

    /**
     * @return precision
     */
    Integer getPrecision();

    /**
     * Precision of values. -1 means values won't be rounded at all and show as they are. If not set the default
     * value is -1.
     *
     * @param precision the precision
     */
    T setPrecision(Integer precision);

    DataProvider getDataProvider();

    /**
     * Sets data provider that contains data set.
     *
     * @param dataProvider the data provider
     */
    T setDataProvider(DataProvider dataProvider);

    /**
     * Adds data items. If {@link DataProvider} is null, so it creates {@link ListDataProvider}
     *
     * @param dataItems data items to add
     */
    T addData(DataItem... dataItems);

    /**
     * @return path to images
     */
    String getPathToImages();

    /**
     * Specifies path to the folder where images like resize grips, lens and similar are.
     *
     * @param pathToImages path to images
     */
    T setPathToImages(String pathToImages);

    /**
     * @return theme of a chart
     */
    ChartTheme getTheme();

    /**
     * Sets theme of a chart. If not set the default value is NONE.
     *
     * @param theme the theme
     */
    T setTheme(ChartTheme theme);

    /**
     * @return opacity of chart's border
     */
    Double getBorderAlpha();

    /**
     * Sets opacity of chart's border. Value range is 0 - 1. If not set the default value is 0.
     *
     * @param borderAlpha the border alpha
     */
    T setBorderAlpha(Double borderAlpha);

    /**
     * @return border color
     */
    Color getBorderColor();

    /**
     * Sets color of chart's border. You should set borderAlpha to greater than 0 value in order border to be visible.
     * If not set the default value is #000000.
     *
     * @param borderColor the border color
     */
    T setBorderColor(Color borderColor);

    /**
     * @return class name prefix
     */
    String getClassNamePrefix();

    /**
     * Sets prefix to all class names which are added to all visual elements of a chart in case
     * {@link AbstractChart#addClassNames} is set to true. If not set the default value is "amcharts".
     *
     * @param classNamePrefix class name prefix string
     */
    T setClassNamePrefix(String classNamePrefix);

    /**
     * @return position of link to amCharts site
     */
    CreditsPosition getCreditsPosition();

    /**
     * Sets position of link to amCharts site. Allowed values are: top-left, top-right, bottom-left and bottom-right.
     * Non-commercial version only. If not set the default value is TOP_LEFT.
     *
     * @param creditsPosition the credits position
     */
    T setCreditsPosition(CreditsPosition creditsPosition);

    /**
     * @return text color
     */
    Color getColor();

    /**
     * Sets text color. If not set the default value is "#000000".
     *
     * @param color the text color
     */
    T setColor(Color color);

    /**
     * @return font family
     */
    String getFontFamily();

    /**
     * Sets font family. If not set the default value is "Verdana".
     *
     * @param fontFamily font family string
     */
    T setFontFamily(String fontFamily);

    /**
     * @return font size
     */
    Integer getFontSize();

    /**
     * Sets font size. If not set the default value is 11.
     *
     * @param fontSize the font size
     */
    T setFontSize(Integer fontSize);

    /**
     * @return true if the lines of the chart should be distorted and should produce hand-drawn effect
     */
    Boolean getHandDrawn();

    /**
     * If true, the lines of the chart will be distorted and will produce hand-drawn effect. Try to adjust
     * {@link AbstractChart#handDrawScatter handDrawScatter} and {@link AbstractChart#handDrawThickness
     * handDrawThickness} properties for a more scattered result. If not set the default value is false.
     *
     * @param handDrawn hand drawn option
     */
    T setHandDrawn(Boolean handDrawn);

    /**
     * @return hand draw scatter
     */
    Integer getHandDrawScatter();

    /**
     * Defines by how many pixels hand-drawn line (when {@link AbstractChart#handDrawn handDrawn} is set to
     * true) will fluctuate. If not set the default value is 2.
     *
     * @param handDrawScatter the hand drawn scatter
     */
    T setHandDrawScatter(Integer handDrawScatter);

    /**
     * @return hand drawn thickness
     */
    Integer getHandDrawThickness();

    /**
     * Defines by how many pixels line thickness will fluctuate (when {@link AbstractChart#handDrawn handDrawn} is set
     * to true). If not set the default value is 1.
     *
     * @param handDrawThickness the hand draw thickness
     */
    T setHandDrawThickness(Integer handDrawThickness);

    /**
     * @return hide balloon time in milliseconds
     */
    Integer getHideBalloonTime();

    /**
     * Sets time, in milliseconds after which balloon is hidden if the user rolls-out of the object. Note, this is not
     * duration of fade-out. Duration of fade-out is {@link Balloon#fadeOutDuration}. If not set the default value is
     * 150.
     *
     * @param hideBalloonTime the hide balloon time in milliseconds
     */
    T setHideBalloonTime(Integer hideBalloonTime);

    /**
     * @return true if pan events enabled
     */
    Boolean getPanEventsEnabled();

    /**
     * This setting affects touch-screen devices only. If a chart is on a page, and panEventsEnabled are set to true,
     * the page won't move if the user touches the chart first. If a chart is big enough and occupies all the screen
     * of your touch device, the user won’t be able to move the page at all. If you think that selecting/panning the
     * chart is a primary purpose of your users, you should set panEventsEnabled to true, otherwise - false. If not
     * set the default value is true.
     *
     * @param panEventsEnabled pan events enabled option
     */
    T setPanEventsEnabled(Boolean panEventsEnabled);

    /**
     * @return list of BigNumberPrefix
     */
    List<BigNumberPrefix> getPrefixesOfBigNumbers();

    /**
     * Sets the prefixes which are used to make big numbers shorter: 2M instead of 2000000, etc. Prefixes are used on
     * value axes and in the legend. To enable prefixes, set {@link AbstractChart#usePrefixes usePrefixes} property to
     * true. If not set the default value is
     * <pre>{@code
     * [{"number":1e+3,  "prefix":"k"},
     *  {"number":1e+6,  "prefix":"M"},
     *  {"number":1e+9,  "prefix":"G"},
     *  {"number":1e+12, "prefix":"T"},
     *  {"number":1e+15, "prefix":"P"},
     *  {"number":1e+18, "prefix":"E"},
     *  {"number":1e+21, "prefix":"Z"},
     *  {"number":1e+24, "prefix":"Y"}]
     *}</pre>
     *
     * @param prefixesOfBigNumbers list of BigNumberPrefix
     */
    T setPrefixesOfBigNumbers(List<BigNumberPrefix> prefixesOfBigNumbers);

    /**
     * Adds BigNumberPrefixes.
     *
     * @param prefixesOfBigNumbers prefixes of big numbers
     */
    T addPrefixesOfBigNumbers(BigNumberPrefix... prefixesOfBigNumbers);

    /**
     * @return list of SmallNumberPrefix
     */
    List<SmallNumberPrefix> getPrefixesOfSmallNumbers();

    /**
     * Sets prefixes which are used to make small numbers shorter: 2μ instead of 0.000002, etc. Prefixes are used on
     * value axes and in the legend. To enable prefixes, set {@link AbstractChart#usePrefixes usePrefixes} property to
     * true. If not set the default value is
     * <pre>{@code
     * [{"number":1e-24, "prefix":"y"},
     *  {"number":1e-21, "prefix":"z"},
     *  {"number":1e-18, "prefix":"a"},
     *  {"number":1e-15, "prefix":"f"},
     *  {"number":1e-12, "prefix":"p"},
     *  {"number":1e-9,  "prefix":"n"},
     *  {"number":1e-6,  "prefix":"μ"},
     *  {"number":1e-3,  "prefix":"m"}]
     * }</pre>
     *
     * @param prefixesOfSmallNumbers list of SmallNumberPrefix
     */
    T setPrefixesOfSmallNumbers(List<SmallNumberPrefix> prefixesOfSmallNumbers);

    /**
     * Adds SmallNumberPrefix
     *
     * @param prefixesOfSmallNumbers prefixes of small numbers
     */
    T addPrefixesOfSmallNumbers(SmallNumberPrefix... prefixesOfSmallNumbers);

    /**
     * @return thousands separator
     */
    String getThousandsSeparator();

    /**
     * Sets thousands separator. If not set the default value is ".".
     *
     * @param thousandsSeparator - thousands separator string
     */
    T setThousandsSeparator(String thousandsSeparator);

    /**
     * @return list of titles
     */
    List<Title> getTitles();

    /**
     * Sets list of titles.
     *
     * @param titles the titles
     */
    T setTitles(List<Title> titles);

    /**
     * Adds titles to chart.
     *
     * @param titles the titles to add
     */
    T addTitles(Title... titles);

    /**
     * @return true if uses prefixes is enabled
     */
    Boolean getUsePrefixes();

    /**
     * If true, prefixes will be used for big and small numbers. You can set arrays of prefixes
     * {@link AbstractChart#prefixesOfSmallNumbers prefixesOfSmallNumbers} and
     * {@link AbstractChart#prefixesOfBigNumbers prefixesOfBigNumbers} properties. If not set the default value is
     * false.
     *
     * @param usePrefixes the use prefixes option
     */
    T setUsePrefixes(Boolean usePrefixes);

    /**
     * @return list of additional fields
     */
    List<String> getAdditionalFields();

    /**
     * Sets list of additional fields. Fields from your data provider that should be used
     * directly in the chart configuration.
     *
     * @param additionalFields list of additional fields
     */
    T setAdditionalFields(List<String> additionalFields);

    /**
     * Adds additional fields
     *
     * @param fields the fields
     */
    T addAdditionalFields(String... fields);

    /**
     * @return true if auto display is enabled
     */
    Boolean getAutoDisplay();

    /**
     * If you set autoDisplay to true the chart will automatically monitor changes of display style of chart’s
     * container (or any of it’s parents) and will render chart correctly. If not set the default value is false.
     *
     * @param autoDisplay auto display option
     */
    T setAutoDisplay(Boolean autoDisplay);

    /**
     * @return true if chart should resize itself whenever its parent container size changes
     */
    Boolean getAutoResize();

    /**
     * Set to false if you don't want chart to resize itself whenever its parent container size changes. If not set
     * the default value is true.
     *
     * @param autoResize auto resize option
     */
    T setAutoResize(Boolean autoResize);

    /**
     * @return opacity of background
     */
    Double getBackgroundAlpha();

    /**
     * Sets opacity of background. Set it to greater 0 value if you want {@link AbstractChart#backgroundColor} to work.
     * If not set the default value is 0.
     *
     * @param backgroundAlpha background alpha option
     */
    T setBackgroundAlpha(Double backgroundAlpha);

    /**
     * @return language
     */
    String getLanguage();

    /**
     * Sets language of default. Note, you should include language js file from amcharts/lang and then use variable
     * name used in this file, like <code>setLanguage("de")</code>.
     *
     * @param language language string
     */
    T setLanguage(String language);

    /**
     * @return path
     */
    String getPath();

    /**
     * Specifies absolute or relative path to amCharts files.
     *
     * @param path the path string
     */
    T setPath(String path);

    /**
     * @return true if using SVG icons is enabled
     */
    Boolean getSvgIcons();

    /**
     * Sets use SVG icons (if browser supports SVG). If not set the default value is true.
     *
     * @param svgIcons svgIcons option
     */
    T setSvgIcons(Boolean svgIcons);

    /**
     * @return true if tap to activate is enabled
     */
    Boolean getTapToActivate();

    /**
     * Charts which require gestures like swipe (charts with scrollbar/cursor) used to prevent regular page scrolling
     * and could result page to stick to the same spot if the chart occupied whole screen. Now, in order these gestures
     * to start working user has to touch the chart once. Regular touch events like touching on the bar/slice area do
     * not require the first tap and will show balloons and perform other tasks as usual. If you have a chart which
     * occupies full screen and your page does not require scrolling, set tapToActivate to false – this
     * will bring old behavior back. If not set the default value is true.
     *
     * @param tapToActivate tap to activate option
     */
    T setTapToActivate(Boolean tapToActivate);

    /**
     * @return defs
     */
    String getDefs();

    /**
     * Sets any additional information to SVG, like SVG filters or clip paths. The structure of this object should be
     * identical to XML structure of a object you are adding, only in JSON format.
     *
     * @param defs defs string
     */
    T setDefs(String defs);

    /**
     * @return true if accessible is enabled
     */
    Boolean getAccessible();

    /**
     * When enabled, chart adds aria-label attributes to columns or bullets objects. You can control values of these
     * labels using properties like {@link AbstractGraph#accessibleLabel}. If not set the default value is true.
     *
     * @param accessible accessible option
     */
    T setAccessible(Boolean accessible);

    /**
     * @return description of a SVG element
     */
    String getAccessibleTitle();

    /**
     * Description which is added to of a SVG element.
     *
     * @param accessibleTitle accessible title string
     */
    T setAccessibleTitle(String accessibleTitle);

    /**
     * @return responsive
     */
    Responsive getResponsive();

    /**
     * Sets a config object for Responsive plugin
     *
     * @param responsive the responsive
     */
    T setResponsive(Responsive responsive);

    /**
     * @return process count
     */
    Integer getProcessCount();

    /**
     * If processTimeout is greater than 0, 1000 data items will be parsed at a time, then the chart will make pause
     * and continue parsing data until it finishes. If not set the default value is 1000.
     *
     * @param processCount the process count
     */
    T setProcessCount(Integer processCount);

    /**
     * @return process timeout
     */
    Integer getProcessTimeout();

    /**
     * If you set it to 1 millisecond or some bigger value, chart will be built in chunks instead of all at once. This
     * is useful if you work with a lot of data and the initial build of the chart takes a lot of time, which freezes
     * the whole web application by not allowing other processes to do their job while the chart is busy. If not set
     * the default value is 0.
     *
     * @param processTimeout the process timeout
     */
    T setProcessTimeout(Integer processTimeout);

    /**
     * @return touch click duration in milliseconds
     */
    Integer getTouchClickDuration();

    /**
     * Sets the touch click duration. If you set it to 200 (milliseconds) or so, the chart will fire
     * GraphItemClickEvent or SliceClickEvent only if user holds his/her finger for 0.2 seconds (200 ms) on the
     * column/bullet/slice object. If not set the default value is 0.
     *
     * @param touchClickDuration the touch click duration in milliseconds
     */
    T setTouchClickDuration(Integer touchClickDuration);

    /**
     * @return true if auto transform is enabled,
     */
    Boolean getAutoTransform();

    /**
     * If you set it to true and your chart div (or any of the parent div) has CSS scale applied, the chart will
     * position mouse at a correct position. This operation consumes some CPU and quite a few people are using CSS
     * transforms. If not set the default value is false.
     *
     * @param autoTransform auto transform option
     */
    T setAutoTransform(Boolean autoTransform);

    /**
     * @return accessible description string
     */
    String getAccessibleDescription();

    /**
     * Description which will be added to node of SVG element.
     *
     * @param accessibleDescription description string
     */
    T setAccessibleDescription(String accessibleDescription);
}