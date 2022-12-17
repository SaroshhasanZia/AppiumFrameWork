package com.afw.pages;

import com.afw.utils.DynamicXpath;
import io.appium.java_client.MobileElement;
import io.cucumber.java.sl.In;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

import java.util.*;

import static com.afw.driver.DriverManagerThread.getDriver;

public class Scenario2Page extends BasePage {

    private final String chkList = "//android.view.ViewGroup[%s]//android.widget.CheckedTextView";

    private final String byNames = "//android.view.ViewGroup//android.widget.CheckedTextView[contains(@text,'%s')]";

    private final String items = "//android.view.ViewGroup//android.widget.CheckedTextView";
    private final String deleteBtn = "//android.view.ViewGroup[%s]//android.widget.ImageView[2]";
    private String[] numbers = new String[5];
    List<String> list = new ArrayList<String>();

    HashMap<String, Integer> selectedItems = new HashMap<>();

    public void multiSelection() {
        Integer[] arr = randomIntArray();

        for (int i = 0; i <= 4; i++) {
            String num = String.valueOf(arr[i]);
            numbers[i] = num;
            String newXpath = DynamicXpath.getXpath(chkList, num);
            MobileElement element = (MobileElement) getDriver().findElement(By.xpath(newXpath));
            tap(element);
            list.add(element.getText());
            selectedItems.put(element.getText(), arr[i]);

        }

    }

    public void deletingSelection() {

        Integer[] index = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            index[i] = Integer.parseInt(numbers[i]);
        }
        Arrays.sort(index, Collections.reverseOrder());
        for (int i : index) {
            String newXpath = DynamicXpath.getXpath(deleteBtn, String.valueOf(i));
            MobileElement element = (MobileElement) getDriver().findElement(By.xpath(newXpath));
            tap(element);
        }


    }

    public void checkForDeletedItems() {
        List<MobileElement> elements = getDriver().findElementsByXPath(items);
        List<String> actualNames = new ArrayList<String>();
        for (MobileElement item : elements) {
            actualNames.add(item.getText());
        }

        Assertions.assertThatIterable(actualNames).doesNotContainAnyElementsOf(list);

    }

    public void stopApp(String appName) {
        closeApp(appName);

    }

    public void startApp(String appName) {
        openApp(appName);
    }

    public void checkThatTheSecondAppIsRunning(String appName) {
        Assertions.assertThat(getCurrentApp()).isEqualTo(appName);
    }


}
