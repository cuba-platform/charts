/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.toolkit.gwt.client.charts.jsgantt;

import com.vaadin.terminal.gwt.client.VConsole;

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

    public static native void onReady(Runnable r) /*-{
        if (!$wnd.JSGantt) {
            var id = $wnd.setInterval(function () {
                if ($wnd.JSGantt) {
                    $wnd.clearInterval(id);
                    @com.haulmont.charts.toolkit.gwt.client.charts.jsgantt.GanttChartAPI::execRunnable(Ljava/lang/Runnable;)(r);
                }
            }, 100);
        } else {
            @com.haulmont.charts.toolkit.gwt.client.charts.jsgantt.GanttChartAPI::execRunnable(Ljava/lang/Runnable;)(r);
        }
    }-*/;

    public interface ClickHandler {
        void onClick(int itemId);
    }

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

    private static native void setFormat(String instanceKey, String format) /*-{
        var JSGantt = $wnd.JSGantt;
        var ganttChart = JSGantt.instances[instanceKey];
        ganttChart.setFormat(format);
    }-*/;

    public void setShowResource(boolean showResponsible) {
        setShowComplete(chartKey, showResponsible);
    }

    private static native void setShowResponsible(String instanceKey, boolean showResponsible) /*-{
        var JSGantt = $wnd.JSGantt;
        var ganttChart = JSGantt.instances[instanceKey];
        ganttChart.setShowRes(showResponsible);
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
     * @param color           Color
     * @param dependsOn       Dependencies
     * @param captionType     Caption mode
     * @param isMilestone     If milestone
     * @param isOpen          If open
     * @param isGroup         If group
     */
    public void addTask(int id, int parentId,
                        String title, String resource, int completePercent,
                        String startTs, String endTs, String color,
                        String dependsOn, String captionType,
                        boolean isMilestone, boolean isOpen, boolean isGroup) {
        addTask(chartKey, id, parentId,
                title, resource, completePercent,
                startTs, endTs, color,
                dependsOn, captionType, isMilestone, isOpen, isGroup);
    }

    private static native void addTask(String instanceKey, int id, int parentId,
                                       String title, String resource, int completePercent,
                                       String startTs, String endTs, String color,
                                       String dependsOn, String captionType,
                                       boolean isMilestone, boolean isOpen, boolean isGroup) /*-{
        var JSGantt = $wnd.JSGantt;
        var ganttChart = JSGantt.instances[instanceKey];
        ganttChart.AddTaskItem(new JSGantt.TaskItem(ganttChart, id, title, startTs, endTs, color,
                isMilestone, resource, completePercent, isGroup, parentId, isOpen, dependsOn, captionType));
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
                    chartApi.@com.haulmont.charts.toolkit.gwt.client.charts.jsgantt.GanttChartAPI::handleClick(I)(taskId);
                });

        if (g) {
            g.setShowRes(0); // Show/Hide Responsible (0/1)
            g.setShowDur(0); // Show/Hide Duration (0/1)
            g.setShowComp(0); // Show/Hide % Complete(0/1)
            g.setCaptionType('Resource');  // Set to Show Caption

            return g.getInstanceName();
        } else {
            alert("Chart object is not defined !");
        }

        return "";
    }-*/;
}