package pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProgressbarPage {

    public ProgressbarPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "#progressbar > div.progress-label")
    private WebElement progressbar;


    public boolean getTextFromCompleteProgressbar(WebDriver driver, String textInProgress) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.textToBe(By.cssSelector("#progressbar > div.progress-label"), textInProgress)) ? Boolean.TRUE : Boolean.FALSE;
    }
}
