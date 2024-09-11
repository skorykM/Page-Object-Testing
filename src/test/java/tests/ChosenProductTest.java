package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.pages.ChosenProductPage;

public class ChosenProductTest extends TestRunner {

    Logger log = LoggerFactory.getLogger(ChosenProductTest.class);

    @ParameterizedTest
    @MethodSource("productNamesMethod")
    public void openAllProductsPageTest(String productName){
        log.info(" Open All Products Page Test start with product name {} ", productName);
        ChosenProductPage productPage = loginStandart().openProductPage(productName);

        assertTrue(productPage.getProductImage().isDisplayed());
    }

    @ValueSource(ints = {0,2,4,5})
    @ParameterizedTest
    public void goBackToMainBtnWorkingCorrectTest(int productPlace){
        log.info(" Go to main page button inside of product page, test with item position of {}", productPlace);

        assertTrue(loginStandart().
                openProductPage(productNames.get(productPlace)).
                goToMainPage().getTitle().isDisplayed());
    }

    @ValueSource(ints = {1,3,5})
    @ParameterizedTest
    public void addOpenedProductToCartTest(int productPlace){
        log.info(" Add item to cart that was opened from main page test ");
        String productName = productNames.get(productPlace);

        ChosenProductPage product = loginStandart().openProductPage(productName);
        product.addItemToCart();
        assertTrue( product.goToMyCartPage().cartInventory().
                getItemsNamesPresentInCart().contains(productName) );

    }

}
