package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "username")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"formly_1_input_username_0\"]")
    WebElement usernameDescription;
    @FindBy(css = ".btn.btn-danger")
    WebElement loginButton;
    public void fillUsername(String name) {
        username.sendKeys(name);
    }

    public void fillPassword(String pass) {
        password.sendKeys(pass);
    }

    public void fillUserDescription(String description) {
        usernameDescription.sendKeys(description);
    }

    public void login() {
        loginButton.click();
    }

    public void fillAndSubmitForm(String username, String password, String description) {
        fillUsername(username);
        fillPassword(password);
        fillUserDescription(description);
        login();
    }
}
