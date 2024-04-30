package Selenide;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private static By successMassageLocator = By.cssSelector(".notice.success");
    private static By errorMassageLocator = By.cssSelector(".notice.errors");

    public static String getSuccessMassageText() {
        return $(successMassageLocator).getText();
    }

    public static String getErrorMassageText() {
        return $(errorMassageLocator).getText();
    }

    public static boolean isErrorMassageIsVisible() {
        return $(errorMassageLocator).isDisplayed();
    }

//    public static boolean successMassageIsVisible() {
//        return $(By.cssSelector(".notice.success")).isDisplayed();
//    }

    public static void validateSuccessMassageText(String successfulLoginText) {
        $(successMassageLocator).shouldHave(text(successfulLoginText));
    }
    public static void successMassageIsVisible() {
        $(successMassageLocator).shouldBe(visible);
    }


}
