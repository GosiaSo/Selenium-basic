package widgets;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import pages.Pages;
import pages.widgets.modaldialog.ModalDialogPage;
import testbase.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

public class ModalDialogTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(MenuTest.class);

    //    @Test (dataProvider = "testdatausers")
    @Test
    @Tag("widgets")
    void xxxxxx() {
        driver.get(Pages.MODAL_DIALOG_WIDGETS_SELENIUM_UI);
        logger.info("Została otworzona strona: " + Pages.MODAL_DIALOG_WIDGETS_SELENIUM_UI);

        ModalDialogPage page = new ModalDialogPage(driver);

        page.createNewUser();
        boolean result = page.checkIfNewUserIsCreated(page.getUsers(), new ModalDialogPage.User("Jane Smith", "jane@smith.com", "xxxxxxx"));
        assertThat(result).isEqualTo(Boolean.TRUE);
    }

//    @DataProvider(name = "testdatausers")
//    public Object[][] TestDataFeed() {
//        Object[][] usersdata = new Object[2][3];
//
//        usersdata[0][0] = "Jane Smith";
//        usersdata[0][1] = "jane@smith.com";
//        usersdata[0][3] = "xxxxxxx";
//
//        usersdata[1][0] = "John Doe";
//        usersdata[1][1] = "john.doe@example.com";
//        usersdata[1][3] = "johndoe1";
//
//        return usersdata;
//    }
}
