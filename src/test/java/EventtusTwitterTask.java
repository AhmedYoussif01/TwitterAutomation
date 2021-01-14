import Pages.HomePage;
import Pages.LoginPage;
import Utilities.BaseClass;
import Utilities.RandomStringGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EventtusTwitterTask extends BaseClass {
    RandomStringGenerator generateText;
    LoginPage login;
    HomePage tweetPage;

    @BeforeClass
    public void beforeClass() {
        BaseClass.IntiateDriver();
        generateText = new RandomStringGenerator(); //function defined in Utilities to generate random string
        login = new LoginPage(driver);
        login.userLogin("TestAcc09550718", "Joe.2060");
        //login.userLogin("Testing303.OIT@gmail.com","testingteam1221");

        tweetPage = new HomePage(driver);

    }

    //TC#1: Check Tweet button is dimmed while tweeting box is empty.
    @Test(priority = 1)
    public void CheckTweetButton() {

        WebElement DimmedTweetButton = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[2]/div/div/div[2]/div")); //pointing on the TweetButton web element
        String buttonDisableValue = DimmedTweetButton.getAttribute("aria-disabled");  //get the value of aria-disabled from the button
        Assert.assertEquals("true", buttonDisableValue); //make sure that it is = true
        System.out.println("Button is Dimmed - No Tweet Found"); //Making sure that all script is run till this sentence is printed out

    }


    //TC#2: Check that Tweets will be posted after click on Tweet Button
    @Test(priority = 2)
    public void postTweet() throws InterruptedException {

        String x = generateText.randomString(); //getting the value of randomstring function in X variable
        tweetPage.postTweet(x);
        String PageSource = driver.getPageSource(); //retrieve the page source
        Assert.assertTrue(PageSource.contains("What’s happening?")); //check if page source contain that text to make sure that tweetbos back to normal.
        driver.navigate().to("https://twitter.com/home");
        Thread.sleep(2000);
        System.out.println("Tweet is Posted Successfully");
    }

    /*TC#3: Check that Check that duplicated Tweets will not be posted after click on Tweet button.*/

    @Test(priority = 3)
    public void postDuplicateTweet() throws InterruptedException {

        String x = generateText.randomString(); //getting the value of randomstring function in X variable
        tweetPage.postTweet(x);

        driver.navigate().to("https://twitter.com/home");
        Thread.sleep(3500);

        tweetPage.postTweet(x);

        String PageSource = driver.getPageSource();
        Assert.assertTrue(PageSource.contains("Something went wrong, but don’t fret — let’s give it another shot."));
        System.out.println("Tweet is Duplicated Not posted");
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}





