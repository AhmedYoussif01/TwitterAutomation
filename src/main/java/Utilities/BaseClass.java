package Utilities;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class BaseClass {
    public static WebDriver driver;


    public static void IntiateDriver() {
        System.setProperty("webdriver.chrome.driver", "./ChromeDriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // max. driver to full screen.
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*Steps to valid login*/
        driver.get("https://twitter.com/login/");


    }

}
