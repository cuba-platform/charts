# CUBA Charts Add-on

[![license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)
[![Build Status](https://travis-ci.org/cuba-platform/charts.svg?branch=master)](https://travis-ci.org/cuba-platform/charts)

Charts Add-on provides integration with AmCharts and GoogleMaps for applications based on CUBA Platform.

[Documentation](https://doc.cuba-platform.com/charts-latest).

For more information see [github.com/cuba-platform/cuba](https://github.com/cuba-platform/cuba).

## Build and install

In order to build the add-on from source, you need to install the following:
* Java 8 Development Kit (JDK)
* [CUBA Gradle Plugin](https://github.com/cuba-platform/cuba-gradle-plugin)
* [CUBA](https://github.com/cuba-platform/cuba)

Let's assume that you have cloned sources into the following directories:
```
work/
    cuba/
    cuba-gradle-plugin/
    charts/
```

Open terminal in the `work` directory and run the following command to build and install the plugin into your local Maven repository (`~/.m2`):
```
cd cuba-gradle-plugin
gradlew install
```

After that, go to the cuba directory and build and install it with the same command:
```
cd ../cuba
gradlew install
```

Finally, go to the charts directory and build and install it with the same command:
```
cd ../charts
gradlew install
```