package hw6.steps;

import cucumber.api.java.en.When;
import hw6.entities.TestContext;
import hw6.page_objects.labels.BaseLabel;
import hw6.page_objects.labels.Checkboxes;
import hw6.page_objects.labels.DropdownSelect;
import hw6.page_objects.labels.RadioButtons;
import hw6.page_objects.enums.Location;
import hw6.page_objects.enums.ServiceSectionItems;
import hw6.page_objects.DifferentPage6;
import hw6.page_objects.HomePage6;
import hw6.page_objects.UserTablePage6;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ActionSteps extends BaseSteps {

    // TODO This fields available only in the current class
    // TODO it is better to move them to TestContext - B.C.: moved variable to specific methods

    @When("I login as '([^\"]*)'/'([^\"]*)'")
    public void iLoginAs(String username, String password) {
        ((HomePage6) TestContext.getActualPage()).userIconClick();
        ((HomePage6) TestContext.getActualPage()).fillLoginTextField(username);
        ((HomePage6) TestContext.getActualPage()).fillPasswordTextField(password);
        ((HomePage6) TestContext.getActualPage()).loginButtonClick();
    }

    @When("I click Service subcategory in '([^\"]*)' menu")
    public void iClickServiceButton(Location location) {
        TestContext.getActualPage().getServiceMenuTitle(location).click();
    }

    @When("I click Different Elements in Service dropdown")
    public void iClickDifferentElementsMenu() {
        TestContext.getActualPage().getHeaderServiceMenuItem(ServiceSectionItems.DIFFERENT_ELEMENTS).click();
        TestContext.setActualPage(DifferentPage6.getInstance());
    }

    @When("I click User Table in Service dropdown")
    public void iClickUserTableMenu() {
        TestContext.getActualPage().getHeaderServiceMenuItem(ServiceSectionItems.USER_TABLE).click();
        TestContext.setActualPage(UserTablePage6.getInstance());
    }

    @When("I select checkbox '([^\"]*)' in Different Elements page")
    public void selectItem(Checkboxes value) {
        List<WebElement> elements = TestContext.getActualPage().getSectionItems(Location.CHECKBOXES);
        WebElement item = getSpecificItem((BaseLabel) value, elements);
        if (!item.isSelected()) {
            item.click();
        }
    }

    @When("I unselect checkbox '([^\"]*)' in Different Elements page")
    public void unselectItem(Checkboxes value) {
        List<WebElement> elements = TestContext.getActualPage().getSectionItems(Location.CHECKBOXES);
        WebElement item = getSpecificItem(value, elements);
        if (item.isSelected()) {
            item.click();
        }
    }

    @When("I select radio button '([^\"]*)' in Different Elements page")
    public void selectItem(RadioButtons value) {
        List<WebElement> elements  = TestContext.getActualPage().getSectionItems(Location.RADIO_BUTTONS);
        WebElement item = getSpecificItem(value, elements);
        if (!item.isSelected()) {
            item.click();
        }
    }

    @When("I select dropdown item '([^\"]*)' in Different Elements page")
    public void selectItem(DropdownSelect value) {
        List<WebElement> elements  = TestContext.getActualPage().getSectionItems(Location.DROPDOWN);
        elements.get(0).click();
        elements = TestContext.getActualPage().getSectionItems(Location.DROPDOWN_OPTIONS);
        WebElement item = getSpecificItem(value, elements);
        if (!item.isSelected()) {
            item.click();
        }
    }

    @When("I select vip checkbox for '([^\"]*)'")
    public void selectVipCheckbox(String userName) {
        ((UserTablePage6) TestContext.getActualPage()).getVipCheckbox(userName).click();
    }

    @When("I click on dropdown in column Type for user '([^\"]*)'")
    public void clickUserTypeDropdown(String userName) {
        ((UserTablePage6) TestContext.getActualPage()).getUserTypeSelect(userName).click();
    }




}
