package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartItem {

    private WebElement itemLayout;

    private WebElement itemName;
    private WebElement itemPrice;
    private WebElement itemDescription;
    private WebElement deleteFromCartBtn;

    public CartItem(WebElement itemLayout) {

        this.itemLayout = itemLayout;

        InitElements();
    }

    private void InitElements() {
        itemName = itemLayout.findElement(By.cssSelector("div.inventory_item_name"));
        itemPrice = itemLayout.findElement(By.cssSelector("div.inventory_item_price"));
        itemDescription = itemLayout.findElement(By.cssSelector("div.inventory_item_desc"));
        deleteFromCartBtn = itemLayout.findElement(By.cssSelector("button.btn.btn_secondary.btn_small"));
    }

    public String getItemName() {
        return itemName.getText();
    }
}
