import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class iOS_Safari_Simulator_Device_Test {
    private AppiumDriver driver;


    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.4");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
        capabilities.setCapability("deviceName", "iPhone 11 Pro");
        capabilities.setCapability("safari:useSimulator", true);
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @Test
    public void open_URL() {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        WebElement username = driver.findElementByCssSelector("input#username");
        username.sendKeys("tomsmith");
        WebElement password = driver.findElementByCssSelector("input#password");
        password.sendKeys("SuperSecretPassword!");
        WebElement loginBtn = driver.findElementByCssSelector("button.radius");
        loginBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("secure"));
        Assert.assertTrue(driver.getCurrentUrl().contains("secure"));
        System.out.println(driver.getCurrentUrl());
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
