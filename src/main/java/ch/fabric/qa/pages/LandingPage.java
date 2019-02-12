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
    private By profileIcon = By.xpath("//div[@class='at-main-user-profile']");
    private By logoutButton = By.xpath("//div[text()='Logout']");
    private By myAccountButton = By.xpath("//button[@class='q-btn inline relative-position q-btn-item non-selectable col btn-rect q-btn-rectangle q-btn-flat q-focusable q-hoverable']//div[text()='My account']");
    private By changeInformationButton = By.xpath("//div[contains(text(), 'Change information')]");
    private By notification1 = By.xpath("//span[text()='Notify me each time I am assigned a task']");
    private By notification2 = By.xpath("//span[text()='Notify me each time a task is assigned to a role I am in']");
    private By notification3 = By.xpath("//span[text()='Notify me each time an application I own is run']");
    private By notification4 = By.xpath("//span[text()='Notify me each time a diagram I worked on is modified']");
    private By notification5 = By.xpath("//span[text()='Notify me each time an interface is added']");
    private By notification6 = By.xpath("//span[text()='Notify me each time an interface I have worked on is modified']");
    private By notification7 = By.xpath("//span[contains(text(), 'Via email at')]");
    private By notification8 = By.xpath("//span[contains(text(), 'Via SMS at')]");
    private By notification9 = By.xpath("//span[text()='Regular in-app notifications']");

    protected LandingPage(WebDriver driver) {
        super(driver);
    }

    public void checkRole() {
        logger.info("Checking the user role...");
    }

    public void changeNotificationSettings() {
        logger.info("Click on the profile icon...");
        WebDriverUtils.clickOnElementWithWait(driver, profileIcon);
        logger.info("Click on the My Account button...");
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_500_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, myAccountButton);
        logger.info("Change Notify me each time I am assigned a task ...");
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_500_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, notification1);
        logger.info("Change Notify me each time a task is assigned to a role I am in...");
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_500_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, notification2);
        logger.info("Change Notify me each time an application I own is run...");
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_500_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, notification3);
        logger.info("Change Notify me each time a diagram I worked on is modified...");
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_500_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, notification4);
        logger.info("Change Notify me each time an interface is added...");
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_500_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, notification5);
        logger.info("Change Notify me each time an interface I have worked on is modified...");
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_500_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, notification6);
        logger.info("Change Via email at undefined...");
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_500_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, notification7);
        logger.info("Change Via SMS at undefined...");
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_500_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, notification8);
        logger.info("Change Regular in-app notifications...");
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_500_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, notification9);
    }

    public void changeUserInformation() {
        logger.info("Click on the profile icon...");
        WebDriverUtils.clickOnElementWithWait(driver, profileIcon);
        logger.info("Click on the My Account button...");
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_500_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, myAccountButton);
        logger.info("Click on the Change information button...");
        WebDriverUtils.clickOnElementWithWait(driver, changeInformationButton);
    }

    public void userLogOut () {
        logger.info("Click on the profile icon...");
        WebDriverUtils.clickOnElementWithWait(driver, profileIcon);
        logger.info("Click on hte logout button...");
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_500_MILLISECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, logoutButton);
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
