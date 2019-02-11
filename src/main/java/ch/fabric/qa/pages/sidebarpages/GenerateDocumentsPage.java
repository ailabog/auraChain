package ch.fabric.qa.pages.sidebarpages;

import ch.fabric.qa.interfaces.Sidebar;
import ch.fabric.qa.pages.BasePage;
import ch.fabric.qa.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ch.fabric.qa.utils.WebDriverUtils.*;

/**
 * Class that implements locators methods and returns for Generate Documents Page
 *
 * @author aila.bogasieru@agys.ch
 */

public class GenerateDocumentsPage extends BasePage {

    private static Logger logger = LoggerFactory.getLogger(GenerateDocumentsPage.class);
    private static By addDocument = By.xpath("//i[text()=' add']");
    private static By removeDocument = By.xpath("//i[text()=' delete']");
    private static By seeDocument = By.xpath("//i[text()=' visibility']");
    private static By cancelBtn = By.xpath("//button//div[text()='Cancel']");
    private static By closeCreateDoc = By.xpath("//i[text()='keyboard_arrow_left']");
    private static By dataModelTab = By.xpath("//div//div[text()='Data model']");
    private static By variablesTab = By.xpath("//div//div[text()='Variables']");
    private static By addNewDocButton = By.xpath("//div[text()='Add new']");
    private static By clickOnDocToEdit = By.xpath("//td[@class='text-left cursor-pointer']");
    private static By docNameFieldTextInput = By.xpath("//input[not(@id) and (@class='col q-input-target q-no-input-spinner ellipsis')]");
    private static By previewDocBtn = By.xpath("//i[@class='q-icon far fa-eye']");
    private static By uploadImageBtn = By.xpath("//button[@id='mceu_20-button']");
    private static By imageSourceBtn = By.xpath("//i[@class='mce-ico mce-i-browse']");
    private static By chooseFileBtn = By.xpath("//input[@class='mce-textbox' and @type='file']");
    private static By sourceField = By.xpath("//input[@placeholder]");
    private static By imageDescriptionField = By.xpath("//input[@class='mce-textbox mce-abs-layout-item mce-last']");
    private static By clickImageOkBtn = By.xpath("//div[@class='mce-widget mce-btn mce-primary mce-abs-layout-item mce-first mce-btn-has-text']//button");

    public GenerateDocumentsPage(WebDriver driver) {
        super(driver);
        Sidebar.setDriver(super.driver);
    }
    public WebDriver getWebdriver(){ return super.driver;}

    public void clickOkImageBtn() {
        logger.info("Click the OK confirmation after uploading an image...");
        WebDriverUtils.explicitWait(driver, WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, clickImageOkBtn);
    }

    public void clickImageDescriptionField() {
        logger.info("Click on image description field...");
        WebDriverUtils.explicitWait(driver, WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, imageDescriptionField);
    }

    public void enterImageSource(String imageSourceValue) {
        logger.info("Entering image source..");
        WebDriverUtils.enterTextBox(driver, sourceField, imageSourceValue);
    }

    public void clickSourceField() {
        logger.info("Click on the source field...");
        WebDriverUtils.clickOnElementWithWait(driver, sourceField);
    }

    public void uploadImageDoc(String path) {
        logger.info("Uploading the image..");
        WebDriverUtils.uploadFile(super.driver, chooseFileBtn, path);
    }

    public void clickOnImageSourceBtn() {
        logger.info("Click on the image source button after hitting upload image on doc...");
        WebDriverUtils.clickOnElement(driver, imageSourceBtn);
    }

    public void clickUploadImageBtn() {
        logger.info("Click on the upload image button...");
        WebDriverUtils.explicitWait(driver, WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, uploadImageBtn);
    }

    public void clickOnPreviewBtn() {
        logger.info("Clicking on the preview button...");
        WebDriverUtils.clickOnElementWithWait(driver, previewDocBtn);
    }

    public void clickOnDocNameFieldTextInput() {
        logger.info("Clicking on the doc name field...");
        WebDriverUtils.clickOnElementWithWait(driver, docNameFieldTextInput);
    }

    public void enterDocName(String nameApps) {
        logger.info("Entering apss name..");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.enterTextBox(super.driver, docNameFieldTextInput, nameApps);
    }

    public void clearDocName() {
        logger.info("Clearing the doc name...");
        WebDriverUtils.clearElement(driver, docNameFieldTextInput);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
    }

    public void clickOnDocToEdit() {
        logger.info("Click on the document to edit the name...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, clickOnDocToEdit);
    }

    public void clickOnAddNewDocButton() {
        logger.info("Click on the add new small icon..");
        WebDriverUtils.explicitWait(driver, WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, addNewDocButton);
    }

    public void uploadDocument(String path) {
        logger.info("Uploading the image..");
        WebDriverUtils.uploadFile(super.driver, addNewDocButton, path);
    }


    public void clickDataMoledTab() {
        logger.info("Accessing Data Model Tab..");
        WebDriverUtils.clickOnElementWithWait(super.driver, dataModelTab);
    }

    public void clickVariablesdTab() {
        logger.info("Accessing Variables Tab..");
        WebDriverUtils.clickOnElementWithWait(super.driver, variablesTab);
    }

    public void addNewDoc() {
        logger.info("Adding new document..");
        WebDriverUtils.clickOnElementWithWait(super.driver, addDocument);
    }

    public void removeDoc() {
        logger.info("Adding new document..");
        WebDriverUtils.clickOnElementWithWait(super.driver, removeDocument);
    }

    public void seeDoc() {
        logger.info("Adding new document..");
        WebDriverUtils.clickOnElementWithWait(super.driver, seeDocument);
    }

    public void cancelNewDoc() {
        logger.info("Canceling creation of the new document..");
        WebDriverUtils.clickOnElementWithWait(super.driver, cancelBtn);
    }

    public void closeNewDoc() {
        logger.info("Closing creation of the new document..");
        WebDriverUtils.clickOnElementWithWait(super.driver, closeCreateDoc);
    }
}
