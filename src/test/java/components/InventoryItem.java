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
    private WebElement currentPresentButton;

    public InventoryItem(WebElement itemLayout) {
        this.itemLayout = itemLayout;
        initElements();
    }

    private void initElements()
    {
        itemName = itemLayout.findElement(By.cssSelector("div.inventory_item_name"));
        itemPrice = itemLayout.findElement(By.cssSelector("div.inventory_item_price"));
        itemDescription = itemLayout.findElement(By.cssSelector("div.inventory_item_desc"));
        currentPresentButton = itemLayout.findElement(By.cssSelector("button.btn_inventory"));
    }

    public String getItemName() {
        return itemName.getText();
    }

    public void addToCardBtnClick(){
        currentPresentButton.click();
    }

    public void removeFromCartBtnClick(){
        currentPresentButton.click();
    }

    public void clickOnProductNameToOpen(){
        itemName.click();
    }

}
