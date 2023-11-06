package tests;

import helpers.PropertyProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigateTest extends BaseTestForHomePage {
    private static final String PRACTICE_LINK = PropertyProvider.getInctance().getProperty("practice_link");

    @Test
    public void navigate() {
        homePage.navigateToMenuItem();
        Assert.assertEquals(driver.getCurrentUrl(), PRACTICE_LINK, "URL открытой страницы не совпадает с заданной");
    }
}
