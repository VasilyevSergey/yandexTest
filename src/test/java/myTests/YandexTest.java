package myTests;

import myTests.pages.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class YandexTest extends JUnitTestBase {
    private YandexPage yandexPage;
    private YaPage yaPage;
    private YandexMarketPage yandexMarketPage;
    private SearchResultsPage foundedMonitorsPage;
    private ProductPage productPage;

    @Before
    public void initPageObjects() {
        yandexPage = PageFactory.initElements(driver, YandexPage.class);
        yaPage= PageFactory.initElements(driver, YaPage.class);
        yandexMarketPage = PageFactory.initElements(driver, YandexMarketPage.class);
        foundedMonitorsPage = PageFactory.initElements(driver, SearchResultsPage.class);
        productPage = PageFactory.initElements(driver, ProductPage.class);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testYandexPage() {
        driver.get(baseUrl);

        yaPage.returnLogo().click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("yandex.ru"));

        yandexPage.returnMarketLink().click();
        wait.until(ExpectedConditions.titleContains("Яндекс.Маркет"));

        yandexMarketPage.confirmRegion();
        yandexMarketPage.findAndClickTopmenuMonitors();

        String firstFoundedMonitorTitle = foundedMonitorsPage.getFirstMonitorTitle();
        String firstFoundedMonitorPrice = foundedMonitorsPage.getFirstMonitorPrice();

        foundedMonitorsPage.searchFor(firstFoundedMonitorTitle);

        Assert.assertEquals("Названия мониторов не совпадают", firstFoundedMonitorTitle, productPage.getProductName());
        Assert.assertEquals("Цены мониторов не совпадают", firstFoundedMonitorPrice, productPage.getProductPrice());
        wait.until(ExpectedConditions.visibilityOf(productPage.toTheStoreButton));
    }
}
