package ch.fabric.qa.pages;

import ch.fabric.qa.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Contains locators, methods specific to Manage apps Page
 *
 * @author aila.bogasieru@agys.ch
 */


public class ManageAppsPage extends BasePage {

    protected static final Logger logger = LoggerFactory.getLogger(ManageAppsPage.class);

    private By checkBoxName = By.xpath("i[text()='check_box_outline_blank']");
    private By removeButton = By.xpath("");
    private By deleteBtn = By.xpath("//button//div[text()='Delete']");
    private By navigateRight = By.xpath("//i[text()='chevron_right']");
    private By navigateLeft = By.xpath("//i[text()='chevron_left']");
    private By recordsPerpage = By.xpath("//div//i[text()='arrow_drop_down']");
    private By descendingOrderAppsByName = By.xpath("//i[text()='arrow_upward']");
    private By descendingOrderAppsByOwner = By.xpath("//i[text()='arrow_upward']");
    WebDriver driver = null;


    protected ManageAppsPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheck() {
        logger.info("Checking all the apps..");
        WebDriverUtils.clickOnElementWithWait(driver, checkBoxName);
    }

    public void deleteApps() {
        logger.info("Deleting apps..");
        WebDriverUtils.clickOnElementWithWait(driver, deleteBtn);
    }

    public void removeApp() {
        logger.info("Removing gan app..");
        WebDriverUtils.clickOnElementWithWait(driver, removeButton);
    }

    public void showRecords(String result) {
        logger.info("Displaying results" + result);
        WebDriverUtils.selectVisibleText(driver, recordsPerpage, result);
    }

    public void navigateRight() {
        logger.info("Navigating to right..");
        WebDriverUtils.clickOnElementWithWait(driver, navigateRight);
    }

    public void navigateLeft() {
        logger.info("Navigating to left..");
        WebDriverUtils.clickOnElementWithWait(driver, navigateLeft);
    }

    public void descendingOrderByName() {
        logger.info("Sorting in descneding order apps..");
        WebDriverUtils.clickOnElementWithWait(driver, descendingOrderAppsByName);
    }

    public void descendingOrderByOwner() {
        logger.info("Sorting in descneding order apps..");
        WebDriverUtils.clickOnElementWithWait(driver, descendingOrderAppsByOwner);
    }
}
