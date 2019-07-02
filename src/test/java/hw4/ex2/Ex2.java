package hw4.ex2;

import com.codeborne.selenide.SelenideElement;
import hw4.BaseTest4;
import hw4.InputData;
import hw4.InputDataProvider;
import hw4.enums.values_for_data_input.Colors;
import hw4.enums.values_for_data_input.Elements;
import hw4.enums.values_for_data_input.Metals;
import hw4.enums.values_for_data_input.Vegetables;
import hw4.pages.MetalsAndColorsPage;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Condition.text;

public class Ex2 extends BaseTest4 {

    @Test(dataProviderClass = InputDataProvider.class, dataProvider = "inputData")
    public void Ex1HW4Test(InputData input) {
        //1 - 3
        checkLogin();

        //4.	Click on the link on the Header section	Metals & Colors
        hp.clickMetalsAndColorsTitle();
        MetalsAndColorsPage mcp = new MetalsAndColorsPage();

        //5. - omitted
        //6. Fill form on the page

        Colors colors = input.getColors();
        List<Elements> elements = input.getElements();
        Metals metals = input.getMetals();
        List<Integer> summary = input.getSummary();
        List<Vegetables> vegetables = input.getVegetables();

        if (colors != null) {
            mcp.getcolorDropdownButton().click();
            mcp.getColorDropdown(colors.getText()).click();

        }

        if (elements != null) {
            for (Elements element : elements) {
                mcp.getElementsCheckList(element.getText()).click();
            }
        }

        if (metals != null) {
            mcp.getMetalsDropdownButton().click();
            mcp.getMetalsDropdown(metals.getText()).click();
        }

        if (summary != null) {
            for (Integer number : summary) {
                SelenideElement getNumber = (number % 2 == 0) ?
                        mcp.getEvenNumber(number) : mcp.getOddNumber(number);
                getNumber.click();
            }
        }

        if (vegetables != null) {
            mcp.getVegetablesButton().click();
            mcp.getVegetablesCheckList("Vegetables").click();
            for (Vegetables veg : vegetables) {
                mcp.getVegetablesCheckList(veg.getText()).click();
            }
        }

        //7.	Click “Submit” button
        mcp.getSubmitButton().click();


        //8.	Check Results block output on the right-side
        //Очень хочется здесь оптимизировать, но как это сделать, я не знаю

        String key;

        if (colors != null) {
            key = "Color";
            mcp.getResultLine(key).shouldHave(text(colors.getText()));
        }

        if (elements != null) {
            key = "Elements";
            for (Elements element : elements) {
                mcp.getResultLine(key).shouldHave(text(element.getText()));
            }
        }

        if (metals != null) {
            key = "Metal";
            mcp.getResultLine(key).shouldHave(text(metals.getText()));
        }

        if (summary != null) {
            key = "Summary";
            Integer intValue = 0;

            for (Integer number : summary) {
                intValue += number;
            }
            mcp.getResultLine(key).shouldHave(text(intValue.toString()));
        }

        if (vegetables != null) {
            key = "Vegetables";

            for (Vegetables veg : vegetables) {
                mcp.getResultLine(key).shouldHave(text(veg.getText()));
            }

        }
    }
}
