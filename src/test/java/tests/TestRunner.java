package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestRunner
{
    protected static WebDriver driver;
    @BeforeAll
    public static void beforeAll()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Explicit wait
        System.out.println("Before all executed");
    }

    @AfterAll
    public static void afterAll()
    {
        if (driver != null) { driver.quit(); }
        System.out.println("After all executed");
    }



}
