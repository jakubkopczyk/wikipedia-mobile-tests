package PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SideMenu extends BasePage {

    @AndroidFindBy(id = "org.wikipedia:id/nav_account_text")
    private MobileElement loginWikipediaTxt;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Explore']")
    private MobileElement exploreBtn;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='History']")
    private MobileElement historyBtn;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Reading lists']")
    private MobileElement readingListsBtn;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Nearby']")
    private MobileElement nearbyBtn;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Random']")
    private MobileElement randomBtn;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Settings']")
    private MobileElement settingstn;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Support Wikipedia']")
    private MobileElement supportWikipediaBtn;

    public SideMenu(AppiumDriver driver){
        super(driver);
    }

    public void openHistory(){}
    public void openReadingLists(){}
    public void openNearby(){}
    public void openRandomArticle(){}


}
