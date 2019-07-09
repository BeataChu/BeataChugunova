package hw6.pageObjects;

import hw6.enums.Location;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage6 extends BasePage6 {
    private static HomePage6 instance;

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement loginNameTextField;

    private WebElement password;

    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement loginButton;

    @FindBy(css = ".uui-main-container .icons-benefit")
    private List<WebElement> greenPictures;

    @FindBy(css = ".uui-main-container .benefit-txt")
    private List<WebElement> captionsUnderGreenPictures;

    @FindBy(xpath = "//*[@name = 'main-title' or @name = 'jdi-text']")
    private List<WebElement> subheaders;

    public static HomePage6 getInstance() {
        if (instance == null) {
            instance = new HomePage6();
        }
        return instance;
    }

    public void userIconClick() {
        userIcon.click();
    }

    public void fillLoginTextField(String username) {
        loginNameTextField.sendKeys(username);
    }

    public void fillPasswordTextField(String password) {
        this.password.sendKeys(password);
    }

    public void loginButtonClick() {
        loginButton.click();
    }

    public List<WebElement> getSectionItems(Location location) {
        switch (location) {
            case GREEN_PICTURES:
                return greenPictures;
            case UNDER_GREEN_PICTURES:
                return captionsUnderGreenPictures;
            case CENTER:
                return subheaders;

            default:
                return null;
        }
    }


}
