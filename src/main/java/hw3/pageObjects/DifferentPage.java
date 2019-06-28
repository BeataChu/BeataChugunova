package hw3.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DifferentPage extends BasePage{

    @FindBy (className = "label-checkbox")
    private List<WebElement> checkboxes;

    @FindBy (className = "label-radio")
    private List<WebElement> radiobuttons;

    @FindBy (css = "select[class=\"uui-form-element\"]")
    private List<WebElement> dropdown;

    @FindBy (css = ".main-content .uui-button")
    private List<WebElement> buttons;

    @FindBy (name = "log-sidebar")
    private WebElement logSection;

    public DifferentPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getCheckboxes(){
        return checkboxes;
    }

    // TODO getRadioButtons camel style ;)
    public List<WebElement> getRadiobuttons(){
        return radiobuttons;
    }

    public List<WebElement> getDropdown(){
        return dropdown;
    }

    public List<WebElement> getButtons(){
        return buttons;
    }

    public WebElement getLogSection(){
        return logSection;
    }

    public WebElement getFirstLineOfTheLog(){
        return driver.findElement(By.cssSelector(".panel-body-list.logs>li"));
    }

}
