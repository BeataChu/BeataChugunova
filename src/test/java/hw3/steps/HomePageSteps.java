package hw3.steps;

import hw3.enums.Location;
import hw3.pageObjects.HomePage;
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

    public void login(String userName, String password) {
        ((HomePage) actualPage).login(userName, password);
    }


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

    public void switchToFrameCheckLogoAndSwitchBack() {
        ((HomePage) actualPage).switchToFrame();
        assertTrue(((HomePage) actualPage).getEpamLogo().isDisplayed());
        ((HomePage) actualPage).switchToDefaultContent();
    }

    public void itemBelowCenterHasProperText(String expectedText) {
        assertEquals(((HomePage) actualPage).getTextBelowCenter().getText(), expectedText);
    }

    public void itemBelowCenterHasProperLink(String expectedURL) {
        assertEquals(((HomePage) actualPage).getTextBelowCenter().getAttribute("href"), expectedURL);
    }


}
