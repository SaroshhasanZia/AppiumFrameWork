//package com.afw.commons;
//
//import com.testinium.deviceinformation.DeviceInfoImpl;
//import com.testinium.deviceinformation.device.DeviceType;
//import com.testinium.deviceinformation.exception.DeviceNotFoundException;
//import com.testinium.deviceinformation.model.Device;
//
//import java.io.IOException;
//
//public final class DeviceInfo {
//
//    private DeviceInfo(){}
//
//
//    public static Device PhysicalDeviceInfo() throws DeviceNotFoundException, IOException  //Define the type of device and its version
//    {
//        com.testinium.deviceinformation.DeviceInfo deviceInfo = new DeviceInfoImpl(DeviceType.ALL);   // if IOs device then select io
//        Device device = null;
//        if (deviceInfo.anyDeviceConnected()) {
//            device = deviceInfo.getFirstDevice();  // because we are doing single device execution
//        }
//
//        return device;
//    }
//
//    public static Device SimuDeviceInfo() throws DeviceNotFoundException, IOException  //Define the type of device and its version
//    {
//        com.testinium.deviceinformation.DeviceInfo deviceInfo = new DeviceInfoImpl(DeviceType.ALLANDIOSSIMULATOR);   // if IOs device then select io
//        Device device = null;
//        if (deviceInfo.anyDeviceConnected()) {
//            device = deviceInfo.getFirstDevice();  // because we are doing single device execution
//        }
//
//        return device;
//    }
//
//
//}
