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

package com.haulmont.charts.web.widgets.client.pivottable.extension;

import com.google.gwt.core.client.JavaScriptObject;

public class JsPivotExtensionOptions extends JavaScriptObject {

    protected JsPivotExtensionOptions() {
    }

    public static JsPivotExtensionOptions get() {
        return JavaScriptObject.createObject().cast();
    }

    public final native void setDateTimeParseFormat(JsPivotExtensionOptions config, String format) /*-{
        config.dateTimeParseFormat = format;
    }-*/ ;

    public final native void setDateParseFormat(JsPivotExtensionOptions config, String format) /*-{
        config.dateParseFormat = format;
    }-*/ ;

    public final native void setTimeParseFormat(JsPivotExtensionOptions config, String format) /*-{
        config.timeParseFormat = format;
    }-*/ ;
}
