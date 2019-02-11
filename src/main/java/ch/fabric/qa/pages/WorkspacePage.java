package ch.fabric.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.fabric.qa.utils.WebDriverUtils;

/**
 * Contains locators, methods specific to Workspace page
 *
 * @author aila.bogasieru@agys.ch
 */

public class WorkspacePage extends BasePage {

    protected static final Logger logger = LoggerFactory.getLogger(WorkspacePage.class);

    private By hideIconWorkspace = By.xpath("/html/body/div[4]/div[2]/div/div[1]/div/button");
    private By workspaceElement = By.xpath("/html/body/div[4]/div[2]/div/div[1]/div/div");
    private By dashboardIcon = By.xpath("//button[@type='button']");
    private By dashboardElement = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/button/div[2]/div");
    private By appsElement = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[1]/a/div[2]/div");
    private By applicationSettingsElement = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/a/div[2]/div");
    private By tasksElement = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/a/div[2]/div");
    private By adminSpan = By.xpath("//span[text(), 'Admin']");
    private By usersAndRoles = By.xpath("//*contains[text(), Users and Roles']");
    private By rolesLink = By.xpath("//a[text()='Roles']");
    private By manageAppsLink = By.xpath("//a[text()='Manage Apps']");
    private By manageDocumentsLink = By.xpath("//a[text()='Manage Documents']");
    private By manageUIsLink = By.xpath("//a[text()='Manage UI's']");
    private By componentsFromMarketPlaceLink = By.xpath("//a[text()='Components from Marketplace']");
    private By settingsLink = By.xpath("//a[text()='Settings']");

    private By applicationSpan = By.xpath("//span[text()='Applications']");
    private By createNewButtonLink = By.xpath("/html/body/div[1]/div[2]/main/div/div[1]/div/div[2]/div[1]/button");
    private By yourApplicationLink = By.xpath("//div[text()='Your applications']");
    private By sharedWithYouLink = By.xpath("//div[text()='Shared with you']");
    private By archievedApplication = By.xpath("//div[text()='Archived applications']");

    protected WorkspacePage(WebDriver driver) {
        super(driver);
    }

    public void hideWorkspace() {
        if (WebDriverUtils.findElement(driver, workspaceElement) != null) {
            WebDriverUtils.clickOnElementWithWait(driver, hideIconWorkspace);
        } else {
            logger.info("Element Workspace was not found");
        }
    }

    public DashboardPage returnDashboardPage() {
        WebDriverUtils.clickOnElementWithWait(driver, dashboardElement);
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(dashboardIcon));
        return new DashboardPage(driver);
    }

    public AppsPage returnAppsPage() {
        WebDriverUtils.clickOnElementWithWait(driver, appsElement);
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(applicationSpan));
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(createNewButtonLink));
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(yourApplicationLink));
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(sharedWithYouLink));
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(archievedApplication));
        return new AppsPage(driver);
    }

    public ApplicationSettingsPage returnApplicationSettingsPage() {
        WebDriverUtils.clickOnElementWithWait(driver, applicationSettingsElement);
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(usersAndRoles));
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(adminSpan));
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(rolesLink));
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(manageAppsLink));
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(manageDocumentsLink));
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(manageUIsLink));
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(componentsFromMarketPlaceLink));
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(settingsLink));
        return new ApplicationSettingsPage(driver);
    }

    public TasksPage returnePage() {
        WebDriverUtils.clickOnElementWithWait(driver, tasksElement);
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(dashboardIcon));
        return new TasksPage(driver);
    }
}
