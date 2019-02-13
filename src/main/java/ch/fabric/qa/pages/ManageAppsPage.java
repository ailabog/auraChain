package ch.fabric.qa.pages;

import ch.fabric.qa.utils.WebDriverUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Contains locators, methods specific to Manage apps Page
 *
 * @author aila.bogasieru@agys.ch
 */

@Slf4j
public class ManageAppsPage extends BasePage {


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
        log.info("Checking all the apps..");
        WebDriverUtils.clickOnElementWithWait(driver, checkBoxName);
    }

    public void deleteApps() {
        log.info("Deleting apps..");
        WebDriverUtils.clickOnElementWithWait(driver, deleteBtn);
    }

    public void removeApp() {
        log.info("Removing gan app..");
        WebDriverUtils.clickOnElementWithWait(driver, removeButton);
    }

    public void showRecords(String result) {
        log.info("Displaying results" + result);
        WebDriverUtils.selectVisibleText(driver, recordsPerpage, result);
    }

    public void navigateRight() {
        log.info("Navigating to right..");
        WebDriverUtils.clickOnElementWithWait(driver, navigateRight);
    }

    public void navigateLeft() {
        log.info("Navigating to left..");
        WebDriverUtils.clickOnElementWithWait(driver, navigateLeft);
    }

    public void descendingOrderByName() {
        log.info("Sorting in descneding order apps..");
        WebDriverUtils.clickOnElementWithWait(driver, descendingOrderAppsByName);
    }

    public void descendingOrderByOwner() {
        log.info("Sorting in descneding order apps..");
        WebDriverUtils.clickOnElementWithWait(driver, descendingOrderAppsByOwner);
    }
}
