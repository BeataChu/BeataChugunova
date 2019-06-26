package hw2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.nio.file.Paths;

public class BaseTest2 {

    protected Utilities utilities;
    protected WebDriver driver;

    @BeforeSuite
    public void setUpDriverPath() {
        System.setProperty("webdriver.chrome.driver",
                Paths.get("src/test/resources/driver/chromedriver.exe")
                        .toAbsolutePath().toString());
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        utilities = new Utilities(driver);
        driver.manage().window().maximize();
        //1. Open test site by URL
        driver.get("https://epam.github.io/JDI");
    }

    public void checkLogin() {

        //    2. Assert Browser title
        utilities.pageTitleIsCorrect("Home Page");

        //    3. Perform login
        utilities.login("epam", "1234");

        //    4. Assert User name in the left-top side of screen that user is logged in
        utilities.userIsLoggedIn(LocatorType.ID, "user-name", "PITER CHAILOVSKII");
    }

    @AfterMethod
    //1.17 and 2.19 Close browser
    public void tearDown() {
        driver.close();
    }
}
