/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.amcharts.model.data.MapDataItem;
import com.haulmont.charts.gui.model.JsFunction;
import com.haulmont.cuba.gui.GuiDevelopmentException;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.loaders.AbstractComponentLoader;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public abstract class ChartModelLoader<C extends Component> extends AbstractComponentLoader<C> {

    protected static final String CONFIG_DATE_FORMAT = "yyyy-MM-dd";
    protected static final String CONFIG_DATETIME_FORMAT = "yyyy-MM-dd HH:mm";

    @Override
    protected void loadWidth(Component component, Element element) {
        final String width = element.attributeValue("width");
        if ("auto".equalsIgnoreCase(width)) {
            component.setWidth("640px");
        } else if (!StringUtils.isBlank(width)) {
            component.setWidth(width);
        } else {
            component.setWidth("640px");
        }
    }

    @Override
    protected void loadHeight(Component component, Element element) {
        final String height = element.attributeValue("height");
        if ("auto".equalsIgnoreCase(height)) {
            component.setHeight("480px");
        } else if (!StringUtils.isBlank(height)) {
            component.setHeight(height);
        } else {
            component.setHeight("480px");
        }
    }

    protected MapDataItem loadDataItem(Element property, MapDataItem dataItem) {
        String name = property.attributeValue("name");
        String value = property.attributeValue("value");
        String type = property.attributeValue("type");

        if (StringUtils.isEmpty(name)) {
            throw new GuiDevelopmentException(
                    "'name' attribute does not exist",
                    context.getFullFrameId(), "Chart ID", resultComponent.getId());
        }
        if (StringUtils.isEmpty(value)) {
            throw new GuiDevelopmentException(
                    "'value' attribute does not exist",
                    context.getFullFrameId(), "Chart ID", resultComponent.getId());
        }

        if (type == null) {
            type = "string";
        }

        switch (type) {
            case "int":
                dataItem.add(name, Integer.parseInt(value));
                break;
            case "double":
                dataItem.add(name, Double.parseDouble(value));
                break;
            case "date":
                dataItem.add(name, loadDate(value));
                break;
            case "datetime":
                dataItem.add(name, parseDateTime(value));
                break;
            case "string":
                dataItem.add(name, value);
                break;
            case "long":
                dataItem.add(name, Long.parseLong(value));
                break;
            case "boolean":
                dataItem.add(name, Boolean.valueOf(value));
                break;
            case "uuid":
                dataItem.add(name, UUID.fromString(value));
                break;
            case "decimal":
                dataItem.add(name, new BigDecimal(value));
                break;
            default:
                dataItem.add(name, value);
                break;
        }

        return dataItem;
    }

    protected Date parseDateTime(String value) {
        SimpleDateFormat rangeDF;
        if (value.length() == 10) {
            rangeDF = new SimpleDateFormat(CONFIG_DATE_FORMAT);
        } else {
            rangeDF = new SimpleDateFormat(CONFIG_DATETIME_FORMAT);
        }
        try {
            return rangeDF.parse(value);
        } catch (ParseException e) {
            throw new GuiDevelopmentException(
                    "'value' parsing error for chart: " +
                            value, context.getFullFrameId(), "Chart ID", resultComponent.getId());
        }
    }

    protected Balloon loadBalloon(Element balloonElement) {
        Balloon balloon = new Balloon();

        String adjustBorderColor = balloonElement.attributeValue("adjustBorderColor");
        if (StringUtils.isNotEmpty(adjustBorderColor)) {
            balloon.setAdjustBorderColor(Boolean.valueOf(adjustBorderColor));
        }

        String animationDuration = balloonElement.attributeValue("animationDuration");
        if (StringUtils.isNotEmpty(animationDuration)) {
            balloon.setAnimationDuration(Double.valueOf(animationDuration));
        }

        String borderAlpha = balloonElement.attributeValue("borderAlpha");
        if (StringUtils.isNotEmpty(borderAlpha)) {
            balloon.setBorderAlpha(Double.valueOf(borderAlpha));
        }

        String borderColor = balloonElement.attributeValue("borderColor");
        if (StringUtils.isNotEmpty(borderColor)) {
            balloon.setBorderColor(Color.valueOf(borderColor));
        }

        String borderThickness = balloonElement.attributeValue("borderThickness");
        if (StringUtils.isNotEmpty(borderThickness)) {
            balloon.setBorderThickness(Integer.valueOf(borderThickness));
        }

        String color = balloonElement.attributeValue("color");
        if (StringUtils.isNotEmpty(color)) {
            balloon.setColor(Color.valueOf(color));
        }

        String cornerRadius = balloonElement.attributeValue("cornerRadius");
        if (StringUtils.isNotEmpty(cornerRadius)) {
            balloon.setCornerRadius(Integer.valueOf(cornerRadius));
        }

        String disableMouseEvents = balloonElement.attributeValue("disableMouseEvents");
        if (StringUtils.isNotEmpty(disableMouseEvents)) {
            balloon.setDisableMouseEvents(Boolean.valueOf(disableMouseEvents));
        }

        String drop = balloonElement.attributeValue("drop");
        if (StringUtils.isNotEmpty(drop)) {
            balloon.setDrop(Boolean.valueOf(drop));
        }

        String enabled = balloonElement.attributeValue("enabled");
        if (StringUtils.isNotEmpty(enabled)) {
            balloon.setEnabled(Boolean.valueOf(enabled));
        }

        String fadeOutDuration = balloonElement.attributeValue("fadeOutDuration");
        if (StringUtils.isNotEmpty(fadeOutDuration)) {
            balloon.setFadeOutDuration(Double.valueOf(fadeOutDuration));
        }

        String fillAlpha = balloonElement.attributeValue("fillAlpha");
        if (StringUtils.isNotEmpty(fillAlpha)) {
            balloon.setFillAlpha(Double.valueOf(fillAlpha));
        }

        String fillColor = balloonElement.attributeValue("fillColor");
        if (StringUtils.isNotEmpty(fillColor)) {
            balloon.setFillColor(Color.valueOf(fillColor));
        }

        String fixedPosition = balloonElement.attributeValue("fixedPosition");
        if (StringUtils.isNotEmpty(fixedPosition)) {
            balloon.setFixedPosition(Boolean.valueOf(fixedPosition));
        }

        String fontSize = balloonElement.attributeValue("fontSize");
        if (StringUtils.isNotEmpty(fontSize)) {
            balloon.setFontSize(Integer.valueOf(fontSize));
        }

        String horizontalPadding = balloonElement.attributeValue("horizontalPadding");
        if (StringUtils.isNotEmpty(horizontalPadding)) {
            balloon.setHorizontalPadding(Integer.valueOf(horizontalPadding));
        }

        String maxWidth = balloonElement.attributeValue("maxWidth");
        if (StringUtils.isNotEmpty(maxWidth)) {
            balloon.setMaxWidth(Integer.valueOf(maxWidth));
        }

        String offsetX = balloonElement.attributeValue("offsetX");
        if (StringUtils.isNotEmpty(offsetX)) {
            balloon.setOffsetX(Integer.valueOf(offsetX));
        }

        String offsetY = balloonElement.attributeValue("offsetY");
        if (StringUtils.isNotEmpty(offsetY)) {
            balloon.setOffsetY(Integer.valueOf(offsetY));
        }

        String pointerOrientation = balloonElement.attributeValue("pointerOrientation");
        if (StringUtils.isNotEmpty(pointerOrientation)) {
            balloon.setPointerOrientation(PointerOrientation.valueOf(pointerOrientation));
        }

        String pointerWidth = balloonElement.attributeValue("pointerWidth");
        if (StringUtils.isNotEmpty(pointerWidth)) {
            balloon.setPointerWidth(Integer.valueOf(pointerWidth));
        }

        String shadowAlpha = balloonElement.attributeValue("shadowAlpha");
        if (StringUtils.isNotEmpty(shadowAlpha)) {
            balloon.setShadowAlpha(Double.valueOf(shadowAlpha));
        }

        String shadowColor = balloonElement.attributeValue("shadowColor");
        if (StringUtils.isNotEmpty(shadowColor)) {
            balloon.setShadowColor(Color.valueOf(shadowColor));
        }

        String showBullet = balloonElement.attributeValue("showBullet");
        if (StringUtils.isNotEmpty(showBullet)) {
            balloon.setShowBullet(Boolean.valueOf(showBullet));
        }

        String textAlign = balloonElement.attributeValue("textAlign");
        if (StringUtils.isNotEmpty(textAlign)) {
            balloon.setTextAlign(Align.valueOf(textAlign));
        }

        String verticalPadding = balloonElement.attributeValue("verticalPadding");
        if (StringUtils.isNotEmpty(verticalPadding)) {
            balloon.setVerticalPadding(Integer.valueOf(verticalPadding));
        }

        return balloon;
    }

    protected ExportMenuItem loadExportMenuItem(Element menuItemElement) {
        ExportMenuItem menuItem = new ExportMenuItem();

        String format = menuItemElement.attributeValue("format");
        if (StringUtils.isNotBlank(format)) {
            menuItem.setFormat(ExportFormat.valueOf(format));
        }

        String title = menuItemElement.attributeValue("title");
        if (StringUtils.isNotBlank(title)) {
            menuItem.setTitle(loadResourceString(title));
        }

        String label = menuItemElement.attributeValue("label");
        if (StringUtils.isNotBlank(label)) {
            menuItem.setLabel(loadResourceString(label));
        }

        return menuItem;
    }

    protected void loadExportMenu(Export export, Element exportElement) {
        Element menuElement = exportElement.element("menu");
        if (menuElement != null) {
            List<ExportMenuItem> items = new ArrayList<>();

            for (Object menuElementItem : menuElement.elements("item")) {
                Element menuItemElement = (Element) menuElementItem;
                items.add(loadExportMenuItem(menuItemElement));
            }

            export.setMenu(items);
        }
    }

    protected void loadExportLibs(ExportLibs libs, Element libsElement) {
        String path = libsElement.attributeValue("path");
        if (StringUtils.isNotEmpty(path)) {
            libs.setPath(path);
        }
    }

    protected Export loadExport(Element exportElement) {
        Export export = new Export();

        loadExportMenu(export, exportElement);

        String enabled = exportElement.attributeValue("enabled");
        if (StringUtils.isNotEmpty(enabled)) {
            export.setEnabled(Boolean.valueOf(enabled));
        }

        Element libsElement = exportElement.element("libs");
        if (libsElement != null) {
            ExportLibs libs = new ExportLibs();
            loadExportLibs(libs, libsElement);
            export.setLibs(libs);
        }

        String backgroundColor = exportElement.attributeValue("backgroundColor");
        if (StringUtils.isNotEmpty(backgroundColor)) {
            export.setBackgroundColor(Color.valueOf(backgroundColor));
        }

        String fileName = exportElement.attributeValue("fileName");
        if (StringUtils.isNotEmpty(fileName)) {
            export.setFileName(fileName);
        }

        String position = exportElement.attributeValue("position");
        if (StringUtils.isNotEmpty(position)) {
            export.setPosition(ExportPosition.valueOf(position));
        }

        String removeImages = exportElement.attributeValue("removeImages");
        if (StringUtils.isNotEmpty(removeImages)) {
            export.setRemoveImages(Boolean.valueOf(removeImages));
        }

        String exportTitles = exportElement.attributeValue("exportTitles");
        if (StringUtils.isNotEmpty(exportTitles)) {
            export.setExportTitles(Boolean.valueOf(exportTitles));
        }

        String exportSelection = exportElement.attributeValue("exportSelection");
        if (StringUtils.isNotEmpty(exportSelection)) {
            export.setExportSelection(Boolean.valueOf(exportSelection));
        }

        String dataDateFormat = exportElement.attributeValue("dataDateFormat");
        if (StringUtils.isNotEmpty(dataDateFormat)) {
            export.setDataDateFormat(dataDateFormat);
        }

        String dateFormat = exportElement.attributeValue("dateFormat");
        if (StringUtils.isNotEmpty(dateFormat)) {
            export.setDateFormat(dateFormat);
        }

        String keyListener = exportElement.attributeValue("keyListener");
        if (StringUtils.isNotEmpty(keyListener)) {
            export.setKeyListener(Boolean.valueOf(keyListener));
        }

        String fileListener = exportElement.attributeValue("fileListener");
        if (StringUtils.isNotEmpty(fileListener)) {
            export.setFileListener(Boolean.valueOf(fileListener));
        }

        return export;
    }

    protected void loadLegend(AbstractLegend legend, Element legendElement) {
        loadLegendItems(legend, legendElement);

        String accessibleLabel = legendElement.attributeValue("accessibleLabel");
        if (StringUtils.isNotEmpty(accessibleLabel)) {
            legend.setAccessibleLabel(loadResourceString(accessibleLabel));
        }

        String align = legendElement.attributeValue("align");
        if (StringUtils.isNotEmpty(align)) {
            legend.setAlign(Align.valueOf(align));
        }

        String autoMargins = legendElement.attributeValue("autoMargins");
        if (StringUtils.isNotEmpty(autoMargins)) {
            legend.setAutoMargins(Boolean.valueOf(autoMargins));
        }

        String backgroundAlpha = legendElement.attributeValue("backgroundAlpha");
        if (StringUtils.isNotEmpty(backgroundAlpha)) {
            legend.setBackgroundAlpha(Double.valueOf(backgroundAlpha));
        }

        String backgroundColor = legendElement.attributeValue("backgroundColor");
        if (StringUtils.isNotEmpty(backgroundColor)) {
            legend.setBackgroundColor(Color.valueOf(backgroundColor));
        }

        String borderAlpha = legendElement.attributeValue("borderAlpha");
        if (StringUtils.isNotEmpty(borderAlpha)) {
            legend.setBorderAlpha(Double.valueOf(borderAlpha));
        }

        String borderColor = legendElement.attributeValue("borderColor");
        if (StringUtils.isNotEmpty(borderColor)) {
            legend.setBackgroundColor(Color.valueOf(borderColor));
        }

        String bottom = legendElement.attributeValue("bottom");
        if (StringUtils.isNotEmpty(bottom)) {
            legend.setBottom(Integer.parseInt(bottom));
        }

        String color = legendElement.attributeValue("color");
        if (StringUtils.isNotEmpty(color)) {
            legend.setColor(Color.valueOf(color));
        }

        String divId = legendElement.attributeValue("divId");
        if (StringUtils.isNotEmpty(divId)) {
            legend.setDivId(divId);
        }

        String enabled = legendElement.attributeValue("enabled");
        if (StringUtils.isNotEmpty(enabled)) {
            legend.setEnabled(Boolean.valueOf(enabled));
        }

        String equalWidths = legendElement.attributeValue("equalWidths");
        if (StringUtils.isNotEmpty(equalWidths)) {
            legend.setEqualWidths(Boolean.valueOf(equalWidths));
        }

        String fontSize = legendElement.attributeValue("fontSize");
        if (StringUtils.isNotEmpty(fontSize)) {
            legend.setFontSize(Integer.parseInt(fontSize));
        }

        String forceWidth = legendElement.attributeValue("forceWidth");
        if (StringUtils.isNotEmpty(forceWidth)) {
            legend.setForceWidth(Boolean.valueOf(forceWidth));
        }

        String gradientRotation = legendElement.attributeValue("gradientRotation");
        if (StringUtils.isNotEmpty(gradientRotation)) {
            legend.setGradientRotation(Integer.parseInt(gradientRotation));
        }

        String horizontalGap = legendElement.attributeValue("horizontalGap");
        if (StringUtils.isNotEmpty(horizontalGap)) {
            legend.setHorizontalGap(Integer.parseInt(horizontalGap));
        }

        String labelWidth = legendElement.attributeValue("labelWidth");
        if (StringUtils.isNotEmpty(labelWidth)) {
            legend.setLabelWidth(Integer.parseInt(labelWidth));
        }

        String labelText = legendElement.attributeValue("labelText");
        if (StringUtils.isNotEmpty(labelText)) {
            legend.setLabelText(loadResourceString(labelText));
        }

        String left = legendElement.attributeValue("left");
        if (StringUtils.isNotEmpty(left)) {
            legend.setLeft(Integer.parseInt(left));
        }

        loadMargins(legend, legendElement);

        String markerBorderAlpha = legendElement.attributeValue("markerBorderAlpha");
        if (StringUtils.isNotEmpty(markerBorderAlpha)) {
            legend.setMarkerBorderAlpha(Double.valueOf(markerBorderAlpha));
        }

        String markerBorderColor = legendElement.attributeValue("markerBorderColor");
        if (StringUtils.isNotEmpty(markerBorderColor)) {
            legend.setMarkerBorderColor(Color.valueOf(markerBorderColor));
        }

        String markerBorderThickness = legendElement.attributeValue("markerBorderThickness");
        if (StringUtils.isNotEmpty(markerBorderThickness)) {
            legend.setMarkerBorderThickness(Integer.parseInt(markerBorderThickness));
        }

        String markerDisabledColor = legendElement.attributeValue("markerDisabledColor");
        if (StringUtils.isNotEmpty(markerDisabledColor)) {
            legend.setMarkerDisabledColor(Color.valueOf(markerDisabledColor));
        }

        String markerLabelGap = legendElement.attributeValue("markerLabelGap");
        if (StringUtils.isNotEmpty(markerLabelGap)) {
            legend.setMarkerLabelGap(Integer.parseInt(markerLabelGap));
        }

        String markerSize = legendElement.attributeValue("markerSize");
        if (StringUtils.isNotEmpty(markerSize)) {
            legend.setMarkerSize(Integer.parseInt(markerSize));
        }

        String markerType = legendElement.attributeValue("markerType");
        if (StringUtils.isNotEmpty(markerType)) {
            legend.setMarkerType(MarkerType.valueOf(markerType));
        }

        String maxColumns = legendElement.attributeValue("maxColumns");
        if (StringUtils.isNotEmpty(maxColumns)) {
            legend.setMaxColumns(Integer.parseInt(maxColumns));
        }

        String periodValueText = legendElement.attributeValue("periodValueText");
        if (StringUtils.isNotEmpty(periodValueText)) {
            legend.setPeriodValueText(loadResourceString(periodValueText));
        }

        String position = legendElement.attributeValue("position");
        if (StringUtils.isNotEmpty(position)) {
            legend.setPosition(LegendPosition.valueOf(position));
        }

        String reversedOrder = legendElement.attributeValue("reversedOrder");
        if (StringUtils.isNotEmpty(reversedOrder)) {
            legend.setReversedOrder(Boolean.valueOf(reversedOrder));
        }

        String right = legendElement.attributeValue("right");
        if (StringUtils.isNotEmpty(right)) {
            legend.setRight(Integer.parseInt(right));
        }

        String rollOverColor = legendElement.attributeValue("rollOverColor");
        if (StringUtils.isNotEmpty(rollOverColor)) {
            legend.setRollOverColor(Color.valueOf(rollOverColor));
        }

        String rollOverGraphAlpha = legendElement.attributeValue("rollOverGraphAlpha");
        if (StringUtils.isNotEmpty(rollOverGraphAlpha)) {
            legend.setRollOverGraphAlpha(Double.valueOf(rollOverGraphAlpha));
        }

        String showEntries = legendElement.attributeValue("showEntries");
        if (StringUtils.isNotEmpty(showEntries)) {
            legend.setShowEntries(Boolean.valueOf(showEntries));
        }

        String spacing = legendElement.attributeValue("spacing");
        if (StringUtils.isNotEmpty(spacing)) {
            legend.setSpacing(Integer.parseInt(spacing));
        }

        String switchable = legendElement.attributeValue("switchable");
        if (StringUtils.isNotEmpty(switchable)) {
            legend.setSwitchable(Boolean.valueOf(switchable));
        }

        String switchColor = legendElement.attributeValue("switchColor");
        if (StringUtils.isNotEmpty(switchColor)) {
            legend.setSwitchColor(Color.valueOf(switchColor));
        }

        String switchType = legendElement.attributeValue("switchType");
        if (StringUtils.isNotEmpty(switchType)) {
            legend.setSwitchType(LegendSwitch.valueOf(switchType));
        }

        String textClickEnabled = legendElement.attributeValue("textClickEnabled");
        if (StringUtils.isNotEmpty(textClickEnabled)) {
            legend.setTextClickEnabled(Boolean.valueOf(textClickEnabled));
        }

        String tabIndex = legendElement.attributeValue("tabIndex");
        if (StringUtils.isNotEmpty(tabIndex)) {
            legend.setTabIndex(Integer.parseInt(tabIndex));
        }

        String top = legendElement.attributeValue("top");
        if (StringUtils.isNotEmpty(top)) {
            legend.setTop(Integer.parseInt(top));
        }

        String useGraphSettings = legendElement.attributeValue("useGraphSettings");
        if (StringUtils.isNotEmpty(useGraphSettings)) {
            legend.setUseGraphSettings(Boolean.valueOf(useGraphSettings));
        }

        String useMarkerColorForLabels = legendElement.attributeValue("useMarkerColorForLabels");
        if (StringUtils.isNotEmpty(useMarkerColorForLabels)) {
            legend.setUseMarkerColorForLabels(Boolean.valueOf(useMarkerColorForLabels));
        }

        String useMarkerColorForValues = legendElement.attributeValue("useMarkerColorForValues");
        if (StringUtils.isNotEmpty(useMarkerColorForValues)) {
            legend.setUseMarkerColorForValues(Boolean.valueOf(useMarkerColorForValues));
        }

        String valueAlign = legendElement.attributeValue("valueAlign");
        if (StringUtils.isNotEmpty(valueAlign)) {
            legend.setValueAlign(ValueAlign.valueOf(valueAlign));
        }

        String valueFunction = legendElement.elementText("valueFunction");
        if (StringUtils.isNotBlank(valueFunction)) {
            legend.setValueFunction(new com.haulmont.charts.gui.model.JsFunction(valueFunction));
        }

        String valueText = legendElement.attributeValue("valueText");
        if (StringUtils.isNotEmpty(valueText)) {
            legend.setValueText(loadResourceString(valueText));
        }

        String valueWidth = legendElement.attributeValue("valueWidth");
        if (StringUtils.isNotEmpty(valueWidth)) {
            legend.setValueWidth(Integer.parseInt(valueWidth));
        }

        String verticalGap = legendElement.attributeValue("verticalGap");
        if (StringUtils.isNotEmpty(verticalGap)) {
            legend.setVerticalGap(Integer.parseInt(verticalGap));
        }

        String width = legendElement.attributeValue("width");
        if (StringUtils.isNotEmpty(width)) {
            legend.setWidth(Integer.parseInt(width));
        }
    }

    protected void loadLegendItems(AbstractLegend legend, Element legendElement) {
        Element legendDataElement = legendElement.element("data");
        if (legendDataElement != null) {
            for (Object dataItem : legendDataElement.elements("item")) {
                Element dataElement = (Element) dataItem;

                LegendItem legendItem = new LegendItem();

                String title = dataElement.attributeValue("title");
                if (StringUtils.isNotEmpty(title)) {
                    legendItem.setTitle(loadResourceString(title));
                }

                String color = dataElement.attributeValue("color");
                if (StringUtils.isNotEmpty(color)) {
                    legendItem.setColor(Color.valueOf(color));
                }

                String markerType = dataElement.attributeValue("markerType");
                if (StringUtils.isNotEmpty(markerType)) {
                    legendItem.setMarkerType(MarkerType.valueOf(markerType));
                }

                legend.addItems(legendItem);
            }
        }
    }

    @Nullable
    protected CreditsPosition loadCreditsPosition(Element element) {
        String creditsPosition = element.attributeValue("creditsPosition");
        if (StringUtils.isNotEmpty(creditsPosition)) {
            CreditsPosition cp = CreditsPosition.fromId(creditsPosition);
            if (cp == null) {
                cp = CreditsPosition.valueOf(creditsPosition);
            }
            return cp;
        }
        return null;
    }

    protected void loadMargins(HasMargins hasMargins, Element element) {
        String marginTop = element.attributeValue("marginTop");
        if (StringUtils.isNotEmpty(marginTop)) {
            hasMargins.setMarginTop(Integer.valueOf(marginTop));
        }

        String marginBottom = element.attributeValue("marginBottom");
        if (StringUtils.isNotEmpty(marginBottom)) {
            hasMargins.setMarginBottom(Integer.valueOf(marginBottom));
        }

        String marginLeft = element.attributeValue("marginLeft");
        if (StringUtils.isNotEmpty(marginLeft)) {
            hasMargins.setMarginLeft(Integer.valueOf(marginLeft));
        }

        String marginRight = element.attributeValue("marginRight");
        if (StringUtils.isNotEmpty(marginRight)) {
            hasMargins.setMarginRight(Integer.valueOf(marginRight));
        }
    }

    protected List<Color> loadColors(Element colorsElement) {
        List<Color> colors = new ArrayList<>();

        for (Object colorItem : colorsElement.elements("color")) {
            Element colorElement = (Element) colorItem;

            String value = colorElement.attributeValue("value");
            if (StringUtils.isNotEmpty(value)) {
                colors.add(Color.valueOf(value));
            }
        }
        return colors;
    }

    protected void loadDateFormat(DateFormat dateFormat, Element dateFormatElement) {
        String period = dateFormatElement.attributeValue("period");
        if (StringUtils.isNotEmpty(period)) {
            DatePeriod dp = DatePeriod.fromId(period);
            if (dp == null) {
                dp = DatePeriod.valueOf(period);
            }
            dateFormat.setPeriod(dp);
        }

        String format = dateFormatElement.attributeValue("format");
        if (StringUtils.isNotEmpty(format)) {
            dateFormat.setFormat(format);
        }
    }

    protected void loadGuide(Guide guide, Element guideElement) {
        String above = guideElement.attributeValue("above");
        if (StringUtils.isNotEmpty(above)) {
            guide.setAbove(Boolean.valueOf(above));
        }

        String angle = guideElement.attributeValue("angle");
        if (StringUtils.isNotEmpty(angle)) {
            guide.setAngle(Integer.valueOf(angle));
        }

        String balloonColor = guideElement.attributeValue("balloonColor");
        if (StringUtils.isNotEmpty(balloonColor)) {
            guide.setBalloonColor(Color.valueOf(balloonColor));
        }

        String balloonText = guideElement.attributeValue("balloonText");
        if (StringUtils.isNotEmpty(balloonText)) {
            guide.setBalloonText(loadResourceString(balloonText));
        }

        String boldLabel = guideElement.attributeValue("boldLabel");
        if (StringUtils.isNotEmpty(boldLabel)) {
            guide.setBoldLabel(Boolean.valueOf(boldLabel));
        }

        String category = guideElement.attributeValue("category");
        if (StringUtils.isNotEmpty(category)) {
            guide.setCategory(category);
        }

        String color = guideElement.attributeValue("color");
        if (StringUtils.isNotEmpty(color)) {
            guide.setColor(Color.valueOf(color));
        }

        String dashLength = guideElement.attributeValue("dashLength");
        if (StringUtils.isNotEmpty(dashLength)) {
            guide.setDashLength(Integer.valueOf(dashLength));
        }

        String date = guideElement.attributeValue("date");
        if (StringUtils.isNotEmpty(date)) {
            guide.setDate(loadDate(date));
        }

        String expand = guideElement.attributeValue("expand");
        if (StringUtils.isNotEmpty(expand)) {
            guide.setExpand(Boolean.valueOf(expand));
        }

        String fillAlpha = guideElement.attributeValue("fillAlpha");
        if (StringUtils.isNotEmpty(fillAlpha)) {
            guide.setFillAlpha(Double.valueOf(fillAlpha));
        }

        String fillColor = guideElement.attributeValue("fillColor");
        if (StringUtils.isNotEmpty(fillColor)) {
            guide.setFillColor(Color.valueOf(fillColor));
        }

        String fontSize = guideElement.attributeValue("fontSize");
        if (StringUtils.isNotEmpty(fontSize)) {
            guide.setFontSize(Integer.valueOf(fontSize));
        }

        String id = guideElement.attributeValue("id");
        if (StringUtils.isNotEmpty(id)) {
            guide.setId(id);
        }

        String inside = guideElement.attributeValue("inside");
        if (StringUtils.isNotEmpty(inside)) {
            guide.setInside(Boolean.valueOf(inside));
        }

        String label = guideElement.attributeValue("label");
        if (StringUtils.isNotEmpty(label)) {
            guide.setLabel(loadResourceString(label));
        }

        String labelRotation = guideElement.attributeValue("labelRotation");
        if (StringUtils.isNotEmpty(labelRotation)) {
            guide.setLabelRotation(Integer.valueOf(labelRotation));
        }

        String lineAlpha = guideElement.attributeValue("lineAlpha");
        if (StringUtils.isNotEmpty(lineAlpha)) {
            guide.setLineAlpha(Double.valueOf(lineAlpha));
        }

        String lineColor = guideElement.attributeValue("lineColor");
        if (StringUtils.isNotEmpty(lineColor)) {
            guide.setLineColor(Color.valueOf(lineColor));
        }

        String lineThickness = guideElement.attributeValue("lineThickness");
        if (StringUtils.isNotEmpty(lineThickness)) {
            guide.setLineThickness(Integer.valueOf(lineThickness));
        }

        String position = guideElement.attributeValue("position");
        if (StringUtils.isNotEmpty(position)) {
            guide.setPosition(Position.valueOf(position));
        }

        String tickLength = guideElement.attributeValue("tickLength");
        if (StringUtils.isNotEmpty(tickLength)) {
            guide.setTickLength(Integer.valueOf(tickLength));
        }

        String toAngle = guideElement.attributeValue("toAngle");
        if (StringUtils.isNotEmpty(toAngle)) {
            guide.setToAngle(Integer.valueOf(toAngle));
        }

        String toCategory = guideElement.attributeValue("toCategory");
        if (StringUtils.isNotEmpty(toCategory)) {
            guide.setToCategory(toCategory);
        }

        String toDate = guideElement.attributeValue("toDate");
        if (StringUtils.isNotEmpty(toDate)) {
            guide.setToDate(loadDate(toDate));
        }

        String toValue = guideElement.attributeValue("toValue");
        if (StringUtils.isNotEmpty(toValue)) {
            guide.setToValue(Double.valueOf(toValue));
        }

        String value = guideElement.attributeValue("value");
        if (StringUtils.isNotEmpty(value)) {
            guide.setValue(Double.valueOf(value));
        }

        String valueAxis = guideElement.attributeValue("valueAxis");
        if (StringUtils.isNotEmpty(valueAxis)) {
            guide.setValueAxis(valueAxis);
        }
    }

    protected List<Guide> loadGuides(Element guidesElement) {
        List<Guide> guides = new ArrayList<>();
        for (Object guideItem : guidesElement.elements("guide")) {
            Element guideElement = (Element) guideItem;

            Guide guide = new Guide();
            loadGuide(guide, guideElement);
            guides.add(guide);
        }
        return guides;
    }

    protected Date loadDate(String value) {
        SimpleDateFormat df = new SimpleDateFormat(CONFIG_DATE_FORMAT);
        try {
            return df.parse(value);
        } catch (ParseException e) {
            throw new GuiDevelopmentException("Unable to parse date from XML chart configuration",
                    context.getCurrentFrameId(), "date", value);
        }
    }

    protected List<DateFormat> loadDateFormats(Element dateFormatsElement) {
        List<DateFormat> dateFormats = new ArrayList<>();
        for (Object dateFormatItem : dateFormatsElement.elements("dateFormat")) {
            Element dateFormatElement = (Element) dateFormatItem;
            DateFormat dateFormat = new DateFormat();
            loadDateFormat(dateFormat, dateFormatElement);
            dateFormats.add(dateFormat);
        }
        return dateFormats;
    }

    protected void loadAbstractAxis(AbstractAxis axis, Element element) {
        String autoGridCount = element.attributeValue("autoGridCount");
        if (StringUtils.isNotEmpty(autoGridCount)) {
            axis.setAutoGridCount(Boolean.valueOf(autoGridCount));
        }

        String autoRotateAngle = element.attributeValue("autoRotateAngle");
        if (StringUtils.isNotEmpty(autoRotateAngle)) {
            axis.setAutoRotateAngle(Integer.parseInt(autoRotateAngle));
        }

        String autoRotateCount = element.attributeValue("autoRotateCount");
        if (StringUtils.isNotEmpty(autoRotateCount)) {
            axis.setAutoRotateCount(Integer.parseInt(autoRotateCount));
        }

        String axisAlpha = element.attributeValue("axisAlpha");
        if (StringUtils.isNotEmpty(axisAlpha)) {
            axis.setAxisAlpha(Double.valueOf(axisAlpha));
        }

        String axisColor = element.attributeValue("axisColor");
        if (StringUtils.isNotEmpty(axisColor)) {
            axis.setAxisColor(Color.valueOf(axisColor));
        }

        String axisThickness = element.attributeValue("axisThickness");
        if (StringUtils.isNotEmpty(axisThickness)) {
            axis.setAxisThickness(Integer.parseInt(axisThickness));
        }

        Element balloonElement = element.element("balloon");
        if (balloonElement != null) {
            axis.setBalloon(loadBalloon(balloonElement));
        }

        String boldLabels = element.attributeValue("boldLabels");
        if (StringUtils.isNotEmpty(boldLabels)) {
            axis.setCenterLabels(Boolean.valueOf(boldLabels));
        }

        String boldPeriodBeginning = element.attributeValue("boldPeriodBeginning");
        if (StringUtils.isNotEmpty(boldPeriodBeginning)) {
            axis.setBoldPeriodBeginning(Boolean.valueOf(boldPeriodBeginning));
        }

        String centerLabelOnFullPeriod = element.attributeValue("centerLabelOnFullPeriod");
        if (StringUtils.isNotEmpty(centerLabelOnFullPeriod)) {
            axis.setCenterLabelOnFullPeriod(Boolean.valueOf(centerLabelOnFullPeriod));
        }

        String centerLabels = element.attributeValue("centerLabels");
        if (StringUtils.isNotEmpty(centerLabels)) {
            axis.setBoldLabels(Boolean.valueOf(centerLabels));
        }

        String color = element.attributeValue("color");
        if (StringUtils.isNotEmpty(color)) {
            axis.setColor(Color.valueOf(color));
        }

        String dashLength = element.attributeValue("dashLength");
        if (StringUtils.isNotEmpty(dashLength)) {
            axis.setDashLength(Integer.parseInt(dashLength));
        }

        Element dateFormatsElement = element.element("dateFormats");
        if (dateFormatsElement != null) {
            axis.setDateFormats(loadDateFormats(dateFormatsElement));
        }

        String fillAlpha = element.attributeValue("fillAlpha");
        if (StringUtils.isNotEmpty(fillAlpha)) {
            axis.setFillAlpha(Double.valueOf(fillAlpha));
        }

        String fillColor = element.attributeValue("fillColor");
        if (StringUtils.isNotEmpty(fillColor)) {
            axis.setFillColor(Color.valueOf(fillColor));
        }

        String fontSize = element.attributeValue("fontSize");
        if (StringUtils.isNotEmpty(fontSize)) {
            axis.setFontSize(Integer.parseInt(fontSize));
        }

        String gridAlpha = element.attributeValue("gridAlpha");
        if (StringUtils.isNotEmpty(gridAlpha)) {
            axis.setGridAlpha(Double.valueOf(gridAlpha));
        }

        String gridColor = element.attributeValue("gridColor");
        if (StringUtils.isNotEmpty(gridColor)) {
            axis.setGridColor(Color.valueOf(gridColor));
        }

        String gridCount = element.attributeValue("gridCount");
        if (StringUtils.isNotEmpty(gridCount)) {
            axis.setGridCount(Integer.parseInt(gridCount));
        }

        String gridThickness = element.attributeValue("gridThickness");
        if (StringUtils.isNotEmpty(gridThickness)) {
            axis.setGridThickness(Integer.parseInt(gridThickness));
        }

        Element guidesElement = element.element("guides");
        if (guidesElement != null) {
            axis.setGuides(loadGuides(guidesElement));
        }

        String ignoreAxisWidth = element.attributeValue("ignoreAxisWidth");
        if (StringUtils.isNotEmpty(ignoreAxisWidth)) {
            axis.setIgnoreAxisWidth(Boolean.valueOf(ignoreAxisWidth));
        }

        String inside = element.attributeValue("inside");
        if (StringUtils.isNotEmpty(inside)) {
            axis.setInside(Boolean.valueOf(inside));
        }

        String labelFrequency = element.attributeValue("labelFrequency");
        if (StringUtils.isNotEmpty(labelFrequency)) {
            axis.setLabelFrequency(Double.valueOf(labelFrequency));
        }

        String labelOffset = element.attributeValue("labelOffset");
        if (StringUtils.isNotEmpty(labelOffset)) {
            axis.setLabelOffset(Integer.parseInt(labelOffset));
        }

        String labelRotation = element.attributeValue("labelRotation");
        if (StringUtils.isNotEmpty(labelRotation)) {
            axis.setLabelRotation(Integer.parseInt(labelRotation));
        }

        String labelsEnabled = element.attributeValue("labelsEnabled");
        if (StringUtils.isNotEmpty(labelsEnabled)) {
            axis.setLabelsEnabled(Boolean.valueOf(labelsEnabled));
        }

        String markPeriodChange = element.attributeValue("markPeriodChange");
        if (StringUtils.isNotEmpty(markPeriodChange)) {
            axis.setMarkPeriodChange(Boolean.valueOf(markPeriodChange));
        }

        String minHorizontalGap = element.attributeValue("minHorizontalGap");
        if (StringUtils.isNotEmpty(minHorizontalGap)) {
            axis.setMinHorizontalGap(Integer.parseInt(minHorizontalGap));
        }

        String minorGridAlpha = element.attributeValue("minorGridAlpha");
        if (StringUtils.isNotEmpty(minorGridAlpha)) {
            axis.setMinorGridAlpha(Double.valueOf(minorGridAlpha));
        }

        String minorGridEnabled = element.attributeValue("minorGridEnabled");
        if (StringUtils.isNotEmpty(minorGridEnabled)) {
            axis.setMinorGridEnabled(Boolean.valueOf(minorGridEnabled));
        }

        String minVerticalGap = element.attributeValue("minVerticalGap");
        if (StringUtils.isNotEmpty(minVerticalGap)) {
            axis.setMinVerticalGap(Integer.parseInt(minVerticalGap));
        }

        String minorTickLength = element.attributeValue("minorTickLength");
        if (StringUtils.isNotEmpty(minorTickLength)) {
            axis.setMinorTickLength(Integer.parseInt(minorTickLength));
        }

        String offset = element.attributeValue("offset");
        if (StringUtils.isNotEmpty(offset)) {
            axis.setOffset(Integer.parseInt(offset));
        }

        String position = element.attributeValue("position");
        if (StringUtils.isNotEmpty(position)) {
            axis.setPosition(Position.valueOf(position));
        }

        String showFirstLabel = element.attributeValue("showFirstLabel");
        if (StringUtils.isNotEmpty(showFirstLabel)) {
            axis.setShowFirstLabel(Boolean.valueOf(showFirstLabel));
        }

        String showLastLabel = element.attributeValue("showLastLabel");
        if (StringUtils.isNotEmpty(showLastLabel)) {
            axis.setShowLastLabel(Boolean.valueOf(showLastLabel));
        }

        String tickLength = element.attributeValue("tickLength");
        if (StringUtils.isNotEmpty(tickLength)) {
            axis.setTickLength(Integer.parseInt(tickLength));
        }

        String title = element.attributeValue("title");
        if (StringUtils.isNotEmpty(title)) {
            axis.setTitle(loadResourceString(title));
        }

        String titleBold = element.attributeValue("titleBold");
        if (StringUtils.isNotEmpty(titleBold)) {
            axis.setTitleBold(Boolean.valueOf(titleBold));
        }

        String titleColor = element.attributeValue("titleColor");
        if (StringUtils.isNotEmpty(titleColor)) {
            axis.setTitleColor(Color.valueOf(titleColor));
        }

        String titleFontSize = element.attributeValue("titleFontSize");
        if (StringUtils.isNotEmpty(titleFontSize)) {
            axis.setTitleFontSize(Integer.parseInt(titleFontSize));
        }

        String titleRotation = element.attributeValue("titleRotation");
        if (StringUtils.isNotEmpty(titleRotation)) {
            axis.setTitleRotation(Integer.parseInt(titleRotation));
        }
    }

    protected ValueAxis loadValueAxis(Element valueAxisElement) {
        ValueAxis axis = new ValueAxis();

        loadAbstractAxis(axis, valueAxisElement);

        String id = valueAxisElement.attributeValue("id");
        if (StringUtils.isNotEmpty(id)) {
            axis.setId(id);
        }

        String labelFunction = valueAxisElement.elementText("labelFunction");
        if (StringUtils.isNotBlank(labelFunction)) {
            axis.setLabelFunction(new com.haulmont.charts.gui.model.JsFunction(labelFunction));
        }

        String axisFrequency = valueAxisElement.attributeValue("axisFrequency");
        if (StringUtils.isNotEmpty(axisFrequency)) {
            axis.setAxisFrequency(Double.valueOf(axisFrequency));
        }

        String axisTitleOffset = valueAxisElement.attributeValue("axisTitleOffset");
        if (StringUtils.isNotEmpty(axisTitleOffset)) {
            axis.setAxisTitleOffset(Integer.valueOf(axisTitleOffset));
        }

        String balloonTextFunction = valueAxisElement.elementText("balloonTextFunction");
        if (StringUtils.isNotBlank(balloonTextFunction)) {
            axis.setBalloonTextFunction(new com.haulmont.charts.gui.model.JsFunction(balloonTextFunction));
        }

        String baseValue = valueAxisElement.attributeValue("baseValue");
        if (StringUtils.isNotEmpty(baseValue)) {
            axis.setBaseValue(Double.valueOf(baseValue));
        }

        String duration = valueAxisElement.attributeValue("duration");
        if (StringUtils.isNotEmpty(duration)) {
            axis.setDuration(Duration.valueOf(duration));
        }

        String gridType = valueAxisElement.attributeValue("gridType");
        if (StringUtils.isNotEmpty(gridType)) {
            axis.setGridType(GridType.valueOf(gridType));
        }

        String includeAllValues = valueAxisElement.attributeValue("includeAllValues");
        if (StringUtils.isNotEmpty(includeAllValues)) {
            axis.setIncludeAllValues(Boolean.valueOf(includeAllValues));
        }

        String includeGuidesInMinMax = valueAxisElement.attributeValue("includeGuidesInMinMax");
        if (StringUtils.isNotEmpty(includeGuidesInMinMax)) {
            axis.setIncludeGuidesInMinMax(Boolean.valueOf(includeGuidesInMinMax));
        }

        String includeHidden = valueAxisElement.attributeValue("includeHidden");
        if (StringUtils.isNotEmpty(includeHidden)) {
            axis.setIncludeHidden(Boolean.valueOf(includeHidden));
        }

        String integersOnly = valueAxisElement.attributeValue("integersOnly");
        if (StringUtils.isNotEmpty(integersOnly)) {
            axis.setIntegersOnly(Boolean.valueOf(integersOnly));
        }

        String logarithmic = valueAxisElement.attributeValue("logarithmic");
        if (StringUtils.isNotEmpty(logarithmic)) {
            axis.setLogarithmic(Boolean.valueOf(logarithmic));
        }

        String maximum = valueAxisElement.attributeValue("maximum");
        if (StringUtils.isNotEmpty(maximum)) {
            axis.setMaximum(Double.valueOf(maximum));
        }

        String maximumDate = valueAxisElement.attributeValue("maximumDate");
        if (StringUtils.isNotEmpty(maximumDate)) {
            axis.setMaximumDate(loadDate(maximumDate));
        }

        String minimum = valueAxisElement.attributeValue("minimum");
        if (StringUtils.isNotEmpty(minimum)) {
            axis.setMinimum(Double.valueOf(minimum));
        }

        String minimumDate = valueAxisElement.attributeValue("minimumDate");
        if (StringUtils.isNotEmpty(minimumDate)) {
            axis.setMinimumDate(loadDate(minimumDate));
        }

        String minMaxMultiplier = valueAxisElement.attributeValue("minMaxMultiplier");
        if (StringUtils.isNotEmpty(minMaxMultiplier)) {
            axis.setMinMaxMultiplier(Double.valueOf(minMaxMultiplier));
        }

        String pointPosition = valueAxisElement.attributeValue("pointPosition");
        if (StringUtils.isNotEmpty(pointPosition)) {
            axis.setPointPosition(PointPosition.valueOf(pointPosition));
        }

        String precision = valueAxisElement.attributeValue("precision");
        if (StringUtils.isNotEmpty(precision)) {
            axis.setPrecision(Integer.valueOf(precision));
        }

        String radarCategoriesEnabled = valueAxisElement.attributeValue("radarCategoriesEnabled");
        if (StringUtils.isNotEmpty(radarCategoriesEnabled)) {
            axis.setRadarCategoriesEnabled(Boolean.valueOf(radarCategoriesEnabled));
        }

        String recalculateToPercents = valueAxisElement.attributeValue("recalculateToPercents");
        if (StringUtils.isNotEmpty(recalculateToPercents)) {
            axis.setRecalculateToPercents(Boolean.valueOf(recalculateToPercents));
        }

        String reversed = valueAxisElement.attributeValue("reversed");
        if (StringUtils.isNotEmpty(reversed)) {
            axis.setReversed(Boolean.valueOf(reversed));
        }

        String stackType = valueAxisElement.attributeValue("stackType");
        if (StringUtils.isNotEmpty(stackType)) {
            axis.setStackType(StackType.valueOf(stackType));
        }

        String strictMinMax = valueAxisElement.attributeValue("strictMinMax");
        if (StringUtils.isNotEmpty(strictMinMax)) {
            axis.setStrictMinMax(Boolean.valueOf(strictMinMax));
        }

        String synchronizationMultiplier = valueAxisElement.attributeValue("synchronizationMultiplier");
        if (StringUtils.isNotEmpty(synchronizationMultiplier)) {
            axis.setSynchronizationMultiplier(Double.valueOf(synchronizationMultiplier));
        }

        String synchronizeWith = valueAxisElement.attributeValue("synchronizeWith");
        if (StringUtils.isNotEmpty(synchronizeWith)) {
            axis.setSynchronizeWith(synchronizeWith);
        }

        String totalText = valueAxisElement.elementText("totalText");
        if (StringUtils.isNotEmpty(totalText)) {
            axis.setTotalText(loadResourceString(totalText));
        }

        String totalTextColor = valueAxisElement.attributeValue("totalTextColor");
        if (StringUtils.isNotEmpty(totalTextColor)) {
            axis.setTotalTextColor(Color.valueOf(totalTextColor));
        }

        String totalTextOffset = valueAxisElement.attributeValue("totalTextOffset");
        if (StringUtils.isNotEmpty(totalTextOffset)) {
            axis.setTotalTextOffset(Integer.valueOf(totalTextOffset));
        }

        String treatZeroAs = valueAxisElement.attributeValue("treatZeroAs");
        if (StringUtils.isNotEmpty(treatZeroAs)) {
            axis.setTreatZeroAs(Double.valueOf(treatZeroAs));
        }

        String type = valueAxisElement.attributeValue("type");
        if (StringUtils.isNotEmpty(type)) {
            axis.setType(ValueAxisType.valueOf(type));
        }

        String unit = valueAxisElement.attributeValue("unit");
        if (StringUtils.isNotEmpty(unit)) {
            axis.setUnit(unit);
        }

        String unitPosition = valueAxisElement.attributeValue("unitPosition");
        if (StringUtils.isNotEmpty(unitPosition)) {
            axis.setUnitPosition(UnitPosition.valueOf(unitPosition));
        }

        String usePrefixes = valueAxisElement.attributeValue("usePrefixes");
        if (StringUtils.isNotEmpty(usePrefixes)) {
            axis.setUsePrefixes(Boolean.valueOf(usePrefixes));
        }

        String useScientificNotation = valueAxisElement.attributeValue("useScientificNotation");
        if (StringUtils.isNotEmpty(useScientificNotation)) {
            axis.setUseScientificNotation(Boolean.valueOf(useScientificNotation));
        }

        String zeroGridAlpha = valueAxisElement.attributeValue("zeroGridAlpha");
        if (StringUtils.isNotEmpty(zeroGridAlpha)) {
            axis.setZeroGridAlpha(Double.valueOf(zeroGridAlpha));
        }

        return axis;
    }

    protected void loadGraph(AbstractGraph graph, Element graphElement) {
        String accessibleLabel = graphElement.attributeValue("accessibleLabel");
        if (StringUtils.isNotEmpty(accessibleLabel)) {
            graph.setAccessibleLabel(loadResourceString(accessibleLabel));
        }

        String alphaField = graphElement.attributeValue("alphaField");
        if (StringUtils.isNotEmpty(alphaField)) {
            graph.setAlphaField(alphaField);
        }

        String animationPlayed = graphElement.attributeValue("animationPlayed");
        if (StringUtils.isNotEmpty(animationPlayed)) {
            graph.setAnimationPlayed(Boolean.valueOf(animationPlayed));
        }

        Element balloonElement = graphElement.element("balloon");
        if (balloonElement != null) {
            graph.setBalloon(loadBalloon(balloonElement));
        }

        String balloonColor = graphElement.attributeValue("balloonColor");
        if (StringUtils.isNotEmpty(balloonColor)) {
            graph.setBalloonColor(Color.valueOf(balloonColor));
        }

        String balloonFunction = graphElement.elementText("balloonFunction");
        if (StringUtils.isNotEmpty(balloonFunction)) {
            graph.setBalloonFunction(new JsFunction(balloonFunction));
        }

        String balloonText = graphElement.attributeValue("balloonText");
        if (StringUtils.isNotEmpty(balloonText)) {
            graph.setBalloonText(loadResourceString(balloonText));
        }

        String behindColumns = graphElement.attributeValue("behindColumns");
        if (StringUtils.isNotEmpty(behindColumns)) {
            graph.setBehindColumns(Boolean.valueOf(behindColumns));
        }

        String bullet = graphElement.attributeValue("bullet");
        if (StringUtils.isNotEmpty(bullet)) {
            graph.setBullet(BulletType.valueOf(bullet));
        }

        String bulletAlpha = graphElement.attributeValue("bulletAlpha");
        if (StringUtils.isNotEmpty(bulletAlpha)) {
            graph.setBulletAlpha(Double.valueOf(bulletAlpha));
        }

        String bulletAxis = graphElement.attributeValue("bulletAxis");
        if (StringUtils.isNotEmpty(bulletAxis)) {
            graph.setBulletAxis(bulletAxis);
        }

        String bulletBorderAlpha = graphElement.attributeValue("bulletBorderAlpha");
        if (StringUtils.isNotEmpty(bulletBorderAlpha)) {
            graph.setBulletBorderAlpha(Double.valueOf(bulletBorderAlpha));
        }

        String bulletBorderColor = graphElement.attributeValue("bulletBorderColor");
        if (StringUtils.isNotEmpty(bulletBorderColor)) {
            graph.setBulletBorderColor(Color.valueOf(bulletBorderColor));
        }

        String bulletBorderThickness = graphElement.attributeValue("bulletBorderThickness");
        if (StringUtils.isNotEmpty(bulletBorderThickness)) {
            graph.setBulletBorderThickness(Integer.valueOf(bulletBorderThickness));
        }

        String bulletColor = graphElement.attributeValue("bulletColor");
        if (StringUtils.isNotEmpty(bulletColor)) {
            graph.setBulletColor(Color.valueOf(bulletColor));
        }

        String bulletField = graphElement.attributeValue("bulletField");
        if (StringUtils.isNotEmpty(bulletField)) {
            graph.setBulletField(bulletField);
        }

        String bulletHitAreaSize = graphElement.attributeValue("bulletHitAreaSize");
        if (StringUtils.isNotEmpty(bulletHitAreaSize)) {
            graph.setBulletHitAreaSize(Integer.valueOf(bulletHitAreaSize));
        }

        String bulletOffset = graphElement.attributeValue("bulletOffset");
        if (StringUtils.isNotEmpty(bulletOffset)) {
            graph.setBulletOffset(Integer.valueOf(bulletOffset));
        }

        String bulletSize = graphElement.attributeValue("bulletSize");
        if (StringUtils.isNotEmpty(bulletSize)) {
            graph.setBulletSize(Integer.valueOf(bulletSize));
        }

        String classNameField = graphElement.attributeValue("classNameField");
        if (StringUtils.isNotEmpty(classNameField)) {
            graph.setClassNameField(classNameField);
        }

        String bulletSizeField = graphElement.attributeValue("bulletSizeField");
        if (StringUtils.isNotEmpty(bulletSizeField)) {
            graph.setBulletSizeField(bulletSizeField);
        }

        String closeField = graphElement.attributeValue("closeField");
        if (StringUtils.isNotEmpty(closeField)) {
            graph.setCloseField(closeField);
        }

        String clustered = graphElement.attributeValue("clustered");
        if (StringUtils.isNotEmpty(clustered)) {
            graph.setClustered(Boolean.valueOf(clustered));
        }

        String color = graphElement.attributeValue("color");
        if (StringUtils.isNotEmpty(color)) {
            graph.setColor(Color.valueOf(color));
        }

        String colorField = graphElement.attributeValue("colorField");
        if (StringUtils.isNotEmpty(colorField)) {
            graph.setColorField(colorField);
        }

        String columnIndexField = graphElement.attributeValue("columnIndexField");
        if (StringUtils.isNotEmpty(columnIndexField)) {
            graph.setColumnIndexField(columnIndexField);
        }

        String columnWidth = graphElement.attributeValue("columnWidth");
        if (StringUtils.isNotEmpty(columnWidth)) {
            graph.setColumnWidth(Double.valueOf(columnWidth));
        }

        String connect = graphElement.attributeValue("connect");
        if (StringUtils.isNotEmpty(connect)) {
            graph.setConnect(Boolean.valueOf(connect));
        }

        String cornerRadiusTop = graphElement.attributeValue("cornerRadiusTop");
        if (StringUtils.isNotEmpty(cornerRadiusTop)) {
            graph.setCornerRadiusTop(Integer.valueOf(cornerRadiusTop));
        }

        String cursorBulletAlpha = graphElement.attributeValue("cursorBulletAlpha");
        if (StringUtils.isNotEmpty(cursorBulletAlpha)) {
            graph.setCursorBulletAlpha(Double.valueOf(cursorBulletAlpha));
        }

        String customBullet = graphElement.attributeValue("customBullet");
        if (StringUtils.isNotEmpty(customBullet)) {
            graph.setCustomBullet(customBullet);
        }

        String customBulletField = graphElement.attributeValue("customBulletField");
        if (StringUtils.isNotEmpty(customBulletField)) {
            graph.setCustomBulletField(customBulletField);
        }

        String customMarker = graphElement.attributeValue("customMarker");
        if (StringUtils.isNotEmpty(customMarker)) {
            graph.setCustomMarker(customMarker);
        }

        String dashLength = graphElement.attributeValue("dashLength");
        if (StringUtils.isNotEmpty(dashLength)) {
            graph.setDashLength(Integer.valueOf(dashLength));
        }

        String dashLengthField = graphElement.attributeValue("dashLengthField");
        if (StringUtils.isNotEmpty(dashLengthField)) {
            graph.setDashLengthField(dashLengthField);
        }

        Element dateFormatElement = graphElement.element("dateFormat");
        if (dateFormatElement != null) {
            DateFormat dateFormat = new DateFormat();
            loadDateFormat(dateFormat, dateFormatElement);
            graph.setDateFormat(dateFormat);
        }

        String descriptionField = graphElement.attributeValue("descriptionField");
        if (StringUtils.isNotEmpty(descriptionField)) {
            graph.setDescriptionField(descriptionField);
        }

        String errorField = graphElement.attributeValue("errorField");
        if (StringUtils.isNotEmpty(errorField)) {
            graph.setErrorField(errorField);
        }

        String fillAlphas = graphElement.attributeValue("fillAlphas");
        if (StringUtils.isNotEmpty(fillAlphas)) {
            graph.setFillAlphas(Double.valueOf(fillAlphas));
        }

        String fillColors = graphElement.attributeValue("fillColors");
        if (StringUtils.isNotEmpty(fillColors)) {
            graph.setFillColors(Color.valueOf(fillColors));
        }

        String fillColorsField = graphElement.attributeValue("fillColorsField");
        if (StringUtils.isNotEmpty(fillColorsField)) {
            graph.setFillColorsField(fillColorsField);
        }

        String fillToAxis = graphElement.attributeValue("fillToAxis");
        if (StringUtils.isNotEmpty(fillToAxis)) {
            graph.setFillToAxis(fillToAxis);
        }

        String fillToGraph = graphElement.attributeValue("fillToGraph");
        if (StringUtils.isNotEmpty(fillToGraph)) {
            graph.setFillToGraph(fillToGraph);
        }

        String fixedColumnWidth = graphElement.attributeValue("fixedColumnWidth");
        if (StringUtils.isNotEmpty(fixedColumnWidth)) {
            graph.setFixedColumnWidth(Integer.valueOf(fixedColumnWidth));
        }

        String fontSize = graphElement.attributeValue("fontSize");
        if (StringUtils.isNotEmpty(fontSize)) {
            graph.setFontSize(Integer.valueOf(fontSize));
        }

        String forceGap = graphElement.attributeValue("forceGap");
        if (StringUtils.isNotEmpty(forceGap)) {
            graph.setForceGap(Boolean.valueOf(forceGap));
        }

        String gapField = graphElement.attributeValue("gapField");
        if (StringUtils.isNotEmpty(gapField)) {
            graph.setGapField(gapField);
        }

        String gapPeriod = graphElement.attributeValue("gapPeriod");
        if (StringUtils.isNotEmpty(gapPeriod)) {
            graph.setGapPeriod(Double.valueOf(gapPeriod));
        }

        String gradientOrientation = graphElement.attributeValue("gradientOrientation");
        if (StringUtils.isNotEmpty(gradientOrientation)) {
            graph.setGradientOrientation(GradientOrientation.valueOf(gradientOrientation));
        }

        String hidden = graphElement.attributeValue("hidden");
        if (StringUtils.isNotEmpty(hidden)) {
            graph.setHidden(Boolean.valueOf(hidden));
        }

        String hideBulletsCount = graphElement.attributeValue("hideBulletsCount");
        if (StringUtils.isNotEmpty(hideBulletsCount)) {
            graph.setHideBulletsCount(Integer.valueOf(hideBulletsCount));
        }

        String highField = graphElement.attributeValue("highField");
        if (StringUtils.isNotEmpty(highField)) {
            graph.setHighField(highField);
        }

        String id = graphElement.attributeValue("id");
        if (StringUtils.isNotEmpty(id)) {
            graph.setId(id);
        }

        String includeInMinMax = graphElement.attributeValue("includeInMinMax");
        if (StringUtils.isNotEmpty(includeInMinMax)) {
            graph.setIncludeInMinMax(Boolean.valueOf(includeInMinMax));
        }

        String labelAnchor = graphElement.attributeValue("labelAnchor");
        if (StringUtils.isNotEmpty(labelAnchor)) {
            graph.setLabelAnchor(labelAnchor);
        }

        String labelColorField = graphElement.attributeValue("labelColorField");
        if (StringUtils.isNotEmpty(labelColorField)) {
            graph.setLabelColorField(labelColorField);
        }

        String labelFunction = graphElement.elementText("labelFunction");
        if (StringUtils.isNotBlank(labelFunction)) {
            graph.setLabelFunction(new JsFunction(labelFunction));
        }

        String labelOffset = graphElement.attributeValue("labelOffset");
        if (StringUtils.isNotEmpty(labelOffset)) {
            graph.setLabelOffset(Integer.valueOf(labelOffset));
        }

        String labelPosition = graphElement.attributeValue("labelPosition");
        if (StringUtils.isNotEmpty(labelPosition)) {
            graph.setLabelPosition(ValueLabelPosition.valueOf(labelPosition));
        }

        String labelRotation = graphElement.attributeValue("labelRotation");
        if (StringUtils.isNotEmpty(labelRotation)) {
            graph.setLabelRotation(Integer.valueOf(labelRotation));
        }

        String labelText = graphElement.attributeValue("labelText");
        if (StringUtils.isNotEmpty(labelText)) {
            graph.setLabelText(loadResourceString(labelText));
        }

        String legendAlpha = graphElement.attributeValue("legendAlpha");
        if (StringUtils.isNotEmpty(legendAlpha)) {
            graph.setLegendAlpha(Double.valueOf(legendAlpha));
        }

        String legendColor = graphElement.attributeValue("legendColor");
        if (StringUtils.isNotEmpty(legendColor)) {
            graph.setLegendColor(Color.valueOf(legendColor));
        }

        String legendColorFunction = graphElement.elementText("legendColorFunction");
        if (StringUtils.isNotBlank(legendColorFunction)) {
            graph.setLegendColorFunction(new JsFunction(legendColorFunction));
        }

        String legendPeriodValueText = graphElement.attributeValue("legendPeriodValueText");
        if (StringUtils.isNotEmpty(legendPeriodValueText)) {
            graph.setLegendPeriodValueText(loadResourceString(legendPeriodValueText));
        }

        String legendValueText = graphElement.attributeValue("legendValueText");
        if (StringUtils.isNotEmpty(legendValueText)) {
            graph.setLegendValueText(loadResourceString(legendValueText));
        }

        String lineAlpha = graphElement.attributeValue("lineAlpha");
        if (StringUtils.isNotEmpty(lineAlpha)) {
            graph.setLineAlpha(Double.valueOf(lineAlpha));
        }

        String lineColor = graphElement.attributeValue("lineColor");
        if (StringUtils.isNotEmpty(lineColor)) {
            graph.setLineColor(Color.valueOf(lineColor));
        }

        String lineColorField = graphElement.attributeValue("lineColorField");
        if (StringUtils.isNotEmpty("lineColorField")) {
            graph.setLineColorField(lineColorField);
        }

        String lineThickness = graphElement.attributeValue("lineThickness");
        if (StringUtils.isNotEmpty(lineThickness)) {
            graph.setLineThickness(Integer.valueOf(lineThickness));
        }

        String lowField = graphElement.attributeValue("lowField");
        if (StringUtils.isNotEmpty(lowField)) {
            graph.setLowField(lowField);
        }

        String markerType = graphElement.attributeValue("markerType");
        if (StringUtils.isNotEmpty(markerType)) {
            graph.setMarkerType(MarkerType.valueOf(markerType));
        }

        String maxBulletSize = graphElement.attributeValue("maxBulletSize");
        if (StringUtils.isNotEmpty(maxBulletSize)) {
            graph.setMaxBulletSize(Integer.valueOf(maxBulletSize));
        }

        String minBulletSize = graphElement.attributeValue("minBulletSize");
        if (StringUtils.isNotEmpty(minBulletSize)) {
            graph.setMinBulletSize(Integer.valueOf(minBulletSize));
        }

        String minDistance = graphElement.attributeValue("minDistance");
        if (StringUtils.isNotEmpty(minDistance)) {
            graph.setMinDistance(Integer.valueOf(minDistance));
        }

        String negativeBase = graphElement.attributeValue("negativeBase");
        if (StringUtils.isNotEmpty(negativeBase)) {
            graph.setNegativeBase(Double.valueOf(negativeBase));
        }

        String negativeFillAlphas = graphElement.attributeValue("negativeFillAlphas");
        if (StringUtils.isNotEmpty(negativeFillAlphas)) {
            graph.setNegativeFillAlphas(Double.valueOf(negativeFillAlphas));
        }

        String negativeFillColors = graphElement.attributeValue("negativeFillColors");
        if (StringUtils.isNotEmpty(negativeFillColors)) {
            graph.setNegativeFillColors(Color.valueOf(negativeFillColors));
        }

        String negativeLineAlpha = graphElement.attributeValue("negativeLineAlpha");
        if (StringUtils.isNotEmpty(negativeLineAlpha)) {
            graph.setNegativeLineAlpha(Double.valueOf(negativeLineAlpha));
        }

        String negativeLineColor = graphElement.attributeValue("negativeLineColor");
        if (StringUtils.isNotEmpty(negativeLineColor)) {
            graph.setNegativeLineColor(Color.valueOf(negativeLineColor));
        }

        String newStack = graphElement.attributeValue("newStack");
        if (StringUtils.isNotEmpty(newStack)) {
            graph.setNewStack(Boolean.valueOf(newStack));
        }

        String noStepRisers = graphElement.attributeValue("noStepRisers");
        if (StringUtils.isNotEmpty(noStepRisers)) {
            graph.setNoStepRisers(Boolean.valueOf(noStepRisers));
        }

        String openField = graphElement.attributeValue("openField");
        if (StringUtils.isNotEmpty(openField)) {
            graph.setOpenField(openField);
        }

        Element patternElement = graphElement.element("pattern");
        if (patternElement != null) {
            graph.setPattern(loadPattern(patternElement));
        }

        String patternField = graphElement.attributeValue("patternField");
        if (StringUtils.isNotEmpty(patternField)) {
            graph.setPatternField(patternField);
        }

        String periodSpan = graphElement.attributeValue("periodSpan");
        if (StringUtils.isNotEmpty(periodSpan)) {
            graph.setPeriodSpan(Integer.valueOf(periodSpan));
        }

        String pointPosition = graphElement.attributeValue("pointPosition");
        if (StringUtils.isNotEmpty(pointPosition)) {
            graph.setPointPosition(PointPosition.valueOf(pointPosition));
        }

        String precision = graphElement.attributeValue("precision");
        if (StringUtils.isNotEmpty(precision)) {
            graph.setPrecision(Integer.valueOf(precision));
        }

        String proCandlesticks = graphElement.attributeValue("proCandlesticks");
        if (StringUtils.isNotEmpty(proCandlesticks)) {
            graph.setProCandlesticks(Boolean.valueOf(proCandlesticks));
        }

        String showAllValueLabels = graphElement.attributeValue("showAllValueLabels");
        if (StringUtils.isNotEmpty(showAllValueLabels)) {
            graph.setShowAllValueLabels(Boolean.valueOf(showAllValueLabels));
        }

        String showBalloon = graphElement.attributeValue("showBalloon");
        if (StringUtils.isNotEmpty(showBalloon)) {
            graph.setShowBalloon(Boolean.valueOf(showBalloon));
        }

        String showBalloonAt = graphElement.attributeValue("showBalloonAt");
        if (StringUtils.isNotEmpty(showBalloonAt)) {
            graph.setShowBalloonAt(ShowPositionOnCandle.valueOf(showBalloonAt));
        }

        String showBulletsAt = graphElement.attributeValue("showBulletsAt");
        if (StringUtils.isNotEmpty(showBulletsAt)) {
            graph.setShowBulletsAt(ShowPositionOnCandle.valueOf(showBulletsAt));
        }

        String showHandOnHover = graphElement.attributeValue("showHandOnHover");
        if (StringUtils.isNotEmpty(showHandOnHover)) {
            graph.setShowHandOnHover(Boolean.valueOf(showHandOnHover));
        }

        String showOnAxis = graphElement.attributeValue("showOnAxis");
        if (StringUtils.isNotEmpty(showOnAxis)) {
            graph.setShowOnAxis(Boolean.valueOf(showOnAxis));
        }

        String stackable = graphElement.attributeValue("stackable");
        if (StringUtils.isNotEmpty(stackable)) {
            graph.setStackable(Boolean.valueOf(stackable));
        }

        String stepDirection = graphElement.attributeValue("stepDirection");
        if (StringUtils.isNotEmpty(stepDirection)) {
            graph.setStepDirection(StepDirection.valueOf(stepDirection));
        }

        String switchable = graphElement.attributeValue("switchable");
        if (StringUtils.isNotEmpty(switchable)) {
            graph.setSwitchable(Boolean.valueOf(switchable));
        }

        String tabIndex = graphElement.attributeValue("tabIndex");
        if (StringUtils.isNotEmpty(tabIndex)) {
            graph.setTabIndex(Integer.valueOf(tabIndex));
        }

        String title = graphElement.attributeValue("title");
        if (StringUtils.isNotEmpty(title)) {
            graph.setTitle(loadResourceString(title));
        }

        String topRadius = graphElement.attributeValue("topRadius");
        if (StringUtils.isNotEmpty(topRadius)) {
            graph.setTopRadius(Integer.valueOf(topRadius));
        }

        String type = graphElement.attributeValue("type");
        if (StringUtils.isNotEmpty(type)) {
            graph.setType(GraphType.valueOf(type));
        }

        String urlField = graphElement.attributeValue("urlField");
        if (StringUtils.isNotEmpty(urlField)) {
            graph.setUrlField(urlField);
        }

        String urlTarget = graphElement.attributeValue("urlTarget");
        if (StringUtils.isNotEmpty(urlTarget)) {
            graph.setUrlTarget(urlTarget);
        }

        String useLineColorForBulletBorder = graphElement.attributeValue("useLineColorForBulletBorder");
        if (StringUtils.isNotEmpty(useLineColorForBulletBorder)) {
            graph.setUseLineColorForBulletBorder(Boolean.valueOf(useLineColorForBulletBorder));
        }

        String useNegativeColorIfDown = graphElement.attributeValue("useNegativeColorIfDown");
        if (StringUtils.isNotEmpty(useNegativeColorIfDown)) {
            graph.setUseNegativeColorIfDown(Boolean.valueOf(useNegativeColorIfDown));
        }

        String valueAxis = graphElement.attributeValue("valueAxis");
        if (StringUtils.isNotEmpty(valueAxis)) {
            graph.setValueAxis(valueAxis);
        }

        String valueField = graphElement.attributeValue("valueField");
        if (StringUtils.isNotEmpty(valueField)) {
            graph.setValueField(valueField);
        }

        String visibleInLegend = graphElement.attributeValue("visibleInLegend");
        if (StringUtils.isNotEmpty(visibleInLegend)) {
            graph.setVisibleInLegend(Boolean.valueOf(visibleInLegend));
        }

        String xAxis = graphElement.attributeValue("xAxis");
        if (StringUtils.isNotEmpty(xAxis)) {
            graph.setXAxis(xAxis);
        }

        String xField = graphElement.attributeValue("xField");
        if (StringUtils.isNotEmpty(xField)) {
            graph.setXField(xField);
        }

        String yAxis = graphElement.attributeValue("yAxis");
        if (StringUtils.isNotEmpty(yAxis)) {
            graph.setYAxis(yAxis);
        }

        String yField = graphElement.attributeValue("yField");
        if (StringUtils.isNotEmpty(yField)) {
            graph.setYField(yField);
        }
    }

    protected Pattern loadPattern(Element element) {
        Pattern pattern = new Pattern();

        String url = element.attributeValue("url");
        if (StringUtils.isNotEmpty(url)) {
            pattern.setUrl(url);
        }

        String width = element.attributeValue("width");
        if (StringUtils.isNotEmpty(width)) {
            pattern.setWidth(Integer.parseInt(width));
        }

        String height = element.attributeValue("height");
        if (StringUtils.isNotEmpty(height)) {
            pattern.setHeight(Integer.parseInt(height));
        }

        return pattern;
    }
}