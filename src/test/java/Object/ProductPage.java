package Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private By stockStatusLockator = By.cssSelector("div.stock-available>span.value");
    private By fieldForEnteringTheQuantityOfGoodsLockator = By.cssSelector("input[type='number']");
    private By addToCartButtonLockator = By.cssSelector("button[value='Add To Cart']");

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enteringTheQuantityOfGoods(String numberOfGoods) {
        driver.findElement(fieldForEnteringTheQuantityOfGoodsLockator).clear();
        driver.findElement(fieldForEnteringTheQuantityOfGoodsLockator).sendKeys(numberOfGoods);
    }

    public void addToCartButtonClick() {
        driver.findElement(addToCartButtonLockator).click();
    }

    public int getStockStatusInteger() {
        String[] stockStatus = driver.findElement(By.cssSelector("div.stock-available>span.value")).getText().split(" ");
        return Integer.parseInt(stockStatus[0]);
    }

}
