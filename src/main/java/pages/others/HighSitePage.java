package pages.others;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class HighSitePage {

    public HighSitePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "p.show-button")
    private WebElement submitButton;

    public void scrollToButton(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton);
        actions.perform();

        try {
            takeScreenshot(driver);
        } catch (IOException e) {
            throw new RuntimeException("Failed to take screenshot", e);
        }
    }

    private void takeScreenshot(WebDriver driver) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(".//src/main/resources/screenshots/screenshot.png"));
    }
}
