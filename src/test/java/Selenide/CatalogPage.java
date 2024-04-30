package Selenide;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {
    private static By theGreenDuckInTheMostPopularBlockLockator = By.cssSelector("#box-most-popular [href$='-p-2']");

    public static void theGreenDuckInTheMostPopularBlockClick() {
        $(theGreenDuckInTheMostPopularBlockLockator).click();
    }
}

