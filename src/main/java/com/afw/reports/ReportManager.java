package com.afw.reports;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;


    public class ReportManager {

        private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();


         public static ExtentTest getExtentTest() {

            return test.get();
        }

        public static void setExtentTest(ExtentTest testvalue) {

             test.set(testvalue);
        }

        public static void unload() {
            test.remove();
        }
    }


