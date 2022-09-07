package pages.tables;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class TablePage {

    public TablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "tbody tr")
    public List<WebElement> allMountains;

    public List<RowPage> getMountains() {
        List<RowPage> mountains = new ArrayList<>();

        for (WebElement mountain : allMountains) {
            mountains.add(new RowPage(mountain));
        }
        return mountains;
    }
}
