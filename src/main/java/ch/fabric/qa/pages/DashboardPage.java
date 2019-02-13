package ch.fabric.qa.pages;

import ch.fabric.qa.utils.WebDriverUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

/**
 * Contains locators, methods specific to Dashboard page
 *
 * @author aila.bogasieru@agys.ch
 */

@Slf4j
public class DashboardPage extends BasePage  {


    private By allApplicationsFilter = By.xpath("//div[@data-v-9e227040 and @data-v-66f97ef2]//div[text()='All applications']");
    private By monthsFilter = By.xpath("//div[@data-v-9e227040 and @data-v-66f97ef2]//div[text()='3 Months']");
    private By applicationsTable = By.xpath("//div[@class='col-12 bg-white shadow]");
    private By clickAnyApplicationTasksButton = By.xpath("//div[@class='q-btn-inner row col items-center justify-center']//div[contains(text(), 'Tasks')]");
    private By clickOnPageArrowRight = By.xpath("//i[text()='keyboard_arrow_right']");
    private By appSearchLauraCheck = By.xpath("//div[@class='q-list']");
    private By applicationsSearchBar = By.xpath("//input[@placeholder='Search']");
    private By expandTaskGreenArrowDown = By.xpath("//i[@class='q-icon task-icon fas fa-angle-double-down fa-2x']");
    private By taskExplorerAllAppsDropDown = By.xpath("//div[@data-v-417e1642]//div[text()='All applications']");
    private By taskExplorerAllAppsOption = By.xpath("//div[@class='q-item-label' and text()='All applications']");
    private By taskExplorerDisplayDropDown = By.xpath("//div[@class='col q-input-target ellipsis justify-start' and text()='Display']");
    private By taskExplorerDisplayOption = By.xpath("//div[@class='q-item-label' and text()='Display']");
    private By taskOverviewAllAppsDropDown = By.xpath("//div[@data-v-604d8d9d]//div[text()='All applications']");
    private By taskOverviewAllAppsOption = By.xpath("//div[@class='q-item-label' and text()='All applications']");
    private By taskOverviewTimeDropDown = By.xpath("//div[@data-v-604d8d9d]//div[text()='3 Months']");
    private By taskOverviewTime3Months = By.xpath("//div[@class='q-item-label' and text()='3 Months']");
    private By taskPriorityAllAppsDropDown = By.xpath("//div[@data-v-9e227040]//div[text()='All applications']");
    private By taskPriorityAllAppsOption = By.xpath("//div[@class='q-item-label' and text()='All applications']");
    private By taskPriorityTimeDropDown = By.xpath("//div[@data-v-9e227040]//div[text()='3 Months']");
    private By taskPriorityTime3MOnths = By.xpath("//div[@class='q-item-label' and text()='3 Months']");

    protected DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void clickExpandTaskGreenArrow() {
        log.info("Click on the green arrow from a task...");
        WebDriverUtils.clickOnElementWithWait(driver, expandTaskGreenArrowDown);
    }

    public void filterTaskPriorityGraph() {
        log.info("Filter the Task Priority graphic - all applications...");
        WebDriverUtils.clickOnElementWithWait(driver, taskPriorityAllAppsDropDown);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        log.info("Select All Applications from the list...");
        WebDriverUtils.clickOnElementWithWait(driver, taskPriorityAllAppsOption);
        log.info("Filter the Task Priority graphic - time...");
        WebDriverUtils.clickOnElementWithWait(driver, taskPriorityTimeDropDown);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        log.info("Select 3 months from the list...");
        WebDriverUtils.clickOnElementWithWait(driver, taskPriorityTime3MOnths);
    }

    public void filterTaskOverviewGraph() {
        log.info("Filter the Task Overview graphic - all applications...");
        WebDriverUtils.clickOnElementWithWait(driver, taskOverviewAllAppsDropDown);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        log.info("Select All Applications from the list...");
        WebDriverUtils.clickOnElementWithWait(driver, taskOverviewAllAppsOption);
        log.info("Filter the Task Overview graphic - time...");
        WebDriverUtils.clickOnElementWithWait(driver, taskOverviewTimeDropDown);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        log.info("Select 3 months from the list...");
        WebDriverUtils.clickOnElementWithWait(driver, taskOverviewTime3Months);
    }

    public void filterTaskExplorerSection() {
        log.info("Filter the Task Explorer section - all applications...");
        WebDriverUtils.clickOnElementWithWait(driver, taskExplorerAllAppsDropDown);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        log.info("Select All Applications from the list...");
        WebDriverUtils.clickOnElementWithWait(driver, taskExplorerAllAppsOption);
        log.info("Filter the Task Explorer section - display...");
        WebDriverUtils.clickOnElementWithWait(driver, taskExplorerDisplayDropDown);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        log.info("Select Display from the list...");
        WebDriverUtils.clickOnElementWithWait(driver, taskExplorerDisplayOption);
    }

    public void applicationSearchBar(){
        log.info("Click on the applications - search bar...");
        WebDriverUtils.clickOnElementWithWait(driver, applicationsSearchBar);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        log.info("Enter text in search bar...");
        WebDriverUtils.enterTextBox(driver, applicationsSearchBar, "Laura");
        log.info("Checking if the search worked by searching for any app containing the name Laura...");
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_2000_MILLISECONDS);
        if (WebDriverUtils.findElement(driver, appSearchLauraCheck) != null) {
            log.info("An app name containing the element Laura exists...");
        } else {
            Assert.assertEquals("Test failed...", "The Search bar doesn't work...");
        }
    }

    public void applicationsSectionChangePage() {
        log.info("Changing the pages inside the Applications section...");
        WebDriverUtils.clickOnElementWithWait(driver, clickOnPageArrowRight);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        if (WebDriverUtils.findElement(driver, appSearchLauraCheck) != null) {
            log.info("The change page arrow is working as expected...");
        } else {
            Assert.assertEquals("The arrow doesn't work...", "Or there are no apps on the next page...");
        }

    }

    public void clickOnTaskButtonAnyApp() {
        log.info("Click on the Task button of any available app...");
        WebDriverUtils.clickOnElementWithWait(driver, clickAnyApplicationTasksButton);
    }

    public void showApplications() {
        log.info("Displaying all the applications..");
        WebDriverUtils.clickOnElementWithWait(driver, allApplicationsFilter);
    }

    public void showMonths() {
        log.info("Displaying all the months..");
        WebDriverUtils.clickOnElementWithWait(driver, monthsFilter);
    }
}
