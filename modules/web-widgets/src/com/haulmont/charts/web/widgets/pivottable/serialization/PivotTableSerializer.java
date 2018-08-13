package com.haulmont.charts.web.widgets.pivottable.serialization;

import com.haulmont.charts.gui.pivottable.model.PivotTableModel;

import javax.annotation.Nullable;

public interface PivotTableSerializer {

    String serialize(PivotTableModel pivotTable);

    @Nullable
    String serializeData(PivotTableModel pivotTable);

    String toJson(Object value);
}
