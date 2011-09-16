/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.charts.web.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
@Controller
public class ChartRenderingController {

    private static Log log = LogFactory.getLog(ChartRenderingController.class);

    @RequestMapping(value = "/render", method = RequestMethod.GET)
    public ModelAndView render(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {

        // Handle chart requests

        return null;
    }
}