package basicwebelements;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Pages;
import pages.tables.RowPage;
import pages.tables.TablePage;
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

        TablePage tablePage = new TablePage(driver);
        List<Mountain> filteredMountains = filterMountains(tablePage, 4000);

        printInfo(filteredMountains);
    }

    List<Mountain> filterMountains(TablePage tablePage, int higherThan) {
        List<Mountain> filteredMountains = new ArrayList<>();

        List<RowPage> tablePageMountains = tablePage.getMountains();
        for (RowPage rowPageMountain : tablePageMountains) {
            if (rowPageMountain.getMountainHeight() > higherThan && rowPageMountain.getMountainState().toLowerCase().contains("switzerland")) {
                Mountain mountain = new Mountain();
                mountain.height = rowPageMountain.getMountainHeight();
                mountain.peak = rowPageMountain.getMountainName();
                mountain.mountainRage = rowPageMountain.getMountainRange();
                mountain.state = rowPageMountain.getMountainState();
                mountain.rank = rowPageMountain.getMountainRank();
                filteredMountains.add(mountain);
            }
        }
        return filteredMountains;
    }

    void printInfo(List<Mountain> mountains) {
        for (Mountain mountain : mountains) {
            logger.info(mountain.toString());
        }
    }

    static class Mountain {
        private int rank;
        private String peak;
        private String mountainRage;
        private String state;
        private int height;

        @Override
        public String toString() {
            return "Mountain: " +
                    "rank= " + rank +
                    ", peak='" + peak + '\'' +
                    ", state='" + state + '\'' +
                    ", mountainRage='" + mountainRage + '\'' +
                    ", height=" + height +
                    '.';
        }
    }
}
