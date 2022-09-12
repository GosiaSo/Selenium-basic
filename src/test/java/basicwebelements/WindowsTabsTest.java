package basicwebelements;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Pages;
import pages.tables.TablePage;
import testbase.TestBase;

import java.util.List;

public class WindowsTabsTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(WindowsTabsTest.class);

    @Test
    @Tag("windows")
    @Tag("tabs")
    @Tag("regression")
    void openNewWindowsAndTabs() {

        driver.get(Pages.WINDOWS_SELENIUM_UI);
        logger.info("Została otworzona strona: " + Pages.WINDOWS_SELENIUM_UI);

        final String firstOpenedWindow = driver.getWindowHandle();

        openNewWindowWithTable(firstOpenedWindow, "#newBrowserWindow");
        printNewMessageWindow(firstOpenedWindow);
        openNewWindowWithTable(firstOpenedWindow, "#newBrowserTab");
    }

    private void openNewWindowWithTable(String firstOpenedWindow, String selector) {
        driver.findElement(By.cssSelector(selector)).click();

        switchWindow(firstOpenedWindow);

        logger.info("Została otworzona strona w nowym oknie: " + driver.getCurrentUrl());
        // TODO
        // dlaczego nie mogę wywołac tablesTest.printInfoAboutMountains() i w Table Page @findby-allMountains jest nullem
        TablesTest tablesTest = new TablesTest();
        TablePage tablePage = new TablePage(driver);
        List<TablesTest.Mountain> filteredMountains = tablesTest.filterMountains(tablePage, 4000);
        tablesTest.printInfo(filteredMountains);
        driver.close();

        driver.switchTo().window(firstOpenedWindow);
    }

    private void printNewMessageWindow(String firstOpenedWindow) {
        driver.findElement(By.cssSelector("#newMessageWindow")).click();
        switchWindow(firstOpenedWindow);

        logger.info("Zostało otworzone nowe okno.");
        logger.info(driver.findElement(By.cssSelector("body")).getText());
        driver.close();

        driver.switchTo().window(firstOpenedWindow);
    }

    private void switchWindow(String firstOpenedWindow) {
        for (String windowHandle : driver.getWindowHandles()) {
            if (!firstOpenedWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
