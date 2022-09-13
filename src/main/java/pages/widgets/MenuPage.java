package pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class MenuPage {

    private static final Logger logger = LoggerFactory.getLogger(MenuPage.class);

    public MenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "#menu > li")
    private List<WebElement> mainCategories;

    public WebElement clickOnMainCategory(WebDriver driver, String category) {
        for (WebElement mainCategory : mainCategories) {
            if (mainCategory.getText().toLowerCase().contains(category.toLowerCase())) {
                mainCategory.click();
                logger.info(mainCategory.getText() + " was clicked.");
                return mainCategory;
            }
        }
        return null;
    }

    public WebElement clickOnAdditionalCategory(WebDriver driver, WebElement mainCategory, String category) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        List<WebElement> categories = mainCategory.findElements(By.xpath("./ul/li"));
        for (WebElement selectedCategory : categories) {

            wait.until(ExpectedConditions.elementToBeClickable(mainCategory.findElement(By.xpath("./ul/li"))));
            String text = selectedCategory.findElement(By.xpath("./div")).getText();

            if (text.toLowerCase().contains(category.toLowerCase())) {
                selectedCategory.click();
                logger.info(text + " was clicked.");
                return selectedCategory;
            }
        }
        return null;
    }
}
