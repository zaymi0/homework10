package Selenide;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class RecentlyViewedPage {
    private static By productFromTheRecentlyViewedPageLockator = By.cssSelector("#box-recently-viewed-products li:nth-child(1)");

    public static void productFromTheRecentlyViewedPageClick() {
        $(productFromTheRecentlyViewedPageLockator).click();
    }

}
