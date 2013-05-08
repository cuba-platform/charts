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
import java.net.MalformedURLException;
import java.net.URL;

/**
 * <p>$Id$</p>
 *
 * @author artamonov
 */
@Controller
public class ChartRenderingController {

    private static Log log = LogFactory.getLog(ChartRenderingController.class);

    public final static String RENDERING_URL = "chart";

    @RequestMapping(value = "/" + RENDERING_URL, method = RequestMethod.GET)
    public ModelAndView render(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {

        // Handle chart requests
//        vaadin7
//        if (request.getSession() == null) {
//            accessDenied(response);
//            return null;
//        }
//
//        String chartId = request.getParameter("id");
//        if (chartId == null) {
//            badRequest(response);
//            return null;
//        }
//
//        UserSession userSession = ControllerUtils.getUserSession(request);
//        if (userSession == null) {
//            badRequest(response);
//            return null;
//        }
//
//        CubaApplicationContext context = CubaApplicationContext.getApplicationContext(request.getSession());
//        Application application = findApplication(request, context);
//        if (application == null) {
//            badRequest(response);
//            return null;
//        }
//        CubaCommunicationManager communicationManager = (CubaCommunicationManager) context.getCommunicationManager(application);
//
//        WChart chart = (WChart) communicationManager.getVariableComponent(chartId);
//        if (chart == null) {
//            log.warn(String.format("Non-existent chart component, VAR_PID=%s", chartId));
//            internalError(response);
//            return null;
//        }
//
//        AppContext.setSecurityContext(new SecurityContext(userSession));
//
//        String vendor = chart.getVendor();
//        VChartDataProvider dataProvider = ChartDataProviderFactory.getDataProvider(vendor);
//
//        try {
//            dataProvider.handleDataRequest(request, response, chart);
//            response.setStatus(HttpServletResponse.SC_OK);
//        } catch (ChartException e) {
//            internalError(response);
//            return null;
//        }
//
//        AppContext.setSecurityContext(null);

        return null;
    }

    private URL getApplicationUrl(HttpServletRequest request)
            throws MalformedURLException {
        final URL reqURL = new URL(
                (request.isSecure() ? "https://" : "http://")
                        + request.getServerName()
                        + ((request.isSecure() && request.getServerPort() == 443)
                        || (!request.isSecure() && request
                        .getServerPort() == 80) ? "" : ":"
                        + request.getServerPort())
                        + request.getRequestURI());
        String servletPath;
        if (request.getAttribute("javax.servlet.include.servlet_path") != null) {
            // this is an include request
            servletPath = request.getAttribute(
                    "javax.servlet.include.context_path").toString()
                    + request
                    .getAttribute("javax.servlet.include.servlet_path");

        } else {
            servletPath = request.getContextPath() + request.getServletPath();
        }

        if (servletPath.length() == 0
                || servletPath.charAt(servletPath.length() - 1) != '/') {
            servletPath = servletPath + "/";
        }
        return new URL(reqURL, servletPath);
    }

//    private Object findApplication(HttpServletRequest request, CubaApplicationContext context) {
        // Gets application list for the session.
//        vaadin7
//        final Collection<Application> applications = context.getApplications();
//
//        // Search for the application (using the application URI) from the list
//        for (final Application sessionApplication : applications) {
//            final String sessionApplicationPath = sessionApplication.getURL().getPath();
//
//            String requestApplicationPath;
//            try {
//                requestApplicationPath = getApplicationUrl(request).getPath();
//            } catch (MalformedURLException e) {
//                return null;
//            }
//
//            if (requestApplicationPath.startsWith(sessionApplicationPath)) {
//                // Found a running application
//                if (sessionApplication.isRunning()) {
//                    return sessionApplication;
//                }
//                break;
//            }
//        }
//        return null;
//    }

    /**
     * Set response status to SC_UNAUTHORIZED
     *
     * @param response Response
     */
    public void accessDenied(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }

    /**
     * Set response status to SC_INTERNAL_SERVER_ERROR
     *
     * @param response Response
     */
    public void internalError(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }

    /**
     * Set response status to SC_BAD_REQUEST
     *
     * @param response Response
     */
    public void badRequest(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
}