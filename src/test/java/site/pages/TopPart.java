package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.HomePageTest;

public abstract class TopPart
{
    protected WebDriver driver;
    private WebElement cartBtn;
    private WebElement burgerMenuBtn;

    public TopPart(WebDriver driver)
    {
        this.driver = driver;
        InitElements();
    }

    private void InitElements()
    {
        cartBtn = driver.findElement(By.cssSelector("a.shopping_cart_link"));
        burgerMenuBtn = driver.findElement(By.id("react-burger-menu-btn"));
    }

    // Business logic

    protected HomePage goToHomePage()
    {
        return new HomePage(driver);
    }

    public MyCartPage goToMyCartPage()
    {
        cartBtn.click();
        return new MyCartPage(driver);
    }

    public BurgerMenu openBurgerMenu(){
        burgerMenuBtn.click();
        return new BurgerMenu(driver);
    }

    public WebElement getBurgerMenuBtn(){
        return burgerMenuBtn;
    }


}
