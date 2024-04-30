package ObjectProperties;

import org.openqa.selenium.WebDriver;

public class CatalogPage {
    private WebDriver driver;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    public void theGreenDuckInTheMostPopularBlockClick() {
        driver.findElement(Locators.getLocator("CatalogPage.theGreenDuckInTheMostPopularBlock")).click();
    }
}

