package Pages;

import Utilities.ElementsAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends  ElementsAction {

    public HomePage(WebDriver driver) { //constructor for login page

        super(driver); //to inherit all functions from the extended class
    }

    //POM syntax

    // tweetbox element
    @FindBy(xpath = "//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")
    WebElement TweetBox;
    // Tweetbutton element
    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[4]/div/div/div[2]/div/div/span/span")
    WebElement TweetButton;

    public void postTweet(String tweet) throws InterruptedException { //method to tweet
        Thread.sleep(1000); //suspend the execution from the webpage for 1000ms to wait the page load
        ElementsAction.setElementText(TweetBox, tweet);
        ElementsAction.clickButton(TweetButton);
        Thread.sleep(1500);


    }


}
