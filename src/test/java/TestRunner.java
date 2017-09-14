import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"src/test/resources/screens"}
        , features = "src/test/resources/features"
        , glue = "steps"
)

public class TestRunner {
}
