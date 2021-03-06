package PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class HomePage extends BasePage {

    @AndroidFindBy(className = "android.widget.ImageButton")
    private MobileElement menuBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Explore']")
    private MobileElement pageTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='In the news']")
    private MobileElement newsSectionTitle;

    @AndroidFindAll(@AndroidFindBy(id = "org.wikipedia:id/horizontal_scroll_list_item_image"))
    private List<MobileElement> newsImagesList;

    @AndroidFindAll(@AndroidFindBy(id = "org.wikipedia:id/horizontal_scroll_list_item_text"))
    private List<MobileElement> newsTxtList;

    @AndroidFindAll(@AndroidFindBy(id = "org.wikipedia:id/view_list_card_item_title"))
    private List<MobileElement> trendingArticlesTitlesList;

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
    public String returnFirstNewsTxt(){
        waitForElements(newsTxtList);
        return returnText(newsTxtList.get(0));
    }
    public void openFirstNews(){
        waitForElements(newsImagesList);
        newsImagesList.get(0).click();
    }
    public MultiLanguageArticlePage openFirstFeaturedArticle() {
        waitForElement(featuredArticleTitle);
        featuredArticleTitle.click();
        return new MultiLanguageArticlePage(driver);
    }
    public MultiLanguageArticlePage openFirstTrendingArticle(){
        swipe(Swipe_directions.BOTTOM);
        swipe(Swipe_directions.BOTTOM);
        waitForElements(trendingArticlesTitlesList);
        trendingArticlesTitlesList.get(0).click();
        return new MultiLanguageArticlePage(driver);
    }
    public String returnTrendingArticleTitle(){
        swipe(Swipe_directions.BOTTOM);
        waitForElements(trendingArticlesTitlesList);
        return returnText(trendingArticlesTitlesList.get(0));
    }

    public String returnFeaturedArticleTitle() throws InterruptedException {
        waitForElement(pageTitle);
        swipe(Swipe_directions.BOTTOM);
        Thread.sleep(1000);
        waitForElement(featuredArticleTitle);
        return returnText(featuredArticleTitle);
    }
    public String returnPageTitle(){
        return returnText(pageTitle);
    }

    public SearchPage opeanSearchPage(){
        waitForElement(searchBox);
        searchBox.click();
        return new SearchPage(driver);
    }
}
