package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Dropdown {

    private WebDriver driver;

    private List<WebElement> componentsList;

    public Dropdown(WebDriver driver, String selectorForList) {
        this.driver = driver;

        InitElements(selectorForList);
    }

    private void InitElements(String ListSelector) {

        componentsList = driver.findElements( By.cssSelector(ListSelector) );

    }

    public boolean isOptionExists(String optionName){
        boolean optionExists = false;

        if ( getDropdownOption(optionName) != null ){ optionExists = true; }

        return optionExists;
    }

    public WebElement getDropdownOption(String optionName){
        WebElement result = null;

        for (WebElement current : componentsList){
            if( current.getText().toLowerCase().contains(optionName.toLowerCase()) ){
                result = current;
                break;
            }
        }
        return result;
    }

    public void clickDropdownOption(String optionName){
        getDropdownOption(optionName).click();
    }

}
