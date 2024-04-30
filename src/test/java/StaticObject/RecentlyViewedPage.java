package StaticObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecentlyViewedPage {
    private static By productFromTheRecentlyViewedPageLockator =
            By.cssSelector("#box-recently-viewed-products li:nth-child(1)");

    public static void productFromTheRecentlyViewedPageClick(WebDriver driver) {
        driver.findElement(productFromTheRecentlyViewedPageLockator).click();
    }

}
