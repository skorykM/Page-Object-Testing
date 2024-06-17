package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.pages.HomePage;
import site.pages.LoginPage;

import java.util.ArrayList;

public class HomePageTest extends TestRunner
{
    Logger log = LoggerFactory.getLogger(HomePageTest.class);

    private HomePage loginStandart()
    {
        LoginPage login = new LoginPage(driver);
        return login.SuccessfulUserLogin("standard_user");
    }

    @Test
    public void inventoryPresentTest()
    {
        log.info("Start inventory test");
        Assertions.assertTrue(loginStandart()
                .mainPageInventory().getInventorySize() > 0,"Inventory items were found");

    }

    @Test
    public void allItemsCorrectDisplayedTest(){
        log.info("Inventory items test start");
        Assertions.assertEquals(loginStandart().
                mainPageInventory().
                getItemsNames(), productNames);
    }

}
