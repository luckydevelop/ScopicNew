package popups;


import com.codeborne.selenide.Condition;
import helpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CreateNewPostPopUp {

    private final String FIELD_HEADLINE_XPATH = ".//div[@id='createNewPostDialog']//*[@id='PostCreate_header']";
    private final String DROPDOWN_MENU_MEDIA_XPATH = ".//div[@id='createNewPostDialog']//*[@id='PostCreate']/div[1]/div[2]/div/div[2]/div[1]";
   // private final String DROPDOWN_MENU_MEDIA_XPATH = ".//div[@id='createNewPostDialog']//*[@id='PostCreate']/div[1]/div[2]/div/div[2]/div[1]/a[2]";
    private final String DROPDOWN_MENU_AD_TYPE_XPATH = ".//div[@id='createNewPostDialog']//*[@id='PostCreate_adType']";

    private final String BUTTON_BROWSE_FILE_XPATH = ".//span[contains(text(), 'Browse file')]/..";
    private final String TEXT_AREA_DESCRION_XPATH = ".//div[@id='createNewPostDialog']//textarea[@id='PostCreate_description']";
    private final String BUTTON_CANCEL_XPATH = ".//*[@id='createNewPostDialog']/div[3]/div[1]/a[1]";
    private final String BUTTON_CREATE_ENVYGRAM_XPATH = ".//*[@id='createNewPostDialog']//*[@id='createNewPost']/span[1]";
    private final String BUTTON_CLOSE_CLASS = ".//div[@id='createNewPostDialog']//*[@id='createNewPostDialog']/div[1]/button";

    public void typeHeadline(String headline){
        $(By.xpath(FIELD_HEADLINE_XPATH)).click();
        $(By.xpath(FIELD_HEADLINE_XPATH)).sendKeys(headline);
    }

    public void selectMedia(String mediaType){
        $(By.xpath(DROPDOWN_MENU_MEDIA_XPATH)).click();
        $(By.linkText(mediaType)).click();
    }

    public void browseFile(){
        $(By.xpath(BUTTON_BROWSE_FILE_XPATH)).click();
    }

    public void selectAdType(String adType){
        $(By.xpath(DROPDOWN_MENU_AD_TYPE_XPATH)).selectOptionContainingText(adType);
    }

    public void typeDescription(String description){
        $(By.xpath(TEXT_AREA_DESCRION_XPATH)).click();
        $(By.xpath(TEXT_AREA_DESCRION_XPATH)).setValue(description);
    }

    public void clickCreateEnvygram(){
        $(By.xpath(BUTTON_CREATE_ENVYGRAM_XPATH)).click();
    }

}
