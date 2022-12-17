package com.afw.listeners;

import com.afw.driver.Driver;
import com.afw.reports.ExtentLogger;
import com.afw.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listener implements ITestListener, ISuiteListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getName());
    }


    @Override
    public  void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getName()+ " is passed");
    }

    @Override
    public  void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getName()+ " got failed!");
    }

    @Override
    public  void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getName()+ " is skipped");

    }


    @Override
    public  void onStart(ISuite suite) {
        ExtentReport.initReport();
//        try {
//            Driver.initDriver();
//        } catch (DeviceNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public  void onFinish(ISuite suite) {
        ExtentReport.tearDownReport();
//        Driver.quitDriver();

    }




}
