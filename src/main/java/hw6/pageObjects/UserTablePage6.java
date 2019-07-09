package hw6.pageObjects;

import hw6.entities.TestContext;
import hw6.enums.Location;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserTablePage6 extends BasePage6 {

    private static UserTablePage6 instance;
    @FindBy(css = "tbody select")
    private List<WebElement> typeDropdowns;
    @FindBy(css = "tbody a")
    private List<WebElement> userNames;
    @FindBy(css = "tbody img")
    private List<WebElement> descImages;
    @FindBy(css = "tbody span")
    private List<WebElement> descTexts;
    @FindBy(css = "tbody input")
    private List<WebElement> checkboxes;
    @FindBy(css = ".panel-body-list.logs>li")
    private WebElement firstLineOfTheLog;

    public static UserTablePage6 getInstance() {
        if (instance == null) {
            instance = new UserTablePage6();
        }
        return instance;
    }

    public List<WebElement> getSectionItems(Location location) {
        switch (location) {
            case TYPE_DROPDOWNS:
                return typeDropdowns;
            case USER_NAMES:
                return userNames;
            case DESCRIPTION_IMAGES:
                return descImages;
            case DESCRIPTION_TEXTS:
                return descTexts;
            case CHECKBOXES:
                return checkboxes;
        }
        throw new NoSuchElementException("No such element");
    }

    public WebElement getUserNumber(String number) {
        return TestContext.getDriver().findElement(By.xpath("//tr/td[.='" + number + "']"));
    }

    public WebElement getUserName(String number) {
        return TestContext.getDriver().findElement(By.xpath("//tr[contains(.,'" + number + "')]//a"));
    }

    public WebElement getUserDescription(String number) {
        return TestContext.getDriver().findElement(By.xpath("//tr[contains(.,'" + number + "')]//span"));
    }

    public WebElement getVipCheckbox(String userName) {
        return TestContext.getDriver().findElement(By.xpath("//tr[contains(.,'" + userName + "')]//input"));
    }

    public WebElement getFirstLineOfTheLog() {
        return firstLineOfTheLog;
    }

    public WebElement getUserTypeSelect(String userName) {
        return TestContext.getDriver().findElement(By.xpath("//tr[contains(.,'" + userName + "')]//select"));
    }

    public List<WebElement> getUserTypeDropdownItems(String userName) {
        return TestContext.getDriver().findElements(By.xpath("//tr[contains(.,'" + userName + "')]//select/option"));
    }
}
