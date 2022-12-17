package com.afw.utils;

import com.afw.driver.DriverManagerThread;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public final class ScreenShotUtil {

    private ScreenShotUtil(){}

    public static String getBase64Image(){
//        return "Screenshot";

      return   ((TakesScreenshot) DriverManagerThread.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
