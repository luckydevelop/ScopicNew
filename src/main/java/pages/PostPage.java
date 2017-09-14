package pages;


import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PostPage {
    private static final String TITLE_XPATH = ".//*[@id='content']/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/div[1]";

    public String getPostDescription(){
        return $(By.xpath(TITLE_XPATH)).getAttribute("title");
    }

}

