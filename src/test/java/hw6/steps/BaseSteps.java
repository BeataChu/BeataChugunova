package hw6.steps;

import hw6.entities.TestContext;
import hw6.enums.Labels.BaseLabel;
import hw6.pageObjects.HomePage6;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class BaseSteps {

    public BaseSteps() {
        TestContext.setActualPage(HomePage6.getInstance());
    }

    public WebElement getSpecificItem(BaseLabel label, List<WebElement> elements) {
        for (WebElement element : elements) {
            if (element.getText().toUpperCase().contains(label.toString().toUpperCase())) {
                try {
                    return element.findElement(By.xpath("./*"));
                } catch (Exception e) {
                    return element;
                }
            }
        }
        throw new NoSuchElementException("No such label");
    }


}
