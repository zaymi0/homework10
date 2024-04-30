package Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage {
    private By theGreenDuckInTheMostPopularBlockLockator = By.cssSelector("#box-most-popular [href$='-p-2']");
    private WebDriver driver;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    public void theGreenDuckInTheMostPopularBlockClick() {
        driver.findElement(theGreenDuckInTheMostPopularBlockLockator).click();
    }
}

