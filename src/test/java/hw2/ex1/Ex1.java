package hw2.ex1;

import hw2.BaseTest;
import hw2.LocatorType;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.assertNotNull;

public class Ex1 extends BaseTest {

    // TODO Please format code according to Java Code Convention (length line of code)
    @Test
    public void exerciseOneTest() {
        checkLogin();

        //5. Assert Browser title
        utilities.pageTitleIsCorrect("Home Page");

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        utilities.itemsAreInProperQuantityAndContainProperTexts(LocatorType.CSS, "header .nav>li", new ArrayList<String>(Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS")));

        //7. Assert that there are 4 images on the Index Page and they are displayed
        utilities.itemsOfATypeExistInProperQuantity(LocatorType.CSS, ".uui-main-container .icons-benefit", 4);

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        utilities.itemsAreInProperQuantityAndContainProperTexts(LocatorType.CSS, ".uui-main-container .benefit-txt", new ArrayList<String>(Arrays.asList("To include good practices\nand ideas from successful\nEPAM project", "To be flexible and\ncustomizable", "To be multiplatform", "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…")));

        //9. Assert a text of the main headers
        utilities.itemIsDisplayedAndHaveProperText(LocatorType.NAME, "main-title", "EPAM FRAMEWORK WISHES…");
        utilities.itemIsDisplayedAndHaveProperText(LocatorType.NAME, "jdi-text", "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10. Assert that there is an iframe in the center of the page
        assertNotNull(driver.findElement(By.id("iframe")));

        //11.Switch to the iframe and check that there is Epam logo in the left top conner of iframe and
        //12.Switch to original window back
        utilities.switchToFrameCheckLogoAndSwitchBack("iframe", LocatorType.ID, "epam_logo");


        //13. Assert a text of the sub header
        utilities.itemIsDisplayedAndHaveProperText(LocatorType.CSS, "h3.text-center a", "JDI GITHUB");

        //14. Assert that JDI GITHUB is a link and has a proper URL
        utilities.itemIsALinkWithProperURL(LocatorType.PARTIAL_LINK, "JDI GITHUB", "https://github.com/epam/JDI");

        //15. Assert that there is Left Section
        utilities.itemIsDisplayed(LocatorType.CLASS_NAME, "uui-side-bar");

        //16. Assert that there is Footer
        utilities.itemIsDisplayed(LocatorType.CLASS_NAME, "footer-bg");
    }
}
