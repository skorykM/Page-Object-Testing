package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartList {

    protected WebDriver driver;
    private static final String CART_LIST_SELECTOR = "div.cart_item";

    private List<CartItem> cartItems;

    public CartList(WebDriver driver) {
        this.driver = driver;
        
        InitElements();
    }

    private void InitElements() {

        cartItems = new ArrayList<>();

        for (WebElement current : driver.findElements(By.cssSelector(CART_LIST_SELECTOR)))
        {
            cartItems.add(new CartItem(current));
        }
    }

    public List<String> getItemsNamesPresentInCart(){
        List<String> names = new ArrayList<>();

        for (CartItem cartItem : cartItems) {
            names.add(cartItem.getItemName());
        }

        return names;
    }


}
