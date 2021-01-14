package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ElementsAction {

    public WebDriver driver;
    public ElementsAction(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public static void clickButton(WebElement button) {
        button.click();
    }
    public static void setElementText (WebElement settxtElement , String txt) {
        settxtElement.sendKeys(txt);
    }
}
