package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase extends AbstractTestNGCucumberTests {

    public static AppiumDriver driver;

    public static void Android_setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName" , "espresso");
        capabilities.setCapability("platformVersion", "8.1");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("forceEspressoRebuild",true);
        capabilities.setCapability("appium:autoGrantPermissions", true);
        capabilities.setCapability("platformName", "Android");
       // capabilities.setCapability("skipServerInstallation",true);
        capabilities.setCapability("app",
                System.getProperty("user.dir") + "/apps/ToDo.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    public void iOS_setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone X");
        capabilities.setCapability("automationName","XCUITest");
        capabilities.setCapability("isHeadless",true);
        capabilities.setCapability("app",
                System.getProperty("user.dir") + "/apps/DailyCheck.zip");
        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    public static void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
