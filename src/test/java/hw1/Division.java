package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Division extends BaseTest{

    @Test (dataProvider = "arithmeticData")
    public void divisionTest(int num1, int num2) {
        assertEquals(calculator.div(num1, num2), num1/num2);
    }

}