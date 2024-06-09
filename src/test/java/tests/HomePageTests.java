package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import site.pages.HomePage;
import site.pages.LoginPage;

public class HomePageTests extends TestRunner
{

    private HomePage loginStandart()
    {
        LoginPage login = new LoginPage(driver);
        return login.SuccessfulUserLogin("standard_user");
    }

    @Test
    public void inventoryTest()
    {
        HomePage home = loginStandart();

        Assertions.assertTrue(home.getInventory().getInventorySize() > 0);

    }

}
