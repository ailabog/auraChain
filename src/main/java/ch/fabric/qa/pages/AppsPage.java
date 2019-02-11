package ch.fabric.qa.pages;

import ch.fabric.qa.interfaces.*;
import ch.fabric.qa.pages.sidebarpages.DiagramsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.fabric.qa.utils.WebDriverUtils;
import org.testng.Assert;

import static ch.fabric.qa.utils.WebDriverUtils.WAIT_1000_MILLISECONDS;

/**
 * Contains locators, methods specific to Apps page
 *
 * @author aila.bogasieru@agys.ch
 */

public class AppsPage extends BasePage {

    protected static final Logger logger = LoggerFactory.getLogger(AppsPage.class);

    private By searchTextBox = By.xpath("//input[@placeholder='Search']");
    private By createNewButton = By.xpath("//button//div[text()='Create new']");
    private By yourApplicationLink = By.xpath("//div[text()='Your applications']");
    private By sharedWithYouLink = By.xpath("//div[text()='Shared with you']");
    private By archievedApplication = By.xpath("//button//div[text()='Archived applications']");
    private By applicationsTable = By.xpath("//man[@class='q-layout-page q-pa-md-xs q-pa-lg-lg row justify-center page-style']");
    private By selectType = By.xpath("//div//i[text()='arrow_drop_down']");
    private By standardValue = By.xpath("//div[4]/div/div/div/div");
    private By hyperledgerFabric = By.xpath("//div[4]/div/div[2]/div/div");
    private By appsNameTxtBox = By.xpath("//input[@class='col q-input-target q-no-input-spinner ellipsis']");
    private By appDescription = By.xpath("//textarea[@class='col q-input-target q-input-area']");
    private By saveAppBtn = By.xpath("//button//div[text()='Save']");
    private By cloudUploadBtn = By.xpath("//input[@class='hidden-input-file bg-grey-2']");
    private By editAppsBtn = By.xpath("//button//div[text()='Edit App']");
    private By moreActionsApp = By.xpath("//i[text()='more_vert']");
    private By userInterfaceActionApp = By.xpath("//div//div[text()='  User Interface ']");
    private By reportsActionApp = By.xpath("//div[text()='Reports']");
    private By nameAppText = By.xpath("//div[contains(text(), '17/1/12/29/10')]");
    private By oneApp = By.xpath("//*[contains(text(), 'AutomationTestLucian')]");
    private By searchIcon = By.xpath("//i[@class='q-icon fas fa-search']/ancestor::button");
    private By clickOnApp = By.xpath("//div[@class='apps-card-title row' and contains (text(), 'Samsung2021')]");

    private By pagesBtn = By.xpath("//button//div[text()='Pages']");
    private By layoutBtn = By.xpath("//button//div[text()='Layout']");

    private static final String DESCRIPTION_SUBSTRING = " Added Text to Description";

    protected AppsPage(WebDriver driver) {
        super(driver);
        Sidebar.setDriver(super.driver);
    }
    public WebDriver getWebdriver(){
        return super.driver;
    }

    public void uploadFileToApp(String filePath){
        WebDriverUtils.uploadFile(super.driver, cloudUploadBtn,  filePath);
    }

    public void clickApplicationName() {
        logger.info("Clicking on application name field...");
        WebDriverUtils.clickOnElement(driver, appsNameTxtBox);
    }

    public void clickApplicationDescription() {
        logger.info("Clicking on application description field...");
        WebDriverUtils.clickOnElement(driver, appDescription);
    }

    public void clickOnUploadButton() {
        logger.info("Clicking on upload image button...");
        WebDriverUtils.clickOnElement(driver, cloudUploadBtn);
    }

    public void clickOneApp() {
        logger.info("Clicking on an app...");
        WebDriverUtils.clickOnElementWithWait(super.driver, oneApp);
    }

    public void clickOnEditAppbtn() {
        WebDriverUtils.explicitWait(super.driver, WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, editAppsBtn);
        logger.info("Clicked on Edit App button");
    }

    public void searchApp(String appSearched) {
        logger.info("Searching for application...");
        WebDriverUtils.enterTextBox(super.driver, searchTextBox, appSearched);
    }

    public void clickCreateNew() {
        logger.info("Creating new application...");
        WebDriverUtils.explicitWait(super.driver, WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, createNewButton);
    }



    public void clickYourApplication() {
        logger.info("Accessing all the applications..");
        WebDriverUtils.clickOnElementWithWait(super.driver, yourApplicationLink);

    }

    public  DiagramsPage returnSamsungDiagram() {
    WebDriverUtils.clickOnElementWithWait(driver, clickOnApp);
    WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
            ExpectedConditions.invisibilityOfElementLocated(clickOnApp));
    WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
    return new DiagramsPage(driver);
    }

    public void clickSharedWithYou() {
        logger.info("Accessing all the applications that are shared with you..");
        WebDriverUtils.clickOnElementWithWait(super.driver, sharedWithYouLink);

    }

    public void clickArchievedApplication() {
        logger.info("Accessing all the archieved applications..");
        WebDriverUtils.clickOnElementWithWait(super.driver, archievedApplication);
    }

    public void enterAppsName(String nameApps) {
        logger.info("Entering apss name..");
        WebDriverUtils.explicitWait(super.driver, WAIT_1000_MILLISECONDS);
        WebDriverUtils.enterTextBox(super.driver, appsNameTxtBox, nameApps);
    }

    public void selectTypeOfApp() {
        logger.info("Selecting type of the application..");
        WebDriverUtils.clickOnElementWithWait(super.driver, selectType);
    }

    public void standardApp() {
        logger.info("Selecting standard App..");
        WebDriverUtils.clickOnElementWithWait(super.driver, standardValue);
    }

    public void hyperledgerdApp() {
        logger.info("Selecting Hyperledger Fabric App..");
        WebDriverUtils.clickOnElementWithWait(super.driver, hyperledgerFabric);
    }

    public void enterAppDescription(String appDescriptionValue) {
        logger.info("Entering description for the application..");
        WebDriverUtils.explicitWait(super.driver, WAIT_1000_MILLISECONDS);
        WebDriverUtils.enterTextBox(super.driver, appDescription, appDescriptionValue);
    }

    public void saveAppClick() {
        logger.info("Saving the application..");
        WebDriverUtils.clickOnElementWithWait(super.driver, saveAppBtn);
    }

    public void findMyApplication() {
        logger.info("Uploading the image..");
        WebDriverUtils.clickOnElementWithWait(super.driver, cloudUploadBtn);
    }

    public void uploadImageApps(String path) {
        logger.info("Uploading the image..");
        WebDriverUtils.uploadFile(super.driver, cloudUploadBtn, path);
    }

    public void SendDescSubstrToDesc() {
        WebDriverUtils.explicitWait(super.driver, WAIT_1000_MILLISECONDS);
        WebDriverUtils.findElement(super.driver, appDescription).sendKeys(DESCRIPTION_SUBSTRING);
        logger.info("Updating the description with text: " + DESCRIPTION_SUBSTRING);
    }


    public void setEditAppsBtnApp(String appName) {
        logger.info("Editing an app..");
        if (WebDriverUtils.table(driver, appName, applicationsTable)) {
            WebDriverUtils.clickOnElementWithWait(super.driver, editAppsBtn);
        } else {
            logger.info("Application can not be edited..");
        }
    }

    public void clickMoreActionsApp() {
        logger.info("Displaying more actions..");
        WebDriverUtils.clickOnElementWithWait(super.driver, moreActionsApp);
    }

    public void clickUserInterfaceActionApp() {
        logger.info("Going to user interface action for app..");
        WebDriverUtils.clickOnElementWithWait(super.driver, userInterfaceActionApp);
    }

    public void clickReportsActionApp() {
        logger.info("Going to reports action for app..");
        WebDriverUtils.clickOnElementWithWait(super.driver, reportsActionApp);
    }

    public void clickOnSearchIcon() {
        WebDriverUtils.clickOnElementWithWait(super.driver, searchIcon);
    }

    public void assertAppFound(String expectedApp){
        String searchAppLable = WebDriverUtils.getElementText(super.driver,nameAppText);
        Assert.assertEquals(searchAppLable, expectedApp, "App searched is the right one");
    }

    public DiagramsPage goToDiagramsPageFromAppsPage() {
        DiagramsPage diagram = new DiagramsPage(driver);
        WebDriverUtils.waitUntil(super.driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(createNewButton));
        WebDriverUtils.waitUntil(super.driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.visibilityOfElementLocated(diagram.publishButton));
        logger.info("Publish element is visible..");
        logger.info("Diagrams page is loaded..");
        return new DiagramsPage(super.driver);
    }

}
