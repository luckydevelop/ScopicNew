package pages;

import helpers.Helper;
import org.openqa.selenium.By;
import popups.CreateNewPostPopUp;
import popups.SignInPopUp;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HomePage {

    private final String SEARCH_FIELD_ID = "search";
    private final String DROPDOWN_TOGGLE_CLASS = "dropdown-toggle";
    private final String AVATAR_CLASS = "image";
    private final String USERNAME_CSS = ".username";
    private final String NOTIFICATION_CSS = ".label";
    private final String SETTINGS_CLASS = "settingsButtonLabel";
    private final String CRETE_NEW_POST_ITEM_LINKTEXT = "Create New Post";

    public HomePage clickDropdownToggle(){
        $(By.className(DROPDOWN_TOGGLE_CLASS)).click();
        return page(HomePage.class);
    }

    public CreateNewPostPopUp clickCreateNewPostItem(){
        $(By.partialLinkText(CRETE_NEW_POST_ITEM_LINKTEXT)).click();
        return page(CreateNewPostPopUp.class);
    }

    public HomePage allElementsLoaded()
    {
        ArrayList<By> listLocators = new ArrayList<By>();
        listLocators.add(By.id(SEARCH_FIELD_ID));
        listLocators.add(By.className(DROPDOWN_TOGGLE_CLASS));
        listLocators.add(By.className(AVATAR_CLASS));
        listLocators.add(By.cssSelector(USERNAME_CSS));
        listLocators.add(By.cssSelector(NOTIFICATION_CSS));
        listLocators.add(By.className(SETTINGS_CLASS));
          Helper.allElementsLoaded(listLocators);
        return page(HomePage.class);
    }


}
