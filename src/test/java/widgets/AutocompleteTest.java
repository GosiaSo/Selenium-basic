package widgets;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Pages;
import pages.widgets.AutocompletePage;
import testbase.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

public class AutocompleteTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(AutocompleteTest.class);

    @Test
    @Tag("widgets")
    @Tag("autocomplete")
    @Tag("regression")
    void checkSelectedOption() {
        driver.get(Pages.AUTOCOMPLETE_WIDGETS_SELENIUM_UI);
        logger.info("Została otworzona strona: " + Pages.AUTOCOMPLETE_WIDGETS_SELENIUM_UI);

        AutocompletePage autocompletePage = new AutocompletePage(driver);

        autocompletePage.typeInInput("a");
        autocompletePage.printOutAllOptions();
        autocompletePage.selectRandomOption();

        String textFromSelectedOption = autocompletePage.getTextFromSelectedOption();

        logger.info("Losowo wybrana opcja: " + textFromSelectedOption + " | Oczekiwany tekst jakiś losowy lel, który wiadomo, że się nie zgadza");
        assertThat(textFromSelectedOption).isEqualTo("losowa opcja");
    }

}
