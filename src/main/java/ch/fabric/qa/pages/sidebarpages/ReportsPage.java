package ch.fabric.qa.pages.sidebarpages;

import ch.fabric.qa.interfaces.Sidebar;
import ch.fabric.qa.pages.BasePage;
import ch.fabric.qa.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that implements locators methods and returns for NewCatalog page
 *
 * @author aila.bogasieru@agys.ch
 */


public class ReportsPage extends BasePage {

    private static Logger logger = LoggerFactory.getLogger(ReportsPage.class);

    private static By finishedProcessesTab = By.xpath("//div//div[text()='Finished processes']");
    private static By activeProcessesTab = By.xpath("//div[text()='Active processes']");
    private static By zoomPlus = By.xpath("//i[@class='q-icon mdi mdi-plus']");
    private static By zoomMinus = By.xpath("//i[@class='q-icon mdi mdi-minus']");
    private static By turnaroundTime = By.xpath("//div[text()='Turnaround time']");
    private static By thresholds = By.xpath("//div[text()='Thresholds']");
    private static By attentionThresholdField = By.xpath("//div[@class='q-if-label q-if-label-above' and .//div[text()='Attention threshold']]/following-sibling::input ");
    private static By warningThresholdField = By.xpath("//div[@class='q-if-label q-if-label-above' and .//div[text()='Warning threshold']]/following-sibling::input ");
    private static By statusNameField = By.xpath("//div[@class='row no-wrap relative-position' and .//div[text()='Status name']]//following-sibling::input[@class='col q-input-target q-no-input-spinner ellipsis']");

    public ReportsPage(WebDriver driver) {
        super(driver);
        Sidebar.setDriver(super.driver);
    }
    public WebDriver getWebdriver(){ return super.driver;}

    public void compareStatusNameField(){
        if(WebDriverUtils.getElementText(driver, statusNameField).equals(DiagramsPage.STATUS_NAME_FIELD)){
            logger.info("Test passed");
        }
        else{
            logger.info("TEST FAILED");
        }
    }

    public void enterWarningThresholdValue() {
        logger.info("Enter a new attention threshold value...");
        WebDriverUtils.enterTextBox(driver, warningThresholdField, "80");
    }

    public void clickWarningThresholdField() {
        logger.info("Click on the Attention threshold field...");
        WebDriverUtils.clickOnElementWithWait(super.driver, warningThresholdField);
    }

    public void enterAttentionThresholdValue() {
        logger.info("Enter a new attention threshold value...");
        WebDriverUtils.enterTextBox(driver, attentionThresholdField, "10");
    }

    public void clickAttentionThresholdField() {
        logger.info("Click on the Attention threshold field...");
        WebDriverUtils.clickOnElementWithWait(super.driver, attentionThresholdField);
    }

    public void clickThresholdsButton() {
        logger.info("Click on Thresholds button from the right...");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, thresholds);
    }

    public void clickTurnaroundTime() {
        logger.info("Click on Turnaround time button from the right...");
        WebDriverUtils.clickOnElementWithWait(super.driver, turnaroundTime);
    }

    public void clickZoomPlus() {
        logger.info("Click on zoom - plus");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, zoomPlus);
    }

    public void clickZoomMinus() {
        logger.info("Click on zoom - minus");
        WebDriverUtils.explicitWait(super.driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(super.driver, zoomMinus);
    }

    public void clickFinishedProcesses() {
        logger.info("Go to FINISHED PROCESSES Tab..");
        WebDriverUtils.clickOnElementWithWait(super.driver, finishedProcessesTab);
    }

    public void clickActiveProcesses() {
        logger.info("Go to FINISHED PROCESSES Tab..");
        WebDriverUtils.clickOnElementWithWait(super.driver, activeProcessesTab);
    }
}
