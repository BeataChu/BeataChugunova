package hw4;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

import static hw4.enums.valuesForInputData.Colors.*;
import static hw4.enums.valuesForInputData.Elements.*;
import static hw4.enums.valuesForInputData.Metals.*;
import static hw4.enums.valuesForInputData.Vegetables.*;

public class InputDataProvider {

    @DataProvider(name = "inputData")
    public static Object[][] builder() {
        return new Object[][]{
                {InputData.getBuilder()
                        .setColors(YELLOW)
                        .setElements(Arrays.asList(EARTH))
                        .setMetals(GOLD)
                        .build()},
                {InputData.getBuilder()
                        .setSummary(Arrays.asList(3, 8))
                        .setVegetables(Arrays.asList(CUCUMBER, TOMATO))
                        .build()},
                {InputData.getBuilder()
                        .setElements(Arrays.asList(WIND, FIRE, WATER))
                        .setMetals(BRONZE)
                        .setSummary(Arrays.asList(3, 2))
                        .setVegetables(Arrays.asList(ONION))
                        .build()},
                {InputData.getBuilder()
                        .setColors(GREEN)
                        .setElements(Arrays.asList(WATER))
                        .setMetals(SELEN)
                        .setSummary(Arrays.asList(6, 5))
                        .setVegetables(Arrays.asList(CUCUMBER, TOMATO, VEGETABLES, ONION))
                        .build()},
                {InputData.getBuilder()
                        .setColors(BLUE)
                        .setElements(Arrays.asList(FIRE))
                        .setVegetables(Arrays.asList(CUCUMBER, TOMATO, VEGETABLES))
                        .build()}

        };
    }
}





