package hw6.pageObjects;

import hw6.entities.TestContext;
import hw6.enums.Location;
import hw6.enums.ServiceSectionItems;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

import static hw6.enums.Location.HEADER_SECTION;


public abstract class BasePage6 {

    @FindBy(css = ".uui-header .m-l8 .dropdown-toggle")
    protected WebElement headerServiceTitle;

    @FindBy(xpath = "//ul[@class = 'sidebar-menu']//*[text() = 'Service']")
    protected WebElement leftServiceTitle;

    @FindBy(css = ".uui-header .m-l8 .dropdown-menu a")
    protected List<WebElement> serviceHeaderSectionItems;


    @FindBy(xpath = "//li[@class='menu-title' and contains(.//span,'Service')]//li//span")
    protected List<WebElement> serviceLeftSectionItems;

    @FindBy(name = "navigation-sidebar")
    protected WebElement leftSection;

    @FindBy(xpath = "//a[contains(string(),'Different elements')]")
    private WebElement differentElements;

    @FindBy(xpath = "//a[contains(string(),'User Table')]")
    private WebElement userTable;

    public BasePage6() {
        PageFactory.initElements(TestContext.getDriver(), this);
    }

    public WebElement getServiceMenuTitle(Location location) {
        return location.equals(HEADER_SECTION) ? headerServiceTitle : leftServiceTitle;
    }


    public List<WebElement> getServiceDropdownMenu(Location location) {

        return location.equals(HEADER_SECTION) ? serviceHeaderSectionItems : serviceLeftSectionItems;
    }

    public WebElement getHeaderServiceMenuItem(ServiceSectionItems menuItem) {
        switch (menuItem) {
            case DIFFERENT_ELEMENTS:
                return differentElements;
            case USER_TABLE:
                return userTable;
        }
        throw new NoSuchElementException();
    }

    public abstract List<WebElement> getSectionItems(Location location);


}
