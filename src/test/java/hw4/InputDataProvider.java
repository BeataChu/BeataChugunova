package hw4;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

import static hw4.enums.values_for_data_input.Colors.*;
import static hw4.enums.values_for_data_input.Elements.*;
import static hw4.enums.values_for_data_input.Metals.*;
import static hw4.enums.values_for_data_input.Vegetables.*;

public class InputDataProvider {

    @DataProvider(name = "inputData")
    public static Object[][] builder() {
        return new Object[][]{
                {InputData.builder()
                        .colors(YELLOW)
                        .elements(Arrays.asList(EARTH))
                        .metals(GOLD)
                        .build()},
                {InputData.builder()
                        .summary(Arrays.asList(3, 8))
                        .vegetables(Arrays.asList(CUCUMBER, TOMATO))
                        .build()},
                {InputData.builder()
                        .elements(Arrays.asList(WIND, FIRE, WATER))
                        .metals(BRONZE)
                        .summary(Arrays.asList(3, 2))
                        .vegetables(Arrays.asList(ONION))
                        .build()},
                {InputData.builder()
                        .colors(GREEN)
                        .elements(Arrays.asList(WATER))
                        .metals(SELEN)
                        .summary(Arrays.asList(6, 5))
                        .vegetables(Arrays.asList(CUCUMBER, TOMATO, VEGETABLES, ONION))
                        .build()},
                {InputData.builder()
                        .colors(BLUE)
                        .elements(Arrays.asList(FIRE))
                        .vegetables(Arrays.asList(CUCUMBER, TOMATO, VEGETABLES))
                        .build()}

        };
    }
}





