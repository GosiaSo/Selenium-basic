package pages.interactions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class SelectablePage extends BasePage {

    public SelectablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#selectable li")
    private List<WebElement> allItems;

    @FindBy(css = "#feedback span")
    private WebElement feedback;

    @FindBy(css = "#select-result")
    private WebElement selectResult;

    public String printSelectedItems(List<String> selectedItems) {
        StringBuilder sb = new StringBuilder();
        actions.keyDown(Keys.CONTROL).perform();
        for (WebElement allItem : allItems) {
            if (selectedItems.contains(allItem.getText())) {
                allItem.click();
            }
        }
        actions.release();
        return sb.append(feedback.getText()).append(selectResult.getText()).toString();
    }
}
