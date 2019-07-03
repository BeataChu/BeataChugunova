package hw4.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public abstract class BasePage4 {

    @FindBy(id = "user-icon")
    private SelenideElement userIcon;

    @FindBy(id = "name")
    private SelenideElement loginNameTextField;

    @FindBy(xpath = "//button[@id='login-button']")
    private SelenideElement loginButton;

    @FindBy(css = "head>title")
    private SelenideElement pageTitle;

    public void login(String userName, String password) {
        userIcon.click();
        loginNameTextField.sendKeys(userName);
        $("#password").sendKeys(password);
        loginButton.click();
    }

    public SelenideElement getPageTitle() {
        return pageTitle;
    }

    public SelenideElement getDisplayedUserName() {
        return $("#user-name");
    }

    public void clickServiceHeaderTitle() {
        $(".uui-header .m-l8 .dropdown-toggle").click();
    }

    public void clickMetalsAndColorsTitle() {
        $(byXpath("//header//a[text() = 'Metals & Colors']")).click();

    }

    // TODO Why do you return List<SelenideElements> instead of ElementsCollection???
    public List<SelenideElement> getServiceHeaderSectionItems() {
        return $$(".uui-header .m-l8 .dropdown-menu a");
    }

    public void clickServiceLeftTitle() {
        $(By.xpath("//ul[@class = 'sidebar-menu']//*[text() = 'Service']")).click();
    }

    // TODO Why do you return List<SelenideElements> instead of ElementsCollection???
    public List<SelenideElement> getServiceLeftSectionItems() {
        return $$(By.xpath("//li[@class='menu-title' and contains(.//span,'Service')]//li//span"));
    }

    public void clickHeaderTableWithPages() {
        $(byXpath("//header//a[text()='Table with pages']")).click();
    }

}
