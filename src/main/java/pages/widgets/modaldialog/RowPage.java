package pages.widgets.modaldialog;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class RowPage {
    public RowPage(WebElement row) {
        PageFactory.initElements(new DefaultElementLocatorFactory(row), this);
    }

    @FindBy(xpath = "td[1]")
    private WebElement name;

    @FindBy(xpath = "td[2]")
    private WebElement email;

    @FindBy(xpath = "td[3]")
    private WebElement password;

    public String getName() {
        return name.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getPassword() {
        return password.getText();
    }
}
