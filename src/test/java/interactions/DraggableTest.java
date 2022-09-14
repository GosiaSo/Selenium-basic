package interactions;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Pages;
import pages.interactions.DraggablePage;
import testbase.TestBase;
import widgets.SliderTest;

public class DraggableTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(SliderTest.class);

    @Test
    @Tag("interactions")
    @Tag("draggable")
    @Tag("regression")
    void dragSquareTo() {
        driver.get(Pages.DRAGGABLE_INTERACTIONS_SELENIUM_UI);
        logger.info("Została otworzona strona: " + Pages.DRAGGABLE_INTERACTIONS_SELENIUM_UI);

        DraggablePage page = new DraggablePage(driver);
        page.dragElement(driver, 3, 0);
        page.dragElement(driver, 0, 2);
        page.dragElement(driver, -1, -1);
        page.dragElement(driver, -2, 1);
    }
}
