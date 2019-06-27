package hw3.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    @FindBy(id = "user-name")
    private WebElement loggedUserName;

    @FindBy (className = "footer-bg")
    private WebElement footer;

    @FindBy (css = ".uui-header .m-l8 .dropdown-toggle")
    private WebElement serviceHeaderTitle;

    @FindBy (css = ".uui-header .m-l8 .dropdown-menu a")
    private List<WebElement> serviceHeaderSectionItems;

    @FindBy (xpath = "//ul[@class = 'sidebar-menu']//*[text() = 'Service']")
    private WebElement serviceLeftTitle;

    @FindBy (xpath = "//li[@class='menu-title' and contains(.//span,'Service')]//li//span")
    private List<WebElement> serviceLeftSectionItems;

    @FindBy (xpath = "//header//a[text() ='Different elements']")
    private WebElement differentElements;

    @FindBy(css = "header .nav>li")
    private List<WebElement> headerSectionTitles;

    @FindBy (name = "navigation-sidebar")
    private WebElement leftSection;




    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getLoggedUserName(){
        return loggedUserName.getText();
    }

    public WebElement getFooter(){
        return footer;
    }

    public WebElement getServiceHeaderTitle() {
        return serviceHeaderTitle;
    }

    public List<WebElement> getServiceHeaderSectionItems(){
        return serviceHeaderSectionItems;
    }

    public WebElement getServiceLeftTitle() {
        return serviceLeftTitle;
    }

    public List<WebElement> getServiceLeftSectionItems(){
        return serviceLeftSectionItems;
    }

    public WebElement getDifferentElements(){
        return differentElements;
    }

    public List<WebElement> getHeaderSectionTitles() {
        return headerSectionTitles;
    }

    public WebElement getLeftSection(){
        return leftSection;
    }




}

