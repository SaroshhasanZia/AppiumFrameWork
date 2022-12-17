package com.afw.pages;

import com.afw.utils.DynamicXpath;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;


import static com.afw.driver.DriverManagerThread.getDriver;

public class Scenario1Page extends BasePage {

    private final String menuItems = "//android.widget.TextView[contains(@text,'%s')]";

    private final String dragButtonItems = "//android.widget.TextView[contains(@text,'%s')]//following-sibling::android.widget.ImageView";

    //
    //android.widget.CheckedTextView[1]
    //
    ///hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.view.ViewGroup[6]//android.widget.CheckedTextView
    private final String country = "new UiSelector().text(\"%s\")";

    private final By elements = By.id("com.mobeta.android.demodslv:id/text");

    // private String menuItems = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]//following-sibling::android.widget.TextView[contains(@text,'%s')]";

    public void clickMenuItems(String value){
        String newXpath = DynamicXpath.getXpath(menuItems,value);
        MobileElement element = (MobileElement) getDriver().findElement(By.xpath(newXpath));
        tap(element);

    }

    public void selection(String element){

        String elementXpath = DynamicXpath.getXpath(country,element);
        By by = new MobileBy.ByAndroidUIAutomator(elementXpath);
        scrollToElement(by);
    }

    public void dragAndDrop(String sourceValue, String destValue) {

        String sourceXpath = DynamicXpath.getXpath(dragButtonItems,sourceValue);
        String DestPath = DynamicXpath.getXpath(country,destValue);

        MobileElement source = (MobileElement) getDriver().findElement(By.xpath(sourceXpath));
        By dest = new MobileBy.ByAndroidUIAutomator(DestPath);
        //dragAndDrop(source,dest);

        dragAndDropToTop(source,dest);
    }

    public void removeCountry(String element){
//        String elementPath = DynamicXpath.getXpath(dragButtonItems,element);
//        MobileElement source = (MobileElement) getDriver().findElement(By.xpath(elementPath));
        PointOption start = PointOption.point(961,609);
        PointOption end = PointOption.point(168,609);

        swipeByCoordinates(start,end);
    }

    public void assertionForCountryRemoved(String country){
        negativeAssertion(country,elements);
    }

    public void assertionForCountryIndex(String country){
        firstIndexAssertion(country,elements);
    }






}
