package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class TestRunner
{
    protected static WebDriver driver;
    //public static Wait<WebDriver> wait;

    @BeforeAll
    public static void beforeAll()
    {
        System.out.println("Before all executed");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Implicit wait

    }

    @BeforeEach
    public void beforeEach()
    {
        driver.get("https://www.saucedemo.com/");
        //wait = new WebDriverWait(driver,Duration.ofSeconds(2)); // Explicit wait
    }

    @AfterAll
    public static void afterAll()
    {
        if (driver != null) { driver.quit(); }
        System.out.println("After all executed");
    }



}
