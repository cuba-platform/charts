/*
 * Copyright (c) 2008-2019 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package spec.charts.web.pivottable

import com.haulmont.charts.gui.components.pivot.PivotTable
import com.haulmont.charts.web.gui.components.pivottable.PivotExcelExporter
import com.haulmont.charts.web.gui.components.pivottable.WebPivotTable
import com.haulmont.charts.web.widgets.pivottable.serialization.PivotTableSerializer
import com.haulmont.cuba.gui.export.ExportDisplay
import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.ss.usermodel.CellType
import spock.lang.Specification

class ExcelExporterTest extends Specification {

    def serializer = Mock(PivotTableSerializer.class)

    def pivotData
    def pivotTable = new TestPivotTable()

    def CUSTOM_FILENAME = "customFileName"
    def rowsCount = 8
    def cellsCount = 10
    def mergedRegionsCount = 17

    void setup() {
        def json = PivotTableHelper.readFile('pivotDataJson.json')
        pivotData = PivotTableHelper.getPivotData(json)
    }

    def "test file name"() {
        given: "create PivotExcelExporter"
        TestPivotExcelExporter exporter = new TestPivotExcelExporter(pivotTable)

        when: "set custom file name"
        exporter.exportPivotTable(pivotData, CUSTOM_FILENAME)
        then:
        exporter.fileName == CUSTOM_FILENAME

        when: "test default file name"
        exporter.fileName = null
        exporter.metaClass = null
        exporter.exportPivotTable(pivotData, null)
        then:
        exporter.fileName == exporter.DEFAULT_FILE_NAME
    }

    def "test generated sheet count values"() {
        given: "created PivotExcelExporter"
        TestPivotExcelExporter exporter = new TestPivotExcelExporter(pivotTable)

        when: "generate sheet"
        exporter.exportPivotTable(pivotData, null)
        then:
        exporter.sheet.getLastRowNum() == rowsCount - 1
        exporter.sheet.getNumMergedRegions() == mergedRegionsCount
    }

    def "test header cells type"() {
        given: "created PivotExcelExporter"
        TestPivotExcelExporter exporter = new TestPivotExcelExporter(pivotTable)

        when: "generate sheet"
        exporter.exportPivotTable(pivotData, null)
        then:
        for (int i = 0; i < 3; i++) {
            HSSFRow row = exporter.sheet.getRow(i)
            for (int j = 0; j < cellsCount; j++) {
                HSSFCell cell = row.getCell(j)
                if ((i == 0 || i == 1) && (j == 0 || j == 1)
                        || (i == 2 && j == 2)) {
                    assert cell.getCellTypeEnum() == CellType.BLANK
                    continue
                }

                assert cell.getCellTypeEnum() == CellType.STRING
                assert cell.getCellStyle().getFont(exporter.wb).bold
            }
        }
    }

    def "check body cells type"() {
        given: "created PivotExcelExporter"
        TestPivotExcelExporter exporter = new TestPivotExcelExporter(pivotTable)

        when: "generate sheet"
        exporter.exportPivotTable(pivotData, null)
        then:
        for (int i = 3; i < rowsCount; i++) {
            HSSFRow row = exporter.sheet.getRow(i)
            for (int j = 0; j < cellsCount; j++) {
                HSSFCell cell = row.getCell(j)
                if (0 <= j && j < 3) {
                    assert cell.getCellTypeEnum() == CellType.STRING
                    assert cell.getCellStyle().getFont(exporter.wb).bold
                    continue
                }

                if (((3 < i && i < 7) && j == 3) || (i == 5 && j == 6)) {
                    assert cell.getCellTypeEnum() == CellType.BLANK
                    continue
                }

                cell.getCellTypeEnum() == CellType.NUMERIC
                if (j == 9 || i == 7) {
                    assert cell.getCellStyle().getFont(exporter.wb).bold
                }
            }
        }
    }

    class TestPivotExcelExporter extends PivotExcelExporter {

        TestPivotExcelExporter(PivotTable pivotTable) {
            super(pivotTable)
        }

        @Override
        protected void export(ExportDisplay display) {
            //do nothing
        }

        @Override
        protected void initNotifications(PivotTable pivotTable) {
            //do nothing
        }
    }

    class TestPivotTable extends WebPivotTable {

        @Override
        protected PivotTableSerializer createPivotTableSerializer() {
            return serializer
        }
    }
}
