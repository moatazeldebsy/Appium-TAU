package iOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Picker_View_iOS_Test {
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
    public void testPickerView() {
        driver.findElementByAccessibilityId("Picker View").click();
        driver.findElementByAccessibilityId("Red color component value").sendKeys("30");
        driver.findElementByAccessibilityId("Green color component value").sendKeys("200");
        IOSElement blue = (IOSElement) driver.findElementByAccessibilityId("Blue color component value");
        blue.sendKeys("100");
        System.out.println(blue.getText());
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

}

