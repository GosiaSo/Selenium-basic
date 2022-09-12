package widgets;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Pages;
import testbase.TestBase;

import java.util.List;

public class TooltipTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(SliderTest.class);

    @Test
    @Tag("widgets")
    @Tag("tooltip")
    @Tag("regression")
    void printMessage() {
        driver.get(Pages.TOOLTIP_WIDGETS_SELENIUM_UI);
        logger.info("Została otworzona strona: " + Pages.TOOLTIP_WIDGETS_SELENIUM_UI);

        List<WebElement> paragraphs = driver.findElements(By.cssSelector("[class=\"content tooltips\"] p"));

        for (WebElement paragraph : paragraphs) {
            if (!paragraph.findElements(By.xpath("./a")).isEmpty()) {
                WebElement infotip = paragraph.findElement(By.xpath("./a"));
                System.out.println(infotip.getAttribute("title"));
            }
        }
    }
}
