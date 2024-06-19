package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.pages.HomePage;
import site.pages.LoginPage;

public class CartPageTest extends TestRunner {

    Logger log = LoggerFactory.getLogger(CartPageTest.class);

    @ValueSource(strings = {"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
            "Sauce Labs Fleece Jacket","Sauce Labs Onesie","Test.allTheThings() T-Shirt (Red)"})
    @ParameterizedTest
    public void addItemToCartTest(String productName){
        log.info("Cart test start");

        HomePage home = loginStandart();
        home.mainPageInventory().addToCartItem(productName);

        Assertions.assertTrue( home.goToMyCartPage().cartInventory().
                getItemsNamesPresentInCart().
                contains(productName));

    }

    @Test
    public void addAllItemsToCartTest(){
        log.info("All items into cart test start");

        HomePage home = loginStandart();
        home.mainPageInventory().addAllItemsToCart();
        Assertions.assertEquals( home.
                        goToMyCartPage().
                cartInventory().getItemsNamesPresentInCart(),
                productNames );

    }

}
