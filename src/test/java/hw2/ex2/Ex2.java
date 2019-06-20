package hw2.ex2;

import hw2.BaseTest;
import hw2.LocatorType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex2 extends BaseTest {

    @Test
    public void exercise2Test() {

        //5. Click on "Service" subcategory in the header and check that drop down contains options
        WebElement service = driver.findElement(By.cssSelector(".uui-header .m-l8 .dropdown-toggle"));
        service.click();

        utilities.itemsAreAllPresentInSection(LocatorType.CSS, ".uui-header .m-l8 .dropdown-menu a", new ArrayList<String>(Arrays.asList("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS")));


        //6. Click on Service subcategory in the left section and check that drop down contains options
        service = driver.findElement(By.cssSelector(".sidebar-menu .menu-title[index='3']"));
        service.click();
        utilities.itemsAreAllPresentInSection(LocatorType.CSS, ".sidebar-menu .menu-title[index='3'] ul a", new ArrayList<String>(Arrays.asList("Support", "Dates", "Complex Table", "Simple Table", "Table with pages", "Different elements")));

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
        utilities.selectItemAndAssertItemSelected(LocatorType.XPATH, "//label[contains(string(),'Water')]/input", true);
        utilities.selectItemAndAssertItemSelected(LocatorType.XPATH, "//label[contains(string(),'Wind')]/input", true);

        //12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        utilities.linesOfTheLogReflectActionsInCheckboxes(LocatorType.CLASS_NAME, "label-checkbox", "./input");

        //13. Select radio Selen
        utilities.selectItemAndAssertItemSelected(LocatorType.XPATH, "//label[contains(string(),'Selen')]/input", true);

        //14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        utilities.linesOfTheLogReflectActionsInCheckboxes(LocatorType.CLASS_NAME, "label-radio", "./input");

        //15. Select in dropdown	Yellow
        driver.findElement(By.cssSelector(".colors>.uui-form-element")).click();
        utilities.selectItemAndAssertItemSelected(LocatorType.XPATH, "//div[@class = 'colors']//option[contains(text(), 'Yellow')]", true);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value.
        utilities.linesOfTheLogReflectActionsInCheckboxes(LocatorType.CSS, ".colors>.uui-form-element", "./option");

        //17. Unselect and assert checkboxes Water, Wind
        utilities.selectItemAndAssertItemSelected(LocatorType.XPATH, "//label[contains(string(),'Water')]/input", false);
        utilities.selectItemAndAssertItemSelected(LocatorType.XPATH, "//label[contains(string(),'Wind')]/input", false);

        //18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        utilities.linesOfTheLogReflectActionsInCheckboxes(LocatorType.CLASS_NAME, "label-checkbox", "./input");

    }


}