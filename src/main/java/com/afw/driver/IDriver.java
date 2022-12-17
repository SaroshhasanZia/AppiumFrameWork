package com.afw.driver;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public interface IDriver {

//    public WebDriver getDriver(Map<String,String> map) throws DeviceNotFoundException, IOException;
    public WebDriver getMobileDriver() throws IOException;

}
