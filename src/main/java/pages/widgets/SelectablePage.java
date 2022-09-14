package pages.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class SelectablePage {

    public SelectablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "#speed")
    private WebElement speedSelect;

    @FindBy(css = "#speed option")
    private List<WebElement> speedOptions;

    @FindBy(css = "#files-button")
    private WebElement filesButtonSelect;

    @FindBy(css = "#number")
    private WebElement numberSelect;

    public void selectRandomSpeed() {
        Random rand = new Random();
        int randomOption = rand.nextInt(speedOptions.size());
        speedOptions.get(randomOption).click();
    }

    public void selectFileByText(String value) { //jquery
        Select select = new Select(filesButtonSelect);
        select.selectByValue(value);
    }

    public void selectNumberByIndex(int index){
        Select select = new Select(numberSelect);
        select.selectByIndex(index);
    }
}
