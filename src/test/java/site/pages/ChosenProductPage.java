package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChosenProductPage extends TopPart {

    private WebElement productImage;
    private WebElement productName;
    private WebElement productDiscription;
    private WebElement productPrice;
    private WebElement addToCartBtn;
    private WebElement backToMainBtn;

    public ChosenProductPage(WebDriver driver) {
        super(driver);

        InitElements();
    }

    private void InitElements(){
        productImage = findByCss("img.inventory_details_img");
        productName = findByCss("div.inventory_details_name");
        productDiscription = findByCss("div.inventory_details_desc");
        productPrice = findByCss("div.inventory_details_price");

        addToCartBtn = findByCss("button.btn_inventory");
        backToMainBtn = findByCss("button.back");
    }

    private WebElement findByCss(String Selector){
        return driver.findElement(By.cssSelector(Selector));
    }

    public HomePage goToMainPage(){
        backToMainBtn.click();

        return new HomePage(driver);
    }

    public WebElement getProductImage() {
        return productImage;
    }

    public void addItemToCart(){
        addToCartBtn.click();
    }
}
