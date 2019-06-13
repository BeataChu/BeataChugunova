package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Multiplication extends BaseTest{

    @Test (dataProvider = "arithmeticData")
    public void multiplicationTest(int num1, int num2) {
        assertEquals(calculator.mult(num1, num2), num1 * num2);
    }

}