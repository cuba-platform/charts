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

package com.haulmont.charts.web.widgets.client.amcharts;

import com.haulmont.charts.web.widgets.amcharts.CubaAmchartsResponsiveIntegration;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.shared.ui.Connect;

@Connect(CubaAmchartsResponsiveIntegration.class)
public class CubaAmchartsResponsiveIntegrationConnector extends AbstractExtensionConnector {
    @Override
    protected void extend(ServerConnector target) {
        // do nothing
        // this extension simply adds JavaScript include
    }
}