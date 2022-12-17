package com.afw.pages;

import com.google.common.collect.Lists;
import com.sun.javafx.scene.traversal.Direction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

import static com.afw.driver.DriverManagerThread.getDriver;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;

class BasePage {

    protected void tap(MobileElement element) {
        new AndroidTouchAction((PerformsTouchActions) getDriver()).tap(tapOptions().withElement(element(element))).perform();
    }

    protected void tapUsingCoordinates(int x, int y) {
        new AndroidTouchAction((PerformsTouchActions) getDriver()).tap(PointOption.point(x, y)).perform();
    }

    protected void longPress(MobileElement element, long sec) {
        new AndroidTouchAction((PerformsTouchActions) getDriver()).longPress(LongPressOptions.longPressOptions().
                withElement(element(element))).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(sec))).perform();
    }

    protected void swipe(MobileElement source, MobileElement dest) {
        new AndroidTouchAction((PerformsTouchActions) getDriver()).longPress(LongPressOptions.longPressOptions().withElement(element(source)))
                .moveTo(element(dest)).release().perform();
    }

    protected void dragAndDrop(MobileElement source, MobileElement dest) {
        new AndroidTouchAction((PerformsTouchActions) getDriver()).longPress(LongPressOptions.longPressOptions().withElement(element(source))).
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(element(dest)).release().perform();
    }

    protected void scrollToElement(By by) {

        while (getDriver().findElements(by).isEmpty()) {
            Dimension dimension = getDriver().manage().window().getSize();
            Double screenHeightStart = dimension.getHeight() * 0.5;
            int scrollStart = screenHeightStart.intValue();
            Double screenHeightEnd = dimension.getHeight() * 0.2;
            int scrollEnd = screenHeightEnd.intValue();
            int center = (int) (dimension.width * 0.5);

            new AndroidTouchAction((PerformsTouchActions) getDriver()).press(point(center, scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
                    moveTo(point(center, scrollEnd)).release().perform();
        }
    }

    public void waitUntilElementIsVisible(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    protected void dragAndDropToTop(MobileElement source, By by) {


        while (getDriver().findElements(by).isEmpty()) {
            Dimension dimension = getDriver().manage().window().getSize();
            Double screenHeightStart = dimension.getHeight() * 0.1;
            int y = screenHeightStart.intValue();
            Double screenHeightEnd = dimension.getWidth() * 0.5;
            int x = screenHeightEnd.intValue();


            new AndroidTouchAction((PerformsTouchActions) getDriver()).longPress(LongPressOptions.longPressOptions().withElement(element(source))).
                    waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).moveTo(point(x, y)).release().perform();


//            956,616
        }


    }

    protected void swipeByElement(MobileElement source) {
//        new AndroidTouchAction((PerformsTouchActions) getDriver()).longPress(LongPressOptions.longPressOptions().withElement(element(source)))
//                .moveTo(point(169,609)).release().perform();
        new AndroidTouchAction((PerformsTouchActions) getDriver()).longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)).withDuration(Duration.ofMillis(2000)))
                .moveTo(point(168, 609)).release().perform();
    }


    protected void swipeElementAndroid(MobileElement el, Direction dir) {
        System.out.println("swipeElementAndroid(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder;
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Rectangle rect = el.getRect();
        // sometimes it is needed to configure edgeBorders
        // you can also improve borders to have vertical/horizontal
        // or left/right/up/down border variables
        edgeBorder = 0;

        switch (dir) {
            case DOWN: // from up to down
                pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                        rect.y + edgeBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                        rect.y + rect.height - edgeBorder);
                break;
            case UP: // from down to up
                pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                        rect.y + rect.height - edgeBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                        rect.y + edgeBorder);
                break;
            case LEFT: // from right to left
                pointOptionStart = PointOption.point(rect.x + rect.width - edgeBorder,
                        rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x + edgeBorder,
                        rect.y + rect.height / 2);
                break;
            case RIGHT: // from left to right
                pointOptionStart = PointOption.point(rect.x + edgeBorder,
                        rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x + rect.width - edgeBorder,
                        rect.y + rect.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + dir + "' NOT supported");
        }

    }


    protected void swipeByCoordinates(PointOption start, PointOption end) {
        new TouchAction((PerformsTouchActions) getDriver())
                .press(start)
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(end)
                .release().perform();
    }


    protected void negativeAssertion(String text, By by) {
        List<MobileElement> element = (List<MobileElement>) getDriver().findElements(by);
        //(MobileElement) getDriver().findElements(By.xpath("//android.widget.TextView"));
        for (MobileElement m : element) {

            Assertions.assertThat(m.getText()).isNotEqualTo(text);

//            System.out.println(m.getText());

        }
    }

    protected void firstIndexAssertion(String text, By by) {
        List<MobileElement> element = (List<MobileElement>) getDriver().findElements(by);
        Assertions.assertThat(element.get(0).getText()).isEqualTo(text);
    }


    protected void navigateBack(){
        getDriver().navigate().back();
    }

    protected Integer randomNumber(){
        Random rn = new Random();
        int num = rn.nextInt(10 - 1 + 1) + 1;
        return num;
    }

    protected Integer[] randomIntArray(){
        Integer[] arr = new Integer[9];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        Collections.shuffle(Arrays.asList(arr));
        return arr;
    }


    protected void openApp(String App) {
        getDriver().activateApp(App);
    }

    protected void closeApp(String App) {
        getDriver().terminateApp(App);

    }

    protected String getCurrentApp(){
        AndroidDriver driver = (AndroidDriver) getDriver();
        return driver.getCurrentPackage();
    }

    protected String adbCommands(String command,ArrayList arry){
        Map<String, Object> argv = new HashMap<>();
        argv.put("command",  command);
        argv.put("args", Lists.newArrayList(arry));
        //String result = getDriver().executeScript("mobile: shell", argv).toString();
        AndroidDriver driver = (AndroidDriver) getDriver();
        return  (String) driver.executeScript("mobile: shell", argv);

    }





}
