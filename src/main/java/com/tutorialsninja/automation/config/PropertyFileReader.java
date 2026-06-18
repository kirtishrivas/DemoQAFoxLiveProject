package com.tutorialsninja.automation.config;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader implements ConfigurationReader {

    Properties prop;

    public PropertyFileReader() {
        try {
            prop = new Properties();   // ✅ MUST INITIALIZE

            //  UPDATED LINE (Correct path):
            FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "/src/main/resources/ConfigurationFile/config.properties"
            );

            prop.load(fis);  // ✅ LOAD FILE

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBrowser() {
        return prop.getProperty("browser");
    }

    @Override
    public String getUrl() {
        return prop.getProperty("url");
    }

    // 🌟 ADD THIS METHOD
    public String getUsername() {
        return prop.getProperty("username"); // Make sure 'username' matches the key name in config.properties
    }

    // 🌟 ADD THIS METHOD
    public String getPassword() {
        return prop.getProperty("password"); // Make sure 'password' matches the key name in config.properties
    }

    @Override
    public int getPageLoadTimeOut() {
        // TODO Auto-generated method stub
        return 0;
    }
}