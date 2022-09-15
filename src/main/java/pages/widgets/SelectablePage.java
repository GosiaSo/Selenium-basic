package pages.widgets;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;

public class SelectablePage extends BasePage {

    public SelectablePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "#speed-button")
    private WebElement speedSelect;

    @FindBy(css = "#speed-menu li")
    private List<WebElement> speedOptions;

    @FindBy(css = "#files-button")
    private WebElement filesButtonSelect;

    @FindBy(css = "#files-menu li")
    private List<WebElement> filesOptions;

    @FindBy(css = "#number-button")
    private WebElement numberSelect;

    @FindBy(css = "#number-menu li")
    private List<WebElement> numberOptions;

    @FindBy(css = "#salutation-button")
    private WebElement titleSelect;

    @FindBy(css = "#salutation-menu li")
    private List<WebElement> titleOptions;

    public void selectRandomSpeed() {
        speedSelect.click();
        getRandomElement(speedOptions).click();
    }

    public void selectFileByText(String value) {
        //TODO change to Select select
        filesButtonSelect.click();
        for (WebElement filesOption : filesOptions) {
            if(filesOption.getText().equalsIgnoreCase(value)){
                filesOption.click();
                break;
            }
        }
    }

    public void selectNumberByIndex(int index) {
        numberSelect.click();
        for (WebElement filesOption : numberOptions) {
            if(filesOption.getText().equalsIgnoreCase(Integer.toString(index))){
                filesOption.click();
                break;
            }
        }
    }

    public void selectRandomTitle() {
        titleSelect.click();
        getRandomElement(titleOptions).click();
    }
}
