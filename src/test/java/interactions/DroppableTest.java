package interactions;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Pages;
import pages.interactions.DroppablePage;
import testbase.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

public class DroppableTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(DroppableTest.class);

    @Test
    @Tag("interactions")
    @Tag("droppable")
    @Tag("regression")
    void dragSquareToTarget() {
        driver.get(Pages.DROPPABLE_INTERACTIONS_SELENIUM_UI);
        logger.info("Została otworzona strona: " + Pages.DROPPABLE_INTERACTIONS_SELENIUM_UI);

        DroppablePage page = new DroppablePage(driver);
        page.dragSquareToTarget(driver);
        String textFromTargetSquare = page.getTExtFromTargetSquare();

        logger.info("Tekst na stronie: " + textFromTargetSquare + " | Tekst oczekiwany: Dropped!");
        assertThat(textFromTargetSquare).isEqualTo("Dropped!");
    }
}
