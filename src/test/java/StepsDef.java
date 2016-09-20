import Core.Capabilities;
import PageObject.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import static PageObject.BasePage.driver;

public class StepsDef extends Capabilities {

    HomePage homePage;
    MultiLanguageArticlePage multiLanguageArticlePage;
    SideMenu sideMenu;
    NewsPage newsPage;
    static String articleTitle;
    static String newsTxt;

    @After
    public void setUp(){
        AfterSetUp();
    }

    @Given("^I am launching the application$")
    public void iAmLaunchingTheApplication() throws Throwable {
        Capabilities.deviceCapabilities();
    }

    @When("^the app is done loading$")
    public void theAppIsDoneLoading() throws Throwable {
        Thread.sleep(5000);
    }

    @Then("^I can see specific elements on Home Page$")
    public void iCanSeeSpecificElementsOnHomePage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertThat(new HomePage(driver).returnPageTitle(), CoreMatchers.containsString("Explore"));

    }

    @Given("^I am on Home Page$")
    public void iAmOnHomePage() throws Throwable {
        Assert.assertThat(new HomePage(driver).returnPageTitle(), CoreMatchers.containsString("Explore"));
    }

    @When("^I tap on first Featured article$")
    public void iTapOnFirstFeaturedArticle() throws Throwable {
        homePage = new HomePage(driver);
        articleTitle = homePage.returnFeaturedArticleTitle();
        homePage.openFirstFeaturedArticle();
    }

    @Then("^Featured article with same title is opened$")
    public void featuredArticleWithSameTitleIsOpened() throws Throwable {
        multiLanguageArticlePage = new MultiLanguageArticlePage(driver);
        Assert.assertThat(multiLanguageArticlePage.returnArticleHeader(), CoreMatchers.containsString(articleTitle));
        multiLanguageArticlePage.back();
    }

    @When("^I tap on hamburger menu button$")
    public void iTapOnHamburgerMenuButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homePage = new HomePage(driver);
        homePage.openSideMenu();
    }

    @Then("^Side menu with specific options is opened$")
    public void sideMenuWithSpecificOptionsIsOpened() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        sideMenu = new SideMenu(driver);
        Assert.assertThat(sideMenu.returnHistoryBtnTitle(),CoreMatchers.is("History"));
        Assert.assertThat(sideMenu.returnNearbyBtnTitle(),CoreMatchers.is("Nearby"));
        Assert.assertThat(sideMenu.returnRandomBtnTitle(),CoreMatchers.is("Random"));
        sideMenu.back();
    }

    @When("^I open first news$")
    public void iOpenFirstNews() throws Throwable {
        homePage = new HomePage(driver);
        newsTxt = homePage.returnFirstNewsTxt();
        homePage.openFirstNews();
    }

    @Then("^News with same title is opened$")
    public void newsWithSameTitleIsOpened() throws Throwable {
        newsPage = new NewsPage(driver);
        Assert.assertThat(newsPage.returnNewsTitle(),CoreMatchers.is(newsTxt));
        newsPage.back();
    }
}
