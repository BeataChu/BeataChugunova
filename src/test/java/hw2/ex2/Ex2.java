package hw2.ex2;

import hw2.BaseTest;
import hw2.LocatorType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Ex2 extends BaseTest {

    // TODO Please format code according to Java Code Convention (length line of code)
    @Test
    public void exerciseTwoTest() {

        checkLogin();

        //5. Click on "Service" subcategory in the header and check that drop down contains options
        ArrayList<String> sideMenuItems = new ArrayList<>(Arrays.asList("support", "dates", "complex table", "simple table", "table with pages", "different elements"));
        WebElement service = driver.findElement(By.cssSelector(".uui-header .m-l8 .dropdown-toggle"));
        service.click();

        utilities.itemsAreAllPresentInSection(LocatorType.CSS, ".uui-header .m-l8 .dropdown-menu a", sideMenuItems);


        //6. Click on Service subcategory in the left section and check that drop down contains options
        service = driver.findElement(By.xpath("//ul[@class = 'sidebar-menu']//*[text() = 'Service']"));
        // TODO I do not get this sout
        System.out.println("31");
        service.click();
        // TODO I do not get this sout
        System.out.println("32");

        utilities.itemsAreAllPresentInSection(LocatorType.XPATH, "//li[@class='menu-title' and contains(.//span,'Service')]//li//span", sideMenuItems);

        //7. Open through the header menu Service -> Different Elements Page
        driver.findElement(By.cssSelector(".uui-header .m-l8 .dropdown-toggle")).click();
        driver.findElement(By.xpath("//header//a[text() ='Different elements']")).click();
        utilities.pageTitleIsCorrect("Different Elements");

        //8. Check interface on Different elements page, it contains all needed elements
        //i.e. 4 checkboxes, 4 radios, 1 dropdown, 2 buttons

        utilities.itemsOfATypeExistInProperQuantity(LocatorType.CLASS_NAME, "label-checkbox", 4);
        utilities.itemsOfATypeExistInProperQuantity(LocatorType.CLASS_NAME, "label-radio", 4);
        utilities.itemsOfATypeExistInProperQuantity(LocatorType.CSS, "select[class=\"uui-form-element\"]", 1);
        utilities.itemsOfATypeExistInProperQuantity(LocatorType.CSS, ".main-content .uui-button", 2);

        //9. Assert that there is Right Section
        utilities.itemIsDisplayed(LocatorType.NAME, "navigation-sidebar");

        //10. Assert that there is Left Section
        utilities.itemIsDisplayed(LocatorType.NAME, "log-sidebar");


        //11. Select checkboxes Water, Wind

        String buttonsTemplate = "//label[contains(string(),'%s')]/input";
        String water = String.format(buttonsTemplate, "Water");
        String wind = String.format(buttonsTemplate, "Wind");


        utilities.selectItemAndAssertItemSelected(water, true);
        utilities.selectItemAndAssertItemSelected(wind, true);

        //12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        utilities.linesOfTheLogReflectActionsInCheckboxes(LocatorType.CLASS_NAME, "label-checkbox", "./input");

        //13. Select radio Selen
        String selen = String.format(buttonsTemplate, "Selen");
        utilities.selectItemAndAssertItemSelected(selen, true);

        //14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        utilities.linesOfTheLogReflectActionsInCheckboxes(LocatorType.CLASS_NAME, "label-radio", "./input");

        //15. Select in dropdown	Yellow
        driver.findElement(By.cssSelector(".colors>.uui-form-element")).click();
        utilities.selectItemAndAssertItemSelected("//div[@class = 'colors']//option[contains(text(), 'Yellow')]", true);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value.
        utilities.linesOfTheLogReflectActionsInCheckboxes(LocatorType.CSS, ".colors>.uui-form-element", "./option");

        //17. Unselect and assert checkboxes Water, Wind
        utilities.selectItemAndAssertItemSelected(water, false);
        utilities.selectItemAndAssertItemSelected(wind, false);

        //18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        utilities.linesOfTheLogReflectActionsInCheckboxes(LocatorType.CLASS_NAME, "label-checkbox", "./input");

    }


}