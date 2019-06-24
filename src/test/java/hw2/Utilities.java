package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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

        findOne(LocatorType.ID,"user-icon").click();
        findOne(LocatorType.ID, "name").sendKeys(userLogin);
        findOne(LocatorType.CSS,("#password")).sendKeys(password);
        findOne(LocatorType.XPATH,("//button[@id='login-button']")).click();
    }


    public void userIsLoggedIn(LocatorType type, String locator, String expectedUserName){
        WebElement item = findOne(type, locator);
        assertEquals(item.getText(), expectedUserName);
    }

    public void itemsOfATypeExistInProperQuantity(LocatorType type, String locator, int listSize){
        List<WebElement> elements = findList(type, locator);
        assertEquals(elements.size(), listSize);
    }

    public void itemsAreInProperQuantityAndContainProperTexts(LocatorType type, String locator, List<String> expectedList) {
        List<WebElement> elements = findList(type, locator);
        List<String> actualList = new ArrayList<>();
        for (WebElement element : elements) {
            actualList.add(element.getText());
        }
        //at the same time we check here both quantity and content of list elements
        assertEquals(actualList, expectedList);
    }

    public void itemsAreAllPresentInSection(LocatorType type, String locator, List<String> expectedList) {
        List<WebElement> elements = findList(type, locator);
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

    public void itemIsDisplayed(LocatorType type, String locator){
        WebElement item = findOne(type, locator);
        assertTrue(item.isDisplayed());
    }

    public void itemIsDisplayedAndHaveProperText(LocatorType type, String locator, String text) {
        WebElement item = findOne(type, locator);
        assertTrue(item.isDisplayed());
        assertEquals(item.getText(),text);
    }

    public void switchToFrameCheckLogoAndSwitchBack(String frameName, LocatorType type, String locator){
        driver.switchTo().frame(frameName);
        assertTrue(findOne(type, locator).isDisplayed());
        driver.switchTo().defaultContent();
    }

    public void itemIsALinkWithProperURL(LocatorType type, String locator, String expectedURL) {
        WebElement item = findOne(type, locator);
        assertEquals(item.getAttribute("href"),expectedURL);
    }

    public void selectItemAndAssertItemSelected(String locator, boolean isSelected){
        WebElement item = driver.findElement(By.xpath(locator));
        item.click();
        assertEquals(item.isSelected(), isSelected);
    }

    public void linesOfTheLogReflectActionsInCheckboxes(LocatorType locatorTypeForLabel, String locatorForLabel, String prefixForCheckpoint) {
        String firstLineOfTheLog, regex;
        WebElement checkpoint;
        List<WebElement> labelsList = findList(locatorTypeForLabel, locatorForLabel);
        for (WebElement label : labelsList) {
            checkpoint = label.findElement(By.xpath(prefixForCheckpoint));

            if (!(checkpoint.isSelected())) {
                checkpoint.click();
                firstLineOfTheLog = findOne(LocatorType.CSS, ".panel-body-list.logs>li").getText();
                if (locatorForLabel.contains("checkbox")){
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



        //methods to obtain WebElements
    public WebElement findOne(LocatorType type, String locator) {
        try {
            switch (type) {
                case NAME:
                    return driver.findElement(By.name(locator));
                case CLASS_NAME:
                    return driver.findElement(By.className(locator));
                case ID:
                    return driver.findElement(By.id(locator));
                case LINK:
                    return driver.findElement(By.linkText(locator));
                case PARTIAL_LINK:
                    return driver.findElement(By.partialLinkText(locator));
                case CSS:
                    return driver.findElement(By.cssSelector(locator));
                case XPATH:
                    return driver.findElement(By.xpath(locator));
                default:
                    return null;
            }
        } catch (NoSuchElementException nsee) {
            throw new NoSuchElementException(
                    String.format("Unable to find element by type %s and locator %s", type, locator));
        }
    }

    public List<WebElement> findList(LocatorType type, String locator) {
        try {
            switch (type) {
                case NAME:
                    return driver.findElements(By.name(locator));
                case CLASS_NAME:
                    return driver.findElements(By.className(locator));
                case ID:
                    return driver.findElements(By.id(locator));
                case LINK:
                    return driver.findElements(By.linkText(locator));
                case PARTIAL_LINK:
                    return driver.findElements(By.partialLinkText(locator));
                case CSS:
                    return driver.findElements(By.cssSelector(locator));
                case XPATH:
                    return driver.findElements(By.xpath(locator));
                default:
                    return null;
            }
        } catch (NoSuchElementException nsee) {
            throw new NoSuchElementException(
                    String.format("Unable to find element by type %s and locator %s", type, locator));
        }
    }






}