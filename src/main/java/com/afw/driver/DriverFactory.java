package com.afw.driver;

import io.appium.java_client.MobileDriver;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public final class DriverFactory {

    private DriverFactory() {
    }

        public static WebDriver getDriver(Modes mode) throws IOException {
//        public static WebDriver getDriver(Modes mode, Map<String,String> map) throws DeviceNotFoundException, IOException {
        MobileDriver driver = null;


        switch (mode) {

            case ANDROID:
                driver = (MobileDriver) new LocalDriverAndroidImpl().getMobileDriver();
//                driver = new LocalDriverAndroidImpl().getDriver(map);

                break;

            case CLOUD:
                driver = (MobileDriver) new CloudDriverImpl().getMobileDriver();
//                driver = new CloudDriverImpl().getDriver(map);

                break;

        }

        return driver;

    }
}