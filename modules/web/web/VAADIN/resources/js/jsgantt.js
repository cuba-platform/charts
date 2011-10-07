/* Copyright (c) 2009, Shlomy Gantz BlueBrick Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of Shlomy Gantz or BlueBrick Inc. nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY SHLOMY GANTZ/BLUEBRICK INC. ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL SHLOMY GANTZ/BLUEBRICK INC. BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/**
 * JSGantt component is a UI control that displays gantt charts based by using CSS and HTML
 * @module    jsgantt
 * @title    JSGantt
 */

var JSGantt;
if (!JSGantt) JSGantt = {};

var vBenchTime = new Date().getTime();

/** Active chart instances */
JSGantt.instances = {
};

/**
 * Creates a task (one row) in gantt object
 * @class TaskItem
 * @namespace JSGantt
 * @constructor
 * @for JSGantt

 * @param pID {Number} Task unique numeric ID
 * @param pName {String} Task Name
 * @param pStart {Date} Task start date/time (not required for pGroup=1 )
 * @param pEnd {Date} Task end date/time, you can set the end time to 12:00 to indicate half-day (not required for pGroup=1 )
 * @param pColor {String} Task bar RGB value
 * @param pMile {Boolean} Determines whether task is a milestone (1=Yes,0=No)
 * @param pRes {String} Resource to perform the task
 * @param pComp {Number} Percent complete (Number between 0 and 100)
 * @param pGroup {Boolean}
 * @param pParent {Number} ID of the parent task
 * @param pOpen {Boolean}
 * @param pDepend {String} Comma seperated list of IDs this task depends on
 * @param pCaption {String} Caption to be used instead of default caption (Resource).
 * note : you should use setCaption("Caption") in order to display the caption
 * @return void
 */
JSGantt.TaskItem = function(pChart, pID, pName, pStart, pEnd, pColor, pMile, pRes, pComp, pGroup, pParent, pOpen, pDepend, pCaption) {

    /**
     * The name of the attribute.
     * @property vID
     * @type String
     * @default pID
     * @private
     */
    var vID = pID;

    /**
     * @property vName
     * @type String
     * @default pName
     * @private
     */
    var vName = pName;

    /**
     * @property vStart
     * @type Date
     * @default new Date()
     * @private
     */
    var vStart = new Date();

    /**
     * @property vEnd
     * @type Date
     * @default new Date()
     * @private
     */
    var vEnd = new Date();

    /**
     * @property vColor
     * @type String
     * @default pColor
     * @private
     */
    var vColor = pColor;

    /**
     * @property vMile
     * @type Boolean
     * @default pMile
     * @private
     */
    var vMile = pMile;

    /**
     * @property vRes
     * @type String
     * @default pRes
     * @private
     */
    var vRes = pRes;

    /**
     * @property vComp
     * @type Number
     * @default pComp
     * @private
     */
    var vComp = pComp;

    /**
     * @property vGroup
     * @type Boolean
     * @default pGroup
     * @private
     */
    var vGroup = pGroup;

    /**
     * @property vParent
     * @type Number
     * @default pParent
     * @private
     */
    var vParent = pParent;

    /**
     * @property vOpen
     * @type Boolean
     * @default pOpen
     * @private
     */
    var vOpen = pOpen;

    /**
     * @property vDepend
     * @type String
     * @default pDepend
     * @private
     */
    var vDepend = pDepend;

    /**
     * @property vCaption
     * @type String
     * @default pCaption
     * @private
     */
    var vCaption = pCaption;

    /**
     * @property vDuration
     * @type String
     * @default ''
     * @private
     */
    var vDuration = '';

    /**
     * @property vLevel
     * @type Number
     * @default 0
     * @private
     */
    var vLevel = 0;

    /**
     * @property vNumKid
     * @type Number
     * @default 0
     * @private
     */
    var vNumKid = 0;

    /**
     * @property vVisible
     * @type Boolean
     * @default 0
     * @private
     */
    var vVisible = 1;
    var x1, y1, x2, y2;

    if (vGroup != 1) {
        vStart = JSGantt.parseDateStr(pStart, pChart.getDateInputFormat());
        vEnd = JSGantt.parseDateStr(pEnd, pChart.getDateInputFormat());
    }

    /**
     * Returns task ID
     * @method getID
     * @return {Number}
     */
    this.getID = function() {
        return vID;
    };

    /**
     * Returns task name
     * @method getName
     * @return {String}
     */
    this.getName = function() {
        return vName;
    };

    /**
     * Returns task start date
     * @method getStart
     * @return {Date}
     */
    this.getStart = function() {
        return vStart;
    };

    /**
     * Returns task end date
     * @method getEnd
     * @return {Date}
     */
    this.getEnd = function() {
        return vEnd;
    };

    /**
     * Returns task bar color (i.e. 00FF00)
     * @method getColor
     * @return {String}
     */
    this.getColor = function() {
        return vColor;
    };

    /**
     * Returns whether task is a milestone (1=Yes,0=No)
     * @method getMile
     * @return {Boolean}
     */
    this.getMile = function() {
        return vMile;
    };

    /**
     * Returns task dependencies as list of values (i.e. 123,122)
     * @method getDepend
     * @return {String}
     */
    this.getDepend = function() {
        if (vDepend)
            return vDepend;
        else
            return null;
    };

    /**
     * Returns task caption (if it exists)
     * @method getCaption
     * @return {String}
     */
    this.getCaption = function() {
        if (vCaption) return vCaption; else return '';
    };

    /**
     * Returns task resource name as string
     * @method getResource
     * @return {String}
     */
    this.getResource = function() {
        if (vRes) return vRes; else return '&nbsp';
    };

    /**
     * Returns task completion percent as numeric value
     * @method getCompVal
     * @return {Boolean}
     */
    this.getCompVal = function() {
        if (vComp) return vComp; else return 0;
    };

    /**
     * Returns task completion percent as formatted string (##%)
     * @method getCompStr
     * @return {String}
     */
    this.getCompStr = function() {
        if (vComp) return vComp + '%'; else return '';
    };

    /**
     * Returns task duration as a fortmatted string based on the current selected format
     * @method getDuration
     * @param vFormat {String} selected format (minute,hour,day,week,month)
     * @return {String}
     */
    this.getDuration = function(vFormat) {
        var tmpPer;

        if (vMile)
            vDuration = '-';
        else if (vFormat == 'hour') {
            tmpPer = Math.ceil((this.getEnd() - this.getStart()) / ( 60 * 60 * 1000));
            if (tmpPer == 1)
                vDuration = '1 Hour';
            else
                vDuration = tmpPer + ' Hours';
        } else if (vFormat == 'minute') {
            tmpPer = Math.ceil((this.getEnd() - this.getStart()) / ( 60 * 1000));
            if (tmpPer == 1)
                vDuration = '1 Minute';
            else
                vDuration = tmpPer + ' Minutes';
        } else {
            tmpPer = Math.ceil((this.getEnd() - this.getStart()) / (24 * 60 * 60 * 1000) + 1);
            if (tmpPer == 1)  vDuration = '1 Day';
            else             vDuration = tmpPer + ' Days';
        }

        return ( vDuration );
    };

    /**
     * Returns task parent ID
     * @method getParent
     * @return {Number}
     */
    this.getParent = function() {
        return vParent;
    };

    /**
     * Returns whether task is a group (1=Yes,0=No)
     * @method getGroup
     * @return {Number}
     */
    this.getGroup = function() {
        return vGroup;
    };

    /**
     * Returns whether task is open (1=Yes,0=No)
     * @method getOpen
     * @return {Boolean}
     */
    this.getOpen = function() {
        return vOpen;
    };

    /**
     * Returns task tree level (0,1,2,3...)
     * @method getLevel
     * @return {Boolean}
     */
    this.getLevel = function() {
        return vLevel;
    };

    /**
     * Returns the number of child tasks
     * @method getNumKids
     * @return {Number}
     */
    this.getNumKids = function() {
        return vNumKid;
    };

    /**
     * Returns the X position of the left side of the task bar on the graph (right side)
     * @method getStartX
     * @return {Number}
     */
    this.getStartX = function() {
        return x1;
    };

    /**
     * Returns the Y position of the top of the task bar on the graph (right side)
     * @method getStartY
     * @return {Number}
     */
    this.getStartY = function() {
        return y1;
    };

    /**
     * Returns the X position of the right of the task bar on the graph (right side)
     * @method getEndX
     * @return {Number}
     */
    this.getEndX = function() {
        return x2;
    };

    /**
     * Returns the Y position of the bottom of the task bar on the graph (right side)
     * @method getEndY
     * @return {Number}
     */
    this.getEndY = function() {
        return y2;
    };

    /**
     * Returns whether task is visible  (1=Yes,0=No)
     * @method getVisible
     * @return {Boolean}
     */
    this.getVisible = function() {
        return vVisible;
    };

    /**
     * Set task dependencies
     * @method setDepend
     * @param pDepend {String} A comma delimited list of task IDs the current task depends on.
     * @return {void}
     */
    this.setDepend = function(pDepend) {
        vDepend = pDepend;
    };

    /**
     * Set task start date/time
     * @method setStart
     * @param pStart {Date}
     * @return {void}
     */
    this.setStart = function(pStart) {
        vStart = pStart;
    };

    /**
     * Set task end date/time
     * @method setEnd
     * @param pEnd {Date}
     * @return {void}
     */
    this.setEnd = function(pEnd) {
        vEnd = pEnd;
    };

    /**
     * Set task tree level (0,1,2,3...)
     * @method setLevel
     * @param pLevel {Number}
     * @return {void}
     */
    this.setLevel = function(pLevel) {
        vLevel = pLevel;
    };

    /**
     * Set Number of children for the task
     * @method setNumKid
     * @param pNumKid {Number}
     * @return {void}
     */
    this.setNumKid = function(pNumKid) {
        vNumKid = pNumKid;
    };

    /**
     * Set task completion percentage
     * @method setCompVal
     * @param pCompVal {Number}
     * @return {void}
     */
    this.setCompVal = function(pCompVal) {
        vComp = pCompVal;
    };

    /**
     * Set a task bar starting position (left)
     * @method setStartX
     * @param pX {Number}
     * @return {void}
     */
    this.setStartX = function(pX) {
        x1 = pX;
    };

    /**
     * Set a task bar starting position (top)
     * @method setStartY
     * @param pY {Number}
     * @return {void}
     */
    this.setStartY = function(pY) {
        y1 = pY;
    };

    /**
     * Set a task bar starting position (right)
     * @method setEndX
     * @param pX {Number}
     * @return {void}
     */
    this.setEndX = function(pX) {
        x2 = pX;
    };

    /**
     * Set a task bar starting position (bottom)
     * @method setEndY
     * @param pY {Number}
     * @return {void}
     */
    this.setEndY = function(pY) {
        y2 = pY;
    };

    /**
     * Set task open/closed
     * @method setOpen
     * @param pOpen {Boolean}
     * @return {void}
     */
    this.setOpen = function(pOpen) {
        vOpen = pOpen;
    };

    /**
     * Set task visibility
     * @method setVisible
     * @param pVisible {Boolean}
     * @return {void}
     */
    this.setVisible = function(pVisible) {
        vVisible = pVisible;
    };
};

/**
 * Creates the gant chart. for example:
 *
 * <b>var g = new JSGantt.GanttChart(document.getElementById('GanttChartDIV'), 'day');</b>
 *
 * var g = new JSGantt.GanttChart( - assign the gantt chart to a javascript variable called 'g'
 * document.getElementById('GanttChartDIV') - reference to the DIV that will hold the gantt chart
 * 'day' - default format will be by day
 *
 * @class GanttChart
 * @param pDiv {String} reference to the DIV that will hold the gantt chart
 * @param pFormat {String} default format (minute,hour,day,week,month,quarter)
 * @param pClickHandler {Function} Click handler
 * @return void
 */
JSGantt.GanttChart = function(pDiv, pFormat, pClickHandler) {

    var timestamp = Number(new Date());

    var instanceName = 'chart_' + timestamp;

    JSGantt.instances[instanceName] = this;

    /* Locale strings */
    var localeMessages = {
        // View format
        "format" : "Format",
        "day" : "Day",
        "month" : "Month",
        "week" : "Week",
        "quarter" : "Quarter",
        // Table columns
        "resource" : "Resource",
        "duration" : "Duration",
        "complete" : "% Complete",
        "startDate" : "Start Date",
        "endDate" : "End Date",
        "qtr" : "Qtr. "
    };

    var localeMonths = [
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December"
    ];

    /**
     * The function for handle click on tasks
     * @property vClickHandler
     * @type Function
     * @default pClickHandler
     * @private
     */
    var vClickHandler = pClickHandler;

    /**
     * The name of the gantt chart DIV
     * @property vDiv
     * @type String
     * @default pDiv
     * @private
     */
    var vDiv = pDiv;

    /**
     * Selected format (minute,hour,day,week,month)
     * @property vFormat
     * @type String
     * @default pFormat
     * @private
     */
    var vFormat = pFormat;

    /**
     * Show resource column
     * @property vShowRes
     * @type Number
     * @default 1
     * @private
     */
    var vShowRes = 1;

    /**
     * Show duration column
     * @property vShowDur
     * @type Number
     * @default 1
     * @private
     */
    var vShowDur = 1;

    /**
     * Show percent complete column
     * @property vShowComp
     * @type Number
     * @default 1
     * @private
     */
    var vShowComp = 1;

    /**
     * Show start date column
     * @property vShowStartDate
     * @type Number
     * @default 1
     * @private
     */
    var vShowStartDate = 1;

    /**
     * Show end date column
     * @property vShowEndDate
     * @type Number
     * @default 1
     * @private
     */
    var vShowEndDate = 1;

    /**
     * Date input format
     * @property vDateInputFormat
     * @type String
     * @default "mm/dd/yyyy"
     * @private
     */
    var vDateInputFormat = "dd/mm/yyyy";

    /**
     * Date display format
     * @property vDateDisplayFormat
     * @type String
     * @default "mm/dd/yy"
     * @private
     */
    var vDateDisplayFormat = "dd/mm/yy";

    var vNumUnits = 0;
    var vCaptionType;
    var vDepId = 1;
    var vTaskList = new Array();

    var vFormatArr = new Array("day", "week", "month", "quarter");
    var vQuarterArr = new Array(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4);
    var vMonthDaysArr = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

    /**
     * Get Instance Key
     * @method getInstanceName
     * @return {String}
     */
    this.getInstanceName = function() {
        return instanceName;
    };

    this.clearTasks = function() {
        vTaskList = new Array();
    };

    /**
     * Click on selected task
     * @param  taskObject {TaskItem} Task
     * @method clickOnTask
     * @return {void}
     */
    this.clickOnTask = function(taskObject) {
        if (vClickHandler)
            vClickHandler(taskObject);
    };

    /**
     * Set function for clicks handle
     * @param  pClickHandler {function}
     * @method getClickHandler
     * @return {void}
     */
    this.setClickHandler = function(pClickHandler) {
        vClickHandler = pClickHandler;
    };

    /**
     * Get function for clicks handle
     * @method getClickHandler
     * @return {function}
     */
    this.getClickHandler = function() {
        return vClickHandler;
    };

    /**
     * Get locale strings for Months
     * @method getLocaleMonths
     * @return {Array}
     */
    this.getLocaleMonths = function() {
        return localeMonths;
    };

    /**
     * Set locale strings for Months
     * @method setLocaleMonths
     * @param pMonths {Array} Months locale names
     * @return {void}
     */
    this.setLocaleMonths = function(pMonths) {
        localeMonths = pMonths;
    };

    /**
     * Get locale messages for tasks table
     * @method getLocaleMessages
     * @return {Object}
     */
    this.getLocaleMessages = function() {
        return localeMessages;
    };

    /**
     * Set locale messages for tasks table
     * @method setLocaleMessages
     * @param pMessages {Object} Messages dictionary
     * @return {void}
     */
    this.setLocaleMessages = function(pMessages) {
        localeMessages = pMessages;
    };

    /**
     * Set current display format (minute/hour/day/week/month/quarter)
     * Only the first 4 arguments are used, for example:
     * <code>
     * g.setFormatArr("day","week","month");
     * </code>
     * will show 3 formatting options (day/week/month) at the bottom right of the gantt chart
     * @method setFormatArr
     * @return {void}
     */
    this.setFormatArr = function() {
        vFormatArr = new Array();
        for (var i = 0; i < arguments.length; i++) {
            vFormatArr[i] = arguments[i];
        }
        if (vFormatArr.length > 4) {
            vFormatArr.length = 4;
        }
    };

    /**
     * Show/Hide resource column
     * @param pShow {Number} 1=Show,0=Hide
     * @method setShowRes
     * @return {void}
     */
    this.setShowRes = function(pShow) {
        vShowRes = pShow;
    };

    /**
     * Show/Hide duration column
     * @param pShow {Number} 1=Show,0=Hide
     * @method setShowDur
     * @return {void}
     */
    this.setShowDur = function(pShow) {
        vShowDur = pShow;
    };

    /**
     * Show/Hide completed column
     * @param pShow {Number} 1=Show,0=Hide
     * @method setShowComp
     * @return {void}
     */
    this.setShowComp = function(pShow) {
        vShowComp = pShow;
    };

    /**
     * Show/Hide start date column
     * @param pShow {Number} 1=Show,0=Hide
     * @method setShowStartDate
     * @return {void}
     */
    this.setShowStartDate = function(pShow) {
        vShowStartDate = pShow;
    };

    /**
     * Show/Hide end date column
     * @param pShow {Number} 1=Show,0=Hide
     * @method setShowEndDate
     * @return {void}
     */
    this.setShowEndDate = function(pShow) {
        vShowEndDate = pShow;
    };

    /**
     * Overall date input format
     * @param pShow {String} (mm/dd/yyyy,dd/mm/yyyy,yyyy-mm-dd)
     * @method setDateInputFormat
     * @return {void}
     */
    this.setDateInputFormat = function(pShow) {
        vDateInputFormat = pShow;
    };

    /**
     * Overall date display format
     * @param pShow {String} (mm/dd/yyyy,dd/mm/yyyy,yyyy-mm-dd)
     * @method setDateDisplayFormat
     * @return {void}
     */
    this.setDateDisplayFormat = function(pShow) {
        vDateDisplayFormat = pShow;
    };

    /**
     * Set gantt caption
     * @param pType {String}
     <p>Caption-Displays a custom caption set in TaskItem<br>
     Resource-Displays task resource<br>
     Duration-Displays task duration<br>
     Complete-Displays task percent complete</p>
     * @method setCaptionType
     * @return {void}
     */
    this.setCaptionType = function(pType) {
        vCaptionType = pType;
    };

    /**
     * Set current display format and redraw gantt chart (minute/hour/day/week/month/quarter)
     * @param pFormat {String} (mm/dd/yyyy,dd/mm/yyyy,yyyy-mm-dd)
     * @method setFormat
     * @return {void}
     */
    this.setFormat = function(pFormat) {
        vFormat = pFormat;
        this.Draw();
    };

    /**
     * Returns whether resource column is shown
     * @method getShowRes
     * @return {Number}
     */
    this.getShowRes = function() {
        return vShowRes;
    };

    /**
     * Returns whether duration column is shown
     * @method getShowDur
     * @return {Number}
     */
    this.getShowDur = function() {
        return vShowDur;
    };

    /**
     * Returns whether percent complete column is shown
     * @method getShowComp
     * @return {Number}
     */
    this.getShowComp = function() {
        return vShowComp;
    };

    /**
     * Returns whether start date column is shown
     * @method getShowStartDate
     * @return {Number}
     */
    this.getShowStartDate = function() {
        return vShowStartDate;
    };

    /**
     * Returns whether end date column is shown
     * @method getShowEndDate
     * @return {Number}
     */
    this.getShowEndDate = function() {
        return vShowEndDate;
    };

    /**
     * Returns date input format
     * @method getDateInputFormat
     * @return {String}
     */
    this.getDateInputFormat = function() {
        return vDateInputFormat;
    };

    /**
     * Returns current display format
     * @method getDateDisplayFormat
     * @return {String}
     */
    this.getDateDisplayFormat = function() {
        return vDateDisplayFormat;
    };

    /**
     * Returns current gantt caption type
     * @method getCaptionType
     * @return {String}
     */
    this.getCaptionType = function() {
        return vCaptionType
    };

    /**
     * Calculates X/Y coordinates of a task and sets the Start and End properties of the TaskItem
     * @method CalcTaskXY
     * @return {void}
     */
    this.CalcTaskXY = function () {
        var vList = this.getList();
        var vTaskDiv;
        var vParDiv;
        var vLeft, vTop, vHeight, vWidth;

        var vID, vBarDiv;

        var i;
        for (i = 0; i < vList.length; i++) {
            vID = vList[i].getID();
            vTaskDiv = document.getElementById("taskbar_" + vID);
            vBarDiv = document.getElementById("bardiv_" + vID);
            vParDiv = document.getElementById("childgrid_" + vID);

            if (vBarDiv) {
                vList[i].setStartX(vBarDiv.offsetLeft);
                vList[i].setStartY(vParDiv.offsetTop + vBarDiv.offsetTop + 6);
                vList[i].setEndX(vBarDiv.offsetLeft + vBarDiv.offsetWidth);
                vList[i].setEndY(vParDiv.offsetTop + vBarDiv.offsetTop + 6);
            }
        }
    };

    /**
     * Adds a TaskItem to the Gantt object task list array
     * @method AddTaskItem
     * @return {void}
     */
    this.AddTaskItem = function(value) {
        vTaskList.push(value);
    };

    /**
     * Returns task list Array
     * @method getList
     * @return {Array}
     */
    this.getList = function() {
        return vTaskList
    };

    /**
     * Clears dependency lines between tasks
     * @method clearDependencies
     * @return {void}
     */
    this.clearDependencies = function() {
        var parent = document.getElementById('rightside');
        var depLine;
        var vMaxId = vDepId;
        for (i = 1; i < vMaxId; i++) {
            depLine = document.getElementById("line" + i);
            if (depLine) {
                parent.removeChild(depLine);
            }
        }
        vDepId = 1;
    };

    /**
     * Draw a straight line (colored one-pixel wide DIV), need to parameterize doc item
     * @method sLine
     * @return {void}
     */
    this.sLine = function(x1, y1, x2, y2) {

        var vLeft = Math.min(x1, x2);
        var vTop = Math.min(y1, y2);
        var vWid = Math.abs(x2 - x1) + 1;
        var vHgt = Math.abs(y2 - y1) + 1;

        var vDoc = document.getElementById('rightside');

        // retrieve DIV
        var oDiv = document.createElement('div');

        oDiv.id = "line" + vDepId++;
        oDiv.style.position = "absolute";
        oDiv.style.margin = "0px";
        oDiv.style.padding = "0px";
        oDiv.style.overflow = "hidden";
        oDiv.style.border = "0px";

        // set attributes
        oDiv.style.zIndex = 0;
        oDiv.style.backgroundColor = "red";

        oDiv.style.left = vLeft + "px";
        oDiv.style.top = vTop + "px";
        oDiv.style.width = vWid + "px";
        oDiv.style.height = vHgt + "px";

        oDiv.style.visibility = "visible";

        vDoc.appendChild(oDiv);
    };

    /**
     * Draw a diaganol line (calc line x,y pairs and draw multiple one-by-one sLines)
     * @method dLine
     * @return {void}
     */
    this.dLine = function(x1, y1, x2, y2) {

        var dx = x2 - x1;
        var dy = y2 - y1;
        var x = x1;
        var y = y1;

        var n = Math.max(Math.abs(dx), Math.abs(dy));
        dx = dx / n;
        dy = dy / n;

        var i;
        for (i = 0; i <= n; i++) {
            var vx = Math.round(x);
            var vy = Math.round(y);
            this.sLine(vx, vy, vx, vy);
            x += dx;
            y += dy;
        }
    };

    /**
     * Draw dependency line between two points (task 1 end -> task 2 start)
     * @method drawDependency
     * @return {void}
     */
    this.drawDependency = function(x1, y1, x2, y2) {
        if (x1 + 10 < x2) {
            this.sLine(x1, y1, x1 + 4, y1);
            this.sLine(x1 + 4, y1, x1 + 4, y2);
            this.sLine(x1 + 4, y2, x2, y2);
            this.dLine(x2, y2, x2 - 3, y2 - 3);
            this.dLine(x2, y2, x2 - 3, y2 + 3);
            this.dLine(x2 - 1, y2, x2 - 3, y2 - 2);
            this.dLine(x2 - 1, y2, x2 - 3, y2 + 2);
        }
        else {
            this.sLine(x1, y1, x1 + 4, y1);
            this.sLine(x1 + 4, y1, x1 + 4, y2 - 10);
            this.sLine(x1 + 4, y2 - 10, x2 - 8, y2 - 10);
            this.sLine(x2 - 8, y2 - 10, x2 - 8, y2);
            this.sLine(x2 - 8, y2, x2, y2);
            this.dLine(x2, y2, x2 - 3, y2 - 3);
            this.dLine(x2, y2, x2 - 3, y2 + 3);
            this.dLine(x2 - 1, y2, x2 - 3, y2 - 2);
            this.dLine(x2 - 1, y2, x2 - 3, y2 + 2);
        }
    };

    /**
     * Draw all task dependencies
     * @method DrawDependencies
     * @return {void}
     */
    this.DrawDependencies = function () {
        //First recalculate the x,y
        this.CalcTaskXY();

        this.clearDependencies();

        var vList = this.getList();
        for (var i = 0; i < vList.length; i++) {

            var vDepend = vList[i].getDepend();
            if (vDepend) {

                var vDependStr = vDepend + '';
                var vDepList = vDependStr.split(',');
                var n = vDepList.length;

                for (var k = 0; k < n; k++) {
                    var vTask = this.getArrayLocationByID(vDepList[k]);

                    if (vList[vTask]) {
                        if (vList[vTask].getVisible() == 1)
                            this.drawDependency(
                                vList[vTask].getEndX(),
                                vList[vTask].getEndY(),
                                vList[i].getStartX() - 1,
                                vList[i].getStartY())
                    }
                }
            }
        }
    };

    /**
     * Find location of TaskItem based on the task ID
     * @method getArrayLocationByID
     * @return {void}
     */
    this.getArrayLocationByID = function(pId) {

        var vList = this.getList();
        for (var i = 0; i < vList.length; i++) {
            if (vList[i].getID() == pId)
                return i;
        }
    };

    /**
     * Draw gantt chart
     * @method Draw
     * @return {void}
     */
    this.Draw = function() {

        var vMaxDate = new Date();
        var vMinDate = new Date();
        var vTmpDate = new Date();
        var vNxtDate = new Date();
        var vCurrDate = new Date();
        var vTaskLeft = 0;
        var vTaskRight = 0;
        var vNumCols = 0;
        var vID = 0;
        var vMainTable = "";
        var vLeftTable = "";
        var vRightTable = "";
        var vDateRowStr = "";
        var vItemRowStr = "";
        var vColWidth = 0;
        var vColUnit = 0;
        var vChartWidth = 0;
        var vNumDays = 0;
        var vDayWidth = 0;
        var vStr = "";
        var vNameWidth = 220;
        var vStatusWidth = 70;
        var vLeftWidth = 15 + 220 + 70 + 70 + 70 + 70 + 70;

        if (vTaskList.length > 0) {

            // Process all tasks preset parent date and completion %
            JSGantt.processRows(vTaskList, 0, -1, 1, 1);

            // get overall min/max dates plus padding
            vMinDate = JSGantt.getMinDate(vTaskList, vFormat);
            vMaxDate = JSGantt.getMaxDate(vTaskList, vFormat);

            // Calculate chart width variables.  vColWidth can be altered manually to change each column width
            // May be smart to make this a parameter of GanttChart or set it based on existing pWidth parameter
            if (vFormat == 'day') {
                vColWidth = 18;
                vColUnit = 1;
            }
            else if (vFormat == 'week') {
                vColWidth = 37;
                vColUnit = 7;
            }
            else if (vFormat == 'month') {
                vColWidth = 37;
                vColUnit = 30;
            }
            else if (vFormat == 'quarter') {
                vColWidth = 60;
                vColUnit = 90;
            }

            else if (vFormat == 'hour') {
                vColWidth = 18;
                vColUnit = 1;
            }

            else if (vFormat == 'minute') {
                vColWidth = 18;
                vColUnit = 1;
            }

            vNumDays = (Date.parse(vMaxDate) - Date.parse(vMinDate)) / ( 24 * 60 * 60 * 1000);
            vNumUnits = vNumDays / vColUnit;

            vChartWidth = vNumUnits * vColWidth + 1;
            vDayWidth = (vColWidth / vColUnit) + (1 / vColUnit);

            vMainTable =
                '<table id="theTable" cellSpacing="0" cellPadding="0" border="0"><tbody><tr>' +
                    '<td vAlign="top" bgColor=#ffffff>';

            if (vShowRes != 1) vNameWidth += vStatusWidth;
            if (vShowDur != 1) vNameWidth += vStatusWidth;
            if (vShowComp != 1) vNameWidth += vStatusWidth;
            if (vShowStartDate != 1) vNameWidth += vStatusWidth;
            if (vShowEndDate != 1) vNameWidth += vStatusWidth;

            // DRAW the Left-side of the chart (names, resources, comp%)
            vLeftTable =
                '<div class="scroll" id="leftside" style="width:' + vLeftWidth + 'px"><table cellSpacing=0 cellPadding=0 border=0><tbody>' +
                    '<tr style="height: 17px">' +
                    '  <td style="width: 15px; height: 17px"></td>' +
                    '  <td style="width: ' + vNameWidth + 'px; height: 17px"><NOBR></NOBR></td>';

            if (vShowRes == 1) vLeftTable += '  <td style="width: ' + vStatusWidth + 'px; height: 17px"></td>';
            if (vShowDur == 1) vLeftTable += '  <td style="width: ' + vStatusWidth + 'px; height: 17px"></td>';
            if (vShowComp == 1) vLeftTable += '  <td style="width: ' + vStatusWidth + 'px; height: 17px"></td>';
            if (vShowStartDate == 1) vLeftTable += '  <td style="width: ' + vStatusWidth + 'px; height: 17px"></td>';
            if (vShowEndDate == 1) vLeftTable += '  <td style="width: ' + vStatusWidth + 'px; height: 17px"></td>';

            vLeftTable +=
                '<tr style="height: 20px">' +
                    '  <td style="border-top: #efefef 1px solid; width: 15px; height: 20px"></td>' +
                    '  <td style="border-top: #efefef 1px solid; width: ' + vNameWidth + 'px; height: 20px"><nobr></nobr></td>';

            if (vShowRes == 1) vLeftTable += '  <td style="border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid; width: 60px; height: 20px" align=center nowrap>' + localeMessages['resource'] +'</td>';
            if (vShowDur == 1) vLeftTable += '  <td style="border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid; width: 60px; height: 20px" align=center nowrap>' + localeMessages['duration'] +'</td>';
            if (vShowComp == 1) vLeftTable += '  <td style="border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid; width: 60px; height: 20px" align=center nowrap>' + localeMessages['complete'] +'</td>';
            if (vShowStartDate == 1) vLeftTable += '  <td style="border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid; width: 60px; height: 20px" align=center nowrap>' + localeMessages['startDate'] +'</td>';
            if (vShowEndDate == 1) vLeftTable += '  <td style="border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid; width: 60px; height: 20px" align=center nowrap>' + localeMessages['endDate'] +'</td>';

            vLeftTable += '</tr>';

            for (i = 0; i < vTaskList.length; i++) {
                var vBGColor, vRowType;
                if (vTaskList[i].getGroup()) {
                    vBGColor = "f3f3f3";
                    vRowType = "group";
                } else {
                    vBGColor = "ffffff";
                    vRowType = "row";
                }

                vID = vTaskList[i].getID();

                if (vTaskList[i].getVisible() == 0)
                    vLeftTable += '<tr id=child_' + vID + ' bgcolor=#' + vBGColor + ' style="display:none" ' +
                        'onMouseover=JSGantt.mouseOver("' + instanceName +'",this,' + vID + ',"left","' + vRowType + '") ' +
                        'onMouseout=JSGantt.mouseOut("' + instanceName +'",this,' + vID + ',"left","' + vRowType + '")>';
                else
                    vLeftTable += '<tr id=child_' + vID + ' bgcolor=#' + vBGColor +
                        ' onMouseover=JSGantt.mouseOver("' + instanceName +'",this,' + vID + ',"left","' + vRowType + '") ' +
                        'onMouseout=JSGantt.mouseOut("' + instanceName +'",this,' + vID + ',"left","' + vRowType + '")>';

                vLeftTable +=
                    '  <td class="gdatehead" style="width: 15px; height: 20px; border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid;">&nbsp;</td>' +
                        '  <td class="gname" style="width: ' + vNameWidth + 'px; height: 20px; border-top: #efefef 1px solid; font-size: 12px;" nowrap><NOBR><span style="color: #aaaaaa">';

                var j;
                for (j = 1; j < vTaskList[i].getLevel(); j++) {
                    vLeftTable += '&nbsp&nbsp&nbsp&nbsp';
                }

                vLeftTable += '</span>';

                if (vTaskList[i].getGroup()) {
                    if (vTaskList[i].getOpen() == 1)
                        vLeftTable += '<span id="group_' + vID + '" style="color:#000000; cursor:pointer; font-weight:bold; font-size: 12px;" onclick="JSGantt.folder(' + vID + ',\'' + instanceName + '\');JSGantt.DrawDependencies(\'' + instanceName +'\');">&ndash;</span><span style="color:#000000">&nbsp</SPAN>';
                    else
                        vLeftTable += '<span id="group_' + vID + '" style="color:#000000; cursor:pointer; font-weight:bold; font-size: 12px;" onclick="JSGantt.folder(' + vID + ',\'' + instanceName + '\');JSGantt.DrawDependencies(\'' + instanceName +'\');">+</span><span style="color:#000000">&nbsp</SPAN>';

                } else {

                    vLeftTable += '<span style="color: #000000; font-weight:bold; font-size: 12px;">&nbsp&nbsp&nbsp</span>';
                }

                vLeftTable +=
                    '<span onclick=JSGantt.onClick("' + instanceName  +'",' + vID + '); style="cursor:pointer"> ' + vTaskList[i].getName() + '</span></NOBR></td>';

                if (vShowRes == 1) vLeftTable += '  <td class=gname style="width: 60px; height: 20px; text-align: center; border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid;" align=center><nobr>' + vTaskList[i].getResource() + '</nobr></td>';
                if (vShowDur == 1) vLeftTable += '  <td class=gname style="width: 60px; height: 20px; text-align: center; border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid;" align=center><nobr>' + vTaskList[i].getDuration(vFormat) + '</nobr></td>';
                if (vShowComp == 1) vLeftTable += '  <td class=gname style="width: 60px; height: 20px; text-align: center; border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid;" align=center><nobr>' + vTaskList[i].getCompStr() + '</nobr></td>';
                if (vShowStartDate == 1) vLeftTable += '  <td class=gname style="width: 60px; height: 20px; text-align: center; border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid;" align=center><nobr>' + JSGantt.formatDateStr(vTaskList[i].getStart(), vDateDisplayFormat) + '</NOBR></td>';
                if (vShowEndDate == 1) vLeftTable += '  <td class=gname style="width: 60px; height: 20px; text-align: center; border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid;" align=center><nobr>' + JSGantt.formatDateStr(vTaskList[i].getEnd(), vDateDisplayFormat) + '</NOBR></td>';

                vLeftTable += '</tr>';
            }

            // DRAW the date format selector at bottom left.  Another potential GanttChart parameter to hide/show this selector
            vLeftTable += '</td></tr>' +
                '<tr><td border="1" colspan="5" align="left" style="border-top: #efefef 1px solid; font-size: 11px; border-left: #efefef 1px solid; height=18px">' + localeMessages['format'] + ':';

            if (vFormatArr.join().indexOf("minute") != -1) {
                if (vFormat == 'minute') vLeftTable += '<input type="radio" name="radFormat" value="minute" checked>' + localeMessages['minute'];
                else
                    vLeftTable += '<input type="radio" name="radFormat" onclick=JSGantt.changeFormat("minute","' + instanceName + '"); value="minute">Minute';
            }

            if (vFormatArr.join().indexOf("hour") != -1) {
                if (vFormat == 'hour') vLeftTable += '<input type="radio" name="radFormat" value="hour" checked>Hour';
                else
                    vLeftTable += '<input type="radio" name="radFormat" onclick=JSGantt.changeFormat("hour","' + instanceName + '"); value="hour">Hour';
            }

            if (vFormatArr.join().indexOf("day") != -1) {
                if (vFormat == 'day') vLeftTable += '<input type="radio" name="radFormat" value="day" checked>' + localeMessages['day'];
                else
                    vLeftTable += '<input type="radio" name="radFormat" onclick=JSGantt.changeFormat("day","' + instanceName + '"); value="day">' + localeMessages['day'];
            }

            if (vFormatArr.join().indexOf("week") != -1) {
                if (vFormat == 'week')
                    vLeftTable += '<input type="radio" name="radFormat" value="week" checked>' + localeMessages['week'];
                else
                    vLeftTable += '<input type="radio" name="radFormat" onclick=JSGantt.changeFormat("week","' + instanceName + '") value="week">' + localeMessages['week'];
            }

            if (vFormatArr.join().indexOf("month") != -1) {
                if (vFormat == 'month')
                    vLeftTable += '<input type="radio" name="radFormat" value="month" checked>' + localeMessages['month'];
                else
                    vLeftTable += '<input type="radio" name="radFormat" onclick=JSGantt.changeFormat("month","' + instanceName + '") value="month">' + localeMessages['month'];
            }

            if (vFormatArr.join().indexOf("quarter") != -1) {
                if (vFormat == 'quarter')
                    vLeftTable += '<input type="radio" name="radFormat" value="quarter" checked>' + localeMessages['quarter'];
                else
                    vLeftTable += '<input type="radio" name="radFormat" onclick=JSGantt.changeFormat("quarter","' + instanceName + '") value="quarter">' + localeMessages['quarter'];
            }

            vLeftTable += '</td></tr></tbody></table></td>';

            vMainTable += vLeftTable;

            // Draw the Chart Rows
            vRightTable =
                '<td style="width: ' + vChartWidth + 'px;" vAlign="top" bgColor="#ffffff">' +
                    '<div class="scroll2" id="rightside">' +
                    '<table style="width: ' + vChartWidth + 'px;" cellSpacing="0" cellPadding="0" border="0">' +
                    '<tbody><tr style="height: 18px">';

            vTmpDate.setFullYear(vMinDate.getFullYear(), vMinDate.getMonth(), vMinDate.getDate());
            vTmpDate.setHours(0);
            vTmpDate.setMinutes(0);

            // Major Date Header
            while (Date.parse(vTmpDate) <= Date.parse(vMaxDate)) {
                vStr = vTmpDate.getFullYear() + '';
                vStr = vStr.substring(2, 4);

                if (vFormat == 'minute') {
                    vRightTable += '<td class=gdatehead style="font-size: 12px; height: 19px;" align=center colspan=60>';
                    vRightTable += JSGantt.formatDateStr(vTmpDate, vDateDisplayFormat) + ' ' + vTmpDate.getHours() + ':00 -' + vTmpDate.getHours() + ':59 </td>';
                    vTmpDate.setHours(vTmpDate.getHours() + 1);
                }

                if (vFormat == 'hour') {
                    vRightTable += '<td class=gdatehead style="font-size: 12px; height: 19px;" align=center colspan=24>';
                    vRightTable += JSGantt.formatDateStr(vTmpDate, vDateDisplayFormat) + '</td>';
                    vTmpDate.setDate(vTmpDate.getDate() + 1);
                }

                if (vFormat == 'day') {
                    vRightTable += '<td class=gdatehead style="font-size: 12px; height: 19px;" align=center colspan=7>' +
                        JSGantt.formatDateStr(vTmpDate, vDateDisplayFormat.substring(0, 5)) + ' - ';
                    vTmpDate.setDate(vTmpDate.getDate() + 6);
                    vRightTable += JSGantt.formatDateStr(vTmpDate, vDateDisplayFormat) + '</td>';
                    vTmpDate.setDate(vTmpDate.getDate() + 1);
                }
                else if (vFormat == 'week') {
                    vRightTable += '<td class=gdatehead align=center style="font-size: 12px; height: 19px;" width=' + vColWidth + 'px>`' + vStr + '</td>';
                    vTmpDate.setDate(vTmpDate.getDate() + 7);
                }
                else if (vFormat == 'month') {
                    vRightTable += '<td class=gdatehead align=center style="font-size: 12px; height: 19px;" width=' + vColWidth + 'px>`' + vStr + '</td>';
                    vTmpDate.setDate(vTmpDate.getDate() + 1);
                    while (vTmpDate.getDate() > 1) {
                        vTmpDate.setDate(vTmpDate.getDate() + 1);
                    }
                }
                else if (vFormat == 'quarter') {
                    vRightTable += '<td class=gdatehead align=center style="font-size: 12px; height: 19px;" width=' + vColWidth + 'px>`' + vStr + '</td>';
                    vTmpDate.setDate(vTmpDate.getDate() + 81);
                    while (vTmpDate.getDate() > 1) {
                        vTmpDate.setDate(vTmpDate.getDate() + 1);
                    }
                }
            }

            vRightTable += '</tr><tr>';

            // Minor Date header and Cell Rows
            vTmpDate.setFullYear(vMinDate.getFullYear(), vMinDate.getMonth(), vMinDate.getDate());
            vNxtDate.setFullYear(vMinDate.getFullYear(), vMinDate.getMonth(), vMinDate.getDate());
            vNumCols = 0;

            var vWeekdayColor, vWeekendColor, vWeekdayGColor, vWeekendGColor;

            while (Date.parse(vTmpDate) <= Date.parse(vMaxDate)) {
                if (vFormat == 'minute') {

                    if (vTmpDate.getMinutes() == 0)
                        vWeekdayColor = "ccccff";
                    else
                        vWeekdayColor = "ffffff";


                    vDateRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; height: 19px; border-left: #efefef 1px solid;"  bgcolor=#' + vWeekdayColor + ' align=center><div style="width: ' + vColWidth + 'px">' + vTmpDate.getMinutes() + '</div></td>';
                    vItemRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid; cursor: default;"  bgcolor=#' + vWeekdayColor + ' align=center><div style="width: ' + vColWidth + 'px">&nbsp&nbsp</div></td>';
                    vTmpDate.setMinutes(vTmpDate.getMinutes() + 1);
                }

                else if (vFormat == 'hour') {

                    if (vTmpDate.getHours() == 0)
                        vWeekdayColor = "ccccff";
                    else
                        vWeekdayColor = "ffffff";

                    vDateRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; height: 19px; border-left: #efefef 1px solid;"  bgcolor=#' + vWeekdayColor + ' align=center><div style="width: ' + vColWidth + 'px">' + vTmpDate.getHours() + '</div></td>';
                    vItemRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid; cursor: default;"  bgcolor=#' + vWeekdayColor + ' align=center><div style="width: ' + vColWidth + 'px">&nbsp&nbsp</div></td>';
                    vTmpDate.setHours(vTmpDate.getHours() + 1);
                }

                else if (vFormat == 'day') {
                    if (JSGantt.formatDateStr(vCurrDate, 'mm/dd/yyyy') == JSGantt.formatDateStr(vTmpDate, 'mm/dd/yyyy')) {
                        vWeekdayColor = "ccccff";
                        vWeekendColor = "9999ff";
                        vWeekdayGColor = "bbbbff";
                        vWeekendGColor = "8888ff";
                    } else {
                        vWeekdayColor = "ffffff";
                        vWeekendColor = "cfcfcf";
                        vWeekdayGColor = "f3f3f3";
                        vWeekendGColor = "c3c3c3";
                    }

                    if (vTmpDate.getDay() % 6 == 0) {
                        vDateRowStr += '<td class="gheadwkend" style="border-top: #efefef 1px solid; font-size: 12px; height: 19px; border-left: #efefef 1px solid;" bgcolor=#' + vWeekendColor + ' align=center><div style="width: ' + vColWidth + 'px">' + vTmpDate.getDate() + '</div></td>';
                        vItemRowStr += '<td class="gheadwkend" style="border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid; cursor: default;"  bgcolor=#' + vWeekendColor + ' align=center><div style="width: ' + vColWidth + 'px">&nbsp</div></td>';
                    }
                    else {
                        vDateRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; height: 19px; border-left: #efefef 1px solid;"  bgcolor=#' + vWeekdayColor + ' align=center><div style="width: ' + vColWidth + 'px">' + vTmpDate.getDate() + '</div></td>';
                        if (JSGantt.formatDateStr(vCurrDate, 'mm/dd/yyyy') == JSGantt.formatDateStr(vTmpDate, 'mm/dd/yyyy'))
                            vItemRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid; cursor: default;"  bgcolor=#' + vWeekdayColor + ' align=center><div style="width: ' + vColWidth + 'px">&nbsp&nbsp</div></td>';
                        else
                            vItemRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid; cursor: default;"  align=center><div style="width: ' + vColWidth + 'px">&nbsp&nbsp</div></td>';
                    }

                    vTmpDate.setDate(vTmpDate.getDate() + 1);

                }

                else if (vFormat == 'week') {
                    vNxtDate.setDate(vNxtDate.getDate() + 7);

                    if (vCurrDate >= vTmpDate && vCurrDate < vNxtDate)
                        vWeekdayColor = "ccccff";
                    else
                        vWeekdayColor = "ffffff";

                    if (vNxtDate <= vMaxDate) {
                        vDateRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; height: 19px; border-left: #efefef 1px solid;" bgcolor=#' + vWeekdayColor + ' align=center width:' + vColWidth + 'px><div style="width: ' + vColWidth + 'px">' + (vTmpDate.getMonth() + 1) + '/' + vTmpDate.getDate() + '</div></td>';
                        if (vCurrDate >= vTmpDate && vCurrDate < vNxtDate)
                            vItemRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid;" bgcolor=#' + vWeekdayColor + ' align=center><div style="width: ' + vColWidth + 'px">&nbsp&nbsp</div></td>';
                        else
                            vItemRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid;" align=center><div style="width: ' + vColWidth + 'px">&nbsp&nbsp</div></td>';

                    } else {
                        vDateRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; height: 19px; border-left: #efefef 1px solid; bgcolor=#' + vWeekdayColor + ' border-right: #efefef 1px solid;" align=center width:' + vColWidth + 'px><div style="width: ' + vColWidth + 'px">' + (vTmpDate.getMonth() + 1) + '/' + vTmpDate.getDate() + '</div></td>';
                        if (vCurrDate >= vTmpDate && vCurrDate < vNxtDate)
                            vItemRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid; border-right: #efefef 1px solid;" bgcolor=#' + vWeekdayColor + ' align=center><div style="width: ' + vColWidth + 'px">&nbsp&nbsp</div></td>';
                        else
                            vItemRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid; border-right: #efefef 1px solid;" align=center><div style="width: ' + vColWidth + 'px">&nbsp&nbsp</div></td>';
                    }

                    vTmpDate.setDate(vTmpDate.getDate() + 7);
                }

                else if (vFormat == 'month') {

                    vNxtDate.setFullYear(vTmpDate.getFullYear(), vTmpDate.getMonth(), vMonthDaysArr[vTmpDate.getMonth()]);
                    if (vCurrDate >= vTmpDate && vCurrDate < vNxtDate)
                        vWeekdayColor = "ccccff";
                    else
                        vWeekdayColor = "ffffff";

                    if (vNxtDate <= vMaxDate) {
                        vDateRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; height: 19px; border-left: #efefef 1px solid;" bgcolor=#' + vWeekdayColor + ' align=center width:' + vColWidth + 'px><div style="width: ' + vColWidth + 'px">' + localeMonths[vTmpDate.getMonth()].substr(0, 3) + '</div></td>';
                        if (vCurrDate >= vTmpDate && vCurrDate < vNxtDate)
                            vItemRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid;" bgcolor=#' + vWeekdayColor + ' align=center><div style="width: ' + vColWidth + 'px">&nbsp&nbsp</div></td>';
                        else
                            vItemRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid;" align=center><div style="width: ' + vColWidth + 'px">&nbsp&nbsp</div></td>';
                    } else {
                        vDateRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; height: 19px; border-left: #efefef 1px solid; border-right: #efefef 1px solid;" bgcolor=#' + vWeekdayColor + ' align=center width:' + vColWidth + 'px><div style="width: ' + vColWidth + 'px">' + localeMonths[vTmpDate.getMonth()].substr(0, 3) + '</div></td>';
                        if (vCurrDate >= vTmpDate && vCurrDate < vNxtDate)
                            vItemRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid; border-right: #efefef 1px solid;" bgcolor=#' + vWeekdayColor + ' align=center><div style="width: ' + vColWidth + 'px">&nbsp&nbsp</div></td>';
                        else
                            vItemRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid; border-right: #efefef 1px solid;" align=center><div style="width: ' + vColWidth + 'px">&nbsp&nbsp</div></td>';
                    }

                    vTmpDate.setDate(vTmpDate.getDate() + 1);

                    while (vTmpDate.getDate() > 1) {
                        vTmpDate.setDate(vTmpDate.getDate() + 1);
                    }
                }

                else if (vFormat == 'quarter') {

                    vNxtDate.setDate(vNxtDate.getDate() + 122);
                    if (vTmpDate.getMonth() == 0 || vTmpDate.getMonth() == 1 || vTmpDate.getMonth() == 2)
                        vNxtDate.setFullYear(vTmpDate.getFullYear(), 2, 31);
                    else if (vTmpDate.getMonth() == 3 || vTmpDate.getMonth() == 4 || vTmpDate.getMonth() == 5)
                        vNxtDate.setFullYear(vTmpDate.getFullYear(), 5, 30);
                    else if (vTmpDate.getMonth() == 6 || vTmpDate.getMonth() == 7 || vTmpDate.getMonth() == 8)
                        vNxtDate.setFullYear(vTmpDate.getFullYear(), 8, 30);
                    else if (vTmpDate.getMonth() == 9 || vTmpDate.getMonth() == 10 || vTmpDate.getMonth() == 11)
                        vNxtDate.setFullYear(vTmpDate.getFullYear(), 11, 31);

                    if (vCurrDate >= vTmpDate && vCurrDate < vNxtDate)
                        vWeekdayColor = "ccccff";
                    else
                        vWeekdayColor = "ffffff";

                    if (vNxtDate <= vMaxDate) {
                        vDateRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; height: 19px; border-left: #efefef 1px solid;" bgcolor=#' + vWeekdayColor + ' align=center width:' + vColWidth + 'px><div style="width: ' + vColWidth + 'px">' + localeMessages['qtr'] + vQuarterArr[vTmpDate.getMonth()] + '</div></td>';
                        if (vCurrDate >= vTmpDate && vCurrDate < vNxtDate)
                            vItemRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid;" bgcolor=#' + vWeekdayColor + ' align=center><div style="width: ' + vColWidth + 'px">&nbsp&nbsp</div></td>';
                        else
                            vItemRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid;" align=center><div style="width: ' + vColWidth + 'px">&nbsp&nbsp</div></td>';
                    } else {
                        vDateRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; height: 19px; border-left: #efefef 1px solid; border-right: #efefef 1px solid;" bgcolor=#' + vWeekdayColor + ' align=center width:' + vColWidth + 'px><div style="width: ' + vColWidth + 'px">Qtr. ' + vQuarterArr[vTmpDate.getMonth()] + '</div></td>';
                        if (vCurrDate >= vTmpDate && vCurrDate < vNxtDate)
                            vItemRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid; border-right: #efefef 1px solid;" bgcolor=#' + vWeekdayColor + ' align=center><div style="width: ' + vColWidth + 'px">&nbsp&nbsp</div></td>';
                        else
                            vItemRowStr += '<td class="ghead" style="border-top: #efefef 1px solid; font-size: 12px; border-left: #efefef 1px solid; border-right: #efefef 1px solid;" align=center><div style="width: ' + vColWidth + 'px">&nbsp&nbsp</div></td>';
                    }

                    vTmpDate.setDate(vTmpDate.getDate() + 81);

                    while (vTmpDate.getDate() > 1) {
                        vTmpDate.setDate(vTmpDate.getDate() + 1);
                    }
                }
            }

            vRightTable += vDateRowStr + '</tr>';
            vRightTable += '</tbody></table>';

            // Draw each row
            var i;
            for (i = 0; i < vTaskList.length; i++) {

                vTmpDate.setFullYear(vMinDate.getFullYear(), vMinDate.getMonth(), vMinDate.getDate());
                var vTaskStart = vTaskList[i].getStart();
                var vTaskEnd = vTaskList[i].getEnd();

                vNumCols = 0;
                vID = vTaskList[i].getID();

                // vNumUnits = Math.ceil((vTaskList[i].getEnd() - vTaskList[i].getStart()) / (24 * 60 * 60 * 1000)) + 1;
                vNumUnits = (vTaskList[i].getEnd() - vTaskList[i].getStart()) / (24 * 60 * 60 * 1000) + 1;
                if (vFormat == 'hour') {
                    vNumUnits = (vTaskList[i].getEnd() - vTaskList[i].getStart()) / (  60 * 1000) + 1;
                }
                else if (vFormat == 'minute') {
                    vNumUnits = (vTaskList[i].getEnd() - vTaskList[i].getStart()) / (  60 * 1000) + 1;
                }

                if (vTaskList[i].getVisible() == 0)
                    vRightTable += '<div id=childgrid_' + vID + ' style="position:relative; display:none;">';
                else
                    vRightTable += '<div id=childgrid_' + vID + ' style="position:relative">';

                if (vTaskList[i].getMile()) {

                    vRightTable += '<div><table style="position:relative; top: 0; width: ' + vChartWidth + 'px;" cellSpacing=0 cellPadding=0 border=0>' +
                        '<tr id=childrow_' + vID + ' class="yesdisplay" style="height: 20px" ' +
                        'onMouseover=JSGantt.mouseOver("' + instanceName +'",this,' + vID + ',"right","mile") ' +
                        'onMouseout=JSGantt.mouseOut("' + instanceName +'",this,' + vID + ',"right","mile")>' + vItemRowStr + '</tr></table></div>';

                    // Build date string for Title
                    vDateRowStr = JSGantt.formatDateStr(vTaskStart, vDateDisplayFormat);

                    vTaskLeft = (Date.parse(vTaskList[i].getStart()) - Date.parse(vMinDate)) / (24 * 60 * 60 * 1000);
                    vTaskRight = 1;

                    vRightTable +=
                        '<div id=bardiv_' + vID + ' style="position:absolute; top:0px; left:' + Math.ceil((vTaskLeft * (vDayWidth) + 1)) + 'px; height: 18px; width:160px; overflow:hidden;">' +
                            '  <div id=taskbar_' + vID + ' title="' + vTaskList[i].getName() + ': ' + vDateRowStr + '" style="height: 16px; width:12px; overflow:hidden; cursor: pointer;" ' +
                            'onclick=JSGantt.onClick("' + instanceName  +'",' + vID + ')>';

                    if (vTaskList[i].getCompVal() < 100) {
                        vRightTable += '&loz;</div>';
                    }
                    else {
                        vRightTable += '&diams;</div>';
                    }

                    if (this.getCaptionType()) {
                        vCaptionStr = '';
                        switch (this.getCaptionType()) {
                            case 'Caption':
                                vCaptionStr = vTaskList[i].getCaption();
                                break;
                            case 'Resource':
                                vCaptionStr = vTaskList[i].getResource();
                                break;
                            case 'Duration':
                                vCaptionStr = vTaskList[i].getDuration(vFormat);
                                break;
                            case 'Complete':
                                vCaptionStr = vTaskList[i].getCompStr();
                                break;
                        }
                        //vRightTable += '<div style="font-size:12px; position:absolute; left: 6px; top:1px;">' + vCaptionStr + '</div>';
                        vRightTable += '<div style="font-size:12px; position:absolute; top:2px; width:120px; left:12px">' + vCaptionStr + '</div>';
                    }
                    vRightTable += '</div>';
                } else {
                    // Build date string for Title
                    vDateRowStr = JSGantt.formatDateStr(vTaskStart, vDateDisplayFormat) + ' - ' + JSGantt.formatDateStr(vTaskEnd, vDateDisplayFormat);

                    if (vFormat == 'minute') {
                        vTaskRight = (Date.parse(vTaskList[i].getEnd()) - Date.parse(vTaskList[i].getStart())) / ( 60 * 1000) + 1 / vColUnit;
                        vTaskLeft = Math.ceil((Date.parse(vTaskList[i].getStart()) - Date.parse(vMinDate)) / ( 60 * 1000));
                    }
                    else if (vFormat == 'hour') {
                        vTaskRight = (Date.parse(vTaskList[i].getEnd()) - Date.parse(vTaskList[i].getStart())) / ( 60 * 60 * 1000) + 1 / vColUnit;
                        vTaskLeft = (Date.parse(vTaskList[i].getStart()) - Date.parse(vMinDate)) / ( 60 * 60 * 1000);
                    }
                    else {
                        vTaskRight = (Date.parse(vTaskList[i].getEnd()) - Date.parse(vTaskList[i].getStart())) / (24 * 60 * 60 * 1000) + 1 / vColUnit;
                        vTaskLeft = Math.ceil((Date.parse(vTaskList[i].getStart()) - Date.parse(vMinDate)) / (24 * 60 * 60 * 1000));
                        if (vFormat = 'day') {
                            var tTime = new Date();
                            tTime.setTime(Number(Date.parse(vTaskList[i].getStart())));
                            if (tTime.getMinutes() > 29)
                                vTaskLeft += .5;
                        }
                    }

                    // Draw Group Bar  which has outer div with inner group div and several small divs to left and right to create angled-end indicators
                    if (vTaskList[i].getGroup()) {
                        vRightTable += '<div><table style="position:relative; top:0; width: ' + vChartWidth + 'px;" cellSpacing=0 cellPadding=0 border=0>' +
                            '<tr id=childrow_' + vID + ' class=yesdisplay style="height: 20px" bgColor=#f3f3f3 ' +
                            'onMouseover=JSGantt.mouseOver("' + instanceName +'",this,' + vID + ',"right","group") ' +
                            'onMouseout=JSGantt.mouseOut("' + instanceName +'",this,' + vID + ',"right","group") >' + vItemRowStr + '</tr></table></div>';
                        vRightTable +=
                            '<div id=bardiv_' + vID + ' style="position:absolute; top:5px; left:' + Math.ceil(vTaskLeft * (vDayWidth) + 1) + 'px; height: 7px; width:' + Math.ceil((vTaskRight) * (vDayWidth) - 1) + 'px">' +
                                '<div id=taskbar_' + vID + ' title="' + vTaskList[i].getName() + ': ' + vDateRowStr +
                                '" class=gtask style="background-color:#000000; height: 7px; width:' +
                                Math.ceil((vTaskRight) * (vDayWidth) - 1) + 'px;  cursor: pointer;opacity:0.9;">' +
                                '<div style="z-index: -4; float:left; background-color:#666666; height:3px; overflow: hidden; margin-top:1px; ' +
                                'margin-left:1px; margin-right:1px; filter: alpha(opacity=80); opacity:0.8; width:' + vTaskList[i].getCompStr() + '; ' +
                                'cursor: pointer;" onclick=JSGantt.onClick("' + instanceName  +'",' + vID + ')>' +
                                '</div>' +
                                '</div>' +
                                '<div style="z-index: -4; float:left; background-color:#000000; height:4px; overflow: hidden; width:1px;"></div>' +
                                '<div style="z-index: -4; float:right; background-color:#000000; height:4px; overflow: hidden; width:1px;"></div>' +
                                '<div style="z-index: -4; float:left; background-color:#000000; height:3px; overflow: hidden; width:1px;"></div>' +
                                '<div style="z-index: -4; float:right; background-color:#000000; height:3px; overflow: hidden; width:1px;"></div>' +
                                '<div style="z-index: -4; float:left; background-color:#000000; height:2px; overflow: hidden; width:1px;"></div>' +
                                '<div style="z-index: -4; float:right; background-color:#000000; height:2px; overflow: hidden; width:1px;"></div>' +
                                '<div style="z-index: -4; float:left; background-color:#000000; height:1px; overflow: hidden; width:1px;"></div>' +
                                '<div style="z-index: -4; float:right; background-color:#000000; height:1px; overflow: hidden; width:1px;"></div>';

                        if (this.getCaptionType()) {
                            vCaptionStr = '';
                            switch (this.getCaptionType()) {
                                case 'Caption':
                                    vCaptionStr = vTaskList[i].getCaption();
                                    break;
                                case 'Resource':
                                    vCaptionStr = vTaskList[i].getResource();
                                    break;
                                case 'Duration':
                                    vCaptionStr = vTaskList[i].getDuration(vFormat);
                                    break;
                                case 'Complete':
                                    vCaptionStr = vTaskList[i].getCompStr();
                                    break;
                            }
                            //vRightTable += '<div style="font-size:12px; position:absolute; left: 6px; top:1px;">' + vCaptionStr + '</div>';
                            vRightTable += '<div style="font-size:12px; position:absolute; top:-3px; width:120px; left:' +
                                (Math.ceil((vTaskRight) * (vDayWidth) - 1) + 6) + 'px">' + vCaptionStr + '</div>';
                        }

                        vRightTable += '</div>';

                    } else {

                        var vDivStr = '<div><table style="position:relative; top:0; width: ' + vChartWidth +
                            'px;" cellSpacing=0 cellPadding=0 border=0>' +
                            '<tr id=childrow_' + vID + ' class=yesdisplay style="height: 20px" bgColor=#ffffff ' +
                            'onMouseover=JSGantt.mouseOver("' + instanceName +'",this,' + vID + ',"right","row") ' +
                            'onMouseout=JSGantt.mouseOut("' + instanceName +'",this,' + vID + ',"right","row")>' + vItemRowStr + '</tr></table></div>';
                        vRightTable += vDivStr;

                        // Draw Task Bar  which has outer DIV with enclosed colored bar div, and opaque completion div
                        vRightTable +=
                            '<div id=bardiv_' + vID + ' style="position:absolute; top:4px; left:' + Math.ceil(vTaskLeft * (vDayWidth) + 1) + 'px; height:18px; width:' + Math.ceil((vTaskRight) * (vDayWidth) - 1) + 'px">' +
                                '<div id=taskbar_' + vID + ' title="' + vTaskList[i].getName() + ': ' + vDateRowStr + '" class=gtask style="background-color:#' + vTaskList[i].getColor() + '; height: 13px; width:' + Math.ceil((vTaskRight) * (vDayWidth) - 1) + 'px; cursor: pointer;opacity:0.9;" ' +
                                'onclick=JSGantt.onClick("' + instanceName  +'",' + vID + ')>' +
                                '<div class=gcomplete style="z-index: -4; float:left; background-color:black; height:5px; overflow: auto; margin-top:4px; filter: alpha(opacity=40); opacity:0.4; width:' + vTaskList[i].getCompStr() + '; overflow:hidden">' +
                                '</div>' +
                                '</div>';

                        if (this.getCaptionType()) {
                            var vCaptionStr = '';
                            switch (this.getCaptionType()) {
                                case 'Caption':
                                    vCaptionStr = vTaskList[i].getCaption();
                                    break;
                                case 'Resource':
                                    vCaptionStr = vTaskList[i].getResource();
                                    break;
                                case 'Duration':
                                    vCaptionStr = vTaskList[i].getDuration(vFormat);
                                    break;
                                case 'Complete':
                                    vCaptionStr = vTaskList[i].getCompStr();
                                    break;
                            }
                            //vRightTable += '<div style="font-size:12px; position:absolute; left: 6px; top:-3px;">' + vCaptionStr + '</div>';
                            vRightTable += '<div style="font-size:12px; position:absolute; top:-3px; width:120px; left:' + (Math.ceil((vTaskRight) * (vDayWidth) - 1) + 6) + 'px">' + vCaptionStr + '</div>';
                        }
                        vRightTable += '</div>';
                    }
                }

                vRightTable += '</div>';
            }

            vMainTable += vRightTable + '</div></td></tr></tbody></table>'; //</body></html>

//            vDiv.innerHTML = vMainTable;
            vDiv.html(vMainTable);
        }

    }; //this.draw

    /**
     * Mouseover behaviour for gantt row
     * @method mouseOver
     * @return {void}
     */
    this.mouseOver = function(pObj, pID, pPos, pType) {
        var vID;
        if (pPos == 'right')  vID = 'child_' + pID;
        else vID = 'childrow_' + pID;

        pObj.bgColor = "#ffffaa";
        var vRowObj = JSGantt.findObj(vID);
        if (vRowObj) vRowObj.bgColor = "#ffffaa";
    };

    /**
     * Mouseout behaviour for gantt row
     * @method mouseOut
     * @return {void}
     */
    this.mouseOut = function(pObj, pID, pPos, pType) {
        var vID;
        if (pPos == 'right')  vID = 'child_' + pID;
        else vID = 'childrow_' + pID;

        pObj.bgColor = "#ffffff";
        var vRowObj = JSGantt.findObj(vID);
        if (vRowObj) {
            if (pType == "group") {
                pObj.bgColor = "#f3f3f3";
                vRowObj.bgColor = "#f3f3f3";
            } else {
                pObj.bgColor = "#ffffff";
                vRowObj.bgColor = "#ffffff";
            }
        }
    };

}; //GanttChart

/**
 *
 @class
 */

/**
 * Checks whether browser is IE
 *
 * @method isIE
 */
JSGantt.isIE = function () {
    return typeof document.all != 'undefined';
};

/**
 * Recursively process task tree ... set min, max dates of parent tasks and identfy task level.
 *
 * @method processRows
 * @param pList {Array} - Array of TaskItem Objects
 * @param pID {Number} - task ID
 * @param pRow {Number} - Row in chart
 * @param pLevel {Number} - Current tree level
 * @param pOpen {Boolean}
 * @return void
 */
JSGantt.processRows = function(pList, pID, pRow, pLevel, pOpen) {

    var vMinDate = new Date();
    var vMaxDate = new Date();
    var vMinSet = 0;
    var vMaxSet = 0;
    var vList = pList;
    var vLevel = pLevel;
    var i = 0;
    var vNumKid = 0;
    var vCompSum = 0;
    var vVisible = pOpen;

    for (i = 0; i < pList.length; i++) {
        if (pList[i].getParent() == pID) {
            vVisible = pOpen;
            pList[i].setVisible(vVisible);
            if (vVisible == 1 && pList[i].getOpen() == 0) {
                vVisible = 0;
            }

            pList[i].setLevel(vLevel);
            vNumKid++;

            if (pList[i].getGroup() == 1) {
                JSGantt.processRows(vList, pList[i].getID(), i, vLevel + 1, vVisible);
            }

            if (vMinSet == 0 || pList[i].getStart() < vMinDate) {
                vMinDate = pList[i].getStart();
                vMinSet = 1;
            }
            if (vMaxSet == 0 || pList[i].getEnd() > vMaxDate) {
                vMaxDate = pList[i].getEnd();
                vMaxSet = 1;
            }
            vCompSum += pList[i].getCompVal();
        }
    }

    if (pRow >= 0) {
        pList[pRow].setStart(vMinDate);
        pList[pRow].setEnd(vMaxDate);
        pList[pRow].setNumKid(vNumKid);
        pList[pRow].setCompVal(Math.ceil(vCompSum / vNumKid));
    }
};

/**
 * Determine the minimum date of all tasks and set lower bound based on format
 *
 * @method getMinDate
 * @param pList {Array} - Array of TaskItem Objects
 * @param pFormat {String} - current format (minute,hour,day...)
 * @return {Date}
 */
JSGantt.getMinDate = function getMinDate(pList, pFormat) {

    var vDate = new Date();

    vDate.setFullYear(pList[0].getStart().getFullYear(), pList[0].getStart().getMonth(), pList[0].getStart().getDate());

    // Parse all Task End dates to find min
    var i;
    for (i = 0; i < pList.length; i++) {
        if (Date.parse(pList[i].getStart()) < Date.parse(vDate))
            vDate.setFullYear(pList[i].getStart().getFullYear(), pList[i].getStart().getMonth(), pList[i].getStart().getDate());
    }

    if (pFormat == 'minute') {
        vDate.setHours(0);
        vDate.setMinutes(0);
    }
    else if (pFormat == 'hour') {
        vDate.setHours(0);
        vDate.setMinutes(0);
    }

    // Adjust min date to specific format boundaries (first of week or first of month)
    else if (pFormat == 'day') {
        vDate.setDate(vDate.getDate() - 1);
        while (vDate.getDay() % 7 > 0) {
            vDate.setDate(vDate.getDate() - 1);
        }
    }

    else if (pFormat == 'week') {
        vDate.setDate(vDate.getDate() - 7);
        while (vDate.getDay() % 7 > 0) {
            vDate.setDate(vDate.getDate() - 1);
        }
    }

    else if (pFormat == 'month') {
        while (vDate.getDate() > 1) {
            vDate.setDate(vDate.getDate() - 1);
        }
    }

    else if (pFormat == 'quarter') {
        if (vDate.getMonth() == 0 || vDate.getMonth() == 1 || vDate.getMonth() == 2) {
            vDate.setFullYear(vDate.getFullYear(), 0, 1);
        }
        else if (vDate.getMonth() == 3 || vDate.getMonth() == 4 || vDate.getMonth() == 5) {
            vDate.setFullYear(vDate.getFullYear(), 3, 1);
        }
        else if (vDate.getMonth() == 6 || vDate.getMonth() == 7 || vDate.getMonth() == 8) {
            vDate.setFullYear(vDate.getFullYear(), 6, 1);
        }
        else if (vDate.getMonth() == 9 || vDate.getMonth() == 10 || vDate.getMonth() == 11) {
            vDate.setFullYear(vDate.getFullYear(), 9, 1);
        }
    }
    return(vDate);
};

/**
 * Used to determine the minimum date of all tasks and set lower bound based on format
 *
 * @method getMaxDate
 * @param pList {Array} - Array of TaskItem Objects
 * @param pFormat {String} - current format (minute,hour,day...)
 * @return {Date}
 */
JSGantt.getMaxDate = function (pList, pFormat) {
    var vDate = new Date();

    vDate.setFullYear(pList[0].getEnd().getFullYear(), pList[0].getEnd().getMonth(), pList[0].getEnd().getDate());

    // Parse all Task End dates to find max
    var i;
    for (i = 0; i < pList.length; i++) {
        if (Date.parse(pList[i].getEnd()) > Date.parse(vDate)) {
            //vDate.setFullYear(pList[0].getEnd().getFullYear(), pList[0].getEnd().getMonth(), pList[0].getEnd().getDate());
            vDate.setTime(Number(Date.parse(pList[i].getEnd())));
        }
    }

    if (pFormat == 'minute') {
        vDate.setHours(vDate.getHours() + 1);
        vDate.setMinutes(59);
    }

    if (pFormat == 'hour') {
        vDate.setHours(vDate.getHours() + 2);
    }

    // Adjust max date to specific format boundaries (end of week or end of month)
    if (pFormat == 'day') {
        vDate.setDate(vDate.getDate() + 1);

        while (vDate.getDay() % 6 > 0) {
            vDate.setDate(vDate.getDate() + 1);
        }
    }

    if (pFormat == 'week') {
        //For weeks, what is the last logical boundary?
        vDate.setDate(vDate.getDate() + 11);

        while (vDate.getDay() % 6 > 0) {
            vDate.setDate(vDate.getDate() + 1);
        }
    }

    // Set to last day of current Month
    if (pFormat == 'month') {
        while (vDate.getDay() > 1) {
            vDate.setDate(vDate.getDate() + 1);
        }
        vDate.setDate(vDate.getDate() - 1);
    }

    // Set to last day of current Quarter
    if (pFormat == 'quarter') {
        if (vDate.getMonth() == 0 || vDate.getMonth() == 1 || vDate.getMonth() == 2)
            vDate.setFullYear(vDate.getFullYear(), 2, 31);
        else if (vDate.getMonth() == 3 || vDate.getMonth() == 4 || vDate.getMonth() == 5)
            vDate.setFullYear(vDate.getFullYear(), 5, 30);
        else if (vDate.getMonth() == 6 || vDate.getMonth() == 7 || vDate.getMonth() == 8)
            vDate.setFullYear(vDate.getFullYear(), 8, 30);
        else if (vDate.getMonth() == 9 || vDate.getMonth() == 10 || vDate.getMonth() == 11)
            vDate.setFullYear(vDate.getFullYear(), 11, 31);

    }

    return(vDate);
};

// todo Multiple charts on page
/**
 * Returns an object from the current DOM
 *
 * @method findObj
 * @param theObj {String} - Object name
 * @param theDoc {Document} - current document (DOM)
 * @return {Object}
 */
JSGantt.findObj = function (theObj, theDoc) {

    var p, i, foundObj;

    if (!theDoc) {
        theDoc = document;
    }

    if ((p = theObj.indexOf("?")) > 0 && parent.frames.length) {
        theDoc = parent.frames[theObj.substring(p + 1)].document;
        theObj = theObj.substring(0, p);
    }

    if (!(foundObj = theDoc[theObj]) && theDoc.all) {
        foundObj = theDoc.all[theObj];
    }

    for (i = 0; !foundObj && i < theDoc.forms.length; i++) {
        foundObj = theDoc.forms[i][theObj];
    }

    for (i = 0; !foundObj && theDoc.layers && i < theDoc.layers.length; i++) {
        foundObj = JSGantt.findObj(theObj, theDoc.layers[i].document);
    }

    if (!foundObj && document.getElementById) {
        foundObj = document.getElementById(theObj);
    }

    return foundObj;
};

/**
 * Change display format of current gantt chart
 *
 * @method changeFormat
 * @param pFormat {String} - Current format (minute,hour,day...)
 * @param instanceName {String} - Instance key
 * @return {void}
 */
JSGantt.changeFormat = function(pFormat, instanceName) {
    var ganttObj = JSGantt.instances[instanceName];
    if (ganttObj) {
        ganttObj.setFormat(pFormat);
        ganttObj.DrawDependencies();
    }
    else {
        alert('Chart undefined');
    }
};

/**
 * Mouse over handler for instance
 *
 * @method mouseOver
 * @param instanceKey Key of GanttChart instance
 * @param pObj DOM object
 * @param pID Object id
 * @param pPos Postion
 * @param pType Type
 * @return {void}
 */
JSGantt.mouseOver = function(instanceKey, pObj, pID, pPos, pType) {
    var instance = JSGantt.instances[instanceKey];
    instance.mouseOver(pObj, pID, pPos, pType);
};

/**
 * Mouse out handler for instance
 *
 * @method mouseOut
 * @param instanceKey Key of GanttChart instance
 * @param pObj DOM object
 * @param pID Object id
 * @param pPos Postion
 * @param pType Type
 * @return {void}
 */
JSGantt.mouseOut = function(instanceKey, pObj, pID, pPos, pType) {
    var instance = JSGantt.instances[instanceKey];
    instance.mouseOut(pObj, pID, pPos, pType);
};

/**
 * DrawDependencies for instance
 *
 * @method DrawDependencies
 * @param instanceName {String} - Instance key
 * @return {void}
 */
JSGantt.DrawDependencies = function (instanceName) {
    var ganttObj = JSGantt.instances[instanceName];
    ganttObj.DrawDependencies();
};

/**
 * Open/Close and hide/show children of specified task
 *
 * @method folder
 * @param pID {Number} - Task ID
 * @param instanceName {String} - Instance key
 * @return {void}
 */
JSGantt.folder = function (pID, instanceName) {
    var ganttObj = JSGantt.instances[instanceName];
    var vList = ganttObj.getList();

    var i;
    for (i = 0; i < vList.length; i++) {
        if (vList[i].getID() == pID) {

            if (vList[i].getOpen() == 1) {
                vList[i].setOpen(0);
                JSGantt.hide(pID, ganttObj);

                if (JSGantt.isIE()) {
                    JSGantt.findObj('group_' + pID).innerText = '+';
                }
                else {
                    JSGantt.findObj('group_' + pID).textContent = '+';
                }

            } else {

                vList[i].setOpen(1);

                JSGantt.show(pID, 1, ganttObj);

                if (JSGantt.isIE()) {
                    JSGantt.findObj('group_' + pID).innerText = '–';
                }
                else {
                    JSGantt.findObj('group_' + pID).textContent = '–';
                }

            }

        }
    }
};

/**
 * Hide children of a task
 *
 * @method hide
 * @param pID {Number} - Task ID
 * @param ganttObj {GanttChart} - The gantt object
 * @return {void}
 */
JSGantt.hide = function (pID, ganttObj) {
    var vList = ganttObj.getList();
    var vID = 0;

    for (var i = 0; i < vList.length; i++) {
        if (vList[i].getParent() == pID) {
            vID = vList[i].getID();
            JSGantt.findObj('child_' + vID).style.display = "none";
            JSGantt.findObj('childgrid_' + vID).style.display = "none";
            vList[i].setVisible(0);
            if (vList[i].getGroup() == 1) {
                JSGantt.hide(vID, ganttObj);
            }
        }
    }
};

/**
 * Show children of a task
 *
 * @method show
 * @param pID {Number} - Task ID
 * @param ganttObj {GanttChart} - The gantt object
 * @return {void}
 */
JSGantt.show = function (pID, pTop, ganttObj) {
    var vList = ganttObj.getList();
    var vID = 0;

    for (var i = 0; i < vList.length; i++) {
        if (vList[i].getParent() == pID) {
            vID = vList[i].getID();
            if (pTop == 1) {
                if (JSGantt.isIE()) { // IE;
                    if (JSGantt.findObj('group_' + pID).innerText == '+') {
                        JSGantt.findObj('child_' + vID).style.display = "";
                        JSGantt.findObj('childgrid_' + vID).style.display = "";
                        vList[i].setVisible(1);
                    }
                } else {
                    if (JSGantt.findObj('group_' + pID).textContent == '+') {
                        JSGantt.findObj('child_' + vID).style.display = "";
                        JSGantt.findObj('childgrid_' + vID).style.display = "";
                        vList[i].setVisible(1);
                    }
                }

            } else {
                if (JSGantt.isIE()) { // IE;
                    if (JSGantt.findObj('group_' + pID).innerText == '–') {
                        JSGantt.findObj('child_' + vID).style.display = "";
                        JSGantt.findObj('childgrid_' + vID).style.display = "";
                        vList[i].setVisible(1);
                    }
                } else {
                    if (JSGantt.findObj('group_' + pID).textContent == '–') {
                        JSGantt.findObj('child_' + vID).style.display = "";
                        JSGantt.findObj('childgrid_' + vID).style.display = "";
                        vList[i].setVisible(1);
                    }
                }
            }

            if (vList[i].getGroup() == 1) {
                JSGantt.show(vID, 0, ganttObj);
            }
        }
    }
};

JSGantt.onClick = function(pInstanceName, pID) {
    var instance = JSGantt.instances[pInstanceName];
    if (instance) {
        var vList = instance.getList();
        var i;
        for (i = 0; i < vList.length; i++) {
            if (vList[i].getID() == pID) {
                instance.clickOnTask(vList[i]);
            }
        }
    }
};

/**
 * Parse dates based on gantt date format setting as defined in JSGantt.GanttChart.setDateInputFormat()
 *
 * @method parseDateStr
 * @param pDateStr {String} - A string that contains the date (i.e. "01/01/09")
 * @param pFormatStr {String} - The date format (mm/dd/yyyy,dd/mm/yyyy,yyyy-mm-dd)
 * @return {Date}
 */
JSGantt.parseDateStr = function(pDateStr, pFormatStr) {
    var vDate = new Date();
    vDate.setTime(Date.parse(pDateStr));

    switch (pFormatStr) {
        case 'mm/dd/yyyy':
            var vDateParts = pDateStr.split('/');
            vDate.setFullYear(parseInt(vDateParts[2], 10), parseInt(vDateParts[0], 10) - 1, parseInt(vDateParts[1], 10));
            break;
        case 'dd/mm/yyyy':
            var vDateParts = pDateStr.split('/');
            vDate.setFullYear(parseInt(vDateParts[2], 10), parseInt(vDateParts[1], 10) - 1, parseInt(vDateParts[0], 10));
            break;
        case 'yyyy-mm-dd':
            var vDateParts = pDateStr.split('-');
            vDate.setFullYear(parseInt(vDateParts[0], 10), parseInt(vDateParts[1], 10) - 1, parseInt(vDateParts[1], 10));
            break;
    }

    return(vDate);

};

/**
 * Display a formatted date based on gantt date format setting as defined in JSGantt.GanttChart.setDateDisplayFormat()
 *
 * @method formatDateStr
 * @param pDate {Date} - A javascript date object
 * @param pFormatStr {String} - The date format (mm/dd/yyyy,dd/mm/yyyy,yyyy-mm-dd...)
 * @return {String}
 */
JSGantt.formatDateStr = function(pDate, pFormatStr) {
    var vYear4Str = pDate.getFullYear() + '';
    var vYear2Str = vYear4Str.substring(2, 4);
    var vMonthStr = (pDate.getMonth() + 1) + '';
    var vDayStr = pDate.getDate() + '';

    var vDateStr = '';

    switch (pFormatStr) {
        case 'mm/dd/yyyy':
            return( vMonthStr + '/' + vDayStr + '/' + vYear4Str );
        case 'dd/mm/yyyy':
            return( vDayStr + '/' + vMonthStr + '/' + vYear4Str );
        case 'yyyy-mm-dd':
            return( vYear4Str + '-' + vMonthStr + '-' + vDayStr );
        case 'mm/dd/yy':
            return( vMonthStr + '/' + vDayStr + '/' + vYear2Str );
        case 'dd/mm/yy':
            return( vDayStr + '/' + vMonthStr + '/' + vYear2Str );
        case 'yy-mm-dd':
            return( vYear2Str + '-' + vMonthStr + '-' + vDayStr );
        case 'mm/dd':
            return( vMonthStr + '/' + vDayStr );
        case 'dd/mm':
            return( vDayStr + '/' + vMonthStr );
    }
    return '';
};

/**
 * Parse an external XML file containing task items.
 *
 * @method parseXML
 * @param ThisFile {String} - URL to XML file
 * @param instanceName {String} - Instance key
 * @return {void}
 */
JSGantt.parseXML = function(ThisFile, instanceName) {
    var pGanttVar = JSGantt.instances[instanceName];
    var is_chrome = navigator.userAgent.toLowerCase().indexOf('chrome') > -1;   // Is this Chrome 

    var xmlDoc;
    try { //Internet Explorer
        xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
    }
    catch(e) {
        try { //Firefox, Mozilla, Opera, Chrome etc. 
            if (!is_chrome) {
                xmlDoc = document.implementation.createDocument("", "", null);
            }
        }
        catch(e) {
            alert(e.message);
            return;
        }
    }

    if (!is_chrome) {     // can't use xmlDoc.load in chrome at the moment
        xmlDoc.async = false;
        xmlDoc.load(ThisFile);		// we can use  loadxml
        JSGantt.AddXMLTask(pGanttVar);
        xmlDoc = null;			// a little tidying
        Task = null;
    }
    else {
        JSGantt.ChromeLoadXML(ThisFile, pGanttVar);
        ta = null;	// a little tidying	
    }
};

/**
 * Add a task based on parsed XML doc
 *
 * @method AddXMLTask
 * @param pGanttVar {Gantt} - Gantt object
 * @return {void}
 */
JSGantt.AddXMLTask = function(pGanttVar) {

    var Task = xmlDoc.getElementsByTagName("task");

    // the number of tasks. IE gets this right, but mozilla add extra ones (Whitespace)
    var n = xmlDoc.documentElement.childNodes.length;

    for (var i = 0; i < n; i++) {
        // optional parameters may not have an entry (Whitespace from mozilla also returns an error )
        // Task ID must NOT be zero other wise it will be skipped
        var pID;
        try {
            pID = Task[i].getElementsByTagName("pID")[0].childNodes[0].nodeValue;
        } catch (error) {
            pID = 0;
        }
        // make sure that these are numbers rather than strings in order to make jsgantt.js behave as expected.
        pID *= 1;

        if (pID != 0) {
            var pName;
            try {
                pName = Task[i].getElementsByTagName("pName")[0].childNodes[0].nodeValue;
            } catch (error) {
                pName = "No Task Name";
            }			// If there is no corresponding entry in the XML file the set a default.

            var pColor;
            try {
                pColor = Task[i].getElementsByTagName("pColor")[0].childNodes[0].nodeValue;
            } catch (error) {
                pColor = "0000ff";
            }

            var pParent;
            try {
                pParent = Task[i].getElementsByTagName("pParent")[0].childNodes[0].nodeValue;
            } catch (error) {
                pParent = 0;
            }
            pParent *= 1;

            var pStart;
            try {
                pStart = Task[i].getElementsByTagName("pStart")[0].childNodes[0].nodeValue;
            } catch (error) {
                pStart = "";
            }

            var pEnd;
            try {
                pEnd = Task[i].getElementsByTagName("pEnd")[0].childNodes[0].nodeValue;
            } catch (error) {
                pEnd = "";
            }

            var pMile;
            try {
                pMile = Task[i].getElementsByTagName("pMile")[0].childNodes[0].nodeValue;
            } catch (error) {
                pMile = 0;
            }
            pMile *= 1;

            var pRes;
            try {
                pRes = Task[i].getElementsByTagName("pRes")[0].childNodes[0].nodeValue;
            } catch (error) {
                pRes = "";
            }

            var pComp;
            try {
                pComp = Task[i].getElementsByTagName("pComp")[0].childNodes[0].nodeValue;
            } catch (error) {
                pComp = 0;
            }
            pComp *= 1;

            var pGroup;
            try {
                pGroup = Task[i].getElementsByTagName("pGroup")[0].childNodes[0].nodeValue;
            } catch (error) {
                pGroup = 0;
            }
            pGroup *= 1;

            var pOpen;
            try {
                pOpen = Task[i].getElementsByTagName("pOpen")[0].childNodes[0].nodeValue;
            } catch (error) {
                pOpen = 1;
            }
            pOpen *= 1;

            var pDepend;
            try {
                pDepend = Task[i].getElementsByTagName("pDepend")[0].childNodes[0].nodeValue;
            } catch (error) {
                pDepend = 0;
            }
            //pDepend *= 1;
            if (pDepend.length == 0) {
                pDepend = ''
            } // need this to draw the dependency lines

            var pCaption;
            try {
                pCaption = Task[i].getElementsByTagName("pCaption")[0].childNodes[0].nodeValue;
            } catch (error) {
                pCaption = "";
            }

            // Finally add the task
            pGanttVar.AddTaskItem(new JSGantt.TaskItem(pID, pName, pStart, pEnd, pColor, "", pMile, pRes, pComp, pGroup, pParent, pOpen, pDepend, pCaption));
        }
    }
};

/**
 * Load an XML document in Chrome
 *
 * @method ChromeLoadXML
 * @param ThisFile {String} - URL to XML file
 * @param pGanttVar {Gantt} - Gantt object
 * @return {void}
 */
JSGantt.ChromeLoadXML = function(ThisFile, pGanttVar) {
// Thanks to vodobas at mindlence,com for the initial pointers here.
    var XMLLoader = new XMLHttpRequest();
    XMLLoader.onreadystatechange = function() {
        JSGantt.ChromeXMLParse(pGanttVar);
    };
    XMLLoader.open("GET", ThisFile, false);
    XMLLoader.send(null);
};

/**
 * Parse XML document in Chrome
 *
 * @method ChromeXMLParse
 * @param pGanttVar {GanttChart} - Gantt object
 * @return {void}
 */
JSGantt.ChromeXMLParse = function (pGanttVar) {
    // Manually parse the file as it is loads quicker
    if (XMLLoader.readyState == 4) {
        var ta = XMLLoader.responseText.split(/<task>/gi);

        var n = ta.length;	// the number of tasks. 
        for (var i = 1; i < n; i++) {
            var Task = ta[i].replace(/<[/]p/g, '<p');
            var te = Task.split(/<pid>/i);

            var pID;
            if (te.length > 2) {
                pID = te[1];
            } else {
                pID = 0;
            }
            pID *= 1;

            te = Task.split(/<pName>/i);
            var pName;
            if (te.length > 2) {
                pName = te[1];
            } else {
                pName = "No Task Name";
            }

            te = Task.split(/<pstart>/i);
            var pStart;
            if (te.length > 2) {
                pStart = te[1];
            } else {
                pStart = "";
            }

            te = Task.split(/<pEnd>/i);
            var pEnd;
            if (te.length > 2) {
                pEnd = te[1];
            } else {
                pEnd = "";
            }

            te = Task.split(/<pColor>/i);
            var pColor;
            if (te.length > 2) {
                pColor = te[1];
            } else {
                pColor = '0000ff';
            }

            te = Task.split(/<pMile>/i);
            var pMile;
            if (te.length > 2) {
                pMile = te[1];
            } else {
                pMile = 0;
            }
            pMile *= 1;

            te = Task.split(/<pRes>/i);
            var pRes;
            if (te.length > 2) {
                pRes = te[1];
            } else {
                pRes = "";
            }

            te = Task.split(/<pComp>/i);
            var pComp;
            if (te.length > 2) {
                pComp = te[1];
            } else {
                pComp = 0;
            }
            pComp *= 1;

            te = Task.split(/<pGroup>/i);
            var pGroup;
            if (te.length > 2) {
                pGroup = te[1];
            } else {
                pGroup = 0;
            }
            pGroup *= 1;

            te = Task.split(/<pParent>/i);
            var pParent;
            if (te.length > 2) {
                pParent = te[1];
            } else {
                pParent = 0;
            }
            pParent *= 1;

            te = Task.split(/<pOpen>/i);
            var pOpen;
            if (te.length > 2) {
                pOpen = te[1];
            } else {
                pOpen = 1;
            }
            pOpen *= 1;

            te = Task.split(/<pDepend>/i);
            var pDepend;
            if (te.length > 2) {
                pDepend = te[1];
            } else {
                pDepend = "";
            }
            //pDepend *= 1;
            if (pDepend.length == 0) {
                pDepend = ''
            } // need this to draw the dependency lines

            te = Task.split(/<pCaption>/i);
            var pCaption;
            if (te.length > 2) {
                pCaption = te[1];
            } else {
                pCaption = "";
            }

            // Finally add the task
            pGanttVar.AddTaskItem(new JSGantt.TaskItem(pID, pName, pStart, pEnd, pColor, "", pMile, pRes, pComp, pGroup, pParent, pOpen, pDepend, pCaption));
        }
    }
};

/**
 * Used for benchmarking performace
 *
 * @method benchMark
 * @param pItem {TaskItem} - TaskItem object
 * @return {void}
 */
JSGantt.benchMark = function(pItem) {
    var vEndTime = new Date().getTime();
    alert(pItem + ': Elapsed time: ' + ((vEndTime - vBenchTime) / 1000) + ' seconds.');
    vBenchTime = new Date().getTime();
};