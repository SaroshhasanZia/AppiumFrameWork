package com.afw.pages;

import java.util.ArrayList;

public class Scenario3Page extends BasePage {

    public String internetConnectivity(String state) {
        String cmd = "svc";
        ArrayList<String> list = new ArrayList<>();
        list.add("wifi");
        list.add(state);
        return adbCommands(cmd, list);

    }

//settings put global development_settings_enabled 1
    //adb shell settings put global bluetooth_on 1


    //adb shell settings put system user_rotation 3
    public String developerOption(String state) {
        String cmd = "settings";
        ArrayList<String> list = new ArrayList<>();
        list.add("put");
        list.add("global");
        list.add("development_settings_enabled");
        list.add(state);
        return adbCommands(cmd, list);

    }

    public String bluetooth(String state) {
        String cmd = "settings";
        ArrayList<String> list = new ArrayList<>();
        list.add("put");
        list.add("global");
        list.add("bluetooth_on");
        list.add(state);
        return adbCommands(cmd, list);

    }

    public String orientation(String state) {
        String cmd = "settings";
        ArrayList<String> list = new ArrayList<>();
        list.add("put");
        list.add("system");
        list.add("user_rotation");
        list.add(state);
        return adbCommands(cmd, list);

    }

    public String notificationSettings(String state) {
        String cmd = "settings";
        ArrayList<String> list = new ArrayList<>();
        list.add("put");
        list.add("global");
        list.add("heads_up_notifications_enabled");
        list.add(state);
        return adbCommands(cmd, list);

    }

//adb shell am force-stop [PACKAGE]

    public String killApps(String packageName) {
        String cmd = "am";
        ArrayList<String> list = new ArrayList<>();
        list.add("force-stop");
        list.add(packageName);
        return adbCommands(cmd, list);

    }

    //adb shell settings get global heads_up_notifications_enabled

    public String checkForBluetooth() {

        String cmd = "settings";
        ArrayList<String> list = new ArrayList<>();
        list.add("get");
        list.add("global");
        list.add("bluetooth_on");
        return adbCommands(cmd, list);


    }


}
