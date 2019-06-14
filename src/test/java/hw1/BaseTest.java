package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;

public class BaseTest {
    Calculator calculator;
    // TODO extra semi column - fixed (B.C.)

    // TODO Why do you decide use this set of data? - Fixed (Skype)
    @DataProvider
    public static Object[][] arithmeticData() {
        return new Integer[][]{{10, 1}, {3, -6}, {1, 2}, {-4000, 2}, {6, 3}};
    }

    // TODO It is better to use @BeforeMethod - fixed (B.C.)
    @BeforeMethod
    public void beforeMethod() {
        calculator = new Calculator();
    }
}
