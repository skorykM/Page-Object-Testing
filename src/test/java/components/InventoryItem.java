package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryItem
{

    private WebElement itemLayout;

    private WebElement itemName;
    private WebElement itemPrice;
    private WebElement itemDescription;
    private WebElement addToCardBtn;

    public InventoryItem(WebElement itemLayout) {
        this.itemLayout = itemLayout;
        initElements();
    }

    private void initElements()
    {
        itemName = itemLayout.findElement(By.cssSelector("div.inventory_item_name"));
        itemPrice = itemLayout.findElement(By.cssSelector("div.inventory_item_price"));
        itemDescription = itemLayout.findElement(By.cssSelector("div.inventory_item_desc"));
        addToCardBtn = itemLayout.findElement(By.cssSelector("button.btn_inventory"));
    }
}
