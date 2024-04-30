package StaticObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private static By loinInputLocator = By.name("email");
    private static By passwordInputLocator = By.name("password");
    private static By loginButtonLocator = By.name("login");

    public static void attemptLogin (WebDriver driver, String email, String password) {
        driver.findElement(loinInputLocator).sendKeys(email);
        driver.findElement(passwordInputLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }

    public static void inputEmail (WebDriver driver, String email) {
        driver.findElement(loginButtonLocator).sendKeys(email);
    }

    public static void inputPassword (WebDriver driver, String password) {
        driver.findElement(passwordInputLocator).sendKeys(password);
    }

    public static void clickLoginButton (WebDriver driver) {
        driver.findElement(loinInputLocator).click();
    }



}
