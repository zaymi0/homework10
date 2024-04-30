package ObjectProperties;

import org.openqa.selenium.By;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Locators {
    private static Properties locators;

    static {
        locators = new Properties();
        InputStream is = Locators.class.getResourceAsStream("/locators.properties");
        try {
            locators.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static By getLocator(String elementName){
        String locatorText = locators.getProperty(elementName);
        String[] fullLocators = locatorText.split("=",2);
        String locatorValue = fullLocators[1];
       By by = switch (LocatorType.valueOf(fullLocators[0])) {
            case css -> By.cssSelector(locatorValue);
            case name -> By.name(locatorValue);
        };
       return by;
    }
}
