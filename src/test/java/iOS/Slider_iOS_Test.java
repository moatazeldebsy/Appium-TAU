package iOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Slider_iOS_Test {
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
    public void testSlider() {
        driver.findElementByAccessibilityId("Sliders").click();
        IOSElement slider = (IOSElement) driver.findElement(By.xpath("//XCUIElementTypeSlider"));
        slider.setValue("0%");
        slider.setValue("1%"); // 100%
        slider.setValue("0.5%"); // 48%
        Assert.assertEquals(slider.getAttribute("value"),"48%");
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

}
