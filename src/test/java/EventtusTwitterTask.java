import Utilities.BaseClass;
import Utilities.RandomStringGenerator;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EventtusTwitterTask extends BaseClass {

    RandomStringGenerator generateText = new RandomStringGenerator();

   /*TC#1: Check Tweet button is dimmed while tweeting box is empty.*/
  /*  @Test
    public void CheckTweetButton()
    {

        WebElement UserName = driver.findElement(By.name("session[username_or_email]"));
        UserName.sendKeys("joefcih@gmail.com");

        WebElement Password = driver.findElement(By.name("session[password]"));
        Password.sendKeys("Ahmed@fcih2011");

        WebElement LoginButton = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[3]/div/div"));
        LoginButton.click();

        WebElement DimmedTweetButton = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[2]/div/div/div[2]/div"));
        String buttonDisableValue = DimmedTweetButton.getAttribute("aria-disabled");
        Assert.assertEquals("true", buttonDisableValue);
        System.out.println("Button is Dimmed - Ashtar Youssif brdo");
    }*/


    /*TC#2: Check that Tweets will be posted after click on Tweet */
    /* @Test
    public void postTweet() throws InterruptedException {
        WebElement UserName = driver.findElement(By.name("session[username_or_email]"));
        UserName.sendKeys("TestAcc09550718");

        WebElement Password = driver.findElement(By.name("session[password]"));
        Password.sendKeys("Joe.2060");

        WebElement LoginButton = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[3]/div/div"));
        LoginButton.click();
        Thread.sleep(1000);
        WebElement tweetBox = driver.findElement(By.xpath("//div[contains(@class,'public-DraftStyleDefault-block public-DraftStyleDefault-ltr')]"));
         String x = generateText.randomString ();
        tweetBox.sendKeys(x);
        WebElement tweetButon = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[4]/div/div/div[2]/div/div/span/span"));
        tweetButon.click();
        Thread.sleep(1000);
        String PageSource = driver.getPageSource();
        Assert.assertTrue (PageSource.contains("What’s happening?"));
        System.out.println("Ashtar Youssif");
    }*/


    /*TC#3: Check that Check that duplicated Tweets will not be posted after click on Tweet button.*/
  @Test
    public void postTweet() throws InterruptedException {
        WebElement UserName = driver.findElement(By.name("session[username_or_email]"));
        UserName.sendKeys("TestAcc09550718");

        WebElement Password = driver.findElement(By.name("session[password]"));
        Password.sendKeys("Joe.2060");

        WebElement LoginButton = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[3]/div/div"));
        LoginButton.click();
        Thread.sleep(1000);
        WebElement tweetBox = driver.findElement(By.xpath("//div[contains(@class,'public-DraftStyleDefault-block public-DraftStyleDefault-ltr')]"));
       String x = generateText.randomString ();
       tweetBox.sendKeys(x);

       WebElement tweetButton = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[4]/div/div/div[2]/div/div/span/span"));
       tweetButton.click();
       /*driver.navigate().refresh();*/
        Thread.sleep(3500);
       tweetBox.sendKeys(x);
       tweetButton.click();

       String PageSource = driver.getPageSource();
        Assert.assertTrue (PageSource.contains("Something went wrong, but don’t fret — let’s give it another shot."));
        System.out.println("Ashtar Youssif");
    }


}





