package PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NewsPage extends BasePage {
    @AndroidFindBy(id = "org.wikipedia:id/view_news_fullscreen_story_text")
    private MobileElement newsTitle;
    public NewsPage(AppiumDriver driver) {
        super(driver);
    }
    public String returnNewsTitle(){
        return returnText(newsTitle);
    }
}
