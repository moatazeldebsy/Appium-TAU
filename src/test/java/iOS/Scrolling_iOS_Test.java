package iOS;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class Scrolling_iOS_Test {
    public IOSDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "14.2");
        capabilities.setCapability("deviceName", "iPhone 12 mini");
        capabilities.setCapability("app",
                System.getProperty("user.dir") + "/apps/UIKitCatalog.zip");
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @Test
    public void testScroll() {
        HashMap<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction","down");
        scrollObject.put("value","Web View");
        driver.executeScript("mobile:scroll",scrollObject);
        driver.findElementByAccessibilityId("Web View").click();
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

}
