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
