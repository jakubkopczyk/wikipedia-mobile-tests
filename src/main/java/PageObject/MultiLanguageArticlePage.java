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


    public String returnArticleHeader(){
        waitForElement(articleHeader);
        return returnText(articleHeader);
    }
}
