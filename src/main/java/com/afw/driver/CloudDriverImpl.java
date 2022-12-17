package com.afw.driver;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class CloudDriverImpl implements IDriver {

    @Override
//    public WebDriver getDriver(Map<String,String> map) throws DeviceNotFoundException, IOException {
        public WebDriver getMobileDriver() throws  IOException {


        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("browserstack.user", "saroshhasanzia_vHG3MA");
        capabilities.setCapability("browserstack.key", "SDHxiqdqYD7GbPgxdKzG");
        capabilities.setCapability("newCommandTimeout","20");

        // Set URL of the application under test
        capabilities.setCapability("app", "bs://6b69f0f68d1adab7e7e91751c19e8ebd2ff5e243");

         //Specify device and os_version for testing
        capabilities.setCapability("device", "Samsung Galaxy S22");
        capabilities.setCapability("os_version", "12.0");
//        map.forEach(capabilities::setCapability);

        // Set other BrowserStack capabilities
        capabilities.setCapability("project", "First Java Project");
        capabilities.setCapability("build", "browserstack-build-1");
        capabilities.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above

        return  new AndroidDriver<AndroidElement>(new URL("http://hub.browserstack.com/wd/hub"), capabilities);


    }
}
