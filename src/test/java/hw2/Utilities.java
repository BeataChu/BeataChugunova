package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Utilities {

    private WebDriver driver;

    public Utilities(WebDriver driver) {
        this.driver = driver;
    }

    //2. Assert browser title and 5. Assert Browser title
    public void pageTitleIsCorrect(String expectedTitle) {
        assertEquals(driver.getTitle(), expectedTitle);
    }


    //3. Perform login + 4. Assert User name in the left-top side of screen that user is logged in
    public void login(String userLogin, String password) {

        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys(userLogin);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='login-button']")).click();
    }


    public void userIsLoggedIn(By locator, String expectedUserName) {
        WebElement item = driver.findElement(locator);
        assertEquals(item.getText(), expectedUserName);
    }

    public void itemsOfATypeExistInProperQuantity(By locator, int listSize) {
        List<WebElement> elements = driver.findElements(locator);
        assertEquals(elements.size(), listSize);
    }

    public void itemsAreInProperQuantityAndContainProperTexts(By locator, List<String> expectedList) {
        List<WebElement> elements = driver.findElements(locator);
        List<String> actualList = new ArrayList<>();
        for (WebElement element : elements) {
            actualList.add(element.getText());
        }
        //at the same time we check here both quantity and content of list elements
        assertEquals(actualList, expectedList);
    }

    public void itemsAreAllPresentInSection(By locator, List<String> expectedList) {
        List<WebElement> elements = driver.findElements(locator);
        List<String> actualList = new ArrayList<>();

        for (WebElement element : elements) {
            String itemText = element.getText().toLowerCase().trim();
            if (expectedList.contains(itemText)) {
                actualList.add(itemText);
            }
        }
        //at the same time we check here both quantity and content of list elements
        assertEquals(actualList, expectedList);
    }

    public void itemIsDisplayed(By locator) {
        WebElement item = driver.findElement(locator);
        assertTrue(item.isDisplayed());
    }

    public void itemIsDisplayedAndHaveProperText(By locator, String text) {
        WebElement item = driver.findElement(locator);
        assertTrue(item.isDisplayed());
        assertEquals(item.getText(), text);
    }

    public void switchToFrameCheckLogoAndSwitchBack(String frameName, By locator) {
        driver.switchTo().frame(frameName);
        assertTrue(driver.findElement(locator).isDisplayed());
        driver.switchTo().defaultContent();
    }

    public void itemIsALinkWithProperURL(By locator, String expectedURL) {
        WebElement item = driver.findElement(locator);
        assertEquals(item.getAttribute("href"), expectedURL);
    }

    public void selectItemAndAssertItemSelected(String locator, boolean isSelected) {
        WebElement item = driver.findElement(By.xpath(locator));
        item.click();
        assertEquals(item.isSelected(), isSelected);
    }

    public void linesOfTheLogReflectActionsInCheckboxes(By locatorForLabel, String prefixForCheckpoint) {
        String firstLineOfTheLog, regex;
        WebElement checkpoint;
        List<WebElement> labelsList = driver.findElements(locatorForLabel);
        for (WebElement label : labelsList) {
            checkpoint = label.findElement(By.xpath(prefixForCheckpoint));

            if (!(checkpoint.isSelected())) {
                checkpoint.click();
                firstLineOfTheLog = driver.findElement(By.cssSelector(".panel-body-list.logs>li")).getText();
                if (locatorForLabel.toString().contains("checkbox")) {
                    regex = ".*" + checkpoint.getText().trim() + ".*" + checkpoint.isSelected();
                } else {
                    regex = ".*" + checkpoint.getText().trim();
                }
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(firstLineOfTheLog);
                assertTrue(matcher.matches());
            }
        }
    }


}