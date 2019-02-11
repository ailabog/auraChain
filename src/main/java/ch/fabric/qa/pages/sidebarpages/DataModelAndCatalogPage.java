package ch.fabric.qa.pages.sidebarpages;

import ch.fabric.qa.interfaces.Sidebar;
import ch.fabric.qa.pages.BasePage;
import ch.fabric.qa.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that implements locators methods and returns for Data Model and Catalogs page
 *
 * @author aila.bogasieru@agys.ch
 */


public class DataModelAndCatalogPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(DataModelAndCatalogPage.class);

    private static By catalogsElement = By.xpath("//button[@class='q-btn inline relative-position q-btn-item non-selectable q-btn-rectangle q-focusable q-hoverable bg-white text-primary q-btn-no-uppercase']");
    private static By addNewButtonAllCatalogs = By.name("add_box");
    private static By importCatalog = By.xpath("//i[text()='import_export']");
    private static By add_newButton = By.xpath("//*[contains(text()='Add New']");
    private static By typeOfFileSelect = By.xpath("//*[contains(text()='arrow_drop_down']");
    private static By cloudImport = By.xpath("//*contains[text()='cloud_download']");
    private static By plusAddFile = By.xpath("//input[@class='q-uploader-input absolute-full cursor-pointer']");
    private static By exportCatalog = By.xpath("//*[contains(text()='cloud_upload']");
    private static By searchCatalogTxtBox = By.xpath("//input[@placeholder='Search']");
    private static By addNewDataModelButton = By.xpath("//*[contains(text()='New']");
    private static By classNameTxtbox = By.xpath("//*[contains(text()='q-if row no-wrap relative-position q-input q-mt-md q-ml-md q-mr-md q-if-has-label q-if-standard text-primary']");

    public DataModelAndCatalogPage(WebDriver driver) {
        super(driver);
        Sidebar.setDriver(super.driver);
    }
    public WebDriver getWebdriver(){
        return super.driver;
    }

    public void catalogClick() {
        logger.info("Adding new catalog{}" + catalogsElement);
        WebDriverUtils.clickOnElementWithWait(super.driver, catalogsElement);
    }

    public void addNewCatalogFromAllCatalogs() {
        logger.info("Adding new catalog{}" + addNewButtonAllCatalogs);
        WebDriverUtils.clickOnElementWithWait(super.driver, addNewButtonAllCatalogs);
    }

    public void importCatalog() {
        logger.info("Import new catalog{}" + importCatalog);
        WebDriverUtils.clickOnElementWithWait(super.driver, importCatalog);
    }

    public void exportCatalog() {
        logger.info("Import new catalog{}" + exportCatalog);
        WebDriverUtils.clickOnElementWithWait(super.driver, exportCatalog);
    }

    public void addNewCatalog() {
        logger.info("Adding new catalog..");
        WebDriverUtils.clickOnElementWithWait(super.driver, add_newButton);
    }

    public void selectTypeOfFile(String typeOfFile) {
        logger.info("Selecting type of file..");
        WebDriverUtils.selectVisibleText(super.driver, typeOfFileSelect, typeOfFile);
    }

    public void importCloud() {
        logger.info("Importing from cloud..");
        WebDriverUtils.clickOnElementWithWait(super.driver, cloudImport);
        WebDriverUtils.clickOnElementWithWait(super.driver, plusAddFile);
        //TO DO UPLOAD THE CATALOG
    }

    public void exportCloud() {
        logger.info("Exporting the file...");
        WebDriverUtils.clickOnElementWithWait(super.driver, exportCatalog);
    }

    public void searchCatalog(String searchCatalogValue) {
        logger.info("Searching new catalog...");
        WebDriverUtils.enterTextBox(super.driver, searchCatalogTxtBox, searchCatalogValue);
    }

    public void addNewDataModel() {
        logger.info("Adding new data model..");
        WebDriverUtils.clickOnElementWithWait(super.driver, addNewDataModelButton);
    }

    public void classNameDataModel(String className) {
        logger.info("Entering class name..");
        WebDriverUtils.enterTextBox(super.driver, classNameTxtbox, className);
    }
}
