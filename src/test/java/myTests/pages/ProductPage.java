package myTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPage extends Page{
    @FindBy(how = How.XPATH, using ="//div[@class='n-title__text']/h1")
    public WebElement productName;

    @FindBy(how = How.XPATH, using ="//span[@class='price']")
    public WebElement productPrice;

    @FindBy(how = How.XPATH, using ="//div[@class='n-product-default-offer-multiple__action']/div/a")
    public WebElement toTheStoreButton;

    public String getProductName() {
        return productName.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }
}
