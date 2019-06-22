package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;

public class BaseTest {
    Calculator calculator;

    @DataProvider
    public static Object[][] arithmeticData() {
        return new Integer[][]{{10, 1}, {3, -6}, {1, 2}, {-4000, 2}, {6, 3}};
    }

    @BeforeMethod
    public void beforeMethod() {
        calculator = new Calculator();
    }
}
