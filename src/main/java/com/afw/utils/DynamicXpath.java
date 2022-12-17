package com.afw.utils;

public final class DynamicXpath {

    private DynamicXpath(){}

    public static String getXpath(String xpath, String value){
        return String.format(xpath, value);

    }

}
