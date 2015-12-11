/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.charts.gui.amcharts.model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

/**
 * @author gorelov
 * @version $Id$
 */
public class SerializationTest {

    protected SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    protected String readFile(String fileName) throws IOException, URISyntaxException {
        URL resource = getClass().getResource("/com/haulmont/charts/gui/amcharts/model/" + fileName);
        byte[] encoded = Files.readAllBytes(Paths.get(resource.toURI()));
        return new String(encoded, StandardCharsets.UTF_8);
    }
}
