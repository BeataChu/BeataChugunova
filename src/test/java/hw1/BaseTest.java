package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;

public class BaseTest {
    Calculator calculator;
    // TODO extra semi column
    ;

    // TODO Why do you decide use this set of data?
    @DataProvider
    public static Object[][] arithmeticData() {
        return new Object[][]{{10, 1}, {3, -6}, {1, 2}, {-4000, 2}, {3, 6}};
    }

    // TODO It is better to use @BeforeMethod
    @BeforeClass
    public void beforeClass() {
        calculator = new Calculator();
    }
}
