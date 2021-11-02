package com.test.Configurations;


import cucumber.api.java.After;
import cucumber.api.java.Before;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;


public class Hooks {

    static ThreadLocal<AppiumDriverLocalService> service = new ThreadLocal<>();
    
    public static Properties prop;

    static AndroidDriver driver;

    public AndroidDriver getDriver() {
        return driver;
    }

    public AppiumDriverLocalService getService() {
        return service.get();
    }

    /*
    *   Start Appium Server Programmatically before each scenario
    */
    @Before
    public void startServer() throws IOException {
        /*AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1");
        service.set(appiumServiceBuilder.build());
        service.get().start();

        if (service == null || !service.get().isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException("An appium server node is not started!");
        }
*/
    	
    	prop = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/deviceconfig.properties");
		prop.load(ip);
		String deviceName=prop.getProperty("deviceName");
		String plarformVersion= prop.getProperty("plarformVersion");
		String platformName= prop.getProperty("platformName");
		String appPackage=prop.getProperty("appPackage");
		String appActivity=prop.getProperty("appActivity");
    	String url ="http://0.0.0.0:4723/wd/hub";
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformVersion", plarformVersion);
		capabilities.setCapability("platformName", platformName);
		// capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);
		capabilities.setCapability("newCommandTimeout", "5000");
        driver = new AndroidDriver(new URL(url), capabilities);
    }

    /*
    *   Stop Appium Server Programmatically before each scenario
    */
    @After
    public void stopServer() {
       
    	driver.quit();
    }
}
