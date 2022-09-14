package widgets;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Pages;
import pages.widgets.ProgressbarPage;
import testbase.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgressbarTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(ProgressbarTest.class);

    @Test
    @Tag("widgets")
    @Tag("regression")
    void checkTextInProgressbar() {
        driver.get(Pages.PROGRESSBAR_WIDGETS_SELENIUM_UI);
        logger.info("Została otworzona strona: " + Pages.PROGRESSBAR_WIDGETS_SELENIUM_UI);

        ProgressbarPage page = new ProgressbarPage(driver);
        String completeProgressbarText = page.getTextFromCompleteProgressbar(driver, "Complete!");

        logger.info("Tekst na stronie: " + completeProgressbarText + " | Tekst oczekiwany: Complete!");
        assertThat(completeProgressbarText).isEqualTo("Complete!");
    }
}
