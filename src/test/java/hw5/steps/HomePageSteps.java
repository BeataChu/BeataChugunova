package hw5.steps;

import hw5.page_objects.HomePage;
import hw5.enums.Location;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSteps extends BasicSteps {


    public HomePageSteps(WebDriver driver) {
        super(driver);
        actualPage = new HomePage(driver);
    }


    @Step("Log in")
    public void login(String userName, String password) {
        ((HomePage) actualPage).login(userName, password);
    }


    @Step("Check items quantity and displayed texts")
    public void itemsAreInProperQuantityWithProperTexts(Location location, List<String> expectedList) {

        switch (location) {
            case HEADER_SECTION:
                elements = (actualPage).getHeaderSectionTitles();
                break;
            case CENTER:
                elements = ((HomePage) actualPage).getCenterSectionTitles();
                break;
            case UNDER_GREEN_PICTURES:
                elements = ((HomePage) actualPage).getCaptionsUnderGreenPictures();
                break;

            default:
                throw new NoSuchElementException("No such element");
        }
        actualList = new ArrayList<>();
        for (WebElement element : elements) {
            actualList.add(element.getText());
        }
        assertEquals(actualList, expectedList);
    }

    @Step("Check a quantity of items")
    public void itemsAreInProperQuantity(Location location, int quantity) {
        switch (location) {
            case GREEN_PICTURES:
                elements = ((HomePage) actualPage).getGreenPictures();
                break;
            default:
                throw new NoSuchElementException("No such element");
        }
        assertEquals(elements.size(), quantity);
    }

    @Step("Check if section is displayed")
    public void sectionIsDisplayed(Location location) {
        WebElement item;
        switch (location) {
            case FRAME:
                item = ((HomePage) actualPage).getFrame();
                break;
            case LEFT_SECTION:
                item = (actualPage).getLeftSection();
                break;
            case FOOTER:
                item = (actualPage).getFooter();
                break;
            default:
                throw new NoSuchElementException("No such element");
        }
        assertTrue(item.isDisplayed());

    }

    @Step("Switch to another frame, check logo and get back")
    public void switchToFrameCheckLogoAndSwitchBack() {
        ((HomePage) actualPage).switchToFrame();
        assertTrue(((HomePage) actualPage).getEpamLogo().isDisplayed());
        ((HomePage) actualPage).switchToDefaultContent();
    }

    @Step("Check text of subheaders")
    public void itemBelowCenterHasProperText(String expectedText) {
        assertEquals(((HomePage) actualPage).getTextBelowCenter().getText(), expectedText);
    }

    @Step("Check link for subheader JDI Github")
    public void itemBelowCenterHasProperLink(String expectedURL) {
        assertEquals(((HomePage) actualPage).getTextBelowCenter().getAttribute("href"), expectedURL);
    }


}
