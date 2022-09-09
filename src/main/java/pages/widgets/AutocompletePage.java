package pages.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

public class AutocompletePage {

    private static final Logger logger = LoggerFactory.getLogger(AutocompletePage.class);

    public AutocompletePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#search")
    private WebElement input;

    @FindBy(css = "#ui-id-1 li")
    private List<WebElement> availableOptions;


    @FindBy(css = "div[role=\"status\"] :last-child")
    private WebElement selectedOption;

    public void typeInInput(String text) {
        input.sendKeys(text);
    }

    public void printOutAllOptions() {
        for (WebElement availableOption : availableOptions) {
            logger.info(availableOption.getText());
        }
    }

    public void selectRandomOption() {
        Random rand = new Random();
        int randomOption = rand.nextInt(availableOptions.size());
        availableOptions.get(randomOption).click();
    }

    public String getTextFromSelectedOption() {
        return selectedOption.getText();
    }
}
