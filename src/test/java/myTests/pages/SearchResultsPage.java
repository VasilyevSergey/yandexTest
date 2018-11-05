package myTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends Page{
    @FindBy(how = How.XPATH, using ="//input[@id='header-search']")
    public WebElement searchField;

    @FindBy(how = How.XPATH, using ="//div[@class='n-snippet-cell2__title']/*")
    public WebElement firstProductTitle;

    @FindBy(how = How.XPATH, using ="//div[@class='price']")
    public WebElement firstProductPrice;

    public void searchFor(String text) {
        searchField.sendKeys(text);
        searchField.submit();

        //ожидаем загрузки страницы
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains(text));
    }

    public String getFirstMonitorTitle() {
        return firstProductTitle.getText();
    }

    public String getFirstMonitorPrice() {
        return firstProductPrice.getText();
    }

    public SearchResultsPage(WebDriver webDriver) {
        super(webDriver);
    }
}



