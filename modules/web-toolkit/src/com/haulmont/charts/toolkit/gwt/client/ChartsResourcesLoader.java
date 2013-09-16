/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */
package com.haulmont.charts.toolkit.gwt.client;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.user.client.Window;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;

/**
 * Manager for dynamic resources
 */
public class ChartsResourcesLoader {

    private static Set<String> alreadyInjected;

    private static String getAbsoluteSource(String host, String appUri, String path) {
        appUri = (appUri == null) ? "" : appUri;
        path = (path == null) ? "" : path;
        String src = "";
        if (host != null) {
            src = getProtocol() + "//" + host;
        }
        src += appUri + (appUri.endsWith("/") ? "" : "/") + "VAADIN/resources" + path;
        return src;
    }

    public static boolean injectCss(@Nullable String host, String appUri, String path) {
        String src = getAbsoluteSource(host, appUri, path);
        if (alreadyInjected != null && alreadyInjected.contains(src)) {
            return false;
        }

        includeCss(src + (src.contains("?") ? "&" : "?") + System.currentTimeMillis());

        if (alreadyInjected == null) {
            alreadyInjected = new HashSet<String>();
        }
        alreadyInjected.add(src);
        return true;
    }

    private static native void includeCss(String path) /*-{
        $wnd.jQuery(document).ready(function() {
            var styleElement = $doc.createElement('link');
            styleElement.setAttribute('rel', 'stylesheet');
            styleElement.setAttribute('href', path);
            $doc.getElementsByTagName('head')[0].appendChild(styleElement);
        });
    }-*/;

    public static boolean injectJs(@Nullable String host, String appUri, String path) {
        String src = getAbsoluteSource(host, appUri, path);
        if (alreadyInjected != null && alreadyInjected.contains(src)) {
            return false;
        }

        Document doc = Document.get();
        ScriptElement script = doc.createScriptElement();
        script.setSrc(src + (src.contains("?") ? "&" : "?") + System.currentTimeMillis());
        script.setType("text/javascript");

        HeadElement head = doc.getElementsByTagName("head").getItem(0).cast();
        head.appendChild(script);

        if (alreadyInjected == null) {
            alreadyInjected = new HashSet<String>();
        }
        alreadyInjected.add(src);
        return true;
    }

    public static boolean injectJs(String appUri, String path) {
        return injectJs(null, appUri, path);
    }

    public static boolean injectCss(String appUri, String path) {
        return injectCss(null, appUri, path);
    }

    private static String getProtocol() {
        if (Window.Location.getProtocol().equals("https:")) {
            return "https:";
        }
        return "http:";
    }
}