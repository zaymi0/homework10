package Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private By successMassageLocator = By.cssSelector(".notice.success");
    private By errorMassageLocator = By.cssSelector(".notice.errors");

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccessMassageText() {
        return driver.findElement(successMassageLocator).getText();
    }

    public String getErrorMassageText() {
        return driver.findElement(errorMassageLocator).getText();
    }

    public boolean isErrorMassageIsVisible() {
        return driver.findElement(By.cssSelector(".notice.errors")).isDisplayed();
    }

    public boolean SuccessMassageIsVisible() {
        return driver.findElement(By.cssSelector(".notice.success")).isDisplayed();
    }



}
