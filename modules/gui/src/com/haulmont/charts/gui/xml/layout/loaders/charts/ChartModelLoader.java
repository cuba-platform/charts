/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.amcharts.model.charts.ChartModel;
import com.haulmont.charts.gui.amcharts.model.data.MapDataItem;
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

public abstract class ChartModelLoader<T extends ChartModel, C extends Component> extends AbstractComponentLoader<C> {

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

        switch (type) {
            case "int":
                dataItem.add(name, Integer.parseInt(value));
                break;
            case "double":
                dataItem.add(name, Double.parseDouble(value));
                break;
            case "date":
                dataItem.add(name, parseDate(value));
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

    protected Date parseDate(String value) {
        SimpleDateFormat rangeDF = new SimpleDateFormat(CONFIG_DATE_FORMAT);

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
}
