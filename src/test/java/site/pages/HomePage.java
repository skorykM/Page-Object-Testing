package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends TopPart
{

    private WebElement title;

    public HomePage(WebDriver driver)
    {
        super(driver);

        initElements();
    }

    private void initElements()
    {
        //appLogo = driver.findElement(By.cssSelector("div.app_logo"));
        //wait.until(d -> popularProducts.isDisplayed());

        title = driver.findElement(By.cssSelector("span.title"));

        System.out.println("    Home page inited");
    }

    public WebElement getTitle() {
        return title;
    }

    public void loadApplication()
    {

    }

}
