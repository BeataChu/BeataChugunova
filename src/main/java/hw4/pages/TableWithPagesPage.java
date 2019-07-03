package hw4.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TableWithPagesPage {

    public TableWithPagesPage() {
        Selenide.page(this);
    }

    public SelenideElement dropdownForNumberOfEntries(){
        return $(".dataTables_length select");
    }




    public SelenideElement logSection(){
        return $(byName("log-sidebar"));
    }

    public SelenideElement leftSection(){
        return $(byName("navigation-sidebar"));
    }

    public SelenideElement getSecondLineOfTheLog(){
        return $(".panel-body-list.logs>li:nth-child(2)");
    }

    // TODO Why do you return List<SelenideElements> instead of ElementsCollection???
    public List<SelenideElement> getNumberOfEntriesDisplayed(){
        return $$("#table-with-pages > tbody>tr");
    }

    public SelenideElement searchInput(){
        return $("#table-with-pages_filter input");
    }
}
