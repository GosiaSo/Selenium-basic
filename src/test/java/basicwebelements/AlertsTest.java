package basicwebelements;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testbase.Pages;
import testbase.TestBase;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AlertsTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(AlertsTest.class);

    @Test
    @Tag("alert")
    @Tag("regression")
    void checkTextOnSimpleAlertButton() {
        driver.get(Pages.ALERTS_SELENIUM_UI);
        logger.info("Została otworzona strona: " + Pages.ALERTS_SELENIUM_UI);

        WebElement simpleAlertButton = driver.findElement(By.cssSelector("button#simple-alert"));
        simpleAlertButton.click();
        driver.switchTo().alert().accept();
        String text = driver.findElement(By.cssSelector("#simple-alert-label")).getText();
        String expectedText = "OK button pressed";

        logger.info("Tekst na stronie: " + text + " | Tekst oczekiwany: " + expectedText);
        assertThat(text).isEqualTo(expectedText);
    }

    @Test
    @Tag("alert")
    void checkTextOnPromptAlertBox() {
        driver.get(Pages.ALERTS_SELENIUM_UI);
        logger.info("Została otworzona strona: " + Pages.ALERTS_SELENIUM_UI);

        WebElement promptAlertButton = driver.findElement(By.cssSelector("button#prompt-alert"));
        promptAlertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Lord Vader");
        alert.accept();
        String text = driver.findElement(By.cssSelector("p#prompt-label")).getText();
        String expectedText = "Hello Lord Vader! How are you today?";

        logger.info("Tekst na stronie: " + text + " | Tekst oczekiwany: " + expectedText);
        assertThat(text).isEqualTo(expectedText);
    }

    @Test
    @Tag("alert")
    void checkCancelationText() {
        driver.get(Pages.ALERTS_SELENIUM_UI);
        logger.info("Została otworzona strona: " + Pages.ALERTS_SELENIUM_UI);

        WebElement confirmPopupButton = driver.findElement(By.cssSelector("button#confirm-alert"));
        confirmPopupButton.click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        confirmPopupButton.click();
        driver.switchTo().alert().dismiss();
        String text = driver.findElement(By.cssSelector("p#confirm-label")).getText();
        String expectedText = "You pressed Cancel!";

        logger.info("Tekst na stronie: " + text + " | Tekst oczekiwany: " + expectedText);
        assertThat(text).isEqualTo(expectedText);
    }

    @Test
    @Tag("alert")
    void checkDelayedButtonText() {
        driver.get(Pages.ALERTS_SELENIUM_UI);
        logger.info("Została otworzona strona: " + Pages.ALERTS_SELENIUM_UI);

        WebElement delayedButton = driver.findElement(By.cssSelector("button#delayed-alert"));
        delayedButton.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
            driver.switchTo().alert().accept();
            String text = driver.findElement(By.cssSelector("#delayed-alert-label")).getText();
            String expectedText = "OK button pressed";
            logger.info("Tekst na stronie: " + text + " | Tekst oczekiwany: " + expectedText);
            assertThat(text).isEqualTo(expectedText);
        } else {
            logger.error("Alert is not present");
        }

    }
}
