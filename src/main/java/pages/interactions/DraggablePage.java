package pages.interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraggablePage {

    public DraggablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#draggable")
    private WebElement square;

    public void dragElement(WebDriver driver, int x, int y) {
        Actions action = new Actions(driver);
        int locationX = square.getLocation().getX();
        int locationY = square.getLocation().getY();

        action.dragAndDropBy(square, locationX * x, locationY * y).perform();
// tu jakiegoś waita by poczekało byśmy zobaczyli, że to się dzieje w ogóle XD
    }

//    public void dragElementBackToPosition(WebDriver driver, int x, int y) {
//        Actions action = new Actions(driver);
//        action.dragAndDropBy(square, -x, -y).perform();
//    }
}
