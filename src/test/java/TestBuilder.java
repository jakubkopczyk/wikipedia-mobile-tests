import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class TestBuilder {
    public static AppiumDriver driver;
    private static WebDriverWait wait;

    // installed app details
    final static String appPackage = "org.wikipedia";
    final static String appActivity = "org.wikipedia.MainActivity";

    @BeforeClass
    public static void setUpClass() throws Exception {
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), testCapabilities());
        driver.launchApp();
        wait = new WebDriverWait(driver, 60);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.resetApp();
        driver.quit();
    }
    @Before
    public void setUp(){
        driver.closeApp();
        driver.launchApp();
    }

    private static DesiredCapabilities testCapabilities() throws Exception {
        DesiredCapabilities capabilities = DesiredCapabilities.android();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AVD_for_Nexus_6_by_Google_511");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 180);
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("autoLaunch", "false");
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);

        return capabilities;
    }
}
