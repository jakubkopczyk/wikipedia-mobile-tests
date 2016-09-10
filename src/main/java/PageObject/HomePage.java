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
    private MobileElement newsSectionTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Featured article']")
    private MobileElement featuredArticleSectionTitle;

    @AndroidFindBy(id = "org.wikipedia:id/view_featured_article_card_image")
    private MobileElement featuredArticleImage;

    @AndroidFindBy(id = "org.wikipedia:id/view_featured_article_card_article_title")
    private MobileElement featuredArticleTitle;

    @AndroidFindBy(id = "org.wikipedia:id/search_container")
    private MobileElement searchBox;

    public HomePage(AppiumDriver driver){
            super(driver);
    }

    public SideMenu openSideMenu(){
        waitForElement(menuBtn);
        menuBtn.click();
        return new SideMenu(driver);
    }
    public void openFirstNews(){}
    public MultiLanguageArticlePage openFirstFeaturedArticle() {
        waitForElement(featuredArticleTitle);
        featuredArticleTitle.click();
        return new MultiLanguageArticlePage(driver);
    }
    public void openFirstTrendingArticle(){}

    public String returnFeaturedArticleTitle() throws InterruptedException {
        waitForElement(pageTitle);
        swipe(Swipe_directions.BOTTOM);
        Thread.sleep(1000);
        waitForElement(featuredArticleTitle);
        return returnText(featuredArticleTitle);
    }

    public SearchPage opeanSearchPage(){
        waitForElement(searchBox);
        searchBox.click();
        return new SearchPage(driver);
    }
}
