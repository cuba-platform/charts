/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.components.pivot;

import com.haulmont.charts.gui.pivottable.extentsion.model.PivotData;
import com.haulmont.cuba.gui.export.ExportDisplay;

public interface PivotTableExtension {

    /**
     * Exports PivotTable to Xls file.
     */
    void exportTableToXls();

    /**
     * Exports PivotTable to Xls file.
     *
     * @param display export display to save file
     */
    void exportTableToXls(ExportDisplay display);

    /**
     * Sets the file name.
     *
     * @param fileName file name
     */
    void setFileName(String fileName);

    /**
     * @return file name
     */
    String getFileName();

    /**
     * @return JSON string which represents PivotTable with aggregated data
     */
    String getPivotDataJSON();

    /**
     * @return serialized object from JSON which represents PivotTable with aggregated data
     */
    PivotData getPivotData();
}
