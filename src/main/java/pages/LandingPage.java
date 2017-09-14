package pages;

import com.codeborne.selenide.Selenide;
import helpers.Helper;
import helpers.PropertiesFromFile;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;


public class LandingPage {

    private final String LOGIN_LINK_ID = "loginDialogButton";
    private final String JOIN_BUTTON_ID = "joinEnvygramBtn";
    private final String RIGHT_BOTTOM_BUTTONS_ID = "joinEnvygramBtn";

    public LandingPage open() {
        Selenide.open(PropertiesFromFile.getProperties().getProperty("landing.page"));
        return page(LandingPage.class);
    }

    public void clickLogInLink() {
        $(By.id(LOGIN_LINK_ID)).click();
    }

    public LandingPage allElementsLoaded() {
        ArrayList<By> listLocators = new ArrayList<>();
        listLocators.add(By.id(LOGIN_LINK_ID));
        listLocators.add(By.id(JOIN_BUTTON_ID));
        listLocators.add(By.id(RIGHT_BOTTOM_BUTTONS_ID));
        Helper.allElementsLoaded(listLocators);
        return page(LandingPage.class);
    }
}
