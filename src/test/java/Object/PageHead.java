package Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageHead {
    private By numberOfItemsInCartLockator = By.cssSelector("span.quantity");
    private WebDriver driver;

    public PageHead(WebDriver driver) {
        this.driver = driver;
    }

    public void waitToBeAddedToCart() {
        ProductPage productPage = new ProductPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBe(numberOfItemsInCartLockator,String.valueOf( productPage.getStockStatusInteger() + 1)));
    }
    public void waitToBeAddedToCart(String numberOfGoods) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBe(numberOfItemsInCartLockator,numberOfGoods));
    }
    public boolean getAreThereNoMoreItemsInTheCartThanInStock() {
        ProductPage productPage = new ProductPage(driver);
        return productPage.getStockStatusInteger() >= Integer.parseInt(driver.findElement(numberOfItemsInCartLockator).getText());
    }

    public String getNumberOfItemsInCart() {
        return driver.findElement(numberOfItemsInCartLockator).getText();
    }
}
