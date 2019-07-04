package hw5.ex2;

import hw5.AllureAttachmentListener;
import hw5.BaseTest3;
import hw5.enums.Labels.Checkboxes;
import hw5.enums.Labels.DropdownSelect;
import hw5.enums.Labels.Radiobuttons;
import hw5.enums.Location;
import hw5.enums.ServiceSectionItems;
import hw5.steps.DifferentPageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(AllureAttachmentListener.class)
public class Ex2 extends BaseTest3 {

    @Feature("Homework 3 revised for Allure: Functionality of steps + page objects")
    @Story("Basic sections a home page + sections and functionality of Different Elements page")
    @Test
    public void Ex1HW3Test() {
        // 1. - 4.
        checkLogin();

        //5. Click on "Service" subcategory in the header and check that drop down contains options
        List<String> expectedList = toStringList(ServiceSectionItems.values());
        homePageSteps.clickItem(Location.SERVICE_HEADER);
        homePageSteps.itemsAreAllPresentInSection(Location.SERVICE_HEADER, expectedList);

        //6. Click on Service subcategory in the left section and check that drop down contains options
        homePageSteps.clickItem(Location.SERVICE_LEFT);
        homePageSteps.itemsAreAllPresentInSection(Location.SERVICE_LEFT, expectedList);

        //7. Open through the header menu Service -> Different Elements Page
        homePageSteps.clickItem(Location.SERVICE_HEADER);
        homePageSteps.clickItem(Location.DIFFERENT_ELEMENTS);

        DifferentPageSteps differentPageSteps = new DifferentPageSteps(driver);
        differentPageSteps.pageNameIsCorrect("Different Elements");

        //8. Check interface on Different elements page, it contains all needed elements
        differentPageSteps.itemsAreInProperQuantity(Location.CHECKBOXES, 4);
        differentPageSteps.itemsAreInProperQuantity(Location.RADIOBUTTONS, 4);
        differentPageSteps.itemsAreInProperQuantity(Location.DROPDOWN, 1);
        differentPageSteps.itemsAreInProperQuantity(Location.BUTTONS, 2);

        //9. Assert that there is Right Section
        differentPageSteps.sectionIsDisplayed(Location.LEFT_SECTION);

        ////10. Assert that there is Left Section
        differentPageSteps.sectionIsDisplayed(Location.LOG_SECTION);

        //11. Select checkboxes Water, Wind
        differentPageSteps.clickLabelAndCheckSelection(Checkboxes.WATER, true);
        differentPageSteps.clickLabelAndCheckSelection(Checkboxes.WIND, true);

        //12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        differentPageSteps.linesOfTheLogReflectActionsWithLabel(Checkboxes.WATER);
        differentPageSteps.linesOfTheLogReflectActionsWithLabel(Checkboxes.WIND);

        //13. Select radio Selen
        differentPageSteps.clickLabelAndCheckSelection(Radiobuttons.SELEN, true);

        //14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        differentPageSteps.linesOfTheLogReflectActionsWithLabel(Radiobuttons.SELEN);

        //15. Select in dropdown	Yellow
        differentPageSteps.clickLabelAndCheckSelection(DropdownSelect.YELLOW, true);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value.
        differentPageSteps.linesOfTheLogReflectActionsWithLabel(DropdownSelect.YELLOW);

        //17. Unselect and assert checkboxes Water, Wind
        differentPageSteps.clickLabelAndCheckSelection(Checkboxes.WATER, false);
        differentPageSteps.clickLabelAndCheckSelection(Checkboxes.WIND, false);

        //18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        differentPageSteps.linesOfTheLogReflectActionsWithLabel(Checkboxes.WATER);
        differentPageSteps.linesOfTheLogReflectActionsWithLabel(Checkboxes.WIND);

    }
}
