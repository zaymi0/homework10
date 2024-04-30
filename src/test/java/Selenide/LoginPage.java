package Selenide;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private static By loinInputLocator = By.name("email");
    private static By passwordInputLocator = By.name("password");
    private static By loginButtonLocator = By.name("login");

    public static void attemptLogin (String email, String password) {
        $(loinInputLocator).sendKeys(email);
        $(passwordInputLocator).sendKeys(password);
        $(loginButtonLocator).click();
    }

    public static void inputEmail (String email) {
        $(loginButtonLocator).sendKeys(email);
    }

    public static void inputPassword (String password) {
        $(passwordInputLocator).sendKeys(password);
    }

    public static void clickLoginButton () {
        $(loinInputLocator).click();
    }



}
