package hw3.ex1;

import hw3.BaseTest3;
import hw3.enums.CaptionsUnderGreenPictures;
import hw3.enums.CenteredHeaders;
import hw3.enums.HeaderItems;
import hw3.enums.Location;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class Ex1 extends BaseTest3 {


    @Test
    public void Ex1HW3Test() {
        // 1. - 4.
        checkLogin();

        //5. Assert Browser title
        assertTrue(homePageSteps.getLoggedUserName().equalsIgnoreCase(userInfo.getProperty("user.user.name")));

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts

        HeaderItems.values().toString();

        List<String> expectedList = toStringList(HeaderItems.values());
        homePageSteps.itemsAreInProperQuantityWithProperTexts(Location.HEADER_SECTION, expectedList);

        //7. Assert that there are 4 images on the Index Page and they are displayed
        homePageSteps.itemsAreInProperQuantity(Location.GREEN_PICTURES, 4);

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        expectedList = toStringList(CaptionsUnderGreenPictures.values());
        homePageSteps.itemsAreInProperQuantityWithProperTexts(Location.UNDER_GREEN_PICTURES, expectedList);

        //9. Assert a text of the main headers
        expectedList = Arrays.asList(CenteredHeaders.EPAM_WISHES.toString(), CenteredHeaders.LOREM_IPSUM.toString());
        homePageSteps.itemsAreInProperQuantityWithProperTexts(Location.CENTER, expectedList);

        //10. Assert that there is an iframe in the center of the page
        homePageSteps.sectionIsDisplayed(Location.FRAME);

        //11.Switch to the iframe and check that there is Epam logo in the left top conner of iframe and
        //12.Switch to original window back
        homePageSteps.switchToFrameCheckLogoAndSwitchBack();

        //13. Assert a text of the sub header
        homePageSteps.itemBelowCenterHasProperText(CenteredHeaders.JDI.toString());

        //14. Assert that JDI GITHUB is a link and has a proper URL
        homePageSteps.itemBelowCenterHasProperLink(CenteredHeaders.JDI_URL.toString());

        //15. Assert that there is Left Section
        homePageSteps.sectionIsDisplayed(Location.LEFT_SECTION);

        //16. Assert that there is Footer
        homePageSteps.sectionIsDisplayed(Location.FOOTER);

    }
}
