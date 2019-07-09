package hw6.steps;

import cucumber.api.java.en.When;
import hw6.entities.TestContext;
import hw6.enums.Labels.BaseLabel;
import hw6.enums.Labels.Checkboxes;
import hw6.enums.Labels.DropdownSelect;
import hw6.enums.Labels.RadioButtons;
import hw6.enums.Location;
import hw6.enums.ServiceSectionItems;
import hw6.pageObjects.DifferentPage6;
import hw6.pageObjects.HomePage6;
import hw6.pageObjects.UserTablePage6;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ActionSteps extends BaseSteps {

    // TODO This fields available only in the current class
    // TODO it is better to move them to TestContext
    private List<WebElement> elements;

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

    @When("I select checkbox '([^\"]*)'")
    public void selectItem(Checkboxes value) {
        elements = TestContext.getActualPage().getSectionItems(Location.CHECKBOXES);
        WebElement item = getSpecificItem((BaseLabel) value, elements);
        if (!item.isSelected()) {
            item.click();
        }
    }

    @When("I unselect checkbox '([^\"]*)'")
    public void unselectItem(Checkboxes value) {
        elements = TestContext.getActualPage().getSectionItems(Location.CHECKBOXES);
        WebElement item = getSpecificItem(value, elements);
        if (item.isSelected()) {
            item.click();
        }
    }

    @When("I select radio button '([^\"]*)'")
    public void selectItem(RadioButtons value) {
        elements = TestContext.getActualPage().getSectionItems(Location.RADIO_BUTTONS);
        WebElement item = getSpecificItem(value, elements);
        if (!item.isSelected()) {
            item.click();
        }
    }

    @When("I select dropdown item '([^\"]*)'")
    public void selectItem(DropdownSelect value) {
        elements = TestContext.getActualPage().getSectionItems(Location.DROPDOWN);
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

//    @When ("I make a screenshot")
//    public void makeAScreenshot() {
//        try {
//            File scrFile = ((TakesScreenshot) TestContext.getDriver()).getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(scrFile, new File("c:\\temp\\screenshot.png"));
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//    }


}
