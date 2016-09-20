package Core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class Capabilities {
    public static AppiumDriver driver;
    private static WebDriverWait wait;

    // installed app details
    final static String appPackage = "org.wikipedia";
    final static String appActivity = "org.wikipedia.MainActivity";


    public static void deviceCapabilities() throws Exception
    {
        DesiredCapabilities capabilities = DesiredCapabilities.android();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AVD_for_Nexus_6_by_Google");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 180);
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("autoLaunch", "false");
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        try
        {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.launchApp();
            wait = new WebDriverWait(driver, 60);
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
    }
    public void AfterSetUp() {
        driver.closeApp();
        driver.launchApp();
    }
    public static void tearDown() throws Exception {
        driver.resetApp();
        driver.quit();
    }
}

