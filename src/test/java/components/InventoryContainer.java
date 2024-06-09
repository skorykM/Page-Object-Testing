package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class InventoryContainer
{
    protected WebDriver driver;
    private final String INVENTORY_ITEMS_SELECTOR = "div.inventory_item";

    private List<InventoryItem> itemList;

    public InventoryContainer(WebDriver driver)
    {
        this.driver = driver;

        InitElements();
    }

    private void InitElements()
    {
        itemList = new ArrayList<>();

        for (WebElement current : driver.findElements(By.cssSelector(INVENTORY_ITEMS_SELECTOR)))
        {
            itemList.add(new InventoryItem(current));
        }
    }

    public int getInventorySize(){ return itemList.size(); }

}
