package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.He;
import helpers.Helper;
import helpers.PropertiesFromFile;
import org.junit.Assert;
import pages.HomePage;
import pages.PostPage;
import popups.CreateNewPostPopUp;

public class CreateNewPostSteps {

    LoginWithEmailSteps loginWithEmailSteps = new LoginWithEmailSteps();
    HomePage homePage = new HomePage();
    CreateNewPostPopUp createNewPostPopUp = new CreateNewPostPopUp();
    PostPage postPage = new PostPage();
    static String mediaType;
    static String description;

    @Given("^User opens HomePage$")
    public void user_opens_HomePage() {
        loginWithEmailSteps.homepage_is_opened();
        loginWithEmailSteps.user_clicks_Log_in_link();
        loginWithEmailSteps.user_Signs_in_with_login_and_password(PropertiesFromFile.getProperties().getProperty("user.default"), PropertiesFromFile.getProperties().getProperty("password.default"));
        loginWithEmailSteps.homepage_is_loaded();
    }

    @And("^User opens CreateNewPostPopUp$")
    public void user_opens_createnewpostpopup() {
        homePage.clickDropdownToggle();
        homePage.clickCreateNewPostItem();
    }

    @When("^User types Headline \"(.*)\"$")
    public void user_types_headline_something(String headline) {
        createNewPostPopUp.typeHeadline(headline);
    }

    @And("^User selects media type \"(.*)\"$")
    public void user_selects_media_type_something(String mediaType) {
        createNewPostPopUp.selectMedia(mediaType);
        this.mediaType=mediaType;
    }

    @And("^User adds link on media or uploads it \"(.*)\"$")
    public void user_adds_link_on_media_or_uploads_it_something(String pathToFile) {
        createNewPostPopUp.uploadMedia(pathToFile, mediaType);
    }

    @And("^User selects Ad type \"(.*)\"$")
    public void user_selects_ad_type_something(String adtype) {
        createNewPostPopUp.selectAdType(adtype);
    }

    @And("^User types Description \"(.*)\"$")
    public void user_types_description_something(String description) {
        createNewPostPopUp.typeDescription(description);
        this.description = description;
    }

    @And("^User click on Create Envygram button$")
    public void user_click_on_create_envygram_button() {
        createNewPostPopUp.clickButtonCreateEnvygram();
    }

    @Then("^New post is created$")
    public void new_post_is_created() {
         String res = postPage.getUploadResult(mediaType);
         if (mediaType.equals("Image From Computer")||mediaType.equals("Video Link")){
             Assert.assertEquals("Tittle should be equal", description, res);
         }
         else{
             Assert.assertEquals("Tittle should be equal", "uploaded", res);
         }
    }

    @Then("^Errors are appears \"(.*)\"$")
    public void errors_are_appears_something(String errors) {
        boolean isErrorsPresent = createNewPostPopUp.areErrorsPresent(errors);
        Assert.assertEquals("Errors should be present on the page", true, isErrorsPresent);
    }
}
