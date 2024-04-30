package Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class Selenium {

    @Test
    public void myFirstTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            System.out.println(link.getAttribute("href"));
        }
        links.get(9).click();
        driver.quit();
    }

    @Test
    public void shouldReturnCorrectDataAfterFollowingTheLinkRubberDucks() {
        SoftAssert softAssert = new SoftAssert();
        String testTitleRubberDucks = "Rubber Ducks | My Store";
        String textTestRubberDucks = "Rubber Ducks";
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.cssSelector
                ("nav#site-menu [href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']")).click();
        WebElement pageTitle = driver.findElement(By.cssSelector("h1.title"));
        softAssert.assertEquals(driver.getTitle(), testTitleRubberDucks,"---");
        softAssert.assertEquals(pageTitle.getText(),textTestRubberDucks,"----");
        softAssert.assertAll();
        driver.quit();

    }
    @Test
    public void shouldReturnCorrectDataAfterFollowingTheLinkSubcategory() {
        SoftAssert softAssert = new SoftAssert();
        String titleSubcategory = "Subcategory | My Store";
        String textSubcategory = "Subcategory";
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement
                (By.cssSelector("nav#site-menu [href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']"))).perform();
        driver.findElement(By.cssSelector("nav#site-menu .category-2")).click();
        WebElement webElementPageTitle = driver.findElement(By.cssSelector("h1.title"));
        softAssert.assertEquals(driver.getTitle(),titleSubcategory);
        softAssert.assertEquals(webElementPageTitle.getText(),textSubcategory);
        softAssert.assertAll();
        driver.quit();
    }

    @Test
    public void shouldReturnTheCorrectDataForTheTransitionToTheHomeLink() {
        SoftAssert softAssert = new SoftAssert();
        String titleHome = "Online Store | My Store";
        String pictureHome = "https://litecart.stqa.ru/images/slides/1-lonely-duck.jpg";
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/rubber-ducks-c-1/");
        driver.findElement(By.cssSelector("li.general-0")).click();
        WebElement webElementPictureHome = driver.findElement
                (By.xpath("//*/img[@src='/images/slides/1-lonely-duck.jpg']"));
        softAssert.assertEquals(driver.getTitle(),titleHome);
        softAssert.assertEquals(webElementPictureHome.getAttribute("src"),pictureHome);
        softAssert.assertAll();
        driver.quit();
    }
}

