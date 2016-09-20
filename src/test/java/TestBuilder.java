import Core.Capabilities;
import Helpers.RecordAndroidScreen;
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

    @BeforeClass
    public static void setUpClass() throws Exception {
        Capabilities.deviceCapabilities();
        driver = Capabilities.driver;
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

}
