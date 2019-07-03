package hw4.pages;

// TODO Unused imports - fixed

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MetalsAndColorsPage extends BasePage4 {

    public MetalsAndColorsPage() {
        Selenide.page(this);
    }

    public SelenideElement getColorDropdown(String color) {
        return $$("#colors .dropdown-menu span").findBy(text(color));
    }

    public SelenideElement getcolorDropdownButton() {
        return $("#colors");
    }

    public SelenideElement getElementsCheckList(String element) {
        return $$("#elements-checklist .checkbox").findBy(text(element));

    }

    public SelenideElement getMetalsDropdownButton() {
        return $("#metals .caret");
    }

    public SelenideElement getMetalsDropdown(String metal) {
        return $$("#metals .dropdown-menu span").findBy(text(metal));
    }

    public void selectNumbers() {

    }

    public SelenideElement getOddNumber(Integer number) {
        return $$("#odds-selector p").findBy(text(number.toString()));
    }

    public SelenideElement getEvenNumber(Integer number) {
        return $$("#even-selector p").findBy(text(number.toString()));
    }

    public SelenideElement getVegetablesButton() {
        return $("#vegetables .caret");
    }

    public SelenideElement getVegetablesCheckList(String veg) {
        return $$("#vegetables .dropdown-menu li").findBy(text(veg));
    }

    public SelenideElement getSubmitButton() {
        return $("#submit-button");
    }

    public SelenideElement getResultLine(String key) {
        return $$(".panel-body-list.results li").findBy(text(key));
    }


}
