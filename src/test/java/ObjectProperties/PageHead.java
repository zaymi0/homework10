package ObjectProperties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageHead {
    private WebDriver driver;

    public PageHead(WebDriver driver) {
        this.driver = driver;
    }

    public void waitToBeAddedToCart() {
        ProductPage productPage = new ProductPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBe
                (Locators.getLocator("PageHead.numberOfItemsInCart"),
                        String.valueOf( productPage.getStockStatusInteger() + 1)));
    }
    public void waitToBeAddedToCart(String numberOfGoods) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBe
                (Locators.getLocator("PageHead.numberOfItemsInCart"), numberOfGoods));
    }
    public boolean getAreThereNoMoreItemsInTheCartThanInStock() {
        ProductPage productPage = new ProductPage(driver);
        return productPage.getStockStatusInteger() >=
                Integer.parseInt
                        (driver.findElement(Locators.getLocator("PageHead.numberOfItemsInCart")).getText());
    }

    public String getNumberOfItemsInCart() {
        return driver.findElement(Locators.getLocator("PageHead.numberOfItemsInCart")).getText();
    }
}
