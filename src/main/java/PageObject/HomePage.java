package PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage {

    @AndroidFindBy(className = "android.widget.ImageButton")
    private MobileElement menuBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Explore']")
    private MobileElement pageTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='In the news']")
    private MobileElement newsTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Featured article']")
    private MobileElement featuredArticleTitle;

    public HomePage(AppiumDriver driver){
            super(driver);
    }

    public SideMenu openSideMenu(){
        waitForElement(menuBtn);
        menuBtn.click();
        return new SideMenu(driver);
    }

}
