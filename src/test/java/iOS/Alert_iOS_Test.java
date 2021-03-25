package iOS;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Alert_iOS_Test {
    public IOSDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "14.4");
        capabilities.setCapability("deviceName", "iPhone 12");
        capabilities.setCapability("app",
                System.getProperty("user.dir") + "/apps/UIKitCatalog.zip");
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @Test
    public void testSimpleAlert() {
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByAccessibilityId("Simple").click();
        driver.switchTo().alert().accept();
    }

    @Test
    public void testOkayCancelAlert() {
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByAccessibilityId("Okay / Cancel").click();
        driver.switchTo().alert().dismiss();
    }

    @Test
    public void testSendTextAlert() {
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByAccessibilityId("Text Entry").click();
        driver.switchTo().alert().sendKeys("Hello TAU");
        driver.switchTo().alert().accept();
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

}
