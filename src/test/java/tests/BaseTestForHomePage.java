package tests;

import helpers.PropertyProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

import java.time.Duration;

public class BaseTestForHomePage {
    public static WebDriver driver = new ChromeDriver();
    private static final String LINK = PropertyProvider.getInctance().getProperty("link");
    public HomePage homePage = new HomePage(driver);

    @BeforeTest
    public void setup() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(LINK);
        Assert.assertEquals(driver.getCurrentUrl(), LINK, "URL открытой страницы не совпадает с заданной");
    }

    @AfterTest
    public void close() {
        driver.close();
    }
}
