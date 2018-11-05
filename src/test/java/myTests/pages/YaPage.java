package myTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class YaPage extends Page {
    @FindBy(how = How.XPATH, using = "//a[@data-statlog='logo']")
    public WebElement logo;

    public WebElement returnLogo() {
        return logo;
    }

    public YaPage(WebDriver webDriver) {
        super(webDriver);
    }
}
