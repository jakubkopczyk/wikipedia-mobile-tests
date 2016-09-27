import Core.Capabilities;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty","html:src/main/resources/report"},features = "src/main/java/features/HomePage")
public class TestFeatures {
    @AfterClass
    public static void tearDownTest() throws Exception {
        Capabilities.tearDown();
    }
}