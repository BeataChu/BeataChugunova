package hw5.steps;

import hw5.page_objects.DifferentPage;
import hw5.enums.Labels.BaseLabel;
import hw5.enums.Labels.Checkboxes;
import hw5.enums.Labels.DropdownSelect;
import hw5.enums.Labels.Radiobuttons;
import hw5.enums.Location;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentPageSteps extends BasicSteps {


    public DifferentPageSteps(WebDriver driver) {
        super(driver);
        actualPage = new DifferentPage(driver);
    }

    @Step("Check a quantity of displayed items")
    public void itemsAreInProperQuantity(Location location, int quantity) {
        switch (location) {
            case CHECKBOXES:
                elements = ((DifferentPage) actualPage).getCheckboxes();
                break;
            case RADIOBUTTONS:
                elements = ((DifferentPage) actualPage).getRadioButtons();
                break;
            case DROPDOWN:
                elements = ((DifferentPage) actualPage).getDropdown();
                break;
            case BUTTONS:
                elements = ((DifferentPage) actualPage).getButtons();
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
            case LOG_SECTION:
                item = ((DifferentPage) actualPage).getLogSection();
                break;
            case LEFT_SECTION:
                item = (actualPage).getLeftSection();
                break;
            default:
                throw new NoSuchElementException("No such element");
        }
        assertTrue(item.isDisplayed());
    }

    @Step("Find exact label")
    public WebElement findLabel(BaseLabel label) {
        if (label instanceof Checkboxes) {
            elements = ((DifferentPage) actualPage).getCheckboxes();
        } else if (label instanceof Radiobuttons) {
            elements = ((DifferentPage) actualPage).getRadioButtons();
        } else if (label instanceof DropdownSelect) {
            elements = ((DifferentPage) actualPage).getDropdown();
            elements.get(0).click();
        }

        WebElement item = null;
        for (WebElement element : elements) {
            if (element.getText().toUpperCase().contains(label.toString())) {
                item = element.findElement(By.xpath("./*"));
                break;
            }
        }
        return item;
    }

    @Step("Click label {label} and check selection")
    public void clickLabelAndCheckSelection(BaseLabel label, boolean isSelected) {
        WebElement item = findLabel(label);
        item.click();
        assertEquals(item.isSelected(), isSelected);
    }

    @Step("Check that log reflects actions on label {label}")
    public void linesOfTheLogReflectActionsWithLabel(BaseLabel label) {
        String firstLineOfTheLog, regex;
        WebElement item = findLabel(label);
        if (!(item.isSelected())) {
            item.click();
            firstLineOfTheLog = ((DifferentPage) actualPage).getFirstLineOfTheLog().getText();
            if (label instanceof Checkboxes) {
                regex = ".*" + item.getText().trim() + ".*" + item.isSelected();
            } else {
                regex = ".*" + item.getText().trim();
            }
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(firstLineOfTheLog);
            assertTrue(matcher.matches());

        }


    }
}
