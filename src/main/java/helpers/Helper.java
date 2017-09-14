package helpers;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;

public class Helper {
    public static void allElementsLoaded(ArrayList<By> list) {
        for (By by : list) {
            $(by).shouldBe(Condition.visible);
        }
    }

    public static void waitMillis(int n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}




