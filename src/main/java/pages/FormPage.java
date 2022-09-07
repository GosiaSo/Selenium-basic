package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FormPage {

    private static final Logger logger = LoggerFactory.getLogger(FormPage.class);

    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inputFirstName3")
    private WebElement firstNameInput;

    @FindBy(id = "inputLastName3")
    private WebElement lastNameInput;

    @FindBy(id = "inputEmail3")
    private WebElement emailInput;

    @FindBy(css = "input[name=\"gridRadiosSex\"]")
    private List<WebElement> sexRadiobuttons;

    @FindBy(id = "inputAge3")
    private WebElement ageInput;

    @FindBy(css = "input[name=\"gridRadiosExperience\"]")
    private List<WebElement> yearOfExperienceRadiobuttons;

    @FindBy(id = "gridCheckAutomationTester")
    private WebElement automationTesterOption;

    @FindBy(id = "selectContinents")
    private WebElement continentDropdown;
    @FindBy(css = "#selectContinents option")
    private List<WebElement> continentsOptions;

    @FindBy(id = "selectSeleniumCommands")
    private WebElement seleniumCommandsSelect;

    @FindBy(id = "chooseFile")
    private WebElement fileUploudInput;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement submitButton;

    @FindBy(id = "validator-message")
    private WebElement submitMessage;


    public void fillFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void fillEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void chooseRandomSexRadiobutton() {
        Random rand = new Random();
        int randomSex = rand.nextInt(sexRadiobuttons.size());
        sexRadiobuttons.get(randomSex).click();
    }

    public void fillAge() {
        Random rand = new Random();
        int randomAge = rand.nextInt(100);
        ageInput.sendKeys(Integer.toString(randomAge));
    }

    public void chooseRandomYearRadiobutton() {
        Random rand = new Random();
        int randomYear = rand.nextInt(yearOfExperienceRadiobuttons.size());
        yearOfExperienceRadiobuttons.get(randomYear).click();
    }

    public void fillProfession() {
        automationTesterOption.click();
    }

    public void selectContinent() {
        continentDropdown.click();
        Random rand = new Random();
        int list = rand.nextInt(continentsOptions.size());
        continentsOptions.get(list).click();
    }

    public void selectSeleniumCommands(List<String> commands, WebDriver driver) {

        List<String> chosenCommands = selectCommands(commands);

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).build().perform();
        for (String chosenCommand : chosenCommands) {
            WebElement option = seleniumCommandsSelect.findElement(By.cssSelector("option[value=\"" + chosenCommand + "\""));
            option.click();
        }
        actions.keyUp(Keys.CONTROL).build().perform();
    }

    private List<String> selectCommands(List<String> commands) {
        List<String> chosenCommands = new ArrayList<>();
        for (String command : commands) {
            if (command.toLowerCase().contains("browser")) {
                chosenCommands.add("browser-commands");
            }
            if (command.toLowerCase().contains("navigation")) {
                chosenCommands.add("navigation-commands");
            }
            if (command.toLowerCase().contains("switch")) {
                chosenCommands.add("switch-commands");
            }
            if (command.toLowerCase().contains("wait")) {
                chosenCommands.add("wait-commands");
            }
            if (command.toLowerCase().contains("webelement")) {
                chosenCommands.add("webelement-commands");
            }
        }
        return chosenCommands;
    }

    public void uploadFile(String filePath) {
        fileUploudInput.sendKeys(filePath);
        logger.info("File under path: " + filePath + " has been uploaded.");
    }

    public void signIn() {
        submitButton.click();
        logger.info("The form has been sent.");
    }

    public String getSuccessText() {
        return submitMessage.getText();
    }
}
