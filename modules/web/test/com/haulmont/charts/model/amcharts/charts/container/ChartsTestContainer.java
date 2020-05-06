package com.haulmont.charts.model.amcharts.charts.container;

import com.haulmont.cuba.web.testsupport.TestContainer;

public class ChartsTestContainer extends TestContainer {

    public ChartsTestContainer() {
        super();
        springConfig = "/com/haulmont/charts/model/amcharts/charts/container/test-charts-web-spring.xml";
    }

    public static class Common extends ChartsTestContainer {

        public static final ChartsTestContainer.Common INSTANCE = new ChartsTestContainer.Common();

        private static volatile boolean initialized;

        private Common() {
        }

        @Override
        public void before() throws Throwable {
            if (!initialized) {
                super.before();
                initialized = true;
            }
            setupContext();
        }

        @Override
        public void after() {
            cleanupContext();
        }
    }
}
