package com.afw.reports;

import com.aventstack.extentreports.MediaEntityBuilder;

import static com.afw.reports.ReportManager.getExtentTest;
import static com.afw.utils.ScreenShotUtil.getBase64Image;

public final class ExtentLogger {

    private ExtentLogger(){}

    public static void pass(String Message){
        getExtentTest().pass(Message);
    }

    public static void fail(String Message){
//        getExtentTest().fail(Message);
        getExtentTest().fail(Message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
    }

    public static void skip(String Message){
        getExtentTest().skip(Message);
    }
}
