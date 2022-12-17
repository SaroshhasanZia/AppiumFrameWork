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

import static com.afw.utils.PropertyUtil.getValue;

public class LocalDriverAndroidImpl implements IDriver{


    @Override
//    public WebDriver getDriver(Map<String,String> map) throws DeviceNotFoundException, IOException {
        public WebDriver getMobileDriver() throws IOException {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
//        capabilities.setCapability(CapabilityType.VERSION, DeviceInfo.PhysicalDeviceInfo().getProductVersion());
//        capabilities.setCapability("deviceName", DeviceInfo.PhysicalDeviceInfo().getModelNumber());

//        capabilities.setCapability("app",System.getProperty("user.dir") +"APK");

//        capabilities.setCapability("app","/opt/com.mobeta.android.demodslv-0.5.0-3_APKdot.com.apk");
        capabilities.setCapability("app","/home/vend-sarosh/Documents/APKFile/com.mobeta.android.demodslv-0.5.0-3_APKdot.com.apk");
//        capabilities.setCapability("deviceName","emulator-5554");

        capabilities.setCapability("platformName","Android");

        capabilities.setCapability("noReset", true);
        capabilities.setCapability("fullReset", false);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("appWaitActivity","*");
        capabilities.setCapability("unlockType","pin");
        capabilities.setCapability("unlockKey","123456");
//        capabilities.setCapability("adbPort","5555");
//        capabilities.setCapability("remoteAdbHost","172.17.0.3");

        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,getValue("com.mobeta.android.demodslv"));
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,getValue(".Launcher"));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UIAutomator2");

        return new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"),capabilities);


    }
}
