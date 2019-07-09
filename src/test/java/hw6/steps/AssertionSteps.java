package hw6.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import hw6.entities.TestContext;
import hw6.enums.Labels.Checkboxes;
import hw6.enums.Labels.DropdownSelect;
import hw6.enums.Labels.RadioButtons;
import hw6.enums.Location;
import hw6.pageObjects.DifferentPage6;
import hw6.pageObjects.UserTablePage6;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static hw6.enums.Location.*;
import static org.testng.Assert.*;

public class AssertionSteps extends BaseSteps {

    // TODO This fields available only in the current class
    // TODO it is better to move them to TestContext
    List<WebElement> elements;
    private Map<Location, Integer> elementsList;

    @Then("page title should be '([^\"]*)'")
    public void iGetPageTitle(String expectedPageTitle) {
        assertTrue(TestContext.getDriver().getTitle().equalsIgnoreCase(expectedPageTitle));
    }

    @Then("User name should be '([^\"]*)'")
    public void userNameShouldBe(String expectedUsername) {
        WebElement userNameWebElement = TestContext.getDriver().findElement(By.id("user-name"));
        assertEquals(userNameWebElement.getText(), expectedUsername);
    }

    @Then("home page should contain all necessary elements")
    public void homePageShouldContainAllNecessaryElements(Map<Location, Integer> elementsList) {
        this.elementsList = elementsList;
        for (Map.Entry<Location, Integer> entry : elementsList.entrySet()) {
            // TODO assertEquals
            assertTrue(TestContext.getActualPage().getSectionItems((Location) entry.getKey()).size() == entry.getValue());
        }
    }

    @Then("'(\\d+)' '([^\"]*)' are displayed on Users Table on User Table Page")
    public void userTablePageShouldContainAllNecessaryElements(int number, Location location) {
        assertEquals(TestContext.getActualPage().getSectionItems(location).size(), number);

    }

    @Then("'([^\"]*)' dropdown list should have '([^\"]*)' items")
    public void dropdownListShouldHaveItems(Location location, List<String> items) {
        List<WebElement> listSubMenu = TestContext.getActualPage().getServiceDropdownMenu(location);
        List<String> subItemsText = listSubMenu.
                stream()
                .map(WebElement::getText)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        assertTrue(subItemsText.containsAll(items));
    }

    @Then("Different Elements page should contain all necessary elements")
    public void diffPageShouldContainAllNecessaryElements(Map<Location, Integer> elementsList) {
        this.elementsList = elementsList;
        for (Map.Entry<Location, Integer> entry : elementsList.entrySet()) {
            // TODO assertEquals
            assertTrue(TestContext.getActualPage().getSectionItems(entry.getKey()).size() == entry.getValue());
        }
    }

    @Then("there should be '([^\"]*)'")
    public void sectionShouldBeVisible(Location location) {
        WebElement section = ((DifferentPage6) TestContext.getActualPage()).getSideSection(location);
        assertTrue(section.isDisplayed());
    }

    @Then("for a clicked checkbox '([^\"]*)' there is a corresponding log line")
    public void logLineShouldCorrespondWithActions(Checkboxes value) {
        elements = TestContext.getActualPage().getSectionItems(CHECKBOXES);
        WebElement item = getSpecificItem(value, elements);
        String firstLineOfTheLog = ((DifferentPage6) TestContext.getActualPage()).getFirstLineOfTheLog().getText();
        String regex = ".*" + item.getText().trim() + ".*" + item.isSelected();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(firstLineOfTheLog);
        assertTrue(matcher.matches());

    }


    @Then("for a clicked radio button '([^\"]*)' there is a corresponding log line")
    public void logLineShouldCorrespondWithActions(RadioButtons value) {
        elements = TestContext.getActualPage().getSectionItems(RADIO_BUTTONS);
        WebElement item = getSpecificItem(value, elements);
        String firstLineOfTheLog = ((DifferentPage6) TestContext.getActualPage()).getFirstLineOfTheLog().getText();
        String regex = ".*" + item.getText().trim();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(firstLineOfTheLog);
        assertTrue(matcher.matches());

    }

    @Then("for a clicked dropdown item '([^\"]*)' there is a corresponding log line")
    public void logLineShouldCorrespondWithActions(DropdownSelect value) {
        elements = TestContext.getActualPage().getSectionItems(DROPDOWN_OPTIONS);
        WebElement item = getSpecificItem(value, elements);
        if (!(item.isSelected())) {
            item.click();
            String firstLineOfTheLog = ((DifferentPage6) TestContext.getActualPage()).getFirstLineOfTheLog().getText();
            String regex = ".*" + value.toString();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(firstLineOfTheLog);
            assertTrue(matcher.matches());


        }
    }

    @Then("User table contains following values:")
    public void userTableShouldContainValues(DataTable arg) {
        List<Map<String, String>> table = arg.asMaps(String.class, String.class);
        for (Map<String, String> map : table) {
            String number = map.get("Number");
            assertNotNull(((UserTablePage6) TestContext.getActualPage()).getUserNumber(number));
            WebElement userName = ((UserTablePage6) TestContext.getActualPage()).getUserName(number);
            assertEquals(userName.getText(), map.get("User"));
            WebElement userDescription = ((UserTablePage6) TestContext.getActualPage()).getUserDescription(number);
            assertEquals(userDescription.getText(), map.get("Description"));
        }

    }

    @Then("1 log line has \"Vip: condition changed to '(true|false)'\" text in log section")
    public void vipActionShouldBeReflectedInLogLine(String flag) {
        String firstLineOfTheLog = ((UserTablePage6) TestContext.getActualPage()).getFirstLineOfTheLog().getText();
        String regex = ".*" + "Vip: condition changed to " + flag;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(firstLineOfTheLog);
        assertTrue(matcher.matches());
    }

    @Then("'([^\"]*)' droplist contains values")
    public void userTypeDroplistShouldContainValues(String userName, List<String> expectedList) {
        elements = ((UserTablePage6) TestContext.getActualPage()).getUserTypeDropdownItems(userName);
        List<String> actualList = new ArrayList<>();
        for (WebElement element : elements) {
            actualList.add(element.getText());
        }
        assertEquals(actualList, expectedList);
    }
}


//    Number | User             | Description                  |
//            | 1      | Roman            | Lorem ipsum                  |
//            | 2      | Sergey Ivan      | Lorem ipsum                  |
//            | 3      | Vladzimir        | Lorem ipsum                  |
//            | 4      | Helen Bennett    | Lorem ipsum some description |
//            | 5      | Yoshi Tannamuri  | Lorem ipsum some description |
//            | 6      | Giovanni Rovelli | Lorem ipsum some description |

