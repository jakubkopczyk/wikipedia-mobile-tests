import PageObject.HomePage;
import PageObject.MultiLanguageArticlePage;
import PageObject.SearchPage;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class TestSuite extends TestBuilder {

    HomePage homePage;
    MultiLanguageArticlePage multiLanguageArticlePage;
    SearchPage searchPage;

    @Test
    public void test01_openArticlesOnHomeScreen() throws InterruptedException {
        homePage = new HomePage(driver);
        String articleTitle = homePage.returnFeaturedArticleTitle();
        homePage.openFirstFeaturedArticle();
        multiLanguageArticlePage = new MultiLanguageArticlePage(driver);
        Assert.assertThat(multiLanguageArticlePage.returnArticleHeader(), CoreMatchers.containsString(articleTitle));

    }
    @Test
    public void test02_searchForArticle() throws Exception {
        homePage = new HomePage(driver);
        homePage.opeanSearchPage();
        searchPage = new SearchPage(driver);
        searchPage.searchMultiLanguageArticle("iOS");
        multiLanguageArticlePage = new MultiLanguageArticlePage(driver);
        Assert.assertThat(multiLanguageArticlePage.returnArticleHeader().toLowerCase(),CoreMatchers.containsString("ios"));
    }

}
