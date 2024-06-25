package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.pages.ChosenProductPage;

public class ChosenProductTest extends TestRunner {

    Logger log = LoggerFactory.getLogger(ChosenProductTest.class);

    @ValueSource(strings = {"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
            "Sauce Labs Fleece Jacket","Sauce Labs Onesie","Test.allTheThings() T-Shirt (Red)"})
    @ParameterizedTest
    public void openAllProductsPageTest(String productName){
        log.info(" Open All Products Page Test start ");
        ChosenProductPage productPage = loginStandart().openProductPage(productName);

        assertTrue(productPage.getProductImage().isDisplayed());
    }

}
