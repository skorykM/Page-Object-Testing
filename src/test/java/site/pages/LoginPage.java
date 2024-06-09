package site.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage
{
    private WebDriver driver;

    private WebElement loginBtn;
    private WebElement username;
    private WebElement password;
    private WebElement errorBox;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        initElements();
    }

    private void initElements()
    {
       loginBtn = driver.findElement(By.cssSelector("input.submit-button"));
       username = driver.findElement(By.id("user-name"));
       password = driver.findElement(By.id("password"));

    }

    public void setUserName(String username)
    {
        this.username.sendKeys(username);
    }

    public WebElement getErrorBox() {
        errorBox = driver.findElement(By.cssSelector("div.error-message-container.error"));
        return errorBox;
    }

    public HomePage SuccessfulUserLogin(String username)
    {
        setUserName(username);
        setPassword("secret_sauce");
        return loginBtnClick();
    }

    public String getUsername() { return username.getAttribute("value"); }

    public String getPassword() { return password.getAttribute("value"); }

    public void setPassword(String password) { this.password.sendKeys(password); }

    public HomePage loginBtnClick()
    {
        loginBtn.click();
        return new HomePage(driver);

    }

}
