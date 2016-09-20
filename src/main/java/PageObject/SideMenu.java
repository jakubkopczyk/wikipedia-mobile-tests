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

    public void openHistory(){
        waitForElement(historyBtn);
        historyBtn.click();
        //TODO return HistoryPage
    }

    public void openReadingLists(){
        waitForElement(readingListsBtn);
        readingListsBtn.click();
        //TODO return ReadingListPage
    }

    public void openNearby(){
        waitForElement(nearbyBtn);
        nearbyBtn.click();
        //TODO return NearbyPage
    }

    public void openRandomArticle(){
        waitForElement(randomBtn);
        randomBtn.click();
        //TODO return ArticlePage or MultiLanguageArticlePage
    }

    public String returnHistoryBtnTitle(){
        return returnText(historyBtn);
    }

    public String returnReadingListBtnTitle(){
        return returnText(readingListsBtn);
    }

    public String returnNearbyBtnTitle(){
        return returnText(nearbyBtn);
    }

    public String returnRandomBtnTitle(){
        return returnText(randomBtn);
    }


}
