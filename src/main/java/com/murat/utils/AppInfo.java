package com.murat.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;


public final class AppInfo {

    public static String APP_NAME;

    public static String APP_VERSION;

    static {
        Properties appinfo = new Properties();
        try(
                InputStreamReader isr = new InputStreamReader(AppInfo.class.getResourceAsStream("/appinfo"),"UTF-8");
        ) {
            appinfo.load(isr);
            APP_NAME = appinfo.getProperty("appName");
            APP_VERSION= appinfo.getProperty("appVersion");
        } catch (IOException e) {
        }
    }


}
