package widgets;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Pages;
import pages.widgets.SelectablePage;
import testbase.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectableTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(SelectableTest.class);

    @Test
    @Tag("widgets")
    @Tag("regression")
    void selectOptions() {
        driver.get(Pages.SELECTABLE_WIDGETS_SELENIUM_UI);
        logger.info("Została otworzona strona: " + Pages.SELECTABLE_WIDGETS_SELENIUM_UI);

        SelectablePage selectablePage = new SelectablePage(driver);
        selectablePage.selectRandomSpeed();
        selectablePage.selectFileByText("ui.jQuery.js");
        selectablePage.selectNumberByIndex(3);
        selectablePage.selectRandomTitle();
    }
}
