package hw6.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import hw6.entities.TestContext;
import hw6.page_objects.DifferentPage6;
import hw6.page_objects.HomePage6;
import hw6.page_objects.UserTablePage6;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CucumberHooks {

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        TestContext.setDriver(driver);
    }

    @After
    public void closeDriver() {
        HomePage6.wipeInstance();
        DifferentPage6.wipeInstance();
        UserTablePage6.wipeInstance();
        TestContext.setActualPage(null);
        TestContext.getDriver().close();


    }


}
