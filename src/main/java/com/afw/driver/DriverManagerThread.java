package com.afw.driver;

import io.appium.java_client.MobileDriver;
import org.openqa.selenium.WebDriver;

public final class DriverManagerThread {

    private static ThreadLocal<MobileDriver> driverThreadLocal = new ThreadLocal<>();


    public static MobileDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void setDriver(MobileDriver value) {
        driverThreadLocal.set(value);
    }

    public static void unloadDriver() {
        driverThreadLocal.remove();
    }
}
