package ch.fabric.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.fabric.qa.utils.WebDriverUtils;

/**
 * Contains locators, methods specific to Landing page
 *
 * @author aila.bogasieru@agys.ch
 */

public class LandingPage extends BasePage {

    protected static final Logger logger = LoggerFactory.getLogger(LandingPage.class);

    private By landingIcon = By.xpath("//button//i[@class='q-icon fas fa-th']");
    private By appsElement = By.xpath("//a//div[text()='Apps']");
    private By applicationSettingsElement = By.xpath("//a//div[text()='Application Settings']");
    private By tasksElement = By.xpath("//div/div[text()='Tasks']/preceding-sibling::i");
    private By workspaceElement = By.xpath("//div[contains(text(),'Workspace')]");
    private By dashboardElement = By.xpath("//button//div[text()='Dashboard']");
    private By taskExplorerText = By.xpath("//div[text()='Task explorer']");
    private By applicationsText = By.xpath("//p[text()='Applications']");
    private By applicationSettingsText = By.xpath("//span[text()='Application Settings']");
    private By activeTasks = By.xpath("//div//div[text()='My active tasks']");
    private By completedTasks = By.xpath("//div//div[text()='My completed tasks']");


    protected LandingPage(WebDriver driver) {
        super(driver);
    }

    public void clickApps() {
        logger.info("Click on Apps button..");
        WebDriverUtils.clickOnElementWithWait(driver, appsElement);
    }

    public void clickMenus() {
        logger.info("Go to Menus..");
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_2000_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, landingIcon);
    }

    public void checkDasboardElements() {
        if (WebDriverUtils.findElement(driver, landingIcon) != null) {
            WebDriverUtils.clickOnElementWithWait(driver, landingIcon);
            WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_500_MILLISECONDS);
            if (WebDriverUtils.findElement(driver, workspaceElement) != null) {
                WebDriverUtils.clickOnElementWithWait(driver, workspaceElement);
                logger.info("Workspace element can be accessed");
            } else {
                logger.info("Workspace element is not displayed");
            }
            if (WebDriverUtils.findElement(driver, dashboardElement) != null) {
                WebDriverUtils.checkIfElementExists(driver, dashboardElement, 10);
                WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_500_MILLISECONDS);
                logger.info("Dashboard element can be accessed");
            } else {
                logger.info("Dashboard element is not displayed");
            }
            if (WebDriverUtils.findElement(driver, appsElement) != null) {
                WebDriverUtils.checkIfElementExists(driver, applicationSettingsElement, 10);
                logger.info("Apps element can be accessed");
            } else {
                logger.info("Apps element is not displayed");
            }
            if (WebDriverUtils.findElement(driver, applicationSettingsElement) != null) {
                WebDriverUtils.checkIfElementExists(driver, applicationSettingsElement, 10);
                logger.info("Application Settings element can be accessed");
            } else {
                logger.info("Application Settings element is not displayed");
            }
            if (WebDriverUtils.findElement(driver, tasksElement) != null) {
                WebDriverUtils.checkIfElementExists(driver, applicationSettingsElement, 10);
                logger.info("Tasks Element can be accessed");
            } else {
                logger.info("Tasks Elements Element is not displayed");
            }
        } else {
            logger.info("Elements were not found");
        }
    }

    public WorkspacePage returnWorkspacePage() {
        WebDriverUtils.clickOnElementWithWait(driver, landingIcon);
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(workspaceElement));
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(dashboardElement));
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(appsElement));
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(applicationSettingsElement));
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(tasksElement));
        return new WorkspacePage(driver);
    }

    public DashboardPage returnDashboardPage() {
        WebDriverUtils.clickOnElementWithWait(driver,landingIcon);
        WebDriverUtils.clickOnElementWithWait(driver, dashboardElement);
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.visibilityOfElementLocated(taskExplorerText));
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.visibilityOfElementLocated(applicationsText));
        return new DashboardPage(driver);
    }

    public AppsPage returnAppsPage() {
        WebDriverUtils.clickOnElementWithWait(driver, appsElement);
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(applicationsText));
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_1000_MILLISECONDS);
        return new AppsPage(driver);
    }

    public ApplicationSettingsPage returnApplicationSettingsPage() {
        WebDriverUtils.clickOnElementWithWait(driver, applicationSettingsElement);
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(applicationSettingsText));
        return new ApplicationSettingsPage(driver);
    }

    public TasksPage returnTasksPage() {
        WebDriverUtils.clickOnElementWithWait(driver, tasksElement);
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(applicationSettingsText));
        return new TasksPage(driver);
    }
}
