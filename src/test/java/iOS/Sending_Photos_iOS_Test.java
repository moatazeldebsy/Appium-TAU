package iOS;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Sending_Photos_iOS_Test {
    public IOSDriver driver;
    File classPath, imageDir, img;
    String imgName = "TAU-logo.png";

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "13.7");
        capabilities.setCapability("deviceName", "iPhone 11 Pro");
        capabilities.setCapability("bundleId", "com.apple.mobileslideshow");
        driver = new IOSDriver(new URL( "http://localhost:4723/wd/hub"), capabilities);
    }

    @Test
    public void testSlider() throws IOException {
        classPath = new File(System.getProperty("user.dir"));
        imageDir = new File(classPath, "/resources/images");
        img = new File(imageDir.getCanonicalFile(), imgName);
        driver.pushFile(imgName,img);
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
