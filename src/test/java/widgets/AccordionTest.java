package widgets;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Pages;
import pages.widgets.AccordionPage;
import testbase.TestBase;

public class AccordionTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(AccordionTest.class);

    @Test
    @Tag("widgets")
    @Tag("regression")
    void printTextInsideEachSection() {
        driver.get(Pages.ACCORDION_WIDGETS_SELENIUM_UI);
        logger.info("Została otworzona strona: " + Pages.ACCORDION_WIDGETS_SELENIUM_UI);

        AccordionPage accordionPage = new AccordionPage(driver);
        System.out.println(accordionPage.getAllSections());
    }
}
