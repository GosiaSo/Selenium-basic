package pages.interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DroppablePage {
    public DroppablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#draggable")
    private WebElement square;

    @FindBy(css = "#droppable")
    private WebElement targetSquare;

    public void dragSquareToTarget(WebDriver driver) {
        Actions action = new Actions(driver);
        action.dragAndDrop(square, targetSquare).perform();
    }

    public String getTExtFromTargetSquare() {
        return targetSquare.getText();
    }
}
