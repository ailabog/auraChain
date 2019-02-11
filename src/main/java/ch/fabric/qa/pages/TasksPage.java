package ch.fabric.qa.pages;

import ch.fabric.qa.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.By;

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

    protected TasksPage(WebDriver driver) {
        super(driver);
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
