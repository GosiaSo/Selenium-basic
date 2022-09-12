package form;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.FormPage;
import pages.Pages;
import testbase.TestBase;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class FormTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(FormTest.class);

    @Test
    @Tag("form")
    @Tag("regression")
    void checkTextAfterSendForm() {
        driver.get(Pages.FORM_SELENIUM_UI);
        logger.info("Została otworzona strona: " + Pages.FORM_SELENIUM_UI);

        FormPage formPage = new FormPage(driver);

        formPage.fillFirstName("Gosia");
        formPage.fillLastName("So");
        formPage.fillEmail("email@gmail.com");
        formPage.chooseRandomSexRadiobutton();
        formPage.fillAge();
        formPage.chooseRandomYearRadiobutton();
        formPage.fillProfession();
        formPage.selectContinent();
        formPage.selectSeleniumCommands(Arrays.asList("Switch Commands", "Wait Commands"), driver);
        String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\samplefiles\\sample.pdf";
        formPage.uploadFile(filePath);
        formPage.signIn();

        String text = formPage.getSuccessText();
        String expectedText = "Form send with success";

        logger.info("Tekst na stronie: " + text + " | Tekst oczekiwany: " + expectedText);
        assertThat(text).isEqualTo(expectedText);
    }
}
