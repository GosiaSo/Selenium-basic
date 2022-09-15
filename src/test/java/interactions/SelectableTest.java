package interactions;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Pages;
import pages.interactions.SelectablePage;
import testbase.TestBase;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectableTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(SelectableTest.class);

    @Test
    @Tag("interactions")
    @Tag("regression")
    void checkSelectedITems() {
        driver.get(Pages.SELECTABLE_INTERACTIONS_SELENIUM_UI);
        logger.info("Została otworzona strona: " + Pages.SELECTABLE_INTERACTIONS_SELENIUM_UI);

        SelectablePage page = new SelectablePage(driver);
        List<String> selectedItems = Arrays.asList("Item 1", "Item 3", "Item 4");
        String actualText = page.printSelectedItems(selectedItems);

        logger.info("Tekst na stronie: " + actualText + " | Tekst oczekiwany: You've selected:#1 #3 #4");
        assertThat(actualText).isEqualTo("You've selected:#1 #3 #4");
    }
}
