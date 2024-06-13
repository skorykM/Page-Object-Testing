package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Replace;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.pages.TopPart;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public abstract class TestRunner
{
    protected static WebDriver driver;
    //public static Wait<WebDriver> wait;
    Logger log = LoggerFactory.getLogger(TopPart.class);

    @BeforeAll
    public static void beforeAll()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Implicit wait

    }

    @BeforeEach
    public void beforeEach()
    {
        driver.get("https://www.saucedemo.com/");
        //wait = new WebDriverWait(driver,Duration.ofSeconds(2)); // Explicit wait
    }

    @RegisterExtension
    TestWatcher watcher = new TestWatcher() {

        @Override
        public void testFailed(ExtensionContext context, Throwable cause){
            log.error(" Test Failed with error - ", cause);
            captureScreenshot(context.getRequiredTestMethod().getName());
            driver.quit();
        }

        @Override
        public void testSuccessful(ExtensionContext context) {
            if (driver!=null) { driver.quit(); }
        }


    };

    private void captureScreenshot(String methodName)
    {
        try
        {
            File fileSrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path destPath = Paths.get("screenshots", methodName + ".png");
            Files.move(fileSrc.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


    @AfterAll
    public static void afterAll()
    {
        if (driver != null) { driver.quit(); }
    }



}
