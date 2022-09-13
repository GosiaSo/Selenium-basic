package pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccordionPage {
    public AccordionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#accordion h3")
    private List<WebElement> sections;

    public String getAllSections() {
        StringBuilder sb = new StringBuilder();
        for (WebElement paragraph : sections) {
            WebElement divWithText = paragraph.findElement(By.xpath("following-sibling::*"));
            getChildText(divWithText, sb);
        }
        return sb.toString();
    }

    private void getChildText(WebElement divWithText, StringBuilder sb) {
        WebElement child = divWithText.findElement(By.xpath(".//*"));
        sb.append(child.getAttribute("textContent"));
        if (!child.findElements(By.xpath(".//*")).isEmpty()) {
            String text = child.findElement(By.xpath(".//*")).getAttribute("textContent");
            sb.append(text).append(System.getProperty("line.separator"));
            getChildText(child, sb);
        }
    }
}
