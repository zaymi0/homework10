package ObjectProperties;

import org.openqa.selenium.WebDriver;

public class RecentlyViewedPage {
    private WebDriver driver;

    public RecentlyViewedPage(WebDriver driver) {
        this.driver = driver;
    }

    public void productFromTheRecentlyViewedPageClick() {
        driver.findElement
                (Locators.getLocator("RecentlyViewedPage.productFromTheRecentlyViewedPage")).click();
    }

}
