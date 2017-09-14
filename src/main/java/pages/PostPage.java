package pages;


import org.openqa.selenium.By;
import popups.CreateNewPostPopUp;

import static com.codeborne.selenide.Selenide.$;

public class PostPage {
    private static final String TITLE_XPATH = ".//*[@id='content']/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/div[1]";
    private CreateNewPostPopUp createNewPostPopUp = new CreateNewPostPopUp();

    private String getPostDescription() {
        return $(By.xpath(TITLE_XPATH)).getAttribute("title");
    }

    public String getUploadResult(String mediaType) {
        String res;
        switch (mediaType) {
            case "Image From Computer":
            case "Video Link":
                res = getPostDescription();
                break;
            case "Image From Internet":
            case "Envygram Link":
                boolean isDisplayedPopUp = createNewPostPopUp.isCreateNewPostPopUpDisplayed();
                res = isDisplayedPopUp ? "not uploaded" : "uploaded";
                break;
            default:
                throw new RuntimeException("Invalid media type");
        }
        return res;
    }
}

