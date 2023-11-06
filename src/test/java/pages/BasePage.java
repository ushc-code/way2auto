package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        try {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }
}
