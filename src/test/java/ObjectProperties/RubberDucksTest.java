package ObjectProperties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class RubberDucksTest {
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
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        String successfulLoginText = "You are now logged in as Mi Za.";
        loginPage.attemptLogin("mihazx007@gmail.com", "QWERTY");
        Assert.assertEquals(homePage.getSuccessMassageText(), successfulLoginText,
                "The account login text does not match the specified one.");
    }
    @Test
    public void displayLineAfterLogin() {
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        String successfulLoginText = "You are now logged in as Mi Za.";
        loginPage.attemptLogin("mihazx007@gmail.com", "QWERTY");
        softAssert.assertEquals(homePage.getSuccessMassageText(), successfulLoginText,
                "The account login text does not match the specified one.");
        softAssert.assertTrue(homePage.SuccessMassageIsVisible(), "The login message is not displayed");
        softAssert.assertAll();
    }

    @Test
    public void addingItemToCart() {
        CatalogPage catalogPage = new CatalogPage(driver);
        PageHead pageHead = new PageHead(driver);
        ProductPage productPage = new ProductPage(driver);
        catalogPage.theGreenDuckInTheMostPopularBlockClick();
        productPage.enteringTheQuantityOfGoods("1");
        productPage.addToCartButtonClick();
        pageHead.waitToBeAddedToCart("1");
        Assert.assertEquals(pageHead.getNumberOfItemsInCart(),"1",
                "The displayed quantity of items in the cart does not match.");
    }
    @Test
    public void addingMoreItemsToTheCartThanAreInStock() {

        CatalogPage catalogPage = new CatalogPage(driver);
        PageHead pageHead = new PageHead(driver);
        ProductPage productPage = new ProductPage(driver);
        catalogPage.theGreenDuckInTheMostPopularBlockClick();
        productPage.enteringTheQuantityOfGoods(String.valueOf(productPage.getStockStatusInteger() + 1));
        productPage.addToCartButtonClick();
        pageHead.waitToBeAddedToCart();
        Assert.assertTrue(pageHead.getAreThereNoMoreItemsInTheCartThanInStock(),
                "There are more items in the cart than are in stock.");
    }

    @Test
    public void addingAProductToRecentlyViewed() {
        CatalogPage catalogPage = new CatalogPage(driver);
        RecentlyViewedPage recentlyViewedPage = new RecentlyViewedPage(driver);
        catalogPage.theGreenDuckInTheMostPopularBlockClick();
        String titleOfTheSelectedProduct = driver.getTitle();
        recentlyViewedPage.productFromTheRecentlyViewedPageClick();
        String titleOfTheProductDisplayedInTheListOfViewed = driver.getTitle();
        Assert.assertEquals(titleOfTheSelectedProduct,titleOfTheProductDisplayedInTheListOfViewed,
                "The selected product and the product from the viewed list do not match.");
    }
}
