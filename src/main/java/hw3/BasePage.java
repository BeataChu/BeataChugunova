package hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    @FindBy(id = "user-name")
    private WebElement loggedUserName;

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    public void clickLeftSideMenu(LeftSideMenu menuItem) {
//        driver.findElement(By.linkText(menuItem.getName())).click();
//    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getLoggedUserName(){
        return loggedUserName.getText();
    }

    public List<WebElement> getElementsByCss(String locator) {
        return (driver).findElements(By.cssSelector(locator));
    }



}

