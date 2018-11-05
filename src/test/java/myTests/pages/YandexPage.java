package myTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class YandexPage extends Page {
    @FindBy(how = How.XPATH, using = "//a[@data-id='market']")
    public WebElement marketLink;
    public WebElement returnMarketLink() {
        return marketLink;
    }

    public YandexPage(WebDriver webDriver) {
        super(webDriver);
    }
}
