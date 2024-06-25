package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.pages.BurgerMenu;
import site.pages.HomePage;


public class BurgerMenuTest extends TestRunner {

    Logger log = LoggerFactory.getLogger(BurgerMenuTest.class);

    @Test
    public void burgerOpensTest(){
        log.info("Burger open test start");
        BurgerMenu menu = loginStandart().openBurgerMenu();
        waitFor(menu.getAllProducts(),true);

        assertTrue( menu.getAllProducts().isDisplayed() );

    }

    @Test
    public void burgerClosesTest(){
        log.info("Burger close test start");
        HomePage home = loginStandart();
        BurgerMenu menu = home.openBurgerMenu();

        waitFor(menu.getAllProducts(),true);
        menu.closeBurgerMenu();
        waitFor( menu.getAllProducts(), false );

        assertFalse( menu.getAllProducts().isDisplayed() );
    }

    @Test
    public void logoutTest(){
        log.info("Logout test start");

        BurgerMenu menu = loginStandart().openBurgerMenu();
        waitFor(menu.getAllProducts(),true);

        assertTrue( menu.logout().getLoginBtn().isDisplayed() );
    }

}
