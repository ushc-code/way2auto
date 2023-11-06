package tests;

import helpers.PropertyProvider;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTestForLoginPage {
    private static final String username = PropertyProvider.getInctance().getProperty("username");
    private static final String password = PropertyProvider.getInctance().getProperty("password");

    @Test
    public void login() {
        loginPage.fillAndSubmitForm(username, password, "123");
        String message = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/p[1]")).getText();
        Assert.assertEquals(message, "You're logged in!!", "Пользователь не был авторизован");
    }
}
