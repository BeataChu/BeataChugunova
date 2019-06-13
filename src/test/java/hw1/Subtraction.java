package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Subtraction extends BaseTest{

    @Test (dataProvider = "arithmeticData")
    public void subtractionTest(int num1, int num2) {
        assertEquals(calculator.sub(num1, num2), num1 - num2);
    }

}
