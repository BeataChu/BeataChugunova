package hw5.steps;

import hw5.TestProvider;
import hw5.page_objects.BasePage;
import hw5.enums.Location;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public abstract class BasicSteps {

    protected WebDriver driver;
    protected BasePage actualPage;
    protected List<WebElement> elements;
    protected List<String> actualList;

    protected BasicSteps(WebDriver driver) {
        this.driver = driver;
        TestProvider.getInstance().setDriver(driver);
    }

    @Step("Check page name (expected: {expectedPageName}")
    public void pageNameIsCorrect(String expectedPageName) {
        assertEquals(actualPage.getPageTitle(), expectedPageName);
    }

    @Step("Get User's full name")
    public String getLoggedUserName() {
        return actualPage.getLoggedUserName();
    }

    @Step("Check if items are all displayed in section {location}")
    public void itemsAreAllPresentInSection(Location location, List<String> expectedList) {

        switch (location) {
            case SERVICE_HEADER:
                elements = actualPage.getServiceHeaderSectionItems();
                break;
            case SERVICE_LEFT:
                elements = actualPage.getServiceLeftSectionItems();
                break;
            default:
                throw new NoSuchElementException("No such element");
        }
        actualList = new ArrayList<>();
        for (WebElement element : elements) {
            String itemText = element.getText().toUpperCase().trim();
            if (expectedList.contains(itemText)) {
                actualList.add(itemText);
            }
        }
        assertEquals(actualList, expectedList);
    }

    @Step("Click item in {location}")
    public void clickItem(Location location) {
        WebElement item;
        switch (location) {
            case SERVICE_HEADER:
                item = actualPage.getServiceHeaderTitle();
                break;
            case SERVICE_LEFT:
                item = actualPage.getServiceLeftTitle();
                break;
            case DIFFERENT_ELEMENTS:
                item = actualPage.getDifferentElements();
                break;
            default:
                throw new NoSuchElementException("No such element");
        }
        item.click();
    }

    abstract public void itemsAreInProperQuantity(Location location, int quantity);

    abstract public void sectionIsDisplayed(Location location);

}

