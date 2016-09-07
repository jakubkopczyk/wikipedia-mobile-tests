package PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EnglishOnlyArticle extends ArticleBasePage {
    public EnglishOnlyArticle(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "org.wikipedia:id/menu_feed_tabs")
    private MobileElement shareButton;
}
