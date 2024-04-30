package StaticObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private static By stockStatusLockator = By.cssSelector("div.stock-available>span.value");
    private static By fieldForEnteringTheQuantityOfGoodsLockator = By.cssSelector("input[type='number']");
    private static By addToCartButtonLockator = By.cssSelector("button[value='Add To Cart']");
    public static void enteringTheQuantityOfGoods(WebDriver driver, String numberOfGoods) {
        driver.findElement(fieldForEnteringTheQuantityOfGoodsLockator).clear();
        driver.findElement(fieldForEnteringTheQuantityOfGoodsLockator).sendKeys(numberOfGoods);
    }

    public static void addToCartButtonClick(WebDriver driver) {
        driver.findElement(addToCartButtonLockator).click();
    }

    public static int getStockStatusInteger(WebDriver driver) {
        String[] stockStatus = driver.findElement(By.cssSelector("div.stock-available>span.value")).getText().split(" ");
        return Integer.parseInt(stockStatus[0]);
    }

}
