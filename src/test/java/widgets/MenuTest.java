package widgets;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Pages;
import pages.widgets.MenuPage;
import testbase.TestBase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MenuTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(MenuTest.class);

    @Test
    @Tag("widgets")
    @Tag("regression")
    void clickOnMainMenu() {

        driver.get(Pages.MENU_WIDGETS_SELENIUM_UI);
        logger.info("Została otworzona strona: " + Pages.MENU_WIDGETS_SELENIUM_UI);

        MenuPage menuPage = new MenuPage(driver);

        WebElement music = menuPage.clickOnMainCategory(driver, "Music");
        logger.info("Selected menu item: " + music.getText());
        WebElement jazz = menuPage.clickOnAdditionalCategory(driver, music, "Jazz");
        logger.info("Selected menu item: " + jazz.getText());
        WebElement modern = menuPage.clickOnAdditionalCategory(driver, jazz, "Modern");
        logger.info("Selected menu item: " + modern.getText());


        logger.info("Selected menu item: " + modern.getText() + " | Expected menu item: Modern");
        assertThat(modern.getText()).isEqualTo("Modern");
    }
}
