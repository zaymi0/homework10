package Selenide;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private static By stockStatusLockator = By.cssSelector("div.stock-available>span.value");
    private static By fieldForEnteringTheQuantityOfGoodsLockator = By.cssSelector("input[type='number']");
    private static By addToCartButtonLockator = By.cssSelector("button[value='Add To Cart']");

    public static void enteringTheQuantityOfGoods(String numberOfGoods) {
        $(fieldForEnteringTheQuantityOfGoodsLockator).clear();
        $(fieldForEnteringTheQuantityOfGoodsLockator).sendKeys(numberOfGoods);
    }

    public static void addToCartButtonClick() {
        $(addToCartButtonLockator).click();
    }

    public static int getStockStatusInteger() {
        String[] stockStatus = $(By.cssSelector("div.stock-available>span.value")).getText().split(" ");
        return Integer.parseInt(stockStatus[0]);
    }

}
