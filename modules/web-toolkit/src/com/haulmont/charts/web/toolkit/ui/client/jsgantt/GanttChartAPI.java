/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.jsgantt;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.vaadin.client.VConsole;

import java.util.Date;
import java.util.logging.Level;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
public class GanttChartAPI {

    private String chartKey;
    private ClickHandler clickHandler;

    public GanttChartAPI(String containerId, ClickHandler clickHandler) {
        this.chartKey = newInstance(containerId);
        this.clickHandler = clickHandler;
    }

    public interface ClickHandler {
        void onClick(int itemId);
    }

    public static native void onReady(Runnable r) /*-{
        if (!$wnd.JSGantt) {
            var id = $wnd.setInterval(function () {
                if ($wnd.JSGantt) {
                    $wnd.clearInterval(id);
                    @com.haulmont.charts.web.toolkit.ui.client.jsgantt.GanttChartAPI::execRunnable(Ljava/lang/Runnable;)(r);
                }
            }, 100);
        } else {
            @com.haulmont.charts.web.toolkit.ui.client.jsgantt.GanttChartAPI::execRunnable(Ljava/lang/Runnable;)(r);
        }
    }-*/;


    public void handleClick(int itemId) {
        if (clickHandler != null)
            clickHandler.onClick(itemId);
    }

    @SuppressWarnings("unused")
    private static void execRunnable(Runnable r) {
        if (r != null) {
            try {
                r.run();
            } catch (Throwable e) {
                VConsole.log(e.toString());
            }
        }
    }

    public void setMonthNames(String[] monthNames) {
        setMonthNames(chartKey, monthNames);
    }

    public String formatDate(double date, String format) {
        if (Double.isNaN(date))
            return "";
        else
            return DateTimeFormat.getFormat(format).format(new Date((long) date));
    }

    private static native void setMonthNames(String instanceKey, String[] monthNames)/*-{
        var JSGantt = $wnd.JSGantt;
        var ganttChart = JSGantt.instances[instanceKey];
        ganttChart.setLocaleMonths(monthNames);
    }-*/;

    public void setLocale(GanttMessagePack messagePack) {
        setLocale(chartKey, messagePack);
    }

    private static native void setLocale(String instanceKey, GanttMessagePack messagePack)/*-{
        var JSGantt = $wnd.JSGantt;
        var ganttChart = JSGantt.instances[instanceKey];
        ganttChart.setLocaleMessages(messagePack);
    }-*/;

    public void setShowStartDate(boolean showStartDate) {
        setShowStartDate(chartKey, showStartDate);
    }

    private static native void setShowStartDate(String instanceKey, boolean showStartDate) /*-{
        var JSGantt = $wnd.JSGantt;
        var ganttChart = JSGantt.instances[instanceKey];
        ganttChart.setShowStartDate(showStartDate);
    }-*/;


    public void setShowEndDate(boolean showEndDate) {
        setShowEndDate(chartKey, showEndDate);
    }

    private static native void setShowEndDate(String instanceKey, boolean showEndDate) /*-{
        var JSGantt = $wnd.JSGantt;
        var ganttChart = JSGantt.instances[instanceKey];
        ganttChart.setShowEndDate(showEndDate);
    }-*/;

    public void setShowCompete(boolean showCompete) {
        setShowComplete(chartKey, showCompete);
    }

    private static native void setShowComplete(String instanceKey, boolean showComplete) /*-{
        var JSGantt = $wnd.JSGantt;
        var ganttChart = JSGantt.instances[instanceKey];
        ganttChart.setShowComp(showComplete);
    }-*/;

    public void setShowDuration(boolean showDuration) {
        setShowComplete(chartKey, showDuration);
    }

    private static native void setShowDuration(String instanceKey, boolean showDuration) /*-{
        var JSGantt = $wnd.JSGantt;
        var ganttChart = JSGantt.instances[instanceKey];
        ganttChart.setShowDur(showDuration);
    }-*/;

    public void setFormat(String format) {
        setFormat(chartKey, format);
    }

    public void setSize(int width, int height) {
        setSize(chartKey, width, height);
    }

    private static native void setFormat(String instanceKey, String format) /*-{
        var JSGantt = $wnd.JSGantt;
        var ganttChart = JSGantt.instances[instanceKey];
        ganttChart.setFormat(format);
    }-*/;

    public void setDateFormat(String dateFormat) {
        setDateFormat(chartKey, dateFormat);
    }

    private static native void setDateFormat(String instanceKey, String dateFormat) /*-{
        var JSGantt = $wnd.JSGantt;
        var ganttChart = JSGantt.instances[instanceKey];
        ganttChart.setDateDisplayFormat(dateFormat);
    }-*/;

    private static native void setSize(String instanceKey, int width, int height) /*-{
        var JSGantt = $wnd.JSGantt;
        var ganttChart = JSGantt.instances[instanceKey];
        ganttChart.setSize(width, height);
    }-*/;


    public void setShowResource(boolean showResource) {
        setShowResource(chartKey, showResource);
    }

    private static native void setShowResource(String instanceKey, boolean showResource) /*-{
        var JSGantt = $wnd.JSGantt;
        var ganttChart = JSGantt.instances[instanceKey];
        ganttChart.setShowRes(showResource);
    }-*/;


    public void setShowInitiator(boolean showInitiator) {
        setShowInitiator(chartKey, showInitiator);
    }

    private static native void setShowInitiator(String instanceKey, boolean showInitiator) /*-{
        var JSGantt = $wnd.JSGantt;
        var ganttChart = JSGantt.instances[instanceKey];
        ganttChart.setShowInitiator(showInitiator);
    }-*/;

    public void repaint() {
        repaint(chartKey);
    }

    private static native void repaint(String instanceKey) /*-{
        var JSGantt = $wnd.JSGantt;
        var ganttChart = JSGantt.instances[instanceKey];
        ganttChart.Draw();
        ganttChart.DrawDependencies();
    }-*/;

    /**
     * Add new Task object to chart
     *
     * @param id              New Id
     * @param parentId        Parent Id
     * @param title           Title
     * @param resource        Resource
     * @param completePercent Complete percentage
     * @param startTs         Start timestamp
     * @param endTs           End timestamp
     * @param styleClass      Style class
     * @param dependsOn       Dependencies
     * @param captionType     Caption mode
     * @param isMilestone     If milestone
     * @param isOpen          If open
     * @param isGroup         If group
     */
    public void addTask(int id, int parentId,
                        String title, String resource, String initiator, int completePercent,
                        String startTs, String endTs, String styleClass,
                        String dependsOn, String captionType, String tooltip,
                        boolean isMilestone, boolean isOpen, boolean isGroup) {
        addTask(chartKey, id, parentId,
                title, resource, initiator, completePercent,
                startTs, endTs, styleClass,
                dependsOn, captionType, tooltip, isMilestone, isOpen, isGroup);
    }

    private static native void addTask(String instanceKey, int id, int parentId,
                                       String title, String resource, String initiator, int completePercent,
                                       String startTs, String endTs, String styleClass,
                                       String dependsOn, String captionType, String tooltip,
                                       boolean isMilestone, boolean isOpen, boolean isGroup) /*-{
        var JSGantt = $wnd.JSGantt;
        var ganttChart = JSGantt.instances[instanceKey];
        ganttChart.AddTaskItem(new JSGantt.TaskItem(ganttChart, id, title, startTs, endTs, styleClass,
                isMilestone, resource, initiator, completePercent, isGroup, parentId, isOpen, dependsOn, captionType, tooltip));
    }-*/;

    public void clearTaskPane() {
        clearTaskPane(chartKey);
    }

    public static native void clearTaskPane(String instanceKey) /*-{
        var JSGantt = $wnd.JSGantt;
        var ganttChart = JSGantt.instances[instanceKey];
        ganttChart.clearTasks();
    }-*/;

    private native String newInstance(String containerId)/*-{
        var chartApi = this;

        // Use JSGantt as package name
        var JSGantt = $wnd.JSGantt;

        var containerDiv = $wnd.jQuery('#' + containerId);

        var g = new JSGantt.GanttChart(containerDiv, 'day',
                function(task) {
                    var taskId = Number(task.getID());
                    chartApi.@com.haulmont.charts.web.toolkit.ui.client.jsgantt.GanttChartAPI::handleClick(I)(taskId);
                });

        if (g) {
            g.setShowStartDate(1); //Show Start Date
            g.setShowEndDate(1); //Show End Date
            g.setShowRes(0); // Show/Hide Responsible (0/1)
            g.setShowInitiator(0); // // Show/Hide Initiator (0/1)
            g.setShowDur(0); // Show/Hide Duration (0/1)
            g.setShowComp(0); // Show/Hide % Complete(0/1)
            g.setCaptionType('Resource');  // Set to Show Caption
            //Set format date function
            g.setDateFormatConverter(function(pDate, pFormatStr) {
                return chartApi.@com.haulmont.charts.web.toolkit.ui.client.jsgantt.GanttChartAPI::formatDate(DLjava/lang/String;)(pDate.getTime(), pFormatStr)
            });

            return g.getInstanceName();
        } else {
            alert("Chart object is not defined !");
        }

        return g.getInstanceName();
    }-*/;
}