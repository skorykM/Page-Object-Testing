package site.pages;

import components.CartList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyCartPage {

    private WebDriver driver;

    private CartList cartInventory;

    public MyCartPage(WebDriver driver) {

        this.driver = driver;
        InitElements();
    }

    private void InitElements() {

        try { cartInventory = new CartList(driver); }
        catch (Exception e) { System.out.println("SOMETHING WRONG WITH CART " + e); }

    }

    public CartList cartInventory(){
        return cartInventory;
    }

}
