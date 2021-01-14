package Pages;

import Utilities.ElementsAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends  ElementsAction {

    public LoginPage(WebDriver driver) { //constructor for login page
        super(driver); //to inherit all functions from the extended class
    }

    //POM syntax

    // username element
    @FindBy(name = "session[username_or_email]")
    WebElement email;
    // pswd element
    @FindBy(name = "session[password]")
    WebElement password;
    // login button element
    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[3]/div/div")
    WebElement login;

    public void userLogin(String emails, String passwd) { //method to login
        ElementsAction.setElementText(email, emails);
        ElementsAction.setElementText(password, passwd);
        ElementsAction.clickButton(login);

    }


}
