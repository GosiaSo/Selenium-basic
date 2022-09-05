package widgets;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testbase.Pages;
import testbase.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

public class SliderTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(SliderTest.class);

    @ParameterizedTest
    @ValueSource(ints = {50})
    @Tag("widgets")
    @Tag("slider")
    void checkCorrectValueAfterShiftSlider50(int value) {
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

    @ParameterizedTest
    @ValueSource(ints = {80})
    @Tag("widgets")
    @Tag("slider")
    void checkCorrectValueAfterShiftSlider80(int value) {
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

    @ParameterizedTest
    @ValueSource(ints = {20})
    @Tag("widgets")
    @Tag("slider")
    void checkCorrectValueAfterShiftSlider20(int value) {
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

    @ParameterizedTest
    @ValueSource(ints = {0})
    @Tag("widgets")
    @Tag("slider")
    void checkCorrectValueAfterShiftSlider0(int value) {
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
