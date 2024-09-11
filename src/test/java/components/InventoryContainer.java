package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import site.pages.HomePage;

import java.util.ArrayList;
import java.util.List;

public class InventoryContainer
{
    protected WebDriver driver;
    private static final String INVENTORY_ITEMS_SELECTOR = "div.inventory_item";

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

    public List<InventoryItem> getInventoryItems() {
        return itemList;
    }

    public void clickOnChosenProduct(String productName){
        for (InventoryItem item: itemList){
            if (item.getItemName().contains(productName)){ item.clickOnProductNameToOpen(); break; }
        }
    }

    public List<String> getItemsNames()
    {
        List<String> names = new ArrayList<>();

        for (int i = 0; i < this.getInventorySize(); i++){
            names.add(itemList.get(i).getItemName());
        }

        return names;
    }

    public List<InventoryItem> itemList(){
        return itemList;
    }

    public HomePage addToCartItem(String itemName){

        for (int i=0; i < getInventorySize(); i++){
            if( itemList.get(i).getItemName().equals(itemName) )
            {
                itemList.get(i).addToCardBtnClick();
                break;
            }
        }

        return new HomePage(driver);
    }

    public HomePage removeItemFromCart(String itemName){
        for (int i=0; i < getInventorySize(); i++){
            if( itemList.get(i).getItemName().equals(itemName) )
            {
                itemList.get(i).removeFromCartBtnClick();
                break;
            }
        }

        return new HomePage(driver);
    }

    public HomePage addAllItemsToCart(){
        for (InventoryItem item : itemList){
            item.addToCardBtnClick();
        }
        return new HomePage(driver);
    }




}
