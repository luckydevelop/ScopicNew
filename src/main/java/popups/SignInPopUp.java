package popups;


import helpers.Helper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SignInPopUp {
    private final String USERNAME_FIELD_ID = "UserLogin_email";
    private final String PASSWORD_FIELD_ID = "UserLogin_password";
    private final String SIGN_IN_BUTTON_ID = "signIn";
    private final String FORGOT_PASSWORD_LINK_ID = "forgotDialogButton";
    private final String SIGN_UP_NOW_PARTIAL_LINK = "Sign Up Now";
    private final String TWITTER_BUTTON_XPATH = ".//*[@id='loginDialog']/div[4]/div/div/div/span[2]/a";
    private final String FACEBOOK_BUTTON_XPATH = ".//*[@id='loginDialog']/div[4]/div/div/div/span[3]/a";
    private final String INSTAGRAM_BUTTON_XPATH = ".//*[@id='loginDialog']/div[4]/div/div/div/span[4]/a";
    private final String CLOSE_BUTTON_PARTIAL_XPATH = ".//*[@id='loginDialog']/div[1]/button";
    private final String USERNAME_FIELD_ERROR_ID = "UserLogin_email_em_";
    private final String PASSWORD_FIELD_ERROR_ID = "UserLogin_password_em_";
    private final String CREDENTIAL_ERROR_XPATH = ".//span[contains(text(), 'Please')]";

    private static final Logger log = Logger.getLogger(SignInPopUp.class);

    public SignInPopUp inputUsername(String username) {
        log.info(username);
        $(By.id(USERNAME_FIELD_ID)).click();
        $(By.id(USERNAME_FIELD_ID)).val(username);
        return page(SignInPopUp.class);
    }

    public SignInPopUp inputPassword(String password) {
        $(By.id(PASSWORD_FIELD_ID)).click();
        $(By.id(PASSWORD_FIELD_ID)).val(password);
        return page(SignInPopUp.class);
    }

    public void clickSignInButton() {
        $(By.id(SIGN_IN_BUTTON_ID)).click();
    }

    public String getUsernameFieldError() {
        Helper.waitMillis(500);
        String text;
        if ($(By.id(USERNAME_FIELD_ERROR_ID)).isDisplayed()) {
            text = $(By.id(USERNAME_FIELD_ERROR_ID)).getText();
            log.info(String.format("Password field error is - %s", text));
        } else
            text = "";
        return text;
    }

    public String getPasswordFieldError() {
        Helper.waitMillis(500);
        String text;
        if ($(By.id(PASSWORD_FIELD_ERROR_ID)).isDisplayed()) {
            text = $(By.id(PASSWORD_FIELD_ERROR_ID)).getText();
            log.info(String.format("Password field error is - %s", text));
        } else
            text = "";
        return text;
    }

    public String getCredentialError() {

        return $(By.xpath(CREDENTIAL_ERROR_XPATH)).getText();
    }

    public SignInPopUp allElementsLoaded() {
        ArrayList<By> listLocators = new ArrayList<>();
        listLocators.add(By.id(USERNAME_FIELD_ID));
        listLocators.add(By.id(PASSWORD_FIELD_ID));
        listLocators.add(By.id(SIGN_IN_BUTTON_ID));
        listLocators.add(By.id(FORGOT_PASSWORD_LINK_ID));
        listLocators.add(By.partialLinkText(SIGN_UP_NOW_PARTIAL_LINK));
        listLocators.add(By.xpath(TWITTER_BUTTON_XPATH));
        listLocators.add(By.xpath(FACEBOOK_BUTTON_XPATH));
        listLocators.add(By.xpath(INSTAGRAM_BUTTON_XPATH));
        listLocators.add(By.xpath(CLOSE_BUTTON_PARTIAL_XPATH));
        Helper.allElementsLoaded(listLocators);
        return page(SignInPopUp.class);
    }

}
