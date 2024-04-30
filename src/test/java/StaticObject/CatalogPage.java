package StaticObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage {
    private static By theGreenDuckInTheMostPopularBlockLockator = By.cssSelector("#box-most-popular [href$='-p-2']");

    public static void theGreenDuckInTheMostPopularBlockClick(WebDriver driver) {
        driver.findElement(theGreenDuckInTheMostPopularBlockLockator).click();
    }
}

