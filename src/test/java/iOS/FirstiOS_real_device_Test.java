package iOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstiOS_real_device_Test {

    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("platformVersion", "14.4");
        caps.setCapability("deviceName", "Moataz");
        caps.setCapability("udid","00008027-0019299A3E22002E");
        caps.setCapability("xcodeOrgId","moataznabil2019@gmail.com");
        caps.setCapability("xcodeSigningId", "iPhone Developer");
        caps.setCapability("useNewWDA",true);
        caps.setCapability("derivedDataPath","/Users/m.eldebsy/Library/Developer/Xcode/DerivedData/WebDriverAgent-ciegwgvxzxdrqthilmrmczmqvrgu");
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/UIKitCatalog-ios.zip");
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void click_App_Button() {
        // code
        driver.findElementByAccessibilityId("Buttons").click();
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

}
