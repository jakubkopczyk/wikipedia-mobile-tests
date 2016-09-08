import PageObject.HomePage;
import PageObject.MultiLanguageArticlePage;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class TestSuite extends TestBuilder {

    HomePage homePage;
    MultiLanguageArticlePage multiLanguageArticlePage;

    @Test
    public void test01_openArticlesOnHomeScreen() throws InterruptedException {
        homePage = new HomePage(driver);
        String articleTitle = homePage.returnFeaturedArticleTitle();
        homePage.openFirstFeaturedArticle();
        multiLanguageArticlePage = new MultiLanguageArticlePage(driver);
        //String articleHeader = multiLanguageArticlePage.returnArticleHeader();
        Assert.assertThat(multiLanguageArticlePage.returnArticleHeader(), CoreMatchers.containsString(articleTitle));

    }

}
