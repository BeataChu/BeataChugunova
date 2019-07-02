package hw4;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import hw3.FileUtils;
import hw4.pages.HomePage4;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest4 {

    protected Properties userInfo;
    protected HomePage4 hp;


    @BeforeMethod
    public void setUp() {
        Configuration.startMaximized = true;
        userInfo = FileUtils.readUserFromFile("src/test/resources/properties/user.properties");

    }

    public void checkLogin() {

        //1. Open test site by URL
        hp = open(DataEnums.HOME_PAGE_URL.getText(), HomePage4.class);

        //2. Assert Browser title
        hp.getPageTitle().shouldHave(attribute("text", DataEnums.HOME_PAGE_TITLE.getText()));

        //3. Perform login

        hp.login(userInfo.getProperty("user.name"), userInfo.getProperty("user.password"));
    }

    @AfterMethod
    public void tearDown() {
        Selenide.close();
    }
}
