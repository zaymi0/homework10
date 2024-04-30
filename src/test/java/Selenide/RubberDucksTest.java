package Selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.SoftAsserts;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.*;

@Listeners({SoftAsserts.class})
public class RubberDucksTest {
@BeforeMethod
public void setup() {
    Configuration.baseUrl = "https://litecart.stqa.ru/en/";
    Configuration.browser = CHROME;
    Configuration.browserSize = "1920x1080";
    open(Configuration.baseUrl);
}
@AfterMethod
public void close() {
    closeWindow();
}
    @Test
        public void accountLogin() {
        LoginPage.attemptLogin("mihazx007@gmail.com", "QWERTY");
        HomePage.validateSuccessMassageText("You are now logged in as Mi Za.");
    }
    @Test
    public void displayLineAfterLogin() {
        LoginPage.attemptLogin("mihazx007@gmail.com", "QWERTY");
        HomePage.validateSuccessMassageText("You are now logged in as Mi Za.");
        HomePage.successMassageIsVisible();
    }

    @Test
    public void addingItemToCart() {
        CatalogPage.theGreenDuckInTheMostPopularBlockClick();
        ProductPage.enteringTheQuantityOfGoods("1");
        ProductPage.addToCartButtonClick();
        PageHead.waitToBeAddedToCart("1");
        PageHead.theItemsInTheCartCorrespondToTheExpectedOnes("1");
    }
    @Test
    public void addingMoreItemsToTheCartThanAreInStock() {
        CatalogPage.theGreenDuckInTheMostPopularBlockClick();
        ProductPage.enteringTheQuantityOfGoods(String.valueOf(ProductPage.getStockStatusInteger() + 1));
        ProductPage.addToCartButtonClick();
        PageHead.waitToBeAddedToCart();
        Assert.assertTrue(PageHead.getAreThereNoMoreItemsInTheCartThanInStock(),
                "There are more items in the cart than are in stock.");
    }

    @Test
    public void addingAProductToRecentlyViewed() {
        CatalogPage.theGreenDuckInTheMostPopularBlockClick();
        String titleOfTheSelectedProduct = title();
        RecentlyViewedPage.productFromTheRecentlyViewedPageClick();
        PageHead.thePageTitleMustMatchWhatIsExpected(titleOfTheSelectedProduct);
    }
}
