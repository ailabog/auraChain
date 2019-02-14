package ch.fabric.qa.pages.sidebarpages;

import ch.fabric.qa.interfaces.Sidebar;
import ch.fabric.qa.pages.BasePage;
import ch.fabric.qa.utils.WebDriverUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that implements locators methods and returns for InterfaceBuilderPage page
 *
 * @author aila.bogasieru@agys.ch
 */

@Slf4j
public class InterfaceBuilderPage extends BasePage {


    private static By pagesBtn = By.xpath("//div[@class='q-btn-group row no-wrap inline q-btn-toggle text-primary fabric col']//div[text()='Pages']");
    private static By layoutBtn = By.xpath("//button[@class='q-btn inline relative-position q-btn-item non-selectable q-btn-rectangle q-focusable q-hoverable bg-primary text-white']//div[text()='Pages']");
    private static By basicComponentsChevronDown = By.xpath("//div[text()='Basic components']");
    private static By layoutStructureChevronDown = By.xpath("//div[text()='Layout structure']");
    private static By panelUIAdd = By.xpath("//div[text()='Panel']");
    private static By panelIcon = By.xpath("//div//div[@class='col-auto left-item-icon row justify-center round-borders bg-white']");
    private static By standardElementsChevronDown = By.xpath("//div//i[@class='q-icon cursor-pointer transition-generic relative-position q-collapsible-toggle-icon material-icons q-item-icon']");
    private static By segmentIcon = By.xpath("//div//div[@class='col-auto left-item-icon row justify-center round-borders bg-white']");
    private static By formElementsChevronDown = By.xpath("//div[text()='Form elements']");
    private static By textBoxIcon = By.xpath("//div[text()='Textbox']");
    private static By selectIcon = By.xpath("//div//div[@class='col-auto left-item-icon row justify-center round-borders bg-white']");
    private static By customComponentsChevronDown = By.xpath("//div//i[@class=q-icon cursor-pointer transition-generic relative-position q-collapsible-toggle-icon mdi mdi-chevron-down q-item-icon']");
    private static By textBox = By.xpath("//input//div[text()='New textbox']");
    private static By codeInput = By.xpath("//div[text()='Code']//preceding::input");
    private static By nameInput = By.xpath("//div[text()='Name']//following::input");
    private static By descriptionInput = By.xpath("//div[text()='Description']//preceding::textarea[@class='col q-input-target q-input-area']");
    private static By interfaceBuilderSaveButton = By.xpath("//div[text()='Save']");

    public InterfaceBuilderPage(WebDriver driver) {
        super(driver);
        Sidebar.setDriver(super.driver);
    }
    public WebDriver getWebdriver(){ return super.driver;}

    public void editingTheStylesTab(){
        log.info("")
    }

    public void addCodeNameDescription(){
        log.info("Click on the Code field...");
        WebDriverUtils.clickOnElementWithWait(driver, codeInput);
        log.info("Entering text in the Code field...");
        WebDriverUtils.enterTextBox(driver, codeInput, "CodeFieldTest");
        log.info("Click on the Name field...");
        WebDriverUtils.clickOnElementWithWait(driver, nameInput);
        log.info("Entering text in the Name field...");
        WebDriverUtils.enterTextBox(driver, nameInput, "NameFieldTest");
        log.info("Click on the Description field...");
        WebDriverUtils.clickOnElementWithWait(driver, descriptionInput);
        log.info("Entering text in the Description field...");
        WebDriverUtils.enterTextBox(driver, descriptionInput, "DescriptionFieldTest");
    }

    public void saveInterfaceBuilderPage(){
        log.info("Save the interface builder ...");
        WebDriverUtils.clickOnElementWithWait(driver, interfaceBuilderSaveButton);
    }

    public void addFormElementsComponents(){
        log.info("Click Form elements section...");
        WebDriverUtils.clickOnElementWithWait(driver, formElementsChevronDown);
        log.info("Click on a textbox element...");
        WebDriverUtils.clickOnElementWithWait(driver, textBoxIcon);
    }

    public void addLayoutStructureComponents() {
        log.info("Click the Basic components section...");
        WebDriverUtils.clickOnElementWithWait(driver, basicComponentsChevronDown);
        log.info("Click Layout structure section...");
        WebDriverUtils.clickOnElementWithWait(driver, layoutStructureChevronDown);
        log.info("Add a panel element...");
        WebDriverUtils.clickOnElementWithWait(driver, panelUIAdd);
    }

    public void clickOnCodeInput() {
        log.info("Clicking on the code field..");
        WebDriverUtils.clickOnElementWithWait(driver, codeInput);
    }

    public void enterCodeText(String interfaceCodeValue) {
        log.info("Enter code text..");
        WebDriverUtils.enterTextBox(driver, codeInput, interfaceCodeValue);
    }

    public void clickOnNameInput() {
        log.info("Clicking on the name field..");
        WebDriverUtils.clickOnElementWithWait(driver, nameInput);
    }

    public void enterNameText(String interfaceCodeValue) {
        log.info("Enter name text..");
        WebDriverUtils.enterTextBox(driver, nameInput, interfaceCodeValue);
    }

    public void clickOnPanelElement() {
        log.info("Clicking on panel to be added..");
        WebDriverUtils.clickOnElementWithWait(driver, panelUIAdd);
    }

    public void clickLayoutStructureButton() {
        log.info("Clicking on the layout structure dropdown..");
        WebDriverUtils.clickOnElementWithWait(driver, layoutStructureChevronDown);
    }

    public void clickBasicComponentsButton() {
        log.info("Clicking on the basic components dropdown..");
        WebDriverUtils.clickOnElement(driver, basicComponentsChevronDown);
    }

    public void clickPages() {
        log.info("Accessing Pages..");
        WebDriverUtils.clickOnElementWithWait(super.driver, pagesBtn);
    }

    public void clickLayout() {
        log.info("Accessing Layout..");
        WebDriverUtils.clickOnElementWithWait(super.driver, layoutBtn);
    }

    public void goToBasicComponents() {
        log.info("Going to Basic components section..");
        WebDriverUtils.clickOnElementWithWait(super.driver, basicComponentsChevronDown);
        if (WebDriverUtils.findElement(super.driver, layoutStructureChevronDown) != null &&
                WebDriverUtils.findElement(super.driver, standardElementsChevronDown) != null &&
                WebDriverUtils.findElement(super.driver, formElementsChevronDown) != null)
            WebDriverUtils.clickOnElementWithWait(super.driver, layoutStructureChevronDown);
        WebDriverUtils.clickOnElementWithWait(super.driver, panelIcon);
        WebDriverUtils.clickOnElementWithWait(super.driver, standardElementsChevronDown);
        WebDriverUtils.clickOnElementWithWait(super.driver, segmentIcon);
        WebDriverUtils.clickOnElementWithWait(super.driver, formElementsChevronDown);
        WebDriverUtils.clickOnElementWithWait(super.driver, textBoxIcon);
        WebDriverUtils.clickOnElementWithWait(super.driver, selectIcon);
    }

    public void goToCustomComponents() {
        log.info("Going to Custom components section..");
        WebDriverUtils.clickOnElementWithWait(super.driver, customComponentsChevronDown);
    }

    public void enterTextBoxValue(String value) {
        log.info("Entering value in textbox form element..");
        WebDriverUtils.enterTextBox(super.driver, textBox, value);

    }
}
