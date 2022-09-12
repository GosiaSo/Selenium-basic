package basicwebelements;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Pages;
import testbase.TestBase;

import java.util.List;
import java.util.Random;

public class IframeTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(IframeTest.class);

    @Test
    @Tag("iframe")
    @Tag("regression")
    void checkTextOnSimpleAlertButton() {
        driver.get(Pages.IFRAME_SELENIUM_UI);
        logger.info("Została otworzona strona: " + Pages.IFRAME_SELENIUM_UI);

//        WebElement iframe1 = driver.findElement(By.cssSelector("iframe[name=iframe1]"));
        driver.switchTo().frame("iframe1");
        WebElement firstNameInput = driver.findElement(By.cssSelector("#inputFirstName3"));
        firstNameInput.sendKeys("Gosia");
        WebElement lastNameInput = driver.findElement(By.cssSelector("#inputSurname3"));
        lastNameInput.sendKeys("So");

        driver.switchTo().defaultContent();
        driver.switchTo().frame("iframe2");

        driver.findElement(By.cssSelector("#inputLogin")).sendKeys("loginnnn");
        driver.findElement(By.cssSelector("#inputPassword")).sendKeys("hasełko");

        WebElement dropdown = driver.findElement(By.cssSelector("#inlineFormCustomSelectPref"));
        dropdown.click();

        List<WebElement> continentOptions = driver.findElements(By.cssSelector("option"));
        Random rand = new Random();
        int list= rand.nextInt(continentOptions.size());
        continentOptions.get(list).click();

        List<WebElement> yearOfExperienceOptions = driver.findElements(By.cssSelector(".form-check"));
        driver.switchTo().defaultContent();

        WebElement basicMenu = driver.findElement(By.cssSelector("li[class=\"nav-ite dropdown\"]"));
        basicMenu.click();
    }
}
