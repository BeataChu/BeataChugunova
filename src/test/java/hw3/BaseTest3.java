package hw3;

import hw3.steps.HomePageSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class BaseTest3 {

    protected WebDriver driver;
    protected HomePageSteps homePageSteps;
    protected Properties userInfo;

    @BeforeSuite
    public void setUpDriverPath() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //1. Open test site by URL
        driver.get("https://epam.github.io/JDI");
        homePageSteps = new HomePageSteps(driver);
        userInfo = FileUtils.readUserFromFile("src/test/resources/properties/user.properties");
    }

    public void checkLogin() {

        //    2. Assert Browser title
        homePageSteps.pageNameIsCorrect("Home Page");

        //    3. Perform login
        homePageSteps.login(userInfo.getProperty("user.name"), userInfo.getProperty("user.password"));

        //    4. Assert User name in the left-top side of screen that user is logged in -
        assertTrue(homePageSteps.getLoggedUserName().equalsIgnoreCase(userInfo.getProperty("user.user.name")));
    }

    public List<String> toStringList(Object[] s) {
        List<String> result = new ArrayList<String>();
        for (Object obj : s) {
            result.add(obj.toString());
        }
        return result;
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
