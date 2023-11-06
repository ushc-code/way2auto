package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTestForHomePage {

    @Test
    public void findHeader() {
        Assert.assertNotNull(homePage.getHeader(), "Элемент header не найден на странице");
    }

    @Test
    public void findNavigation() {
        Assert.assertNotNull(homePage.getNavigation(), "Элемент navigation не найден на странице");
    }

    @Test
    public void findCertification() {
        Assert.assertNotNull(homePage.getCertificationBlock(), "Сертификаты не найдены на странице");

    }

    @Test
    public void checkSlider() {
        String[] result = homePage.findActiveHref();
        Assert.assertNotEquals(result[0], result[1], "Слайдер не переключился автоматически в течении 5 секунд");
    }

    @Test
    public void findFooter() {
        Assert.assertNotNull(homePage.getFooter(), "Элемент footer не найден на странице");
    }

    @Test
    public void checkScrollMenu() {
        Assert.assertNotNull(homePage.checkScrollMenu(), "Меню не отображается при скролле");
    }

}
