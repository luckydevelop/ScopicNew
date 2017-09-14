package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helpers.PropertiesFromFile;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class Hooks {

    @Before
    public void setupTimeout()
    {
       System.setProperty("webdriver.chrome.driver", PropertiesFromFile.getProperties().getProperty("driver.chrome.path"));
       Configuration.browser = PropertiesFromFile.getProperties().getProperty("browser");
    }

    @After
    public void closeDriver()
    {
        getWebDriver().close();
    }


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "K:\\Job\\Testing\\Scopic\\src\\test\\resources");
            scenario.embed(screenshot, "src/test/resources/image/png");
            scenario.embed(screenshot, "image/png");
        }
    }

}
