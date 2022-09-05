package basicwebelements;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testbase.Pages;
import testbase.TestBase;

import java.util.ArrayList;
import java.util.List;


public class TablesTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(TablesTest.class);

    @Test
    @Tag("tables")
    void printInfoAboutMountains() {
        driver.get(Pages.TABLES_SELENIUM_UI);
        logger.info("Została otworzona strona: " + Pages.TABLES_SELENIUM_UI);

        List<Mountain> filteredMountains = filterMountains(4000);
        printInfo(filteredMountains);
    }

    private List<Mountain> filterMountains(int higherThan) {

        final List<Mountain> filteredMountains = new ArrayList<>();

        int heightColumn = getIndexOfColumn("height");
        int peakColumn = getIndexOfColumn("peak");
        int mountainRangeColumn = getIndexOfColumn("mountain range");

        List<WebElement> heightValuesFromTable = driver.findElements(By.cssSelector("tbody td:nth-child(" + heightColumn + ")"));

        for (int i = 0; i < heightValuesFromTable.size(); i++) {
            String height = heightValuesFromTable.get(i).getText();
            if (Integer.parseInt(height) > higherThan) {
                List<WebElement> peakValuesFromTable = driver.findElements(By.cssSelector("tbody td:nth-child(" + peakColumn + ")"));
                String peak = peakValuesFromTable.get(i).getText();
                List<WebElement> mountainRageValuesFromTable = driver.findElements(By.cssSelector("tbody td:nth-child(" + mountainRangeColumn + ")"));
                String mountainRange = mountainRageValuesFromTable.get(i).getText();
                List<WebElement> rankValuesFromTable = driver.findElements(By.cssSelector("tbody th"));
                int rank = Integer.parseInt(rankValuesFromTable.get(i).getText());

                Mountain mountain = new Mountain();
                mountain.rank = rank;
                mountain.height = Integer.parseInt(height);
                mountain.mountainRage = mountainRange;
                mountain.peak = peak;

                filteredMountains.add(mountain);
            }
        }
        return filteredMountains;
    }

    private int getIndexOfColumn(String columnName) {
        List<WebElement> headers = driver.findElements(By.cssSelector("thead th"));
        for (int i = 0; i < headers.size(); i++) {
            if (headers.get(i).getText().equalsIgnoreCase(columnName)) {
                return i + 1;
            }
        }
        return -1;
    }

    private void printInfo(List<Mountain> mountains) {
        for (Mountain mountain : mountains) {
            System.out.println(mountain.toString());
        }
    }

    static class Mountain {
        private int rank;
        private String peak;
        private String mountainRage;
        private int height;

        @Override
        public String toString() {
            return "Mountain: " +
                    "rank= " + rank +
                    ", peak='" + peak + '\'' +
                    ", mountainRage='" + mountainRage + '\'' +
                    ", height=" + height +
                    '.';
        }
    }
}
