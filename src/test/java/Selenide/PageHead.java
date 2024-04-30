package Selenide;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

public class PageHead {
    private static By numberOfItemsInCartLockator = By.cssSelector("span.quantity");

    public static void waitToBeAddedToCart() {
        $(numberOfItemsInCartLockator).shouldHave(text(String.valueOf(ProductPage.getStockStatusInteger() + 1)));
    }

    public static void waitToBeAddedToCart(String numberOfGoods) {
        $(numberOfItemsInCartLockator).shouldHave(text(numberOfGoods));
    }

    public static boolean getAreThereNoMoreItemsInTheCartThanInStock() {
        return ProductPage.getStockStatusInteger() >= Integer.parseInt($(numberOfItemsInCartLockator).getText());
    }

    public static String getNumberOfItemsInCart() {
        return $(numberOfItemsInCartLockator).getText();
    }

    public static void theItemsInTheCartCorrespondToTheExpectedOnes(String expected) {
        $(numberOfItemsInCartLockator).shouldHave(text(expected));
    }

    public static void thePageTitleMustMatchWhatIsExpected(String expectedTitle) {
        $(title()).shouldHave(text(expectedTitle));
    }

    public static void theNumberOfItemsInTheCartDoesNotExceedTheQuantityInStock(String expected) {
        $(numberOfItemsInCartLockator).shouldHave(text(expected));

    }
}