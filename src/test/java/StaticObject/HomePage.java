package StaticObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private static By successMassageLocator = By.cssSelector(".notice.success");
    private static By errorMassageLocator = By.cssSelector(".notice.errors");

    public static String getSuccessMassageText(WebDriver driver) {
        return driver.findElement(successMassageLocator).getText();
    }

    public static String getErrorMassageText(WebDriver driver) {
        return driver.findElement(errorMassageLocator).getText();
    }

    public static boolean isErrorMassageIsVisible(WebDriver driver) {
        return driver.findElement(By.cssSelector(".notice.errors")).isDisplayed();
    }

    public static boolean SuccessMassageIsVisible(WebDriver driver) {
        return driver.findElement(By.cssSelector(".notice.success")).isDisplayed();
    }



}
