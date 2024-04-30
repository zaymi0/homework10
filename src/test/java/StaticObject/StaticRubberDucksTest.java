package StaticObject;

import ObjectProperties.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class StaticRubberDucksTest {
    private WebDriver driver;
@BeforeMethod
public void setup() {
   Browser browser = Browser.valueOf(System.getProperty("browser", "edge"));
    driver = switch (browser) {
        case chrome -> new ChromeDriver();
        case edge -> new EdgeDriver();
    };
    driver.manage().window().maximize();
    driver.get("https://litecart.stqa.ru/en/");
}
@AfterMethod
public void end() {
    driver.quit();
}
    @Test
        public void accountLogin() {
        String successfulLoginText = "You are now logged in as Mi Za.";
        LoginPage.attemptLogin(driver,"mihazx007@gmail.com", "QWERTY");
        Assert.assertEquals(HomePage.getSuccessMassageText(driver), successfulLoginText,
                "The account login text does not match the specified one.");
    }
    @Test
    public void displayLineAfterLogin() {
        SoftAssert softAssert = new SoftAssert();
        String successfulLoginText = "You are now logged in as Mi Za.";
        LoginPage.attemptLogin(driver,"mihazx007@gmail.com", "QWERTY");
        softAssert.assertEquals(HomePage.getSuccessMassageText(driver), successfulLoginText,
                "The account login text does not match the specified one.");
        softAssert.assertTrue(HomePage.SuccessMassageIsVisible(driver), "The login message is not displayed");
        softAssert.assertAll();
    }

    @Test
    public void addingItemToCart() {
        CatalogPage.theGreenDuckInTheMostPopularBlockClick(driver);
        ProductPage.enteringTheQuantityOfGoods(driver, "1");
        ProductPage.addToCartButtonClick(driver);
        PageHead.waitToBeAddedToCart(driver, "1");
        Assert.assertEquals(PageHead.getNumberOfItemsInCart(driver),"1",
                "The displayed quantity of items in the cart does not match.");
    }
    @Test
    public void addingMoreItemsToTheCartThanAreInStock() {
        CatalogPage.theGreenDuckInTheMostPopularBlockClick(driver);
        ProductPage.enteringTheQuantityOfGoods(driver,String.valueOf(ProductPage.getStockStatusInteger(driver) + 1));
        ProductPage.addToCartButtonClick(driver);
        PageHead.waitToBeAddedToCart(driver);
        Assert.assertTrue(PageHead.getAreThereNoMoreItemsInTheCartThanInStock(driver),
                "There are more items in the cart than are in stock.");
    }

    @Test
    public void addingAProductToRecentlyViewed() {
        CatalogPage.theGreenDuckInTheMostPopularBlockClick(driver);
        String titleOfTheSelectedProduct = driver.getTitle();
        RecentlyViewedPage.productFromTheRecentlyViewedPageClick(driver);
        String titleOfTheProductDisplayedInTheListOfViewed = driver.getTitle();
        Assert.assertEquals(titleOfTheSelectedProduct,titleOfTheProductDisplayedInTheListOfViewed,
                "The selected product and the product from the viewed list do not match.");
    }
}
