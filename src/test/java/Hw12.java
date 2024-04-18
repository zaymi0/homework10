import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


public class Hw12 {

    @Test
        public void accountLogin() {
        SoftAssert softAssert = new SoftAssert();
        String successfulLoginText = "You are now logged in as Mi Za.";
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.cssSelector
                ("[name = email]")).sendKeys("mihazx007@gmail.com");
        driver.findElement(By.cssSelector
                ("[name = password]")).sendKeys("QWERTY");
        driver.findElement(By.cssSelector("[name = login]")).click();
        softAssert.assertEquals(driver.findElement(By.cssSelector(".notice.success")).getText(),
                successfulLoginText,"The account login text does not match the specified one.");
        driver.quit();
        softAssert.assertAll();
    }
    @Test
    public void displayLineAfterLogin() {
        SoftAssert softAssert = new SoftAssert();
        String successfulLoginText = "You are now logged in as Mi Za.";
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.cssSelector
                ("[name = email]")).sendKeys("mihazx007@gmail.com");
        driver.findElement(By.cssSelector
                ("[name = password]")).sendKeys("QWERTY");
        driver.findElement(By.cssSelector("[name = login]")).click();
        softAssert.assertEquals(driver.findElement(By.cssSelector("[class = 'notice success']")).getText(),
                successfulLoginText,"The account login text does not match the specified one.");
        WebElement loginMassage = driver.findElement(By.cssSelector(".notice.success"));
        boolean loginMassageIsVisible = loginMassage.isDisplayed();
        softAssert.assertTrue(loginMassageIsVisible, "The login message is not displayed");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void addingItemToCart() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.cssSelector("#box-most-popular.box .image[alt='Green Duck']")).click();
        driver.findElement(By.cssSelector("button[value='Add To Cart']")).click();
        WebElement numberOfItemsInTheCart = driver.findElement(By.cssSelector("span.quantity"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"),"1"));
        softAssert.assertEquals(numberOfItemsInTheCart.getText(),"1",
                "The displayed quantity of items in the cart does not match.");
        driver.quit();
        softAssert.assertAll();
    }
    @Test
    public void addingMoreItemsToTheCartThanAreInStock() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.cssSelector("#box-most-popular.box .image[alt='Green Duck']")).click();
        String[] stockStatus = driver.findElement(By.cssSelector("div.stock-available>span.value")).getText().split(" ");
        int maximumNumberOfProducts = Integer.parseInt(stockStatus[0]);
        driver.findElement(By.cssSelector("input[type='number']")).clear();
        driver.findElement(By.cssSelector("input[type='number']")).sendKeys(String.valueOf(maximumNumberOfProducts + 1));
        driver.findElement(By.cssSelector("button[value='Add To Cart']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"),String.valueOf(maximumNumberOfProducts + 1)));
        boolean comparisonOfTheMaximumValueInTheWarehouseAndTheValueInTheCart =
                maximumNumberOfProducts > Integer.parseInt(driver.findElement(By.cssSelector(("span.quantity"))).getText());
        softAssert.assertTrue(comparisonOfTheMaximumValueInTheWarehouseAndTheValueInTheCart,
                "There are more items in the cart than are in stock.");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void addingAProductToRecentlyViewed() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.cssSelector(".content>.listing-wrapper.products :first-child")).click();
        String titleOfTheSelectedProduct = driver.getTitle();
        driver.findElement(By.cssSelector(".content>.list-horizontal :first-child")).click();
        String titleOfTheProductDisplayedInTheListOfViewed = driver.getTitle();
        softAssert.assertEquals(titleOfTheSelectedProduct,titleOfTheProductDisplayedInTheListOfViewed,
                "The selected product and the product from the viewed list do not match.");
        driver.quit();
        softAssert.assertAll();
    }
}
