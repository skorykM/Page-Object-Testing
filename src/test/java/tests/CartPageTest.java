package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.pages.HomePage;

public class CartPageTest extends TestRunner {

    Logger log = LoggerFactory.getLogger(CartPageTest.class);

    @ValueSource (ints = {0,1,3})
    @ParameterizedTest
    public void removeItemFromCartTest(int productPosition){
        log.info("Remove item from cart test start");

        String productName = productNames.get(productPosition);

        HomePage home = loginStandart();

        assertEquals(0,home.mainPageInventory().addToCartItem(productName)
                .mainPageInventory().removeItemFromCart(productName)
                .goToMyCartPage().cartInventory().getCartSize());
    }


    @MethodSource("productNamesMethod")
    @ParameterizedTest
    public void addItemToCartTest(String productName){
        log.info("Add item to cart test start");

        HomePage home = loginStandart();

        assertTrue( home.mainPageInventory().addToCartItem(productName).
                goToMyCartPage().cartInventory().
                getItemsNamesPresentInCart().
                contains(productName));

    }

    @Test
    public void addAllItemsToCartTest(){
        log.info("Add all items into cart test start");

        HomePage home = loginStandart();

        assertEquals( home.mainPageInventory().addAllItemsToCart().
                        goToMyCartPage().
                        cartInventory().getItemsNamesPresentInCart(),
                        productNames );

    }

}
