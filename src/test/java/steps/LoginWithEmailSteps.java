package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.Helper;
import org.junit.Assert;
import pages.HomePage;
import pages.LandingPage;
import popups.SignInPopUp;

public class LoginWithEmailSteps {
    LandingPage landingPage = new LandingPage();
    SignInPopUp signInPopUp = new SignInPopUp();
    HomePage homePage = new HomePage();

    @Given("^LandingPage is opened$")
    public void homepage_is_opened() {
        landingPage.open().allElementsLoaded();
    }

    @When("^User clicks Log in link$")
    public void user_clicks_Log_in_link() {
        landingPage.clickLogInLink();
    }

    @When("^SignIn popup is loaded$")
    public void signin_popup_is_loaded()  {
        signInPopUp.allElementsLoaded();
    }

    @When("^User Signs in with login \"(.*)\" and password \"(.*)\"$")
    public void user_Signs_in_with_login_and_password(String username, String password) {
        signInPopUp.inputUsername(username);
        signInPopUp.inputPassword(password);
        signInPopUp.clickSignInButton();
    }

    @Then("^HomePage is loaded$")
    public void homepage_is_loaded() {
        homePage.allElementsLoaded();
    }

    @Then("^Error message \"(.*)\" appears in username field$")
    public void error_message_appears_in_username_field(String errorMessage){
        Assert.assertEquals(String.format("Expected error message should be - %s", errorMessage), errorMessage, signInPopUp.getUsernameFieldError());
    }

    @Then("^Error message \"(.*)\" appears in password field$")
    public void error_message_appears_in_password_field(String errorMessage) {
        Assert.assertEquals(String.format("Expected error message should be - %s", errorMessage), errorMessage, signInPopUp.getPasswordFieldError());
    }

    @Then("^Error message under login field \"(.*)\" appears$")
    public void error_message_under_login_field_appears(String errorMessage) {
        Assert.assertEquals(String.format("Expected error message should be - %s", errorMessage), errorMessage, signInPopUp.getCredentialError());
    }

}
