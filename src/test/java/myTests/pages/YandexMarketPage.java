package myTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//короче ожидание всплывающего окна работает, а нажатие на кнопку - нет
public class YandexMarketPage extends Page {
    @FindBy(how = How.XPATH, using ="//span[text()='Да, спасибо']")
    public WebElement acceptButton;

    @FindBy(how = How.XPATH, using ="//a[text()='Компьютеры']")
    public WebElement computersTopmenu;

    @FindBy(how = How.XPATH, using ="//div[@class='popup2__content']")
    public WebElement popupRegion;

    @FindBy(how = How.XPATH, using ="//a[text()='Мониторы']")
    public WebElement monitorsSubitem;

    public void confirmRegion() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(popupRegion));

        Actions actions = new Actions(driver);
        actions.moveToElement(acceptButton).click().perform();
    }

    public void findAndClickTopmenuMonitors() {
        Actions actions = new Actions(driver);
        actions.moveToElement(computersTopmenu).perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(monitorsSubitem));
        monitorsSubitem.click();
    }

    public YandexMarketPage(WebDriver webDriver) {
        super(webDriver);
    }
}