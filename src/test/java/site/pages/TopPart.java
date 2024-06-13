package site.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.HomePageTest;

public abstract class TopPart
{
    protected WebDriver driver;
    Logger log = LoggerFactory.getLogger(TopPart.class);
    private WebElement logo;

    public TopPart(WebDriver driver)
    {
        this.driver = driver;
        InitElements();
    }

    private void InitElements()
    {
        log.info("Top part initialized");
    }

    // Business logic

    protected HomePage goToHomePage()
    {
        //clickLogo();
        return new HomePage(driver);
    }


}
