package ObjectProperties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void attemptLogin (String email, String password) {
        driver.findElement(Locators.getLocator("LoginPage.loginInput")).sendKeys(email);
        driver.findElement(Locators.getLocator("LoginPage.passwordInput")).sendKeys(password);
        driver.findElement(Locators.getLocator("LoginPage.loginButton")).click();
    }

    public void inputEmail (String email) {
        driver.findElement(Locators.getLocator("LoginPage.loginInput")).sendKeys(email);
    }

    public void inputPassword (String password) {
        driver.findElement(Locators.getLocator("LoginPage.passwordInput")).sendKeys(password);
    }

    public void clickLoginButton () {
        driver.findElement(Locators.getLocator("LoginPage.loginButton")).click();
    }



}
