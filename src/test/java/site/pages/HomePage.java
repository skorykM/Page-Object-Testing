package site.pages;

import components.InventoryContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.HomePageTest;

public class HomePage extends TopPart
{
    Logger log = LoggerFactory.getLogger(HomePage.class);

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

        log.info("Home page initialized");
    }

    public WebElement getTitle() {
        return title;
    }

    public InventoryContainer getInventory() {
        return inventory;
    }
}
