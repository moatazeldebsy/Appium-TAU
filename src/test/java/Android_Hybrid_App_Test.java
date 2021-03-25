import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Android_Hybrid_App_Test {
    private static By chromeScreen = MobileBy.AccessibilityId("buttonStartWebviewCD");
    private static By gotoHomeScreen = By.id("goBack");
    private AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator1");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("app", System.getProperty("user.dir") + "/apps/selendroid.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    public void switchToWebView() {
        Set<String> availableContexts = driver.getContextHandles();
        for (String context : availableContexts) {
            if (context.contains("WEBVIEW")) {
                driver.context(context);
                break;
            }
        }
    }

    @Test
    public void HybridTest() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(chromeScreen))
                .click();
        switchToWebView();
        WebElement name_input = driver.findElement(By.id("name_input"));
        name_input.clear();
        String name = "Moataz Nabil";
        name_input.sendKeys(name);
        driver.context("NATIVE_APP");
        driver.findElement(gotoHomeScreen).click();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
