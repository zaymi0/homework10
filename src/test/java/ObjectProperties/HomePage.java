package ObjectProperties;

import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccessMassageText() {
        return driver.findElement(Locators.getLocator("HomePage.successMassage")).getText();
    }

    public String getErrorMassageText() {
        return driver.findElement(Locators.getLocator("HomePage.errorMassage")).getText();
    }

    public boolean isErrorMassageIsVisible() {
        return driver.findElement(Locators.getLocator("HomePage.errorMassage")).isDisplayed();
    }

    public boolean SuccessMassageIsVisible() {
        return driver.findElement(Locators.getLocator("HomePage.successMassage")).isDisplayed();
    }



}
