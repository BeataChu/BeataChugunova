package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePage extends BasePage {
    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement loginNameTextField;

    private WebElement password;

    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement loginButton;

    @FindBy(css = "header .nav>li")
    private List<WebElement> headerSectionTitles;

    @FindBy(css = ".uui-main-container .icons-benefit")
    private List<WebElement> greenPictures;

    @FindBy(css = ".uui-main-container .benefit-txt")
    private List<WebElement> captionsUnderGreenPictures;

    @FindBy(css = "h3.text-center a")
    private WebElement textBelowCenter;

    @FindBy(name = "main-title")
    private WebElement epamWishes;

    @FindBy(name = "jdi-text")
    private WebElement loremIpsum;

    @FindBy(id = "iframe")
    private WebElement frame;

    @FindBy(id = "epam_logo")
    private WebElement epamLogo;

    @FindBy (className = "uui-side-bar")
    private WebElement leftSection;

    @FindBy (className = "footer-bg")
    private WebElement footer;

    public HomePage(WebDriver driver) {
        super(driver);
    }



    public void login(String userName, String password) {
        userIcon.click();
        loginNameTextField.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public List<WebElement> getHeaderSectionTitles() {
        return headerSectionTitles;
    }

    public List<WebElement> getCenterSectionTitles() {
        return new ArrayList<WebElement>(Arrays.asList(epamWishes, loremIpsum));
    }

    public List<WebElement> getGreenPictures(){
        return greenPictures;
    }

    public List<WebElement> getCaptionsUnderGreenPictures(){
        return captionsUnderGreenPictures;
    }

    public WebElement getTextBelowCenter(){
        return textBelowCenter;
    }

    public WebElement getFrame(){
        return frame;
    }

    public void switchToFrame(){
        driver.switchTo().frame(frame);
    }

    public void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }

    public WebElement getEpamLogo(){
        return epamLogo;
    }

    public WebElement getLeftSection(){
        return leftSection;
    }

    public WebElement getFooter(){
        return footer;
    }

}
