package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.HomePageTest;

public abstract class TopPart
{
    protected WebDriver driver;
    Logger log = LoggerFactory.getLogger(TopPart.class);
    private WebElement cartBtn;

    public TopPart(WebDriver driver)
    {
        this.driver = driver;
        InitElements();
    }

    private void InitElements()
    {
        cartBtn = driver.findElement(By.cssSelector("a.shopping_cart_link"));
        log.info("Top part initialized");
    }

    // Business logic

    protected HomePage goToHomePage()
    {
        return new HomePage(driver);
    }

    public MyCartPage goToMyCartPage()
    {
        cartBtn.click();
        return new MyCartPage(driver);
    }


}
