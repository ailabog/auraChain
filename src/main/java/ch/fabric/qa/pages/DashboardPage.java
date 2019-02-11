package ch.fabric.qa.pages;

import ch.fabric.qa.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Contains locators, methods specific to Dashboard page
 *
 * @author aila.bogasieru@agys.ch
 */

public class DashboardPage extends BasePage  {

    protected static final Logger logger = LoggerFactory.getLogger(DashboardPage.class);

    private By allApplicationsFilter = By.xpath("//div[@data-v-9e227040 and @data-v-66f97ef2]//div[text()='All applications']");
    private By monthsFilter = By.xpath("//div[@data-v-9e227040 and @data-v-66f97ef2]//div[text()='3 Months']");
    private By applicationsTable = By.xpath("//div[@class='col-12 bg-white shadow]");

    protected DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void showApplications() {
        logger.info("Displaying all the applications..");
        WebDriverUtils.clickOnElementWithWait(driver, allApplicationsFilter);
    }

    public void showMonths() {
        logger.info("Displaying all the months..");
        WebDriverUtils.clickOnElementWithWait(driver, monthsFilter);
    }
}
