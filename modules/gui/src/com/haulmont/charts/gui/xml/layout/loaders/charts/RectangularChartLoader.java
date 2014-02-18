/*
 * Copyright (c) 2008-2014 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.xml.layout.loaders.charts;

import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.amcharts.model.charts.RectangularChart;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

/**
 * @author artamonov
 * @version $Id$
 */
public abstract class RectangularChartLoader<T extends RectangularChart> extends CoordinateChartLoader<T> {
    protected RectangularChartLoader(Context context) {
        super(context);
    }

    @Override
    protected void loadConfiguration(Element element, T chart) {
        super.loadConfiguration(element, chart);

        loadTrendLines(element, chart);
        loadCursor(element, chart);
        loadScrollbar(element, chart);

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

        String depth3D = element.attributeValue("depth3D");
        if (StringUtils.isNotEmpty(depth3D)) {
            chart.setDepth3D(Integer.valueOf(depth3D));
        }

        loadMargins(element, chart);

        String marginsUpdated = element.attributeValue("marginsUpdated");
        if (StringUtils.isNotEmpty(marginsUpdated)) {
            chart.setMarginsUpdated(Boolean.valueOf(marginsUpdated));
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

        String zoomOutText = element.attributeValue("zoomOutText");
        if (StringUtils.isNotEmpty(zoomOutText)) {
            chart.setZoomOutText(loadResourceString(zoomOutText));
        }
    }

    protected void loadCursor(Element element, T chart) {
        Element cursorElement = element.element("chartCursor");
        if (cursorElement != null) {
            Cursor cursor = new Cursor();

            String categoryBalloonFunction = cursorElement.elementText("categoryBalloonFunction");
            if (StringUtils.isNotEmpty(categoryBalloonFunction)) {
                cursor.setCategoryBalloonFunction(new JsFunction(categoryBalloonFunction));
            }

            String animationDuration = cursorElement.attributeValue("animationDuration");
            if (StringUtils.isNotEmpty(animationDuration)) {
                cursor.setAnimationDuration(Double.valueOf(animationDuration));
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
                cursor.setCategoryBalloonDateFormat(categoryBalloonDateFormat);
            }

            String categoryBalloonEnabled = cursorElement.attributeValue("categoryBalloonEnabled");
            if (StringUtils.isNotEmpty(categoryBalloonEnabled)) {
                cursor.setCategoryBalloonEnabled(Boolean.valueOf(categoryBalloonEnabled));
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

            String graphBulletSize = cursorElement.attributeValue("graphBulletSize");
            if (StringUtils.isNotEmpty(graphBulletSize)) {
                cursor.setGraphBulletSize(Double.valueOf(graphBulletSize));
            }

            String oneBalloonOnly = cursorElement.attributeValue("oneBalloonOnly");
            if (StringUtils.isNotEmpty(oneBalloonOnly)) {
                cursor.setOneBalloonOnly(Boolean.valueOf(oneBalloonOnly));
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

            String zoomable = cursorElement.attributeValue("zoomable");
            if (StringUtils.isNotEmpty(zoomable)) {
                cursor.setZoomable(Boolean.valueOf(zoomable));
            }

            chart.setChartCursor(cursor);
        }
    }

    protected void loadScrollbar(Element element, T chart) {
        Element scrollbarElement = element.element("chartScrollbar");
        if (scrollbarElement != null) {
            Scrollbar scrollbar = new Scrollbar();

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

            String dragIconHeight = scrollbarElement.attributeValue("dragIconHeight");
            if (StringUtils.isNotEmpty(dragIconHeight)) {
                scrollbar.setDragIconHeight(Integer.valueOf(dragIconHeight));
            }

            String dragIconWidth = scrollbarElement.attributeValue("dragIconWidth");
            if (StringUtils.isNotEmpty(dragIconWidth)) {
                scrollbar.setDragIconWidth(Integer.valueOf(dragIconWidth));
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

            String maximum = scrollbarElement.attributeValue("maximum");
            if (StringUtils.isNotEmpty(maximum)) {
                scrollbar.setMaximum(Double.valueOf(maximum));
            }

            String minimum = scrollbarElement.attributeValue("minimum");
            if (StringUtils.isNotEmpty(minimum)) {
                scrollbar.setMinimum(Double.valueOf(minimum));
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

            String updateOnReleaseOnly = scrollbarElement.attributeValue("updateOnReleaseOnly");
            if (StringUtils.isNotEmpty(updateOnReleaseOnly)) {
                scrollbar.setUpdateOnReleaseOnly(Boolean.valueOf(updateOnReleaseOnly));
            }

            chart.setChartScrollbar(scrollbar);
        }
    }

    protected void loadTrendLines(Element element, T chart) {
        Element trendLinesElement = element.element("trendLines");
        if (trendLinesElement != null) {
            for (Object trendLineItem : trendLinesElement.elements("trendLine")) {

                Element trendLineElement = (Element) trendLineItem;

                TrendLine trendLine = new TrendLine();

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

                String finalValue = trendLineElement.attributeValue("finalValue");
                if (StringUtils.isNotEmpty(finalValue)) {
                    trendLine.setFinalValue(Double.valueOf(finalValue));
                }

                String finalXValue = trendLineElement.attributeValue("finalXValue");
                if (StringUtils.isNotEmpty(finalXValue)) {
                    trendLine.setFinalXValue(Double.valueOf(finalXValue));
                }

                String initialCategory = trendLineElement.attributeValue("initialCategory");
                if (StringUtils.isNotEmpty(initialCategory)) {
                    trendLine.setInitialCategory(initialCategory);
                }

                String initialDate = trendLineElement.attributeValue("initialDate");
                if (StringUtils.isNotEmpty(initialDate)) {
                    trendLine.setInitialDate(loadDate(initialDate));
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