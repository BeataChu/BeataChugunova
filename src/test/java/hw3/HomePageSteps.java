package hw3;

import hw2.LocatorType;
import hw3.enums.Location;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class HomePageSteps {

    private WebDriver driver;
    private HomePage homePage;
    private List<WebElement> elements;
    private List<String> actualList;

    protected HomePageSteps(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
    }

    public void login(String userName, String password) {
        homePage.login(userName, password);
    }

    public String getPageName() {
        return homePage.getPageTitle();
    }

    public String getLoggedUserName() {
        return homePage.getLoggedUserName();
    }

    public void itemsAreInProperQuantityWithProperTexts(Location location, List<String> expectedList) {

        switch (location) {
            case HEADER_SECTION:
                elements = homePage.getHeaderSectionTitles();
                break;
            case CENTER:
                elements = homePage.getCenterSectionTitles();
                break;
            case UNDER_GREEN_PICTURES:
                elements = homePage.getCaptionsUnderGreenPictures();
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


    public void greenPicturesExistInProperQuantity(int quantity) {
        List<WebElement> elements = homePage.getGreenPictures();
        assertEquals(elements.size(), quantity);
    }

    public void sectionIsDisplayed(Location location) {
        WebElement item;
        switch (location){
            case FRAME: item = homePage.getFrame();
            break;
            case LEFT_SECTION: item = homePage.getLeftSection();
            break;
            case FOOTER: item = homePage.getFooter();
            break;
            default:
                throw new NoSuchElementException("No such element");
        }
        assertTrue(item.isDisplayed());

    }

    public void switchToFrameCheckLogoAndSwitchBack() {
        homePage.switchToFrame();
        assertTrue(homePage.getEpamLogo().isDisplayed());
        homePage.switchToDefaultContent();
    }

    public void itemBelowCenterHasProperText(String expectedText) {
        assertEquals(homePage.getTextBelowCenter().getText(), expectedText);
    }

    public void itemBelowCenterHasProperLink(String expectedURL){
        assertEquals(homePage.getTextBelowCenter().getAttribute("href"), expectedURL);
    }
}
