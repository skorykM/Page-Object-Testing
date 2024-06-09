package site.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class TopPart
{
    protected WebDriver driver;

    private WebElement logo;

    public TopPart(WebDriver driver)
    {
        this.driver = driver;
        InitElements();
    }

    private void InitElements()
    {
        System.out.println("    Top part inited");
    }

    // Business logic

    protected HomePage goToHomePage()
    {
        //clickLogo();
        return new HomePage(driver);
    }


}
