package popups;


import com.codeborne.selenide.Condition;
import helpers.Helper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CreateNewPostPopUp {

    private final String FIELD_HEADLINE_XPATH = ".//div[@id='createNewPostDialog']//*[@id='PostCreate_header']";
    private final String DROPDOWN_MENU_MEDIA_XPATH = ".//div[@id='createNewPostDialog']//*[@id='PostCreate']/div[1]/div[2]/div/div[2]/div[1]";
    private final String DROPDOWN_MENU_AD_TYPE_XPATH = ".//div[@id='createNewPostDialog']//*[@id='PostCreate_adType']";
    private final String BUTTON_BROWSE_FILE_XPATH = ".//span[contains(text(), 'Browse file')]/..";
    private final String TEXT_AREA_DESCRION_XPATH = ".//div[@id='createNewPostDialog']//textarea[@id='PostCreate_description']";
    private final String BUTTON_CANCEL_XPATH = ".//*[@id='createNewPostDialog']/div[3]/div[1]/a[1]";
    private final String BUTTON_CREATE_ENVYGRAM_XPATH = ".//*[@id='createNewPostDialog']//*[@id='createNewPost']/span[1]";
    private final String BUTTON_CLOSE_CLASS = ".//div[@id='createNewPostDialog']//*[@id='createNewPostDialog']/div[1]/button";

    private final String FIELD_SOURCE_FROM_WEB_XPATH = ".//div[@id='uploadFromWebsiteDialog']//input[@id='PostCreate_source']";
    private final String FIELD_SOURCE_FROM_Envygram_XPATH = ".//div[@id='uploadFromEnvygramDialog']//input[@id='PostCreate_source']";
    private final String FIELD_SOURCE_VIDEO_XPATH = ".//div[@id='uploadFromEmbedcodeDialog']//textarea[@id='PostCreate_source']";
    private final String BUTTON_SAVE_LINK = "Save";
    private final String BUTTON_REPOST_ENVYGRAM_LINK = "Repost";

    private final String ERRORS_XPATH_CONTAINS = ".//span[contains(text(), '%s')]";

    final static Logger logger = Logger.getLogger(CreateNewPostPopUp.class);


    public boolean isErrorPresent(String error){
       boolean res =  $(By.xpath(String.format(ERRORS_XPATH_CONTAINS, error))).isDisplayed();
       logger.info(String.format("Error message %s is present on the page - %s", error, res));
       return res;
    }

    public boolean areErrorsPresent(String errors){
        Helper.waitMillis(1000);
        String errorsArray[] = errors.split(", ");
        for (String error : errorsArray) {
            boolean isErrorPresent = isErrorPresent(error);
            if (!isErrorPresent) return false;
        }
        return true;
    }

    public void typeHeadline(String headline) {
        $(By.xpath(FIELD_HEADLINE_XPATH)).click();
        $(By.xpath(FIELD_HEADLINE_XPATH)).sendKeys(headline);
    }

    public void selectMedia(String mediaType) {
        $(By.xpath(DROPDOWN_MENU_MEDIA_XPATH)).click();
        $(By.linkText(mediaType)).click();
    }

    public void browseFile() {
        $(By.xpath(BUTTON_BROWSE_FILE_XPATH)).click();
    }

    public void selectAdType(String adType) {
        $(By.xpath(DROPDOWN_MENU_AD_TYPE_XPATH)).selectOptionContainingText(adType);
    }

    public void typeDescription(String description) {
        $(By.xpath(TEXT_AREA_DESCRION_XPATH)).click();
        $(By.xpath(TEXT_AREA_DESCRION_XPATH)).setValue(description);
    }

    public void clickButtonCreateEnvygram() {
        $(By.xpath(BUTTON_CREATE_ENVYGRAM_XPATH)).click();
    }

    public void clickButtonRepostEnvygram() {
        $(By.linkText(BUTTON_REPOST_ENVYGRAM_LINK)).click();
    }

    public void clickButtonSaveLink() {
        $(By.linkText(BUTTON_SAVE_LINK)).click();
    }

    public boolean isCreateNewPostPopUpDisplayed() {
        $(By.xpath(FIELD_HEADLINE_XPATH)).waitUntil(Condition.disappear, 15000);
        boolean res = $(By.xpath(FIELD_HEADLINE_XPATH)).isDisplayed();
        logger.info(String.format("Post Pop Up IsDisplayed - %s", String.valueOf(res)));
        return res;
    }

    private void insertLinkAndSave(String xpath, String pathToFile) {
        $(By.xpath(xpath)).click();
        $(By.xpath(xpath)).click();
        $(By.xpath(xpath)).sendKeys(pathToFile);
    }

    public void uploadMedia(String pathToFile, String mediaType) {
        switch (mediaType) {
            case "Image From Computer":
                browseFile();
                try {
                    Runtime.getRuntime().exec("src/main/resources/my_script.exe");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Helper.waitMillis(5000);
                break;
            case "Image From Internet":
                insertLinkAndSave(FIELD_SOURCE_FROM_WEB_XPATH, pathToFile);
                clickButtonSaveLink();
                break;
            case "Envygram Link":
                insertLinkAndSave(FIELD_SOURCE_FROM_Envygram_XPATH, pathToFile);
                clickButtonRepostEnvygram();
                break;
            case "Video Link":
                insertLinkAndSave(FIELD_SOURCE_VIDEO_XPATH, pathToFile);
                clickButtonSaveLink();
                break;
            default:
                throw new RuntimeException("Invalid media type");
        }

    }


}
