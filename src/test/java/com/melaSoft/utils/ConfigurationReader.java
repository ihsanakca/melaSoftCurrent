package com.melaSoft.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    /**
     * bu class configuration.properties altında yer alan verileri okumaya yarar
     */

    private static Properties properties; // properties leri içinde key/value olarak  saklayabilen bir yapı

    static {
        try {
            // path of file which is wanted to read
            String path="configuration.properties";

            // read file into java
            /**
             * fileInputStream() dışarıdan java ya bir veri almak istedğimizde kullandığımız bir yöntem
             */
            FileInputStream input=new FileInputStream(path);

            // properties --> class that can store data in key/value format
            properties=new Properties();
            // the values (data) from input is loaded to the properties object
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // we need to get method for read properties variable
    public static String get(String keyName){
        return properties.getProperty(keyName);
    }
}
