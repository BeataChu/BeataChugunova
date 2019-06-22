package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {

    // TODO Why these fields are public?
    public Utilities utilities;
    public WebDriver driver;

    @BeforeSuite
    public void setUpDriverPath() {
        // TODO For the HW2 I ask you do not use WebDriverManager
        WebDriverManager.chromedriver().setup();

        // TODO Why driver initialization located in the BeforeSuite?
        driver = new ChromeDriver();
        utilities = new Utilities(driver);
        driver.manage().window().maximize();
    }

    // TODO Why this method has @Test annotation?
    // TODO Are you sure that this test will be running before all others?
    @Test
    public void openPageAndLoginTest() {
        //    1. Open test site by Url
        driver.get("https://epam.github.io/JDI");

        //    2. Assert Browser title
        utilities.pageTitleIsCorrect("Home Page");

        //    3. Perform login
        utilities.login("epam", "1234");

        //    4. Assert User name in the left-top side of screen that user is logged in

        utilities.userIsLoggedIn(LocatorType.ID, "user-name", "PITER CHAILOVSKII");

    }

    @AfterSuite
    //1.17 and 2.19 Close browser
    // TODO Why close in AfterSuites?
    public void tearDown() {
        driver.close();
    }
}
