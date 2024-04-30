package ObjectProperties;

import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enteringTheQuantityOfGoods(String numberOfGoods) {
        driver.findElement(Locators.getLocator("ProductPage.fieldForEnteringTheQuantityOfGoods")).clear();
        driver.findElement(Locators.getLocator("ProductPage.fieldForEnteringTheQuantityOfGoods")).sendKeys(numberOfGoods);
    }

    public void addToCartButtonClick() {
        driver.findElement(Locators.getLocator("ProductPage.addToCartButton")).click();
    }

    public int getStockStatusInteger() {
        String[] stockStatus = driver.findElement
                (Locators.getLocator("ProductPage.stockStatus")).getText().split(" ");
        return Integer.parseInt(stockStatus[0]);
    }

}
