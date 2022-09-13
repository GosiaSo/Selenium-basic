package othertests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Pages;
import pages.others.HighSitePage;
import testbase.TestBase;

public class HighSiteTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(HighSiteTest.class);

    @Test
    @Tag("otherstest")
    @Tag("highsite")
    @Tag("regression")
    void xxx() {
        driver.get(Pages.HIGHSITE_SELENIUM_UI);
        logger.info("Została otworzona strona: " + Pages.HIGHSITE_SELENIUM_UI);

        HighSitePage highSitePage = new HighSitePage(driver);
        highSitePage.scrollToButton(driver);
    }
}
