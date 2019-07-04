package hw4.ex1;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw3.enums.ServiceSectionItems;
import hw4.BaseTest4;
import hw4.DataEnums;
import hw4.pages.TableWithPagesPage;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertTrue;

public class Ex1 extends BaseTest4 {
    @Test
    public void Ex1HW4Test() {
        //1 - 3
        checkLogin();

        //4. Assert User name in the left-top side of screen that user is logged in
        $("#user-name").shouldHave(text(userInfo.getProperty("user.user.name")));

        //5. Click on "Service" subcategory in the header and check that drop down contains options
        List<String> expectedList = new ArrayList<>();
        ServiceSectionItems[] itemTexts = ServiceSectionItems.values();
        for (ServiceSectionItems text : itemTexts) {
            expectedList.add(text.toString());
        }

        // TODO Methods looks a bit tricky :) - fixed
        hp.clickServiceHeaderTitle();
        ElementsCollection actualItemsList = hp.getServiceHeaderSectionItems();
        List<String> itemsTexts = new ArrayList<>();
        for (SelenideElement element : actualItemsList){
            itemsTexts.add(element.getText().toUpperCase());
        }
        assertTrue(itemsTexts.containsAll(expectedList));


        //6. Click on Service subcategory in the left section and check that drop down contains options
        // TODO Methods looks a bit tricky :) - fixed
        hp.clickServiceLeftTitle();
        actualItemsList = hp.getServiceLeftSectionItems();
        itemsTexts = new ArrayList<>();
        for (SelenideElement element : actualItemsList){
            itemsTexts.add(element.getText().toUpperCase());
        }
        assertTrue(itemsTexts.containsAll(expectedList));

         //7. Open through the header menu Service -> Table with pages
        hp.clickServiceHeaderTitle();
        hp.clickHeaderTableWithPages();

        TableWithPagesPage tp = new TableWithPagesPage();

        //8. Check that default value for “Show entries” dropdown is 5
        tp.dropdownForNumberOfEntries().shouldHave(text(DataEnums.DEFAULT_NUMBER_OF_ENTRIES.getText()));

        //9. Assert that there is Right Section
        // TODO What is the purpose of the current method invocation? - fixed
        tp.logSection().shouldBe(visible);

        //10. Assert that there is Left Section
        // TODO What is the purpose of the current method invocation? - fixed
        tp.leftSection().shouldBe(visible);

        //11. Select new value for the entries in the dropdown list - 10
        tp.dropdownForNumberOfEntries().selectOption(DataEnums.NUMBER_OF_ENTRIES_TO_SHOW.getText());
        tp.dropdownForNumberOfEntries().getSelectedOption().shouldHave(text(DataEnums.NUMBER_OF_ENTRIES_TO_SHOW.getText()));

        //12. Assert that for the dropdown there is an individual log row and value is corresponded to the value of dropdown.
        tp.getSecondLineOfTheLog().shouldHave(text(DataEnums.NUMBER_OF_ENTRIES_TO_SHOW.getText()));

        //13. Assert that in the table displayed corrected amount of entries
        // TODO What is the purpose of the current method invocation? - fixed
        $$(tp.getNumberOfEntriesDisplayed()).shouldHaveSize(10);

        //14. Type in “Search” text field - Custom
        tp.searchInput().sendKeys(DataEnums.TEXT_FOR_SEARCH.getText());

        //15. Assert the table contains only records with Search field value
        for (SelenideElement element : tp.getNumberOfEntriesDisplayed()) {
            element.shouldHave(text(DataEnums.TEXT_FOR_SEARCH.getText()));
        }


    }
}