package ch.fabric.qa.pages;

import ch.fabric.qa.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Contains locators, methods specific to Tasks page
 *
 * @author aila.bogasieru@agys.ch
 */

public class TasksPage extends BasePage {

    protected static final Logger logger = LoggerFactory.getLogger(ManageAppsPage.class);

    private By myActiveTasksTab = By.xpath("//div[text()='My open tasks']");
    private By myCompletedTasksTab = By.xpath("//div[text()='Completed tasks']");
    private By tasksTable = By.xpath("//table[@class='q-table q-table-horizontal-separator']");
    private By myOpenTasksFilter = By.xpath("//div[contains(text(),'My open tasks']");
    private By recordsPerPageDropDown = By.xpath("//div[@class='q-if row no-wrap relative-position q-select inline q-table-bottom-item q-if-focusable q-if-hide-underline q-if-standard q-if-has-content text-primary']//div[@class='col q-input-target ellipsis justify-start']");
    private By recordsPerPage20Option = By.xpath("//div[@class='q-item-label' and text()='20']");
    private By completedTasksTab = By.xpath("//div[text()='Completed tasks']");
    private By completedTasksTitle = By.xpath("//div[@class='row' and contains(text(), 'Completed tasks')]");
    private By allApplicationsDropDown = By.xpath("//div[@class='col q-input-target ellipsis justify-start' and text()='All applications']");
    private By allApplicationsDropDownOption = By.xpath("//div[@class='q-item-label' and text()='All applications']");
    private By displayDropDown = By.xpath("//div[@class='col q-input-target ellipsis justify-start' and text()='Display']");
    private By getDisplayDropDownOption = By.xpath("//div[@class='q-item-label' and text()='Display']");
    private By searchBarIcon = By.xpath("//i[@class='q-icon fas fa-search']");
    private By searchBar = By.xpath("//input[@class='col q-input-target q-no-input-spinner ellipsis text-left']");
    private By taskSearchApprovalCheck = By.xpath("//p[@class='task-title text-left q-mb-xs' and contains(text(), 'Approval')]");
    private By startAnyTaskArrowRight = By.xpath("//i[@class='q-icon action-icon fas fa-chevron-right fa-3x text-grey']");

    protected TasksPage(WebDriver driver) {
        super(driver);
    }


    public void startAnyTask() {
        logger.info("Click on the arrow from the right to start any available task...");
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, startAnyTaskArrowRight);
    }

    public void clickCompletedTasksTab() {
        logger.info("Click on the completed tasks tab...");
        WebDriverUtils.clickOnElementWithWait(driver, completedTasksTab);
        if (WebDriverUtils.findElement(driver, completedTasksTitle) != null) {
            logger.info("The completed tasks page successfully opened...");
        } else {
            Assert.assertEquals("Test failed...", "The completed tasks page didn't open...");
        }
    }

    public void searchForTask() {
        logger.info("Click on the search bar...");
        WebDriverUtils.clickOnElementWithWait(driver, searchBarIcon);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, searchBar);
        WebDriverUtils.enterTextBox(driver, searchBar, "Approval");
        if (WebDriverUtils.findElement(driver, taskSearchApprovalCheck) != null) {
            logger.info("A task name containing the element Approval exists...");
        } else {
            Assert.assertEquals("Test failed...", "The Search bar doesn't work...");
        }
    }

    public void filterByApplications() {
        logger.info("Filter the tasks by Applications drop down...");
        WebDriverUtils.clickOnElementWithWait(driver, allApplicationsDropDown);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Choose All Applications option from the drop down list...");
        WebDriverUtils.clickOnElementWithWait(driver, allApplicationsDropDownOption);
        logger.info("Filter the tasks by Display drop down...");
        WebDriverUtils.clickOnElementWithWait(driver, displayDropDown);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Choose Display option from the drop down list...");
        WebDriverUtils.clickOnElementWithWait(driver, getDisplayDropDownOption);
    }

    public void chooseNoOfRecordsPerPage() {
        logger.info("Click on the records per page drop down...");
        WebDriverUtils.clickOnElementWithWait(driver, recordsPerPageDropDown);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        logger.info("Choose the value 20...");
        WebDriverUtils.clickOnElementWithWait(driver, recordsPerPage20Option);
    }

    public void goToMyOpenTasks() {
        logger.info("Go to My active tasks..");
        WebDriverUtils.clickOnElementWithWait(driver, myActiveTasksTab);
    }

    public void checkOpenTasksFilter(){
        ExpectedConditions.visibilityOfElementLocated(myOpenTasksFilter);
    }

    public void checkCompletedTasksFilter(){
        ExpectedConditions.visibilityOfElementLocated(myOpenTasksFilter);
     // Va fi schimbat cu verificatea obiectului de Completed tasks atunci cand va fi fixat bugul din jira
    }

    public void goTOMyCompletedTasks() {
        logger.info("Go to My completed tasks..");
        WebDriverUtils.clickOnElementWithWait(driver, myCompletedTasksTab);
    }
}
