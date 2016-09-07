package PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class SearchPage extends BasePage {

    int i = 0;
    String englishOnlyArticle = "Harlan Howard Thompson";

    @AndroidFindBy(id = "org.wikipedia:id/search_src_text")
    private MobileElement searchTxtField;

    @AndroidFindAll(@AndroidFindBy(id = "org.wikipedia:id/page_list_item_title"))
    private List<MobileElement> searchResults;

    public SearchPage(AppiumDriver driver) {
        super(driver);
    }
    //TODO fill blank methods
    public void searchArticle(String articleName){}

    public MultiLanguageArticlePage openMultiLanguageArticle(String articleName) throws Exception {
        waitForElements(searchResults);
        while (i < searchResults.size()) {
            if (searchResults.get(i).getText().toLowerCase() == articleName.toLowerCase()) {
                searchResults.get(0).click();
                break;
            } else {
                i++;
            }
        }
        if (i == searchResults.size()) {
            throw new Exception("iOS article was not found");
        }
        return new MultiLanguageArticlePage(driver);
    }
}
