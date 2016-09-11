package PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MultiLanguageArticlePage extends ArticleBasePage {
    public MultiLanguageArticlePage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "org.wikipedia:id/view_article_header_text")
    private MobileElement articleHeader;

    @AndroidFindBy(xpath = "//*[@content-desc='Mobile operating system']")
    private MobileElement mobileSystemHyperlink;

    @AndroidFindBy(id = "org.wikipedia:id/link_preview_title")
    private MobileElement articlePreview;

    @AndroidFindBy(id = "org.wikipedia:id/view_article_menu_bar_share")
    private MobileElement shareBtn;

    @AndroidFindBy(xpath = "//*[@content-desc='More options']")
    private MobileElement optionsBtn;

    @AndroidFindBy(xpath = "//*[@text='Add to reading list']")
    private MobileElement addToReadingListBtn;

    @AndroidFindBy(id = "org.wikipedia:id/onboarding_button")
    private MobileElement readingListinfoPopupBtn;

    @AndroidFindBy(id = "org.wikipedia:id/reading_list_title")
    private MobileElement readingListTitle;

    @AndroidFindBy(id = "org.wikipedia:id/snackbar_text")
    private MobileElement savedToReadingListMessage;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement okBtn;

    @AndroidFindBy(xpath = "//*[@text='Save to reading list']")
    private MobileElement readingListChoicePopup;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My test reading list']")
    private MobileElement testReadingList;

    public void openLinkToArticlePreview(){
        waitForElement(mobileSystemHyperlink);
        mobileSystemHyperlink.click();
    }
    public String returnArticlePreviewTitle(){
        return returnText(articlePreview);
    }

    public String returnArticleHeader(){
        return returnText(articleHeader);
    }
    public void addArticleToReadingList(){
        waitForElement(optionsBtn);
        optionsBtn.click();
        waitForElement(addToReadingListBtn);
        addToReadingListBtn.click();
        if (isPresent(readingListinfoPopupBtn)){
            readingListinfoPopupBtn.click();
            waitForElement(readingListTitle);
            pressKey(67);
            readingListTitle.sendKeys("My test reading list");
            okBtn.click();
        }
        if(isPresent(readingListChoicePopup)){
            waitForElement(testReadingList);
            testReadingList.click();
        }
    }
    public String returnSavedToReadingListMessage(){
        return returnText(savedToReadingListMessage);
    }
}
