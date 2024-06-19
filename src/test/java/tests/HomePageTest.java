package tests;

import components.SortOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.pages.HomePage;

public class HomePageTest extends TestRunner
{
    Logger log = LoggerFactory.getLogger(HomePageTest.class);

    public static Object[][] FindSortOptions(){
        return new Object[][]{
                {SortOptions.SORT_HILO},
                {SortOptions.SORT_LOHI},
                {SortOptions.SORT_AZ},
                {SortOptions.SORT_ZA},
        };
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

    @ParameterizedTest
    @MethodSource("FindSortOptions")
    public void sortDropdownPresent(SortOptions sort){

        HomePage home =  loginStandart().chooseSortMethod(sort);

        Assertions.assertTrue( home.getCurrentSortOption().contains(sort.toString()) );
    }

    

}
