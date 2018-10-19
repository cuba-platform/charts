/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package spec.charts.web.pivottable

import com.google.gson.Gson
import com.haulmont.charts.gui.pivottable.extentsion.model.PivotData

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

class PivotTableHelper {

    static final Gson gson = new Gson()

    static String readFile(String fileName) throws IOException, URISyntaxException {
        URL resource = PivotTableHelper.class.getResource("/spec/charts/web/pivottable/" + fileName)
        byte[] encoded = Files.readAllBytes(Paths.get(resource.toURI()))
        return new String(encoded, StandardCharsets.UTF_8)
    }

    static PivotData getPivotData(String json) {
        return gson.fromJson(json, PivotData.class)
    }
}
