package site.pages;

import components.Dropdown;
import components.InventoryContainer;
import components.SortOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends TopPart
{
    Logger log = LoggerFactory.getLogger(HomePage.class);

    private WebElement title;
    private WebElement sortDropdownMenu;
    private WebElement sortDropdownMenuActive;
    private InventoryContainer inventory;

    private final static String LIST_SORT_CSS_SELECTOR = "option";

    private Dropdown dropdownComponent;

    public HomePage(WebDriver driver)
    {
        super(driver);

        initElements();
    }

    private void initElements()
    {
        //wait.until(d -> popularProducts.isDisplayed());
        title = driver.findElement(By.cssSelector("span.title"));
        sortDropdownMenuActive = driver.findElement(By.cssSelector("span.active_option"));
        sortDropdownMenu = driver.findElement(By.cssSelector("select"));
        inventory = new InventoryContainer(driver);
        createSortDropdown(LIST_SORT_CSS_SELECTOR);

        log.info("Home page initialized");
    }

    public WebElement getTitle() {
        return title;
    }

    public InventoryContainer mainPageInventory() {
        return inventory;
    }

    public String getCurrentSortOption(){
        return sortDropdownMenuActive.getText();
    }

    public void sortDropdownClick(){ sortDropdownMenu.click(); }

    private void createSortDropdown(String selector){
        dropdownComponent = new Dropdown(driver, selector);
    }

    protected Dropdown getDropdown(){
        //custom exception?
        //if(dropdownComponent == null){ throw new Exception("error"); }

        return dropdownComponent;
    }

    public HomePage chooseSortMethod(SortOptions optionName){
        sortDropdownClick();

        if(!dropdownComponent.isOptionExists(optionName.toString())) {  }//custom exception too?

        dropdownComponent.clickDropdownOption(optionName.toString());

        return new HomePage(driver);
    }


}
