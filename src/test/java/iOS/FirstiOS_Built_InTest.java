package iOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstiOS_Built_InTest {

    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("platformVersion", "14.4");
        caps.setCapability("deviceName", "iPhone 12");
        caps.setCapability("bundleId",  "com.apple.MobileAddressBook");
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void click_App_Button() {
        // code
        driver.findElementByAccessibilityId("Add").click();
        driver.findElementByAccessibilityId("First name").sendKeys("Moataz");
        driver.findElementByAccessibilityId("Last name").sendKeys("Nabil");
        driver.findElementByAccessibilityId("Done").click();
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

}
