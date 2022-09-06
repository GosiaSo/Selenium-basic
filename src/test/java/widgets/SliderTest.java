package widgets;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Pages;
import testbase.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

public class SliderTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(SliderTest.class);

    @Test
    @Tag("widgets")
    @Tag("slider")
    void checkCorrectValueAfterShiftSlider() {
        moveSlider(50);
        moveSlider(80);
        moveSlider(80);
        moveSlider(20);
        moveSlider(0);
    }

    private void moveSlider(int value) {
        driver.get(Pages.SLIDER_WIDGETS_SELENIUM_UI);
        logger.info("Została otworzona strona: " + Pages.SLIDER_WIDGETS_SELENIUM_UI);

        WebElement handle = driver.findElement(By.cssSelector("#custom-handle"));

        for (int i = 0; i < value; i++) {
            handle.sendKeys(Keys.ARROW_RIGHT);
        }
        logger.info("Slider został przesunięty " + value + " razy.");
        logger.info("Tekst na stronie: " + handle.getText() + " | Tekst oczekiwany: " + value);
        assertThat(Integer.parseInt(handle.getText())).isEqualTo(value);
    }
}
