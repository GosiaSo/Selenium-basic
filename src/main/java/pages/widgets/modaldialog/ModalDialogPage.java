package pages.widgets.modaldialog;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ModalDialogPage {

    public ModalDialogPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "#create-user")
    private WebElement createUserButton;

    @FindBy(css = ".ui-dialog-buttonset button")
    private List<WebElement> buttons;

    @FindBy(css = "tbody tr")
    public List<WebElement> users;

    public void createNewUser() {
        createUserButton.click();
        for (WebElement button : buttons) {
            if (button.getText().toLowerCase().contains("create")) {
                button.click();
            }
        }
    }

    public List<User> getUsers() {
        List<User> existingUsers = new ArrayList<>();
        for (WebElement user : users) {
            RowPage rowPage = new RowPage(user);
            User existingUser = new User();
            existingUser.name = rowPage.getName();
            existingUser.email = rowPage.getEmail();
            existingUser.password = rowPage.getPassword();
            existingUsers.add(existingUser);
        }
        return existingUsers;
    }

    public boolean checkIfNewUserIsCreated(List<User> existingUsers, User user) {
        for (User existingUser : existingUsers) {
            if (existingUser.equals(user)) {
                return true;
            }
        }
        return false;
    }

    public static class User {
        private String name;
        private String email;
        private String password;

        public User() {
        }

        public User(String name, String email, String password) {
            this.name = name;
            this.email = email;
            this.password = password;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return StringUtils.equals(name, user.name) && StringUtils.equals(email, user.email) && StringUtils.equals(password, user.password);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, email, password);
        }
    }

//    static class ExistingUsers {
//        private List<User> users;
//    }
}
