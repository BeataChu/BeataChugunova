package hw6.entities;

import hw6.pageObjects.BasePage6;
import org.openqa.selenium.WebDriver;

// TODO This class should be in the test scope
public class TestContext {

    private static WebDriver driver;

    private static BasePage6 actualPage;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        TestContext.driver = driver;
    }

    // TODO I think this get is not necessary here you could invoke pages using Page.getInstance()....
    public static BasePage6 getActualPage() {
        return actualPage;
    }

    // TODO I think this set is not necessary here you could invoke pages using Page.getInstance()....
    public static void setActualPage(BasePage6 basePage6) {
        actualPage = basePage6;
    }

//    public static void setPageNull(){
//        actualPage = null;
//    }
}

