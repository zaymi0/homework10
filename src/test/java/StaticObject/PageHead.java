package StaticObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageHead {
    private static By numberOfItemsInCartLockator = By.cssSelector("span.quantity");
    public static void waitToBeAddedToCart(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBe(numberOfItemsInCartLockator,String.valueOf( ProductPage.getStockStatusInteger(driver) + 1)));
    }
    public static void waitToBeAddedToCart(WebDriver driver, String numberOfGoods) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBe(numberOfItemsInCartLockator,numberOfGoods));
    }
    public static boolean getAreThereNoMoreItemsInTheCartThanInStock(WebDriver driver) {
        return ProductPage.getStockStatusInteger(driver) >= Integer.parseInt(driver.findElement(numberOfItemsInCartLockator).getText());
    }

    public static String getNumberOfItemsInCart(WebDriver driver) {
        return driver.findElement(numberOfItemsInCartLockator).getText();
    }
}
