package tests;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.pages.HomePage;
import site.pages.LoginPage;

public class HomePageTest extends TestRunner
{
    Logger log = LoggerFactory.getLogger(HomePageTest.class);

    private HomePage loginStandart()
    {
        LoginPage login = new LoginPage(driver);
        return login.SuccessfulUserLogin("standard_user");
    }

    @Test
    public void inventoryTest()
    {
        log.info("Start inventory test");
        Assertions.assertTrue(loginStandart()
                .getInventory().getInventorySize() > 0,"Inventory items were found");

    }

}
