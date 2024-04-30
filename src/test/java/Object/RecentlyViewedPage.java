package Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecentlyViewedPage {
    private By productFromTheRecentlyViewedPageLockator = By.cssSelector("#box-recently-viewed-products li:nth-child(1)");

    private WebDriver driver;

    public RecentlyViewedPage(WebDriver driver) {
        this.driver = driver;
    }

    public void productFromTheRecentlyViewedPageClick() {
        driver.findElement(productFromTheRecentlyViewedPageLockator).click();
    }

}
