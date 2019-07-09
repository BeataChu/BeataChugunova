package hw6.page_objects;

import hw6.page_objects.enums.Location;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DifferentPage6 extends BasePage6 {
    private static DifferentPage6 instance;
    @FindBy(css = ".label-checkbox")
    private List<WebElement> checkboxes;
    @FindBy(css = ".label-radio")
    private List<WebElement> radioButtons;
    @FindBy(css = "select.uui-form-element")
    private List<WebElement> dropdownMenu;
    @FindBy(xpath = "//select[@class='uui-form-element']/option")
    private List<WebElement> dropdownOptions;

    @FindBy(css = ".main-content .uui-button")
    private List<WebElement> buttons;
    @FindBy(name = "log-sidebar")
    private WebElement logSection;
    @FindBy(css = ".panel-body-list.logs>li")
    private WebElement firstLineOfTheLog;

    public static DifferentPage6 getInstance() {
        if (instance == null) {
            instance = new DifferentPage6();
        }
        return instance;
    }

    public static void wipeInstance(){
        instance = null;
    }

    public List<WebElement> getSectionItems(Location location) {
        switch (location) {
            case CHECKBOXES:
                return checkboxes;
            case RADIO_BUTTONS:
                return radioButtons;
            case DROPDOWN:
                return dropdownMenu;
            case DROPDOWN_OPTIONS:
                return dropdownOptions;
            case BUTTONS:
                return buttons;
        }
        throw new NoSuchElementException("No such element");
    }


    public WebElement getSideSection(Location location) {
        switch (location) {
            case LEFT_SECTION:
                return leftSection;
            case LOG_SECTION:
                return logSection;
        }
        throw new NoSuchElementException("No such element");
    }

    public WebElement getFirstLineOfTheLog() {
        return firstLineOfTheLog;
    }

}
