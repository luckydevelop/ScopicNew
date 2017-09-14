import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:K:\\Job\\Testing\\Scopic\\src\\main\\resources\\report"}
        ,features = "src/test/resources/features"
        ,glue="steps"
        // ,format = {"html:K:\\Job\\Testing\\Scopic\\src\\test\\resources\\report"}
        ,format = "html:src"

)

public class TestRunner {
}
