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

    private String containerId;

    private String chartKey;

    public GanttChartAPI(String id, String containerId) {
        this.chartKey = id + "_api";
        this.containerId = containerId;
    }

    public void createChartControl() {
        newInstance(chartKey, containerId);
    }

    public static native void onReady(Runnable r) /*-{
        if (!$wnd.ganttChartHelper) {
            var id = $wnd.setInterval(function () {
                if ($wnd.ganttChartHelper) {
                    $wnd.clearInterval(id);
                    @com.haulmont.charts.toolkit.gwt.client.charts.jsgantt.GanttChartAPI::execRunnable(Ljava/lang/Runnable;)(r);
                }
            }, 100);
        } else {
            @com.haulmont.charts.toolkit.gwt.client.charts.jsgantt.GanttChartAPI::execRunnable(Ljava/lang/Runnable;)(r);
        }
    }-*/;

    private static void execRunnable(Runnable r) {
        if (r != null) {
            try {
                r.run();
            } catch (Throwable e) {
                VConsole.log(e.toString());
            }
        }
    }

    private static native void newInstance(String chartKey, String containerId)/*-{

        $wnd.jQuery(document).ready(function() {
            alert('Insert!');

            // Use JSGantt as package name
            var JSGantt = $wnd.JSGantt;

            var containerDiv = $wnd.jQuery('#' + containerId);

            // todo fix Global variable usage
            $wnd['g'] = new JSGantt.GanttChart('g', containerDiv, 'day');
            var g = $wnd['g'];

            if (g) {
                g.setShowRes(1); // Show/Hide Responsible (0/1)
                g.setShowDur(1); // Show/Hide Duration (0/1)
                g.setShowComp(1); // Show/Hide % Complete(0/1)
                g.setCaptionType('Resource');  // Set to Show Caption

                g.AddTaskItem(new JSGantt.TaskItem(1, 'Define Chart API', '', '', 'ff0000', 'http://help.com', 0, 'Brian', 0, 1, 0, 1));
                g.AddTaskItem(new JSGantt.TaskItem(11, 'Chart Object', '2/20/2008', '2/20/2008', 'ff00ff', 'http://www.yahoo.com', 1, 'Shlomy', 100, 0, 1, 1));
                g.AddTaskItem(new JSGantt.TaskItem(12, 'Task Objects', '', '', '00ff00', '', 0, 'Shlomy', 40, 1, 1, 1));
                g.AddTaskItem(new JSGantt.TaskItem(121, 'Constructor Proc', '2/21/2008', '3/9/2008', '00ffff', 'http://www.yahoo.com', 0, 'Brian T.', 60, 0, 12, 1));
                g.AddTaskItem(new JSGantt.TaskItem(122, 'Task Variables', '3/6/2008', '3/11/2008', 'ff0000', 'http://help.com', 0, '', 60, 0, 12, 1, 121));
                g.AddTaskItem(new JSGantt.TaskItem(123, 'Task Functions', '3/9/2008', '3/29/2008', 'ff0000', 'http://help.com', 0, 'Anyone', 60, 0, 12, 1, 0, 'This is another caption'));
                g.AddTaskItem(new JSGantt.TaskItem(2, 'Create HTML Shell', '3/24/2008', '3/25/2008', 'ffff00', 'http://help.com', 0, 'Brian', 20, 0, 0, 1, 122));
                g.AddTaskItem(new JSGantt.TaskItem(3, 'Code Javascript', '', '', 'ff0000', 'http://help.com', 0, 'Brian', 0, 1, 0, 1));
                g.AddTaskItem(new JSGantt.TaskItem(31, 'Define Variables', '2/25/2008', '3/17/2008', 'ff00ff', 'http://help.com', 0, 'Brian', 30, 0, 3, 1, 'Caption 1'));
                g.AddTaskItem(new JSGantt.TaskItem(32, 'Calculate Chart Size', '3/15/2008', '3/24/2008', '00ff00', 'http://help.com', 0, 'Shlomy', 40, 0, 3, 1));
                g.AddTaskItem(new JSGantt.TaskItem(33, 'Draw Taks Items', '', '', '00ff00', 'http://help.com', 0, 'Someone', 40, 1, 3, 1));
                g.AddTaskItem(new JSGantt.TaskItem(332, 'Task Label Table', '3/6/2008', '3/11/2008', '0000ff', 'http://help.com', 0, 'Brian', 60, 0, 33, 1));
                g.AddTaskItem(new JSGantt.TaskItem(333, 'Task Scrolling Grid', '3/9/2008', '3/20/2008', '0000ff', 'http://help.com', 0, 'Brian', 60, 0, 33, 1));
                g.AddTaskItem(new JSGantt.TaskItem(34, 'Draw Task Bars', '', '', '990000', 'http://help.com', 0, 'Anybody', 60, 1, 3, 1));
                g.AddTaskItem(new JSGantt.TaskItem(341, 'Loop each Task', '3/26/2008', '4/11/2008', 'ff0000', 'http://help.com', 0, 'Brian', 60, 0, 34, 1, "332,333"));
                g.AddTaskItem(new JSGantt.TaskItem(342, 'Calculate Start/Stop', '4/12/2008', '5/18/2008', 'ff6666', 'http://help.com', 0, 'Brian', 60, 0, 34, 1));
                g.AddTaskItem(new JSGantt.TaskItem(343, 'Draw Task Div', '5/13/2008', '5/17/2008', 'ff0000', 'http://help.com', 0, 'Brian', 60, 0, 34, 1));
                g.AddTaskItem(new JSGantt.TaskItem(344, 'Draw Completion Div', '5/17/2008', '6/04/2008', 'ff0000', 'http://help.com', 0, 'Brian', 60, 0, 34, 1));
                g.AddTaskItem(new JSGantt.TaskItem(35, 'Make Updates', '10/17/2008', '12/04/2008', 'f600f6', 'http://help.com', 0, 'Brian', 30, 0, 3, 1));

                g.Draw();
                g.DrawDependencies();
            } else {
                alert("Chart object is not defined !");
            }
        });
    }-*/;
}