package PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ArticleBasePage extends BasePage {

    @AndroidFindBy(id = "org.wikipedia:id/view_article_header_text")
    private MobileElement articleHeaderTxt;

    @AndroidFindBy(id = "org.wikipedia:id/view_article_menu_bar_bookmark")
    private MobileElement bookmarkBtn;

    @AndroidFindBy(id = "org.wikipedia:id/floating_toc_button")
    private MobileElement tableOfContentBtn;

    public ArticleBasePage(AppiumDriver driver) {
        super(driver);
    }


}
