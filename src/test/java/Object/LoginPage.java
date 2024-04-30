package Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private By loinInputLocator = By.name("email");
    private By passwordInputLocator = By.name("password");
    private By loginButtonLocator = By.name("login");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void attemptLogin (String email, String password) {
        driver.findElement(loinInputLocator).sendKeys(email);
        driver.findElement(passwordInputLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }

    public void inputEmail (String email) {
        driver.findElement(loginButtonLocator).sendKeys(email);
    }

    public void inputPassword (String password) {
        driver.findElement(passwordInputLocator).sendKeys(password);
    }

    public void clickLoginButton () {
        driver.findElement(loinInputLocator).click();
    }



}
