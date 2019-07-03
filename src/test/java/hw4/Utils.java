package hw4;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<String> toStringList(Object[] s) {
        List<String> result = new ArrayList<String>();
        for (Object obj : s) {
            result.add(obj.toString());
        }
        return result;
    }

    public static List<String> allTextsAreInSection(List<SelenideElement> elements, List<String> expectedList) {
        // TODO Method looks a bit tricky
        // TODO You try make some checks here
        List<String> actualList = new ArrayList<>();
        for (
                SelenideElement element : elements) {
            String itemText = element.getText().toUpperCase().trim();
            if (expectedList.contains(itemText)) {
                actualList.add(itemText);
            }
        }
        return actualList;
    }
}
