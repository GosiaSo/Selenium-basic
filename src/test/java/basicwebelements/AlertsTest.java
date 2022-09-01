package basicwebelements;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testbase.Pages;
import testbase.TestBase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AlertsTest extends TestBase {
    private static final Logger loger = LoggerFactory.getLogger(AlertsTest.class);

    @Test
    @Tag("alert")
    void checkTextOnSimpleAlertButton() {
        driver.get(Pages.SELENIUM_UI);
        loger.info("Została otworzona strona: " + Pages.SELENIUM_UI);

        WebElement simpleAlertButton = driver.findElement(By.cssSelector("button#simple-alert"));
        simpleAlertButton.click();
        driver.switchTo().alert().accept();
        String text = driver.findElement(By.cssSelector("#simple-alert-label")).getText();
        String expectedText = "OK button pressed";

        assertThat(text).isEqualTo(expectedText);
        loger.info("Tekst na stronie: " + text + " | Tekst oczekiwany: " + expectedText);
    }

    @Test
    @Tag("alert")
    void checkTextOnPromptAlertBox(){
        driver.get(Pages.SELENIUM_UI);
        loger.info("Została otworzona strona: " + Pages.SELENIUM_UI);

        WebElement promptAlertButton = driver.findElement(By.cssSelector("button#prompt-alert"));
        promptAlertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Lord Vader");
        alert.accept();
        String text = driver.findElement(By.cssSelector("p#prompt-label")).getText();
        String expectedText = "Hello Lord Vader! How are you today?";

        assertThat(text).isEqualTo(expectedText);
        loger.info("Tekst na stronie: " + text + " | Tekst oczekiwany: " + expectedText);
    }

    @Test
    @Tag("confirm")
    void checkCancelationText(){
        driver.get(Pages.SELENIUM_UI);
        loger.info("Została otworzona strona: " + Pages.SELENIUM_UI);

        WebElement confirmPopupButton = driver.findElement(By.cssSelector("button#confirm-alert"));
        confirmPopupButton.click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        confirmPopupButton.click();
        driver.switchTo().alert().dismiss();
        String text = driver.findElement(By.cssSelector("p#confirm-label")).getText();
        String expectedText = "You pressed Cancel!";

        assertThat(text).isEqualTo(expectedText);
        loger.info("Tekst na stronie: " + text + " | Tekst oczekiwany: " + expectedText);
    }

    //TODO
    void checkDelayedButtonText(){

    }
}
