package site.pages;

import components.InventoryContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends TopPart
{

    private WebElement title;
    private InventoryContainer inventory;

    public HomePage(WebDriver driver)
    {
        super(driver);

        initElements();
    }

    private void initElements()
    {
        //wait.until(d -> popularProducts.isDisplayed());
        title = driver.findElement(By.cssSelector("span.title"));
        inventory = new InventoryContainer(driver);

        System.out.println("    Home page inited");
    }

    public WebElement getTitle() {
        return title;
    }

    public InventoryContainer getInventory() {
        return inventory;
    }
}
