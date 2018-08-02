/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.web.toolkit.ui.client.pivottable.extension;

import com.google.gwt.dom.client.Element;

public class CubaPivotTableExtensionJsOverlay {

    protected Element pivotElement;

    public CubaPivotTableExtensionJsOverlay(Element pivotElement) {
        this.pivotElement = pivotElement;
    }

    public String getPivotDataJSON() {
        return getPivotDataJSON(pivotElement);
    }

    public static native String getPivotDataJSON(Element pivotElement) /*-{
        var tableElements = pivotElement.getElementsByClassName('pvtTable');
        if (tableElements.length === 0) {
            return;
        }

        var table = tableElements[0];

        var resultObject = {};
        resultObject.dataNumRows = table.attributes['data-numrows'] ? table.attributes['data-numrows'].value : null;
        resultObject.dataNumCols = table.attributes['data-numcols'] ? table.attributes['data-numcols'].value : null;

        var boldClassNames = ['pvtTotal rowTotal', 'pvtTotal colTotal', 'pvtGrandTotal'];

        var isNumeric = function(num){
            return !isNaN(num)
        }

        // appendIndex needs to set the original order of rows in json
        var getRowsAndCells = function (tableRows, appendIndex) {
            var rows = [];
            for (var i = 0; i < tableRows.length; i++) {
                var tableRow = tableRows[i];

                var row = {};
                row.tableRowNumber = i + appendIndex;
                row.cells = [];

                for (var j = 0; j < tableRow.cells.length; j++) {
                    var rowCell = tableRow.cells[j];

                    var cell = {};

                    // check for bold
                    if (rowCell.nodeName === 'TH' || boldClassNames.indexOf(rowCell.className) > -1) {
                        cell.isBold = true;
                    } else {
                        cell.isBold = false;
                    }

                    if (rowCell.className) {
                        cell.className = rowCell.className;
                    }

                    cell.colSpan = rowCell.colSpan;
                    cell.rowSpan = rowCell.rowSpan;

                    if (rowCell.outerText) {
                        cell.value = rowCell.outerText;
                    }

                    // check for numeric or string
                    if (isNumeric(cell.value)) {
                        cell.type = 'NUMERIC'
                    } else {
                        cell.type = 'STRING'
                    }

                    row.cells.push(cell);
                }
                rows.push(row);
            }
            return rows;
        };

        var tableHead = table.tHead;
        resultObject.headRows = getRowsAndCells(tableHead.rows, 0);

        var tableBody = table.tBodies[0];
        resultObject.bodyRows = getRowsAndCells(tableBody.rows, resultObject.headRows.length);

        return JSON.stringify(resultObject);
    }-*/;
}
