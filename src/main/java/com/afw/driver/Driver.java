package com.afw.driver;

import com.afw.utils.PropertyUtil;
import io.appium.java_client.MobileDriver;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import static com.afw.driver.DriverManagerThread.*;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public final class Driver {

    private Driver(){}

    public static void initDriver() throws  IOException {
//    public static void initDriver(Map<String,String> map) throws DeviceNotFoundException, IOException {

        if(Objects.isNull(getDriver())){
            System.out.println("Driver was null");

            String modeValue = PropertyUtil.getValue("mode");
            MobileDriver driver = (MobileDriver) DriverFactory.getDriver(Modes.valueOf(modeValue.toUpperCase()));
//        WebDriver driver = DriverFactory.getDriver(Modes.valueOf(modeValue.toUpperCase()),map);
            setDriver(driver);

     }
    }

    public static void quitDriver(){
        if(Objects.nonNull(getDriver())) {
            getDriver().quit();
            unloadDriver();
        }
    }

}
