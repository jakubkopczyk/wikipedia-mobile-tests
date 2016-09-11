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
    public void searchArticle(String articleName){
        waitForElement(searchTxtField);
        searchTxtField.sendKeys(articleName);
    }

    public MultiLanguageArticlePage searchMultiLanguageArticle(String articleName) throws Exception {
        searchArticle(articleName);
        //Thread.sleep(4000);
        waitForElements(searchResults);
        while (i < searchResults.size()) {
            if (searchResults.get(i).getText().toLowerCase().equals(articleName.toLowerCase())) {
                searchResults.get(i).click();
                return new MultiLanguageArticlePage(driver);
            } else {
                i++;
            }
        }
        throw new Exception(articleName + " was not found");
        }
}
