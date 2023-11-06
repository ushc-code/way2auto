package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "ast-above-header-wrap")
    WebElement header;
    @FindBy(className = "navigation-accessibility")
    WebElement navigation;
    @FindBy(xpath = "//*[@id=\"post-17\"]/div/div/section[2]/div/div/div")
    WebElement certificationBlock;

    @FindBy(css = ".swiper-slide .pp-info-box-button.elementor-button.elementor-size-xs")
    WebElement activeSlideButton;
    @FindBy(xpath = "//div[@data-elementor-type=\"footer\"]")
    WebElement footer;

    @FindBy(xpath = "//*[@id=\"menu-item-27617\"]/a/span[2]")
    WebElement menuItem;

    public WebElement getActiveSlideButton() {
        return activeSlideButton;
    }

    public WebElement getFooter() {
        return footer;
    }

    public WebElement getCertificationBlock() {
        return certificationBlock;
    }

    public WebElement getNavigation() {
        return navigation;
    }

    public WebElement getHeader() {
        return header;
    }

    public void scrollToElement() {
        int deltaY = activeSlideButton.getRect().y;
        new Actions(driver)
                .scrollByAmount(0, deltaY)
                .perform();
    }

    public String[] findActiveHref() {
        scrollToElement();
        String activeHref = activeSlideButton.getAttribute("href");
        By locator = By.cssSelector(".swiper-slide.swiper-slide-active .pp-info-box-button.elementor-button.elementor-size-xs");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOfElementLocated(locator), ExpectedConditions.attributeContains(locator, "href", "https://www.selenium-tutorial.com/p/webservices-api-testing-tutorial")));
        WebElement nextActiveSlideButton = driver.findElement(locator);
        String nextActiveHref = nextActiveSlideButton.getAttribute("href");
        String[] hrefValues = {activeHref, nextActiveHref};
        return hrefValues;
    }

    public void navigateToMenuItem() {
        menuItem.click();
        driver.findElement(By.xpath("//*[@id=\"menu-item-27619\"]/a")).click();

    }

    public WebElement checkScrollMenu() {
        By locator = By.className("ast-sticky-active");
        scrollToElement();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement scrollMenu = driver.findElement(locator);
        return scrollMenu;
    }
}
