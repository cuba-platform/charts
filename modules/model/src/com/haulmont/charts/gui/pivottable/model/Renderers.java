/*
 * Copyright (c) 2008-2018 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package com.haulmont.charts.gui.pivottable.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Configuration of renderers. Use when {@link PivotTableModel#editable} is set to {@code true}.
 */
public class Renderers extends AbstractPivotObject {
    private static final long serialVersionUID = 3073573008851609082L;

    /**
     * A list which will be converted to a dictionary of rendering functions.
     */
    private List<Renderer> renderers;

    /**
     * One of predefined renderers, which name will be
     * converted to {@code rendererName} - an renderer to
     * prepopulate in dropdown i.e. key to {@code renderers} object.
     */
    private Renderer defaultRenderer;

    public List<Renderer> getRenderers() {
        return renderers;
    }

    public Renderers setRenderers(List<Renderer> renderers) {
        this.renderers = renderers;
        return this;
    }

    public Renderers addRenderers(Renderer... renderers) {
        if (renderers != null) {
            if (this.renderers == null) {
                this.renderers = new ArrayList<>();
            }
            this.renderers.addAll(Arrays.asList(renderers));
        }
        return this;
    }

    public Renderer getDefaultRenderer() {
        return defaultRenderer;
    }

    public Renderers setDefaultRenderer(Renderer defaultRenderer) {
        this.defaultRenderer = defaultRenderer;
        return this;
    }
}
