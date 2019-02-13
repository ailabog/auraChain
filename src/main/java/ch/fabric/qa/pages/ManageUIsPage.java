package ch.fabric.qa.pages;

import ch.fabric.qa.utils.WebDriverUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Contains locators, methods specific to Manage UI Page
 *
 * @author aila.bogasieru@agys.ch
 */

@Slf4j
public class ManageUIsPage extends BasePage {

    private By checkCheckBoxName = By.xpath("//i[text()='check_box_outline_blank']");
    private By removeManageUI = By.xpath("//i[text()='delete']");
    private By sortDescendingName = By.xpath("//th[@class='text-left sortable sorted sort-desc'");
    private By sortAscendingName = By.xpath("//th[@class='text-left sortable']");
    private By sortDescendingDescription = By.xpath("//th[@class='text-left sortable sorted sort-desc'");
    private By sortAscendingDescription = By.xpath("//th[@class='text-left sortable']");
    private By sortDescendingOwner = By.xpath("//th[@class='text-left sortable sorted sort-desc'");
    private By sortAscendingOwner = By.xpath("//th[@class='text-left sortable']");
    private By sortDescendingUIs = By.xpath("//th[@class='text-left sortable sorted sort-desc'");
    private By sortAscendingUIs = By.xpath("//th[@class='text-left sortable']");

    private By recordsPerpage = By.xpath("//div//i[text()='arrow_drop_down']");
    private By navigateRight = By.xpath("//i[text()='chevron_right']");
    private By navigateLeft = By.xpath("//i[text()='chevron_left']");
    WebDriver driver = null;

    protected ManageUIsPage(WebDriver driver) {
        super(driver);
    }

    public void navigateLeft() {
        log.info("Navigating to the left..");
        WebDriverUtils.clickOnElementWithWait(driver, navigateLeft);
    }

    public void setNavigateRightight() {
        log.info("Navigating to the right..");
        WebDriverUtils.clickOnElementWithWait(driver, navigateRight);
    }

    public void showRecordsPerPage(String result) {
        log.info("Showing records per page..");
        WebDriverUtils.selectVisibleText(driver, recordsPerpage, result);
    }

    public void removeUI() {
        log.info("Removing UI..");
        WebDriverUtils.clickOnElementWithWait(driver, removeManageUI);
    }

    public void sortAscendingByName() {
        log.info("Sorting ascending by name..");
        WebDriverUtils.clickOnElementWithWait(driver, sortDescendingName);
    }

    public void sortDescendingByName() {
        log.info("Sorting ascending by name..");
        WebDriverUtils.clickOnElementWithWait(driver, sortAscendingName);
    }

    public void sortAscendingByDescription() {
        log.info("Sorting ascending by name..");
        WebDriverUtils.clickOnElementWithWait(driver, sortDescendingDescription);
    }

    public void sortDescendingByDescription() {
        log.info("Sorting ascending by name..");
        WebDriverUtils.clickOnElementWithWait(driver, sortAscendingDescription);
    }

    public void sortAscendingByOwner() {
        log.info("Sorting ascending by name..");
        WebDriverUtils.clickOnElementWithWait(driver, sortDescendingOwner);
    }

    public void sortDescendingByOwner() {
        log.info("Sorting ascending by name..");
        WebDriverUtils.clickOnElementWithWait(driver, sortAscendingOwner);
    }

    public void sortAscendingByUIs() {
        log.info("Sorting ascending by name..");
        WebDriverUtils.clickOnElementWithWait(driver, sortDescendingOwner);
    }

    public void sortDescendingByUIs() {
        log.info("Sorting ascending by name..");
        WebDriverUtils.clickOnElementWithWait(driver, sortAscendingOwner);
    }
}
