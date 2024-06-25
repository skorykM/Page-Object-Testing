package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BurgerMenu {

    private WebDriver driver;

    private WebElement logout;
    private WebElement closeBtn;
    private WebElement allProducts;

    public BurgerMenu(WebDriver driver) {

        this.driver = driver;
        
        InitElements();

    }

    private void InitElements() {

        logout = driver.findElement(By.id("logout_sidebar_link"));
        allProducts = driver.findElement(By.id("inventory_sidebar_link"));
        closeBtn = driver.findElement(By.id("react-burger-cross-btn"));

    }

    public WebElement getAllProducts(){
        return allProducts;
    }

    public void closeBurgerMenu(){
        closeBtn.click();
    }

    public HomePage goToMainPage(){
        allProducts.click();
        return new HomePage(driver);
    }

    public LoginPage logout(){
        logout.click();
        return new LoginPage(driver);
    }

}
