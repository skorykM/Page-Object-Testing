package prestaShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopPart
{
    protected WebDriver driver;

    private WebElement logo;
    private WebElement clothes;
    private WebElement accessories;
    private WebElement art;
    private WebElement search;
    private WebElement contactUs;

    //public TopPart(){  }

    public TopPart(WebDriver driver)
    {
        this.driver = driver;
        InitElements();
    }

    private void InitElements()
    {



    }


}
