package hw6.entities;

import hw6.pageObjects.BasePage6;
import org.openqa.selenium.WebDriver;

public class TestContext {

    private static WebDriver driver;

    private static BasePage6 actualPage;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        TestContext.driver = driver;
    }

    public static BasePage6 getActualPage() {
        return actualPage;
    }

    public static void setActualPage(BasePage6 basePage6) {
        actualPage = basePage6;
    }

//    public static void setPageNull(){
//        actualPage = null;
//    }
}

