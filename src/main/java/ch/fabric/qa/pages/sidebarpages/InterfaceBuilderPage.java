package ch.fabric.qa.pages.sidebarpages;

import ch.fabric.qa.interfaces.Sidebar;
import ch.fabric.qa.pages.BasePage;
import ch.fabric.qa.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that implements locators methods and returns for InterfaceBuilderPage page
 *
 * @author aila.bogasieru@agys.ch
 */

public class InterfaceBuilderPage extends BasePage {

    private static Logger logger = LoggerFactory.getLogger(InterfaceBuilderPage.class);

    private static By pagesBtn = By.xpath("//button//div[text()='Pages']");
    private static By layoutBtn = By.xpath("//button//div[text()='Layout']");
    private static By basicComponentsChevronDown = By.xpath("//div[text()='Basic components']");
    private static By layoutStructureChevronDown = By.xpath("//div[text()='Layout structure']");
    private static By panelUIAdd = By.xpath("//div[text()='Panel']");
    private static By panelIcon = By.xpath("//div//div[@class='col-auto left-item-icon row justify-center round-borders bg-white']");
    private static By standardElementsChevronDown = By.xpath("//div//i[@class='q-icon cursor-pointer transition-generic relative-position q-collapsible-toggle-icon material-icons q-item-icon']");
    private static By segmentIcon = By.xpath("//div//div[@class='col-auto left-item-icon row justify-center round-borders bg-white']");
    private static By formElementsChevronDown = By.xpath("//div//i[@class='q-icon cursor-pointer transition-generic relative-position q-collapsible-toggle-icon material-icons q-item-icon rotate-180']");
    private static By textBoxIcon = By.xpath("//div//div[@class='col-auto left-item-icon row justify-center round-borders bg-white']");
    private static By selectIcon = By.xpath("//div//div[@class='col-auto left-item-icon row justify-center round-borders bg-white']");
    private static By customComponentsChevronDown = By.xpath("//div//i[@class=q-icon cursor-pointer transition-generic relative-position q-collapsible-toggle-icon mdi mdi-chevron-down q-item-icon']");
    private static By textBox = By.xpath("//input//div[text()='New textbox']");
    private static By codeInput = By.xpath("//html/body/div[1]/div[2]/main/div[3]/div[2]/div/div/div[1]/div/div[1]/div/div[3]/div[1]/div/div[2]/div[1]/input");
    private static By nameInput = By.xpath("/html/body/div[1]/div[2]/main/div[3]/div[2]/div/div/div[1]/div/div[1]/div/div[3]/div[2]/div/div[2]/div[1]/input");

    public InterfaceBuilderPage(WebDriver driver) {
        super(driver);
        Sidebar.setDriver(super.driver);
    }
    public WebDriver getWebdriver(){ return super.driver;}

    public void clickOnCodeInput() {
        logger.info("Clicking on the code field..");
        WebDriverUtils.clickOnElementWithWait(driver, codeInput);
    }

    public void enterCodeText(String interfaceCodeValue) {
        logger.info("Enter code text..");
        WebDriverUtils.enterTextBox(driver, codeInput, interfaceCodeValue);
    }

    public void clickOnNameInput() {
        logger.info("Clicking on the name field..");
        WebDriverUtils.clickOnElementWithWait(driver, nameInput);
    }

    public void enterNameText(String interfaceCodeValue) {
        logger.info("Enter name text..");
        WebDriverUtils.enterTextBox(driver, nameInput, interfaceCodeValue);
    }

    public void clickOnPanelElement() {
        logger.info("Clicking on panel to be added..");
        WebDriverUtils.clickOnElementWithWait(driver, panelUIAdd);
    }

    public void clickLayoutStructureButton() {
        logger.info("Clicking on the layout structure dropdown..");
        WebDriverUtils.clickOnElementWithWait(driver, layoutStructureChevronDown);
    }

    public void clickBasicComponentsButton() {
        logger.info("Clicking on the basic components dropdown..");
        WebDriverUtils.clickOnElement(driver, basicComponentsChevronDown);
    }

    public void clickPages() {
        logger.info("Accessing Pages..");
        WebDriverUtils.clickOnElementWithWait(super.driver, pagesBtn);
    }

    public void clickLayout() {
        logger.info("Accessing Layout..");
        WebDriverUtils.clickOnElementWithWait(super.driver, layoutBtn);
    }

    public void goToBasicComponents() {
        logger.info("Going to Basic components section..");
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
        logger.info("Going to Custom components section..");
        WebDriverUtils.clickOnElementWithWait(super.driver, customComponentsChevronDown);
    }

    public void enterTextBoxValue(String value) {
        logger.info("Entering value in textbox form element..");
        WebDriverUtils.enterTextBox(super.driver, textBox, value);

    }
}
