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

    private List<Renderer> renderers;

    private Renderer selectedRenderer;

    /**
     * @return a list which will be converted to a dictionary of rendering functions
     */
    public List<Renderer> getRenderers() {
        return renderers;
    }

    /**
     * Sets a list which will be converted to a dictionary of rendering functions.
     *
     * @param renderers a list which will be converted to a dictionary of rendering functions
     * @return a reference to this object
     */
    public Renderers setRenderers(List<Renderer> renderers) {
        this.renderers = renderers;
        return this;
    }

    /**
     * Adds an array which will be converted to a dictionary of rendering functions.
     *
     * @param renderers an array which will be converted to a dictionary of rendering functions
     * @return a reference to this object
     */
    public Renderers addRenderers(Renderer... renderers) {
        if (renderers != null) {
            if (this.renderers == null) {
                this.renderers = new ArrayList<>();
            }
            this.renderers.addAll(Arrays.asList(renderers));
        }
        return this;
    }

    /**
     * @return a selected renderer
     */
    public Renderer getSelectedRenderer() {
        return selectedRenderer;
    }

    /**
     * Sets one of predefined renderers, which name will be
     * converted to {@code rendererName} - an renderer to
     * prepopulate in dropdown i.e. key to {@code renderers} object.
     *
     * @param selectedRenderer one of predefined renderers
     * @return a reference to this object
     */
    public Renderers setSelectedRenderer(Renderer selectedRenderer) {
        this.selectedRenderer = selectedRenderer;
        return this;
    }

    /**
     * @return a selected renderer
     * @deprecated use {@link #getSelectedRenderer()} instead
     */
    @Deprecated
    public Renderer getDefaultRenderer() {
        return getSelectedRenderer();
    }

    /**
     * Sets one of predefined renderers, which name will be
     * converted to {@code rendererName} - an renderer to
     * prepopulate in dropdown i.e. key to {@code renderers} object.
     *
     * @param defaultRenderer one of predefined renderers
     * @return a reference to this object
     * @deprecated use {@link #setSelectedRenderer(Renderer)}} instead
     */
    @Deprecated
    public Renderers setDefaultRenderer(Renderer defaultRenderer) {
        return setSelectedRenderer(defaultRenderer);
    }
}
