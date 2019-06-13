package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Addition extends BaseTest{

    @Test (dataProvider = "arithmeticData")
    public void additionTest(int num1, int num2) {
       assertEquals(calculator.sum(num1, num2), num1 + num2);
    }

}
