package hw2.ex2;

import hw2.BaseTest2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex2 extends BaseTest2 {

    // TODO Please format code according to Java Code Convention (length line of code) - fixed
    @Test
    public void exerciseTwoTest() {

        checkLogin();

        //5. Click on "Service" subcategory in the header and check that drop down contains options
        ArrayList<String> sideMenuItems = new ArrayList<>(Arrays.asList
                ("support", "dates", "complex table", "simple table", "table with pages", "different elements"));
        WebElement service = driver.findElement(By.cssSelector(".uui-header .m-l8 .dropdown-toggle"));
        service.click();

        utilities.itemsAreAllPresentInSection(By.cssSelector(".uui-header .m-l8 .dropdown-menu a"), sideMenuItems);


        //6. Click on Service subcategory in the left section and check that drop down contains options
        service = driver.findElement(By.xpath("//ul[@class = 'sidebar-menu']//*[text() = 'Service']"));
        service.click();
        utilities.itemsAreAllPresentInSection(By.xpath(
                "//li[@class='menu-title' and contains(.//span,'Service')]//li//span"), sideMenuItems);

        //7. Open through the header menu Service -> Different Elements Page
        driver.findElement(By.cssSelector(".uui-header .m-l8 .dropdown-toggle")).click();
        driver.findElement(By.xpath("//header//a[text() ='Different elements']")).click();
        utilities.pageTitleIsCorrect("Different Elements");

        //8. Check interface on Different elements page, it contains all needed elements
        //i.e. 4 checkboxes, 4 radios, 1 dropdown, 2 buttons

        utilities.itemsOfATypeExistInProperQuantity(By.className("label-checkbox"), 4);
        utilities.itemsOfATypeExistInProperQuantity(By.className("label-radio"), 4);
        utilities.itemsOfATypeExistInProperQuantity(By.cssSelector("select[class=\"uui-form-element\"]"), 1);
        utilities.itemsOfATypeExistInProperQuantity(By.cssSelector(".main-content .uui-button"), 2);

        //9. Assert that there is Right Section
        utilities.itemIsDisplayed(By.name("navigation-sidebar"));

        //10. Assert that there is Left Section
        utilities.itemIsDisplayed(By.name("log-sidebar"));


        //11. Select checkboxes Water, Wind

        String buttonsTemplate = "//label[contains(string(),'%s')]/input";
        String water = String.format(buttonsTemplate, "Water");
        String wind = String.format(buttonsTemplate, "Wind");


        utilities.selectItemAndAssertItemSelected(water, true);
        utilities.selectItemAndAssertItemSelected(wind, true);

        //12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        utilities.linesOfTheLogReflectActionsInCheckboxes(By.className(
                "label-checkbox"), "./input");

        //13. Select radio Selen
        String selen = String.format(buttonsTemplate, "Selen");
        utilities.selectItemAndAssertItemSelected(selen, true);

        //14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        utilities.linesOfTheLogReflectActionsInCheckboxes(By.className(
                "label-radio"), "./input");

        //15. Select in dropdown	Yellow
        driver.findElement(By.cssSelector(".colors>.uui-form-element")).click();
        utilities.selectItemAndAssertItemSelected("//div[@class = 'colors']//option[contains(text(), 'Yellow')]",
                true);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value.
        utilities.linesOfTheLogReflectActionsInCheckboxes(By.cssSelector(
                ".colors>.uui-form-element"), "./option");

        //17. Unselect and assert checkboxes Water, Wind
        utilities.selectItemAndAssertItemSelected(water, false);
        utilities.selectItemAndAssertItemSelected(wind, false);

        //18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        utilities.linesOfTheLogReflectActionsInCheckboxes(By.className(
                "label-checkbox"), "./input");

    }


}