/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.components.charts.RectangularChart;
import com.haulmont.charts.gui.model.JsFunction;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

public abstract class RectangularChartLoader<T extends RectangularChart> extends CoordinateChartLoader<T> {

    @Override
    protected void loadConfiguration(T chart, Element element) {
        super.loadConfiguration(chart, element);

        loadTrendLines(chart, element);
        loadCursor(chart, element);

        String angle = element.attributeValue("angle");
        if (StringUtils.isNotEmpty(angle)) {
            chart.setAngle(Integer.valueOf(angle));
        }

        String autoMarginOffset = element.attributeValue("autoMarginOffset");
        if (StringUtils.isNotEmpty(autoMarginOffset)) {
            chart.setAutoMarginOffset(Integer.valueOf(autoMarginOffset));
        }

        String autoMargins = element.attributeValue("autoMargins");
        if (StringUtils.isNotEmpty(autoMargins)) {
            chart.setAutoMargins(Boolean.valueOf(autoMargins));
        }

        Element scrollbarElement = element.element("chartScrollbar");
        if (scrollbarElement != null) {
            chart.setChartScrollbar(loadScrollbar(scrollbarElement));
        }

        String depth3D = element.attributeValue("depth3D");
        if (StringUtils.isNotEmpty(depth3D)) {
            chart.setDepth3D(Integer.valueOf(depth3D));
        }

        loadMargins(chart, element);

        String marginsUpdated = element.attributeValue("marginsUpdated");
        if (StringUtils.isNotEmpty(marginsUpdated)) {
            chart.setMarginsUpdated(Boolean.valueOf(marginsUpdated));
        }

        String maxZoomFactor = element.attributeValue("maxZoomFactor");
        if (StringUtils.isNotEmpty(maxZoomFactor)) {
            chart.setMaxZoomFactor(Integer.valueOf(maxZoomFactor));
        }

        String minMarginBottom = element.attributeValue("minMarginBottom");
        if (StringUtils.isNotEmpty(minMarginBottom)) {
            chart.setMinMarginBottom(Integer.valueOf(minMarginBottom));
        }

        String minMarginLeft = element.attributeValue("minMarginLeft");
        if (StringUtils.isNotEmpty(minMarginLeft)) {
            chart.setMinMarginLeft(Integer.valueOf(minMarginLeft));
        }

        String minMarginRight = element.attributeValue("minMarginRight");
        if (StringUtils.isNotEmpty(minMarginRight)) {
            chart.setMinMarginRight(Integer.valueOf(minMarginRight));
        }

        String minMarginTop = element.attributeValue("minMarginTop");
        if (StringUtils.isNotEmpty(minMarginTop)) {
            chart.setMinMarginTop(Integer.valueOf(minMarginTop));
        }

        String plotAreaBorderAlpha = element.attributeValue("plotAreaBorderAlpha");
        if (StringUtils.isNotEmpty(plotAreaBorderAlpha)) {
            chart.setPlotAreaBorderAlpha(Double.valueOf(plotAreaBorderAlpha));
        }

        String plotAreaBorderColor = element.attributeValue("plotAreaBorderColor");
        if (StringUtils.isNotEmpty(plotAreaBorderColor)) {
            chart.setPlotAreaBorderColor(Color.valueOf(plotAreaBorderColor));
        }

        String plotAreaFillAlphas = element.attributeValue("plotAreaFillAlphas");
        if (StringUtils.isNotEmpty(plotAreaFillAlphas)) {
            chart.setPlotAreaFillAlphas(Double.valueOf(plotAreaFillAlphas));
        }

        String plotAreaFillColors = element.attributeValue("plotAreaFillColors");
        if (StringUtils.isNotEmpty(plotAreaFillColors)) {
            chart.setPlotAreaFillColors(Color.valueOf(plotAreaFillColors));
        }

        String plotAreaGradientAngle = element.attributeValue("plotAreaGradientAngle");
        if (StringUtils.isNotEmpty(plotAreaGradientAngle)) {
            chart.setPlotAreaGradientAngle(Integer.valueOf(plotAreaGradientAngle));
        }

        String zoomOutButtonAlpha = element.attributeValue("zoomOutButtonAlpha");
        if (StringUtils.isNotEmpty(zoomOutButtonAlpha)) {
            chart.setZoomOutButtonAlpha(Double.valueOf(zoomOutButtonAlpha));
        }

        String zoomOutButtonColor = element.attributeValue("zoomOutButtonColor");
        if (StringUtils.isNotEmpty(zoomOutButtonColor)) {
            chart.setZoomOutButtonColor(Color.valueOf(zoomOutButtonColor));
        }

        String zoomOutButtonImage = element.attributeValue("zoomOutButtonImage");
        if (StringUtils.isNotEmpty(zoomOutButtonImage)) {
            chart.setZoomOutButtonImage(zoomOutButtonImage);
        }

        String zoomOutButtonImageSize = element.attributeValue("zoomOutButtonImageSize");
        if (StringUtils.isNotEmpty(zoomOutButtonImageSize)) {
            chart.setZoomOutButtonImageSize(Integer.valueOf(zoomOutButtonImageSize));
        }

        String zoomOutButtonPadding = element.attributeValue("zoomOutButtonPadding");
        if (StringUtils.isNotEmpty(zoomOutButtonPadding)) {
            chart.setZoomOutButtonPadding(Integer.valueOf(zoomOutButtonPadding));
        }

        String zoomOutButtonRollOverAlpha = element.attributeValue("zoomOutButtonRollOverAlpha");
        if (StringUtils.isNotEmpty(zoomOutButtonRollOverAlpha)) {
            chart.setZoomOutButtonRollOverAlpha(Double.valueOf(zoomOutButtonRollOverAlpha));
        }

        String zoomOutButtonTabIndex = element.attributeValue("zoomOutButtonTabIndex");
        if (StringUtils.isNotEmpty(zoomOutButtonTabIndex)) {
            chart.setZoomOutButtonTabIndex(Integer.valueOf(zoomOutButtonTabIndex));
        }

        String zoomOutText = element.attributeValue("zoomOutText");
        if (StringUtils.isNotEmpty(zoomOutText)) {
            chart.setZoomOutText(loadResourceString(zoomOutText));
        }
    }

    protected void loadCursor(T chart, Element element) {
        Element cursorElement = element.element("chartCursor");
        if (cursorElement != null) {
            Cursor cursor = new Cursor();

            String adjustment = cursorElement.attributeValue("adjustment");
            if (StringUtils.isNotEmpty(adjustment)) {
                cursor.setAdjustment(Integer.valueOf(adjustment));
            }

            String categoryBalloonFunction = cursorElement.elementText("categoryBalloonFunction");
            if (StringUtils.isNotEmpty(categoryBalloonFunction)) {
                cursor.setCategoryBalloonFunction(new JsFunction(categoryBalloonFunction));
            }

            String animationDuration = cursorElement.attributeValue("animationDuration");
            if (StringUtils.isNotEmpty(animationDuration)) {
                cursor.setAnimationDuration(Double.valueOf(animationDuration));
            }

            String avoidBalloonOverlapping = cursorElement.attributeValue("avoidBalloonOverlapping");
            if (StringUtils.isNotEmpty(avoidBalloonOverlapping)) {
                cursor.setAvoidBalloonOverlapping(Boolean.valueOf(avoidBalloonOverlapping));
            }

            String balloonPointerOrientation = cursorElement.attributeValue("balloonPointerOrientation");
            if (StringUtils.isNotEmpty(balloonPointerOrientation)) {
                cursor.setBalloonPointerOrientation(balloonPointerOrientation);
            }

            String bulletsEnabled = cursorElement.attributeValue("bulletsEnabled");
            if (StringUtils.isNotEmpty(bulletsEnabled)) {
                cursor.setBulletsEnabled(Boolean.valueOf(bulletsEnabled));
            }

            String bulletSize = cursorElement.attributeValue("bulletSize");
            if (StringUtils.isNotEmpty(bulletSize)) {
                cursor.setBulletSize(Integer.valueOf(bulletSize));
            }

            String categoryBalloonAlpha = cursorElement.attributeValue("categoryBalloonAlpha");
            if (StringUtils.isNotEmpty(categoryBalloonAlpha)) {
                cursor.setCategoryBalloonAlpha(Double.valueOf(categoryBalloonAlpha));
            }

            String categoryBalloonColor = cursorElement.attributeValue("categoryBalloonColor");
            if (StringUtils.isNotEmpty(categoryBalloonColor)) {
                cursor.setCategoryBalloonColor(Color.valueOf(categoryBalloonColor));
            }

            String categoryBalloonDateFormat = cursorElement.attributeValue("categoryBalloonDateFormat");
            if (StringUtils.isNotEmpty(categoryBalloonDateFormat)) {
                cursor.setCategoryBalloonDateFormat(loadResourceString(categoryBalloonDateFormat));
            }

            String categoryBalloonEnabled = cursorElement.attributeValue("categoryBalloonEnabled");
            if (StringUtils.isNotEmpty(categoryBalloonEnabled)) {
                cursor.setCategoryBalloonEnabled(Boolean.valueOf(categoryBalloonEnabled));
            }

            String categoryBalloonText = cursorElement.attributeValue("categoryBalloonText");
            if (StringUtils.isNotEmpty(categoryBalloonText)) {
                cursor.setCategoryBalloonText(categoryBalloonText);
            }

            String color = cursorElement.attributeValue("color");
            if (StringUtils.isNotEmpty(color)) {
                cursor.setColor(Color.valueOf(color));
            }

            String cursorAlpha = cursorElement.attributeValue("cursorAlpha");
            if (StringUtils.isNotEmpty(cursorAlpha)) {
                cursor.setCursorAlpha(Double.valueOf(cursorAlpha));
            }

            String cursorColor = cursorElement.attributeValue("cursorColor");
            if (StringUtils.isNotEmpty(cursorColor)) {
                cursor.setCursorColor(Color.valueOf(cursorColor));
            }

            String cursorPosition = cursorElement.attributeValue("cursorPosition");
            if (StringUtils.isNotEmpty(cursorPosition)) {
                cursor.setCursorPosition(CursorPosition.valueOf(cursorPosition));
            }

            String enabled = cursorElement.attributeValue("enabled");
            if (StringUtils.isNotEmpty(enabled)) {
                cursor.setEnabled(Boolean.valueOf(enabled));
            }

            String fullWidth = cursorElement.attributeValue("fullWidth");
            if (StringUtils.isNotEmpty(fullWidth)) {
                cursor.setFullWidth(Boolean.valueOf(fullWidth));
            }

            String graphBulletAlpha = cursorElement.attributeValue("graphBulletAlpha");
            if (StringUtils.isNotEmpty(graphBulletAlpha)) {
                cursor.setGraphBulletAlpha(Double.valueOf(graphBulletAlpha));
            }

            String graphBulletSize = cursorElement.attributeValue("graphBulletSize");
            if (StringUtils.isNotEmpty(graphBulletSize)) {
                cursor.setGraphBulletSize(Double.valueOf(graphBulletSize));
            }

            String oneBalloonOnly = cursorElement.attributeValue("oneBalloonOnly");
            if (StringUtils.isNotEmpty(oneBalloonOnly)) {
                cursor.setOneBalloonOnly(Boolean.valueOf(oneBalloonOnly));
            }

            String leaveAfterTouch = cursorElement.attributeValue("leaveAfterTouch");
            if (StringUtils.isNotEmpty(leaveAfterTouch)) {
                cursor.setLeaveAfterTouch(Boolean.valueOf(leaveAfterTouch));
            }

            String leaveCursor = cursorElement.attributeValue("leaveCursor");
            if (StringUtils.isNotEmpty(leaveCursor)) {
                cursor.setLeaveCursor(Boolean.valueOf(leaveCursor));
            }

            String limitToGraph = cursorElement.attributeValue("limitToGraph");
            if (StringUtils.isNotEmpty(limitToGraph)) {
                cursor.setLimitToGraph(limitToGraph);
            }

            String pan = cursorElement.attributeValue("pan");
            if (StringUtils.isNotEmpty(pan)) {
                cursor.setPan(Boolean.valueOf(pan));
            }

            String selectionAlpha = cursorElement.attributeValue("selectionAlpha");
            if (StringUtils.isNotEmpty(selectionAlpha)) {
                cursor.setCursorAlpha(Double.valueOf(selectionAlpha));
            }

            String selectWithoutZooming = cursorElement.attributeValue("selectWithoutZooming");
            if (StringUtils.isNotEmpty(selectWithoutZooming)) {
                cursor.setSelectWithoutZooming(Boolean.valueOf(selectWithoutZooming));
            }

            String showNextAvailable = cursorElement.attributeValue("showNextAvailable");
            if (StringUtils.isNotEmpty(showNextAvailable)) {
                cursor.setShowNextAvailable(Boolean.valueOf(showNextAvailable));
            }

            String valueBalloonsEnabled = cursorElement.attributeValue("valueBalloonsEnabled");
            if (StringUtils.isNotEmpty(valueBalloonsEnabled)) {
                cursor.setValueBalloonsEnabled(Boolean.valueOf(valueBalloonsEnabled));
            }

            String valueLineAlpha = cursorElement.attributeValue("valueLineAlpha");
            if (StringUtils.isNotEmpty(valueLineAlpha)) {
                cursor.setValueLineAlpha(Double.valueOf(valueLineAlpha));
            }

            String valueLineAxis = cursorElement.attributeValue("valueLineAxis");
            if (StringUtils.isNotEmpty(valueLineAxis)) {
                cursor.setValueLineAxis(valueLineAxis);
            }

            String valueLineBalloonEnabled = cursorElement.attributeValue("valueLineBalloonEnabled");
            if (StringUtils.isNotEmpty(valueLineBalloonEnabled)) {
                cursor.setValueLineBalloonEnabled(Boolean.valueOf(valueLineBalloonEnabled));
            }

            String valueLineEnabled = cursorElement.attributeValue("valueLineEnabled");
            if (StringUtils.isNotEmpty(valueLineEnabled)) {
                cursor.setValueLineEnabled(Boolean.valueOf(valueLineEnabled));
            }

            String valueZoomable = cursorElement.attributeValue("valueZoomable");
            if (StringUtils.isNotEmpty(valueZoomable)) {
                cursor.setValueZoomable(Boolean.valueOf(valueZoomable));
            }

            String zoomable = cursorElement.attributeValue("zoomable");
            if (StringUtils.isNotEmpty(zoomable)) {
                cursor.setZoomable(Boolean.valueOf(zoomable));
            }

            String zooming = cursorElement.attributeValue("zooming");
            if (StringUtils.isNotEmpty(zooming)) {
                cursor.setZooming(Boolean.valueOf(zooming));
            }

            chart.setChartCursor(cursor);
        }
    }

    protected Scrollbar loadScrollbar(Element scrollbarElement) {
        Scrollbar scrollbar = new Scrollbar();

        String accessibleLabel = scrollbarElement.attributeValue("accessibleLabel");
        if (StringUtils.isNotEmpty(accessibleLabel)) {
            scrollbar.setAccessibleLabel(loadResourceString(accessibleLabel));
        }

        String autoGridCount = scrollbarElement.attributeValue("autoGridCount");
        if (StringUtils.isNotEmpty(autoGridCount)) {
            scrollbar.setAutoGridCount(Boolean.valueOf(autoGridCount));
        }

        String backgroundAlpha = scrollbarElement.attributeValue("backgroundAlpha");
        if (StringUtils.isNotEmpty(backgroundAlpha)) {
            scrollbar.setBackgroundAlpha(Double.valueOf(backgroundAlpha));
        }

        String backgroundColor = scrollbarElement.attributeValue("backgroundColor");
        if (StringUtils.isNotEmpty(backgroundColor)) {
            scrollbar.setBackgroundColor(Color.valueOf(backgroundColor));
        }

        String color = scrollbarElement.attributeValue("color");
        if (StringUtils.isNotEmpty(color)) {
            scrollbar.setColor(Color.valueOf(color));
        }

        String dragCursorDown = scrollbarElement.attributeValue("dragCursorDown");
        if (StringUtils.isNotEmpty(dragCursorDown)) {
            scrollbar.setDragCursorDown(dragCursorDown);
        }

        String dragCursorHover = scrollbarElement.attributeValue("dragCursorHover");
        if (StringUtils.isNotEmpty(dragCursorHover)) {
            scrollbar.setDragCursorHover(dragCursorHover);
        }

        String dragIcon = scrollbarElement.attributeValue("dragIcon");
        if (StringUtils.isNotEmpty(dragIcon)) {
            scrollbar.setDragIcon(dragIcon);
        }

        String dragIconHeight = scrollbarElement.attributeValue("dragIconHeight");
        if (StringUtils.isNotEmpty(dragIconHeight)) {
            scrollbar.setDragIconHeight(Integer.valueOf(dragIconHeight));
        }

        String dragIconWidth = scrollbarElement.attributeValue("dragIconWidth");
        if (StringUtils.isNotEmpty(dragIconWidth)) {
            scrollbar.setDragIconWidth(Integer.valueOf(dragIconWidth));
        }

        String enabled = scrollbarElement.attributeValue("enabled");
        if (StringUtils.isNotEmpty(enabled)) {
            scrollbar.setEnabled(Boolean.valueOf(enabled));
        }

        String graph = scrollbarElement.attributeValue("graph");
        if (StringUtils.isNotEmpty(graph)) {
            scrollbar.setGraph(graph);
        }

        String graphFillAlpha = scrollbarElement.attributeValue("graphFillAlpha");
        if (StringUtils.isNotEmpty(graphFillAlpha)) {
            scrollbar.setGraphFillAlpha(Double.valueOf(graphFillAlpha));
        }

        String graphFillColor = scrollbarElement.attributeValue("graphFillColor");
        if (StringUtils.isNotEmpty(graphFillColor)) {
            scrollbar.setGraphFillColor(Color.valueOf(graphFillColor));
        }

        String graphLineAlpha = scrollbarElement.attributeValue("graphLineAlpha");
        if (StringUtils.isNotEmpty(graphLineAlpha)) {
            scrollbar.setGraphLineAlpha(Double.valueOf(graphLineAlpha));
        }

        String graphLineColor = scrollbarElement.attributeValue("graphLineColor");
        if (StringUtils.isNotEmpty(graphLineColor)) {
            scrollbar.setGraphLineColor(Color.valueOf(graphLineColor));
        }

        String graphType = scrollbarElement.attributeValue("graphType");
        if (StringUtils.isNotEmpty(graphType)) {
            scrollbar.setGraphType(GraphType.valueOf(graphType));
        }

        String gridAlpha = scrollbarElement.attributeValue("gridAlpha");
        if (StringUtils.isNotEmpty(gridAlpha)) {
            scrollbar.setGridAlpha(Double.valueOf(gridAlpha));
        }

        String gridColor = scrollbarElement.attributeValue("gridColor");
        if (StringUtils.isNotEmpty(gridColor)) {
            scrollbar.setGridColor(Color.valueOf(gridColor));
        }

        String gridCount = scrollbarElement.attributeValue("gridCount");
        if (StringUtils.isNotEmpty(gridCount)) {
            scrollbar.setGridCount(Integer.valueOf(gridCount));
        }

        String hideResizeGrips = scrollbarElement.attributeValue("hideResizeGrips");
        if (StringUtils.isNotEmpty(hideResizeGrips)) {
            scrollbar.setHideResizeGrips(Boolean.valueOf(hideResizeGrips));
        }

        String ignoreCustomColors = scrollbarElement.attributeValue("ignoreCustomColors");
        if (StringUtils.isNotEmpty(ignoreCustomColors)) {
            scrollbar.setIgnoreCustomColors(Boolean.valueOf(ignoreCustomColors));
        }

        String maximum = scrollbarElement.attributeValue("maximum");
        if (StringUtils.isNotEmpty(maximum)) {
            scrollbar.setMaximum(Double.valueOf(maximum));
        }

        String minimum = scrollbarElement.attributeValue("minimum");
        if (StringUtils.isNotEmpty(minimum)) {
            scrollbar.setMinimum(Double.valueOf(minimum));
        }

        String offset = scrollbarElement.attributeValue("offset");
        if (StringUtils.isNotEmpty(offset)) {
            scrollbar.setOffset(Integer.valueOf(offset));
        }

        String oppositeAxis = scrollbarElement.attributeValue("oppositeAxis");
        if (StringUtils.isNotEmpty(oppositeAxis)) {
            scrollbar.setOppositeAxis(Boolean.valueOf(oppositeAxis));
        }

        String resizeEnabled = scrollbarElement.attributeValue("resizeEnabled");
        if (StringUtils.isNotEmpty(resizeEnabled)) {
            scrollbar.setResizeEnabled(Boolean.valueOf(resizeEnabled));
        }

        String scrollbarHeight = scrollbarElement.attributeValue("scrollbarHeight");
        if (StringUtils.isNotEmpty(scrollbarHeight)) {
            scrollbar.setScrollbarHeight(Integer.valueOf(scrollbarHeight));
        }

        String scrollDuration = scrollbarElement.attributeValue("scrollDuration");
        if (StringUtils.isNotEmpty(scrollDuration)) {
            scrollbar.setScrollDuration(Double.valueOf(scrollDuration));
        }

        String selectedBackgroundAlpha = scrollbarElement.attributeValue("selectedBackgroundAlpha");
        if (StringUtils.isNotEmpty(selectedBackgroundAlpha)) {
            scrollbar.setSelectedBackgroundAlpha(Double.valueOf(selectedBackgroundAlpha));
        }

        String selectedBackgroundColor = scrollbarElement.attributeValue("selectedBackgroundColor");
        if (StringUtils.isNotEmpty(selectedBackgroundColor)) {
            scrollbar.setSelectedBackgroundColor(Color.valueOf(selectedBackgroundColor));
        }

        String selectedGraphFillAlpha = scrollbarElement.attributeValue("selectedGraphFillAlpha");
        if (StringUtils.isNotEmpty(selectedGraphFillAlpha)) {
            scrollbar.setSelectedGraphFillAlpha(Double.valueOf(selectedGraphFillAlpha));
        }

        String selectedGraphFillColor = scrollbarElement.attributeValue("selectedGraphFillColor");
        if (StringUtils.isNotEmpty(selectedGraphFillColor)) {
            scrollbar.setSelectedGraphFillColor(Color.valueOf(selectedGraphFillColor));
        }

        String selectedGraphLineAlpha = scrollbarElement.attributeValue("selectedGraphLineAlpha");
        if (StringUtils.isNotEmpty(selectedGraphLineAlpha)) {
            scrollbar.setSelectedGraphLineAlpha(Double.valueOf(selectedGraphLineAlpha));
        }

        String selectedGraphLineColor = scrollbarElement.attributeValue("selectedGraphLineColor");
        if (StringUtils.isNotEmpty(selectedGraphLineColor)) {
            scrollbar.setSelectedGraphLineColor(Color.valueOf(selectedGraphLineColor));
        }

        String tabIndex = scrollbarElement.attributeValue("tabIndex");
        if (StringUtils.isNotEmpty(tabIndex)) {
            scrollbar.setTabIndex(Integer.valueOf(tabIndex));
        }

        String updateOnReleaseOnly = scrollbarElement.attributeValue("updateOnReleaseOnly");
        if (StringUtils.isNotEmpty(updateOnReleaseOnly)) {
            scrollbar.setUpdateOnReleaseOnly(Boolean.valueOf(updateOnReleaseOnly));
        }

        return scrollbar;
    }

    protected void loadTrendLines(T chart, Element element) {
        Element trendLinesElement = element.element("trendLines");
        if (trendLinesElement != null) {
            for (Object trendLineItem : trendLinesElement.elements("trendLine")) {

                Element trendLineElement = (Element) trendLineItem;

                TrendLine trendLine = new TrendLine();

                String balloonText = trendLineElement.attributeValue("balloonText");
                if (StringUtils.isNotEmpty(balloonText)) {
                    trendLine.setBalloonText(balloonText);
                }

                String dashLength = trendLineElement.attributeValue("dashLength");
                if (StringUtils.isNotEmpty(dashLength)) {
                    trendLine.setDashLength(Integer.valueOf(dashLength));
                }

                String finalCategory = trendLineElement.attributeValue("finalCategory");
                if (StringUtils.isNotEmpty(finalCategory)) {
                    trendLine.setFinalCategory(finalCategory);
                }

                String finalDate = trendLineElement.attributeValue("finalDate");
                if (StringUtils.isNotEmpty(finalDate)) {
                    trendLine.setFinalDate(loadDate(finalDate));
                }

                Element finalImageElement = trendLineElement.element("finalImage");
                if (finalImageElement != null) {
                    trendLine.setFinalImage(loadImage(finalImageElement));
                }

                String finalValue = trendLineElement.attributeValue("finalValue");
                if (StringUtils.isNotEmpty(finalValue)) {
                    trendLine.setFinalValue(Double.valueOf(finalValue));
                }

                String finalXValue = trendLineElement.attributeValue("finalXValue");
                if (StringUtils.isNotEmpty(finalXValue)) {
                    trendLine.setFinalXValue(Double.valueOf(finalXValue));
                }

                String id = trendLineElement.attributeValue("id");
                if (StringUtils.isNotEmpty(id)) {
                    trendLine.setId(id);
                }

                String initialCategory = trendLineElement.attributeValue("initialCategory");
                if (StringUtils.isNotEmpty(initialCategory)) {
                    trendLine.setInitialCategory(initialCategory);
                }

                String initialDate = trendLineElement.attributeValue("initialDate");
                if (StringUtils.isNotEmpty(initialDate)) {
                    trendLine.setInitialDate(loadDate(initialDate));
                }

                Element initialImageElement = trendLineElement.element("initialImage");
                if (initialImageElement != null) {
                    trendLine.setFinalImage(loadImage(initialImageElement));
                }

                String initialValue = trendLineElement.attributeValue("initialValue");
                if (StringUtils.isNotEmpty(initialValue)) {
                    trendLine.setInitialValue(Double.valueOf(initialValue));
                }

                String initialXValue = trendLineElement.attributeValue("initialXValue");
                if (StringUtils.isNotEmpty(initialXValue)) {
                    trendLine.setInitialXValue(Double.valueOf(initialXValue));
                }

                String isProtected = trendLineElement.attributeValue("isProtected");
                if (StringUtils.isNotEmpty(isProtected)) {
                    trendLine.setProtected(Boolean.valueOf(isProtected));
                }

                String lineAlpha = trendLineElement.attributeValue("lineAlpha");
                if (StringUtils.isNotEmpty(lineAlpha)) {
                    trendLine.setLineAlpha(Double.valueOf(lineAlpha));
                }

                String lineColor = trendLineElement.attributeValue("lineColor");
                if (StringUtils.isNotEmpty(lineColor)) {
                    trendLine.setLineColor(Color.valueOf(lineColor));
                }

                String lineThickness = trendLineElement.attributeValue("lineThickness");
                if (StringUtils.isNotEmpty(lineThickness)) {
                    trendLine.setLineThickness(Integer.valueOf(lineThickness));
                }

                String valueAxis = trendLineElement.attributeValue("valueAxis");
                if (StringUtils.isNotEmpty(valueAxis)) {
                    trendLine.setValueAxis(valueAxis);
                }

                String valueAxisX = trendLineElement.attributeValue("valueAxisX");
                if (StringUtils.isNotEmpty(valueAxisX)) {
                    trendLine.setValueAxisX(valueAxisX);
                }

                chart.addTrendLines(trendLine);
            }
        }
    }
}